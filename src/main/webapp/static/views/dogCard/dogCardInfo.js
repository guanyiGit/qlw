//定义model对象
var model = {
    formatDate: function(date) {
        var datetime = new Date(date);
        var year = datetime.getFullYear();
        var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
        var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
        var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
        var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
        // return year + "-" + month + "-" + day + " " + hours + ":" + min;
        return year + "-" + month + "-" + day;
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
    booll:false,
    user:null,
    InertDogCard:{
        seqNum:null,//犬证id
        dogId:null,//犬id
        dogOwnerId:null,//犬主id
        memberCardId:null,//会员证id
        dogCardNum:null,//证书编号
        startTime:null,//犬证有效期开始时间
        endTime:null,//犬证有效期结束时间
        lssueTime:null,//犬证签发时间
        lssueOrgId:null,//发证机构id
        lssuerId:null,//签发人，办理人
        status:null,//犬证状态
        deviceId:null,//设备id
        useStatus:null,//使用状态
        creationTime:null,//设备创建时间/有效起始时间
        expireTime:null,//设备过期时间
        phone:null,//电话
        name:null,//姓名
        gender:null,//性别
        email:null,//邮箱
        orgType:null//机构类型
}
}

$(function () {
    model.user=JSON.parse(sessionStorage.getItem("user"));
    model.InertDogCard.lssueOrgId=model.user.organizationId;
    model.InertDogCard.lssuerId=model.user.userId;
    console.log(model.user)
    $("#add input").empty();
    $("#filePicker").empty();
    judge();
    selectImmuneCardNum();//查询所有免疫证号
    //查询展示免疫证信息相关
    old_value = $("#immuneNum").val();
    $("#immuneNum").focus(function () {
        if ($("#immuneNum").val() == "") {
            AutoComplete("auto_div", "immuneNum", cusids);
        }
    });
    $("#immuneNum").keyup(function () {
        AutoComplete("auto_div", "immuneNum", cusids);
    });
    $(document).click(function () {
        $("#bigImg").hide();
    })
});
//判断是查看还是录入页面
var dogId=null;
function judge() {
    selectUser();//查用户信息
    var type=sessionStorage.getItem("pageType");
    if (type=="check") {
        $(".check").attr("readOnly","readOnly");
        dogId=sessionStorage.getItem("dogId");
        selectRelatedInfo(dogId);
        sessionStorage.setItem("pageType","");
        sessionStorage.setItem("dogId","");
        $(".an").hide();
    }else if (type=="insert") {
        $(".check").removeAttr("readOnly");
        $("#update").hide();
        $("#insert").show();
        $("#que").show();
        var date=model.formatDate(new Date());
        $("#dqfrq").val(date);
        $("#dyxqxk").val(date);
        $("#xqfrq").val(date);
        $("#xyxqxk").val(date);
        $("#dqfjg").val(model.user.department);
        $("#xqfjg").val(model.user.department);
    }else if (type=="update") {
        $(".check").attr("readOnly","readOnly");
        dogId=sessionStorage.getItem("dogId");
        selectRelatedInfo(dogId);
        sessionStorage.setItem("pageType","");
        sessionStorage.setItem("dogId","");
        $("#insert").hide();
        $("#update").show();
        $("#que").show();
    }
}
var mess=null;
//根据项圈或设备编号查犬只id
function selectDiviceId() {
    $("#tishi").hide();
    var num=$("#xqbh").val().trim();
    $.ajax({
        type:"get",
        url:"/biz/dogCard/selectDogIdByDeviceId",
        data:{deviceNumber:num},
        dataType: "json",
        success:function (results) {
            if (results.code=="000000" && results.result!=null) {
                model.booll=false;
                $("#tishi").attr("src","../../static/images/cha.png");
                $("#tishi").show();
                mess="项圈已占用！"
            }else {
                selectDivce(num);
            }
        }
    })
}
//录入生成犬证
function insertDogCard() {
    if ($("#xqbh").val().trim()==null || $("#xqbh").val().trim()==""){
        alert("项圈编号不能为空!");
        return
    }
    if ($("#immuneNum").val().trim()==null || $("#immuneNum").val().trim()==""){
        alert("免疫证号不能为空!");
        return
    }
    if (model.booll) {
        model.InertDogCard.startTime=model.DateToUnix($("#dyxqxk").val().trim());
        model.InertDogCard.endTime=model.DateToUnix($("#dyxqxj").val().trim());
        model.InertDogCard.lssueTime=model.DateToUnix($("#dqfrq").val().trim());
        model.InertDogCard.creationTime=model.DateToUnix($("#xyxqxk").val().trim());
        model.InertDogCard.expireTime=model.DateToUnix($("#xyxqxj").val().trim());
        model.InertDogCard.status=1;
        model.InertDogCard.lssueOrgId=1;//待补充
        model.InertDogCard.lssuerId=1;//待补充
        model.InertDogCard.orgType=1;//待补充

        $.ajax({
            type:"post",
            url:"/biz/dogCard/insertDogCard",
            data:JSON.stringify(model.InertDogCard),
            dataType: "json",
            contentType:"application/json",
            success:function (results) {
                if (results.code=="000000" && results.result!=null) {
                    alert(results.result);
                    $(".an").hide();
                    selectRelatedInfo(model.InertDogCard.dogId);
                }else {
                    alert("生成犬证失败!");
                }
            }
        })
    }else {
        alert(mess);
    }
}
//查设备id
function selectDivce(diviceNum) {
    $.ajax({
        type:"get",
        url:"/biz/dogCard/selectDiviceIdByNum",
        async: false,
        data:{deviceNumber:diviceNum},
        dataType: "json",
        success:function (results) {
            if (results.code=="000000" && results.result!=null) {
                model.InertDogCard.deviceId=results.result;//设备id
                $("#tishi").attr("src","../../static/images/gou.png");
                $("#tishi").show();
                model.booll=true;
            }else {
                model.booll=false;
                $("#tishi").attr("src","../../static/images/cha.png");
                $("#tishi").show();
                mess="项圈不存在！"
            }
        }
    })
}
//返回
function returnn() {
    if (sessionStorage.getItem("orgRes")=="other") {
        $("#home").load("views/dogCard/dogCardHandle.html");
    }else if (sessionStorage.getItem("orgRes")=="hospital") {
        $("#home").load("views/immunisation/immunisation.html");
    }
}
//根据用户id查用户信息
function selectUser() {
    model.user=null;
    $.ajax({
        type:"get",
        url:"/biz/dogCard/selectImmuneCardNums",
        async: false,
        data:{userId:1},
        dataType: "json",
        success:function (results) {
            if (results.code=="000000" && results.result!=null) {
                model.user = results.result;
                model.InertDogCard.lssueOrgId=model.user.organizationId;//发证机构id
                model.InertDogCard.lssuerId=model.user.userId;
            }
        }
    })
}
//查询所有免疫证号
function selectImmuneCardNum() {
    $.ajax({
        type:"get",
        url:"/biz/dogCard/selectImmuneCardNums",
        async: false,
        dataType: "json",
        success:function (results) {
            if (results.code=="000000" && results.result!=null) {
                cusids = results.result;
            }
        }
    })
}
//根据免疫证号查询相关信息
function selectRelatedInfo(dogId){
    var cardNum=$("#immuneNum").val().trim();
    $.ajax({
        type:"get",
        url:"/biz/dogCard/selectDogCardInfo",
        data:{cardNum:cardNum,dogId:dogId},
        dataType: "json",
        success:function (results) {
            console.log(results)
            if (results.code=="000000" && results.result!=null) {
                var data = results.result;
                if (data.tMemberCard!=null) {
                    model.InertDogCard.memberCardId=data.tMemberCard.memberCardId;
                }
                if (data.immuneCard!=null) {
                    $("#immuneNum").val(data.immuneCard.immuneCardNum?data.immuneCard.immuneCardNum:"");
                    $("#mqfjg").val(data.immuneCard.orgName?data.immuneCard.orgName:"");
                    $("#mqfrq").val(data.immuneCard.lssueTime?model.formatDate(data.immuneCard).lssueTime:"");
                    $("#myxqxk").val(data.immuneCard.startTime?model.formatDate(data.immuneCard.startTime):"");
                    $("#myxqxj").val(data.immuneCard.endTime?model.formatDate(data.immuneCard.endTime):"");
                }
                if (data.dogCard!=null) {
                    $("#dogCardNum").val(data.dogCard.dogCardNum?data.dogCard.dogCardNum:"");
                    $("#dqfjg").val(data.dogCard.orgName?data.dogCard.orgName:"");
                    $("#dqfrq").val(data.dogCard.lssueTime?model.formatDate(data.dogCard.lssueTime):"");
                    $("#dyxqxk").val(data.dogCard.startTime?model.formatDate(data.dogCard.startTime):"");
                    $("#dyxqxj").val(data.dogCard.endTime?model.formatDate(data.dogCard.endTime):"");
                }
                if (data.device!=null) {
                    $("#xqbh").val(data.device.deviceNumber?data.device.deviceNumber:"");
                    $("#xqfjg").val(data.device.orgName?data.device.orgName:"");
                    if (data.dogCard!=null) {
                        $("#xqfrq").val(data.dogCard.lssueTime?model.formatDate(data.dogCard.lssueTime):"");
                    }
                    $("#xyxqxk").val(data.device.startTime?model.formatDate(data.device.startTime):"");
                    $("#xyxqxj").val(data.device.endTime?model.formatDate(data.device.endTime):"");
                }
                if (data.dogInfo!=null) {
                    model.InertDogCard.dogId=data.dogInfo.dogId;
                    model.InertDogCard.status=data.dogInfo.status;
                    $("#dogName").val(data.dogInfo.dogName?data.dogInfo.dogName:"");
                    $("#pz").val(data.dogInfo.breed?data.dogInfo.breed:"");
                    if (data.dogInfo.dogGender==0) {
                        $("#xb").val("雄");
                    }else if (data.dogInfo.dogGender==0) {
                        $("#xb").val("雌");
                    }
                    $("#nl").val(data.dogInfo.dogAge?data.dogInfo.dogAge+'个月':"");
                    $("#csrq").val(data.dogInfo.birthTime?model.formatDate(data.dogInfo.birthTime):"");
                    $("#ms").val(data.dogInfo.color?data.dogInfo.color:"");
                    $("#father").val(data.dogInfo.fatherId?data.dogInfo.fatherId:"");
                    $("#mather").val(data.dogInfo.motherId?data.dogInfo.motherId:"");
                }
                if (data.dogOwners!=null) {
                    model.InertDogCard.dogOwnerId=data.dogOwners.dogOwnerId;
                    model.InertDogCard.phone=data.dogOwners.dogOwnerPhone;
                    model.InertDogCard.name=data.dogOwners.dogOwnerName;
                    model.InertDogCard.gender=data.dogOwners.sex;
                    model.InertDogCard.email=data.dogOwners.eMail;
                    $("#dogOwerName").val(data.dogOwners.dogOwnerName?data.dogOwners.dogOwnerName:"");
                    if (data.dogOwners.dogOwnerType==0) {
                        $("#xz").val("个人");
                    }else if (ata.dogOwners.dogOwnerType==1) {
                        $("#xz").val("企业");
                    }
                    if (data.dogOwners.cardType==0) {
                        $("#zjlx").val("身份证");
                    }else if (ata.dogOwners.cardType==1) {
                        $("#zjlx").val("房产证");
                    }else if (ata.dogOwners.cardType==2) {
                        $("#zjlx").val("营业执照");
                    }else if (ata.dogOwners.cardType==3) {
                        $("#zjlx").val("其他");
                    }
                    $("#zjhm").val(data.dogOwners.cardNum?data.dogOwners.cardNum:"");
                    if (data.dogOwners.sex==0) {
                        $("#xb1").val("男");
                    }else if (data.dogOwners.sex==1) {
                        $("#xb1").val("女");
                    }
                    $("#csrq1").val(data.dogOwners.birthDate?model.formatDate(data.dogOwners.birthDate):"");
                    $("#xzqx").val(data.dogOwners.districtName?data.dogOwners.districtName:"");
                    // $("#ssbm").val(data.dogOwners.dogName?data.dogOwners.dogName:"");
                    $("#yb").val(data.dogOwners.postalCode?data.dogOwners.postalCode:"");
                    $("#phone").val(data.dogOwners.dogOwnerPhone?data.dogOwners.dogOwnerPhone:"");
                    $("#dzyx").val(data.dogOwners.eMail?data.dogOwners.eMail:"");
                    $("#xxdz").val(data.dogOwners.address?data.dogOwners.address:"");
                }
                if (data.urlLsit!=null && JSON.stringify(data.urlLsit)!="[]") {
                    var urls=data.urlLsit;
                    for (var i=0;i<urls.length;i++) {
                        var img=$("<img src='" +urls[i].thumbnailUrl+"'>");
                        $("#filePicker").append(img);
                        img.data("imageUrl",urls[i].imageUrl);
                        img.click(function () {
                            $("#bigImg").attr("src",this.data("imageUrl"));
                            $("#bigImg").show();
                        });
                    }
                }
            }
        }
    })
}
//犬证续期
function dogCardRenewal() {
    var endDate=$("#dyxqxj").val().trim();
    $.ajax({
        type:"get",
        url:"/biz/dogCard/updateCardDate",
        data:{dogId:dogId,endDate:endDate},
        dataType: "json",
        success:function (results) {
            if (results.code=="000000" && results.result!=null) {
                alert(results.result);
                selectRelatedInfo(dogId);
            }else {
                alert("犬证续期失败!")
            }
        }
    })
}

//免疫证号搜索
// var test_list = ["小张", "小苏", "小杨", "老张", "老苏", "老杨", "老爷爷", "小妹妹", "老奶奶", "大鹏", "大明", "大鹏展翅", "你好", "hello", "hi","DF-12DD 客户名称 id"];
var cusids = [];//免疫证号
var old_value = "";
var highlightindex = -1;   //高亮
//自动完成
function AutoComplete(auto, search, mylist) {
    if ($("#" + search).val() != old_value || old_value == "") {
        var autoNode = $("#" + auto);   //缓存对象（弹出框）
        var carlist = new Array();
        var n = 0;
        old_value = $("#" + search).val();
        for (i in mylist) {
            if (mylist[i].indexOf(old_value) >= 0) {
                carlist[n++] = mylist[i];
            }
        }
        if (carlist.length == 0) {
            autoNode.hide();
            return;
        }
        autoNode.empty();  //清空上次的记录
        for (i in carlist) {
            var wordNode = carlist[i];   //弹出框里的每一条内容
            var newDivNode = $("<div>").attr("id", i);    //设置每个节点的id值
            newDivNode.attr("style", "font:14px/25px arial;height:25px;padding:0 8px;cursor: pointer;");
            newDivNode.html(wordNode).appendTo(autoNode);  //追加到弹出框
            // newDivNode.data("customerId",cusids[i]);
            //鼠标移入高亮，移开不高亮
            newDivNode.mouseover(function () {
                if (highlightindex != -1) {        //原来高亮的节点要取消高亮（是-1就不需要了）
                    autoNode.children("div").eq(highlightindex).css("background-color", "white");
                }
                //记录新的高亮节点索引
                highlightindex = $(this).attr("id");
                $(this).css("background-color", "#ebebeb");
            });
            newDivNode.mouseout(function () {
                $(this).css("background-color", "white");
            });
            //鼠标点击文字上屏
            newDivNode.click(function () {
                //取出高亮节点的文本内容
                var comText = autoNode.hide().children("div").eq(highlightindex).text();
                highlightindex = -1;
                //文本框中的内容变成高亮节点的内容
                $("#" + search).val(comText);
                selectRelatedInfo();
                // $("." + search).data("customerId",$(this).data("customerId"));
            })
            if (carlist.length > 0) {    //如果返回值有内容就显示出来
                autoNode.show();
            } else {               //服务器端无内容返回 那么隐藏弹出框
                autoNode.hide();
                //弹出框隐藏的同时，高亮节点索引值也变成-1
                highlightindex = -1;
            }
        }
    }
    //点击页面隐藏自动补全提示框
    document.onclick = function (e) {
        var e = e ? e : window.event;
        var tar = e.srcElement || e.target;
        if (tar.id != search) {
            if ($("#" + auto).is(":visible")) {
                $("#" + auto).css("display", "none")
            }
        }
    }
}