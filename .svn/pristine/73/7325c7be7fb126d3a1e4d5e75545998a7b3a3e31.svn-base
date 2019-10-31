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
    orgId:null
}

$(function () {
	//获取登录用户的相关信息
	var user=JSON.parse(sessionStorage.getItem("user"));
	//获取组织id
	model.orgId=user.organizationId;
	//获取用户id
	//model.userId=user.userId;
    //免疫证table
    Table.initAddImmunisationTable();
    //犬证table
    // Table.initDogCardTable();
    var oTable = new TableInit();
    oTable.Init();
  //点击模糊查询,待优化加上enter事件
    $(".searchClick").click(function (){
        var opt = {
            url: "/biz/dogInfo/findImmuneCardList",
            silent: true,
            query:{
            	searchKey:$('#key').val()
            }
        };
        $("#addImmunisationTable").bootstrapTable('refresh', opt);
    });
    //点击免疫证办理按钮
    $("#add-im").click(function (){
        //跳转免疫证添加页面
        $("#home").load("views/immunisation/immune_certificate_handling_add.html");
    });
});

//初始化table
var Table = {
		//免疫信息table
	    initAddImmunisationTable:function(){
	        $("#addImmunisationTable").bootstrapTable({
	            url: '/biz/dogInfo/findImmuneCardList',         //请求后台的URL（*）
	            method: 'get',                      //请求方式（*）
	            // toolbar: '#toolbar',                //工具按钮用哪个容器
	            striped: true,                      //是否显示行间隔色
	            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	            pagination: true,                   //是否显示分页（*）
	            sortable: true,                     //是否启用排序
	            sortOrder: "asc",                   //排序方式
	            queryParams: function (params) {//上传服务器的参数
	                var temp = {//如果是在服务器端实现分页，index、pageSize这两个参数是必须的
	                    index  : params.offset, // SQL语句起始索引
	                    pageSize : params.limit, // 每页显示数量
	                    orgId:model.orgId
	                    //page: (params.offset / params.limit) + 1,   //当前页码
	                    
	                };
	                return temp;
	            },//传递参数（*）
	            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	            pageNumber:1,                       //初始化加载第一页，默认第一页
	            pageSize: 10,                       //每页的记录行数（*）
	            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
	            // search: true,                pagination       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	            // strictSearch: true,
	            // showColumns: true,                  //是否显示所有的列
	            // showRefresh: true,                  //是否显示刷新按钮
	            minimumCountColumns: 2,             //最少允许的列数
	            clickToSelect: true,                //是否启用点击选中行
	            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	            uniqueId: "ID",  
	            //每一行的唯一标识，一般为主键列
	            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
	            // cardView: false,                    //是否显示详细视图
	            // detailView: false,                   //是否显示父子表
	            classes:"table table-striped table-bordered table-thead",
	            columns: [{
	                field: 'dogImmune.immuneCardNum',
	                title: '免疫证号',
	                align:'center',
	            }, {
	                field: 'dogName',
	                title: '犬只名称',
	                align:'center',
	            }, {
	                field: 'dogBreedDictionary.dictionaryDescribe',
	                title: '犬只品种',
	                align:'center',
	            }, {
	                field: 'dogGender',
	                title: '性别',
	                align:'center',
	                formatter:function (value,row,index,field) {
	                	if(value==0){
	                		return "雄";
	                	}if(value==1){
	                		return "雌";
	                	}
	                }
	            },  {
	                field: 'dogColorDictionary.dictionaryDescribe',
	                title: '毛色',
	                align:'center',
	            }, {
	                field: 'dogOwner.dogOwnerName',
	                title: '犬主姓名',
	                align:'center',
	            }, {
	                field: 'dogOwner.dogOwnerPhone',
	                title: '电话',
	                align:'center',
	            }, {
	                field: 'dogImmune.lssueTime',
	                title: '办理时间',
	                align:'center',
	                formatter:function (value,row,index,field) {
	                	return model.formatDate(value);
	                }
	            }, {
	                field: 'dogImmune.tTUsers.name',
	                title: '办理人',
	                align:'center',
	            }, {
	                field: 'Desc',
	                title: '操作',
	                align:'center',
	                formatter:function (value,row,index,field) {
	                    return "<a style='color: #51CAD4' class='findDetail' href='javascript:void(0)'>查看详情</a>";
	                },
	                events: 'operateEvents'//注意,一定加上此句话,否则跳转不过去
	            }],
	            formatNoMatches: function(){
	                return "没有相关的匹配结果";
	            },
	            formatLoadingMessage: function(){
	                // return "请稍等，正在加载中。。。";
	                return "请稍等，正在加载中。。。";
	            },
                formatShowingRows: function (pageFrom, pageTo, totalRows) {
                    return "当前第 " + pageFrom + " 页，本页 " + totalRows + " 条";
                }
	        });
	        
	        window.operateEvents = {
	        		//查询详情
	        		'click .findDetail': function(e, value, row, index) {
	        			 $("#home").load("views/immunisation/immune_certificate_detail.html");
	        			 //存犬只id
	        			 window.sessionStorage.setItem("seqId", row.dogImmune.seqId);
	        			
	        		}	
	    	    };

	    },
};

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $("#dogCardTable").bootstrapTable({
            url: '/biz/dogCard/selectDogCardHandleList',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            // queryParams: initDogCardTable.queryParams,//传递参数（*）
            queryParams: function (params) {//上传服务器的参数
                var temp = {//如果是在服务器端实现分页，index、pageSize这两个参数是必须的
                    size : params.limit, // 每页显示数量
                    // pageSize : params.offset, // SQL语句起始索引
                    num: (params.offset / params.limit) + 1,   //当前页码

                    input:$('#inpu').val().trim()
                    // Name:$('#search_name').val(),
                    // Tel:$('#search_tel').val()
                };
                return temp;
            },//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            // showColumns: true,                  //是否显示所有的列
            // showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            classes:"table table-striped table-bordered table-thead",
            columns: [{
                field: 'dogCardNum',
                title: '犬证号',
                align:'center',
            }, {
                field: 'dogName',
                title: '犬只名称',
                align:'center',
            }, {
                field: 'dogVarieties',
                title: '犬只品种',
                align:'center',
            }, {
                field: 'dogOwnerName',
                title: '犬主姓名',
                align:'center',
            }, {
                field: 'dogOwnerPhone',
                title: '电话',
                align:'center',
            }, {
                field: 'lssueTime',
                title: '办理时间',
                align:'center',
                formatter:function (value,row,index,field) {
                    return value?model.formatDate(value):"";
                }
            }, {
                field: 'lssuerName',
                title: '办理人',
                align:'center',
            }, {
                field: 'lssueOrgName',
                title: '办理机构',
                align:'center',
            },{
                field: 'Desc',
                title: '操作',
                align:'center',
                events:operateEventss,
                formatter: operateFormatter
                // formatter:function (value,row,index,field) {
                //     var buffer = new StringBuffer();
                //     var a='<a style=\'color: #0c8ec3\'>查看详情</a>';
                //     var b='<a style=\'color: #0c8ec3\'>续期</a>'
                //     buffer.append(a);
                //     buffer.append('<br>');
                //     buffer.append(b);
                //     return buffer.toString();
                // }
            }],
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return "当前第 " + pageFrom + " 页，本页 " + pageTo + " 条";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
            onLoadSuccess:function(data){
                if(data!=null){
                    $(".pull-right").css("display", "block");
                }
            },
            data:[{Name:"张三"},{Name:"李四"},{Name:"王五"}]
        });
        //模糊查询按钮事件
        $('#search11').click(function(){
            $('#dogCardTable').bootstrapTable('refresh', {url: '/dogCard/selectDogCardHandleList'});
        });
    };
    window.operateEventss = {
        //查询详情
        'click .RoleOfA': function(e, value, row, index) {
            /*$("#master").hide();
            $("#detail").show();
             myFrame.window.selectDetail();
            myFrame.window.InitMainTable(row.dogOwnerId);*/
            $("#home").load("views/dogCard/dogCardInfo.html");
            //存犬主id
            window.sessionStorage.setItem("dogId", row.dogId);
            window.sessionStorage.setItem("pageType", "check");
            window.sessionStorage.setItem("orgRes", "hospital");
        },
        //发消息
        'click .RoleOfB': function(e, value, row, index) {
            /*$("#master").hide();
            $("#detail").show();
             myFrame.window.selectDetail();
            myFrame.window.InitMainTable(row.dogOwnerId);*/
            $("#home").load("views/dogCard/dogCardInfo.html");
            //存犬主id
            window.sessionStorage.setItem("dogId", row.dogId);
            window.sessionStorage.setItem("pageType", "update");
            window.sessionStorage.setItem("orgRes", "hospital");
        }
    }
    function operateFormatter(value, row, index) {
        return [
            '<a id="btn_detail" type="button" class="RoleOfA bt-select" style="color: #51CAD4;">查看详情</a>',
            '<br/>',
            '<a id="btn_msg" type="button"  class="RoleOfB bt-select" style="color: #51CAD4">续期</a>',
        ].join('');
    }
    return oTableInit;
};

//犬证办理
function dogCardHandle() {
    window.sessionStorage.setItem("dogId", "");
    window.sessionStorage.setItem("pageType", "insert");
    window.sessionStorage.setItem("orgRes", "hospital");
    $("#home").load("views/dogCard/dogCardInfo.html");
}