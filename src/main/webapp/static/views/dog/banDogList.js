var model={
		data:null,
		id:null,
		type:6
}


$(function () {
	//
	createTable();
    //新增
    $("#add").click(function(){
    	$("#master").hide();
    	$("#detail").show();
    });
    
    
    upload.initjyqzuploader(); 
    
    //取消
    $("#cansle").click(function(){
    	$("#master").show();
    	$("#detail").hide();
    	createTable();
    });
    
});

var upload = {
		initjyqzuploader:function(){
		    // 创建Web Uploader实例
		    // 初始化Web Uploader
		    var uploader = WebUploader.create({
		        // 选完文件后，是否自动上传。
		        auto: false,
		        // swf文件路径
		        swf:'../../../static/webuploader/Uploader.swf',
		        fileNumLimit:2,
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
		            '<span class="pull-right" style="cursor:pointer" >删除</span>').appendTo($li);
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
		        uploader.removeFile(file);
                removeFile(file);
                $("#detail *").val('');
                bootbox.alert("操作成功");
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
		    	if($("#jy").val()==''){
		    		bootbox.alert("禁养犬种不能为空");
		    		return false;
		    	}
		    	//保存对象
		    	save();
		    	if(model.id==null){
		    		bootbox.alert("服务器异常，请重试...");
		    		return false;
		    	}
		    	//判断是否有图片
		    	var count=$(fileList).context.childElementCount;
		    	if(count==0){
		    		bootbox.alert("请选择图片");
		    		return false;
		    	}
		    	//上传图片
		        uploader.upload();
		    });
		}
}

    //初始化Table
     function createTable () {
		$("#banDogTable").bootstrapTable('destroy'); 
        $("#banDogTable").bootstrapTable({
        	url: '/biz/dogAndOwner/selectDogBanList',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            //toolbar: '#toolbar',
           dataType:"json",               		//工具按钮用哪个容器
           striped: true,                      //是否显示行间隔色
           cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
           pagination: true,                   //是否显示分页（*）
           sortable: true,                     //是否启用排序
           sortOrder: "asc",                   //排序方式
           sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
           pageNumber:1,                       //初始化加载第一页，默认第一页
           pageSize: 10,                       //每页的记录行数（*）
           pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
           search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
           strictSearch: true,
           showColumns: false,                  //是否显示所有的列
           showRefresh: false,                  //是否显示刷新按钮
           minimumCountColumns: 2,             //最少允许的列数
           clickToSelect: true,   				//是否启用点击选中行
           // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
           uniqueId: "ID",							//每一行的唯一标识，一般为主键列
           queryParams: function(params){
           	return{
           		size: params.limit,   //页面大小 
                num: (params.offset/params.limit)+1,  //页码 
           	}
           },  //传递参数（*）
            columns: [{
                field: 'thumbnailUrl',
                title: '图片',
                align:'center',
                valign:"middle",
                formatter:function (value,row,index,field) {
                    var buffer = new StringBuffer();
                    var img='<img src="'+value+'" style="width:60px;height:60px;">';
                    buffer.append(img);
                    return buffer.toString();
                }
            }, {
                field: 'dogBreedBame',
                title: '禁养犬种',
                align:'center',
                valign:"middle",
            }, {
                field: 'creationTime',
                title: '发布时间',
                align:'center',
                valign:"middle",
                formatter:function(value,row,index,field){
                	return timeStamp2String(value);
                }
            }, {
                field: 'note',
                title: '备注',
                align:'center',
                valign:"middle",
            },{
                field: 'Desc',
                title: '操作',
                align:'center',
                valign:"middle",
                events:operateEvents,
                formatter: operateFormatter
            }],
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatShowingRows: function (pageFrom, pageTo, totalRows) {
                return "当前第 " + pageFrom + " 页，本页 " + pageTo + " 条";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
            onLoadSuccess:function(data){
                if(data!=null){
                    $(".pull-right").css("display", "block");
                }
            },
            responseHandler:function(res){ //格式化数据
            	if(res.result!=null){
            		return {
            			total : res.result.page.totalCount, //总页数,前面的key必须为"total"
            			rows : res.result.dogInfos //行数据，前面的key要与之前设置的dataField的值一致.
            		};
            	}else{
            		return {
            			total : 0,
            			rows : []
            		};
            	}
            },
        });
    };
    
    window.operateEvents = {
       		//移除
       		'click .RoleOfB': function(e, value, row, index) {
       			var data={
       					dogBreedId:row.dogBreedId,
       					mark:0
       			}
       			deletee(data);
       		},	
       };
       
   function operateFormatter(value, row, index) {
   	return [
   	        '<a id="btn_msg"  style="cursor:pointer;color: rgb(65, 199, 214)" class="RoleOfB ">移除</a>'
   	        ].join('');
   }
   
   
   //获得页面数据
   function getBanDog(){
	   var banDog={
			   dogBreedBame:$("#jy").val(),
			   note:$("#bz").val(),
			   mark:2
	   }
	   model.data=banDog;
   }
   
   //新增
   function save(){
	   getBanDog();
	   $.ajax({
	        type:"post",
	        url:"/biz/dogAndOwner/insertDogBan",
	        data:JSON.stringify(model.data),
	        dataType:"json",
	        contentType:"application/json",
	        async:false,
	        success:function (res) {
	        	//要获得返回的主键id
	        	model.id=res.result;
	        }
	    })
   }
   
   //移除
   function deletee(data){
	   bootbox.confirm("确定移除吗?", function(ok){
		   if(ok){
			   $.ajax({
			        type:"post",
			        url:"/biz/dogAndOwner/updateDogBan",
			        data:JSON.stringify(data),
			        dataType:"json",
			        contentType:"application/json",
			        success:function (res) {
			        	if(res.code=="000000"){
			        		createTable ();
			        	}
			        }
			    })
		   }
	   })
   }
    

