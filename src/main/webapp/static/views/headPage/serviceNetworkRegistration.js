function DateToUnix(string) {
    var f = string.split('/', 2);
    var d = (f[0] ? f[0] : '').split('/', 3);
    var t = (f[1] ? f[1] : '').split(':', 3);
    return (new Date(
        parseInt(d[0], 10) || null,
        (parseInt(d[1], 10) || 1) - 1,
        parseInt(d[2], 10) || null,
        parseInt(t[0], 10) || null,
        parseInt(t[1], 10) || null,
        parseInt(t[2], 10) || null
    )).getTime()/1000;
}
var serviceSiteObj={
organizationName:null,//医院名称
organizationCapital:null,//注册资本
registerNumber:null,//注册号
creditCode:null,//统一社会信用代码
establishDate:null,//成立时间
provinceId:null,//省
ownedCityId:null,//市
districtId:null,//区
phone:null,//联系电话
personLiable:null,//联系人
orgType:2,//机构类型
scopeOfOperation:null,//经营范围
address:null,
petHospitals:null
}
var id=null;
var selector2=null;
$(function () {
    $("#que").click(function () {
        $(".syy").click();
    });
    //有效期限
    // $("#dyxqxk").attr("type", "date").attr("readonly", false).attr("min", date.format(date, 'yyyy-MM-dd'));
    // $("#dyxqxj").attr("type", "date").attr("readonly", false).attr("min", date.format(date, 'yyyy-MM-dd'));
    uploadpic1("#dg","fileList","#filePicker");
    uploadpic2("#dg1","fileList1","#filePicker1");
    uploadpic3("#dg2","fileList2","#filePicker2");
    uploadpic4("#dg3","fileList3","#filePicker3");
    uploadpic5("#dg4","fileList4","#filePicker4");
    // 模拟城市-无联动/无搜索
    selector2 = $('#city-picker-selector2').cityPicker({
        dataJson: cityData,
        renderMode: true,
        search: false,
        autoSelected: true,
        code: 'cityCode',
        level: 3,
        onChoiceEnd: function() {
            serviceSiteObj.provinceId=this.values[0].id;
            serviceSiteObj.ownedCityId=this.values[1].id;
            serviceSiteObj.districtId=this.values[2].id;
        }
    });
})

