//角色管理js
var model = {
    formatDate: function (date) {
        var datetime = new Date(date);
        var year = datetime.getFullYear();
        var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
        var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
        var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
        var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
        // return year + "-" + month + "-" + day + " " + hours + ":" + min;
        return year + "-" + month + "-" + day;
    },
    DateToUnix: function (string) {
        var f = string.split(' ', 2);
        var d = (f[0] ? f[0] : '').split('-', 3);
        var t = (f[1] ? f[1] : '').split(':', 3);
        return (new Date(
            parseInt(d[0], 10) || null,
            (parseInt(d[1], 10) || 1) - 1,
            parseInt(d[2], 10) || null,
            parseInt(t[0], 10) || null,
            parseInt(t[1], 10) || null,
            parseInt(t[2], 10) || null
        )).getTime() / 1000;
    },
    role:{id:null,name:null,description:null},//插入角色的参数
    resuouce:{roleId:null,resourceIds:null},
    permissions:null
}
//页面加载后执行
$(function () {
    //shbuttonnnn();
    queryRoles();
//    $("#return").click(function () {
//        $("#suspension").hide();
//        $("#popupWindow").hide();
//    })
    $("#cancel1").click(function () {
        $("#suspension").hide();
        $("#popupWindow1").hide();
    });
})
////显示隐藏页面按钮
//function shbuttonnnn() {
//    $(".hsbutton").hide();
//    model.permissions = JSON.parse(localStorage.getItem("permissions"));
//    for (var i=0;i<model.permissions.length;i++){
//        if (model.permissions[i].name=="新增角色") {
//            $("#xzjs").show();
//        }
//        if (model.permissions[i].name=="删除角色") {
//            $("#scjs").show();
//        }
//    }
//}
//查询角色列表
function queryRoles() {
    $("#tlist1").empty();
    $.ajax({
        type:"get",
        url:"/biz/role/findRoleAll",
        dataType:"json",
        success:function (result) {
            var data = result.obj;
            // var page = resut.page;
            // getPageInfo(page);
            for (var i=0;i<data.length;i++){
                var id=null;//角色id
                var name="";//角色名称
                var description="";//角色描述
                if (data[i].roleId!=null && data[i].roleId!=undefined) {id=data[i].roleId};
                if (data[i].roleName!=null && data[i].roleName!=undefined) {name=data[i].roleName};
                //if (data[i].description!=null && data[i].description!=undefined) {description=data[i].description};
                var tr = $("<tr class='success'></tr>");
                var td1 = $("<td></td>");
                var td2 = $("<td></td>");
                var td3 = $("<td></td>");
                var td4 = $("<td></td>");
                var td5 = $("<td></td>");
                var input = $("<input type='checkbox' class='roleId'>");
                var but1 = $("<button class=\"buttonn1\">修改</button>");
                var but2 = $("<button class=\"buttonn1\">查看</button>");
                var but3 = $("<button class=\"buttonn1\" style='width: 70px'>授权</button>");
//                for (var a=0;a<model.permissions.length;a++){
//                    // if (model.permissions[a].name=="查看角色"){
//                    //     td5.append(but2);
//                    // }
//                    if (model.permissions[a].name=="修改角色"){
//                        td5.append(" ").append(but1);
//                    }
//                    if (model.permissions[a].name=="授权"){
//                        td5.append(" ").append(but3);
//                    }
//                }
                td5.append(" ").append(but3);
                $("#tlist1").append(
                    tr.append(td1.text((i+1)+" "))
                        .append(td2.append(input.val(id)))
                        .append(td3.text(name))
                        .append(td5))
//                but1.data("role", data[i]);
//                but2.data("role", data[i]);
                but3.data("role", data[i]);
//                but1.click(function() {
//                    updat($(this).data("role"));
//                })
//                but2.click(function() {
//                    check($(this).data("role"));
//                })
                but3.click(function() {
                    menuAuthorization($(this).data("role"));
                })
            }
        }
    })
}
//反选
function fan() {
    $('.roleId:checkbox').each(function(){
        //console.log(this);
        this.checked = !this.checked;
    });
}

