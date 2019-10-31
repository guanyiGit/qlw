package com.soholy.dogmanager.service.violation.impl;

import com.github.pagehelper.PageHelper;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.*;
import com.soholy.dogmanager.mapper.TBanDogMapper;
import com.soholy.dogmanager.mapper.TDictionaryMapper;
import com.soholy.dogmanager.mapper.TImagesMapper;
import com.soholy.dogmanager.mapper.TImagesRefMapper;
import com.soholy.dogmanager.service.violation.BanService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 项目名称：dogmanager-violation
 * 类名称：BlackServiceImpl
 * 类描述： 禁养犬种service
 * 创建人：YL
 * 创建时间：2018年8月23日 下午3:10:06
 * 修改人：Administrator
 * 修改时间：2018年8月23日 下午3:10:06
 * 修改备注：
 */
@Service
public class BanServiceImpl implements BanService {

    private static Logger LOGGER = LoggerFactory.getLogger(BanServiceImpl.class);

    @Autowired
    private TBanDogMapper tBanDogMapper;

    @Autowired
    private TImagesMapper tImagesMapper;

    @Autowired
    private TImagesRefMapper tImagesRefMapper;

    @Autowired
    private TDictionaryMapper tDictionaryMapper;


    @Override
    public DogResult update(TBanDog tBanDog) {
        tBanDogMapper.updateByPrimaryKeySelective(tBanDog);
        return DogResult.ok();
    }

    @Override
    public Page<TBanDogRefDict> findAll(int pn, int pageSize, String string) {
        Page<TBanDogRefDict> page = new Page<>();
//        PageHelper.startPage(pn, pageSize);
        int totalCount = tBanDogMapper.findAllCount(pn, pageSize, string);
        List<TBanDogRefDict> list = null;
        if (totalCount > 0) {
            list = tBanDogMapper.findAll(pn, pageSize, string);
        }
        page.setLists(list);
        page.setPageNumber(pn);
        page.setPageSize(pageSize);
        page.setTotalRecord(totalCount);
        return page;
    }


    @Override
    public boolean checkBlackList(String string) {
        List<TBanDogRefDict> list = tBanDogMapper.findAll(null, null, string);
        return list != null && list.size() > 0 ? false : true;
    }

    @Override
    public DogResult save(String banName, String remrks) {
        TDictionaryExample example = new TDictionaryExample();
        example.createCriteria().andDictionaryDescribeEqualTo(banName.trim());
        List<TDictionary> tDictionaries = tDictionaryMapper.selectByExample(example);

        int dictionaryId = 0;

        //不存在 新增犬种信息
        if (tDictionaries == null || tDictionaries.size() == 0) {
            TDictionary diction = new TDictionary();
            diction.setCreationTime(Calendar.getInstance().getTime());
            diction.setDictionaryDescribe(banName);
            diction.setDictionaryField("dog_breed_type");
            //设置序号
            example = new TDictionaryExample();
            example.createCriteria().andDictionaryFieldEqualTo("dog_breed_type");
            example.setOrderByClause("dictionary_value asc");
            tDictionaries = tDictionaryMapper.selectByExample(example);
            diction.setDictionaryValue(tDictionaries.get(tDictionaries.size() - 1).getDictionaryValue() + 1);

            //插入返回主键
            tDictionaryMapper.save(diction);
            dictionaryId = diction.getDictionaryId();
        } else {//已存在
            dictionaryId = tDictionaries.get(0).getDictionaryId();
        }

        //插入
        TBanDog bandog = new TBanDog();
        bandog.setCreationTime(new Date());
        bandog.setDictionaryId(dictionaryId);
        if (StringUtils.isNotBlank(remrks)) {
            bandog.setNote(remrks);
        }
        int result = tBanDogMapper.save(bandog);
        return result > 0 ? DogResult.ok(bandog.getDogBanId()) : DogResult.build(400, "保存错误！");
    }

    @Override
    public DogResult removeBatch(List<Long> list) {
        //删除禁养犬种
        Optional<Integer> reduce = list.stream().map(x -> tBanDogMapper.deleteByPrimaryKey(x.intValue()))
                .reduce((x, y) -> x + y);

        //查询图片表id
        TImagesRefExample example = new TImagesRefExample();
        example.createCriteria().andRefIdIn(list);
        List<TImagesRef> tImagesRefs = tImagesRefMapper.selectByExample(example);
        List<Long> imgIds = tImagesRefs.stream()
                .map(x -> x.getImageId())
                .collect(Collectors.toList());

        //删除图片关联表
        tImagesRefMapper.deleteByExample(example);

        if (imgIds != null && imgIds.size() > 0) {
            //删除图片表
            TImagesExample examplei = new TImagesExample();
            examplei.createCriteria().andImageIdIn(imgIds);
            tImagesMapper.deleteByExample(examplei);

        }
        if (reduce.isPresent() && reduce.get() == list.size()) {
            return DogResult.ok();
        }
        return DogResult.build(400, "移除失败");
    }

}
