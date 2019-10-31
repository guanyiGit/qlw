
$(function () {
    $(document).on("show.bs.modal", ".modal", function(){
        $(this).draggable();
        $(this).css("overflow-y", "scroll");
        // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
    });
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.初始化Button的点击事件
    // var oButtonInit = new ButtonInit();
    // oButtonInit.Init();

    $("#ss").click(function(){
    	refersh();
   });
});

$("#so").keydown(function(e) {
	if (e.keyCode == 13) {
		refersh();
	}
});

function refersh(){
	 var string=$("#so input").val();
	 if(string==''){
		 string=null;
	 }
     $('#dogFileTable').bootstrapTable('refresh',  {
     	query:{
     		input:string
     	}
     });
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#dogFileTable').bootstrapTable({
             url: '/biz/dogAndOwner/selectDogList',         //请求后台的URL（*）
             method: 'post',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            //sortable: true,                     //是否启用排序
           // sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'Name',
                title: '犬只信息',
                width:400,
                align:"center",
                formatter:function (value,row,index,field) {
                	var qzgq='';
                	var qzgqdays=DateDiff(new Date().toLocaleDateString(),timeStamp2String(row.endTime));
                	if(qzgqdays>0){
                		qzgq="犬证过期";
                	}
                	var ljcq='';
                	var ljcqdays=DateDiff(new Date().toLocaleDateString(),timeStamp2String(row.nextInsDate));
                	if(ljcqdays>0){
                		ljcq="年检超期";
                	}
                    var buffer = new StringBuffer();
                    buffer.append('<div  class="row" style="width: 400px;height: 120px;">');
                    buffer.append('<div class="col-sm-4">');
                    buffer.append('<img src="'+row.url+'">');
                    buffer.append('</div>');
                    buffer.append('<div class="col-sm-8" style="height: 100%;line-height: 30px" >');
                    buffer.append('<table style="width: 170px;height: 60px">');
                    buffer.append('<tr align="center">');
                    buffer.append('<th colspan="4" align="center"><B>'+row.dogName+'</B></th>');
                    buffer.append('</tr>');
                    buffer.append('<tr align="center">');
                    buffer.append('<th colspan="2" style="color: rgb(255, 153, 102)">'+qzgq+'</th>');
                    buffer.append('<th colspan="2"><font color="#f65">'+ljcq+'</font></th>');
                    buffer.append('</tr>');
                    buffer.append('<tr align="center">');
                    buffer.append('<th colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">性别:</th>');
                    buffer.append('<th colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+row.dogGender+'</th>');
                    buffer.append('<th colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">品种:</th>');
                    buffer.append('<th colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+row.breed+'</th>');
                    buffer.append('</tr>');
                    buffer.append('<tr align="center">');
                    buffer.append('<th colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">犬龄:</th>');
                    buffer.append('<th colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+row.dogAge+'</th>');
                    buffer.append('<th colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">毛色:</th>');
                    buffer.append('<th colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+row.colour+'</th>');
                    buffer.append('</tr>');
                    buffer.append('</table>');
                    buffer.append('</div>');
                    buffer.append('</div>');
                    return buffer.toString();
                }
            }, {
                field: 'dogOwnerName',
                title: '犬主',
                align:"center",
                valign:"middle",
                width:200,
                formatter: function (value, row, index, field) {
                    var buffer =   new StringBuffer();
                    buffer.append(row.dogOwnerName);
                    buffer.append("<br>");
                    buffer.append(row.phone);
                    return buffer.toString();
                }
            }, {
                field: 'dogCardNum',
                title: '犬证号',
            	align:"center",
                valign:"middle"
            }, {
                field: 'immuneCardNum',
                title: '免疫证号',
            	align:"center",
                valign:"middle"
            }, {
                field: 'Desc',
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
            			total : res.result.page.totalCount, //总页数,前面的key必须为"total"
            			rows : res.result.dogInfos //行数据，前面的key要与之前设置的dataField的值一致.
            		};
            	}else{
            		
            		return {
            			total:0,
            			rows:[]
            		};
            	}
            		
            }
        });
    };
    
    	window.operateEvents = {
    		//查询详情
    		'click .RoleOfA': function(e, value, row, index) {
    			 $("#home").load("views/dog/dogDetail.html");
    			//存犬只id
    			 window.sessionStorage.setItem("dogId", row.dogId);
    		}
    		
	    };
     
    	function operateFormatter(value, row, index) {
    		return [
    		        '<a class="RoleOfA" style="cursor: pointer">查看详情</a>',
    		       /* '<br/>',
    		        '<a id="btn_msg"   class="RoleOfB ">发消息</a>',*/
    		].join('');
    	}
    	
    	// 得到查询的参数
     oTableInit.queryParams = function (params) {
         var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        		 size: params.limit,   //页面大小 
                 num: (params.offset/params.limit)+1,  //页码 
         };
         return temp;
     };
    return oTableInit;
};

