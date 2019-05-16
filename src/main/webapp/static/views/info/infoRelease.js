function formatDate(date) {
    var datetime = new Date(date);
    var year = datetime.getFullYear();
    var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
    var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
    var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
    var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
    return year + "年" + month + "月" + day + "日" + hours + "时" + min;
}
$(function () {
    var oTable = new TableInit();
    oTable.Init();
    $("#titile").click(function () {
        $("#home").load("views/info/release.html")
    });
});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $("#dogCardTable").bootstrapTable({
            url: '/biz/information/getInformations',         //请求后台的URL（*）
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
                    TypeNumber:null,
                    status:null,
                    pageSize : params.limit, // 每页显示数量
                    // pageSize : params.offset, // SQL语句起始索引
                    pageNum: (params.offset / params.limit) + 1,   //当前页码

                    query:$('#inpu').val().trim()
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
            classes:"table table-bordered theadStyle",
            columns: [{
                field: 'infoTitile',
                title: '标题',
                align:'center',
            }, {
                field: 'informationTypeName',
                title: '类型',
                align:'center',
            }, {
                field: 'creationTime',
                title: '发布时间',
                align:'center',
                formatter:function (value,row,index,field) {
                    var date=formatDate(value);
                    return date;
                    }
            }, {
                field: 'infoState',
                title: '状态',
                align:'center',
                formatter:function (value,row,index,field) {
                    switch (value)
                    {
                        case 0:
                            value="审核中";
                            break;
                        case 1:
                            value="上架";
                            break;
                        case 2:
                            value="下架";
                            break;
                    }
                    return value;
                }
            }, {
                field: 'informationId',
                title: '操作',
                align:'center',
                events:operateEventss,
                formatter: operateFormatter
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
            data:[{Name:"张三"},{Name:"李四"},{Name:"王五"}]
        });
        //模糊查询按钮事件
        $('#search11').click(function(){
            $('#dogCardTable').bootstrapTable('refresh', {url: '/biz/information/getInformations'});
        });
    };
    window.operateEventss = {
        //查询详情
        'click .RoleOfA': function(e, value, row, index) {
            $("#home").load("views/dogCard/dogCardInfo.html");
            //存犬主id
            window.sessionStorage.setItem("dogId", row.dogId);
            window.sessionStorage.setItem("pageType", "check");
            window.sessionStorage.setItem("orgRes", "hospital");
        },
        //发消息
        'click .RoleOfB': function(e, value, row, index) {
            $.ajax({
                type:"post",
                url:"/biz/information/delete",
                data:{informationId:value},
                success:function (results) {
                    if (results.status==200) {
                        var oTable = new TableInit();
                        oTable.Init();
                    }
                }
            })
        }
    }
    function operateFormatter(value, row, index) {
        return [
            '<a id="btn_detail" type="button" style="color: #0b5b97" class="RoleOfA btn-default bt-select">查看详情</a>',
            '&nbsp&nbsp&nbsp',
            '<a id="btn_msg" type="button" style="color: #0b5b97" class="RoleOfB btn-default bt-select">删除</a>',
        ].join('');
    }
    return oTableInit;
};

