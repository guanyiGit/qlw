var model={
		collectionId:null,
		dogId:null,
		operatorId:null
}

$(function () {
	var user=JSON.parse(sessionStorage.getItem("user"));
	model.operatorId=user.userId;
    $(document).on("show.bs.modal", ".modal", function(){
        $(this).draggable();
        $(this).css("overflow-y", "scroll");
        // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
    });
//===========================================================================================   
    //初始化table1
    initTable1();
    //模糊查询
    $("#ss1").click(function(){
    	refersh1();
    }); 
    //跳转到收容登记
    $("#srdj").click(function(){
    	$("#home").load("views/dog/registrationAndRegistration.html");
    });
    
    //批量发布到领养平台
    $("#fblypt").click(function(){
    	var collectionIdList=[];
   	 	//获取所有被选中的记录
       var rows = $("#dogFileTable1").bootstrapTable('getSelections');
       if (rows.length== 0) {
       	bootbox.alert("请至少选择一项!") 
           return;
       }
       for (var i = 0; i < rows.length; i++) {
    	   collectionIdList.push(rows[i]['collectionId']);
       }
       publishBatch(collectionIdList);
    });
    
    //认领登记
    $("#rllxdh").blur(function(){
    	var rllxdh=$.trim($("#rllxdh").val());
    	if(rllxdh !=''){
    		if(!is_mobile(rllxdh)){
    			bootbox.alert("联系电话格式不正确");
    		}
    	}
    });
    $("#save1").click(function(){
    	//校验数据
    	if($.trim($("#rlr").val())==''){
    		bootbox.alert("认领人不能为空");
    		return false;
    	}
    	if($.trim($("#rlzjhm").val())==''){
    		bootbox.alert("证件号码不能为空");
    		return false;
    	}
    	claim();
    });
    
    //领养登记
    $("#lylxdh").blur(function(){
    	var lylxdh=$.trim($("#lylxdh").val());
    	if(lylxdh !=''){
    		if(!is_mobile(lylxdh)){
    			bootbox.alert("联系电话格式不正确");
    		}
    	}
    });
    $("#save2").click(function(){
    	//校验数据
    	if($.trim($("#lyr").val())==''){
    		bootbox.alert("领养人不能为空");
    		return false;
    	}
    	if($.trim($("#lyzjhm").val())==''){
    		bootbox.alert("证件号码不能为空");
    		return false;
    	}
    	adoption();
    });
    
    //处理登记
    $("#save3").click(function(){
    	if($.trim($("#clfs").val())==''){
    		bootbox.alert("处理方式不能为空");
    		return false;
    	}
    	if($.trim($("#clyl").val())==''){
    		bootbox.alert("处理原因不能为空");
    		return false;
    	}
    	handle();
    });
//===========================================================================================  
    //初始化table2
    initTable2();
    $("#ss2").click(function(){
    	refersh2();
    });
    //批量撤回到收容平台
    $("#plch").click(function(){
    	var AdoptionCollectionVOList=[];
   	 	//获取所有被选中的记录
       var rows = $("#dogFileTable2").bootstrapTable('getSelections');
       if (rows.length== 0) {
       	bootbox.alert("请至少选择一项!") 
           return;
       }
       for (var i = 0; i < rows.length; i++) {
    	   var obj={
   				collectionId:rows[i]['collectionId'],
   				adoptionPublicityId:rows[i]['adoptionPublicityId']
   			}
    	   AdoptionCollectionVOList.push(obj);
       }
       revocationBatch(AdoptionCollectionVOList);
    });
//===========================================================================================
    //初始化table3
    initTable3();
    $("#ss3").click(function(){
    	refersh3();
    });
    //领养确认
    $("#save7").click(function(){
    	var rows = $("#sureAdoptionTable").bootstrapTable('getSelections');
        if (rows.length== 0) {
        	bootbox.alert("请选择一项!") 
            return;
        }
        if (rows.length>1) {
        	bootbox.alert("请选择一项!") 
        	return;
        }
 	   var obj={
				collectionId:rows[0]['collectionId'],
				dogPublicityId:rows[0]['adoptionPublicityId'],
 	   			adoptionRecordsId:rows[0]['adoptionRecordsId']
			}
 	  applySuer(obj);
    });
    
    //批量撤回到收容平台
    $("#plch1").click(function(){
    	var AdoptionCollectionVOList=[];
   	 	//获取所有被选中的记录
       var rows = $("#dogFileTable3").bootstrapTable('getSelections');
       if (rows.length== 0) {
       	bootbox.alert("请至少选择一项!") 
           return;
       }
       for (var i = 0; i < rows.length; i++) {
    	   var obj={
   				collectionId:rows[i]['collectionId'],
   				adoptionPublicityId:rows[i]['adoptionPublicityId']
   			}
    	   AdoptionCollectionVOList.push(obj);
       }
       revocationBatch(AdoptionCollectionVOList);
    });
    
    //重新发布
    $("#cxfb").click(function(){
    	var AdoptionRecordList=[];
   	 	//获取所有被选中的记录
       var rows = $("#dogFileTable3").bootstrapTable('getSelections');
       if (rows.length== 0) {
       	bootbox.alert("请至少选择一项!") 
           return;
       }
       for (var i = 0; i < rows.length; i++) {
    	   var obj={
    			adoptionRecordsId:rows[i]['adoptionRecordsId'],
   				dogPublicityId:rows[i]['adoptionPublicityId']
   			}
    	   AdoptionRecordList.push(obj);
       }
       againPublish(AdoptionRecordList);
    });
//=============================================================================     
    //初始化table4
    initTable4();
    $("#ss4").click(function(){
    	refersh4();
    });
    //初始化table5
    initTable5();
    $("#ss5").click(function(){
    	refersh5();
    });
    //初始化table6
   initTable6();
   $("#ss6").click(function(){
   		refersh6();
   });
});

