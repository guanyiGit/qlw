
//页面加载函数
$(function () {
    //初始化用户table
    userTable.initUserTable();

    //切换tab
    $(".nav-pills li").click(function () {
        $(this).addClass("activeli").siblings().removeClass("activeli")
    })

    //初始化角色table
    roleTable.initRoleTable();

    $('#sex').selectpicker({});

    $('#orgName').selectpicker({});

    //初始化机构类型select
    mySelect.init({
        url:"/biz/dictionary/OrgType",
        id:"orgType",
        value:"dictionaryValue",
        text:"dictionaryDescribe"
    });

    //用户添加表单提交
    $("#submit_button").click(function () {
        var userInfo = $("#user_form").serialize();
        $.ajax({
            url:"/biz/user/add",
            type:"post",
            dataType:"json",
            data:userInfo,
            success:function (res) {
                  console.log(res);
            }
        })


    })

    //删除
    $("#delete_user").click(function () {
        //获取复选框选中值
        var checkBoxValues  = CheckBox.getCheckBoxValue();
        for (var index in checkBoxValues){
            var checkBoxValue = checkBoxValues[index];
            console.log(checkBoxValue);
            $.ajax({
                url:"/biz/user/delete",
                type:"post",
                dataType:"json",
                data:{
                    userId:checkBoxValue.userId
                },
                success:function (res) {
                    //重新加载table
                    $("#userTable").bootstrapTable("refresh",{
                        url:"/biz/user/list",
                    });
                }
            })
        }
    })

    //启用
    $("#enable").click(function () {
        //获取复选框选中值
        var checkBoxValues  = CheckBox.getCheckBoxValue();
        for (var index in checkBoxValues){
            var checkBoxValue = checkBoxValues[index];
            if (checkBoxValue.uStatus == 1){
                bootbox.alert("已启用");
                return;
            }
            $.ajax({
                url:"/biz/user/updateStatus",
                type:"post",
                dataType:"json",
                data:{
                    userId:checkBoxValue.userId,
                    status:1
                },
                success:function (res) {
                    console.log(res);
                    if (res.status == 200){
                        bootbox.alert("操作成功！！");
                        //重新加载table
                        $("#userTable").bootstrapTable("refresh",{
                            url:"/biz/user/list",
                        });
                    } else{
                        bootbox.alert("服务器暂忙，请稍后再试！！");
                    }
                }
            })
        }
    })

    //禁用
    $("#disable").click(function () {
        //获取复选框选中值
        var checkBoxValues  = CheckBox.getCheckBoxValue();
        for (var index in checkBoxValues){
            var checkBoxValue = checkBoxValues[index];
            if (checkBoxValue.uStatus == 0){
                bootbox.alert("已禁用");
                return;
            }
            console.log(checkBoxValue);
            $.ajax({
                url:"/biz/user/updateStatus",
                type:"post",
                dataType:"json",
                data:{
                    userId:checkBoxValue.userId,
                    status:0
                },
                success:function (res) {
                    console.log(res);
                    if (res.status == 200){
                        bootbox.alert("操作成功！！");
                        //重新加载table
                        $("#userTable").bootstrapTable("refresh",{
                            url:"/biz/user/list",
                        });
                    } else{
                        bootbox.alert("服务器暂忙，请稍后再试！！");
                    }
                }
            })
        }
    })

    //分配角色
    $("#role_submit").click(function () {
        var roleIdsArray = $("#checkRole").val();
        //获取复选框选中值
        var checkBoxValues  = CheckBox.getCheckBoxValue();
        for (var i in checkBoxValues){
            var checkBoxValue = checkBoxValues[i];
            var roleIds = "";
            for (var j in roleIdsArray){
                roleIds = roleIdsArray[j]+",";
            }
            roleIds = roleIds.substr(0,roleIds.length-1);
            $.ajax({
                url:"/biz/user/assignRole",
                type:"post",
                dataType:"json",
                data:{
                    userId:checkBoxValue.userId,
                    roleIds:roleIds
                },
                success:function (res) {
                    $("#userTable").bootstrapTable("refresh",{
                        url:"/biz/user/list",
                    });
                }
            })
        }

    })


    //用户模糊查询
    $("#searchUser").click(function(){
        var query=$("#query_user").val();
        console.log(query);
        $('#userTable').bootstrapTable('refresh',  {
            query:{
                query:query,
            }
        });
    });

    //角色模糊查询
    $("#searchRole").click(function(){
        var query=$("#query_role").val();
        console.log(query);
        $('#roleTable').bootstrapTable('refresh',  {
            query:{
                query:query,
            }
        });
    });



})

