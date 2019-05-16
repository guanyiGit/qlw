
$(function () {
	//取犬主id
	var dogOwnerId=window.sessionStorage.getItem("dogOwnerId");
    selectDetail(dogOwnerId);
    InitMainTable(dogOwnerId);
	
});
//我的宠物
function InitMainTable(dogOwnerId){
	$("#dogDetailTable").bootstrapTable('destroy'); 
    $('#dogDetailTable').bootstrapTable({
        url: '/biz/dogAndOwner/selectMyDogs',         //请求后台的URL（*）
        method: 'get', 
        dataType:"json",               			 //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        //pagination: true,                   //是否显示分页（*）
        //sortable: false,                     //是否启用排序
       // sortOrder: "asc",                   //排序方式
       // queryParams: oTableInit.queryParams,//传递参数（*）
       // sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
       // pageNumber:1,                       //初始化加载第一页，默认第一页
      //  pageSize: 10,                       //每页的记录行数（*）
       // pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: false,                  //是否显示所有的列
        showRefresh: false,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,   				//是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",							//每一行的唯一标识，一般为主键列
        // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
        // cardView: false,                    //是否显示详细视图
        // detailView: false,    
        //是否显示父子表
        queryParams: function(params){
        	return {
        		ownerId:dogOwnerId
        	};
        },
        columns: [
            // {
            // checkbox: true
            //  },
            {
            field: 'dogName',
            title: '犬名'
        }, {
            field: 'breed',
            title: '品种'
        }, {
            field: 'dogGender',
            title: '性别'
        }, {
            field: 'colour',
            title: '毛色'
        },{
            field: 'birthday',
            title: '出生日期',
            formatter:function(value, row, idex, field){
            	var birthday= timeStamp2String(value);
            	return birthday;
            }	
        },{
            field: 'lssueTime',
            title: '登记日期',
            formatter:function(value, row, idex, field){
            	var lssueTime= timeStamp2String(value);
            	return lssueTime;
            }
        }, {
            field: 'operator',
            title: '操作',
            events:operateEvents,
            formatter: operateFormatter
        }],
        onLoadSuccess:function(data){
        	//console.log(data);
        },
        onLoadError:function(status){
        	//alert(status);
        },
        formatNoMatches: function(){
            return "没有相关的匹配结果";
        },
        formatLoadingMessage: function(){
            // return "请稍等，正在加载中。。。";
            return "";
        },
        responseHandler:function(res){ //格式化数据
        	if(res.result!=null){
        		return {
        			//total : res.result.length, //总页数,前面的key必须为"total"
        			data : res.result //行数据，前面的key要与之前设置的dataField的值一致.
        		};
        	}else{
        		return {
        			//total : 0,
        			data : []
        		};
        	}
        },
        //data:[{birthday:"1535793976000"},{lssueTime:"1535793976000"},{dogName:"王五"}]
        
    });
    
}

window.operateEvents = {
		//查询详情
		'click .RoleOfA': function(e, value, row, index) {
			 $("#home").load("views/dog/dogDetail.html");
			//存犬id
			 window.sessionStorage.setItem("dogId", row.dogId);
		},
    };
 
	function operateFormatter(value, row, index) {
		return [
		        '<a class="RoleOfA">查看详情</a>',
		].join('');
	}



//查询犬主详情
function selectDetail(Id){
    $.ajax({
        type:"get",
        url:"/biz/dogAndOwner/selectDogOwnerAllInfo",
        data:{ownerId:Id},
        dataType:"json",
        success:function (res) {
        	 console.log(res.result);
        	 if(res.result!=null){
        		 $("#add input").attr("readonly","readonly");
        		 var tMemberCard=res.result.tMemberCard;
        		 var dogOwners=res.result.dogOwners;
        		 /*会员证信息*/
        		 $("#hyzh").val(tMemberCard.memberCardNo);//会员证号
        		 $("#qfjg").val(tMemberCard.issueOrgId);//签发机构
        		 $("#qfrq").val(tMemberCard.issueDate);//签发日期
        		 $("#Syxqx").val(timeStamp2String(tMemberCard.upTime));//会员证开始日期
        		 $("#Eyxqx").val(timeStamp2String(tMemberCard.expireTime));//会员证结束日期
        		 /* 犬主信息*/
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
        		 $("#zjh").val(dogOwners.cardNum);//证件号
        		 $("#xb").val((dogOwners.sex==0)?"男":"女");//性别
        		 $("#csrq").val(timeStamp2String(dogOwners.birthDate));//出生日期
        		 $("#xzxq").val(dogOwners.districtName);//现住区县
        		 $("#ssbm").val(dogOwners.orgName);//所属部门
        		 $("#sssq").val(dogOwners.community);//所属社区
        		 $("#yb").val(dogOwners.postalCode);//邮编
        		 $("#lxdh").val(dogOwners.dogOwnerPhone);//联系电话
        		 $("#dzyj").val(dogOwners.eMail);//电子邮件
        		 $("#xxdz").val(dogOwners.address);//详细地址
        	 }
        }
    })
}

//格式化日期
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