//批量发布到领养平台
function publishBatch(collectionIdList){
	bootbox.confirm("确定发布吗?", function(ok){
		if(ok){
			$.ajax({
				type:"get",
				url:"/biz/adoption/publishBatch",
				data:{"collectionIdList":collectionIdList},
				traditional: true,
				dataType:"json",
				success:function (result) {
					initTable1();
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
						initTable2();
					}else{
						bootbox.alert("操作失败");
					}
				}
			})
		}
	})
}


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
						initTable3();
					}else{
						bootbox.alert("操作失败");
					}
				}
			})
		}
	})
}


//同一条用方法
function myutil(pic,name,sex,age,breed,hairColor,NO) {////name,sex,age,breed,hairColor,NO  分别表示 犬名 性别 犬龄 品种 毛色 犬只/犬舍编号
    var buffer = new StringBuffer();
    buffer.append('<div  class="row" style="width: 400px;height: 120px;">');
    buffer.append('<div class="col-sm-4">');
    buffer.append('<img src="'+pic+'" style="width:120px;height:120px">');
    buffer.append('</div>');
    buffer.append('<div class="col-sm-8" style="height: 100%;line-height: 40px" >');
    buffer.append('<table  style="width:100%" >');//width: 170px;height: 60px
    buffer.append('<tr align="left">');
    buffer.append('<th  colspan="12">'+name+'</th>');
    buffer.append('<th  colspan="12">性别:'+sex+'</th>');
    buffer.append('<th  colspan="12">犬龄:'+age+'</th>');
    buffer.append('</tr>');
    buffer.append('<tr align="">');
    buffer.append('<th colspan="9" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">品种:</th>');
    buffer.append('<th colspan="9" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+ breed+'</th>');
    buffer.append('<th colspan="9" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">毛色:</th>');
    buffer.append('<th colspan="9" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+hairColor+'</th>');
    buffer.append('</tr>');
    buffer.append('<tr align="left">');
    buffer.append('<th  colspan="18" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">犬只/犬舍编号:</th>');
    buffer.append('<th  colspan="18" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+NO+'</th>');
    buffer.append('</tr>');
    buffer.append('</table>');
    buffer.append('</div>');
    buffer.append('</div>');
    return buffer.toString();
}

	//收容中模糊查询
	function refersh1(){
		 $('#dogFileTable1').bootstrapTable('refresh',  {
	        	query:{
	        		string:$("#so1 input").val()
	        	}
	        });
	}
	$("#so1").keydown(function(e) {
		if (e.keyCode == 13) {
			refersh1();
		}
	});
	
	//1.收容中列表
    function initTable1(){
    	$("#dogFileTable1").bootstrapTable('destroy'); 
        $('#dogFileTable1').bootstrapTable({
             url: '/biz/collection/findCollectionList',         //请求后台的URL（*）
             method: 'get',                      //请求方式（*）
             //toolbar: '#toolbar',
            dataType:"json",               		//工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
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
            		pageSize: params.limit,   //页面大小 
                    pn: (params.offset/params.limit)+1,  //页码 
                    status:0
            	}
            },  //传递参数（*）
            columns: [{
                checkbox: true
            }, {
                field: 'Name',
                title: '犬只',
                width:200,
                align:"center",
                formatter:function (value,row,index,field) {
                    return  myutil(row.thumbnailUrl,row.dogName,((row.dogGender==0)?"雄":"雌"),row.dogAge,row.dogBreed,row.dogColor,row.dogCode+"/"+row.doghouseNum);
                }
            }, {
                field: 'collDogReason',
                title: '收容原因',
                align:"center",
                valign:"middle"
            }, {
                field: 'collectionTime',
                title: '收容时间',
                align:"center",
                valign:"middle",
                formatter:function (value,row) {
                	return  timeStamp2String(value);
                }	
            },{
                field: 'Desc',
                title: '操作',
                align:"center",
                valign:"middle",
                events:operateEvents,
                formatter:operateFormatter
            }],
            onLoadSuccess:function(data){
                if(data!=null){
                    $(".pull-right").css("display", "block");
                }
            },
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
            			total : result.data.totalRecord, //总页数,前面的key必须为"total"
            			rows : result.data.lists //行数据，前面的key要与之前设置的dataField的值一致.
            		};
            	}else{
            		return {
            			total : 0,
            			rows : []
            		};
            	}
            }
        });
    };
    
    function operateFormatter(value, row, index) {
    	return [
    	        '<a class="RoleOfA" data-toggle="modal" data-target="#myModal" style="cursor: pointer" >认领登记</a>',
    	        '<br/>',
    	        '<a class="RoleOfB " data-toggle="modal" data-target="#myModal1" style="cursor: pointer" >领养登记</a>',
    	        '<br/>',
    	        '<a class="RoleOfC " data-toggle="modal" data-target="#myModal2" style="cursor: pointer" >处理登记</a>',
    	        '<br/>',
    	        '<a class="detail" style="cursor: pointer" href="javascript:void(0)">查看详情</a>',
    	        ].join('');
    };
    
    window.operateEvents = {
    		//认领登记
    		'click .RoleOfA': function(e, value, row, index) {
    			model.collectionId=row.collectionId;
    			model.dogId=row.dogId;
    		},
    		//领养登记
    		'click .RoleOfB': function(e, value, row, index) {
    			model.collectionId=row.collectionId;
    			model.dogId=row.dogId;
    		},
    		//处理登记
    		'click .RoleOfC': function(e, value, row, index) {
    			model.collectionId=row.collectionId;
    			model.dogId=row.dogId;
    		},
    		//查看详情
    		'click .detail': function(e, value, row, index) {
    			$("#detail").show();
    			$("#master").hide();
    			selectDetail(row.collectionId);
    		}
    
    };

 
    //认领登记
   function claim(){
	   var Object={
			   collectionId:model.collectionId,//收容id
			   dogId:model.dogId,//狗id
			   claimName:$.trim($("#rlr").val()),
			   cardType:$.trim($("#rlzjlx option:selected").val()),//证件类型
			   cardNum:$.trim($("#rlzjhm").val()),//证件号码,
			   phone:$.trim($("#rllxdh").val()),//认领人电话
			   adress:$.trim($("#rlyqdz").val()),//养犬地址
			   remark:$.trim($("#rlbz").val()),//备注
			   handleTime:$.trim($("#rlsj").val()),//认领时间
			   operatorId:model.operatorId
	   }
	   $.ajax({
	        type:"post",
	        url:"/biz/collection/claim",
	        data:Object,
	        dataType:"json",
	        contentType: "application/x-www-form-urlencoded",
	        async:false,
	        success:function (res) {
	        	if(res.status==200){
	        		bootbox.alert("操作成功");
	        		initTable1();
	        	}else{
	        		bootbox.alert("操作失败");
	        	}
	        }
	    }) 
   }
   
   
   //领养登记
   function adoption(){
	   var Object={
			   collectionId:model.collectionId,//收容id
			   applyerName:$.trim($("#lyr").val()),//领养申请人
			   applyerPhone:$.trim($("#lylxdh").val()),//电话
			   cardType:$.trim($("#lyzjlx option:selected").val()),//证件类型
			   cardNumber:$.trim($("#lyzjhm").val()),//证件号码
			   adoptionAddress:$.trim($("#lyyqdz").val()),//养犬地址
			   remark:$.trim($("#lybz").val()),//备注
			   adoptionTime:$.trim($("#lysj").val()),//领养时间
			   operatorId:model.operatorId
	   }
	   $.ajax({
	        type:"post",
	        url:"/biz/collection/adoption",
	        data:Object,
	        dataType:"json",
	        contentType: "application/x-www-form-urlencoded",
	        async:false,
	        success:function (res) {
	        	if(res.status==200){
	        		bootbox.alert("操作成功");
	        		
	        		initTable1();
	        	}else{
	        		bootbox.alert("操作失败");
	        	}
	        }
	    }) 
   }
   
   //处理登记
   function handle(){
	   var Object={
			   collectionId:model.collectionId,//收容id
			   dogId:model.dogId,//犬id
			   handleReason:$.trim($("#clfs").val()),//处理原因
			   handleTime:$.trim($("#clsj").val()),//处理时间
			   remark:$.trim($("#clbz").val()),//处理备注
			   handleWay:$.trim($("#clfs").val()),//处理方式
			   operatorId:model.operatorId
	   }
	   $.ajax({
	        type:"post",
	        url:"/biz/collection/handle",
	        data:Object,
	        dataType:"json",
	        contentType: "application/x-www-form-urlencoded",
	        async:false,
	        success:function (res) {
	        	if(res.status==200){
	        		//bootbox.alert("操作成功");
	        		//$("#home").load("views/dog/canineCollection.html");
	        		initTable1();
	        	}else{
	        		bootbox.alert("操作失败");
	        	}
	        }
	    }) 
   }
   