////修改
//function updat(role) {
//    openRole();
//    $("#insertt").text("修改角色");
//    model.role.id=role.id;
//    $(".check").hide();
//    $(".insert").hide();
//    $("#return").hide();
//    $(".update").show();
//    $("#namee").val(role.name);
//    $("#describe").val(role.description);
//}
//function saveUpdate() {
//    model.role.name = $("#namee").val().trim();
//    model.role.description = $("#describe").val().trim();
//    if (model.role.name == null||model.role.name=="") {
//        alert("请输入角色名称！");
//        return
//    }
//    console.log(model.role)
//    $.ajax({
//        type:"post",
//        url:"/role/updateRole",
//        data:JSON.stringify(model.role),
//        dataType:"json",
//        contentType:"application/json",
//        success:function (result) {
//            if (result.success == true && result.msg == "修改角色成功") {
//                alert("修改角色成功！");
//                $("#suspension").hide();
//                $("#popupWindow").hide();
//                queryRoles();
//            }else {
//                alert("修改角色失败！");
//            }
//        }
//    })
//}
////删除
//function deleteRole() {
//    var ids = new Array();
//    $(".roleId:checked").each(function () {
//        ids.push(parseInt($(this).val()));
//    })
//    if (ids==null || ids.length<=0) {
//        alert("请选择角色！")
//        return
//    }
//    $.ajax({
//        type:"post",
//        url:"/role/deleteRole",
//        traditional :true,
//        data:{ids:ids},
//        dataType:"json",
//        success:function (result) {
//            if (result.success == true && result.msg == "删除角色成功") {
//                alert("删除角色成功！");
//                queryRoles();
//            }else {
//                alert("删除角色失败！");
//            }
//        }
//    })
//}
////查看
//function check(role) {
//    openRole();
//    $(".update").hide();
//    $(".insert").hide();
//    $(".check").show();
//    $("#namee").val(role.name);
//    $("#describe").val(role.description);
//    $("#return").show();
//}
////打开新增用户
//function openRole() {
//    $(".update").hide();
//    $(".check").hide();
//    $(".insert").show();
//    $("#insertt").text("添加角色")
//    clear();
//}
//function clear(){
//    $("#suspension").show();
//    $("#popupWindow").show();
//    $("#namee").val("");
//    $("#describe").val("");
//}
////插入用户
//function insertRole() {
//    model.role.id=null;
//    model.role.name = $("#namee").val().trim();
//    model.role.description = $("#describe").val().trim();
//    if (model.role.description == null||model.role.description=="") {
//        alert("请输入角色名称！");
//        return
//    }
//    $.ajax({
//        type:"post",
//        url:"/role/addRole",
//        data:JSON.stringify(model.role),
//        dataType:"json",
//        contentType:"application/json",
//        success:function (result) {
//            if (result.success == true && result.msg == "添加角色成功") {
//                alert("添加角色成功！");
//                $("#suspension").hide();
//                $("#popupWindow").hide();
//                queryRoles();
//            }else {
//                alert("添加角色失败！")
//            }
//        }
//    })
//}
//菜单授权
function menuAuthorization(role) {
    model.resuouce.roleId=role.roleId
    $("#suspension").show();
    $("#popupWindow1").show();
    $("#rol").empty();
    $("#rol").text(role.roleName);
    //查询展示组织结构树
        $.ajax({
            type:"get",
            url:"/biz/role/viewResources",
            data:{roleId:role.roleId},
            async:false,
            dataType:"json",
            success:function (result) {
                console.log(result);
                if (result!=null && result!=undefined){
                    var data = result.resourceAll;
                    var arr = new Array();
                    for (var i=0;i<data.length;i++) {
                        var obj = {text:data[i].resourceName,nodeid:data[i].resourceId,pid:data[i].parentId,isChild:false,nodes:[]}
                        arr.push(obj);
                    }
                    arr = createTree(arr);
                    $('#tree').treeview({
                        data: arr,         // 数据源
                        showCheckbox: true,   //是否显示复选框
                        highlightSelected: true,    //是否高亮选中
                        // nodeIcon: 'glyphicon glyphicon-th-list',//节点上的图标
                        emptyIcon: '',    //没有子节点的节点图标
                        multiSelect: false,//多选
                        onNodeChecked: function (event,data) {
                            // $('#tree').treeview('uncheckAll', { silent: true });//取消选中所有的树节点
                            $('#tree').treeview('checkNode', [ data.nodeId, { silent: true } ]);
                            $('#tree').treeview('toggleNodeSelected', [ data.nodeId, { silent: true } ]);
                            $('#tree').treeview('selectNode', [ data.nodeId, { silent: true } ]);
                            var selectNodes = getChildNodeIdArr(data); //获取所有子节点
                            if (selectNodes) { //子节点不为空，则切换子节点选中状态
                                $('#tree').treeview('toggleNodeChecked', [ selectNodes, { silent: true } ]);
                                }
                        }
                    });
                    $('#tree').treeview('collapseAll', { silent: true });//折叠所有树节点，折叠整个树
                    $('#tree').treeview('expandAll', { levels: 1, silent: true });//展开树节点
                    var nodess = $('#tree').treeview('getEnabled');//返回已启用的所有节点
                    for (var i=0;i<nodess.length;i++){//选择拥有的权限节点
                        for (var j=0;j<result.roleResource.length;j++) {
                            if (nodess[i].nodeid==result.roleResource[j].resourcesId){
                                $('#tree').treeview('checkNode', [ nodess[i].nodeId, { silent: true } ]);
                            }
                        }
                    }
                    // debugger
                    // setParentNodeCheck(node);
                    // console.log(getChildNodeIdArr(node));
                }
            }
        })
}
//保存修改权限
function savePermissions() {
    var object = $('#tree').treeview('getChecked');//获取所有选中的节点
    var resouceIds = new Array();
    for (var i=0;i<object.length;i++){
        resouceIds.push(object[i].nodeid)
    }
    model.resuouce.resourceIds=resouceIds;
    $.ajax({
        type:"post",
        url:"/biz/role/assignResources",
        data:model.resuouce,
        traditional :true,
        dataType:"json",
        success:function (result) {
            if (result.success==true && result.msg=="分配权限成功") {
                alert("分配权限成功!");
                $("#suspension").hide();
                $("#popupWindow1").hide();
                queryRoles();
            }else {
                alert("分配权限失败!")
            }
        }
    })
}

//全选反选树
function getChildNodeIdArr(node) {
                 var ts = [];
                 if (node.nodes) {
                         for (x in node.nodes) {
                                 ts.push(node.nodes[x].nodeId);
                                 if (node.nodes[x].nodes) {
                                        var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
                                        for (j in getNodeDieDai) {
                                                 ts.push(getNodeDieDai[j]);
                                             }
                                     }
                             }
                     } else {
                         ts.push(node.nodeId);
                     }
                 return ts;
             }

         function setParentNodeCheck(node) {
                 var parentNode = $("#tree").treeview("getNode", node.parentId);
                 if (parentNode.nodes) {
                         var checkedCount = 0;
                         for (x in parentNode.nodes) {
                                 if (parentNode.nodes[x].state.checked) {
                                         checkedCount ++;
                                     } else {
                                         break;
                                     }
                             }
                         if (checkedCount === parentNode.nodes.length) {
                                 $("#tree").treeview("checkNode", parentNode.nodeId);
                                 setParentNodeCheck(parentNode);
                             }
                     }
             }