//获取参数
function obtainParms() {
    serviceSiteObj.organizationName=$("#yymc").val().trim();
    serviceSiteObj.organizationCapital=$("#zczb").val().trim();
    serviceSiteObj.registerNumber=$("#zch").val().trim();
    serviceSiteObj.creditCode=$("#xydm").val().trim();
    serviceSiteObj.establishDate=DateToUnix($("#clsj").val().trim());
    serviceSiteObj.phone=$("#phone").val().trim();
    serviceSiteObj.personLiable=$("#lxr").val().trim();
    serviceSiteObj.scopeOfOperation=$("#jyfw").val().trim();
    serviceSiteObj.address=$("#address").val().trim();
    var list=[];
    var tPetHospital1={petHCardType:0, petHCardNum:$("#petHCardNum1").val().trim(), startTime:DateToUnix($("#startDate1").val().trim()), endTime:DateToUnix($("#startDate1").val().trim())};
    var tPetHospital2={petHCardType:1, petHCardNum:$("#petHCardNum2").val().trim(), startTime:DateToUnix($("#startDate2").val().trim()), endTime:DateToUnix($("#startDate2").val().trim())};
    var tPetHospital3={petHCardType:2, petHCardNum:$("#petHCardNum3").val().trim(), startTime:DateToUnix($("#startDate3").val().trim()), endTime:DateToUnix($("#startDate3").val().trim())};
    var tPetHospital4={petHCardType:3, petHCardNum:$("#petHCardNum4").val().trim(), startTime:DateToUnix($("#startDate4").val().trim()), endTime:DateToUnix($("#startDate4").val().trim())};
    list.push(tPetHospital1);
    list.push(tPetHospital2);
    list.push(tPetHospital3);
    list.push(tPetHospital4);
    serviceSiteObj.petHospitals=list;
    // console.log(list)
    $.ajax({
        type:"post",
        url:"/biz/serviceSite/add",
        data:JSON.stringify(serviceSiteObj),
        contentType:"application/json",
        dataType:"json",
        // traditional: true,
        success:function (results) {
            if (results.status==200 && results.data!=null) {
                id=results.data;
                uploader1.upload();
                uploader2.upload();
                uploader3.upload();
                uploader4.upload();
                uploader5.upload();
                $("#home").load("../../../static/views/dog/serviceNetwork.html");
            }
        }
    })
}
//图片上传1
var uploader1=null;
function uploadpic1(id1,id2,id3) {
    // 创建Web Uploader实例
    // 初始化Web Uploader
    uploader1 = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,
        // swf文件路径
        swf:'../../../static/webuploader/Uploader.swf',
        fileNumLimit:4,
        duplicate :false,
        method:"post",
        // 文件接收服务端。
        server: '/biz/fileManager/uploadFileBatch',
        disableGlobalDnd:false,
        dnd:id1,
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id:id3,
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
    uploader1.on( 'fileQueued', function( file ) {
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
        $("#"+id2).append($li);
        $btns.on('click', 'span', function () {
            var index = $(this).index();
            switch (index) {
                case 0:
                    uploader1.removeFile(file);
                    removeFile(file);
                    return;
            }
        });
        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader1.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, 100, 100 );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader1.on( 'uploadProgress', function( file, percentage ) {
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
    uploader1.on( 'uploadSuccess', function( file ) {
//                $( '#'+file.id ).addClass('upload-state-done');
        $( '#'+file.id ).find('.file-panel').append('<span class="pull-left">上传成功</span>')
    });

    // 文件上传失败，显示上传出错。
    uploader1.on( 'uploadError', function( file ) {
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
    uploader1.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });

    uploader1.on( 'uploadBeforeSend', function( block, data ) {
        data.Id = id;
        data.type=1;
    });

    // 负责view的销毁
    function removeFile( file ) {
        var $li = $('#'+file.id);
        $li.off().find('.file-panel').off().end().remove();
    }
    // //上传方法
    // $("#up").click(function () {
    //     uploader.upload();
    // });
}

//图片上传2
var uploader2=null;
function uploadpic2(id1,id2,id3) {
    // 创建Web Uploader实例
    // 初始化Web Uploader
    uploader2 = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,
        // swf文件路径
        swf:'../../../static/webuploader/Uploader.swf',
        fileNumLimit:4,
        duplicate :false,
        method:"post",
        // 文件接收服务端。
        server: '/biz/fileManager/uploadFileBatch',
        disableGlobalDnd:false,
        dnd:id1,
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id:id3,
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
    uploader2.on( 'fileQueued', function( file ) {
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
        $("#"+id2).append($li);
        $btns.on('click', 'span', function () {
            var index = $(this).index();
            switch (index) {
                case 0:
                    uploader2.removeFile(file);
                    removeFile(file);
                    return;
            }
        });
        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader2.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, 100, 100 );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader2.on( 'uploadProgress', function( file, percentage ) {
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
    uploader2.on( 'uploadSuccess', function( file ) {
//                $( '#'+file.id ).addClass('upload-state-done');
        $( '#'+file.id ).find('.file-panel').append('<span class="pull-left">上传成功</span>')
    });

    // 文件上传失败，显示上传出错。
    uploader2.on( 'uploadError', function( file ) {
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
    uploader2.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });

    uploader2.on( 'uploadBeforeSend', function( block, data ) {
        data.Id = id;
        data.type=1;
    });

    // 负责view的销毁
    function removeFile( file ) {
        var $li = $('#'+file.id);
        $li.off().find('.file-panel').off().end().remove();
    }
    // //上传方法
    // $("#up").click(function () {
    //     uploader.upload();
    // });
}

//图片上传3
var uploader3=null;
function uploadpic3(id1,id2,id3) {
    // 创建Web Uploader实例
    // 初始化Web Uploader
    uploader3 = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,
        // swf文件路径
        swf:'../../../static/webuploader/Uploader.swf',
        fileNumLimit:4,
        duplicate :false,
        method:"post",
        // 文件接收服务端。
        server: '/biz/fileManager/uploadFileBatch',
        disableGlobalDnd:false,
        dnd:id1,
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id:id3,
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
    uploader3.on( 'fileQueued', function( file ) {
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
        $("#"+id2).append($li);
        $btns.on('click', 'span', function () {
            var index = $(this).index();
            switch (index) {
                case 0:
                    uploader3.removeFile(file);
                    removeFile(file);
                    return;
            }
        });
        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader3.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, 100, 100 );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader3.on( 'uploadProgress', function( file, percentage ) {
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
    uploader3.on( 'uploadSuccess', function( file ) {
//                $( '#'+file.id ).addClass('upload-state-done');
        $( '#'+file.id ).find('.file-panel').append('<span class="pull-left">上传成功</span>')
    });

    // 文件上传失败，显示上传出错。
    uploader3.on( 'uploadError', function( file ) {
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
    uploader3.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });

    uploader3.on( 'uploadBeforeSend', function( block, data ) {
        data.Id = id;
        data.type=1;
    });

    // 负责view的销毁
    function removeFile( file ) {
        var $li = $('#'+file.id);
        $li.off().find('.file-panel').off().end().remove();
    }
    // //上传方法
    // $("#up").click(function () {
    //     uploader.upload();
    // });
}

//图片上传4
var uploader4=null;
function uploadpic4(id1,id2,id3) {
    // 创建Web Uploader实例
    // 初始化Web Uploader
    uploader4 = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,
        // swf文件路径
        swf:'../../../static/webuploader/Uploader.swf',
        fileNumLimit:4,
        duplicate :false,
        method:"post",
        // 文件接收服务端。
        server: '/biz/fileManager/uploadFileBatch',
        disableGlobalDnd:false,
        dnd:id1,
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id:id3,
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
    uploader4.on( 'fileQueued', function( file ) {
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
        $("#"+id2).append($li);
        $btns.on('click', 'span', function () {
            var index = $(this).index();
            switch (index) {
                case 0:
                    uploader4.removeFile(file);
                    removeFile(file);
                    return;
            }
        });
        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader4.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, 100, 100 );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader4.on( 'uploadProgress', function( file, percentage ) {
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
    uploader4.on( 'uploadSuccess', function( file ) {
//                $( '#'+file.id ).addClass('upload-state-done');
        $( '#'+file.id ).find('.file-panel').append('<span class="pull-left">上传成功</span>')
    });

    // 文件上传失败，显示上传出错。
    uploader4.on( 'uploadError', function( file ) {
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
    uploader4.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });

    uploader4.on( 'uploadBeforeSend', function( block, data ) {
        data.Id = id;
        data.type=1;
    });

    // 负责view的销毁
    function removeFile( file ) {
        var $li = $('#'+file.id);
        $li.off().find('.file-panel').off().end().remove();
    }
    // //上传方法
    // $("#up").click(function () {
    //     uploader.upload();
    // });
}

//图片上传5
var uploader5=null;
function uploadpic5(id1,id2,id3) {
    // 创建Web Uploader实例
    // 初始化Web Uploader
    uploader5 = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,
        // swf文件路径
        swf:'../../../static/webuploader/Uploader.swf',
        fileNumLimit:4,
        duplicate :false,
        method:"post",
        // 文件接收服务端。
        server: '/biz/fileManager/uploadFileBatch',
        disableGlobalDnd:false,
        dnd:id1,
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id:id3,
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
    uploader5.on( 'fileQueued', function( file ) {
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
        $("#"+id2).append($li);
        $btns.on('click', 'span', function () {
            var index = $(this).index();
            switch (index) {
                case 0:
                    uploader5.removeFile(file);
                    removeFile(file);
                    return;
            }
        });
        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader5.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr( 'src', src );
        }, 100, 100 );
    });

    // 文件上传过程中创建进度条实时显示。
    uploader5.on( 'uploadProgress', function( file, percentage ) {
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
    uploader5.on( 'uploadSuccess', function( file ) {
//                $( '#'+file.id ).addClass('upload-state-done');
        $( '#'+file.id ).find('.file-panel').append('<span class="pull-left">上传成功</span>')
    });

    // 文件上传失败，显示上传出错。
    uploader5.on( 'uploadError', function( file ) {
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
    uploader5.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').remove();
    });

    uploader5.on( 'uploadBeforeSend', function( block, data ) {
        data.Id = id;
        data.type=1;
    });

    // 负责view的销毁
    function removeFile( file ) {
        var $li = $('#'+file.id);
        $li.off().find('.file-panel').off().end().remove();
    }
    // //上传方法
    // $("#up").click(function () {
    //     uploader.upload();
    // });
}