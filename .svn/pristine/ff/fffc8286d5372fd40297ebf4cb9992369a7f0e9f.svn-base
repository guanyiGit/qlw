$(function () {
	var collectionId=window.sessionStorage.getItem("collectionId");
	var adoptionRecordsId=window.sessionStorage.getItem("adoptionRecordsId");
	//查收容详情
	selectDetail(collectionId);
	//查已领养详情
	selectAdoptionedDetail(adoptionRecordsId);
});
/*
//查看犬只收容详情
function selectDetail(Id){
       $.ajax({
        type:"get",
	       url:"/biz/collection/findOne",
	       data:{collectionId:Id},
	       dataType:"json",
           success:function (res) {
           	 if(res.status==200){
           		 var dogInfo=res.data;
           		$("#detail input[type='text']").attr("readonly","readonly");
        		$("#detail input[type='radio']").attr("onclick","return false");
        		$("#detail option").attr("disabled","disabled");
        		$("#detail textarea").attr("readonly","readonly");
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
}*/

function selectAdoptionedDetail(Id){
    $.ajax({
        type:"get",
	       url:"/biz/adoption/findOne",
	       data:{adoptionRecordId:Id},
	       dataType:"json",
           success:function (res) {
           	 if(res.status==200){
           		var adoption=res.data;
           		$("#lysj").val(adoption.adoptionTime);
           		$("#lyr").val(adoption.applyerName);
           		var card='';
                if(adoption.cardType==0){
                	card="身份证";
                }else if(adoption.cardType==1){
                	card="房产证";
                }else if(adoption.cardType==2){
                	card="营业执照";
                }else{
                	card="其他";
                }
           		$("#lyzjlx").val(card);
           		$("#lyzjhm").val(adoption.cardNumber);
           		$("#lylxdh").val(adoption.applyerPhone);
           		$("#lyyqdz").val(adoption.adoptionAddress);
           		$("#lybz").val(adoption.remark);
           	 }
           }
       })
}
