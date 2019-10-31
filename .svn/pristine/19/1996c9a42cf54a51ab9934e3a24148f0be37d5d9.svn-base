var model={
    information:{
        operatorId:1,//发布人id
          informationType:null,//类型
          infoTitile:null,//标题
          infoContent:null//内容
    },
    picParm:{
        Id:null,
        type: null
    },
    list:[]
}
var E = window.wangEditor;
var editor = new E('#editor');
editor.customConfig.uploadImgServer = '/biz/fileManager/uploadSinglePic';
editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
editor.customConfig.uploadImgMaxLength = 5;
editor.customConfig.uploadImgParams = {
    // 如果版本 <=v3.1.0 ，属性值会自动进行 encode ，此处无需 encode
    // 如果版本 >=v3.1.1 ，属性值不会自动 encode ，如有需要自己手动 encode
    type: model.picParm.Id,
    Id: model.picParm.type
}
editor.customConfig.uploadImgHooks = {
    customInsert: function (insertImg, result, editor) {
        // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
        // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

        // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
        var url =result.url;
        console.log(url)
        insertImg(url);

        // result 必须是一个 JSON 格式字符串！！！否则报错
    }
}
editor.create();

function save() {
    selectPicIds();
    model.information.informationType=parseInt($("#infoType").val());
    model.information.infoTitile=$("#title").val();
    model.information.infoContent=editor.txt.html();
    $.ajax({
        type:"post",
        url:"/biz/information/add",
        data:{information:JSON.stringify(model.information),imageIds:JSON.stringify(model.list)},
        // contentType:"application/json",
        dataType:"json",
        success:function (results) {
            if (results.status==200) {
                $("#home").load("views/info/infoRelease.html");
            }else {
                alert("发布信息失败！")
            }
        }
    })
}
function selectPicIds() {
    var imgsrcs=[];
    $("#editor img").each(function() {
        imgsrcs.push($(this).attr("src"));
    });
    $.ajax({
        type:"post",
        url:"/biz/dogCard/selectIdsByurl",
        async:false,
        data: JSON.stringify(imgsrcs),
        contentType:"application/json",
        dataType:"json",
        traditional:true,
        success:function (results) {
            if(results.code=="000000" && results.result!=null && JSON.stringify(results.result)!="[]"){
                model.list=results.result;
            }
            console.log(results)
        }
    })
}
function que() {
    $("#home").load("views/info/infoRelease.html")
}