/* //查看犬只收容详情
   function selectDetail(Id){
          $.ajax({
           type:"get",
   	       url:"/biz/collection/findOne",
   	       data:{collectionId:Id},
   	       dataType:"json",
              success:function (res) {
              	 if(res.status==200){
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
   }*/
    
    	
	//发布中模糊查询
	function refersh2(){
		 $('#dogFileTable2').bootstrapTable('refresh',  {
	        	query:{
	        		string:$("#so2 input").val()
	        	}
	        });
	}
	$("#so2").keydown(function(e) {
		if (e.keyCode == 13) {
			refersh2();
		}
	});
    function initTable2(){
    	$("#dogFileTable2").bootstrapTable('destroy'); 
        $('#dogFileTable2').bootstrapTable({
             url: '/biz/adoption/findPublishingList',         //请求后台的URL（*）
             method: 'get',                      //请求方式（*）
             //toolbar: '#toolbar',
            dataType:"json",               		//工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
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
            		pageSize: params.limit,   //页面大小 
                    pn: (params.offset/params.limit)+1,  //页码 
            	}
            },  //传递参数（*）
            columns: [{
                checkbox: true
            }, {
                field: 'Name',
                title: '犬只',
                width:200,
                align:"center",
                formatter:function (value,row,index,field) {
                	 return  myutil(row.thumbnailUrl,row.dogName,((row.dogGender==0)?"雄":"雌"),row.dogAge,row.dogBreed,row.dogColor,row.dogCode+"/"+row.doghouseNum);
                }
            }, {
                field: 'publishDate',
                title: '发布时间',
                align:"center",
                valign:"middle",
                formatter: function (value, row) {
                    return timeStamp2String(value);
                }
            }, {
                field: 'days',
                title: '已发布时长',
                align:"center",
                valign:"middle",
                formatter: function (value, row) {
                	if(row.publishDate!=''){
                		return DateDiff(new Date().toLocaleDateString(),timeStamp2String(row.publishDate))+"天";
                	}
                }
            },{
                field: 'Desc',
                title: '操作',
                align:"center",
                valign:"middle",
                events:operateEvents1,
                formatter:operateFormatter1
            }],
            onLoadSuccess:function(data){
                if(data!=null){
                    $(".pull-right").css("display", "block");
                }
            },
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
            			total : result.data.totalRecord, //总页数,前面的key必须为"total"
            			rows : result.data.lists //行数据，前面的key要与之前设置的dataField的值一致.
            		};
            	}else{
            		return {
            			total : 0,
            			rows : []
            		};
            	}
            },
           // data:[{dogCardNum:"张三"},{dogCardNum:"李四"},{dogCardNum:"王五"}]
        });
    }
    
    function operateFormatter1(value, row, index) {
    	return [
    	        '<a class="RoleOfA " style="cursor: pointer" href="javascript:void(0)">撤回到收容库</a>',
    	        '<br/>',
    	        '<a class="RoleOfB "  style="cursor: pointer" href="javascript:void(0)">查看详情</a>'
    	        ].join('');
    };
    
    window.operateEvents1 = {
    		//撤回到收容平台
    		'click .RoleOfA': function(e, value, row, index) {
    			var AdoptionCollectionVOList=[];
    			var obj={
    				collectionId:row.collectionId,
    				adoptionPublicityId:row.adoptionPublicityId
    			}
    			AdoptionCollectionVOList.push(obj);
    			revocationBatch(AdoptionCollectionVOList);
    		},
    		//查看详情
    		'click .RoleOfB': function(e, value, row, index) {
    			window.sessionStorage.setItem("collectionId", row.collectionId);
    			window.sessionStorage.setItem("punishDate", timeStamp2String(row.publishDate));
    			
    			$("#home").load("views/dog/publishingDetail.html");
    		}
    };
    
    
	//待确认领养模糊查询
	function refersh3(){
		 $('#dogFileTable3').bootstrapTable('refresh',  {
	        	query:{
	        		string:$("#so3 input").val()
	        	}
	        });
	}
	$("#so3").keydown(function(e) {
		if (e.keyCode == 13) {
			refersh3();
		}
	});
    //待确认领养
    function initTable3(){
    	$("#dogFileTable3").bootstrapTable('destroy'); 
        $('#dogFileTable3').bootstrapTable({
             url: '/biz/adoption/findAdoptabledList',         //请求后台的URL（*）
             method: 'get',                      //请求方式（*）
             //toolbar: '#toolbar',
            dataType:"json",               		//工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
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
            		pageSize: params.limit,   //页面大小 
                    pn: (params.offset/params.limit)+1,  //页码 
                    status:1
            	}
            },  //传递参数（*）
            columns: [{
                checkbox: true
            }, {
                field: 'Name',
                title: '犬只',
                width:200,
                align:"center",
                formatter:function (value,row,index,field) {
                	return  myutil(row.thumbnailUrl,row.dogName,((row.dogGender==0)?"雄":"雌"),row.dogAge,row.dogBreed,row.dogColor,row.dogCode+"/"+row.doghouseNum);
                }
            }, {
                field: 'applyTime',
                title: '领养申请时间',
                align:"center",
                valign:"middle",
                formatter: function (value, row) {
                    return timeStamp2String(value);
                }
            }, {
                field: 'applyerName',
                title: '申请人',
                align:"center",
                valign:"middle"
            },{
                field: 'Desc',
                title: '操作',
                align:"center",
                valign:"middle",
                events:operateEvents3,
                formatter:operateFormatter3
                
            }],
            onLoadSuccess:function(data){
                if(data!=null){
                    $(".pull-right").css("display", "block");
                }
            },
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
            			total : result.data.totalRecord, //总页数,前面的key必须为"total"
            			rows : result.data.lists //行数据，前面的key要与之前设置的dataField的值一致.
            		};
            	}else{
            		return {
            			total : 0,
            			rows : []
            		};
            	}
            },
        });
    }
    function operateFormatter3(value, row, index) {
    	return [
    	        '<a   class="qrly" style="cursor: pointer" data-toggle="modal" data-target="#myModal3">确认领养</a><br>',
                '<a   class="cxfb" style="cursor: pointer">重新发布</a><br>',
                '<a   class="chsr" style="cursor: pointer">撤回到收容库</a><br>',
                '<a   class="ckxq" style="cursor: pointer">查看详情</a>',
    	        ].join('');
    };
    
    window.operateEvents3 = {
    		//确认领养
    		'click .qrly': function(e, value, row, index) {
    			 initTable7(row.adoptionPublicityId);
    		},
    		//重新发布
    		'click .cxfb': function(e, value, row, index) {
    			var AdoptionRecordList=[];
    			 var obj={
    		    			adoptionRecordsId:row.adoptionRecordsId,
    		   				dogPublicityId:row.adoptionPublicityId
    		   			}
    		    	   AdoptionRecordList.push(obj);
    			      againPublish(AdoptionRecordList);
    		},
    		//撤回到收容库
    		'click .chsr': function(e, value, row, index) {
    			var AdoptionCollectionVOList=[];
    			 var obj={
    		   				collectionId:row.collectionId,
    		   				adoptionPublicityId:row.adoptionPublicityId
    		   			}
    		    	   AdoptionCollectionVOList.push(obj);
    			 	   revocationBatch(AdoptionCollectionVOList);
    		},
    		//查看详情
    		'click .ckxq': function(e, value, row, index) {
    			window.sessionStorage.setItem("collectionId", row.collectionId);
    			window.sessionStorage.setItem("adoptionPublicityId", row.adoptionPublicityId);
    			window.sessionStorage.setItem("adoptionRecordsId", row.adoptionRecordsId);
    			$("#home").load("views/dog/pendingAdoptionDetail.html");
    		}
    
    };
    
    
    
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
                checkbox: true
            }, {
                field: 'applyerName',
                title: '姓名',
                align:"center",
                valign:"middle"	
            }, {
                field: 'applyerSex',
                title: '性别',
                align:"center",
                valign:"middle",
                formatter: function (value, row) {
                    return (value==0)?"男":"女";
                }
            }, {
                field: 'cardType',
                title: '证件类型',
                align:"center",
                valign:"middle",
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
                valign:"middle"
            },{
                field: 'applyerPhone',
                title: '联系电话',
                align:"center",
                valign:"middle"
            },{
                field: 'applyerPhone',
                title: '申请时间',
                align:"center",
                valign:"middle",
                formatter: function (value, row) {
                    return timeStamp2String(value);
                }
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

    
    //已认领模糊查询
	function refersh4(){
	 $('#dogFileTable4').bootstrapTable('refresh',  {
        	query:{
        		string:$("#so4 input").val()
        	}
        });
	}
	$("#so4").keydown(function(e) {
		if (e.keyCode == 13) {
			refersh4();
		}
	});
    //已认领
    function initTable4(){
    	$("#dogFileTable4").bootstrapTable('destroy');
        $('#dogFileTable4').bootstrapTable({
             url: '/biz/collection/findHandleCollectionList',         //请求后台的URL（*）
             method: 'get',                      //请求方式（*）
             //toolbar: '#toolbar',
            dataType:"json",               		//工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
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
            		pageSize: params.limit,   //页面大小 
                    pn: (params.offset/params.limit)+1,  //页码 
                    type:0
            	}
            },  //传递参数（*）
            columns: [{
                checkbox: true
            }, {
                field: 'Name',
                title: '犬只',
                width:200,
                align:"center",
                formatter:function (value,row,index) {
                	return  myutil(row.thumbnailUrl,row.dogName,((row.dogGender==0)?"雄":"雌"),row.dogAge,row.dogBreed,row.dogColor,row.dogCode+"/"+row.doghouseNum);
                }
            }, {
                field: 'claimName',
                title: '认领人',
                align:"center",
                valign:"middle"
               
            }, {
                field: 'handleTime',
                title: '认领时间',
                align:"center",
                valign:"middle",
	        	 formatter: function (value, row, index) {
	                 return timeStamp2String(value);
	             }
            },{
                field: 'Desc',
                title: '操作',
                align:"center",
                valign:"middle",
                events:operateEvents4,
                formatter:function () {
                    return [
                        '<a  class="ckxq " style="cursor: pointer">查看详情</a>',
                    ].join('');
                }
            }],
            onLoadSuccess:function(data){
                if(data!=null){
                    $(".pull-right").css("display", "block");
                }
            },
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
            			total : result.data.totalRecord, //总页数,前面的key必须为"total"
            			rows : result.data.lists //行数据，前面的key要与之前设置的dataField的值一致.
            		};
            	}else{
            		return {
            			total : 0,
            			rows : []
            		};
            	}
            },
        });
    }
    
    window.operateEvents4 = {
    		//查看详情
    		'click .ckxq': function(e, value, row, index) {
    			window.sessionStorage.setItem("collectionId", row.collectionId);
    			window.sessionStorage.setItem("handleId", row.handleId);
    			$("#home").load("views/dog/AdoptionDetail.html");
    		}
    
    };
    
    
    //已领养
	function refersh5(){
	 $('#dogFileTable5').bootstrapTable('refresh',  {
        	query:{
        		string:$("#so5 input").val()
        	}
        });
	}
	$("#so5").keydown(function(e) {
		if (e.keyCode == 13) {
			refersh5();
		}
	});
    function initTable5(){
    	$("#dogFileTable5").bootstrapTable('destroy');
        $('#dogFileTable5').bootstrapTable({
             url: '/biz/adoption/findAdoptabledList',         //请求后台的URL（*）
             method: 'get',                      //请求方式（*）
             //toolbar: '#toolbar',
            dataType:"json",               		//工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
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
            		pageSize: params.limit,   //页面大小 
                    pn: (params.offset/params.limit)+1,  //页码 
                    status:2
            	}
            },  //传递参数（*）
            columns: [{
                checkbox: true
            }, {
                field: 'Name',
                title: '犬只',
                width:200,
                align:"center",
                formatter:function (value,row,index) {
                	return  myutil(row.thumbnailUrl,row.dogName,((row.dogGender==0)?"雄":"雌"),row.dogAge,row.dogBreed,row.dogColor,row.dogCode+"/"+row.doghouseNum);
                }
            }, {
                field: 'applyerName',
                title: '领养人',
                align:"center",
                valign:"middle"
            }, {
                field: 'adoptionTime',
                title: '领养时间',
                align:"center",
                valign:"middle",
                formatter:function (value,row,index) {
                	return  timeStamp2String(value);
                }
            },{
                field: 'Desc',
                title: '操作',
                align:"center",
                valign:"middle",
                events:operateEvents5,
                formatter:function () {
                    return [
                        '<a class="adoption" style="cursor: pointer">查看详情</a>',
                    ].join('');
                }
            }],
            onLoadSuccess:function(data){
                if(data!=null){
                    $(".pull-right").css("display", "block");
                }
            },
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
            			total : result.data.totalRecord, //总页数,前面的key必须为"total"
            			rows : result.data.lists //行数据，前面的key要与之前设置的dataField的值一致.
            		};
            	}else{
            		return {
            			total : 0,
            			rows : []
            		};
            	}
            }
        });
    }
    
    window.operateEvents5 = {
    		//查看详情
    		'click .adoption': function(e, value, row, index) {
    			window.sessionStorage.setItem("collectionId", row.collectionId);
    			window.sessionStorage.setItem("adoptionRecordsId", row.adoptionRecordsId);
    			$("#home").load("views/dog/AdoptionedDetail.html");
    		}
    
    };
    
    
    //已处理列表
    function refersh6(){
   	 $('#dogFileTable6').bootstrapTable('refresh',  {
           	query:{
           		string:$("#so6 input").val()
           	}
           });
   	}
	$("#so6").keydown(function(e) {
		if (e.keyCode == 13) {
			refersh6();
		}
	});
    function initTable6(){
    	$("#dogFileTable6").bootstrapTable('destroy');
        $('#dogFileTable6').bootstrapTable({
             url: '/biz/collection/findHandleCollectionList',         //请求后台的URL（*）
             method: 'get',                      //请求方式（*）
             //toolbar: '#toolbar',
            dataType:"json",               		//工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
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
            		pageSize: params.limit,   //页面大小 
                    pn: (params.offset/params.limit)+1,  //页码 
                    type:1
            	}
            },  //传递参数（*）
            columns: [{
                checkbox: true
            }, {
                field: 'Name',
                title: '犬只',
                width:200,
                align:"center",
                formatter:function (value,row,index,field) {
                	return  myutil(row.thumbnailUrl,row.dogName,((row.dogGender==0)?"雄":"雌"),row.dogAge,row.dogBreed,row.dogColor,row.dogCode+"/"+row.doghouseNum);
                }
            }, {
                field: 'handleReason',
                title: '处理原因',
                align:"center",
                valign:"middle"
            }, {
                field: 'handleTime',
                title: '处理时间',
                align:"center",
                valign:"middle",
                formatter:function (value) {
                    return timeStamp2String(value);
                }
            },{
                field: 'Desc',
                title: '操作',
                align:"center",
                valign:"middle",
                events:operateEvents6,
                formatter:function () {
                    return [
                        '<a class="handle" style="cursor: pointer">查看详情</a>',
                    ].join('');
                }
            }],
            onLoadSuccess:function(data){
                if(data!=null){
                    $(".pull-right").css("display", "block");
                }
            },
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
            			total : result.data.totalRecord, //总页数,前面的key必须为"total"
            			rows : result.data.lists //行数据，前面的key要与之前设置的dataField的值一致.
            		};
            	}else{
            		return {
            			total : 0,
            			rows : []
            		};
            	}
            }
        });
    }

    window.operateEvents6 = {
    		//查看详情
    		'click .handle': function(e, value, row, index) {
    			window.sessionStorage.setItem("collectionId", row.collectionId);
    			window.sessionStorage.setItem("handleId", row.handleId);
    			$("#home").load("views/dog/dealedDetail.html");
    		}
    
    };
