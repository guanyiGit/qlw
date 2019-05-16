var model={
    formatDate: function(date) {
        var datetime = new Date(date);
        var year = datetime.getFullYear();
        var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
        var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
        var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
        var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
        // return year + "-" + month + "-" + day + " " + hours + ":" + min;
        return year + "/" + month + "/" + day;
    },
    DateToUnix: function(string) {
        var f = string.split('-', 2);
        var d = (f[0] ? f[0] : '').split('-', 3);
        var t = (f[1] ? f[1] : '').split(':', 3);
        return (new Date(
            parseInt(d[0], 10) || null,
            (parseInt(d[1], 10) || 1) - 1,
            parseInt(d[2], 10) || null,
            parseInt(t[0], 10) || null,
            parseInt(t[1], 10) || null,
            parseInt(t[2], 10) || null
        )).getTime()/1000;
    },
    data:{TypeNumber:null,status:null,pageNum:1},//TypeNumber 0：政策法规 1：动态资讯 2:养犬宣传 3：服务指南 status:0审核中，1上架，2下架
    data1:{pn:1,pageSize:10,string:null,status:1},
    data2:{provinceId : null,ownedCityId : null,districtId : null,orgtype : 2,status : 1,page:1}//服务网点参数
}
$(function () {
    buttonBinding();
    selectPolicyRules();
    selectknowledge();
    dynamicInformation();
    loveToAdopt();//爱心领养
    $('#b06').unslider({
        speed: 1000,
        delay: 3000,
        autoplay: true,
        dots: true,
        loop:true,
        arrows:false,
        items: '>ul',   // 幻灯片的容器选择器
        item: '>li',    // 需要滚动的选择器
        easing: 'swing',// 动画的缓动函数(easing function)
        starting:function(){
            // alert("执行");
            var ul = $("#cul");
            ul.children("li:first").insertAfter(ul.children("li:last"));
        }
    });
    // for (var i=0;i<5;i++){
    //     var tb = buffer.toString();
    //     var tbRight = bufferRight.toString();
    //     var rw = tb+tbRight;
    //     $(rw).appendTo($("#test"));
    // }
    serviceOutlets();//服务网点
    shufflingFigure();//危险犬种
});
//点击登陆跳转登陆页
function jumpLanding() {
    window.location.href="../../../static/views/login/login.html";
    // window.location.href="../../../static/index.html";
}
//按钮绑定跳转页面
function buttonBinding() {
    $("#axly").click(function () {
        $("#caidanhou").hide();
        $("#mainer").show();
        $("#homee").load("../../static/views/dog/lovingAdoption.html");
    })
    $("#fwzn").click(function () {
        sessionStorage.setItem("type",3);
        $("#caidanhou").hide();
        $("#mainer").show();
        $("#homee").load("../../static/views/headPage/dynamicInformation.html");
    })
    $("#zcfgggg").click(function () {
        sessionStorage.setItem("type",0);
        $("#caidanhou").hide();
        $("#mainer").show();
        $("#homee").load("../../static/views/headPage/dynamicInformation.html");
    })
    $("#jypz").click(function () {
        $("#caidanhou").hide();
        $("#mainer").show();
        $("#homee").load("../../static/views/headPage/dogKindOfBan.html");
    })
    $("#yqzsss").click(function () {
        sessionStorage.setItem("type",2);
        $("#caidanhou").hide();
        $("#mainer").show();
        $("#homee").load("../../static/views/headPage/dynamicInformation.html");
    })
    $(".zx").click(function () {
        sessionStorage.setItem("type",3);
        $("#homee").load("../../static/views/headPage/dynamicInformation.html");
    });
    $("#fwwdzc").click(function () {
        $("#homee").load("../../static/views/headPage/serviceNetworkRegistration.html");
    });
    $(".fwwdd").click(function () {
        $("#homee").load("../../static/views/dog/serviceNetwork.html");
    });
}
//爱心领养
function loveToAdopt() {
    $("#adoptNum").empty();
    $("#test").empty();
    $.ajax({
        type:"get",
        url:"/biz/collection/findCollectionList",
        async:false,
        data:model.data1,
        dataType:"json",
        success:function (results) {
            // console.log(111)
            console.log(results)
            if (results.status==200 && results.data != null && results.data != JSON.stringify("[]")) {
                $("#adoptNum").text(results.data.totalRecord);
                var data=results.data.lists;
                var left="";
                for (var i=0;i<data.length;i++) {
                    var dogGender="";
                    if (data[i].dogGender==0) {
                        dogGender="男";
                    }else if (data[i].dogGender==0) {
                        dogGender="女";
                    }
                    var a=i+1
                    if (a%2==1){
                        //奇数 左边的
                        var buffer = new StringBuffer();
                        buffer.append('<div  class="row " style="width: 250px;height: 120px;display: inline-block;">');
                        buffer.append('<div class="col-sm-4">');
                        buffer.append('<img style="width: 100px;height: 100px;" src=' + data[i].thumbnailUrl + '>');
                        buffer.append('</div>');
                        buffer.append('<div class="col-sm-6" style="height: 100%;line-height: 40px;margin-left: 41px" >');
                        buffer.append('<table style="width: 200px;height: 60px">');
                        buffer.append('<tr align="center">');
                        buffer.append('<td colspan="8" align="center"><B>姓名</B></td>');
                        buffer.append('<td colspan="8" style="color: rgb(255, 153, 102)">'+data[i].dogName+'</td>');
                        buffer.append('<td colspan="8"><font color="#f65">'+data[i].dogBreed+'</font></td>');
                        buffer.append('</tr>');
                        buffer.append('<tr align="center">');
                        buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">性别:</td>');
                        buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+dogGender+'</td>');
                        buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">毛色:</td>');
                        buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+data[i].dogColor+'</td>');
                        buffer.append('</tr>');
                        buffer.append('<tr align="center">');
                        buffer.append('<td colspan="24" align="center" style="font-family: 微软雅黑; color: rgb(153, 153, 153);"><button id=adopt'+i+' class="btn btn-warning">立即领养</button></td>');
                        buffer.append('</tr>');
                        buffer.append('</table>');
                        buffer.append('</div>');
                        buffer.append('</div>');
                        left=buffer.toString();
                        $(left).appendTo($("#test"));
                    }else {
                        //偶数
                        var bufferRight = new StringBuffer();
                        bufferRight.append('<div  class="row" style="width: 250px;height: 120px;display: inline-block;margin-left: 92px">');
                        bufferRight.append('<div class="col-sm-4">');
                        bufferRight.append('<img style="width: 100px;height: 100px;" src=' + data[i].thumbnailUrl + '>');
                        bufferRight.append('</div>');
                        bufferRight.append('<div class="col-sm-6" style="height: 100%;line-height: 40px;margin-left: 41px" >');
                        bufferRight.append('<table style="width: 200px;height: 60px">');
                        bufferRight.append('<tr align="center">');
                        bufferRight.append('<td colspan="8" align="center"><B>姓名</B></td>');
                        bufferRight.append('<td colspan="8" style="color: rgb(255, 153, 102)">'+data[i].dogName+'</td>');
                        bufferRight.append('<td colspan="8"><font color="#f65">'+data[i].dogBreed+'</font></td>');
                        bufferRight.append('</tr>');
                        bufferRight.append('<tr align="center">');
                        bufferRight.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">性别:</td>');
                        bufferRight.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+dogGender+'<td>');
                        bufferRight.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">毛色:</td>');
                        bufferRight.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">'+data[i].dogColor+'</td>');
                        bufferRight.append('</tr>');
                        bufferRight.append('<tr align="center">');
                        bufferRight.append('<td colspan="24" align="center" style="font-family: 微软雅黑; color: rgb(153, 153, 153);"><button id=adopt'+i+' class="btn btn-warning">立即领养</button></td>');
                        bufferRight.append('</tr>');
                        bufferRight.append('</table>');
                        bufferRight.append('</div>');
                        bufferRight.append('</div>');
                        var tbRight = bufferRight.toString();
                        $(tbRight).appendTo($("#test"));
                    }
                    $("#adopt"+i).data("collectionId",data[i].collectionId);
                    $("#adopt"+i).data("adoptionPublicityId",data[i].adoptionPublicityId);
                    $("#adopt"+i).click(function () {
                        window.sessionStorage.setItem("collectionId", $(this).data("collectionId"));
                        window.sessionStorage.setItem("adoptionPublicityId", $(this).data("adoptionPublicityId"));
                        $("#homee").load("views/dog/adoptionApplication.html");
                    })
                }
            }
        }
    })
}

