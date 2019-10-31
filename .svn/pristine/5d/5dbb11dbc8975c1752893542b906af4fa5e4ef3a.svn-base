package com.soholy.dogmanager.mapper;

import com.soholy.dogmanager.entity.TDogOwner;
import com.soholy.dogmanager.entity.TDogOwnerExample;
import com.soholy.dogmanager.entity.dogCard.DogOwners;
import com.soholy.dogmanager.pojo.statistic.DogOwnerDTO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TDogOwnerMapper {
    int countByExample(TDogOwnerExample example);

    int deleteByExample(TDogOwnerExample example);

    int deleteByPrimaryKey(Long dogOwnerId);

    int insert(TDogOwner record);

    int insertSelective(TDogOwner record);

    List<TDogOwner> selectByExample(TDogOwnerExample example);

    TDogOwner selectByPrimaryKey(Long dogOwnerId);

    int updateByExampleSelective(@Param("record") TDogOwner record, @Param("example") TDogOwnerExample example);

    int updateByExample(@Param("record") TDogOwner record, @Param("example") TDogOwnerExample example);

    int updateByPrimaryKeySelective(TDogOwner record);

    int updateByPrimaryKey(TDogOwner record);

    /**
     *  根据设备id查询犬主信息
     * @param deviceId
     * @return
     */
    TDogOwner findDogOwnerByDeviceId(Long deviceId);


    /**
     * 根据免疫证号查免疫证号
     * @param iminNum 免疫证号
     * @return
     */
    String selectIminNumBymin(@Param("iminNum") String iminNum);

    DogOwners selectDogOwnerByPhone(String phone);

    List<DogOwnerDTO> findDogOwnerList(HashMap<String,Object> map);
    int findDogOwnerListCount(HashMap<String,Object> map);

    DogOwnerDTO findDogOwnerById(Long dogOwnerId);


}