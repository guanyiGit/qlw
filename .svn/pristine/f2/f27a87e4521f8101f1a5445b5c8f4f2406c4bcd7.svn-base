
$(function () {
    $(document).on("show.bs.modal", ".modal", function(){
        $(this).draggable();
        $(this).css("overflow-y", "scroll");
        // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
    });
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    
    $("#ss").click(function(){
    	refersh();
    }); 
});



function refersh(){
	 var string=$("#so input").val();
	 if(string==''){
		 string=null;
	 }
     $('#dogMasterFileTable').bootstrapTable('refresh',  {
     	query:{
     		input:string
     	}
     });
}


$("#so").keydown(function(e) {
	if (e.keyCode == 13) {
		refersh();
	}
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#dogMasterFileTable').bootstrapTable({
            url: '/biz/dogAndOwner/selectOwnerArchivesList',         //请求后台的URL（*）
             method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar'
            dataType:"json",               			 //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            //sortable: false,                     //是否启用排序
           // sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
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
            columns: [{
                checkbox: true
            }, {
                field: 'dogOwnerName',
                title: '犬主姓名',
                align:"center",
            }, {
                field: 'cardNum',
                title: '身份证号',
                align:"center",
            }, {
                field: 'dogOwnerPhone',
                title: '联系电话',align:"center",
            }, {
                field: 'districtName',
                title: '所属区域',align:"center",
            },{
                field: 'dogNum',
                title: '犬只数',align:"center",
            }, {
                field: 'operate',
                title: '操作',align:"center",
                events:operateEvents,
                formatter: operateFormatter
            }],
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return "当前第 " + pageFrom + " 页，本页 " + pageTo + " 条";
            },
            onLoadSuccess:function(data){
            	if(data!=null){
            		$(".pull-right").css("display", "block");
            	}
            },
            onLoadError:function(status){
            	console.log(status);
            },
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            }
           
        });
    };
    	window.operateEvents = {
    		//查询详情
    		'click .RoleOfA': function(e, value, row, index) {
    			 $("#home").load("views/dog/dogMasterFileDetail.html");
    			//存犬主id
    			 window.sessionStorage.setItem("dogOwnerId", row.dogOwnerId);
    		},
    		/*//发消息
    		'click .RoleOfB': function(e, value, row, index) {
    			//alert("发消息咯");
	    	}	*/
	    };
     
    	function operateFormatter(value, row, index) {
    		return [
    		        '<a class="RoleOfA" style="color: rgb(65, 199, 219);">查看详情</a>',
    		        /*'<br/>',
    		        '<a id="btn_msg"   class="RoleOfB ">发消息</a>',*/
    		].join('');
    	}

    //得到查询的参数
     oTableInit.queryParams = function (params) {
         var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
             size: params.limit,   //页面大小 
             num: (params.offset/params.limit)+1,  //页码 
         };
         return temp;
     };
    return oTableInit;
};

