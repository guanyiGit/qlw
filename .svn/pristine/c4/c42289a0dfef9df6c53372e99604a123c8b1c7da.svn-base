package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TAdoptionPublicity;
import com.soholy.dogmanager.entity.TAdoptionPublicityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAdoptionPublicityMapper {
    int countByExample(TAdoptionPublicityExample example);

    int deleteByExample(TAdoptionPublicityExample example);

    int deleteByPrimaryKey(Long adoptionPublicityId);

    int insert(TAdoptionPublicity record);

    int insertSelective(TAdoptionPublicity record);

    List<TAdoptionPublicity> selectByExample(TAdoptionPublicityExample example);

    TAdoptionPublicity selectByPrimaryKey(Long adoptionPublicityId);

    int updateByExampleSelective(@Param("record") TAdoptionPublicity record, @Param("example") TAdoptionPublicityExample example);

    int updateByExample(@Param("record") TAdoptionPublicity record, @Param("example") TAdoptionPublicityExample example);

    int updateByPrimaryKeySelective(TAdoptionPublicity record);

    int updateByPrimaryKey(TAdoptionPublicity record);
    
    void saveAdoptionPublicityBatch(List<TAdoptionPublicity> list);
}