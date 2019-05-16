package com.soholy.dogmanager.controller.dictionaries;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.TDictionary;
import com.soholy.dogmanager.mapper.TDictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/biz/dictionary")
public class DictionaryController {
	
	@Autowired
	private TDictionaryMapper dictionaryMapper;
	
	@RequestMapping(value = "/OrgType")
	@ResponseBody
	public DogResult getOrgType(){
		try {
			List<TDictionary> selectOrgType = dictionaryMapper.selectOrgType(null);
			return DogResult.ok(selectOrgType);
		} catch (Exception e) {
			return DogResult.build(400, "获取类型出错");
		}
	}

	@RequestMapping("/findBizTypes")
	@ResponseBody
	public DogResult findBizTypes(String dictionaryField){
		try {
			List<TDictionary> selectOrgType = dictionaryMapper.findBizTypes(dictionaryField);
			return DogResult.ok(selectOrgType);
		} catch (Exception e) {
			return DogResult.build(400, "获取类型出错");
		}
	}
	
}
