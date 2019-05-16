package com.soholy.dogmanager.common.utils;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.soholy.dogmanager.service.statistic.TVaccineService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


//@Component
//@EnableAsync
public class testTask {

	@Resource
	TVaccineService tVaccineService;
    
    //@Scheduled(cron = "* 0/3 * * * ?")
    public void test1(){
        System.out.println("test");
    }
    //通知下次免疫时间
    //@Scheduled(cron = "* 0/1 * * * ?")
    @Scheduled(cron = "* * 2 * * ?")//每天凌晨2点执行一次
    public void vaccineInjection() {
    	System.out.println("test。。。");
	  	List<Map> list=(List<Map>)tVaccineService.getInjectionTZ();
	  	List<Long>idList=new ArrayList<>();//得到的需要发送免疫记录id
	  	List<Map>drugList=new ArrayList<Map>();//得到通知集合
	  	for (int i = 0; i < list.size(); i++) {
	  		idList.add((Long)list.get(i).get("vaccine_injection_id"));
	  		String tz="犬主:"+list.get(i).get("dog_owner_name")
	  				+"你好,你的宠物狗:"+list.get(i).get("dog_name")
	  				+"下次免疫时间快到了,请您与"+list.get(i).get("next_injection_date")
	  				+"到宠物医院:"+list.get(i).get("organization_name")
	  				+"进行:"+list.get(i).get("vaccine_name")+"免疫注射。";
	  		Map<String, Object>map=new HashMap<String, Object>();
	  		map.put("notif_receiver_id", list.get(i).get("dog_owner_id"));
	  		map.put("notif_title", "下次免疫注射通知提醒");
	  		map.put("noti_content", tz);
	  		drugList.add(map);
		}
	  	if(drugList.size()>0) {
	  		if(tVaccineService.addNotification(drugList)>0) {
	  			System.out.println("添加通知成功");
		  		if(tVaccineService.updInjection(idList)>0) {
		  			System.out.println("修改免疫注射状态成功");
		  		}
	  		}
	  	}
    }
    //通知下次喂药
    //@Scheduled(cron = "* 0/1 * * * ?")
    @Scheduled(cron = "* * 3 * * ?")//每天凌晨2点执行一次
    public void drug() {
	  	System.out.println("test。。。");
	  	List<Map> list=(List<Map>)tVaccineService.getDrugTZ();//得到提醒喂药集合
	  	List<Long>idList=new ArrayList<Long>();//得到的需要发送免疫记录id
	  	List<Map>drugList=new ArrayList<Map>();//得到通知集合
	  	for (int i = 0; i < list.size(); i++) {
	  		idList.add((Long)list.get(i).get("drug_record_id"));
	  		String tz="犬主:"+list.get(i).get("dog_owner_name")+"你好,你的宠物狗:"
	  		+list.get(i).get("dog_name")+"下次喂药时间快到了,请您与"+list.get(i).get("next_drug_date")
	  		+"到宠物医院:"+list.get(i).get("organization_name")+"进行:"
	  		+list.get(i).get("organization_name")+"喂药。";
	  		Map<String, Object>map=new HashMap<String, Object>();
	  		map.put("notif_receiver_id", list.get(i).get("dog_owner_id"));
	  		map.put("notif_title","下次喂药通知提醒");
	  		map.put("noti_content", tz);
	  		drugList.add(map);
		}
	  	if(drugList.size()>0) {
	  		if(tVaccineService.addNotification(drugList)>0) {
	  			System.out.println("添加通知成功");
		  		if(tVaccineService.updDrugRecord(idList)>0) {
		  			System.out.println("修改免疫注射状态成功");
		  		}
	  		}
	  	}
    }
    
}
