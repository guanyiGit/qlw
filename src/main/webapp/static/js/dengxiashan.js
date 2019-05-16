$(function () {
    selectUser();
    // $("#sidebar-nav a").click(function () {
    //     $("#sidebar-nav a").removeClass("active");
    //     $(this).addClass("active");
    // });
    bandPage();
    // selcetResource();
})
//退出
function logOut() {
    $.ajax({
        type: "get",
        url:"/biz/logout",
        success:function (results) {
            if (results!=null){
                window.location.href="../../../static/views/homePage/homePage.html";
            }
        }
    })
}
//获取用户信息
function selectUser() {
    $.ajax({
        type: "post",
        url:"/biz/getUSerInfo",
        async:false,
        dataType:"json",
        success:function (results) {
            if (results.status==200 && results.data!=null) {
                var user=results.data;
                $("#user_name").text(user.name);
                sessionStorage.setItem("user",JSON.stringify(user));
            }
        }
    })
}
//获取资源权限
function selcetResource() {
    $(".menuu").hide();
    $.ajax({
        type:"post",
        url:"/biz/resource/getResources",
        dataType:"json",
        success:function (results) {
            console.log(111)
            console.log(results);
            if (results.status==200 && results.data!=null && results.data!=JSON.stringify("[]")) {
                var data=results.data;
                sessionStorage.setItem("resource",data);
                for (var i=0;i<data.length;i++) {
                    var res=data[i];
                    if (res!=null){
                        if (res.description!=null){
                            if (res.description.indexOf("犬只办--首页")>=0){
                                $("#qzbsy").show();
                            }
                            if (res.description.indexOf("收容所--首页")>=0){
                                $("#srssy").show();
                            }
                            if (res.description.indexOf("宠物医院--首页")>=0){
                                $("#cwyysy").show();
                            }
                            if (res.description.indexOf("运营方--首页")>=0){
                                $("#yyfsy").show();
                            }
                            if (res.description.indexOf("犬只办--犬只档案")>=0){
                                $("#qzda").show();
                            }
                            if (res.description.indexOf("犬只办--犬主档案")>=0){
                                $("#qzdn").show();
                            }
                            if (res.description.indexOf("犬只办--犬证管理")>=0 || res.description.indexOf("收容所--犬证管理")>=0){
                                $("#qzgl").show();
                            }
                            if (res.description.indexOf("信息发布")>=0){
                                $("#xxfb").show();
                            }
                            if (res.description.indexOf("犬只办--电子围栏")>=0){
                                $("#dzwl").show();
                            }
                            if (res.description.indexOf("犬只办--禁养犬种")>=0){
                                $("#jyqz").show();
                            }
                            if (res.description.indexOf("收容所--犬只收容")>=0){
                                $("#qzsr").show();
                            }
                            if (res.description.indexOf("收容所--执法管理")>=0){
                                $("#zfgl").show();
                            }
                            if (res.description.indexOf("黑名单")>=0){
                                $("#hmd").show();
                            }
                            if (res.description.indexOf("收容所--会员证办理")>=0){
                                $("#hyzbl").show();
                            }
                            if (res.description.indexOf("宠物医院--病历记录")>=0){
                                $("#bljl").show();
                            }
                            if (res.description.indexOf("宠物医院--免疫证办理")>=0 || res.description.indexOf("宠物医院--犬证办理")>=0){
                                $("#zjbl").show();
                            }
                            if (res.description.indexOf("运营方--设备管理")>=0){
                                $("#yyfsbgl").show();
                            }
                            if (res.description.indexOf("运营方--信息审核")>=0){
                                $("#xxsh").show();
                            }
                            if (res.description.indexOf("服务网点审核")>=0){
                                $("#fwwdsh").show();
                            }
                            if (res.description.indexOf("权限管理")>=0){
                                $("#qxgl").show();
                            }
                        }
                    }
                }
                $("#interface").children("li:visible").get(0).click();
            }
        }
    })
}
//绑定页面跳转
function bandPage() {
    $(".syy").click(function () {
        $("#home").load("../../static/views/homePage/visitorHomePage.html");
    })
    $(".axlyy").click(function () {
        $("#home").load("../../static/views/dog/lovingAdoption.html");
    })
    $(".fwznn").click(function () {
        sessionStorage.setItem("type",3);
        $("#home").load("../../static/views/headPage/dynamicInformation.html");
    })
    $(".zcfgg").click(function () {
        sessionStorage.setItem("type",0);
        $("#home").load("../../static/views/headPage/dynamicInformation.html");
    })
    $(".jypzz").click(function () {
        $("#home").load("../../static/views/headPage/dogKindOfBan.html");
    })
    $(".dtzxx").click(function () {
        sessionStorage.setItem("type",1);
        $("#home").load("../../static/views/headPage/dynamicInformation.html");
    })
    $(".yqzss").click(function () {
        sessionStorage.setItem("type",2);
        $("#home").load("../../static/views/headPage/dynamicInformation.html");
    })



    $("#qzbsy").click(function () {
        $("#home").load("views/homePage/dogsdoHomePage.html");
    });
    $("#srssy").click(function () {
        $("#home").load("views/homePage/hospiceHomePage.html");
    });
    $("#cwyysy").click(function () {
        $("#home").load("views/homePage/petClinicHomePage.html");
    });
    // $("#qzsy").click(function () {//犬主首页
    //     $("#home").load("views/homePage/petClinicHomePage.html");
    // });
    $("#yyfsy").click(function () {
        $("#home").load("views/homePage/operatorHomePage.html");
    });
    $("#qzda").click(function () {
        $("#home").load("views/dog/dogFiles.html");
    });
    $("#qzdn").click(function () {
        $("#home").load("views/dog/dogMasterFile.html");
    });
    // $("#wzqz").click(function () {//无证犬只
    //     $("#home").load("views/homePage/petClinicHomePage.html");
    // });
    $("#qzgl").click(function () {
        $("#home").load("views/dogCard/dogCardHandle.html");
    });
    $("#hmd").click(function () {
        $("#home").load("views/blanklist/blankListFile.html");
    });
    // $("#zfcf").click(function () {//执法处罚
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#fwwd").click(function () {//服务网点
    //     $("#home").load("views/homePage/petClinicHomePage.html");
    // });
    $("#xxfb").click(function () {//信息发布
        $("#home").load("views/info/infoRelease.html");
    });
    // $("#qzbsbgl").click(function () {//犬只办设备管理
    //     $("#home").load("views/homePage/petClinicHomePage.html");
    // });
    $("#dzwl").click(function () {//电子围栏
        $("#home").load("views/map/fence.html");
    });
    // $("#qzbsrsqzzx").click(function () {//犬只办/收容所犬只注销
    //     $("#home").load("views/homePage/petClinicHomePage.html");
    // });
    $("#jyqz").click(function () {
        $("#home").load("views/dog/banDogList.html");
    });
    // $("#qzbtjxx").click(function () {//犬只办统计信息
    //     $("#home").load("views/homePage/petClinicHomePage.html");
    // });
    $("#zfgl").click(function () {
        $("#home").load("views/lawEnforcement/enforcementManage.html");
    });
    $("#qzsr").click(function () {//犬只收容
        $("#home").load("views/dog/canineCollection.html");
    });
    $("#hyzbl").click(function () {
        $("#home").load("views/dogCard/memberHandle.html");
    });
    // $("#wtcl").click(function () {//问题处理
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#srssbgl").click(function () {//收容所宠物医院设备管理
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
//     $("#srstjxx").click(function () {//收容所统计信息
//         $("#home").load("views/lawEnforcement/enforcementManage.html");
//     });
    $("#zjbl").click(function () {
        $("#home").load("views/immunisation/immunisation.html");
    });
    $("#mydj").click(function () {
        $("#home").load("views/immunisation/immuneToRegisterList.html");
    });
    // $("#njgl").click(function () {//年检管理
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    $("#bljl").click(function () {
        $("#home").load("views/medical_history/medical_history_List.html");
    });
    // $("#yygl").click(function () {//预约管理
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#yytjxx").click(function () {//医院统计信息
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#wdxx").click(function () {//我的信息
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#wdqz").click(function () {//我的犬证
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#wdcw").click(function () {//我的宠物
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#hdgj").click(function () {//活动轨迹
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#qzywyy").click(function () {//犬主业务预约
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    $("#yyfsbgl").click(function () {//运营方设备管理
        $("#home").load("views/device_manager/device_manager-active.html");
    });
    $("#xxsh").click(function () {//信息审核
        $("#home").load("views/message_moderation/message_moderation.html");
    });
    $("#fwwdsh").click(function () {//服务网点审核
        $("#home").load("views/serviceSite/ServiceSiteExamineList.html");
    });
    // $("#lbtgl").click(function () {//轮播图管理
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    // $("#yyftjxx").click(function () {//运营方统计信息
    //     $("#home").load("views/lawEnforcement/enforcementManage.html");
    // });
    $("#qxgl").click(function () {//权限管理
        $("#home").load("views/Operator_manager/power_manager.html");
    });
}