//服务网点
function serviceOutlets() {
    $("#fwwdTable").empty();
    $.ajax({
        type:"post",
        url:"/biz/serviceSite/getServiceSitesforAdmin",
        data:model.data2,
        dataType:"json",
        success:function (results) {
            // console.log(111)
            // console.log(results)
            if (results.status==200 && results.data != null) {
                if (results.data.list != null && results.data.list != JSON.stringify("[]")) {
                    var data = results.data.list;
                    for (var i=0;i<5 && i<data.length;i++){
                        if (data[i].pictureUrl!=null && data[i].pictureUrl!=JSON.stringify("[]")) {
                            var url=data[i].pictureUrl[0]?data[i].pictureUrl[0]:"";
                        }
                        var name=data[i].organizationName?data[i].organizationName:"";
                        var phone=data[i].phone?data[i].phone:"";
                        var address=data[i].address?data[i].address:"";
                        var id="id"+i;
                        var tr=$('<tr data-index="0">\n' +
                            '<td style="width: 200px; ">\n' +
                            '<div class="row hhh" style="text-align: center">\n' +
                            '<div class="col-sm-4 " style="top: 14px  ">\n' +
                            '<img style="width: 75px;height: 75px;" src='+url+'>\n' +
                            '</div>\n' +
                            '<div class="col-sm-6" style="height: 100%;line-height: 40px">\n' +
                            '<table style="width: 170px;height: 60px;line-height: 28px">\n' +
                            '<tbody>\n' +
                            '<tr align="left">\n' +
                            '<td colspan="1" align="left">\n' +
                            '<span style="left: 0px"><b>'+name+'</b></span>\n' +
                            '<span style="position: absolute;right:-42px"><a id='+id+' style="color: red">预约</a></span>\n' +
                            '</td>\n' +
                            '</tr>\n' +
                            '<tr align="left"><td colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">电话：'+phone+'</td></tr>\n' +
                            '<tr align="left"><td colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);"><font size="2">地址:' + address+'</font></td></tr>\n' +
                            '</tbody>\n' +
                            '</table>\n' +
                            '</div>\n' +
                            '</div>\n' +
                            '</td>\n' +
                            '</tr>');
                        $("#fwwdTable").append(tr);
                        $("#"+id).data("organizationId",data[i].organizationId);
                        $("#"+id).click(function () {
                            // alert($(this).data("organizationId"));
                        })
                    }
                }
            }
        }
    });
}