//监听机构类型change时间内
function  orgTypeOnchange(obj) {
    //先执行销毁操作，再初始化select

    //获取选中行的value值(机构类型id)
    var value =  obj.options[obj.selectedIndex].value;
    console.log(value);
    mySelect.init({
        url:"/biz/serviceSite/selectOrgByTypeId",
        data:{
            orgType: value
        },
        id:"orgName",
        value:"organizationId",
        text:"organizationName"
    })
}

//获取复选框选中的数据
var CheckBox = {
    getCheckBoxValue:function () {
        //如果type为0，表示获取用户列表选中值
        var getSelectRows = $("#userTable").bootstrapTable('getSelections',function (row) {
            return  row;
        })
        return getSelectRows;
    }
}

//自定义下拉框
var mySelect={
    init:function (option) {
        $.ajax({
            url:option.url,
            data:option.data,
            contentType:"application/x-www-form-urlencoded",
            dataType:"json",
            type:"post",
            success:function (data) {
                if(!data){
                    alert("没有可加载的数据");
                    return;
                }
                var value = option.value;
                var text  = option.text;
                var buffer = new StringBuffer();
                for (var index in data.data) {
                    var item = data.data[index];
                    var value2= item[value];
                    var text2= item[text];
                    buffer.append("<option value='"+value2+"'>"+text2+"</option>");
                }
                $(buffer.toString()).appendTo($("#"+option.id));
                // 缺一不可
                $('#'+option.id).selectpicker('refresh');
                $('#'+option.id).selectpicker('render');
            }
        });
    }
};

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

var ParamsInit = {
    queryParams : function (params) {
        var temp = {
            pageSize: params.limit,   //页面大小
            pageNum: (params.offset/params.limit)+1,  //页码
        }
        return temp;
    },
}

var userTable = {
    //用户table
    initUserTable: function () {
        $("#userTable").bootstrapTable({
            url: '/biz/user/list',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: ParamsInit.queryParams, //传递参数（*）
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
            uniqueId: "userId",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            classes: "table table-striped table-bordered table-thead",
            columns: [{
                checkbox: true,
            },{
                field: 'userId',
                title: '用户编号',
                align: 'center',
            }, {
                field: 'name',
                title: '用户名称',
                align: 'center',
            }, {
                field: 'phone',
                title: '联系方式',
                align: 'center',
            }, {
                field: 'orgType',
                title: '机构类型',
                align: 'center',
                formatter: function (value, row, index, field) {
                    if (value == 0) {
                        return "犬只办";
                    }
                    if (value == 1) {
                        return "收容所";
                    }
                    if (value == 2) {
                        return "宠物医院";
                    }
                }
            }, {
                field: 'orgName',
                title: '机构名称',
                align: 'center',
            }, {
                field: 'roleName',
                title: '所属角色',
                align: 'center',
            }, {
                field: 'createTime',
                title: '创建时间',
                align: 'center',
                formatter:function (value, row, index, field) {
                    return timeStamp2String(value);
                }
            }, {
                field: 'uStatus',
                title: '是否启用',
                align: 'center',
                formatter: function (value, row, index, field) {
                    if (value == 0) {
                        return "禁用";
                    }
                    if (value == 1) {
                        return "启用";
                    }
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
                //console.log(data);
                // if(data!=null){
                //     $(".pull-right").css("display", "block");
                // }
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

var roleTable = {
    //用户table
    initRoleTable: function () {
        $("#roleTable").bootstrapTable({
            url: '/biz/role/list',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: ParamsInit.queryParams, //传递参数（*）
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
            uniqueId: "roleId",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            classes: "table table-striped table-bordered table-thead",
            columns: [{
                checkbox: true,
            },{
                field: 'roleId',
                title: '角色编号',
                align: 'center',
            }, {
                field: 'roleName',
                title: '角色名称',
                align: 'center',
            }, {
                field: 'creationTime',
                title: '创建时间',
                align: 'center',
                formatter:function (value, row, index, field) {
                    return timeStamp2String(value);
                }
            }, {
                field: 'operate',
                title: '操作',
                align:"center",
                formatter: function (value,row,index,field) {
                    return "<a id='LookInfo'>查看权限</a>";
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
                // if(data!=null){
                //     $(".pull-right").css("display", "block");
                // }
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


function operateFormatter(value, row, index) {
    return [
        '<a id="LookResources"  class="RoleOfResources">查看权限</a>',
    ].join('');
}

