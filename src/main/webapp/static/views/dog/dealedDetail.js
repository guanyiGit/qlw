$(function () {
	var collectionId=window.sessionStorage.getItem("collectionId");
	var handleId=window.sessionStorage.getItem("handleId");
	//查收容详情
	selectDetail(collectionId);
	//查认领详情
	selectHandleDetail(handleId);
	
});

/*//查看犬只收容详情
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
*/
function selectHandleDetail(Id){
	 $.ajax({
	        type:"get",
	        url:"/biz/collection/findHandleCollectionById",
	        data:{handleId:Id},
	        dataType:"json",
	        success:function (res) {
           	 if(res.status==200){
           		 console.log(handle);
           		var handle=res.data;
           		$("#rlsj").val(timeStamp2String(handle.handleTime));
           		$("#clfs").val(handle.claimName);
           		$("#clyy").val(handle.cardType);
           		$("#clbz").val(handle.cardNum);
           	 }
           }
	  })
}