$(function () {
    //初始化表格
    oTableInit();

    //切换tab
    $(".top-tabbar>div").click(function () {
        deviePageIndex = $(this).index();

        $(this).css({//tba切换
            "backgroundColor": "#51CAD4",
            "color": "#fff"
        }).siblings().css({
            "backgroundColor": "#F5F5FA",
            "color": "#9EA9C5"
        });

        if (0 == deviePageIndex) {//按钮切换
            $(".example").removeClass("none");
            $(".disableds").addClass("none");
        } else if (1 == deviePageIndex) {
            $(".example").addClass("none");
            $(".disableds").removeClass("none");
        }

        oTableInit();
    })

    //search input event
    $(".form-input").change(function () {
        params.keyword = $(this).val();
    }).keyup(function (e) {
        if (e.key.toString().toUpperCase() == 'ENTER') {
            params.keyword = $(this).val();
        }
    });
    $(".search-icon").click(function () {
        search($(this).next().val());
    })

    //导入
    $(".import").click(function () {
        $(".uploadfile").trigger("click", function () {
        });
    });
    $(".uploadfile").change(function (e) {
        let files = e.target.files;
        if (!files || files.length != 1) {
            alert("请一次上传一个文件1")
            return;
        }
        let formdata = new FormData();
        formdata.append('file', files[0]);
        $.ajax({
            url: baseUrl + "/import?userId=" + userId,
            method: "post",
            dataType: 'JSON',
            cache: false,
            processData: false,  //不处理发送的数据，因为data值是FormData对象，不需要对数据做处理
            contentType: false,   //不设置Content-type请求头
            data: formdata,
            mimeType: "multipart/form-data",
            success(res) {
                alert("success！")
                initTable();
            }, error(res) {
                alert("网络错误！")
            }
        })
    });

    //模板下载
    $(".example-download").click(function () {
        window.location.href = baseUrl + "/export?userId" + userId;
    });

    //禁用按钮
    $(".disableds").click(function () {
        let itmes = $(".selected").find("[data-id]");
        if (!itmes || itmes.length == 0) {
            alert("大兄弟选择数据啊！！！");
            return;
        }

        let deviceIds = [];//请求的数据 设备id集合
        itmes.each(function (index, item) {
            deviceIds.push($(this).attr("data-id"));
        });
        let status = 0;//禁用设备
        $.ajax({
            url: baseUrl + "/list/" + status,
            data: "deviceIds=" + deviceIds,
            method: 'put',
            dataType: 'JSON',
            contentType: "application/x-www-form-urlencoded",
            // traditional:false,
            success(res) {
                alert("success!!！")
                oTableInit();
            }, error(res) {
                alert("网络错误！")
            }
        })
    })

    //导出excel表格
    $(".export").click(function () {
        let itmes = $(".selected").find("[data-id]");
        if (!itmes || itmes.length == 0) {
            alert("请选择要导出的数据！");
            return;
        }

        let selectDevies = [];//需要导出的数据
        itmes.each(function (i, n) {
            pageData.map((item, index) => {
                if (item.deviceId == $(this).attr("data-id")) {
                    selectDevies.push(item);
                }
            })
        })
        //导出数据
        sendHttp(baseUrl + "/export/data", "post", {"paramStr": JSON.stringify(selectDevies)})
    })

})

//search fun 搜索关键字
function search(keyWord) {
    params.keyword = keyWord;
    oTableInit();
}

let userId = 7;
let deviePageIndex = 1;//被选中的按钮下标 默认已审核


let params = {//页面参数
    deviceStatus: deviePageIndex, //激活状态 0 禁用 1启用
    offset: null,  //页码
    limit: null,//页面大小
    keyword: null//关键字
}

let pageData = [];//数据

let baseUrl = 'http://localhost:9000/biz/device';


function oTableInit() {
    $("#deviceManagerActive").bootstrapTable('destroy');
    $('#deviceManagerActive').bootstrapTable({
        url: baseUrl + '/list',   //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        //toolbar: '#toolbar',
        // classes: 'theadStyle',
        checkboxHeader: true,
        dataType: "json",               		//工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        searchOnEnterKey: true,
        // searchText:'请录入',
        undefinedText: "无",
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        //showColumns: true,                  //是否显示所有的列
        //showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,   				//是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",							//每一行的唯一标识，一般为主键列
        queryParams: function (e) {         //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            params.limit = e.limit;//页面大小
            params.offset =(e.offset / e.limit) + 1// e.offset; //页码
            params.deviceStatus = deviePageIndex;
            if (!params.keyword) delete params.keyword
            return params;
        },
        columns: [{
            checkbox: true,
            width: '5%',
            clickToSelect: true,
            valign: 'middle',
            align: 'center',
            // events: {
            //     'mouseover input': function (e, value, row, index) {
            //         // debugger
            //         // if($(this).prop("checked")){
            //         //     $(this).prop("checked", true)
            //         // }else{
            //         //     $(this).prop("checked", false)
            //         // }
            //
            //     }
            // },
        }, {
            field: 'deviceNumber',
            title: '序号',
            width: '5%',
            valign: 'middle',
            align: 'center',
            formatter(value, row, index, field) {
                return "<span data-id='" + row.deviceId + "'>" + (index + 1) + "</span>";
            }
        },  {
            field: 'deviceNumber',
            title: '编号',
            width: '12%',
            valign: 'middle',
            align: 'center'
        },{
            field: 'deviceBrand',
            title: '品牌',
            width: '12%',
            valign: 'middle',
            align: 'center'
        }, {
            field: 'model',
            title: '型号',
            width: '12%',
            valign: 'middle',
            align: 'center',
            formatter(value, row, index, field) {
                return row.tDeviceModel.deviceModelName;
            }
        }, {
            field: 'productionTime',
            title: '出厂日期',
            width: '12%',
            valign: 'middle',
            align: 'center',
            formatter(value, row, index, field) {
                return Date.format(value, 'yyyy年MM月dd日')
                // return format(value);
            }
        }, {
            field: 'deviceStatus',
            title: '状态',
            width: '12%',
            valign: 'middle',
            align: 'center',
            formatter(value, row, index, field) {
                return value == 0 ? '已禁用' : value == 1 ? '启用' : '已注销';
            }
        }, {
            field: 'creationTime',
            title: '录入时间',
            width: '12%',
            valign: 'middle',
            align: 'center',
            events: {
                'click .chakan': function (e, value, row, index) {


                },
                'click .chakan': function (e, value, row, index) {
                    sessionStorage.setItem("data-device-info", JSON.stringify(row));
                    // $("#home").load("./views/message_moderation/moderation_info.html");
                }
            },
            formatter(value, row, index, field) {
                return Date.format(value, 'yyyy年MM月dd日');
            }
        }],
        onLoadSuccess: function (data) {

        },
        onLoadError: function (status) {
            console.log(status);
        },
        formatLoadingMessage: function () {
            // return "请稍等，正在加载中。。。";
            return "";
        },
        formatShowingRows: function (e) {
            return "当前第 " + params.offset + " 页，本页 " + pageData.length + " 条";
        },
        formatNoMatches: function () {
            return "没有数据";
        },
        formatRecordsPerPage: function (pageNumber) {
            // console.log($(e).text())
            return "";
        },
        responseHandler: function (result) { //格式化数据
            pageData = result.data.list;//放入页面参数
            if (result.data != null && result.data.list != null) {
                return {
                    total: result.data.total, //总条数,前面的key必须为"total"
                    rows: result.data.list //行数据，前面的key要与之前设置的dataField的值一致.
                };
            }
            return {
                total: 0,
                rows: []
            };
        },
    });
}

