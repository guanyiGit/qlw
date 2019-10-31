var model = {
    formatDate: function(date) {
        var datetime = new Date(date);
        var year = datetime.getFullYear();
        var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
        var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
        var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
        var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
        // return year + "-" + month + "-" + day + " " + hours + ":" + min;
        return year + "-" + month + "-" + day;
    },
    DateToUnix: function(string) {
        var f = string.split('-', 2);
        var d = (f[0] ? f[0] : '').split('-', 3);
        var t = (f[1] ? f[1] : '').split(':', 3);
        return (new Date(
            parseInt(d[0], 10) || null,
            (parseInt(d[1], 10) || 1) - 1,
            parseInt(d[2], 10) || null,
            parseInt(t[0], 10) || null,
            parseInt(t[1], 10) || null,
            parseInt(t[2], 10) || null
        )).getTime()/1000;
    },
    CalAge: function(date1) {
    	var datetime1 = new Date(date1);
    	var datetime2 = new Date();
    	 var year1 = datetime1.getFullYear();
    	 var year2 = datetime2.getFullYear();
    	 var age=year2-year1+1;
    	 return age+"岁";
    },
    orgId:null
}

$(function () {
	//取出当前登录用户的部门信息
	var user=JSON.parse(sessionStorage.getItem("user"));
	model.orgId=user.organizationId;
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.点击模糊查询,待优化加上enter事件
    $("#search").click(function (){
        var opt = {
            url: "/biz/dogInfo/findTherapyList",
            silent: true,
            query:{
            	searchKey:$('#key').val()
            }
        };
        $("#dogTrackEventsTable").bootstrapTable('refresh', opt);
    });
  //3.点击模糊查询,待优化加上enter事件
    $("#addTherapy").click(function (){
    	//跳转新增病历页面
        $("#home").load("views/medical_history/medical_history_add.html");
    });
    
    //
    $("body").on("click",".RoleOfA",function(){
    	var dogId = $(this).attr("data-id")
    	var dogOwnerId = $(this).attr("dog-owen-id")
    	window.sessionStorage.setItem("medical_history_dogId", dogId);
    	window.sessionStorage.setItem("medical_history_dogOwnerId", dogOwnerId);
    	$("#home").load("views/medical_history/medical_history_detail.html");
    })
    
    
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#dogTrackEventsTable').bootstrapTable({
        	url: '/biz/dogInfo/findTherapyList',         //请求后台的URL（*）
          	method: 'get',                      //请求方式（*）
            //toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            paginationVAlign:'bottom',            //分页条 在垂直方向
            paginationHAlign:'right',           //水平位置
            singleSelect:true,
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            //height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            columns: [{
                field: '',
                title: '',
                width:160,
                checkbox:true,
                showSelectTitle:true,
                formatter(value,row,index,field){
                    let buffer = new StringBuffer();
                    buffer.append('<div  class="row" style="width:162px;height: 120px;">');
                    buffer.append('<div class="col-sm-12">');
                    buffer.append('<span style="display: inline-block;height: 20px;width: 20px; background-color: #fff;position: absolute;top: 1px;left: 16px;"></span>');
                    buffer.append('<img src='+row.imageList[0].thumbnailUrl+' style="border: solid 1px #aaa;""/>');
                    buffer.append('<div>');
                    buffer.append('<div >');
                    return buffer.toString();
                }
            	
            },{
                field: '',
                title: '犬只信息',
                width:160,
                formatter:function (value,row,index,field) {
                	
                   var buffer = new StringBuffer();
                   buffer.append('<div  class="row" style="width: 300px;height: 120px;">');
                    buffer.append('<div class="col-sm-6" style="height: 100%;line-height: 40px" >');
                    
                    buffer.append('<table style="width: 170px;height: 60px">');
                    buffer.append('<tr align="center">');
                    buffer.append('<td colspan="8" align="left">');
                    buffer.append('<B style="font-size: 18px;">&nbsp;'+row.dogName+'</B>');
                    buffer.append('</td>');
                    buffer.append('</tr>');
                    buffer.append('<tr align="center">');
                    buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">性别:</td>');
                    if(row.dogGender==0){
                    	buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">雄</td>');
                    }else{
                    	buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">雌</td>');
                    }
                    buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">品种:</td>');
                    buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+row.dogBreedDictionary.dictionaryDescribe+'</td>');
                    buffer.append('</tr>');
                    buffer.append('<tr align="center">');
                    buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">犬龄:</td>');
                    buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+model.CalAge(row.birthTime)+'</td>');
                    buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">毛色:</td>');
                    buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+row.dogColorDictionary.dictionaryDescribe+'</td>');
                    buffer.append('</tr>');
                    buffer.append('</table>');

                    buffer.append('</div>');
                    buffer.append('</div>');
                    return buffer.toString();
                }
            }, 
            {
                field: '',
                title: '犬主',
                formatter(value,row,index,field){
                    let buffer = new StringBuffer();
                    buffer.append('<div  class="row" style="width:162px;height: 120px;font-size: 18px;">');
                    buffer.append('<div class="col-sm-12" style="display: flex; flex-flow: column nowrap;align-items: flex-start;justify-content: center;height: 100%;">');
                    buffer.append('<span >'+row.dogOwner.dogOwnerName+'</span >');
                    buffer.append('<span style="margin-top: 12px; color: rgb(153, 153, 153);">'+row.dogOwner.dogOwnerPhone+'</span>');
                    buffer.append('<div>');
                    buffer.append('<div >');

                    return buffer.toString();
                }
            }, 
            {
                field: '',
                title: '犬证号',
                formatter(value,row,index,field){
                    let sb = new StringBuffer();
                    sb.append('<div  class="row" style="width:162px;height: 120px;font-size: 18px;">');
                    sb.append('<div class="col-sm-12" style="display: flex; align-items: center;justify-content: flex-start;height: 100%;">');
                    sb.append('<span >'+row.tDogCard.dogCardNum+'</span >');
                    sb.append('<div>');
                    sb.append('<div >');
                    return sb.toString();
                }
            },
            {
                field: '',
                title: '免疫证号',
                formatter(value,row,index,field){
                    let sb = new StringBuffer();
                    sb.append('<div  class="row" style="width:162px;height: 120px;font-size: 18px;">');
                    sb.append('<div class="col-sm-12" style="display: flex; align-items: center;justify-content: center;height: 100%;">');
                    sb.append('<span >'+row.dogImmune.immuneCardNum+'</span >');
                    sb.append('<div>');
                    sb.append('<div >');
                    return sb.toString();
                }
            }, 
            {
                field: 'Desc',
                title: '操作',
                align:'center',
                valign:'middle',
//                events:operateEventss,
                events:{
                	'click #btn_detail': function(e, value, row, index){
                		alert(e)
                	}
                },
                formatter: operateFormatter
            }
            ],
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            }
        });

    };

    
    //得到查询的参数
     oTableInit.queryParams = function (params) {
    	 var temp = {//如果是在服务器端实现分页，index、pageSize这两个参数是必须的
                 index  : params.offset, // SQL语句起始索引
                 pageSize : params.limit, // 每页显示数量
                 orgId:model.orgId//当前登录用户的部门id
                 //page: (params.offset / params.limit) + 1,   //当前页码
                 
             };
         return temp;
     };
     
     window.operateEventss = {
    	        //查询详情
    	        'click .RoleOfA': function(e, value, row, index) {
    	            /*$("#master").hide();
    	            $("#detail").show();
    	             myFrame.window.selectDetail();
    	            myFrame.window.InitMainTable(row.dogOwnerId);*/
    	            $("#home").load("views/medical_history/medical_history_detail.html");
    	            //存犬主id
//    	            window.sessionStorage.setItem("dogId", row.dogId);
//    	            window.sessionStorage.setItem("pageType", "check");
//    	            window.sessionStorage.setItem("orgRes", "hospital");
    	        }
    	    }
    	    function operateFormatter(value, row, index) {
    	        return [
    				'<button id="btn_detail" type="button" dog-owen-id='+row.dogOwnerId+' data-id='+row.dogId+' class="RoleOfA btn-default bt-select">病历记录</button>',
    	        ].join('');
    	    }
    return oTableInit;
};




var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};
