var logUser={username:null,password:null}

//页面载入完毕后执行
$(function() {
    // $.ajaxSetup({
    //     async: false
    // });
    //给登录按钮绑定单击处理
    $("#login").click(function(){
        login();
    });
    $("#loginName").focus(function(){
        $("#count_span").empty();
    });
    $('#password').focus(function(){
        $("#count_span").empty();
    });
});
//登录处理
function login() {
    var ok = true;
    //获取请求参数
    var username = $("#loginName").val().trim();
    var password = $("#password").val().trim();
    logUser.username=username;
    logUser.password=password;
    //检测参数格式
    // var accReg=/^\d{12}$/;
    var mmReg=/^[a-zA-Z0-9]{6,15}$/;
    // if (accAccount == ""||!accReg.test(accAccount)) {
    //     ok = false;
    //     $("#count_span").empty().html("工号为8位数字");
    // }
    if (password == ""||!mmReg.test(password)) {
        ok = false;
        $("#count_span").empty().html("密码错误!");
    }
    //发送Ajax请求
    if (ok) {
        var url = "/biz/login"+"?"+Math.random();
        $.post(url, logUser, function(results) {
            console.log(results)
            if (results.status == 200 && results.data!=null) {
                //window.user=results.data;
                //sessionStorage.setItem("user",results.data);
                //window.location.href="../../../static/index.html";
            }else if (results.status == 200 && results.data==null) {
                //window.location.href="../../../static/index.html";
            }else {
                $("#count_span").empty().html(results.msg);
            }
        },'json');
    }
};