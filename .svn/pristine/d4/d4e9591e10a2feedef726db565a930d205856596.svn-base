package com.soholy.dogmanager.service.fence.impl;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Point;
import com.soholy.dogmanager.entity.TFence;
import com.soholy.dogmanager.entity.TFenceCoordinate;
import com.soholy.dogmanager.entity.TFenceCoordinateExample;
import com.soholy.dogmanager.mapper.TFenceCoordinateMapper;
import com.soholy.dogmanager.mapper.TFenceMapper;
import com.soholy.dogmanager.mapper.TUsersMapper;
import com.soholy.dogmanager.pojo.fence.FenceRefCoordinate;
import com.soholy.dogmanager.service.fence.FenceService;
import com.soholy.dogmanager.utils.fence.FenceUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FenceServiceImpl implements FenceService {

    private static Logger logger = LoggerFactory.getLogger(FenceServiceImpl.class);

    @Autowired
    private TFenceMapper fenceMapper;

    @Autowired
    private TUsersMapper tUsersMapper;

    @Autowired
    private TFenceCoordinateMapper fenceCoordinateMapper;

    @Value("${Maximum_time}")
    private String Maximum_time;

    @Value("${Maximum_distance}")
    private String Maximum_distance;

    @Value("${Fence_distance}")
    private String Fence_distance;

    @Autowired
    private TFenceCoordinateMapper tFenceCoordinateMapper;

    @Override
    public DogResult addCoordinate(List<TFenceCoordinate> coordinates) throws Exception {
        try {
            fenceCoordinateMapper.insertBatch(coordinates);
            return DogResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return DogResult.build(400, "添加失败！！");
        }
    }

    /**
     * 添加围栏时，同步添加围栏坐标
     */
    @Override
    public DogResult addFence(TFence fence, List<TFenceCoordinate> coordinates, Long newFenceId) {
        try {
            //判断围栏id是否存在，若存在，则修改fence
            if (fence.getFenceId() != null) {
                //若存在，则先删除原来围栏坐标，重新关联新坐标
                fenceCoordinateMapper.deleteByFenceId(fence.getFenceId());
                for (int i = 0; i < coordinates.size(); i++) {
                    TFenceCoordinate tFenceCoordinate = coordinates.get(i);
                    tFenceCoordinate.setFenceId(fence.getFenceId());
                    tFenceCoordinate.setSeq(i + 1);
                    tFenceCoordinate.setDistrictId(tFenceCoordinate.getDistrictId());
                    tFenceCoordinate.setCreationTime(new Date());
                }
                // 添加围栏坐标
                DogResult result = this.addCoordinate(coordinates);
                return result;
            }
            fence.setStartTime(new Date());
            fence.setCreationTime(new Date());
            // 添加围栏
            fenceMapper.insertSelective(fence);
            // 添加围栏坐标
            FenceRefCoordinate frc = new FenceRefCoordinate();
            frc.setCreationTime(fence.getCreationTime());
            frc.setFenceId(fence.getFenceId());
            frc.setFenceName(fence.getFenceName());
            frc.setFenceType(fence.getFenceType());
            frc.setOperatorId(fence.getOperatorId());
            frc.setStartTime(fence.getStartTime());
            frc.setStatus(fence.getStatus());
            frc.setNewFenceId(newFenceId);

            coordinates.forEach(x -> {
                x.setFenceId(fence.getFenceId());
                x.setCreationTime(Calendar.getInstance().getTime());
            });
            this.addCoordinate(coordinates);
            frc.setCoordinates(coordinates);
            DogResult result = DogResult.ok(frc);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            return DogResult.build(400, "添加失败！！");
        }
    }

    /**
     * 删除围栏时，同步删除围栏坐标
     */
    @Override
    public DogResult deleteFenceById(Long fenceId) {
        try {
            // 删除围栏
            fenceMapper.deleteByPrimaryKey(fenceId);
            // 删除围栏坐标
            fenceCoordinateMapper.deleteByFenceId(fenceId);
            //this.deleteCoordinateByFenceId(fenceId);
            return DogResult.ok();
        } catch (Exception e) {
            logger.info(e.getMessage());
            return DogResult.build(400, "删除失败！！");
        }
    }

    /**
     * 批量删除，
     */
    @Override
    public DogResult deleteCoordinateByFenceId(Long fenceId) throws Exception {
        try {
            List<TFenceCoordinate> list = this.selectCoordinatesByFenceId(fenceId);
            DogResult dogResult = this.deleteCoordinates(list);
            return dogResult;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return DogResult.build(400, "删除失败");
        }
    }

    @Override
    public DogResult deleteCoordinates(List<TFenceCoordinate> coordinates) throws Exception {
        try {
            fenceCoordinateMapper.deleteBatch(coordinates);
            return DogResult.ok();
        } catch (Exception e) {
            logger.info(e.getMessage());
            return DogResult.build(400, "删除失败");
        }
    }

    @Override
    public List<TFenceCoordinate> selectCoordinatesByFenceId(Long fenceId) throws Exception {
        try {
            List<TFenceCoordinate> list = fenceCoordinateMapper.selectCoordinatesByFenceId(fenceId);
            return list;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TFence> selectFences() throws Exception {
        return this.selectFences(null);
    }

    @Override
    public List<TFence> selectFences(Long operatorId) throws Exception {
        List<TFence> fences = fenceMapper.selectFences(operatorId);
        return fences;
    }

    @SuppressWarnings("null")
    @Override
    public List<FenceRefCoordinate> selectFenceRefCoordinate(Long operatorId,Long fenceId) throws Exception {
        List<FenceRefCoordinate> fenceRefCoordinatesList = new ArrayList<>();

        List<TFence> fences = this.selectFences(operatorId);


        // 获取每个围栏的具体坐标
        for (TFence fence : fences) {
            if(fenceId != null){
                if(fence.getFenceId() != fenceId)
                    continue;
            }
            FenceRefCoordinate fenceRefCoordinate = new FenceRefCoordinate();
            fenceRefCoordinate.settUsers(tUsersMapper.selectByPrimaryKey(operatorId));
            // 将fence值复制给fenceRefCoordinate
            PropertyUtils.copyProperties(fenceRefCoordinate, fence);
            List<TFenceCoordinate> fenceCoordinates = this.selectCoordinatesByFenceId(fence.getFenceId());
            fenceRefCoordinate.setCoordinates(fenceCoordinates);
            // 将围栏坐标添加到fenceRefCoordinate中
            fenceRefCoordinatesList.add(fenceRefCoordinate);
        }
        return fenceRefCoordinatesList;
    }

    @Override
    public FenceRefCoordinate isPtInPoly(Double ALon, Double ALat) throws Exception {
        try {
            // 获取所有围栏
            List<FenceRefCoordinate> fenceDetails = this.findDetailByids(null);
//            List<TFence> fences = this.selectFences();
//            for (TFence fence : fences) {
            for (FenceRefCoordinate fence : fenceDetails) {
                // 获取每个围栏的所有坐标点
//                List<TFenceCoordinate> coordinates = this.selectCoordinatesByFenceId(fence.getFenceId());
                // 创建围栏坐标点集合
                List<Point> points = new ArrayList<>();
                for (TFenceCoordinate coordinate : fence.getCoordinates()) {
                    Point point = new Point();
                    // doubleValue 将BigDecimal转化为double
                    point.setLongitude(coordinate.getLongitude().doubleValue());
                    point.setLatitude(coordinate.getLatitude().doubleValue());
                    points.add(point);
                }
                if (points.size() < 3) {
                    return null;
                }
                int iSum, iCount, iIndex;
                double dLon1 = 0, dLon2 = 0, dLat1 = 0, dLat2 = 0, dLon;
                iSum = 0; // 交点个数
                iCount = points.size(); // 顶点个数
                for (iIndex = 0; iIndex < iCount; iIndex++) {
                    // 如果当前坐标是最后一个坐标，则与第一个点组成两点连线
                    if (iIndex == points.size() - 1) {
                        // 坐标一
                        dLon1 = points.get(iIndex).getLongitude();
                        dLat1 = points.get(iIndex).getLatitude();
                        // 坐标二
                        dLon2 = points.get(0).getLongitude();
                        dLat2 = points.get(0).getLatitude();
                    } else {
                        // 坐标一
                        dLon1 = points.get(iIndex).getLongitude();
                        dLat1 = points.get(iIndex).getLatitude();
                        // 坐标二
                        dLon2 = points.get(iIndex + 1).getLongitude();
                        dLat2 = points.get(iIndex + 1).getLatitude();
                    }
                    // 以下语句判断A点是否在边的两端点的水平平行线之间，在则可能有交点，开始判断交点是否在左射线上
                    if (((ALat >= dLat1) && (ALat < dLat2)) || ((ALat >= dLat2) && (ALat < dLat1))) {
                        if (Math.abs(dLat1 - dLat2) > 0) {
                            // 得到 A点向左射线与边的交点的x坐标：
                            dLon = dLon1 - ((dLon1 - dLon2) * (dLat1 - ALat)) / (dLat1 - dLat2);
                            //判断坐标点与交点之间的距离
//                            double distance = FenceUtils.GetDistance(ALat, dLon, ALat, ALon);
                            // 如果交点在A点左侧且两点之间距离大于x米（说明是做射线与 边的交点），则射线与边的全部交点数加一：
//                            if (dLon < ALon && distance >= Double.parseDouble(Fence_distance)) {
                            if (dLon < ALon ) {
                                iSum++;
                            }
                        }
                    }
                    // 如果交点个数为奇数，则在区域范围类
                    if ((iSum % 2) != 0) {
                        return fence;
                    }
                }
            }
            // 如果交点个数为偶数，则不在该区域范围内
            return null;
        } catch (Exception e) {
            // 出现异常，返回null
            return null;
        }
    }

    @Override
    public boolean modifyById(long fenceId, List<TFenceCoordinate> tFenceCoordinates) {
        if (tFenceCoordinates != null && tFenceCoordinates.size() > 0) {
            TFenceCoordinateExample example = new TFenceCoordinateExample();
            example.createCriteria().andFenceIdEqualTo(fenceId);

            //查询围栏是否有修改
            List<TFenceCoordinate> temps = tFenceCoordinateMapper.selectByExample(example);
            long count = tFenceCoordinates.stream().filter(x -> {
                BigDecimal latitude = x.getLatitude();
                BigDecimal longitude = x.getLongitude();

                long collect = temps.stream()
                        .filter(y -> y.getLatitude().toBigInteger().equals(latitude.toBigInteger()) && y.getLongitude().toBigInteger().equals(longitude.toBigInteger()))
                        .count();
                return collect == 4;
            }).count();
            //围栏未有修改内容能够
            if (count == tFenceCoordinates.size()) {
                return false;
            }

            //删除已有围栏信息
            if (tFenceCoordinateMapper.deleteByExample(example) == tFenceCoordinates.size()) {
                Date now = Calendar.getInstance().getTime();
                AtomicInteger result = new AtomicInteger();
                tFenceCoordinates.stream().forEach(x -> {
                    x.setCreationTime(now);
                    x.setFenceId(fenceId);

                    //重新添加围栏
                    result.addAndGet(tFenceCoordinateMapper.insertSelective(x));
                });
                return result.get() == tFenceCoordinates.size();
            }

        }
        return false;
    }

    @Override
    public List<FenceRefCoordinate> findDetailByids(long[] fenceIds) {
        return tFenceCoordinateMapper.findDetailByids(fenceIds);
    }

}
