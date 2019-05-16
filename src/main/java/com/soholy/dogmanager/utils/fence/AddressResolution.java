package com.soholy.dogmanager.utils.fence;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soholy.dogmanager.common.httpclient.HttpsUtils;

/**
* @ClassName: AddressResolution
* @Description: 高德地图解析
* @author py
* @date 2018年9月8日
*
 */
public class AddressResolution {
	
	/**
	* @Description:地址转经纬度
	* @param address
	* @param city
	* @return（展示方法参数和返回值）
	 */
	public static Map<String, String> AddressToResolution(String address,String city,String key){
		String url = "https://restapi.amap.com/v3/geocode/geo";
		Map<String, String> params  =new HashMap<>();
		params.put("key", key);
		params.put("address", address);
		if (city!=null&&city.equals("")) {
			params.put("city", city);
		}
		JSONObject get = HttpsUtils.doGet(url, params);
		System.out.println(get.toJSONString());
		Map<String, String> locationMap = new HashMap<>();
		//将geocodes转化为json数组
		JSONArray jsonArray = get.getJSONArray("geocodes");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String location = jsonObject.getString("location");
			String[] coordinates = location.split(",");
			locationMap.put("longitude", coordinates[0]);
			locationMap.put("latitude", coordinates[1]);
		}
		
		return locationMap;
		
		
		
	}
	
	/**
	 * 
	* @Description:经纬度转地址
	* @param lng
	* @param lat
	* @return（展示方法参数和返回值）
	 */
	public static String ResolutionToAddress(String lng,String lat,String key){
		String url = "https://restapi.amap.com/v3/geocode/regeo";
		Map<String, String> params  =new HashMap<>();
		params.put("key", key);
		String location = lng+","+lat;
		params.put("location", location);
		JSONObject get = HttpsUtils.doGet(url, params);
		JSONObject regeocode = get.getJSONObject("regeocode");
		String address = regeocode.getString("formatted_address");
		return address;
	}
	
}
