package com.soholy.dogmanager.mapper;

import java.util.List;

import com.soholy.dogmanager.entity.notice.InforMationDetail;
import org.apache.ibatis.annotations.Param;

import com.soholy.dogmanager.entity.TInformation;
import com.soholy.dogmanager.entity.TInformationExample;

public interface TInformationMapper {
    int countByExample(TInformationExample example);

    int deleteByExample(TInformationExample example);

    int deleteByPrimaryKey(Long informationId);

    int insert(TInformation record);

    List<TInformation> selectByExampleWithBLOBs(TInformationExample example);

    List<TInformation> selectByExample(TInformationExample example);

    TInformation selectByPrimaryKey(Long informationId);

    int updateByExampleSelective(@Param("record") TInformation record, @Param("example") TInformationExample example);

    int updateByExampleWithBLOBs(@Param("record") TInformation record, @Param("example") TInformationExample example);

    int updateByExample(@Param("record") TInformation record, @Param("example") TInformationExample example);

    int updateByPrimaryKeyWithBLOBs(TInformation record);

    int updateByPrimaryKey(TInformation record);
    
    //添加资讯信息
    Long addInformation(TInformation information);
    
    //更新浏览次数+1
    int updateInformationCount(Long informationId);
    
    //修改编辑资讯
    int updateInformation(TInformation information);
    
    //删除资讯信息
    int deleteInformation(Long informationId);
    
    //查看资讯
    TInformation selectInformation(Long informationId);
    
    //更新热度
    int updatehot(Long informationId);
    
    //查询资讯列表(分页)
    List<TInformation> selectInformations(@Param("TypeNumber") Integer TypeNumber, @Param("status") Integer status, @Param("query") String query, @Param("mark")Integer mark);
    
    //审核通过
    int updateInformationForYes(Long informationId);
	
    //审核不通过(添加失败原因)
    int updateInformationForNo(@Param("informationId")Long informationId, @Param("failReason")String failReason);

    /**
     * 查询资讯详情
     * @param informationId
     */
    InforMationDetail findInforMationDetailById(Long informationId);


    /**
     *查资讯列表
     * @param type       资讯类型
     *                   0政策法规
     *                   1动态资讯
     *                   2养犬宣传
     *                   3服务指南
     * @param searchkey titile搜索
     * @param mark 0审核中，1上架，2下架
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<InforMationDetail> findList(@Param("type")Integer type,
                                     @Param("searchkey")String searchkey,
                                     @Param("mark")Integer mark,
                                     @Param("pageNum")Integer pageNum,
                                     @Param("pageSize")Integer pageSize);

    /**
     * 查总条数
     * @return
     * @param type
     * @param searchkey
     * @param mark
     */
    int findListTotalCount(@Param("type")Integer type, @Param("searchkey")String searchkey, @Param("mark")Integer mark);
}