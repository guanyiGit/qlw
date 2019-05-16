package com.soholy.dogmanager.service.common;

import com.soholy.dogmanager.entity.TDictionary;

import java.util.List;

public interface TdictionaryService {

    /**
     *  查询字典表
     * @param dictionaryField 字典类型
     * @return
     */
    List<TDictionary> getTdictionarys(String dictionaryField);
}
