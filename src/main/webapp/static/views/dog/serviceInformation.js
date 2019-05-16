

$(function () {
    //初始化服务指南table serviceInformationTable
    initServiceInformationTable();
});

//初始化服务指南table serviceInformationTable
function initServiceInformationTable() {
    $("#serviceInformationTable").bootstrapTable({
        // url: '/Home/GetDepartment',         //请求后台的URL（*）
        // method: 'get',                      //请求方式（*）
        // toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: false,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        pagination:true,
        pageNumber:1,
        pageList:[10,15,20],
        clickToSelect: true,                //是否启用点击选中行
        showHeader:false,
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        columns: [{
            field: 'Name',
            width:20,
            formatter:function () {
                return "<img src='../../../static/images/hand.png'>";
            }
            // title: '免疫日期'
        }, {
            field: 'ParentName',
            // title: '免疫项目'
        }, {
            field: 'Level',
            width:80
            // title: '疫苗名称'
        }],
        formatNoMatches: function(){
            return "没有相关的匹配结果";
        },
        formatLoadingMessage: function(){
            // return "请稍等，正在加载中。。。";
            return "";
        },
        data:[{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'},{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'},{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'}]
    });
}
