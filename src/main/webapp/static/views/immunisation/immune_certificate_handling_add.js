//定义modell对象
var modell = {
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
    dogInfo:
        {
            dogName:null,//犬名
            dogBreedType:null,//犬品种
            dogGender:null,//犬性别
            birthTime:null,//犬只出生日期
            dogColorType:null,//犬只颜色
            fatherId:null,//父本
            motherId:null,  //母本

        dogImmune:
            {//免疫证信息
                lssuerId:null,//签证人id
                immuneCardNum:null,//免疫证号
                lssueTime:null,//签发日期
                startTime:null,//生效时间
                endTime:null,//失效时间
                lssueOrgId:null//签发机构

            },
            dogOwner:
                {//犬主信息
                dogOwnerName:null,//犬主姓名
                dogOwnerType:null,//性质
                sex:null,//性别
                birthDate:null,//出生日期
                districtId:null,//现住区县
                community:null,//所属社区
                postalCode:null,//邮编
                dogOwnerPhone:null,//电话
                eMail:null,//邮件
                address:null,//地址
                tDogOwnerCard:{
                    cardType:null,//证件类型
                    cardNum:null//证件号码
                }


            }
         },
    
    Id:null,
    type:2
}

$(function () {
    // 创建Web Uploader实例
    // 初始化Web Uploader
    var uploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,
        // swf文件路径
        swf:'webuploader/Uploader.swf',
        fileNumLimit:4,
        duplicate :false,
        method:"post",
        // 文件接收服务端。
        server: '/biz/fileManager/uploadFileBatch',
        disableGlobalDnd:false,
        dnd:"#dg",
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id:"#filePicker",
            innerHTML: "选择图片",
            multiple:true
        },
        // 只允许选择图片文件。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });
//            uploader.addButton({
//                id: '#filePicker',
//                innerHTML: '选择文件'
//            });

    // 监听fileQueued事件，通过uploader.makeThumb来创建图片预览图。
    // PS: 这里得到的是Data URL数据，IE6、IE7不支持直接预览。可以借助FLASH或者服务端来完成预览。
    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {
        var $li = $(
            '<li id="' + file.id + '" class="file-item thumbnail">' +
            '<div class="info" style="display: inline">' + file.name + '</div>' +
            '<img>'+
            '</li>'
            ),
            $img = $li.find('img');
        var $btns = $('<div class="file-panel">' +
            '<span class="pull-right" >删除</span>').appendTo($li);
        // $list为容器jQuery实例
        $(fileList).append($li);
        $btns.on('click', 'span', function () {
            var index = $(this).index();
            switch (index) {
                case 0:
                    uploader.removeFile(file);
                    removeFile(file);
                    return;
            }
        });
        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, 100, 100 );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress span');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<p class="progress"><span></span></p>')
                .appendTo( $li )
                .find('span');
        }

        $percent.css( 'width', percentage * 100 + '%' );
    });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on( 'uploadSuccess', function( file ) {
//                $( '#'+file.id ).addClass('upload-state-done');
        $( '#'+file.id ).find('.file-panel').append('<span class="pull-left">上传成功</span>')
    });

    // 文件上传失败，显示上传出错。
    uploader.on( 'uploadError', function( file ) {
        var $li = $( '#'+file.id ),
            $error = $li.find('div.error');
        $error.addClass('pull-right');
        // 避免重复创建
        if ( !$error.length ) {
            $error = $('<div class="error"></div>').appendTo( $li );
        }
        $error.text('上传失败');
    });

    // 完成上传完了，成功或者失败，先删除进度条。
    uploader.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });
    
    uploader.on( 'uploadBeforeSend', function( block, data ) {
    	console.log(111);
    	console.log(modell);
        data.Id = modell.Id;
        data.type=modell.type;
    });
    
    // 负责view的销毁
    function removeFile( file ) {
        var $li = $('#'+file.id);
        $li.off().find('.file-panel').off().end().remove();
    }
    
    //签发日期,有效日期
    initDate();
    //初始化犬只品种,犬只毛色,和犬主区域的数据
    initSelectOption();
    
    //保存免疫证数据
    $("#save").click(function () {
    	//获得免疫证页面添加参数
    	   gainImmuneParam();
    	insertImmuneCardRel();
    	uploader.upload();
    	 
    });


    //点击取消,跳转到列表页面,清空页面数据
    $("#cancel").click(function () {
    	$("#add").html();
    	$("#home").load("views/immunisation/immunisation.html");
    });



});


