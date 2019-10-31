var model={
		dogId:10101570,
		dogOwnerId:null,
		operatorId:null,
		districtId:null,
		orgId:null,
		data:null,
		user:null
}


$(function () {
	var user=JSON.parse(sessionStorage.getItem("user"));
	model.orgId=user.organizationId;
	model.operatorId=user.userId;
	model.districtId=user.districtId;
    $(document).on("show.bs.modal", ".modal", function(){
        $(this).draggable();
        $(this).css("overflow-y", "scroll");
        // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
    });
    //初始化表格
    oTableInit();

    //迷糊查询
    $("#ss").click(function(){
    	refersh();
    });
    
    //回车事件
    $("#so").keydown(function(e) {
    	if (e.keyCode == 13) {
    		refersh();
    	}
    });

    
    //通过项圈编码查当前积分及犬id、犬主id
    $("#qzbsh").blur(function(){
    	var num=$.trim($("#qzbsh").val());
    	if(num==''){
    		bootbox.alert("犬只标识不能为空");
    		return false;
    	}
    	selectpointByNum(num);
    });
   
    //show出违法登记
    $("#add").click(function(){
    	InitViolationType();
    	$("#violationShow").show();
    	$("#master").hide();
    	$("#detail").hide();
    });
    
    //确定违法登记
    $("#save").click(function(){
    	if($("#qzbsh").val()==''){
    		bootbox.alert("犬只标识不能为空");
    		return false;
    	}
    	if($("#wfsj").val()==''){
    		bootbox.alert("违法时间不能为空");
    		return false;
    	}
    	if($("#wfdd").val()==''){
    		bootbox.alert("违法地点不能为空");
    		return false;
    	}
    	if($("#sfsr input[type='radio']:checked").val()==null){
    		bootbox.alert("请选择是否收容");
    		return false;
    	}
    	if($("#cfsj").val()==''){
    		bootbox.alert("处罚时间不能为空");
    		return false;
    	}
    	//校验分数
    	if($.trim($("#bckf").val())!=''){
    		if(!isNonnegativeInteger($("#bckf").val())){
    			bootbox.alert("本次扣分填写有误");
    			return false;
    		}
    	}
    	save();
    });
    
    //取消违法登记
    $("#cansle").click(function(){
    	$("#violationShow").hide();
    	$("#master").show();
    	$("#detail").hide();
    	oTableInit();
    });
    
    //查看历史违法记录
    $("#lsjl").click(function(){
    	var num=$.trim($("#qzbsh").val());
    	if(num==''){
    		bootbox.alert("犬只标识不能为空");
    		return false;
    	}
    	if(model.dogId==null){
    		bootbox.alert("查无此犬");
    		return false;
    	}
    	$("#suspension").show();
    	$("#popupWindow").show();
    	selectPastNote();
    });
    
    //取消查看历史违法记录
    $("#cansle3").click(function(){
    	$("#suspension").hide();
    	$("#popupWindow").hide();
    });
    
    
    //取消查看详情
    $("#cansle1").click(function(){
    	$("#more").show();
    	$("#moreDetail").hide();
    	$("#violationShow").hide();
    	$("#master").show();
    	$("#detail").hide();
    });
    //查看更多
    $("#more").click(function(){
    	$("#more").hide();
    	$("#violationShow").hide();
    	$("#master").hide();
    	$("#detail").show();
    	$("#moreDetail").show();
    	var data={
    			dogId:model.dogId,
    			cardNum:null
    	}
    	more(data);
    });
});

//违法行为
function InitViolationType(){
	   $.ajax({
	        type:"get",
	        url:"/biz/adoption/selectdogPro",
	        data:{logg:4},
	        dataType:"json",
	        success:function (res) {
	        		if(res.length!=0){
	        			for(var i=0;i<res.length;i++){
	        				var option=$('<option></option>');
	        				option.val(res[i].value);
	        				option.text(res[i].name);
	        				$("#wfxw").append(option);
	        			}
	        		}
	        }
	    })
}





//通过项圈编码查当前积分及犬id、犬主id
function selectpointByNum(num){
	 $.ajax({
	        type:"get",
	        url:"/biz/violationPunish/findDeviceDogVoByDeviceCode",
	        data:{deviceNumber:num},
	        dataType:"json",
	        //contentType:"application/json",
	        success:function (res) {
	        	if(res.status==200 && res.data!=null){
	        		$("#jf").text(res.data.deductionSum);
	        		model.dogId=res.data.dogId;
	        		model.dogOwnerId=res.data.dogOwnerId;
	        	}else{
	        		bootbox.alert("查无此犬");
	        		return;
	        	}
	        }
	    })
}


//获得页面数据
function getViolationObj(){
		var violation={
				violationDate:$.trim($("#wfsj").val()),
				violationPlace:$.trim($("#wfdd").val()),
				violationType:$("#wfxw option:checked").val(),
				points:$.trim($("#bckf").val()),
				isCollection:$.trim($("#sfsr input[name='shourong']:checked").val()),
				punishTime:$.trim($("#cfsj").val()),
				dogId:model.dogId,
				dogOwnerId:model.dogOwnerId,
				orgId:model.orgId,
				operatorId:model.operatorId,
				districtId:model.districtId
		}
		model.data=violation;
}

