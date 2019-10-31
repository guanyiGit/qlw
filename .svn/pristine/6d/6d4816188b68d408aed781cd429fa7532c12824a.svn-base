package com.soholy.dogmanager.common.utils;


import com.soholy.dogmanager.pojo.statistic.DogTendency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DateUtils {
	/**
	 * 求出最近count月的 startMonth和endMonth 
	 * @author ZhongZhong
	 * @param count 月数
	 * @return Date
	 * @throws ParseException 
	 */
	public static HashMap<String, Object> getStartDateAndEndDate(Integer count) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		HashMap<String, Object>map=new HashMap<String, Object>();
		
			Calendar c1 = Calendar.getInstance();
			 c1.add(Calendar.MONTH, -count);
			 Date startDate=sdf.parse(sdf.format(c1.getTime()));
			
			 	Date endDate=sdf.parse(sdf.format(new Date()));
			 	
			map.put("startDate", startDate);
			map.put("endDate", endDate);
		return map;
	}


	/**
	 * 求出最近count月的 startMonth和endMonth
	 * @author ZhongZhong
	 * @param count 月数
	 * @return Date
	 * @throws ParseException
	 */
	public static List<DogTendency> getYearMonthInCountYear(Integer count) throws ParseException {

        List<DogTendency>tendencyList=new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为2017-10
        Calendar calendar = Calendar.getInstance();//得到Calendar实例
        Date maxDate=sdf.parse(sdf.format(calendar.getTime()));
        calendar.add(Calendar.MONTH, -count);//把月份减count个月
        Date minDate = sdf.parse(sdf.format(calendar.getTime()));
        List<Date> list = null;
        try {
            list = getMonthBetween(minDate, maxDate);
            for (Date d:list) {
                DogTendency tendency=new DogTendency();
                tendency.setDate(d);
                tendencyList.add(tendency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list);


		return tendencyList;

	}



	
	
	
	/**
	 * 获取前count个月的起始日期和截止日期
	 * 例如:2018-08-27上1个月的起始日期:2018-07-01  截止日期:2018-08-01
	 * @param args
	 * @throws ParseException
	 */
	public static HashMap<String, Object> getMonthDate(Integer count) throws ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
		Calendar c1 = Calendar.getInstance();
		Date endDate=sd.parse(sd.format(c1.getTime()));
		 c1.add(Calendar.MONTH, -count);
		Date startDate = sd.parse(sd.format(c1.getTime()));
		 
		HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("startDate", startDate);
			map.put("endDate", endDate);
		return map;
	}
	
	
	/**
	 * 根据当前日期获取昨日日期(字符串类型)
	 * @throws ParseException 
	 */
	public static String getYesterdayDate() throws ParseException {
		
		Date date=new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");  
		return sd.format(org.apache.commons.lang3.time.DateUtils.addDays(date, -1));
	}
	
	/**
	 * 获取上月字符串类型日期
	 * @return
	 */
	public static String getLastStringMonth() {
		Date date=new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");  
		return sd.format(org.apache.commons.lang3.time.DateUtils.addMonths(date, -1));
	}
	
	public static void main(String[] args) throws ParseException {

	}



    static List<Date> getMonthBetween(Date minDate, Date maxDate) throws Exception {
        ArrayList<Date> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(minDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);


        max.setTime(maxDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(curr.getTime());
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

	
}
