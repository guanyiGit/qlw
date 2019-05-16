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
var model = {
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
		symptom:null,
		remarks:null,
		creationTime:null
	}
}


$(function () {
	//1.获取页面传过来的犬只id
	var dogId=window.sessionStorage.getItem("medical_history_dogId");
	//2.获取页面传递的犬主id
	var dogOwnerId=window.sessionStorage.getItem("medical_history_dogOwnerId");
	//3.获取用户信息
	var user=JSON.parse(sessionStorage.getItem("user"));
	//4.获取用户部门id 
	var orgId=user.organizationId;
	//5.获取用户id
	var userId=user.userId;
	//赋值
	 model.therapy.orgId=orgId;
	 model.therapy.dogId=dogId;
	 model.therapy.dogOwnerId=dogOwnerId;
	 model.therapy.operationId=userId;
	 //3.查询病历详情
	 findTherapyDetail(dogId,orgId);
	 //4.弹出新增病历模态框
	 $("#add").click(function(){
		 $("#myModal").modal(
			 'toggle'
		 )
	 });
	 //5.新增病历
	 $("#submit").click(function(){
		 gainModelValue();
		 insertTherapyRecord();
	 });
	 
	 //6.点击返回按钮时,跳转到病历列表页面
	 $("#back").click(function(){
		 $("#home").load("./views/medical_history/medical_history_List.html");
	 });
});

//3#查询病历详情(待优化)
function findTherapyDetail(dogId,orgId){
	$.ajax({
		type: "get",
        url: "/biz/dogInfo/findTherapyDetail",
        data:{dogId:dogId,orgId:orgId},
        dataType:"json",
        async: false,
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		debugger
        		//渲染犬只基本信息
        		gainDogBaiscInfo(result);
        		var data=result.tTherapyList;
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
        		
        	}else{
        		alert("查询病历详情失败!");
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
//获取犬只基本信息
function gainDogBaiscInfo(result){
	$("#immNum").val(result.dogImmune.immuneCardNum);//免疫证号
	 $("#dogCardNum").val(result.tDogCard.dogCardNum);//犬证号
    $("#dogOwnerName").val(result.dogOwner.dogOwnerName);//犬主姓名
    $("#dogOwnerPhone").val(result.dogOwner.dogOwnerPhone);//犬主电话
    $("#dogName").val(result.dogName);//犬只名称
    if(result.dogGender==0){
    	$("#dogGender").val("雄");//犬只性别
    }else{
    	$("#dogGender").val("雌");//犬只性别
    }
    $("#dogBreedType").val(result.dogBreedDictionary.dictionaryDescribe);//犬只品种
    $("#birthTime").val(model.formatDate(result.birthTime));//犬只出生年月
    $("#dogColorType").val(result.dogColorDictionary.dictionaryDescribe);//毛色
}
//5#新增病历
function insertTherapyRecord(){
	$.ajax({
		type: "post",
        url: "/biz/dogInfo/insertTherapyRecord",
        data:model.therapy,
        dataType:"json",
        async: false,
        success: function (result) 
        {
        	if(result){
        		alert("新增病历成功");
        		findTherapyDetail(model.therapy.dogId,model.therapy.orgId);
        	}else{
        		alert("新增病历失败");
        	}
        }
	})
}
