package com.soholy.dogmanager.service.statistic.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.entity.HealthConditionDO;
import com.soholy.dogmanager.mapper.HealthConditionMapper;
import com.soholy.dogmanager.pojo.statistic.HealthConditionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soholy.dogmanager.common.utils.Md5Encode;
import com.soholy.dogmanager.entity.dogCard.PageInfo;
import com.soholy.dogmanager.entity.statistic.DogInfo;
import com.soholy.dogmanager.mapper.statistic.DogInfoMapper;
import com.soholy.dogmanager.mapper.statistic.TVaccineMapper;
import com.soholy.dogmanager.service.statistic.TVaccineService;
@Service
public class TVaccineServiceImpl implements TVaccineService {

	@Resource
	TVaccineMapper tVaccineMapper;
	@Resource
	DogInfoMapper dogInfoMapper;
	@Autowired
    private HealthConditionMapper healthConditionMapper;

	@Override
	public int getTVaccineCount(String input,Integer org_id) {
		// TODO Auto-generated method stub
		return tVaccineMapper.getTVaccineCount(input,org_id);
	}
	@Override
	public Object tVaccineList(Integer num,Integer size,String input,Integer org_id) {
		Map<Object,Object>map=new HashMap<Object,Object>();
		//得到总数量
		int count=tVaccineMapper.getTVaccineCount(input,org_id);
		
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNum(num);//页码
		pageInfo.setPageSize(size);//页数量
		pageInfo.setTotalCount(count);//总数量
		
		List<Object>list=tVaccineMapper.tVaccineList(pageInfo.getTotalStart(),pageInfo.getPageSize(),input,org_id);
		map.put("pageInfo", pageInfo);
		map.put("list", list);
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public Object tVaccineListWY(Integer num, Integer size, String input, Integer org_id) {
		Map<Object,Object>map=new HashMap<Object,Object>();
		//得到总数量
		int count=tVaccineMapper.getTVaccineCountWY(input,org_id);

		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNum(num);//页码
		pageInfo.setPageSize(size);//页数量
		pageInfo.setTotalCount(count);//总数量

		List<Object>list=tVaccineMapper.tVaccineListWY(pageInfo.getTotalStart(),pageInfo.getPageSize(),input,org_id);
		map.put("pageInfo", pageInfo);
		map.put("list", list);
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public Map getTherapyList(Integer num, Integer size, Integer org_id) {
		Map<String,Object>map=new HashMap<String,Object>();
		//得到总数量
		int count=tVaccineMapper.getTherapyListCount(org_id);

		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNum(num);//页码
		pageInfo.setPageSize(size);//页数量
		pageInfo.setTotalCount(count);//总数量

		List<Map>list=tVaccineMapper.getTherapyList(pageInfo.getTotalStart(),pageInfo.getPageSize(),org_id);
		map.put("pageInfo", pageInfo);
		map.put("list", list);
		map.put("code",200);
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public Object getTVaccineId(Integer id,Integer num,Integer size) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
//		HashMap<String,Object> dogInfo=tVaccineMapper.getTVaccineId(id);//犬信息
//        List<HashMap<String, Object>> ZdogPic = tVaccineMapper.findDogPic((long) dogInfo.get("dog_id"),2);//犬图片
//        List<HashMap<String, Object>> CdogPic = tVaccineMapper.findDogPic((long) dogInfo.get("dog_id"),10);//犬图片
        List<Object>list=null;//集
		int InjectionCount=tVaccineMapper.getInjectionCount(id);//得到免疫记录全部数量

		HashMap<String, Object> map1 = new HashMap<>();
//		map1.put("dogId",dogInfo.get("dog_id"));
		map1.put("dogId",id);
		if(num!=null&&!num.equals("")&&size!=null&&!size.equals("")) {
			PageInfo pageInfo=new PageInfo();
			pageInfo.setTotalCount(InjectionCount);//总数量
			pageInfo.setPageNum(num);//当前页
			pageInfo.setPageSize(size);//分页大小
			list=tVaccineMapper.getInjectionList(id,pageInfo.getTotalStart(),size);
			map.put("pageInfo", pageInfo);

			PageHelper.startPage(num,size);
			List<HealthConditionVO> HealthConditionList = healthConditionMapper.list(map1);
			com.github.pagehelper.PageInfo<HealthConditionVO> healthConditionPageInfo = new com.github.pagehelper.PageInfo<>(HealthConditionList);
			map.put("healthConditionPageInfo", healthConditionPageInfo);
		}else {
			list=tVaccineMapper.getInjectionList(id,null,null);
			List<HealthConditionVO> HealthConditionList = healthConditionMapper.list(map1);
			map.put("HealthConditionList", HealthConditionList);
		}
//		map.put("dogInfo", dogInfo);
//		map.put("ZdogPic", ZdogPic);
//		map.put("CdogPic", CdogPic);
		map.put("Immunelist", list);
		return map;
	}
	@Override
	public Object getDrugRecord(Integer org_id,Integer dog_id,Integer num,Integer size) {
		// TODO Auto-generated method stub
		int i=tVaccineMapper.getDrugRecordListCount(org_id,dog_id);
		PageInfo pageInfo =new PageInfo();
		pageInfo.setTotalCount(i);
		pageInfo.setPageSize(size);
		pageInfo.setPageNum(num);
		Map<String, Object> map=new HashMap<String, Object>();
		Object dogInfo=tVaccineMapper.getDogDowOwner(dog_id);//得到狗信息和犬主信息
		List<Object>list=tVaccineMapper.getDrugRecordList(org_id,dog_id,pageInfo.getTotalStart(),size);
		map.put("dogInfo", dogInfo);
		map.put("list", list);
		map.put("pageInfo", pageInfo);
		return map;
	}
	@Override
	public Object getDogInfoImm(Integer id,Integer pageNum,Integer pageSize,Integer org_id) {
		// TODO Auto-generated method stub
		int i=tVaccineMapper.getInjectionListDogIDCount(id,org_id);
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNum(pageNum);
		pageInfo.setTotalCount(i);
		pageInfo.setPageSize(pageSize);
		Map<String, Object> map=new HashMap<String, Object>();
		Object dogInfo=tVaccineMapper.getDogInfoImm(id);
		List<Object>list=tVaccineMapper.getInjectionListDogID(id,pageInfo.getTotalStart(),pageSize,org_id);
		map.put("pageInfo", pageInfo);
		map.put("dogInfo", dogInfo);
		map.put("list", list);
		return map;
	}
	@Override
	public Map getTherapyDetails(Integer dogId,Integer orgId,Integer num,Integer size) {
		// TODO Auto-generated method stub
		try {
			Map<String,Object>map=new HashMap();
			map.put("dogId", dogId);
			map.put("orgId", orgId);
			int i=tVaccineMapper.getTherapeListCount(map);//总数量
			PageInfo pageInfo=new PageInfo();
			pageInfo.setTotalCount(i);
			pageInfo.setPageNum(num);
			pageInfo.setPageSize(size);
			
			map.put("start", pageInfo.getTotalStart());
			map.put("size", size);

			Object dogInfo=tVaccineMapper.getDogDowOwner(dogId);//得到狗信息和犬主信息
			List<Map> list=tVaccineMapper.getTherapeList(map);//病历记录集合
			map.put("pageInfo", pageInfo);
			map.put("dogInfo", dogInfo);
			map.put("list", list);
			map.put("code",200);
			return map;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public boolean addTVaccine(Map map) {
		// TODO Auto-generated method stub
		try {
			Integer id=tVaccineMapper.getVaccineRegisterIds(
					(int)map.get("dog_id"),(int)map.get("org_id"));
			if(id!=null&&!id.equals("")) {//if存在该免疫证不添加免疫证表数据
				map.put("vaccine_register_id",id);//免疫登记id从后台得到
				if(tVaccineMapper.addVaccineInjection(map)>0) {
					return true;
				}
			}else {
				if(tVaccineMapper.addTVaccine(map)>0) {//添加免疫登记表
					//得到免疫登记表自增最大id值getVaccineRegisterId
					int getVaccineRegisterId=tVaccineMapper.getVaccineRegisterId();
					map.put("vaccine_register_id", getVaccineRegisterId);//免疫登记id从后台得到
					if(tVaccineMapper.addVaccineInjection(map)>0) {
						return true;
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public String getIdRefId(Integer ref_id,String vaccine_name) {
		// TODO Auto-generated method stub
		return tVaccineMapper.getIdRefId(ref_id,vaccine_name);
	}
	@SuppressWarnings("all")
	@Override
	@Transactional
	public boolean addWZVaccine(Map map) {
		// TODO Auto-generated method stub
		try {
			if(map!=null&&!map.equals("")) {
				//根据犬主电话查找犬主id
				Integer dogOwonerId=tVaccineMapper.getDogOwnerID((String)map.get("dog_owner_phone"));
				
				if(dogOwonerId!=null&&!dogOwonerId.equals("")) {//有该犬主id执行根据宠物名字和犬主id得到宠物id
					map.put("dog_owner_id", dogOwonerId);//得到犬主id
					Integer dogId=tVaccineMapper.getDogIds(dogOwonerId, (String)map.get("dog_name"));
					if(dogId!=null&&!dogId.equals("")) {
						map.put("dog_id", dogId);
					}else {//没有该犬信息添加犬信息
						int i=tVaccineMapper.addDogInfo(map);
						map.put("dog_id", tVaccineMapper.getVaccineRegisterId());//得到犬id
					}
				}else {
					//添加犬主
					int addDogOwner=tVaccineMapper.addDogOwner(map);
					if(addDogOwner>0) {
						//得到犬主id
						map.put("dog_owner_id", tVaccineMapper.getVaccineRegisterId());
						//添加身份证
						int addDogOwnerCard=tVaccineMapper.addDogOwnerCard(map);
						if(addDogOwnerCard>0) {
							//添加犬
							int addDogInfo=tVaccineMapper.addDogInfo(map);
							map.put("dog_id", tVaccineMapper.getVaccineRegisterId());//得到犬id
						}
					}
				}
				map.put("ref_id", -1);
				Integer id=tVaccineMapper.getVaccineRegisterIds((int)map.get("dog_id"),(int)map.get("org_id"));
				if(id!=null&&!id.equals("")) {//if存在该免疫证登记id不添加免疫数据
					map.put("vaccine_register_id", id);
					if(tVaccineMapper.addVaccineInjection(map)>0) {//添加免疫记录
						return true;
					}
				}else {
					if(tVaccineMapper.addTVaccine(map)>0) {//添加免疫登记
						int vrid=tVaccineMapper.getVaccineRegisterId();//得到免疫登记表自增最大id值
						map.put("vaccine_register_id", vrid);
						if(tVaccineMapper.addVaccineInjection(map)>0) {//添加免疫记录
							return true;
						}
					}
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public int addWZTherapy(Map map) {
		// TODO Auto-generated method stub
		try {
			if(map!=null&&!map.equals("")) {
				//根据犬主电话查找犬主id
				Integer dogOwonerId=tVaccineMapper.getDogOwnerID((String)map.get("dog_owner_phone"));
				
				if(dogOwonerId!=null&&!dogOwonerId.equals("")) {//有该犬主id执行根据宠物名字和犬主id得到宠物id
					map.put("dog_owner_id", dogOwonerId);//得到犬主id
					Integer dogId=tVaccineMapper.getDogIds(dogOwonerId, (String)map.get("dog_name"));
					if(dogId!=null&&!dogId.equals("")) {
						map.put("dog_id", dogId);
					}else {//没有该犬信息添加犬信息
						int i=tVaccineMapper.addDogInfo(map);
						map.put("dog_id", tVaccineMapper.getVaccineRegisterId());//得到犬id
					}
				}else {//不存在该犬主添加犬主
					//添加犬主
					int addDogOwner=tVaccineMapper.addDogOwner(map);
					if(addDogOwner>0) {
						//得到犬主id
						map.put("dog_owner_id", tVaccineMapper.getVaccineRegisterId());
						//添加身份证
						int addDogOwnerCard=tVaccineMapper.addDogOwnerCard(map);
						if(addDogOwnerCard>0) {
							//添加犬
							int addDogInfo=tVaccineMapper.addDogInfo(map);
							map.put("dog_id", tVaccineMapper.getVaccineRegisterId());//得到犬id
						}
					}
				}
				if(tVaccineMapper.addTherapy(map)>0) {//添加病历记录
						return tVaccineMapper.getVaccineRegisterId();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	@Override
	public Object getDogInfoPhone(String input,Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		int i=tVaccineMapper.getDogInfoPhoneCount(input);
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNum(pageNum);
		pageInfo.setPageSize(pageSize);
		pageInfo.setTotalCount(i);
		Map map=new HashMap<String,Object>();
		map.put("pageInfo", pageInfo);
		List<Object>list=tVaccineMapper.getDogInfoPhone(input,pageInfo.getTotalStart(),pageSize);
		map.put("list", list);
		return map;
	}
	@Override
	public int addDrugRecord(Map map) {
		// TODO Auto-generated method stub
		return tVaccineMapper.addDrugRecord(map);
	}
	@Override
	public List<Map> getDrugTZ() {
		// TODO Auto-generated method stub
		return tVaccineMapper.getDrugTZ();
	}
	@Override
	public int addVaccineInjection(Map map) {
		// TODO Auto-generated method stub
		return tVaccineMapper.addVaccineInjection(map);
	}
	@Override
	public boolean addDrugRecords(Map map) {
		// TODO Auto-generated method stub
			try {
				Integer id=tVaccineMapper.getVaccineRegisterIds((int)map.get("dog_id"),(int)map.get("org_id"));
				if(id!=null&&!id.equals("")) {//if存在该免疫登记id不添加免疫数据
						map.put("vaccine_register_id", id);//免疫登记id从后台得到
						if(tVaccineMapper.addDrugRecord(map)>0) {
							return true;
					}
				}else {
					if(tVaccineMapper.addTVaccine(map)>0) {//添加免疫登记表
						//得到免疫登记表自增最大id值getVaccineRegisterId
						int getVaccineRegisterId=tVaccineMapper.getVaccineRegisterId();
						map.put("vaccine_register_id", getVaccineRegisterId);//免疫登记id从后台得到
						if(tVaccineMapper.addDrugRecord(map)>0) {
							return true;
						}
					}
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
			return false;
	}
	@Override
	public Object getDrugRecords(Integer id,Integer num,Integer size,Integer org_id) {
		// TODO Auto-generated method stub
		int i=tVaccineMapper.getDrugRccordListDogIdCount(id,org_id);
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageSize(size);
		pageInfo.setTotalCount(i);
		pageInfo.setPageNum(num);
		Map<String, Object> map=new HashMap<String, Object>();
		Object dogInfo=tVaccineMapper.getDogInfoImm(id);
		List<Object>list=tVaccineMapper.getDrugRccordListDogId(id,pageInfo.getTotalStart(),size,org_id);
		map.put("dogInfo", dogInfo);
		map.put("list", list);
		map.put("pageInfo", pageInfo);
		return map;
	}
	@Override
	public List<Map> getInjectionTZ() {
		// TODO Auto-generated method stub
		return tVaccineMapper.getInjectionTZ();
	}
	@Override
	public int addNotification(List<Map> list) {
		// TODO Auto-generated method stub
		return tVaccineMapper.addNotification(list);
	}
	@Override
	public boolean addWZDrugRecord(Map map) {
		// TODO Auto-generated method stub
		try {
			if(map!=null&&!map.equals("")) {
				//根据犬主电话查找犬主id
				Integer dogOwonerId=tVaccineMapper.getDogOwnerID((String)map.get("dog_owner_phone"));
				if(dogOwonerId!=null&&!dogOwonerId.equals("")) {//有该犬主id执行根据宠物名字和犬主id得到宠物id
					map.put("dog_owner_id", dogOwonerId);//得到犬主id
					Integer dogId=tVaccineMapper.getDogIds(dogOwonerId, (String)map.get("dog_name"));
					if(dogId!=null&&!dogId.equals("")) {
						map.put("dog_id", dogId);
					}else {//没有该犬信息添加犬信息
						int i=tVaccineMapper.addDogInfo(map);
						map.put("dog_id", tVaccineMapper.getVaccineRegisterId());//得到犬id
					}
				}else {//不存在该犬主添加犬主
					//添加犬主
					int addDogOwner=tVaccineMapper.addDogOwner(map);
					if(addDogOwner>0) {
						//得到犬主id
						map.put("dog_owner_id", tVaccineMapper.getVaccineRegisterId());
						//添加身份证
						int addDogOwnerCard=tVaccineMapper.addDogOwnerCard(map);
						if(addDogOwnerCard>0) {
							//添加犬
							int addDogInfo=tVaccineMapper.addDogInfo(map);
							map.put("dog_id", tVaccineMapper.getVaccineRegisterId());//得到犬id
						}
					}
				}
				//map.put("ref_id", -1);
				Integer id=tVaccineMapper.getVaccineRegisterIds((int)map.get("dog_id"),(int)map.get("org_id"));
				if(id!=null&&!id.equals("")) {//if存在该免疫登记id不添加免疫数据
					map.put("vaccine_register_id", id);//免疫登记id从后台得到
					if(tVaccineMapper.addDrugRecord(map)>0) {
						return true;
					}
				}else {
					if(tVaccineMapper.addTVaccine(map)>0) {//添加免疫登记表
					//得到免疫登记表自增最大id值getVaccineRegisterId
					int getVaccineRegisterId=tVaccineMapper.getVaccineRegisterId();
					map.put("vaccine_register_id", getVaccineRegisterId);//免疫登记id从后台得到
					if(tVaccineMapper.addDrugRecord(map)>0) {
						return true;
						}
					}
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@Override
	public int updDrugRecord(List<Long> list) {
		// TODO Auto-generated method stub
		return tVaccineMapper.updDrugRecord(list);
	}
	@Override
	public int updInjection(List<Long> list) {
		// TODO Auto-generated method stub
		return tVaccineMapper.updInjection(list);
	}
	@Override
	public int updPwd(Map map) {
		// TODO Auto-generated method stub
		try {
			String rawPwd=Md5Encode.getCredentials((String)map.get("name")
					,(String)map.get("rawPwd")).toString();//得到用户输入的旧密码
			map.put("rawPwd", rawPwd);
			int i=tVaccineMapper.boolPwd(map);//得到旧密码是否正确
			System.out.println("查询状态"+i);
			if(i>0) {
				String newPwd=Md5Encode.getCredentials((String)map.get("name")
						,(String)map.get("newPwd")).toString();//生成新密码
				map.put("newPwd", newPwd);
				int ii=tVaccineMapper.updPwd(map);//1修改成功/0新密码与旧密码一样
				System.out.println("修改状态"+ii);
				return ii;
			}
			return -1;//-1原密码不正确
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -2;//-2修改失败
		}
	}
	@Override
	public Map getDogOwner(String phone) {
		// TODO Auto-generated method stub
		return tVaccineMapper.getDogOwner(phone);
	}
	@Override
	public Map getDog(Integer id, String dogName) {
		// TODO Auto-generated method stub
		return tVaccineMapper.getDog(id, dogName);
	}
	@Override
	public Map getTherapes(Integer id) {
		// TODO Auto-generated method stub
		try {
			Map <String,Object>map=tVaccineMapper.getTherapes(id);//得到病历记录
			List<Map> list=tVaccineMapper.getTherapeLists(id);;//得到病历记录图片集合
			map.put("list", list);
			return map;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Map> getHospitalList(Integer id) {
		// TODO Auto-generated method stub
		return tVaccineMapper.getHospitalList(id);
	}
	@Override
	public Map getDogDogOwner(Integer id) {
		// TODO Auto-generated method stub
		return (Map)tVaccineMapper.getDogInfoImm(id);
	}

	@Override
	public List<Map> getHealthConditionList(Integer dogId) {
		return tVaccineMapper.getHealthConditionList(dogId);
	}

	@Override
	public Object getDogList(String input, Integer num, Integer size) {
		Map<Object,Object>map=new HashMap<Object,Object>();
		//得到总数量
		int count=tVaccineMapper.getDogListCount(input);

		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNum(num);//页码
		pageInfo.setPageSize(size);//页数量
		pageInfo.setTotalCount(count);//总数量

		List<Map>list=tVaccineMapper.getDogList(input,pageInfo.getTotalStart(),pageInfo.getPageSize());
		map.put("pageInfo", pageInfo);
		map.put("list", list);
		map.put("code",200);
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public DogResult addDogInfo(Map map) {
		try {
			//1根据犬主id犬名查找犬。
			Integer dogId=tVaccineMapper.getDogIds(Integer.parseInt(map.get("dog_owner_id").toString()), (String)map.get("dog_name"));
			if(dogId!=null&&!dogId.equals("")) {
				return DogResult.build(400,"犬名已经存在");
			}else {//没有该犬信息添加犬信息
				if(tVaccineMapper.addDogInfo(map)>0){
					int dog_id=tVaccineMapper.getVaccineRegisterId();//得到犬id
					return DogResult.build(200,"添加成功",dog_id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return DogResult.build(400,"添加失败");
		}
		return DogResult.build(400,"添加失败");
	}

	@Override
	public int addTherapy(Map map) {
		// TODO Auto-generated method stub
		try {
			if(tVaccineMapper.addTherapy(map)>0) {
				int i=tVaccineMapper.getVaccineRegisterId();
				return i;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}
}
