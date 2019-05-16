$(function () {
	var collectionId=window.sessionStorage.getItem("collectionId");
	var adoptionPublicityId=window.sessionStorage.getItem("adoptionPublicityId");
	var adoptionRecordsId=window.sessionStorage.getItem("adoptionRecordsId");
	selectDetail(collectionId);
	initTable7(adoptionPublicityId);
	
	//重新发布
	$("#cxfb").click(function(){
		var AdoptionRecordList=[];
		 var obj={
	    			adoptionRecordsId:adoptionRecordsId,
	   				dogPublicityId:adoptionPublicityId
	   			}
	    	   AdoptionRecordList.push(obj);
		      againPublish(AdoptionRecordList);
	});
	//撤回到收容所
	$("#chsr").click(function(){
		var AdoptionCollectionVOList=[];
		 var obj={
	   				collectionId:collectionId,
	   				adoptionPublicityId:adoptionPublicityId
	   			}
	    	   AdoptionCollectionVOList.push(obj);
		 	   revocationBatch(AdoptionCollectionVOList);
	});
});


//重新发布
function againPublish(data){
	bootbox.confirm("确定重新发布吗?", function(ok){
		if(ok){
			$.ajax({
				type:"post",
				url:"/biz/adoption/againPublish",
				data:{"AdoptionRecordListStr":JSON.stringify(data)},
				dataType:"json",
				success:function (result) {
					if(result.status==200){
						bootbox.alert("操作成功");
					}else{
						bootbox.alert("操作失败");
					}
				}
			})
		}
	})
}

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
					}else{
						bootbox.alert("操作失败");
					}
				}
			})
		}
	})
}


//待确认领养
function initTable7(adoptionPublicityId){
	$("#sureAdoptionTable").bootstrapTable('destroy'); 
    $('#sureAdoptionTable').bootstrapTable({
         url: '/biz/adoption/findTAdoptionApply',         //请求后台的URL（*）
         method: 'get',                      //请求方式（*）
         //toolbar: '#toolbar',
        dataType:"json",               		//工具按钮用哪个容器
        sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: false,                  //是否显示所有的列
        showRefresh: false,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,   				//是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",							//每一行的唯一标识，一般为主键列
        queryParams: function(params){
        	return{
                adoptionPublicityId:adoptionPublicityId
        	}
        },  //传递参数（*）
        columns: [{
            checkbox: true,
            width:'5%'
        }, {
            field: 'applyerName',
            title: '姓名',
            align:"center",
            valign:"middle"	,
            width:'13%'
        }, {
            field: 'applyerSex',
            title: '性别',
            align:"center",
            valign:"middle", width:'13%',
            formatter: function (value, row) {
                return (value==0)?"男":"女";
            }
        }, {
            field: 'cardType',
            title: '证件类型',
            align:"center",
            valign:"middle", width:'13%',
        	formatter: function (value, row) {
        		var cardType='';
                if(value==0){
                	cardType="身份证";
                }else if(value==1){
                	cardType="房产证";
                }else if(value==2){
                	cardType="营业执照";
                }else{
                	cardType="其他";
                }
                return cardType;
            }	 
        },{
            field: 'cardNumber',
            title: '证件号码',
            align:"center",
            valign:"middle", width:'13%',
        },{
            field: 'applyerPhone',
            title: '联系电话',
            align:"center",
            valign:"middle", width:'13%',
        },{
            field: 'applyerPhone',
            title: '申请时间',
            align:"center",
            valign:"middle", width:'13%',
            formatter: function (value, row) {
                return timeStamp2String(value);
            }
        },{
            field: 'operator',
            title: '操作',
            align:"center",
            valign:"middle", width:'13%',
            events:operateEvents,
            formatter:operateFormatter
        }],
        formatNoMatches: function(){
            return "没有相关的匹配结果";
        },
        formatLoadingMessage: function(){
            // return "请稍等，正在加载中。。。";
            return "";
        },
        responseHandler:function(result){ //格式化数据
        	if(result.data!=null){
        		return {
        			data:result.data
        		};
        	}
        },
    });
}

function operateFormatter(value, row, index) {
	return [
	        '<a class="detail"  style="cursor: pointer" href="javascript:void(0)">确认领养</a>'
	        ].join('');
};

window.operateEvents = {
		//确认领养
		'click .detail': function(e, value, row, index) {
			 var obj={
						collectionId:row.collectionId,
						dogPublicityId:row.dogPublicityId,
		 	   			adoptionRecordsId:row.adoptionRecordsId
					}
		 	  applySuer(obj);
		}
};

//确认领养
function applySuer(data){
	bootbox.confirm("确定领养吗?", function(ok){
		if(ok){
			$.ajax({
				type:"get",
				url:"/biz/adoption/applySuer",
				data:data,
				dataType:"json",
				contentType: "application/x-www-form-urlencoded",
				success:function (result) {
					
				}
			})
		}
	})
}
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