//查询政策法规//TypeNumber 0：政策法规 1：动态资讯 2:养犬宣传 3：服务指南 status:0审核中，1上架，2下架
function selectPolicyRules() {
    model.data.status=1;
    model.data.TypeNumber=0;
    $.ajax({
        type:"post",
        url:"/biz/information/getInformations",
        data:model.data,
        success:function (reslults) {
            if (reslults.status==200 && reslults.data!=null) {
                if (reslults.data.list!=null && reslults.data.list!=JSON.stringify("[]") && reslults.data.list.length>0) {
                    $("#zcfg").empty();
                    var data=reslults.data.list;
                    for (var i=0;i<data.length;i++){
                        var title=data[i].infoTitile?data[i].infoTitile:'';
                        var date=data[i].creationTime?model.formatDate(data[i].creationTime):"";
                        var dv=$("                        <hr style=\"border: 1px solid #0f0f0f;width: 100%;color:gray;size: 1px;height:0px\">\n" +
                            "                        <div style=\"margin-left: 20px;margin-right: 20px;text-align: center\">\n" +
                            "                            <label class=\"pull-left\" style=\"white-space: nowrap; text-align: left; font-size: 16px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);\">" +title+"</label>\n" +
                            "                            <label class=\"pull-right\" style=\"white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);\">" +date+"</label>\n" +
                            "                        </div>");
                        $("#zcfg").append(dv);
                        dv.data("informationId",data[i].informationId);
                        dv.click(function () {
                            sessionStorage.setItem("informationId",this.data("informationId"));
                            $("#home").load("../../../static/views/headPage/InforDetails.html");
                        });
                    }
                }
            }
        }
    })
}

