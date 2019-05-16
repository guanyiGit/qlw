//页面加载函数
$(function () {
    to_auditingTable.initTo_auditingTable();

    auditingTable.initAuditingTable();


})

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

var to_auditingTable = {
    initTo_auditingTable:function () {
        $("#to_auditingTable").bootstrapTable({
            url: '/biz/serviceSite/getServiceSitesforAdmin',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: function (params) {
                var temp = {
                    pageSize: params.limit,   //页面大小s
                    pageNum: (params.offset/params.limit)+1,  //页码
                    status: 0,    //查询状态 (查询所有审核中的服务网点)
                }
                return temp;
            }, //传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                pagination       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "organizationId",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            classes: "table table-striped table-bordered table-thead",
            columns: [{
                checkbox: true,
            },{
                field: 'organizationName',
                title: '网点名称',
                align: 'center',
            }, {
                field: 'phone',
                title: '联系电话',
                align: 'center',
            }, {
                field: 'district',
                title: '所属区域',
                align: 'center',
            }, {
                field: 'address',
                title: '详细地址',
                align: 'center',
            },{
                field: 'creationTime',
                title: '申请时间',
                align: 'center',
                formatter:function (value, row, index, field) {
                    return timeStamp2String(value);
                }
            }, {
                title: '操作',
                align: 'center',
                events:to_auditing,
                formatter: function (value,row,index,field) {
                    return "<a class='to_auditing_button'>审核</a>";
                }
            }],
            formatNoMatches: function () {
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function () {
                // return "请稍等，正在加载中。。。";
                return "请稍等，正在加载中。。。";
            },
            //显示分页条
            onLoadSuccess: function (data) {
                console.log(data);
            },
            onLoadError: function (status) {
                console.log(status);
            },
            responseHandler: function (result) { //格式化数据
                if (result.data != null) {
                    return {
                        total: result.data.total, //总页数,前面的key必须为"total"
                        rows: result.data.list //行数据，前面的key要与之前设置的dataField的值一致.
                    };
                } else {
                    return {
                        total: 0,
                        rows: []
                    };
                }
            },
        })
    }
}

var auditingTable = {
    initAuditingTable:function () {
        $("#auditingTable").bootstrapTable({
            url: '/biz/serviceSite/getServiceSitesforAdmin',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: function (params) {
                var temp = {
                    pageSize: params.limit,   //页面大小
                    pageNum: (params.offset/params.limit)+1,  //页码
                }
                return temp;
            }, //传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                pagination       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "organizationId",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            classes: "table table-striped table-bordered table-thead",
            columns: [{
                checkbox: true,
            },{
                field: 'organizationName',
                title: '网点名称',
                align: 'center',
            }, {
                field: 'phone',
                title: '联系电话',
                align: 'center',
            }, {
                field: 'district',
                title: '所属区域',
                align: 'center',
            }, {
                field: 'address',
                title: '详细地址',
                align: 'center',
            },{
                field: 'approvalTime',
                title: '审批时间',
                align: 'center',
                formatter:function (value, row, index, field) {
                    return timeStamp2String(value);
                }
            }, {
                field: 'status',
                title: '审批状态',
                align: 'center',
                formatter: function (value, row, index, field) {
                    if (value == 1) {
                        return "审核通过";
                    }
                    if (value == 2) {
                        return "审核不通过";
                    }
                }
            },{
                field: 'operate',
                title: '操作',
                events:operateEvents,
                formatter: function (value,row,index) {
                    return "<a id='select' class='selectInfo'>查看详情</a>";
                }
            }],
            formatNoMatches: function () {
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function () {
                // return "请稍等，正在加载中。。。";
                return "请稍等，正在加载中。。。";
            },
            //显示分页条
            onLoadSuccess: function (data) {
                console.log(data);
            },
            onLoadError: function (status) {
                console.log(status);
            },
            responseHandler: function (result) { //格式化数据
                if (result.data != null) {
                    return {
                        total: result.data.total, //总页数,前面的key必须为"total"
                        rows: result.data.list //行数据，前面的key要与之前设置的dataField的值一致.
                    };
                } else {
                    return {
                        total: 0,
                        rows: []
                    };
                }
            },
        })
    }
}



window.to_auditing = {
    //点击审核按钮事件
    'click .to_auditing_button':function (e, value, row, index) {
        var organizationId = row.organizationId;
        console.log(organizationId);
        window.sessionStorage.setItem("organizationId",organizationId);
        $("#home").load("views/serviceSite/ServiceSiteExamine.html");
    }
}

window.operateEvents = {
    //查询详情事件
    'click .selectInfo':function (e, value, row, index) {
        var organizationId = row.organizationId;
        var examineStatus = row.status;
        window.sessionStorage.setItem("organizationId",organizationId);
        window.sessionStorage.setItem("examineStatus",examineStatus);
        $("#home").load("views/serviceSite/ServiceSiteInfo.html")
    }
}
