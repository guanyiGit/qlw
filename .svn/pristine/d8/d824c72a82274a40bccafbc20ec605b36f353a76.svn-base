package com.soholy.dogmanager.controller.dictionary;


import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.service.common.TdictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 字典表查询
 */
@RestController
@RequestMapping(value = "/biz/Tdictionary")
public class TdictionaryController {

    @Autowired
    private TdictionaryService tDictionaryService;

    /**
     * 查询字典表
     *
     * @param dictionaryField 字典类型
     * @return
     */
    @RequestMapping(value = "/{dictionaryField}")
    public String get(@PathVariable(value = "dictionaryField") String dictionaryField) {
        return new GlobalResult().successJSON(tDictionaryService.getTdictionarys(dictionaryField));
    }

}