//养犬知识//TypeNumber 0：政策法规 1：动态资讯 2:养犬宣传 3：服务指南 status:0审核中，1上架，2下架
function selectknowledge() {
    model.data.status=1;
    model.data.TypeNumber=2;
    $.ajax({
        type:"post",
        url:"/biz/information/getInformations",
        data:model.data,
        success:function (reslults) {
            if (reslults.status==200 && reslults.data!=null) {
                if (reslults.data.list!=null && reslults.data.list!=JSON.stringify("[]") && reslults.data.list.length>0) {
                    $("#yqzs").empty();
                    var data=reslults.data.list;
                    for (var i=0;i<data.length;i++){
                        var title=data[i].infoTitile?data[i].infoTitile:'';
                        var date=data[i].creationTime?model.formatDate(data[i].creationTime):"";
                        var dv=$("<hr style=\"border: 1px solid #0f0f0f;width: 100%;color:gray;size: 1px\">\n" +
                            "                        <div style=\"margin-left: 20px;margin-right: 20px;text-align: center\">\n" +
                            "                            <label class=\"pull-left\" style=\"white-space: nowrap; text-align: left; font-size: 16px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);\">" +title+"</label>\n" +
                            "                            <label class=\"pull-right\" style=\"white-space: nowrap; text-align: left; font-size: 14px; font-weight: 400; font-style: normal; text-decoration: none; font-family: 微软雅黑; color: rgb(0, 0, 0);\">" +date+"</label>\n" +
                            "                        </div>");
                        $("#yqzs").append(dv);
                        dv.data("informationId",data[i].informationId);
                        dv.click(function () {
                            sessionStorage.setItem("informationId",this.data("informationId"));
                            $("#home").load("../../../static/views/headPage/InforDetails.html");
                        });
                    }
                }
            }
        }
    })
}

//动态资讯//TypeNumber 0：政策法规 1：动态资讯 2:养犬宣传 3：服务指南 status:0审核中，1上架，2下架
function dynamicInformation() {
    model.data.status=1;
    model.data.TypeNumber=1;
    $.ajax({
        type:"post",
        url:"/biz/information/getInformations",
        data:model.data,
        success:function (reslults) {
            if (reslults.status==200 && reslults.data!=null) {
                if (reslults.data.list!=null && reslults.data.list!=JSON.stringify("[]") && reslults.data.list.length>0) {
                    var data=reslults.data.list;
                    for (var i=0;i<data.length && i<6;i++){
                        var title=data[i].infoTitile?data[i].infoTitile:'';
                        $("#p"+i).text(title);
                        $("#p"+i).data("informationId",data[i].informationId);
                        $("#p"+i).click(function () {
                            sessionStorage.setItem("informationId",this.data("informationId"));
                            $("#home").load("../../../static/views/headPage/InforDetails.html");
                        });
                    }
                }
            }
        }
    })
}

//轮播图--危险犬只品种
function shufflingFigure() {
    $.ajax({
        type:"post",
        url:"/biz/dogAndOwner/selectDogBanList",
        data:{num:1,size:24},
        success:function (reslults) {
            if (reslults.code=="000000" && reslults.result!=null) {
                var count=reslults.result.page.totalCount?reslults.result.page.totalCount:"";
                $("#dangerousDog").text(count);
                var data=reslults.result.dogInfos;
                if (data != null && data != JSON.stringify("[]")) {
                    for (var i=0;i<data.length && i<24;i++){
                        var url=data[i].thumbnailUrl?data[i].thumbnailUrl:'';
                        $("#img"+i).attr("src",url);
                    }
                }
            }
        }
    })
}