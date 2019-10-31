$(function () {
    $(".fixed-table-toolbar").append()
    //初始化表格
    oTableInitYes();
    // $("#home").load("")

    //切换tab
    $(".top-tabbar>div").click(function () {
        deviePageIndex = $(this).index() == 0 ? oTableInitNo() : oTableInitYes();
        $(this).css({
            "backgroundColor": "#51CAD4",
            "color": "#fff"
        }).siblings().css({
            "backgroundColor": "#F5F5FA",
            "color": "#9EA9C5"
        });
    })

    //search input event
    $(".form-input").change(function () {
        params.query = $(this).val();
    }).keyup(function (e) {
        if(e.key.toString().toUpperCase() == 'ENTER'){
            params.query = $(this).val();
        }
    });
    $(".search-icon").click(function () {
        search($(this).next().val());
    })
})

//search fun 搜索关键字
function search(keyWord) {
    params.query = keyWord;
    if(deviePageIndex ==1){
        oTableInitYes();
    }else{
        oTableInitNo();
    }
}

let deviePageIndex = 1;//被选中的按钮下标 默认已审核

let params = {//页面参数
    TypeNumber: null,// 资讯类型  0政策法规 1动态资讯 2养犬宣传 3服务指南
    status: null,// 0审核中，1上架，2下架
    pageNum: null,  //页码
    pageSize: null,//页面大小
    query: null//关键字
}

let baseUrl = 'http://localhost:8888/biz/information';

//已审核
function oTableInitYes() {
    $("#message_moderation_table").bootstrapTable('destroy');
    $('#message_moderation_table').bootstrapTable({
        url: baseUrl + '/getInformations',   //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        //toolbar: '#toolbar',
        // classes: 'theadStyle',
        checkboxHeader: true,
        dataType: "json",               		//工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        searchOnEnterKey: true,
        // searchText:'请录入',
        undefinedText: "无",
        // detailView:true,
        // showToggle:true,
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        selectItemName: "selectItemName",
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        //showColumns: true,                  //是否显示所有的列
        //showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,   				//是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",							//每一行的唯一标识，一般为主键列
        queryParams: function (e) {         //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            params.pageSize = e.limit;//页面大小
            params.pageNum = e.offset; //页码
            return params;
        },
        columns: [{
            checkbox: true,
            width: '5%',
            clickToSelect: true,
            valign: 'middle',
            align: 'center',
        }, {
            field: 'infoTitile',
            title: '标题',
            width: '20%',
            valign: 'middle',
            align: 'center',
            // clickToSelect:true
        }, {
            field: 'informationTypeName',
            title: '类型',
            width: '20%',
            valign: 'middle',
            align: 'center',
        }, {
            field: 'pubishOrg',
            title: '发布单位',
            width: '20%',
            valign: 'middle',
            align: 'center'
        }, {
            field: 'approvalTime',
            title: '审批时间',
            width: '10%',
            valign: 'middle',
        }, {
            field: 'infoState',
            title: '审批状态',
            width: '15%',
            valign: 'middle',
            formatter(value, row, index, field) {
                let html = '';
                if (0 == value) {
                    html = "待审批";
                } else if (1 == value) {
                    html = "审批通过";
                } else if (2 == value) {
                    html = "<font color='red'>审批不通过</font>";
                }
                return html;
            }
        }, {
            field: 'desc',
            title: '操作',
            width: '10%',
            valign: 'middle',
            align: 'center',
            events:{
                'click .chakan': function(e, value, row, index) {
                    sessionStorage.setItem("data-chakan-info",JSON.stringify(row));
                    $("#home").load("./views/message_moderation/moderation_info.html");
                }
            },
            formatter(value, row, index, field) {
                return '<span style="cursor: pointer;color: #377BB5;" class="chakan">查看</span>';
            }
        }],
        onLoadSuccess: function (data) {

        },
        onLoadError: function (status) {
            console.log(status);
        },
        formatLoadingMessage: function () {
            // return "请稍等，正在加载中。。。";
            return "";
        },
        responseHandler: function (result) { //格式化数据
            if (result.status == 200) {
                return {
                    total: result.data.total, //总页数,前面的key必须为"total"
                    rows: result.data.list //行数据，前面的key要与之前设置的dataField的值一致.
                };
            }
            return {
                total: 0,
                rows: []
            };
        },
    });
}


//待审核
function oTableInitNo() {
    $("#message_moderation_table").bootstrapTable('destroy');
    $('#message_moderation_table').bootstrapTable({
        url: baseUrl + '/getInformations',   //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        //toolbar: '#toolbar',
        // classes: 'theadStyle',
        checkboxHeader: true,
        dataType: "json",               		//工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        searchOnEnterKey: true,
        // searchText:'请录入',
        undefinedText: "无",
        // detailView:true,
        // showToggle:true,
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        selectItemName: "selectItemName",
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        //showColumns: true,                  //是否显示所有的列
        //showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,   				//是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",							//每一行的唯一标识，一般为主键列
        queryParams: function (e) {         //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            params.pageSize = e.limit;//页面大小
            params.pageNum = e.offset; //页码
            return params;
        },
        columns: [{
            checkbox: true,
            width: '5%',
            clickToSelect: true,
            valign: 'middle',
            align: 'center',
        }, {
            field: 'infoTitile',
            title: '标题',
            width: '20%',
            valign: 'middle',
            align: 'center',
            // clickToSelect:true
        }, {
            field: 'informationTypeName',
            title: '类型',
            width: '20%',
            valign: 'middle',
            align: 'center',
        }, {
            field: 'pubishOrg',
            title: '发布单位',
            width: '20%',
            valign: 'middle',
            align: 'center'
        }, {
            field: 'creationTime',
            title: '发布时间',
            width: '25%',
            valign: 'middle',
            formatter(value, row, index, field) {
                return Date.format(value, "yyyy年MM月dd日")
            }
        }, {
            field: 'desc',
            title: '操作',
            width: '10%',
            valign: 'middle',
            align: 'center',
            events:{
                'click .shenghe': function(e, value, row, index) {
                    sessionStorage.setItem("moderation_data_shenghe",JSON.stringify(row))
                    $("#home").load("./views/message_moderation/moderation.html");
                }
            },
            formatter(value, row, index, field) {
                return '<span style="cursor: pointer;color: #377BB5;" class="shenghe">审核</span>';
            }
        }],
        onLoadSuccess: function (data) {

        },
        onLoadError: function (status) {
            console.log(status);
        },
        formatLoadingMessage: function () {
            // return "请稍等，正在加载中。。。";
            return "";
        },
        responseHandler: function (result) { //格式化数据
            if (result.status == 200) {
                return {
                    total: result.data.total, //总页数,前面的key必须为"total"
                    rows: result.data.list //行数据，前面的key要与之前设置的dataField的值一致.
                };
            }
            return {
                total: 0,
                rows: []
            };
        },
    });
}
