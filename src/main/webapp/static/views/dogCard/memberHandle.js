let baseUrl = "http://localhost:8888/biz"
let data = [];//页面数据
let infodata = {};//详情页数据
//切换页面
function switchDisable() {
    let status = $(".table-container").css("display")
    if ('none' == status) {
        $(".table-container").show();
        $(".info-container").hide();
    } else {
        $(".table-container").hide();
        $(".info-container").show();
    }
}

$(function () {
    $(".glyphicon").css('cursor', 'pointer').click(function () {//切换到详情页
        //添加搜索框
        let temp = '<div class="add-tmp" style="margin-top: 20px;margin-left: 20px;">' +
            '<label>用户搜索:</label>' +
            ' <input id="earchPhone" type="text" placeholder="请输入电话号码...">' +
            '<font color="red">&nbsp;&nbsp;*输入犬主电话号码搜索犬主信息</font>' +
            '</div>';
        $(".info-gosw").after(temp);

        switchDisable();
        $(".panel-info input[readonly=readonly]").val("");
        $(".mav-text").text($(".mav-text").text().replace("查看详情", "会员证办理"))
        $(".btns").show();
        $("#dyxqxk, #dyxqxj, #earchPhone").css("borderColor", "#49C8DA");

        //证件信息 初始值
        let date = new Date();
        //会员证号码
        let cradNum = date.format(date, "yyyyMMddHHmmss");
        $("#dogCardNum").val(cradNum);
        $("#dqfjg").val("签发机构");//签发机构名
        $("#dqfrq").val(date.format(date, 'yyyy年MM月dd日'));//签发日期
        //有效期限
        $("#dyxqxk").attr("type", "date").attr("readonly", false).attr("min", date.format(date, 'yyyy-MM-dd'));
        $("#dyxqxj").attr("type", "date").attr("readonly", false).attr("min", date.format(date, 'yyyy-MM-dd'));

    })
    //返回
    $("#return").click(function () {
        switchDisable()
        let a = $(".iadd-tmp")
        $(".add-tmp").remove(); //移除搜索框
    });


    //犬证table
    // Table.initDogCardTable();
    var oTable = new TableInit();
    oTable.Init();
    //模糊查询按钮事件
    $('#search11').click(function () {
        let keyword = $("#inpu").val();
        keyWord = keyword;
        $('#dogCardTable').bootstrapTable('refresh', {url: baseUrl + "/member/list"});
    });

    let resData = {}//根据电话搜索的犬主信息数据  //搜索的结果

    //搜索电话号码
    $(".panel-info").on("blur", "#earchPhone", function () {//搜索按钮
        let phone = $(this).val().trim();
        $.ajax({
            url: baseUrl + "/dogAndOwner/selectDogOwnersByPhone",
            cache: false,
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            data: {
                phone
            },
            success(res) {
                if (res.meta.success && res.data.length == 1) {
                    resData = res.data[0];
                    $("#dogOwerName").val(resData.dogOwnerName);//犬主姓名
                    $("#xz").val(resData.dogOwnerType == 0 ? "个人" : "企业");//性质:
                    $("#zjlx").val(resData.cardType);//证件类型:
                    $("#zjhm").val(resData.cradNum);//证件号码:
                    $("#xb1").val(resData.sex == 0 ? "男" : "女");//性别:
                    $("#csrq1").val(Date.format(resData.creationTime, 'yyyy年MM月dd日'));//创建时间:
                    $("#phone").val(resData.dogOwnerPhone);//联系电话:
                    $("#dzyx").val(resData.eMail);//电子邮箱:
                    $("#yb").val(resData.postalCode);//邮编:
                    $("#xzqx").val(resData.address);//详细地址:
                }

            }
        })
    })
    //保存按钮
    $("#insert").click(function () {
        let curDate = new Date();
        let memberName = $("#dogOwerName").val().trim();
        let memberPhone = resData.dogOwnerPhone;
        let memberAddress = resData.address;
        let issueOrgId = 1;//机构id
        let issueId = 1;//用户id
        let upTime = $("#dyxqxk").val().trim();
        let expireTime = $("#dyxqxj").val().trim();
        if(!(upTime &&  expireTime)){
            alert("时间期限不能为空！");
            return;
        }

        let issueDate = curDate.format(curDate);
        let memberCardNo = $("#dogCardNum").val().trim();
        let dogOwnerId = resData.dogOwnerId;
        let creationTime = curDate.format(curDate);
        $.ajax({//保存数据
            url: baseUrl + "/member",
            method: "post",
            cache: false,
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            data: {
                memberName,
                memberPhone,
                memberAddress,
                issueOrgId,
                issueId,
                upTime,
                expireTime,
                issueDate,
                memberCardNo,
                dogOwnerId,
                creationTime
            },
            success(res) {
                if(res.meta.success){
                    alert("插入成功！")
                }else{

                }
                alert("插入失败！")
            },
            error(){
                alert("插入失败！")
            }
        })
    })


});
let keyWord = '';

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $("#dogCardTable").bootstrapTable({
            url: baseUrl + "/member/list",         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: function (params) {//上传服务器的参数
                let temp = {
                    offset: params.offset,   //页码
                    limit: params.limit,    // 每页显示数量
                }
                if (keyWord) {
                    temp.keyWord = keyWord;
                }
                return temp;
            },//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            // search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            // strictSearch: true,
            // showColumns: true,                  //是否显示所有的列
            // showRefresh: true,                  //是否显示刷新按钮
            // minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            // showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            // cardView: false,                    //是否显示详细视图
            // detailView: false,                   //是否显示父子表
            classes: "table table-striped table-bordered table-thead",
            columns: [{
                field: 'memberCardNo',
                title: '会员证号',
                align: 'center',
            }, {
                field: 'dogOwnerName',
                title: '犬主姓名',
                align: 'center',
                formatter(value, row, index) {
                    return row.tDogOwner.dogOwnerName;
                }
            }, {
                field: 'tDogOwnerCards',
                title: '身份证号',
                align: 'center',
                formatter(value, row, index) {
                    let cardNum = value.map((item, index) => {
                        if (1 == item.cardType) {//身份证
                            return item.cardNum
                        }
                    });
                    return cardNum ? cardNum : '无';
                }
            }, {
                field: 'memberPhone',
                title: '电话',
                align: 'center',
            }, {
                field: 'issueDate',
                title: '办理时间',
                align: 'center',
            }, {
                field: 'tUsers',
                title: '办理人',
                align: 'center',
                formatter(value, row, index) {
                    return value.username;
                }
            }, {
                field: 'tOrganization',
                title: '办理机构',
                align: 'center',
                formatter(value, row, index) {
                    return value.organizationName;
                }
            }, {
                field: 'Desc',
                title: '操作',
                align: 'center',
                events: operateEventss,
                formatter: operateFormatter
            }],
            formatNoMatches: function () {
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function () {
                // return "请稍等，正在加载中。。。";
                return "";
            },
            onLoadSuccess: function (data) {

            },
            responseHandler: function (result) { //格式化数据
                if (result.data != null && result.data.list != null) {
                    return {
                        total: result.data.total, //总页数,前面的key必须为"total"
                        rows: result.data.list //行数据，前面的key要与之前设置的dataField的值一致.
                    };
                }
                return {
                    total: 0,
                    rows: []
                };
            },
        });

    };
    window.operateEventss = {
        //查询详情
        'click #btn_detail': function (e, value, row, index) {
            $(".mav-text").text($(".mav-text").text().replace("会员证办理", "查看详情"))
            // $("#dyxqxk,#dyxqxj")
            $(".btns").hide();
            $("#dyxqxk, #dyxqxj,#earchPhone").css("borderColor", "red").attr("readonly",true);


            infodata = data[index];
            switchDisable();
            $("#dogCardNum").val(infodata.memberCardNo);//会员证号
            $("#dqfjg").val(infodata.tOrganization.organizationName);//签发机构

            $("#dqfrq").val(Date.format(infodata.issueDate));//签发日期
            $("#dyxqxk").val(Date.format(infodata.issueDate));//有效期限 min
            $("#dyxqxj").val(Date.format(infodata.expireTime));//有效期限 max

            $("#dogOwerName").val(infodata.tDogOwner.dogOwnerName);//犬主姓名
            $("#xz").val(infodata.tDogOwner.dogOwnerType == 0 ? "个人" : "企业");//性质:

            let temp = infodata.tDogOwnerCards.map((e, i) => {
                if (0 == e.cardType) return e;
            })

            $("#zjlx").val('身份证');//证件类型:
            $("#zjhm").val(temp.cardNum);//证件号码:
            $("#xb1").val(infodata.tDogOwner.sex == 0 ? "男" : "女");//性别:
            $("#zjhm").val(infodata.tDogOwner.cardNum);//证件号码:
            $("#csrq1").val(Date.format(infodata.tDogOwner.creationTime));//出生日期:
            $("#xzqx").val(infodata.tDogOwner.address);//现住区县:
            $("#ssbm").val(infodata.tDogOwner.address);//所属部门:
            $("#sssq").val(infodata.tDogOwner.address);//所属社区:
            $("#yb").val(infodata.tDogOwner.address);//邮编:
            $("#phone").val(infodata.tDogOwner.dogOwnerPhone);//联系电话:
            $("#dzyx").val(infodata.tDogOwner.eMail);//电子邮箱:
            $("#xxdz").val(infodata.tDogOwner.address);//详细地址:


        },
        //发消息
        'click .RoleOfB': function (e, value, row, index) {

        }
    }

    function operateFormatter(value, row, index) {
        data.push(row);
        return [
            '<a id="btn_detail" type="button" class="RoleOfA btn-default bt-select" style="color: rgb(65, 199, 219);cursor: pointer;">查看详情</a>',
        ].join('');
    }

    return oTableInit;
};
