//页面加载函数
$(function () {
    $(document).on("show.bs.modal", ".modal", function(){
        $(this).draggable();
        $(this).css("overflow-y", "scroll");
        // 防止出现滚动条，出现的话，你会把滚动条一起拖着走的
    });

    $(document).on("hide.bs.modal", ".modal", function(){
        //如果您点击了 关闭 按钮，取消remarks
        clearMarks();
    });

    var editorTool,map= new AMap.Map("container", {
        resizeEnable: true,
        //center: [116.403322, 39.900255],//地图中心点
        zoom: 14 //地图显示的缩放级别
    });
    //ip定位
    AMap.plugin('AMap.CitySearch', function () {
        var citySearch = new AMap.CitySearch()
        citySearch.getLocalCity(function (status, result) {
            if (status === 'complete' && result.info === 'OK') {
                // 查询成功，result即为当前所在城市信息
                //console.log(result);
            }
        })
    })

    //浏览器定位（精确定位）
    // AMap.plugin('AMap.Geolocation', function() {
    //     var geolocation = new AMap.Geolocation({
    //         enableHighAccuracy: true,//是否使用高精度定位，默认:true
    //         timeout: 10000,          //超过10秒后停止定位，默认：5s
    //         buttonPosition:'RB',    //定位按钮的停靠位置
    //         buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
    //         zoomToAccuracy: true,   //定位成功后是否自动调整地图视野到定位点
    //
    //     });
    //     map.addControl(geolocation);
    //     geolocation.getCurrentPosition(function(status,result){
    //         if(status=='complete'){
    //             console.log(result)
    //             //onComplete(result)
    //         }else{
    //             console.log(result)
    //             //onError(result)
    //         }
    //     });
    // });

    //当前绘制的点个数，用来控制前面3个点
    var beginNum = 0;
    //地图上面的click事件对象
    var clickListener ;
    //用来存储3个基本点的数组 第一个存点坐标 第二个存Marker（点标记）对象
    var beginPoints;
    var beginMarks ;
    //多边形编辑事件
    var polygonEditor;

    init();
    //初始化
    function init(){
         beginPoints = [];
         beginMarks = [];
         beginNum = 0;
         polygonEditor = '';
        getfences();
    }

    //点击添加按钮时加载map点击绑定事件
    $("#start_addFence").click(function () {
        //map点击事件绑定
        clickListener = AMap.event.addListener(map, "click", mapOnClick);
    })

    //围栏设置结束事件
    $("#end_addFence").click(function () {
        AMap.event.removeListener(clickListener);
        //openInfo();
    })

    //提交点击事件
    $("#submit_button").click(function () {
        var fenceName = $("#fenceName").val();
        var polygon = createPolygon(beginPoints,null,fenceName);
        polygonEditor = createEditor(polygon);
        clearMarks();
        $('#set_fenceName').modal('hide')
    })

    //地图上面绑定的点击事件
    function mapOnClick(e) {
        beginMarks.push(addMarker(e.lnglat));
        beginPoints.push(e.lnglat);
    };

    //创建多边形
    function createPolygon(arr,fenceId,fenceName){
        var polygon = new AMap.Polygon({
            map: map,
            path: arr,
            strokeColor: "#0000ff",  //线条颜色
            strokeOpacity: 1,        //轮廓线透明度，取值范围[0,1]，0表示完全透明，1表示不透明
            strokeWeight: 3,         //	轮廓线宽度
            fillColor: "#f5deb3",    //多边形填充颜色
            fillOpacity: 0.35,       //多边形填充透明度, 取值范围[0,1]，0表示完全透明，1表示不透明
            extData:{
                fenceName:fenceName,
                fenceId:fenceId
            }
        });
        //绑定多边形对象点击时间
        polygon.on("click",function (res) {
            polygonEditor = createEditor(polygon);
        });
        //绑定右键点击事件
        polygon.on("rightclick",function (e) {
           createContextMenu(polygon,e)
        })
        return polygon;
    }
    
    //创建右键菜单
    function createContextMenu(polygon,e) {
        var contextMenu = new AMap.ContextMenu();//创建右键菜单
        //获取围栏id
        var extData = polygon.getExtData();
        //添加菜单元素
        contextMenu.addItem("删除", function() {
            deletefence(extData.fenceId);
        }, 0);
        contextMenu.addItem("编辑", function() {
            createEditor(polygon);
        }, 0);
        contextMenu.open(map,e.lnglat);
    }
    
    function deletefence(fenceId) {
        $.ajax({
            url:"/biz/fence/deleteFence",
            contentType: "application/x-www-form-urlencoded",
            type:"post",
            dataType:"json",
            data:{
                fenceId:fenceId
            },
            success:function (res) {
                bootbox.alert("删除成功");
                window.location.reload();
            }
        })
    }
    //访问数据库获取围栏信息
    function  getfences() {
        $.ajax({
            url:"/biz/fence/selectFenceRefCoordinate",
            contentType: "application/x-www-form-urlencoded",
            type:"post",
            dataType:"json",
            success:function (res) {
                console.log(res);
                var fences = res.data;
                for (var index in fences){
                    var fence = fences[index];
                    //获取围栏顶点坐标
                    var coordinatelist = [];
                    var coordinates = fence.coordinates;
                    for (var i = 0; i < coordinates.length; i++){
                        //创建一个坐标对象
                        var coordinate = [];
                        coordinate.push(coordinates[i].longitude);
                        coordinate.push(coordinates[i].latitude);
                        coordinatelist.push(coordinate);
                    }
                    //每一个围栏创建一个多边形覆盖物
                    createPolygon(coordinatelist,fence.fenceId,fence.fenceName);
                }
            }
        })
    }

    //创建地图编辑事件
    function createEditor(polygon){
        var polygonEditor = new AMap.PolyEditor(map, polygon);
        polygonEditor.open();
        //监听编辑事件结束
        AMap.event.addListener(polygonEditor,'end',polygonEnd);
        return polygonEditor;
    }

    //编辑结束事件
    function polygonEnd(res){
        //将围栏信息添加到数据库
        var fence = {};
        //禁养围栏
        fence.fenceType = 0;
        //暂定
        fence.operatorId = 0;
        //默认启用
        fence.status = 1;
        console.log(res)
        var extData = res.target.getExtData();
        //获取围栏名称
        fence.fenceName = extData.fenceName;
        //获取围栏id
        fence.fenceId = extData.fenceId;
        var coordinates =[]
        var paths = res.target.getPath();
        for (var index in paths){
            var path = paths[index];
            //创建一个围栏坐标对象
            var coordinate = {};
            coordinate.longitude = path.lng;
            coordinate.latitude = path.lat;
            coordinate.districtId = 0;
            coordinates.push(coordinate);
        }
        //发送添加请求
        $.ajax({
            url:"/biz/fence/addFence",
            contentType: "application/x-www-form-urlencoded",
            type:"post",
            dataType:"json",
            data:{
                fence :JSON.stringify(fence),
                coordinates:JSON.stringify(coordinates)
            },
            success:function (res) {
                window.location.reload();
            }
        })
        init();
    }

    //结束编辑
    $("#endEditFence").click(function () {
        polygonEditor.close();
    })

    //清除marks
    function clearMarks(){
        map.remove(beginMarks);
    }

    // 实例化点标记
    function addMarker(lnglat) {
        var marker = new AMap.Marker({
            icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
            position: lnglat
        });
        marker.setMap(map);
        return marker;
    }

    //将json字符转化为坐标数组
    function json2arr(json){
        var arr = JSON.parse(json);
        var res = [];
        for (var i = 0; i < arr.length; i++) {
            var line = [];
            line.push(arr[i].lng);
            line.push(arr[i].lat);
            res.push(line);
        };
        return res;
    }
})



