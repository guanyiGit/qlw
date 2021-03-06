
//页面加载函数
$(function(){
    var organizationId =  window.sessionStorage.getItem("organizationId");
    //获取当前机构审核状态
    var status =   window.sessionStorage.getItem("examineStatus");
    //审核通过
    if(status==1){
        $("#wei").attr("src","../../../static/images/wancheng.png");
        $("#fail_reason").hide();
    }else if(status==2){
        $("#wei").attr("src","../../../static/images/false.png");
        $("#fail_reason").show();
    }
    console.log(organizationId);
    //加载服务网点基本信息
    initPage.getServiceSite(organizationId);
    //加载服务网点注册信息
    initServiceSiteCard.getSiteCard(organizationId);

})

//格式化日期
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

//获取服务网点详情并渲染到页面上
var initPage = {
    getServiceSite:function (organizationId) {
        $.ajax({
            url:"/biz/serviceSite/getServiceSite",
            type:"post",
            dataType:"json",
            data:{
                organizationId:organizationId,
            },
            success:function (res) {
                console.log(res);
                var org = res.data;
                $("#organizationName").val(org.organizationName);  //医院名称
                $("#organizationCapital").val(org.organizationCapital); //注册资本
                $("#registerNumber").val(org.registerNumber);           //注册号
                $("#creditCode").val(org.creditCode);                   //信用代码
                $("#establishDate").val(timeStamp2String(org.establishDate));  //成立时间
                $("#province").val(org.province);                       //所属省份
                $("#ownedCity").val(org.ownedCity);                     //所属城市
                $("#district").val(org.district);                       //所属区县
                $("#address").val(org.address);                         //详细地址
                $("#personLiable").val(org.personLiable);               //责任人姓名
                $("#phone").val(org.phone);                                 //联系电话
                $("#scopeOfOperation").val(org.scopeOfOperation);       //经营范围
                $("#fail_reason_text").val(org.failReason);             //失败原因
            }
        })
    }
}

//获取服务网点证件并渲染到页面上
var initServiceSiteCard = {
    getSiteCard:function (organizationId) {
        $.ajax({
            url: "/biz/serviceSite/selectSiteCard",
            type: "post",
            dataType: "json",
            data: {
                organizationId: organizationId,
            },
            success:function (res) {
                console.log(res);
                var data = res.data;
                for (var index in data){
                    var siteCard =   data[index];
                    //获取动物诊疗许可证
                    if (siteCard.cardType == 0){
                        $("#card1 .card_number").val(siteCard.petHCardNum);
                        $("#card1 .upTime").val(timeStamp2String(siteCard.startTime));
                        $("#card1 .expireTime").val(timeStamp2String(siteCard.endTime));
                        //添加图片
                        var buffer = new StringBuffer();
                        for (var index in siteCard.images){
                            var image = siteCard.images[index];
                            var url = image.thumbnailUrl;
                            buffer.append("<img  src='"+url+"' style='width: 120px; height: 120px;margin-left: 20px;'/>")
                        }
                        $(buffer.toString()).appendTo($("#filePicker1"));
                        //动物防疫合格证
                    }else if(siteCard.cardType == 1){
                        $("#card2 .card_number").val(siteCard.petHCardNum);
                        $("#card2 .upTime").val(timeStamp2String(siteCard.startTime));
                        $("#card2 .expireTime").val(timeStamp2String(siteCard.endTime));
                        //添加图片
                        var buffer = new StringBuffer();
                        for (var index in siteCard.images){
                            var image = siteCard.images[index];
                            var url = image.thumbnailUrl;
                            buffer.append("<img  src='"+url+"' style='width: 120px; height: 120px;margin-left: 20px;'/>")
                        }
                        $(buffer.toString()).appendTo($("#filePicker2"));
                        //工商营业执照
                    }else if(siteCard.cardType == 2){
                        $("#card3 .card_number").val(siteCard.petHCardNum);
                        $("#card3 .upTime").val(timeStamp2String(siteCard.startTime));
                        $("#card3 .expireTime").val(timeStamp2String(siteCard.endTime));
                        //添加图片
                        var buffer = new StringBuffer();
                        for (var index in siteCard.images){
                            var image = siteCard.images[index];
                            var url = image.thumbnailUrl;
                            buffer.append("<img  src='"+url+"' style='width: 120px; height: 120px;margin-left: 20px;'/>")
                        }
                        $(buffer.toString()).appendTo($("#filePicker3"));
                        //兽医资格证
                    }else if(siteCard.cardType == 3){
                        $("#card4 .card_number").val(siteCard.petHCardNum);
                        $("#card4 .upTime").val(timeStamp2String(siteCard.startTime));
                        $("#card4 .expireTime").val(timeStamp2String(siteCard.endTime));
                        //添加图片
                        var buffer = new StringBuffer();
                        for (var index in siteCard.images){
                            var image = siteCard.images[index];
                            var url = image.thumbnailUrl;
                            buffer.append("<img  src='"+url+"' style='width: 120px; height: 120px;margin-left: 20px;'/>")
                        }
                        $(buffer.toString()).appendTo($("#filePicker4"));
                    }
                }
            }
        })
    }
}

