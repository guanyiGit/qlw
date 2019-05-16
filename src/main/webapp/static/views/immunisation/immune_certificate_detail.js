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
    CalAge: function(date1) {
    	var datetime1 = new Date(date1);
    	var datetime2 = new Date();
    	 var year1 = datetime1.getFullYear();
    	 var year2 = datetime2.getFullYear();
    	 var age=year2-year1+1;
    	 return age+"岁";
    }
}

$(function () {
    $("#cancel").click(function () {
        $("#home").load("views/immunisation/immunisation.html");
    });
    var  seqId=window.sessionStorage.getItem("seqId");
    //查看免疫证详情
    findImmuneDetail(seqId);

});

function  findImmuneDetail(seqId){
    $.ajax({
        type: "get",
        url: "/biz/dogInfo/findImmuneDetail",
        data:{"seqId":seqId},
        async: false,
        dataType: "json",
        success: function (result) {
        	var result=result.data;
            if (result !=null && result !=""){
                $("#immNum").val(result.dogImmune.immuneCardNum);
                $("#issAu").val(result.dogImmune.tOrganization.organizationName);
                $("#issDate").val(model.formatDate(result.dogImmune.lssueTime));
                $("#startDate").val(model.formatDate(result.dogImmune.startTime));
                $("#endDate").val(model.formatDate(result.dogImmune.endTime));
                $("#dogName").val(result.dogName);
                $("#breed").val(result.dogBreedDictionary.dictionaryDescribe);
                if(result.dogGender==0){
                    $("#dogSex").val("雄");
                }if(result.dogGender==1){
                    $("#dogSex").val("雌");
                }
                //照片回显,待完善
                var data=result.imageList;
                if(data!=null){
                    for (var i=0;i<data.length;i++){
                        var thumbnailUrl='<img src='+data[i].thumbnailUrl+'>';
                        $("#filePicker").append(thumbnailUrl);
                    }
                }
                $("#dogAge").val(model.CalAge(result.birthTime));
                $("#dogBirth").val(model.formatDate(result.birthTime));
                $("#color").val(result.dogColorDictionary.dictionaryDescribe);
                $("#father").val(result.fatherId);
                $("#mother").val(result.motherId);
                //犬主
                $("#dogOwner").val(result.dogOwner.dogOwnerName);
                if(result.dogOwner.dogOwnerType==0){
                    $("#property").val("企业");
                }
                if(result.dogOwner.dogOwnerType==1){
                    $("#property").val("个人");
                }
                if(result.dogOwner.tDogOwnerCard.cardType==0){
                    $("#cardType").val("身份证");
                }
                if(result.dogOwner.tDogOwnerCard.cardType==1){
                    $("#cardType").val("房产证");
                }
                if(result.dogOwner.tDogOwnerCard.cardType==2){
                    $("#cardType").val("营业执照");
                }
                if(result.dogOwner.tDogOwnerCard.cardType==3){
                    $("#cardType").val("其他");
                }
                $("#cardNum").val(result.dogOwner.tDogOwnerCard.cardNum);
                if(result.dogOwner.sex==0){
                    $("#sex").val("男");
                }
                if(result.dogOwner.sex==1){
                    $("#sex").val("女");
                }

                $("#ownerBirth").val(model.formatDate(result.dogOwner.birthDate));
                $("#district").val(result.dogOwner.tDistrict.districtName);
                $("#community").val(result.dogOwner.community);
                $("#postalCode").val(result.dogOwner.postalCode);
                $("#phone").val(result.dogOwner.dogOwnerPhone);
                $("#email").val(result.dogOwner.eMail);
                $("#address").val(result.dogOwner.address);
            }else{
            	alert("查看免疫证详情失败!");
            }
        }
    })
}

