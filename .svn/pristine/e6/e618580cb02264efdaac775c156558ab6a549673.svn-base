package com.soholy.dogmanager.service.violation;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.pojo.Page;
import com.soholy.dogmanager.entity.TBanDog;
import com.soholy.dogmanager.entity.TBanDogRefDict;

import java.util.List;

/**
 * 项目名称：generatorSqlmapCustom
 * 类名称：BlankService
 * 类描述： 禁养犬种
 * 创建人：YL
 * 创建时间：2018年8月23日 下午2:55:19
 * 修改人：Administrator
 * 修改时间：2018年8月23日 下午2:55:19
 * 修改备注：
 */
public interface BanService {

    DogResult update(TBanDog tBanDog);

    DogResult removeBatch(List<Long> blackIdList);

    Page<TBanDogRefDict> findAll(int pn, int pageSize, String string);

    //根据姓名是否存在
    boolean checkBlackList(String string);

    DogResult save(String banName, String remrks);
}
