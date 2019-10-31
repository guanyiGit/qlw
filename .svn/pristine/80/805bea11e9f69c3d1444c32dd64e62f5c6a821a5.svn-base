var model={
		collectionId:null,
		adoptionPublicityId:null
}

$(function () {
	var collectionId=window.sessionStorage.getItem("collectionId");
	selectDetail(collectionId);
	var punishDate=window.sessionStorage.getItem("punishDate");
	$("#fbsj").val(punishDate);
	
	//撤回收容所
	$("#chsr").click(function(){
		var AdoptionCollectionVOList=[];
		var obj={
			collectionId:model.collectionId,
			adoptionPublicityId:model.adoptionPublicityId
		}
		AdoptionCollectionVOList.push(obj);
		revocationBatch(AdoptionCollectionVOList);
	});
});


//批量撤回到收容库
function revocationBatch(AdoptionCollectionVOList){
	bootbox.confirm("确定撤回吗?", function(ok){
		if(ok){
			$.ajax({
				type:"get",
				url:"/biz/adoption/revocation",
				data:{"AdoptionCollectionStr":JSON.stringify(AdoptionCollectionVOList)},
				traditional: true,
				dataType:"json",
				success:function (result) {
					if(result.status==200){
						bootbox.alert("操作成功");
					}
				}
			})
		}
	})
}
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
         		$("#detail input[type='text']").attr("readonly","readonly");
        		$("#detail input[type='radio']").attr("onclick","return false");
        		$("#detail option").attr("disabled","disabled");
        		$("#detail textarea").attr("readonly","readonly");
           		 var dogInfo=res.data;
           		 model.collectionId=dogInfo.collectionId;
           		 model.adoptionPublicityId=dogInfo.adoptionPublicityId;
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