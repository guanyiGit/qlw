var tempTr =  '<tr class="tab-body" style="height: 120px;"> '+
				'<td>$(time)</td>'+
					'<td>'+
					    '<p>'+
					        '<span>症状：</span>'+
					        '<span>$(zz)</span>'+
					    '</p>'+
					    '<p>'+
					        '<span>诊断：</span>'+
					        '<span>$(zd)</span>'+
					    '</p>'+
					'</td>'+
					'<td>$(zl)</td>'+
				'<td>$(bz)</td>'+
			'</tr>';
var model={
		formatDate: function(date) {
	        var datetime = new Date(date);
	        var year = datetime.getFullYear();
	        var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
	        var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
	        var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
	        var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
	        // return year + "-" + month + "-" + day + " " + hours + ":" + min;
	        return year + "-" + month + "-" + day;
	    },
	    DateToUnix: function(string) {
	        var f = string.split('-', 2);
	        var d = (f[0] ? f[0] : '').split('-', 3);
	        var t = (f[1] ? f[1] : '').split(':', 3);
	        return (new Date(
	            parseInt(d[0], 10) || null,
	            (parseInt(d[1], 10) || 1) - 1,
	            parseInt(d[2], 10) || null,
	            parseInt(t[0], 10) || null,
	            parseInt(t[1], 10) || null,
	            parseInt(t[2], 10) || null
	        )).getTime()/1000;
	    },
		therapy:{
			orgId:null,
			physicianName:null,
			dogId:null,
			dogOwnerId:null,
			operationId:null,
			diagnose:null,
			treatmentInfo:null,
			remarks:null,
			symptom:null,
			creationTime:null

		}
		
}

$(function(){
	//1.根据免疫证号查询基本信息
	$("#search").click(function (){
		findDogInspectionByImmuneCode();
	});
	//2.点击新增病历,弹出模态框
	$("#add").click(function(){
		if($("#immNum").val()==null || $("#immNum").val()==""){
			alert("请输入免疫证号!")
			return 
		}
		
		 $("#myModal").modal(
			 'toggle'
		 )
	 });
	//3.点击modal框的提交按钮,发起ajax请求插入数据
	$("#submit").click(function(){
		gainModelValue();
		//验证dogId,dogOwnerId,orgId,operationId
		checkBeforeInsert();
    	insertTherapyRecord();
	 });
	//3.点击返回按钮,返回到病历列表
	$("#back").click(function(){
        $("#home").load("views/medical_history/medical_history_List.html");
	 });
	
});

function checkBeforeInsert(){
	if(model.therapy.dogId==null ||model.therapy.dogId==""||
			model.therapy.dogOwnerId==null ||model.therapy.dogOwnerId==""||
			model.therapy.orgId==null ||model.therapy.orgId==""||
			model.therapy.operationId==null ||model.therapy.operationId==""){
		
		alert("新增病历失败!");
	}
}

function findDogInspectionByImmuneCode(){
	$.ajax({
		type: "get",
        url: "/biz/dogInfo/findDogInspectionByImmuneCode",
        data:{immuneCardNum:$("#immNum").val().trim()},
        dataType:"json",
        success: function (result) 
        {
        	debugger
        	var result=result.data;
        	if(result !=null && result !=""){
        		//$("#immNum").val(result.tImmuneCard.immuneCardNum);
                $("#dogCardNum").val(result.tDogCard.dogCardNum);//犬证号
                $("#dogOwnerName").val(result.tDogOwner.dogOwnerName);//犬主姓名
                $("#dogOwnerPhone").val(result.tDogOwner.dogOwnerPhone);//犬主电话
                $("#dogName").val(result.tDogInfo.dogName);//犬只名称
                if(result.tDogInfo.dogGender==0){
                	$("#dogGender").val("雄");//犬只性别
                }else{
                	$("#dogGender").val("雌");//犬只性别
                }
                $("#dogBreedType").val(result.tDogInfo.dogBreedDictionary.dictionaryDescribe);//犬只品种
                $("#birthTime").val(model.formatDate(result.tDogInfo.birthTime));//犬只出生年月
                $("#dogColorType").val(result.tDogInfo.dogColorDictionary.dictionaryDescribe);//毛色
                //待完善
                model.therapy.dogId=result.tDogInfo.dogId;
                model.therapy.dogOwnerId=result.tDogInfo.dogOwnerId;
                //获取登录用户的相关信息
            	var user=JSON.parse(sessionStorage.getItem("user"));
            	//获取组织id
            	model.therapy.orgId=user.organizationId;
                model.therapy.operationId=user.userId;
                findDetailTherapyList(model.therapy.dogId,model.therapy.orgId);
            }
        	else{
        		alert("该免疫证号不存在!请重新输入!");
        		$(".common").val("");
        		$(".tab-head").nextAll().remove();
        		return
        	}
        }
	})
}

function findDetailTherapyList(dogId,orgId){
	$.ajax({
		type: "get",
        url: "/biz/dogInfo/findDetailTherapyList",
        data:{dogId:dogId,orgId:orgId},
        dataType:"json",
        success: function (result) 
        {
        	if(result !=null){
        		var data=result;
        		$(".tab-head").nextAll().remove();
        		for(var i =0;i<data.length;i++){
        			//治疗时间
        			var creationTime=model.formatDate(data[i].creationTime);
        			//症状
	        		var symptom = data[i].symptom;
	        		//诊断
	        		var diagnose = data[i].diagnose;
	        		//治疗
	        		var treatmentInfo = data[i].treatmentInfo;
	        		//备注
	        		var remarks = data[i].remarks;
	        		var tempTrs = tempTr.replace("$(time)",creationTime);
	        		tempTrs = tempTrs.replace("$(zz)",symptom);
	        		tempTrs = tempTrs.replace("$(zd)",diagnose);
	        		tempTrs = tempTrs.replace("$(zl)",treatmentInfo);
	        		tempTrs = tempTrs.replace("$(bz)",remarks);
	        		$(".tab-head").after(tempTrs);
        		}
        		
        	}
        }
	});
}

//获取modal框上的值
function gainModelValue(){
	model.therapy.creationTime=$("#issDate").val().trim();
	model.therapy.symptom=$("#symptom").val().trim();
	model.therapy.diagnose=$("#diagnosis").val().trim();
	model.therapy.treatmentInfo=$("#treatment").val().trim();
	model.therapy.remarks=$("#remarks").val().trim();
}
//新增病历记录
function insertTherapyRecord(){
	$.ajax({
		type: "post",
        url: "/biz/dogInfo/insertTherapyRecord",
        data:model.therapy,
        dataType:"json",
        success: function (result) 
        {
        	if(result==1){
        		alert("新增病历成功!")
        		//根据dogId和orgId查找病历列表
                findDetailTherapyList(model.therapy.dogId,model.therapy.orgId);
        	}
        	else{
        		alert("新增病历失败!")
        	}
        	
        }
	});
}