var model={
		data:null,
		id:1,
		type:3,
		blag:true,
		operatorId:null,
		districtId:null,
		orgId:null
}

$(function () {
	var user=JSON.parse(sessionStorage.getItem("user"));
	model.orgId=user.organizationId;
	model.operatorId=user.userId;
	model.districtId=user.districtId;
	//初始化品种
	InitBreed();
    //初始化毛色
	InitColor();
	//初始化收容原因
	InitCollType();
	
	//初始化上传图片
	//initjyqzuploader(); 
	upPic();
	$("#qzbh").blur(function(){
		if($("#qzbh").val()!=''){
			checkDogCode($("#qzbh").val());
		}
	});
	$("#ql").blur(function(){
		if($("#ql").val()!=''){
			if(!isAge($("#ql").val())){
				bootbox.alert("年龄输入不正确");
			}
		}
	});
	$("#tz").blur(function(){
		if($("#tz").val()!=''){
			if(!isWeight($("#tz").val())){
				bootbox.alert("体重输入不正确");
			}
		}
	});
	
	$("#cansle").click(function(){
		$("#home").load("views/dog/canineCollection.html");
	});
	
});

/*
function initjyqzuploader(){
    // 创建Web Uploader实例
    // 初始化Web Uploader
    var uploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: false,
        // swf文件路径
        swf:'../../../static/webuploader/Uploader.swf',
        fileNumLimit:1,
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
//		            uploader.addButton({
//		                id: '#filePicker',
//		                innerHTML: '选择文件'
//		            });

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
        // thumbnailWidth x thumbnailHeight 为 88 x 100
        uploader.makeThumb( file, function( error, src ) {
            if ( error ) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }
            $img.attr( 'src', src );
        }, 88, 88 );
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
//		                $( '#'+file.id ).addClass('upload-state-done');
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
        
    	data.Id= model.id;    //获取主键id
    	data.type=model.type; //上传图片类型
    });
    
    // 负责view的销毁
    function removeFile( file ) {
        var $li = $('#'+file.id);	
        $li.off().find('.file-panel').off().end().remove();
    }
    
  //保存数据
	$("#save").click(function () {
		
		if($("#qzbh").val()==''){
			bootbox.alert("犬只编号不能为空");
			return false;
		}
		if($("#qsbh").val()==''){
			bootbox.alert("犬舍编号不能为空");
			return false;
		}
		if(model.blag==false){
			bootbox.alert("犬只编号已存在");
			model.blag=true;
			return false;
		}
		//保存对象
		save();
		//上传图片
		console.log(model.id);
		if(model.id==null){
			return false;
		}
	   uploader.upload();
	   // alert("操作成功");
	});
}*/

function upPic(){
	// 初始化Web Uploader
	var uploader = WebUploader.create({

	    // 选完文件后，是否自动上传。
	    auto: false,

	    // swf文件路径
	    swf:'../../../static/webuploader/Uploader.swf',

	    // 文件接收服务端。
	    server: '/biz/fileManager/uploadFileBatch',

	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#filePicker',

	    // 只允许选择图片文件。
	    accept: {
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    }
	});
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {
	    var $li = $(
	            '<div id="' + file.id + '" class="file-item thumbnail">' +
	                '<img>' +
	                '<div class="info">' + file.name + '</div>' +
	            '</div>'
	            ),
	        $img = $li.find('img');


	    // $list为容器jQuery实例
	    $("#fileList").append( $li );

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
	    $( '#'+file.id ).addClass('upload-state-done');
	});

	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
	    var $li = $( '#'+file.id ),
	        $error = $li.find('div.error');

	    // 避免重复创建
	    if ( !$error.length ) {
	        $error = $('<div class="error"></div>').appendTo( $li );
	    }

	    $error.text('上传失败');
	});

	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
	    $( '#'+file.id ).find('.progress').remove();
	   // $("#home").load("views/dog/canineCollection.html");
	    $("#detail input[type='text']").val('');
	    $("#detail textarea").val('');
	    bootbox.alert("操作成功");
	});
	//上传之前做一些事情
    uploader.on( 'uploadBeforeSend', function( block, data ) {
    	data.Id= model.id;    //获取主键id
    	data.type=model.type; //上传图片类型
    });
	
	//保存数据
	$("#save11").click(function () {
		
		if($("#qzbh").val()==''){
			bootbox.alert("犬只编号不能为空");
			return false;
		}
		if($("#qsbh").val()==''){
			bootbox.alert("犬舍编号不能为空");
			return false;
		}
		if(model.blag==false){
			bootbox.alert("犬只编号已存在");
			model.blag=true;
			return false;
		}
		//保存对象
		save();
		//上传图片
		if(model.id==null){
			bootbox.alert("服务器异常，请重试...");
			return false;
		}
		var count=$(fileList).context.childElementCount;
    	if(count==0){
    		bootbox.alert("请选择图片");
    		return false;
    	}
	   uploader.upload();
	});
	
}



//获得页面数据
function getCollectionObject(){
	var collection={
		dogCode:$.trim($("#qzbh").val()),//犬只编号
		doghouseNum:$.trim($("#qsbh").val()),//犬舍编号
		dogName:$.trim($("#qzmc").val()),//犬只名称
		dogBreedType:$.trim($("#breedSelect option:selected").val()),//品种
		dogGender:$.trim($("#xb input:checked").val()),//性别
		dogAge:$.trim($("#ql").val()),//犬龄
		dogColorType:$.trim($("#colorSelect option:selected").val()),//毛色
		weight:$.trim($("#tz").val()),//体重
		dogCharacter:$.trim($("#td").val()),//特点
		healthStatus:$.trim($("#jkzk option:selected").val()),//健康状况
		collDogType:$.trim($("#collTypeSelect option:selected").val()),//收容原因
		remarks:$.trim($("#bz").val()),//备注
		orgId:model.orgId,
		districtId:model.districtId,
		operatorId:model.operatorId
	}
	model.data=collection;
}

//收容登记
function save(){
	getCollectionObject();
	   $.ajax({
	        type:"post",
	        url:"/biz/collection/save",
	        data:model.data,
	        dataType:"json",
	        contentType: "application/x-www-form-urlencoded",
	        async:false,
	        success:function (res) {
	        	if(res.status==200){
	        		model.id=res.data;
	        	}
	        }
	    })
}

//检查犬只编号是否存在
function checkDogCode(code){
	  $.ajax({
	        type:"get",
	        url:"/biz/collection/checkDogCode",
	        data:{dogCode:code},
	        dataType:"json",
	        success:function (res) {
	        	if(res.status==400){
	        		model.blag=false;
	        		bootbox.alert("犬只编号已存在");
	        	}else{
	        		model.blag=true;
	        	}
	        }
	    })
}
   