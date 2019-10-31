$(function () {
    selectDogCard();
});
function formatDate(date) {
    var datetime = new Date(date);
    var year = datetime.getFullYear();
    var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
    var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
    var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
    var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
    // return year + "-" + month + "-" + day + " " + hours + ":" + min;
    return year + "年" + month + "月" ;
}
function formatDate1(date) {
    var datetime = new Date(date);
    var year = datetime.getFullYear();
    var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
    var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
    var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
    var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
    // return year + "-" + month + "-" + day + " " + hours + ":" + min;
    return year + month + day;
}
//查询我的犬证
function selectDogCard() {
    $("#cards").empty();
    $.ajax({
        type:"get",
        url:"/biz/dogCard/selectElectronicDogCard",
        data:{userId:1},
        dataType:"json",
        success:function (result) {
            console.log(result);
            if (result.code=="000000" && result.result!=null && result.result!=JSON.stringify("[]")) {
                var data=result.result;
                for (var i=0;i<data.length;i++) {
                    var card='<div>\n' +
                        '                <div class="cardDiv1">\n' +
                        '                    <div id="positive'+i+ '" style="position: absolute;margin-top: 22px;margin-left: 25px;">\n' +
                        '                        <div>\n' +
                        '                            <p>\n' +
                        '                            <img style="width: 35px;height: 35px" src="../../../static/images/dogjiaoyin.png">\n' +
                        '                            <span style="margin-left: 10px;font-size: 18px;color: #ffffff">西宁市养犬证</span>\n' +
                        '                            </p>\n' +
                        '                            <div style="margin-left: 20px;margin-top: 14px">\n' +
                        '                                <p style="color: #0f0f0f"><span>犬证号：</span><span>'+data[i].dogCardNum+'</span></p>\n' +
                        '                                <p style="color: #0f0f0f"><span>标示号：</span><span>'+data[i].markNum+'</span></p>\n' +
                        '                                <p style="color: #0f0f0f"><span>犬品种：</span><span>'+data[i].dogVarieties+'</span></p>\n' +
                        '                                <p style="color: #0f0f0f"><span>犬毛色：</span><span>'+data[i].color+'</span></p>\n' +
                        '                                <p style="color: #0f0f0f"><span>年检时间：</span><span>'+formatDate(data[i].yearCheckDate)+'</span></p>\n' +
                        '                            </div>\n' +
                        '                            <img style="width: 120px;height: 145px;margin-top: -185px;margin-left: 350px" src="'+data[i].dogUrl+'">\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                    <img id="imgPositive'+i+'" class="img1" src="../../../static/images/dogCard1.jpg">\n' +
                        '                    <div id="reverse'+i+'" class="cardDiv2">\n' +
                        '                        <div style="position: absolute;margin-top: 22px;margin-left: 25px;">\n' +
                        '                            <div>\n' +
                        '                                <div style="margin-left: 20px;margin-top: 5px">\n' +
                        '                                    <p style="color: #0f0f0f"><span>犬主姓名：</span><span>'+data[i].dogOwnersName+'</span></p>\n' +
                        '                                    <p style="color: #0f0f0f"><span>联系电话：</span><span>'+data[i].phone+'</span></p>\n' +
                        '                                    <p style="color: #0f0f0f"><span>养犬地址：</span><span>'+data[i].address+'</span></p>\n' +
                        '                                    <div id="divOne'+i+'" style="margin-top: 38px;width: 90px;height: 90px;"></div>\n' +
                        '                                    <div style="font-size: 12px;margin-left: 117px;margin-top: -43px">\n' +
                        '                                        <p style="color: #0f0f0f"><span>签发单位：</span><span>'+data[i].issuanceUnit+'</span></p>\n' +
                        '                                        <p style="color: #0f0f0f"><span>初始签发日期：</span><span>'+formatDate1(data[i].startDate)+'</span></p>\n' +
                        '                                        <img style="width: 120px;height: 120px;margin-top: -340px;margin-left: 232px" src="../../../static/images/cardX.png">\n' +
                        '                                    </div>\n' +
                        '                                </div>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                    </div>\n' +
                        '                    <div class="cardDiv3"><img class="img2" src="../../../static/images/qiehuan.png" onclick="switchCard('+i+ ');"></div>\n' +
                        '                </div>\n' +
                        '            </div>';
                    $("#cards").append(card);
                    pictureTurnCode(i,data[i].markNum);
                }
            }
        }
    })
}

//文字转二维码图片
function pictureTurnCode(i,markNum) {
    var qrcode=$("#divOne"+i).qrcode({
        render:'canvas||table',
        width: 90, //宽度
        height:90, //高度
        text: markNum //任意内容
    });
}
//反转犬证
function switchCard(i) {
    if ($("#positive"+i).is(":hidden") && $("#imgPositive"+i).is(":hidden")) {
        $("#reverse"+i).hide();
        $("#positive"+i).show();
        $("#imgPositive"+i).show();
    }else if ($("#reverse"+i).is(":hidden")) {
        $("#positive"+i).hide();
        $("#imgPositive"+i).hide();
        $("#reverse"+i).show();
    }
}




//如果内容中有中文，在生成二维码钱就要把字符串转换成utf-8
function toUtf8(str) {
    var out, i, len, c;
    out = "";
    len = str.length;
    for (i = 0; i < len; i++) {
        c = str.charCodeAt(i);
        if ((c >= 0x0001) && (c <= 0x007F)) {
            out += str.charAt(i);
        } else if (c > 0x07FF) {
            out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
            out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
        } else {
            out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
        }
    }
    return out;
}