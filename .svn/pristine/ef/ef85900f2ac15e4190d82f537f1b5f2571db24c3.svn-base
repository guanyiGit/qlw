package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TBanDog;
import com.soholy.dogmanager.entity.TBanDogExample;
import com.soholy.dogmanager.entity.TBanDogRefDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBanDogMapper {
    int countByExample(TBanDogExample example);

    int deleteByExample(TBanDogExample example);

    int deleteByPrimaryKey(Integer dogBanId);

    int insert(TBanDog record);

    int insertSelective(TBanDog record);

    List<TBanDog> selectByExample(TBanDogExample example);

    TBanDog selectByPrimaryKey(Integer dogBanId);

    int updateByExampleSelective(@Param("record") TBanDog record, @Param("example") TBanDogExample example);

    int updateByExample(@Param("record") TBanDog record, @Param("example") TBanDogExample example);

    int updateByPrimaryKeySelective(TBanDog record);

    int updateByPrimaryKey(TBanDog record);

    /**
     * 查列表
     *
     *
     * @param pn
     * @param pageSize
     * @param string
     * @return
     */
    List<TBanDogRefDict> findAll(@Param("pn") Integer pn, @Param("pageSize")Integer pageSize,@Param("string") String string);

    /**
     * 插入返回主键
     *
     * @param bandog
     * @return
     */
    int save(@Param("bandog") TBanDog bandog);

    /**
     * 查列表总数
     *
     *
     * @param pn
     * @param pageSize
     * @param string
     * @return
     */
    int findAllCount(@Param("pn") Integer pn, @Param("pageSize")Integer pageSize,@Param("string") String string);
}