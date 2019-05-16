var model={
		data:null,
		adoptionPublicityId:null,
		collectionId:null,
		blag:false,
		
}


$(function () {
	var collectionId=window.sessionStorage.getItem("collectionId")
	var adoptionPublicityId=window.sessionStorage.getItem("adoptionPublicityId")
	model.collectionId=collectionId;
	model.adoptionPublicityId=adoptionPublicityId;
	getDogInfo(collectionId);
	
	 //校验电话
    $("#lxdh").blur(function(){
		if($("#lxdh").val()!=''){
			if(!is_mobile($("#lxdh").val())){
				bootbox.alert("联系电话填写错误");
			}
		}
	});
    
    //提交申请
    $("#send").click(function(){
    	if($.trim($("#xm").val())==''){
    		bootbox.alert("姓名不能为空");
    		return false;
    	}
    	checkCode();
    	if(model.blag==true){
    		sendApply();
    	}else{
    		bootbox.alert("验证码不正确");
    		return false;
    	}
    });
    $("#cansle").click(function(){
    	$("#home").load("views/dog/lovingAdoption.html");
    });
    
  //获得验证码
    $("#btn").click(function(){
    	if($.trim($("lxdh").val())==''){
    		bootbox.alert("联系电话不能为空");
    		return;
    	}
    	getCode();
    });
});

//show犬信息
function getDogInfo(Id){
	 $.ajax({
	        type:"get",
	        url:"/biz/collection/findOne",
	        data:{collectionId:Id},
	        dataType:"json",
	        success:function (res) {
	        	if(res.status==200 && res.data!=null){
	        		$("#detail input").val('');
	        		var data=res.data;
	        		  $("#qm").text(data.dogName);
	        		  $("#pz").text(data.dogBreed);
	        		  $("#qxb").text(data.dogGender==0?"雄":"雌");
	        		  $("#ms").text(data.dogColor);
	        		  $("#ql").text(data.dogAge);
	        		  $("#td").text(data.dogCharacter);
	        		  $("#bz").text(data.remarks);
	        		  $("#pic").attr("src",data.thumbnailUrl);
	        	}
	        }
	    })
	
} 

//得到申请人信息
function getApply(){
	   var person={
			   applyerName:$.trim($("#xm").val()),   
			   applyerSex:$.trim($("#xb input[type='radio']:checked").val()),   
			   cardType:$.trim($("#zjlx option:selected").val()),   
			   cardNumber:$.trim($("#zjhm").val()),   
			   adoptionAddress:$.trim($("#yqdz").val()),
			   applyerPhone:$.trim($("#lxdh").val()),
			   dogPublicityId:model.adoptionPublicityId ,
			   collectionId:model.collectionId
			   
	   }
	   model.data=person;
}

//申请领养
function sendApply(){
	   getApply();
	   $.ajax({
	        type:"post",
	        url:"/biz/adoption/apply",
	        data:model.data,
	        dataType:"json",
	        contentType: "application/x-www-form-urlencoded",
	        success:function (res) {
	        	if(res.status==200){
	        		$("#detail input").val('');
	        		bootbox.alert("申请成功");
	        	}else{
	        		bootbox.alert("申请失败");
	        	}
	        }
	    })
}


//请求验证码
function getCode(){
	   $.ajax({
	        type:"get",
	        url:"/biz/adoption/getCode",
	        data:{phone:$.trim($("#lxdh").val())},
	        dataType:"json",
	        success:function (res) {
	        	if(res.status==200){
	        		$("#btn").text("请等片刻");
	        	}else{
	        		bootbox.alert("获取验证码失败");
	        	}
	        }
	    })  
}

//验证验证码
function checkCode(){
	   $.ajax({
	        type:"get",
	        url:"/biz/adoption/checkCode",
	        data:{phone:$.trim($("#yzm").val()),randCode:$.trim($("#yzm").val())},
	        dataType:"json",
	        async:false,
	        success:function (res) {
	        	if(res.status==200){
	        		model.blag=true;
	        	}else{
	        		bootbox.alert("验证码不正确");
	        	}
	        }
	    })  
}

