// /*
//  * To change this license header, choose License Headers in Project Properties.
//  * To change this template file, choose Tools | Templates
//  * and open the template in the editor.
//  */
//
// // 登录请求
// function login() {
//
//     var account = $("#account").val().trim();
//     var password = $("#password").val().trim();
//
//     $.ajax({
//         type: "post",
//         url: "acc/login.do" + "?" + Math.random(),
//         contentType: "application/json",
//         dataType: "json",
//         data: JSON.stringify({"account": account, "password": password}),
//         success: function(result) {
//
//             if (result.code == "000000") {
//                 setCookie("ACCOUNT_ID", result.result);
//                 setCookie("ACCOUNT", account);
//                 window.location.href = "/index.html";
//             } else {
//                 alert(result.message);
//             }
//         }
//     });
// }
//
// // 登出
// function logout() {
//     $.ajax({
//         type: "get",
//         url: "../acc/logout.do" + "?" + Math.random(),
//         success: function(result) {
//             window.location.href = "/login.html";
//         }
//     });
// }
//
// // 检测是否已登录
// function checkLogin() {
//     $.ajax({
//         type: "get",
//         url: "../acc/checkLogin.do" + "?" + Math.random(),
//         success: function(result) {
//         }
//     });
// }
//
// // 新增账号
// function addAccount() {
//     var account = $("#acount").val().trim();
//     var password = $("#password").val().trim();
//     var repassword = $("#repassword").val().trim();
//     var name = $("#name").val().trim();
//     var type = $('#type').val();
//     var description = $("#description").val().trim();
//
//     if (account == null || account == "") {
//         alert("请输入登录账号！");
//         return;
//     }
//
//     if (password == null || password == "") {
//         alert("请输入登录密码！");
//         return;
//     }
//
//     if (repassword == null || repassword == "") {
//         alert("请确认登录密码！");
//         return;
//     }
//
//     if (password != repassword) {
//         alert("两次输入登录密码不一致！");
//         return;
//     }
//
//     if (name == null || name == "") {
//         alert("请确认账号名称！");
//         return;
//     }
//
//     $.ajax({
//         type: "post",
//         url: "../acc/create.do" + "?" + Math.random(),
//         contentType: "application/json",
//         dataType: "json",
//         data: JSON.stringify({"account": account, "password": password, "type": type, "name": name, "description": description}),
//         success: function(result) {
//
//             if (result.code == "000000") {
//                 alert("新增账号成功！");
//             } else {
//                 alert(result.message);
//             }
//         }
//     });
// }