function initDate(){
	//签发日期
	$("#issDate").val(modell.formatDate(new Date()));
	//有效起始日期
	$("#startDate").val(modell.formatDate(new Date()));
}
//初始化下拉框犬只品种,犬只毛色,和犬主区域的数据
function initSelectOption() {
    $.ajax({
        type: "get",
        url: "/biz/dogInfo/findBreedColorDistrict",
        dataType: "json",
        success: function (result) {
        	debugger
            if (result.disTrictList.length>0) {
                var data1=result.disTrictList;
                for (var i=0;i<data1.length;i++) {
                    var op=$("<option class='op'></option>");
                    op.val(data1[i].districtId);
                    op.text(data1[i].districtName);
                    $("#district").append(op)
                }
            }
            if (result.breedList.length>0) {
                var data2=result.breedList;
                for (var i=0;i<data2.length;i++) {
                    var op1=$("<option class='op1'></option>");
                    op1.val(data2[i].dictionaryValue);
                    op1.text(data2[i].dictionaryDescribe);
                    $("#breed").append(op1)
                }
            }
            if (result.colorList.length>0) {
                var data3=result.colorList;
                for (var i=0;i<data3.length;i++) {
                    var op2=$("<option class='op2'></option>");
                    op2.val(data3[i].dictionaryValue);
                    op2.text(data3[i].dictionaryDescribe);
                    $("#color").append(op2)
                }
            }
        }
    })
}

//获得免疫证页面添加参数
function gainImmuneParam() {
    //#########################获取犬只信息##################################
    modell.dogInfo.dogName=$.trim($("#dogName").val());//狗名
    modell.dogInfo.dogBreedType=$("#breed").val();//品种
    modell.dogInfo.dogGender=$("#dogSex").val();//性别
    modell.dogInfo.birthTime=modell.DateToUnix($("#dogBirth").val());//出生日期
    modell.dogInfo.dogColorType=$("#color").val();//犬只颜色
    modell.dogInfo.fatherId=$("#father").val();//父本
    modell.dogInfo.motherId=$("#mother").val();//母本
    //#########################获取免疫证信息##################################
    var user=JSON.parse(sessionStorage.getItem("user"));
    modell.dogInfo.dogImmune.lssueOrgId=user.organizationId;
    modell.dogInfo.dogImmune.lssuerId=user.userId;
    modell.dogInfo.dogImmune.immuneCardNum=$.trim($("#immNum").val());//免疫证号
    modell.dogInfo.dogImmune.lssueTime=modell.DateToUnix($("#issDate").val());//签发日期
    modell.dogInfo.dogImmune.startTime=modell.DateToUnix($("#startDate").val());//生效时间
    modell.dogInfo.dogImmune.endTime=modell.DateToUnix($("#endDate").val());//失效时间

    //#########################获取犬主信息##################################
    modell.dogInfo.dogOwner.dogOwnerName=$.trim($("#dogOwner").val());//犬主姓名
    modell.dogInfo.dogOwner.dogOwnerType=$("#property").val();//性质
    modell.dogInfo.dogOwner.sex=$("#cardType").val();//性别
    modell.dogInfo.dogOwner.birthDate=modell.DateToUnix($("#ownerBirth").val());//出生日期
    modell.dogInfo.dogOwner.districtId=$("#district").val();//现住区县
    modell.dogInfo.dogOwner.community=$.trim($("#community").val());//所属社区
    modell.dogInfo.dogOwner.postalCode=$.trim($("#postalCode").val());//邮编
    modell.dogInfo.dogOwner.dogOwnerPhone=$.trim($("#phone").val());//电话
    modell.dogInfo.dogOwner.eMail=$.trim($("#email").val());//邮件
    modell.dogInfo.dogOwner.address=$.trim($("#address").val());//地址

    //#########################获取犬主证件信息##################################
    modell.dogInfo.dogOwner.tDogOwnerCard.cardType=$("#cardType").val(); //证件类型
    modell.dogInfo.dogOwner.tDogOwnerCard.cardNum=$("#cardNum").val(); //证件号码

    if (modell.dogInfo.dogBreedType == "default") {
        alert("请选择犬只品种！");
        return
    }
    if (modell.dogInfo.dogColorType == "default") {
        alert("请选择犬只颜色！");
        return
    }
    if (modell.dogInfo.dogOwner.districtId == "default") {
        alert("请选择所属区县！");
        return
    }
    
    if (modell.dogInfo.dogOwner.dogOwnerName=='' || modell.dogInfo.dogOwner.dogOwnerName == null) {
        alert("请输入犬主姓名！");
        return
    }
    if (modell.dogInfo.dogOwner.dogOwnerPhone=='' || modell.dogInfo.dogOwner.dogOwnerPhone == null) {
        alert("请输入犬主电话！");
        return
    }
    if (modell.dogInfo.dogOwner.address=='' || modell.dogInfo.dogOwner.address == null) {
        alert("请输入犬主地址！");
        return
    }
}



//免疫证办理
function insertImmuneCardRel() {
	debugger
   $.ajax({
       type:"post",
       url:"/biz/dogInfo/insertImmuneMsg",
       data:JSON.stringify(modell.dogInfo),
       async: false,
       dataType:"json",
       contentType:"application/json",
       success:function (result) {
    	   var result= result.data;
           if (result !=null && result !="") {
        	   modell.Id=result;
        	   alert("插入免疫证文本信息成功！");
        	   $("#home").load("views/immunisation/immunisation.html");
           }else {
               alert("插入免疫证文本信息失败！");
       }
       }
   })
}