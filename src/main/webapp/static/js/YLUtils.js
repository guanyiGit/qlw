//常用检验
//订单提交页-验证邮政编码
function is_postcode(postcode) {
 if ( postcode == "") {
  return false;
 } else {
  if (! /^[0-9][0-9]{5}$/.test(postcode)) {
   return false;
  }
 }
 return true;
}
//订单提交页-验证手机号
function is_mobile(mobile) {
  if( mobile == "") {
  return false;
  } else {
  if( ! /^0{0,1}(13[0-9]|15[0-9]|18[0-9]|14[0-9])[0-9]{8}$/.test(mobile) ) {
  return false;
  }
  return true;
 }
}
//订单提交页-验证email的合法性
function is_email(email) {
 if ( email == "") {
  return false;
 } else {
	 if (! /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/.test(email)) {
   return false;
  }
 }
 return true;
}
//非负整数
function isNonnegativeInteger(num){
	var reg = /(^[1-9]+\d*$)|(^0$)/;
	return reg.test(num);
}


//日期格式转化
function timeStamp2String(time) {
	var datetime = new Date();
	datetime.setTime(time);
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1)
			: datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime
			.getDate();
	return year + "-" + month + "-" + date;
}


//计算两个日期天数差的函数，通用
function DateDiff(sDate1, sDate2) {  //sDate1和sDate2是yyyy-MM-dd格式
  var aDate, oDate1, oDate2, iDays;
  aDate = sDate1.split("-");
  oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);  //转换为yyyy-MM-dd格式
  aDate = sDate2.split("-");
  oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
  iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数

  return iDays;  //返回相差天数
}

//验证身份证  
function isCardNo(card) {   
var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;   
return pattern.test(card);  
} 

//校验年龄
function isAge(age){
	var regAge = /^\d{1,2}$/;
	return regAge.test(age);
}
//校验体重
function isWeight(weight){
	var weightReg = /^(0(\.\d{1}){0,1}|[1-8]\d{1,3}(\.\d{1}){0,1}|9\d{1,2}(\.\d{1}){0,1}|999(\.0){0,1}|.{0})$/;
	return weightReg.test(weight);
}

//初始化毛色
function InitColor(){
 $.ajax({
	   type:"get",
	   url:"/biz/adoption/selectdogPro",
	   data:{logg:2},
	   dataType:"json",
	   success:function (res) {
		   if(res.length!=0){
			   for(var i=0;i<res.length;i++){
				   var option=$('<option></option>');
				   option.val(res[i].value);
				   option.text(res[i].name);
				   $("#colorSelect").append(option);
			   }
		   }
	   }
	})
}
//初始收容犬类型
function InitCollType(){
	$.ajax({
		type:"get",
		url:"/biz/adoption/selectdogPro",
		data:{logg:3},
		dataType:"json",
		success:function (res) {
			if(res.length!=0){
				for(var i=0;i<res.length;i++){
					var option=$('<option></option>');
					option.val(res[i].value);
					option.text(res[i].name);
					$("#collTypeSelect").append(option);
				}
			}
		}
	})
}

//初始化品种
function InitBreed(){
	   $.ajax({
	        type:"get",
	        url:"/biz/adoption/selectdogPro",
	        data:{logg:1},
	        dataType:"json",
	        success:function (res) {
	        		if(res.length!=0){
	        			for(var i=0;i<res.length;i++){
	        				var option=$('<option></option>');
	        				option.val(res[i].value);
	        				option.text(res[i].name);
	        				$("#breedSelect").append(option);
	        			}
	        		}
	        }
	    })
}

//查看犬只收容详情
function selectDetail(Id){
       $.ajax({
        type:"get",
	       url:"/biz/collection/findOne",
	       data:{collectionId:Id},
	       dataType:"json",
           success:function (res) {
           	 if(res.status==200){
        		$("#detail input[type='text']").attr("readonly","readonly");
        		$("#detail input[type='radio']").attr("onclick","return false");
        		$("#detail option").attr("disabled","disabled");
        		$("#detail textarea").attr("readonly","readonly");
           		 var dogInfo=res.data;
           		$("#qzbh").val(dogInfo.dogCode);//犬只编号
           		$("#qsbh").val(dogInfo.doghouseNum);//犬舍编号
           		$("#bsph").val(dogInfo.signboardCode);//标识牌号
           		$("#qzmc").val(dogInfo.dogName);//犬只名称
           		if(dogInfo.dogGender==0){//性别
        			$("#xb1").attr("checked","checked");
        		} else {
	        		$("#xb2").attr("checked","checked");
	        	}
           		$("#csrq").val(dogInfo.dogBreed);//犬种
           		$("#ql").val(dogInfo.dogAge);//犬龄
           		$("#ms").val(dogInfo.dogColor);//毛色
           		$("#tz").val(dogInfo.weight);//体重
           		$("#td").val(dogInfo.dogCharacter);//特点
           		var numbers = $("#jkzk").find("option"); //健康状况
        		for (var j = 1; j < numbers.length; j++) {
	        		if ($(numbers[j]).val() == dogInfo.healthStatus) {
	        			$(numbers[j]).attr("selected", "selected");
	        		}
        		}
        		$("#sryy").val(dogInfo.collDogReason);//收容原因
        		$("#srsj").val(timeStamp2String(dogInfo.collectionTime));//收容时间
        		$("#bz").val(dogInfo.remarks);//备注
        		$("#pic").attr("src",dogInfo.thumbnailUrl);
           	 }
           }
       })
}

function getdogAge(birthday){
    var newDate = new Date().getTime() - birthday;
    // 向下取整  例如 10岁 20天 会计算成 10岁
    // 如果要向上取整 计算成11岁，把floor替换成 ceil
    var age = Math.ceil(newDate / 1000 / 60 / 60 / 24 /365);
    return age;
}


