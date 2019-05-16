let params = {//页面参数
    informationId: 3,

}

let baseUrl = 'http://localhost:8888/biz/information';
$(function () {
    let information =  window.sessionStorage.getItem("moderation_data_shenghe")
    information = JSON.parse(information);
    console.log(information)
    $.ajax({//请求页面数据
        url: baseUrl + "/getInformation",
        data: {
            informationId: params.informationId
        },
        method: "post",
        datatype: 'json',
        contentType: "application/x-www-form-urlencoded",
        success(res) {
            if (res.status == 200) {
                let data = res.data;
                $(".tit").text(data.childTitile);//标题
                $(".tit-type").text(data.informationTypeName);//类型
                $(".tit-org").text(data.pubishOrg);//发布单位
                $(".tit-time").text(data.creationTime);//发布时间
                $(".list").html(data.infoContent);//网页内容
            }
        }
    });
    //审核  0审核中，1审核通过,3未通过
    $(".btns>span").click(function () {
        let index = $(this).index();
        if (0 == index) {
            index = 1;//通过
        } else if (1 == index) {
            index = 3;//不通过
        } else if (2 == index) {
            //取消  退回上一页
            $("#home").load("views/message_moderation/message_moderation.html")
            return;
        } else {
            alert("操作有误！");
            return;
        }

        $.ajax({
            url: baseUrl + "/examine",
            data: {
                status: index,
                informationId: params.informationId,
            },
            method: "post",
            success(res) {
                if (res.status == 200) {
                    alert("success!")
                } else {
                    alert("errer!")
                }
            }
        });
    })
});

function btns() {
    $.ajax({
        url: baseUrl + "/examine",
        status: '',
    });
}