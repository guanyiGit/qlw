function SwapTab(name, title, content, Sub, cur) {
    $(name + ' ' + title).mouseover(function() {
        $(this).addClass(cur).siblings().removeClass(cur);
        $(content + " > " + Sub).eq($(name + ' ' + title).index(this)).show().siblings().hide();
    });
}
function divselect(divselectid, inputselectid) {
    var inputselect = $(inputselectid);
    $(divselectid + " cite").click(function() {
        var ul = $(divselectid + " ul");
        var oDiv = $(divselectid);
        if (ul.css("display") == "none") {
            ul.slideDown("fast");
            //oDiv.css('z-index','1000');
        } else {
            ul.slideUp("fast");
            //oDiv.css('z-index','100');
        }
    });
    $(divselectid + " ul li a").click(function() {
        var txt = $(this).text();
        $(divselectid + " cite").html(txt);
        var value = $(this).attr("selectid");
        inputselect.val(value);
        $(divselectid + " ul").hide();

    });
}
;

//建立一個可存取到該file的url  上传图片
function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}
function checkall() {
    var sotxt = $('.sotxt').val();
    if (sotxt == "") {
        alert("请输入搜索内容");
        return false;
    }
}


$(function() {
    $('.address li').click(function() {
        $(this).addClass('selected').siblings('li').removeClass('selected');
        //$(this).find('.ps-radius').attr("checked",true).parents('li').siblings('li').find('.ps-radius').removeAttr("checked");
        $('.address').find('.ps-radius').removeAttr("checked");
        $(this).find('.ps-radius').prop("checked", true);
    });

    //下拉
    new divselect("#youhui", "#youhui-option");
    new divselect("#zixun", "#zixun-option");
    new divselect("#fuwu", "#fuwu-option");
    new divselect("#addService", "#addS");
    new divselect("#jnBox", "#jn-option");

    new divselect("#plshBox", "#plSh-option");
    new divselect("#cityBox", "#city-option");
    new divselect("#serviceBox", "#service-option");
    new divselect("#xiaoquBox", "#xiaoqu-option");
    new divselect("#quBox", "#qu-option");
    new divselect("#plSh", "#plSh-option");

    new divselect("#sfu", "#sfu-option");
    new divselect("#squ", "#squ-option");
    new divselect("#shi", "#shi-option");
    new divselect("#sheng", "#qu-option");
    new divselect("#sex", "#sex-option");
    new divselect("#jiaose", "#jiaose-option");
    new divselect("#jineng17", "#jineng17-option");
    new divselect("#mmQu", "#mmQu-option");
    new divselect("#spCate", "#spCate-option");
    new divselect("#spJn", "#spJn-option");
    new divselect("#qdJn", "#qdJn-option");
    $('.divselect').mouseleave(function() {
        $(this).find('ul').hide();
    })

    //时间范围



    //多选，全选


    $(".user-table tr").on("click", function() {
        if ($(this).find('.n-checkbox').hasClass('n-checkbox-selected')) {
            $(this).find('.n-checkbox').removeClass("n-checkbox-selected");
            $(this).removeClass('tr-selected');
            $(this).find('.checkbox').removeAttr('checked');
        } else {
            $(this).find('.n-checkbox').addClass("n-checkbox-selected");
            $(this).addClass('tr-selected');
            $(this).find('.checkbox').attr('checked', 'checked');
        }
        ;
    })
    $(".n-checkbox").on("click", function(event) {
        if ($(this).hasClass('n-checkbox-selected')) {
            $(this).removeClass("n-checkbox-selected");
            $(this).parents('tr').removeClass('tr-selected');
            $(this).find('.checkbox').removeAttr('checked');
            event.stopPropagation();
        } else {
            $(this).addClass("n-checkbox-selected");
            $(this).parents('tr').addClass('tr-selected');
            $(this).find('.checkbox').attr('checked', 'checked');
            event.stopPropagation();
        }
        ;
    })

    $('.order-table tbody tr').click(function() {
        $(this).addClass('tr-selected').siblings('tr').removeClass('tr-selected');
    })




    $('.all-check').click(function() {
        $(this).toggleClass('n-checkbox-selected');
        $(this).parents('table').find('.n-checkbox').toggleClass('n-checkbox-selected');
        $(this).parents('table').find('.n-checkbox').parents('tr').toggleClass('tr-selected');

    });

    /*$('.popbox').css('margin-top',-$('.popbox').height()/2);
     $('#otherAddress').css('margin-top',-$('#otherAddress').height()/2);*/
    //权限管理
    $('.qxinfo').click(function() {
        $('.overlayer').show();
        $('#qxBox').show();
    });
    $('.partinfo').click(function() {
        $('.overlayer').show();
        $('#partBox').show();
    });

    $('.popbox .close').click(function() {
        $('.overlayer').hide();
        $('.popbox').hide();
    })
    $('.popbox .p-close').click(function() {
        $('.overlayer').hide();
        $('.popbox').hide();
    })

    $('.addpart').click(function() {
        $('.overlayer').show();
        $('#addPartBox').show();
    });

    $('.mima').click(function() {
        $('.overlayer').show();
        $('#mimaBox').show();
    });

    $('.shouji').click(function() {
        $('.overlayer').show();
        $('#shoujiBox').show();
    });
    $('.sbUpdate').click(function() {
        $('.overlayer').show();
        $('#sbUpdate').show();
    });

    $('.i-edit').click(function() {
        $('#updateInfo').show();
        $('.overlayer').show();
    });
    $('.i-edit2').click(function() {
        $('#messageBox').show();
        $('.overlayer').show();
    });
    $('.i-save').click(function() {
        $('.info-input').removeClass('info-input-active');
        $('.info-input').attr("disabled", true);
        $('.i-edit').attr('style', 'display:inline-block');
        $('.i-save').hide();
        //$(this).addClass('i-edit');
        //$(this).text('编辑');
    });

    $('.btn-zhuanjie,fleslider.jscaiBox').click(function() {
        $('#zjBingBox').show();
        $('.overlayer').show();
    });
    $('.btn-waihu').click(function() {
        $('#zjWaiHu').show();
        $('.overlayer').show();
    });

    $('.shuxing-btn').click(function(event) {
        $('#shuxingBox').show();
        $('.overlayer').show();
    });
    $('.jfmos-btn').click(function(event) {
        $('#jifeiBox').show();
        $('.overlayer').show();
    });

    $('#add').click(function() {
        var $options = $('#select1 option:selected');//获取当前选中的项  
        var $remove = $options.remove();//删除下拉列表中选中的项  
        $remove.appendTo('#select2');//追加给对方  
    });

    $('#remove').click(function() {
        var $removeOptions = $('#select2 option:selected');
        $removeOptions.appendTo('#select1');//删除和追加可以用appendTo()直接完成  
    });

    $('#addAll').click(function() {
        var $options = $('#select1 option');
        $options.appendTo('#select2');
    });

    $('#removeAll').click(function() {
        var $options = $('#select2 option');
        $options.appendTo('#select1');
    });

    //双击事件  
    $('#select1').click(function() {
        //var $options = $('#select1 option:selected');  
        var $options = $('option:selected', this);//注意此处“option”与“:”之间的空格，有空格是不可以的  
        $options.appendTo('#select2');
    });

    $('#select2').click(function() {
        $('#select2 option:selected').appendTo('#select1');
    });

    //选择天使
    $('.btn-update').click(function(event) {
        $('#tsBox').show();
        $('.overlayer').show();
    });
    $('.tslist li .head').hover(function() {
        $(this).find('.intro-box').show();
    }, function() {
        $(this).find('.intro-box').hide();
    });

    //添加地址
    $('.btn-add').click(function() {
        $('.overlayer').show();
        $('#addPartBox').show();
    });
    //添加小钱
    $('.addXq').click(function() {
        $('.overlayer').show();
        $('#xqMap').show();
    });



    $('.selectBtn').click(function() {
        if ($(this).hasClass('selectBtn-ed')) {
            $(this).removeClass('selectBtn-ed');
            $(this).html('选择')
        } else {
            $(this).addClass('selectBtn-ed');
            $(this).html('<i></i>已选择')
        }
    })

    $('.order-info-box .info-item').hover(function() {
        $(this).addClass('info-active').siblings().removeClass('info-active');
    })

    $(".uploadBox").change(function() {
        var objUrl = getObjectURL(this.files[0]);
        if (objUrl) {
            $(".img0").attr("src", objUrl);
            $(".img0").css('width', '144');
            $(".img0").css('height', '144');
        }
    });
    $(".uploadBox1").change(function() {
        var objUrl = getObjectURL(this.files[0]);
        if (objUrl) {
            $(".img1").attr("src", objUrl);
            $(".img1").css('width', '144');
            $(".img1").css('height', '144');
        }
    });
    $(".uploadBox2").change(function() {
        var objUrl = getObjectURL(this.files[0]);
        if (objUrl) {
            $(".img2").attr("src", objUrl);
            $(".img2").css('width', '144');
            $(".img2").css('height', '144');
        }
    });
    $('.ts-in-box').width($('.table-hd td').length * 58);

    $('.ts-in-box td').click(function() {
        if ($(this).hasClass('kong-hd')) {
            $(this).addClass('selected-hd');
            $(this).removeClass('kong-hd');
            $(this).text('已选')
        } else if ($(this).hasClass('selected-hd')) {
            $(this).addClass('kong-hd');
            $(this).removeClass('selected-hd');
            $(this).text('空闲')
        }
        ;
    })


    $(".select-bd li").hover(function() {
        $(this).find('.sub-itembox').slideDown('fast');
        $(this).addClass('selected');
    }, function() {
        $(this).find('.sub-itembox').hide();
        $(this).removeClass('selected');
    });
    $('.sx-item .close').click(function() {
        $(this).parent('.sx-item').remove();
    });

    $('.add-c-people').click(function(num) {
        var num = $('#j-contact').find('.jh-bd').length + 1;
        var people = '<div class="jh-bd cl"><div class="jh-group"><div class="hd">联系人' + num + '：</div><input type="text" class="jh-control" value="" /></div><div class="jh-group"><div class="hd">联系电话：</div><input type="text" class="jh-control" value="" /></div><div class="jh-group"><div class="hd">关系：</div><select class="jh-select"><option>夫妻</option></select></div><div class="c-del"></div></div>';
        $("#j-contact").append(people);
    });

    $("#j-contact").on('click', '.c-del', function() {
        $(this).parent('.jh-bd').remove();
    });

    $('.select-other').click(function(event) {
        $('#otherAddress').show();
        $('.overlayer').show();
    });

    $('.ts-name').hover(function() {
        $(this).find('.ts-content').toggle();
        var ts_le = $('.ts-name').length;
        var index = $('.ts-name').index(this);
        //alert(index);
        if (index > (ts_le - 6)) {
            $(this).find('.ts-content').addClass('ts-content2');
        } else {
            $(this).find('.ts-content').removeClass('ts-content2');
        }
        ;
    });


    $('.ts-table .ts-line').height($('#tsTable tr').length * 39);
});