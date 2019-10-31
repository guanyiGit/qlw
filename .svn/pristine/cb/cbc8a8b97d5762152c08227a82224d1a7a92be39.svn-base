//动态资讯/养犬知识/政策法规

$(function () {
    //初始化immuneToRegisterTable
    Table.initImmuneToRegisterTable();

    //模糊查询
    $("#query").click(function(){
        var query=$("#query_input").val();
        console.log(query);
        $('#immuneToRegisterTable').bootstrapTable('refresh',  {
            query:{
                query:query,
            }
        });
    });
    var type=sessionStorage.getItem("type");
    if (type==0) {
        $("#bt").text("政策法规");
    }else if (type==1) {
        $("#bt").text("动态资讯");
    }else if (type==2) {
        $("#bt").text("养犬知识");
    }else if (type==3) {
        $("#bt").text("服务指南");
    }
});


//格式化日期
function timeStamp2String(time) {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1)
        : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime
        .getDate();
    return year + "/" + month + "/" + date;
}

/*
* table查询单数
* */
var a =sessionStorage.getItem("type");
var oTableInit = {
    queryParams : function (params) {
        var temp = {
            pageSize: params.limit,   //页面大小
            pageNum: (params.offset/params.limit)+1,  //页码
            TypeNumber:this.a,
        }
        return temp;
    },
}



var Table ={
    initImmuneToRegisterTable:function () {
        $("#immuneToRegisterTable").bootstrapTable({
             url: '/biz/information/getInformations',         //请求后台的URL（*）
             method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: false,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            showHeader:false,                   //禁用表头          sortOrder: "asc",                   //排序方式
           queryParams: oTableInit.queryParams,//传递参数（*）
            // queryParams:function(params){
            //     return {
            //         pageSize: params.limit,   //页面大小
            //         pageNum: (params.offset/params.limit)+1,  //页码
            //         TypeNumber:1,
            //     }
            // },
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            // showColumns: true,                  //是否显示所有的列
            // showRefresh: true,                  //是否显示刷新按钮
            // minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            classes:"table tablee",
            columns: [{
                class:'icon',
                field: '',
                align:'left',
                formatter:function (value,row,index,field) {
                    return "<img style='width: 50px;height: 30px' src='../../../static/images/shou.jpg'>";
                }
            }, {
                class:'information_title',
                field: 'infoTitile',
                align:'left',
                events:toInformation,
                formatter: operateFormatter
            }, {
                class:'creationTime',
                field: 'creationTime',
                align:'center',
                formatter: function (value,row,index,field) {
                    return timeStamp2String(value);
                }
            }],
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
            //显示分页条
            onLoadSuccess:function(data){
                 console.log(data);
                // if(data!=null){
                //     $(".pull-right").css("display", "block");
                // }
            },
            onLoadError:function(status){
                console.log(status);
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
            responseHandler:function(result){ //格式化数据
                if(result.data!=null){
                    return {
                        total : result.data.total, //总页数,前面的key必须为"total"
                        rows : result.data.list //行数据，前面的key要与之前设置的dataField的值一致.
                    };
                }else{
                    return {
                        total : 0,
                        rows : []
                    };
                }
            },
            //data:[{Name:"张三"},{Name:"李四"},{Name:"王五"}]
        });
    }
}
window.toInformation = {
    //查询详情
    'click .RoleOfA': function(e, value, row, index) {
        selectInformation(row.informationId);
    }
};

function operateFormatter(value, row, index) {
    return [
        '<a id="btn_detail"  class="RoleOfA ">'+row.infoTitile+'</a>'
    ].join('');
}


function selectInformation(id) {
    $.ajax({
        type:"post",
        url:"/information/getInformation",
        data:{
            informationId:id
        },
        dataType:"json",
        success:function (res) {
            console.log(res);
        }
    })
}