//保存违法登记
function save(){
	getViolationObj();
	 $.ajax({
	        type:"post",
	        url:"/biz/violationPunish/save",
	        data:JSON.stringify(model.data),
	        dataType:"json",
	        contentType:"application/json",
	        success:function (res) {
	        	if(res.status==200){
	        		bootbox.alert("添加成功");
	        		$("#violationShow input[type='text']").val('');
	        		$("#jf").text('');
	        	}else{
	        		bootbox.alert("添加失败");
	        	}
	        }
	    })
}

//模糊查询
function refersh(){
	 $('#dogViolationTable').bootstrapTable('refresh',  {
        	query:{
        		string:$("#so input").val()
        	}
        });
}

//违法列表
function oTableInit(){
	  $("#dogViolationTable").bootstrapTable('destroy'); 
     $('#dogViolationTable').bootstrapTable({
          url: '/biz/violationPunish/findAll',         //请求后台的URL（*）
          method: 'get',                      //请求方式（*）
          toolbar: '#toolbar',
         dataType:"json",               		//工具按钮用哪个容器
        // striped: true,                      //是否显示行间隔色
         cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
         pagination: true,                   //是否显示分页（*）
      //   sortable: true,                     //是否启用排序
      //   sortOrder: "asc",                   //排序方式
         sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
         pageNumber:1,                       //初始化加载第一页，默认第一页
         pageSize: 10,                       //每页的记录行数（*）
         pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
         search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
       //  strictSearch: true,
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
             field: 'violationDate',
             title: '违法时间',
             align:"center",
             valign:"middle",
            formatter:function(value){
            	return timeStamp2String(value);
            }	 
         }, {
         	field: 'violationType',
         	title: '违法行为',
         	align:"center",
            valign:"middle"
         }, 
           {
             field: 'dogOwnerName',
             title: '犬主',
             align:"center",
             valign:"middle",
             formatter:function(value, row, index){
            	 var buffer = new StringBuffer();
                 buffer.append(row.dogOwnerName);
                 buffer.append("<br>");
                 buffer.append(row.dogOwnerPhone);
                 return buffer.toString();
             }
         }, {
             field: 'deviceNumber',
             title: '犬只标识号',
             align:"center",
             valign:"middle"
         }, {
             field: 'points',
             title: '本次扣分',
             align:"center",
             valign:"middle"
         }, 
          {
        	 field: 'isCollection',
        	 title: '是否收容',
        	 align:"center",
             valign:"middle",
        	 formatter:function(value, row, index){
        		 if(value!=null){
        			if(value==0){
        				return "是";
        			}else{
        				return "否";
        			}
        		 }
        	 }
         }, {
             field: 'operate',
             title: '操作',
             align:"center",
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
			$("#violationShow").hide();
	    	$("#master").hide();
	    	$("#detail").show();
			selectDetail(row);
		}
		/*//发消息
		'click .RoleOfB': function(e, value, row, index) {
			
		},	*/
	
		
};
function operateFormatter(value, row, index) {
	return [
	        '<a  class="RoleOfA" style="cursor: pointer">查看详情</a>',
	       /* '<br/>',
	        '<a id="btn_msg"   class="RoleOfB ">发消息</a>'*/
	        ].join('');
}






function selectPastNote(){
	 $("#dogViolationPassTable").bootstrapTable('destroy'); 
	 $('#dogViolationPassTable').bootstrapTable({
         url: '/biz/violationPunish/findViolationPunishListByDogId',         //请求后台的URL（*）
         method: 'get',                      //请求方式（*）
         //toolbar: '#toolbar',
        dataType:"json",               		//工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
      //  pagination: true,                   //是否显示分页（*）
       // sortable: true,                     //是否启用排序
      //  sortOrder: "asc",                   //排序方式
       // sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
      //  strictSearch: true,
        showColumns: false,                  //是否显示所有的列
        showRefresh: false,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,   				//是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",							//每一行的唯一标识，一般为主键列
        queryParams: function(params){
        	return{
        		dogId:model.dogId
        	}
        },  //传递参数（*）
        columns: [{
          //  checkbox: true
        }, {
            field: 'violationDate',
            title: '违法时间',
        }, {
        	field: 'violationPlace',
        	title: '违法地点',
        },
		  {
			 field: 'dictionaryDescribe',
			 title: '违法行为',
		 },
		 {
			 field: 'points',
			 title: '本次扣分',
		 },
         {
       	 field: 'isCollection',
       	 title: '是否收容',
       	 formatter:function(value, row, index){
       		 if(value!=null){
       			if(value==0){
       				return "是";
       			}else{
       				return "否";
       			}
       		 }
       	 }
        }],
        onLoadError:function(status){
        	console.log(status);
        },
        formatLoadingMessage: function(){
            // return "请稍等，正在加载中。。。";
            return "";
        },
        responseHandler:function(result){ //格式化数据
        	if(result.data!=null){
        		return {
        			data : result.data //行数据，前面的key要与之前设置的dataField的值一致.
        		};
        	}else{
        		return {
        			data : []
        		};
        	}
        },
    });
}

//查询违法详情
function selectDetail(data){
	console.log(data);
	$("#detail input[type='text']").attr("readonly","readonly");
	$("#detail input[type='radio']").attr("onclick","return false");
	$("#detail textarea").attr("readonly","readonly");
	//犬只犬主信息
    $("#qm").val(data.dogName);//犬名
    $("#pz").val(data.dogBreed);//品种
    $("#xb").val(data.dogGender==0?"雄":"雌");//性别
    $("#ql").val(getdogAge(data.birthTime));//犬龄
    $("#csrq").val(timeStamp2String(data.birthTime));//出生日期
    $("#ms").val(data.dogColor);//毛色
    $("#qzh").val(data.dogCardNum);//犬证号
    $("#bsh").val(data.deviceNumber);//标识号
    $("#oxm").val(data.dogOwnerName);//犬主姓名
    $("#sfzh").val(data.cardNum);//身份证号
    $("#pic").attr("src",data.thumbnailUrl);//犬图
    //违法详情
    $("#wfsj1").val(timeStamp2String(data.violationDate));//违法时间
    $("#wfdd1").val(data.violationPlace);//违法地点
    $("#wfxw1").val(data.violationType);//违法地点
    $("#bckf1").val(data.points);//本次扣分
    if(data.isCollection==0){//是否收容
		$("#sy1").attr("checked","checked");
	} else {
		$("#sy2").attr("checked","checked");
	}
    $("#cfsj1").val(timeStamp2String(data.punishTime));//处罚时间
    $("#bz1").val(data.remarks);//备注
}


//查询更多
function more(data){
    $.ajax({
        type:"get",
        url:"/biz/dogCard/selectDogCardInfo",
        data:data,
        dataType:"json",
        success:function (res) {
        	var result=res.result;
            var immuneCard=result.immuneCard;//免疫证
            var dogCard=result.dogCard;//犬信息
            var device=result.device;//设备
            var dogOwners=result.dogOwners;//犬主信息
            /*免疫证件信息*/
            $("#myzh").val(immuneCard.immuneCardNum);//免疫证号
            $("#qfjg1").val(immuneCard.orgName);//免疫证签发机构
            $("#qfrq1").val(timeStamp2String(immuneCard.lssueTime));//免疫证签发日期
            $("#Syxqx1").val(timeStamp2String(immuneCard.startTime));//免疫证开始日期
            $("#Eyxqx1").val(timeStamp2String(immuneCard.endTime));//免疫证结束日期
            /*犬证信息*/
            $("#qzhm").val(dogCard.dogCardNum);//犬证号码
            $("#qfjg2").val(dogCard.orgName);//犬证签发机构
            $("#qfrq2").val(timeStamp2String(dogCard.lssueTime));//犬证签发日期
            $("#Syxqx2").val(timeStamp2String(dogCard.startTime));//犬证开始日期
            $("#Eyxqx2").val(timeStamp2String(dogCard.endTime));//犬证结束日期
            /*项圈信息*/
            $("#xqbh").val(device.deviceNumber);//项圈编号
            $("#qfjg3").val(device.orgName);//项圈签发机构
            $("#qfrq3").val(timeStamp2String(device.productionTime));//项圈签发日期
            $("#Syxqx3").val(timeStamp2String(device.startTime));//项圈开始日期
            $("#Eyxqx3").val(timeStamp2String(device.endTime));//项圈结束日期
            /*犬主信息*/
            $("#qzxm").val(dogOwners.dogOwnerName);//犬主姓名
            $("#xz").val((dogOwners.dogOwnerType==1)?"企业":"个人");//性质
            var cardType;
            if(dogOwners.cardType==0){
            	cardType="身份证";
            }else if(dogOwners.cardType==1){
            	cardType="房产证";
            }else if(dogOwners.cardType==2){
            	cardType="营业执照";
            }else{
            	cardType="其他";
            }
            $("#zjlx").val(cardType);//证件类型
            $("#zjhm").val(dogOwners.cardNum);//证件号码
            $("#qzxb").val((dogOwners.sex==0)?"男":"女");//性别
            $("#qzqsrq").val(timeStamp2String(dogOwners.birthDate));//出生日期
            $("#xzxq").val(dogOwners.districtName);//现住区县
            $("#ssbm").val(dogOwners.orgName);//所属部门
            $("#sssq").val(dogOwners.community);//所属社区
            $("#yb").val(dogOwners.postalCode);//邮编
            $("#dh").val(dogOwners.dogOwnerPhone);//联系电话
            $("#dz").val(dogOwners.address);//信息地址
        }
    })
}


