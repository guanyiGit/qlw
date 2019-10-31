

$(function () {
    //初始化immuneToRegisterTable
    Table.initImmuneToRegisterTable();
});


var Table ={
    initImmuneToRegisterTable:function () {
        $("#immuneToRegisterTable").bootstrapTable({
            // url: '/Home/GetDepartment',         //请求后台的URL（*）
            // method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            // queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            classes:"table table-striped table-bordered",
            columns: [{
                field: 'Name',
                title: '免疫时间',
                align:'center',
            }, {
                field: 'ParentName',
                title: '免疫项目',
                align:'center',
            }, {
                field: 'Level',
                title: '疫苗厂家及批号',
                align:'center',
            }, {
                field: 'Desc',
                title: '接种兽医',
                align:'center',
            }, {
                field: 'Desc',
                title: '犬只品种',
                align:'center',
            }, {
                field: 'Desc',
                title: '性别',
                align:'center',
            }, {
                field: 'Desc',
                title: '犬龄',
                align:'center',
            }, {
                field: 'Desc',
                title: '毛色',
                align:'center',
            }, {
                field: 'Desc',
                title: '免疫证号',
                align:'center',
            }, {
                field: 'Desc',
                title: '犬主姓名',
                align:'center',
            }, {
                field: 'Desc',
                title: '电话',
                align:'center',
            }, {
                field: 'Desc',
                title: '操作',
                align:'center',
                formatter:function (value,row,index,field) {
                    return "<a style='color: #0c8ec3'>查看详情</a>";
                }
            }],
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
            data:[{Name:"张三"},{Name:"李四"},{Name:"王五"}]
        });
    }
}
