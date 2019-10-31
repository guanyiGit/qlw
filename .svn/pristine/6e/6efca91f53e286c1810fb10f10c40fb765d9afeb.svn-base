var model={
	data:null
}


$(function () {
    $(document).on("show.bs.modal", ".modal", function(){
        $(this).draggable();
        $(this).css("overflow-y", "scroll");
        // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
    });
    //初始化表格
    oTableInit();
    
    //模糊查询
    $("#ss").click(function(){
    	refersh();
    }); 
    //批量删除
    $("#delete").click(function(){
    	var blackIdList=[];
    	 //获取所有被选中的记录
        var rows = $("#blankListFileTable").bootstrapTable('getSelections');
        if (rows.length== 0) {
        	bootbox.alert("请至少选择一项!") 
            return;
        }
        for (var i = 0; i < rows.length; i++) {
            blackIdList.push(rows[i]['blackId']);
        }
    	deletee(blackIdList);
    });
    
    $("#add").click(function(){
    	 $("#master").hide();
    	 $("#detail").show();
    	 $("#tital").text("新增");
    	 $("#cansle").show();
		 $("#save").show();
    	 $("#detail input[type='text']").val('');
    	 $("#detail textarea").val('');
    	 $("#detail input[type='radio']").attr("checked",false);
    	 $("#detail option").removeAttr("disabled");
    	 $("#detail input[type='text']").removeAttr("readonly");
 		 $("#detail input[type='radio']").removeAttr("onclick");
 		 $("#detail textarea").removeAttr("readonly");
    });
    //保存
    $("#save").click(function(){
    	//校验名字
    	if($("#xm").val()==''){
    		bootbox.alert("姓名不能为空") 
    		return false;
    	}
    	save();
    });
    //返回
    $("#cansle").click(function(){
    	$("#master").show();
    	$("#detail").hide();
    	//初始化表格
        oTableInit();
    });
    
    $("#yb").blur(function(){
	  	  //获取邮政编码
	  	  var postcode=$("#yb").val();
	  	  if(postcode!=''){
	  		  if(!is_postcode(postcode)){
	  			bootbox.alert("邮编格式不正确");
	  			  return false;
	  		  }
	  	  }
  	 });
  	 //验证手机号码
  	 $("#lxdh").blur(function(){
	  	  //获取手机号,并去除左右两边空格
	  	  var mobile=$.trim($("#lxdh").val());
	  	 if(mobile!=''){
	  		 if(!is_mobile(mobile)){
	  			bootbox.alert("手机号格式不正确");
	  			 return false;
	  		 }
	  	 }
  	 });
  	 //验证email
  	 $("#dzyx").blur(function(){
	  	  //获取email
	  	  var email=$("#dzyx").val();
	  	  if(email!=''){
	  		  if(!is_email(email)){
	  			bootbox.alert("电子邮件格式不正确");
	  			  return false;
	  		  }
	  	  }
  	 });

    
  	 $("#hmd").click(function(){
  		$("#master").show();
  		$("#detail").hide();
  		 oTableInit();
  	 });
    
});

	//模糊查询
	function refersh(){
		 $('#blankListFileTable').bootstrapTable('refresh',  {
	        	query:{
	        		string:$(".search-container input").val()
	        	}
	        });
	}

   function oTableInit(){
	   $("#blankListFileTable").bootstrapTable('destroy'); 
        $('#blankListFileTable').bootstrapTable({
             url: '/biz/balck/findAll',         //请求后台的URL（*）
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
                field: 'blackName',
                title: '姓名',
                align:'center',
                valign:"middle"
            }, {
            	field: 'cardType',
            	title: '证件类型',
            	 align:'center',
                 valign:"middle",
            	formatter:function(value, row, index){
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
            }, 
              {
                field: 'cardNum',
                title: '证件号码',
                align:'center',
                valign:"middle"
            }, {
                field: 'phone',
                title: '联系电话',
                align:'center',
                valign:"middle"
            }, {
                field: 'joinCause',
                title: '列入黑名单原因',
                align:'center',
                valign:"middle"
            }, {
                field: 'operate',
                title: '操作',
                align:'center',
                valign:"middle",
                events:operateEvents,
                formatter: operateFormatter
            }],
            onLoadSuccess:function(data){
            	if(data!=null){
            		$(".pull-right").css("display", "block");
            	}
            },
            onLoadError:function(status){
            	console.log(status);
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
			formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return "当前第 " + pageFrom + " 页，共 " + totalRows + " 条";
            },
            formatNoMatches: function () {
                return "没有数据";
            },
            formatRecordsPerPage: function (pageNumber) {
                // console.log($(e).text())
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

   window.operateEvents = {
   		//查询详情
   		'click .RoleOfA': function(e, value, row, index) {
   			 //$("#home").load("views/blanklist/blankListDetail.html");
   			//存黑名单id
   			//window.sessionStorage.setItem("blackId", row.blackId);
			 $("#master").hide();
			 $("#detail").show();
			 $("#cansle").show();
			 $("#save").hide();
			 $("#tital").text("查看详情");
			 
   			selectDetail(row.blackId);
   		},
   		//移除
   		'click .RoleOfB': function(e, value, row, index) {
   			var blackIdList=[];
   			blackIdList.push(row.blackId);
   			deletee(blackIdList);
   		},	
   	
   		
   };
   
   function operateFormatter(value, row, index) {
   	return [
   	        '<a class="RoleOfA " style="cursor: pointer">查看详情</a>',
   	        '<br/>',
   	        '<a class="RoleOfB " style="cursor: pointer">移除</a>'
   	        ].join('');
   }
  
//移除
function deletee(blackIdList){
	bootbox.confirm("确定删除吗?", function(ok){
		if(ok){
			$.ajax({
				type:"get",
				url:"/biz/balck/remove",
				data:{"blackIdList":blackIdList},
				traditional: true,
				dataType:"json",
				success:function (result) {
					oTableInit();
				}
			})
		}
	})
}

//获得页面数据
function getObject(){
	var BlankList={
			blackName:$("#xm").val(),//姓名
			cardType:$("#zjlx option:selected").val(),//证件类型
			cardNum:$("#zjhm").val(),//证件号码
			sex:$("#xb input:checked").val(),//性别
			birthData:$("#csrq").val(),//出生日期
			county:$("#xzqx").val(),//区县
			dep:$("#ssbm").val(),//部门
			community:$("#sssq").val(),//社区
			postcode:$("#yb").val(),//邮编
			phone:$("#lxdh").val(),//电话
			email:$("#dzyx").val(),//邮件
			address:$("#xxdz").val(),//地址
			joinCause:$("#lryy").val(),//加入黑名单原因
			remark:$("#bz").val()//备注
	}
	model.data=BlankList;
}

//保存
function save(){
	getObject();
	 $.ajax({
	        type:"post",
	        url:"/biz/balck/save",
	        data:JSON.stringify(model.data),
	        dataType:"json",
	        contentType:"application/json",
	        success:function (res) {
	        	if(res.status==200){
	        		bootbox.alert("保存成功");
	        	}
	        	
	        }
	    })
}

//查询犬主详情
function selectDetail(Id){
    $.ajax({
        type:"get",
        url:"/biz/balck/findOne",
        data:{blackId:Id},
        dataType:"json",
        success:function (res) {
        	if(res.status==200){
        		$("#detail input[type='text']").attr("readonly","readonly");
        		$("#detail input[type='radio']").attr("onclick","return false");
        		$("#detail option").attr("disabled","disabled");
        		$("#detail textarea").attr("readonly","readonly");
        		var data=res.data;
        		$("#xm").val(data.blackName);//姓名
        		var numbers = $("#zjlx").find("option"); //获取select下拉框的所有值
        		for (var j = 1; j < numbers.length; j++) {
	        		if ($(numbers[j]).val() == data.cardType) {
	        			$(numbers[j]).attr("selected", "selected");
	        		}
        		} 
        		//$("#zjlx option").val(cardType);//证件类型
        		$("#zjhm").val(data.cardNum);//证件号码
        		if(data.sex==0){
        			$("#xb1").attr("checked","checked");
        		} else {
	        		$("#xb2").attr("checked","checked");
	        	}
	        	
        		//$("#xb").val(data.sex==0?"男":"女");//性别
        		$("#csrq").val(timeStamp2String(data.birthData));//出生日期
        		$("#xzqx").val(data.county);//区县
        		$("#ssbm").val(data.dep);//部门
        		$("#sssq").val(data.community);//社区
        		$("#yb").val(data.postcode);//邮编
        		$("#lxdh").val(data.phone);//电话
        		$("#dzyx").val(data.email);//邮件
        		$("#xxdz").val(data.address);//地址
        		$("#lryy").val(data.joinCause);//加入黑名单原因
        		$("#bz").val(data.remark);//备注
        	}
        }
    })
}


$("#so").keydown(function(e) {
	if (e.keyCode == 13) {
		refersh();
	}
});






