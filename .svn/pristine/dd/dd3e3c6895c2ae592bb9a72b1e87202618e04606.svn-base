var input=null;
$(function () {
    //图片分页显示
    picturePage();
    $("#ss").click(function () {
        input=$("#input").val().trim();
        picturePage();
    })
    // $(".imggrid-list ul li div").css("background-color","#ffffff");
});
function picturePage() {
    var data = {
        "page": 1,//当前页码
        "records": 20,//总条数
        "rows": [{ "Id": 60, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 61, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 62, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 63, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 64, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 65, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 66, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 67, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 68, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 69, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 70, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 71, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 72, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 73, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 74, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 75, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 76, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 77, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 78, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 78, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 61, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 62, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 63, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 64, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 65, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 66, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 67, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 68, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 69, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 70, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 71, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 72, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 73, "ImgUrl": "../../../static/images/abc.png" },
            { "Id": 73, "ImgUrl": "../../../static/images/abc.png" },
            // { "Id": 74, "ImgUrl": "../../../static/images/abc.png" },
            // { "Id": 75, "ImgUrl": "../../../static/images/abc.png" },
            // { "Id": 76, "ImgUrl": "../../../static/images/abc.png" },
            // { "Id": 77, "ImgUrl": "../../../static/images/abc.png" },
            // { "Id": 78, "ImgUrl": "../../../static/images/abc.png" },
            // { "Id": 78, "ImgUrl": "../../../static/images/abc.png" }
        ]
    };
    $('#imggrid').imgGrid({
        // title: '图片集',
        type: 'GET',//GET|POST
        // data:data,//本地数据
        url: '/biz/dogAndOwner/selectHomeDogBanList',//ajax URL
        params: {input:input},//url参数
        pageselect: [20, 40],
        // height:"1230px",
        height:"auto",
        // width: '850px',
        img: { width: '240px', animate: 'zoomIn' },//图片宽度，及动画效果
        // onClick: function (obj, index, item) {//点击图片事件
        //     alert(index);
        // },
        render: function (item, index) {//自定义显示图片
            var buffer = new StringBuffer();
            buffer.append('<img src="'+item.url+'">');
            buffer.append('<div><span style="font-size: 18px;">'+item.dogBreedBame+'</span></div>');
            return buffer.toString();
        }
    });
}