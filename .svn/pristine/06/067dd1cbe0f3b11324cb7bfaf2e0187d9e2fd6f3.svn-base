package com.soholy.dogmanager.service.common.impl;

import com.soholy.dogmanager.service.common.TdictionaryService;
import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.mapper.TDictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TdictionaryServiceImpl  implements TdictionaryService {

    @Autowired
    private TDictionaryMapper tDictionaryMapper;

    @Override
    public List<TDictionary> getTdictionarys(String dictionaryField) {
        return tDictionaryMapper.findBizTypes(dictionaryField);
    }
}
