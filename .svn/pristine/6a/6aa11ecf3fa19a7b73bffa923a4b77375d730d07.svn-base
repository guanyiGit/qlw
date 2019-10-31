var model={
		breedData:null,
		ageData:null,
		districtData:null,
		sexData:null,
		collBreedData:null,
		collTypeData:null,
		collSexData:null,
		timeArray:null,//全市犬只趋势参数
		countArray:null,
		collTimeArray:null,//收容犬只趋势参数
		collCountArray:null
}

$(function () {
	//1.查询昨日狗的信息 收容 认养 违法
	findYesterDayCollAndLeave();
	
	//2.收容中,已认养,已处理
	findCollLeaveHandelDog();
	//3.上月违法次数
	findLastMonthDogIllegalCounts();
	
	//4.收容犬只分布
		//4.1收容犬只品种分布
		findCollDogBreed();
		//4.2收容犬只性别分布
		findCollDogSex();
		//4.3收容犬只类型分布
		findCollDogType();
	//5全市犬只分布
	//5.1全市犬只犬只品种分布
	findDogBreedsCounts();
	//5.2全市犬只犬龄分布
	findDogAgeCounts();
	//5.3全市犬只区域分布
	findDogCountsByDistrict();
	//5.4全市犬只性别分布
	findDogGenderCounts();
	
	//6.收容犬只趋势
	findCollDogCountsTendency();
	//7.全市犬只每月新增趋势
	findDogCountsTendency();
	//8.违法次数趋势
	findDogIllegalCountsTendency();
    //初始化犬只数量趋势图 dogNumsEchart(收容犬只)
    //initDogNumsEchart();
    //初始化违法次数趋势NumberOfViolationsEchart
    //initNumberOfViolationsEchart();
    // initTable.initNumberofviolationsTable();
    //createDivNumberOfViolations();
    //初始化轮播图
    initlbt();
    //echart1（收容犬只类型分布）
    //initEchart1();
    //初始化 犬只分类统计图2(收容犬只品种分布)
    //initCartogramEchart();
    //echart3(收容犬只性别分布)
    //initEchart3();
  
	
    //在tab打开之后触发 'a[data-toggle="tab"]'
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        var id = e.target.hash ;// 激活的标签页
        e.relatedTarget; // 前一个激活的标签页
        if(id=="#tab2"){
        	//轮播 initlbt2
            initlbt2();
            // tab2echart1
            initTab2Echart11();
            // initTab2Echart12();
            // tab2echart2
            initTab2echart2();
            //tab2echart3(全市犬只品种分布)
            initTab2echart3();
        }else if(id=="#tab22"){
        	//犬只趋势(全市犬只)
            initDogNumsEchart2();
        }
    });


	
//	//轮播 initlbt2
//    initlbt2();
//    // tab2echart1
//    initTab2Echart11();
//    // initTab2Echart12();
//    // tab2echart2
//    initTab2echart2();
//    //tab2echart3(全市犬只品种分布)
//    initTab2echart3();
//	//犬只趋势(全市犬只)
//    initDogNumsEchart2();
});
//(收容犬只新增趋势)
function onchangeCollCount(){
	findCollDogCountsTendency();
}

//(犬只新增趋势)
function onchangeCount(){
	findDogCountsTendency();
}

//下拉框选择月份触发onchange事件(违法趋势)
function onchangeIllegalCount(){
	findDogIllegalCountsTendency();
}


//1#查询昨日狗的信息 收容 认养 违法
function findYesterDayCollAndLeave(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findYesterDayCollAndLeave",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		$(".headdivspan").empty();
        		$("#yesColl").append(result.yesterdayCollDog);
        		$("#yesLeave").append(result.yesterdayLeaveDog);
        		$("#yesIllegal").append(result.yesterdayIllegalCounts);
        	}
        }
 })
}

//2#收容中,已认养,已处理（daiceeshi）
function findCollLeaveHandelDog(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findCollLeaveHandelDog",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		$(".child").empty();
        		for(var i=0;i<result.length;i++){
        			if(result[i].result_type==0){//收容中
        				$("#colling").append(result[i].typeCounts);
        			}
        			if(result[i].result_type==1){//已认养
        				$("#adopted").append(result[i].typeCounts);
        			}
        			if(result[i].result_type==2){//已处理
        				$("#handled").append(result[i].typeCounts);
        			}
        		}
        		
        		
        		
        	}
        }
 })
}


//3#上月违法次数
function findLastMonthDogIllegalCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogIllegalCountsTendency",
        data:{count:1},
        dataType:"json",
        success: function (result) 
        {
        	if(result){
        		var data1=result.illegalCountsTendency;
        		var data2=result.totalIllegalCountsTendency;
        		$("#totalIllegal").empty();
        		if(data1.length>0){
        			createDivNumberOfViolations(data1);
        		}
        		if(data2.length>0){
        			$("#totalIllegal").append(data2[0].illegalCounts);
        		}
        		
        	}
        }
 })
}

//4#收容犬只分布
//4.1#收容犬只品种分布
function findCollDogBreed(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findCollDogBreed",
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		//model.collBreedData=result;
        		initCartogramEchart(result);
        	}
        }
 })
}
//4.2#收容犬只性别分布
function findCollDogSex(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findCollDogSex",
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
//        		model.collSexData=result;
        		initEchart3(result);
        	}
        }
 })
}
//4.3#收容犬只类型分布
function findCollDogType(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findCollDogType",
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		//model.collTypeData=result;
        		initEchart1(result);
        	}
        }
 })
}

//5#全市犬只分布
//5.1#全市犬只品种分布
function findDogBreedsCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogBreedsCounts",
        async: false,
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		model.breedData=result;
        	}
        }
 })
}

//5.2#全市犬只犬龄分布
function findDogAgeCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogAgeCounts",
        async: false,
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		model.ageData=result;
        	}
        }
 })
}
//5.3#全市犬只区域分布
function findDogCountsByDistrict(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogCountsByDistrict",
        async: false,
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		model.districtData=result;
        	}
        }
 })
}
//5.4#全市犬只性别分布
function findDogGenderCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogGenderCounts",
        async: false,
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		model.sexData=result;
        	}
        }
 })
}
//6#每月收容犬只新增数量趋势
function findCollDogCountsTendency(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findCollDogCountsTendency",
        data:{count:$("#collYearCount").val()},
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		var data=result.totalCollDogCountsTendency;
        		var timeArray=[];
        		var countArry=[];
        		for(var i=0;i<data.length;i++){
        			var creationTime=data[i].collectionTime;
        			timeArray.push(creationTime);
        			var dogCounts=data[i].collCounts;
        			countArry.push(dogCounts);
        		}
//        		model.collTimeArray=timeArray;
//        		model.collCountArray=countArry;
        		initDogNumsEchart(timeArray,countArry)
        	}
        }
 })
}
//7#每月犬只新增数量趋势
function findDogCountsTendency(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogCountsTendency",
        data:{count:$("#yearCount").val()},
        async: false,
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		var data=result.totalMonthAdd;
        		var timeArray=[];
        		var countArry=[];
        		for(var i=0;i<data.length;i++){
        			var creationTime=data[i].creationTime;
        			timeArray.push(creationTime);
        			var dogCounts=data[i].dogCounts;
        			countArry.push(dogCounts);
        		}
        		model.timeArray=timeArray;
        		model.countArry=countArry;
        		//initDogNumsEchart2(timeArray,countArry)
        	}
        }
 })
}

//8#每月犬只违法数量趋势
function findDogIllegalCountsTendency(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogIllegalCountsTendency",
        data:{count:$("#yearIllegalCount").val()},
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		var data=result.totalIllegalCountsTendency;
        		var timeArray=[];
        		var countArry=[];
        		for(var i=0;i<data.length;i++){
        			var illegalDate=data[i].illegalDate;
        			timeArray.push(illegalDate);
        			var illegalCounts=data[i].illegalCounts;
        			countArry.push(illegalCounts);
        		}
        		initNumberOfViolationsEchart(timeArray,countArry);
        	}
        }
 })
}
//初始化initTab2Echart11(全市犬只区域、性别分布)
function initTab2Echart11() {
    var myChart = echarts.init(document.getElementById('tab2Echart11'));
    var option = {
        toolbox:{
            show: true,
            feature: {
                dataView: { //数据视图
                    show: true
                }
            }
        },
        tooltip : {
            trigger: 'item',
            // formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            show:false,
            data: ['中华田园犬', '雪纳瑞','边境牧羊犬','哈士奇','博美']
        },
        series : [
            {
                type: 'pie',
                radius : '35%',
                center: ['50%', '30%'],
                selectedMode: 'single',
                data:model.districtData,
//                	[
//                    {
//                        value:2000,
//                        name: '城北区'
//                    },
//                    {value:535, name: '城西区'}
//                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            },
            {
                type: 'pie',
                radius : '35%',
                center: ['50%', '70%'],
                selectedMode: 'single',
                data:
//                	[
//                      {
//                          value:1548,
//                          name: '雄'
//                      },
//                      {value:535, name: '雌'}
//                  ],
                	model.sexData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
}
//初始化 犬只分类统计图(全市犬只品种分布)
function initTab2echart3() {
    var myChart = echarts.init(document.getElementById('tab2Echart3'));
    var option = {
        toolbox:{
            show: true,
            feature: {
                dataView: { //数据视图
                    show: true
                },
            }
        },
        tooltip : {
            trigger: 'item',
        },
        legend: {
            show:false,
            data: ['中华田园犬', '雪纳瑞','边境牧羊犬','哈士奇','博美']
        },
        series : [
            {
                type: 'pie',
                radius : '65%',
                center: ['50%', '50%'],
                selectedMode: 'single',
                data:model.breedData,
//                	[
//                    {
//                        value:1000,
//                        name: '中华田园犬'
//                    },
//                    {value:535, name: '边境牧羊犬'}
//                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
}

//初始化 tab2echart2(全市犬只犬龄分布)
function initTab2echart2() {
    var myChart = echarts.init(document.getElementById("tab2Echart2"));
    var option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x : 'center',
            y : 'bottom',
            data:['rose1','rose2','rose3','rose4','rose5','rose6','rose7','rose8']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['funnel', 'pie']
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                // name:'半径模式',
                type:'pie',
                radius : [20, 110],
                center : ['50%', '50%'],
                roseType : 'radius',
                lableLine: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:model.ageData,
//                	[
//                    {
//                        value:1000,
//                        name: '10岁'
//                    },
//                    {value:535, name: '20岁'}
//                ],
            }
        ]
    };
    myChart.setOption(option);
}

//轮播图2(全市犬只分布)
 function initlbt2() {
    //unslider
    $('#b07').unslider({
        speed: 1000,
        delay: 3000,
        autoplay: true,
        dots: true,
        loop:true,
        arrows:false,
        items: '>ul',   // 幻灯片的容器选择器
        item: '>li',    // 需要滚动的选择器
        easing: 'swing',// 动画的缓动函数(easing function)
        starting:function(){
            // alert("执行");
            var ul = $("#cul2");
            ul.children("li:first").insertAfter(ul.children("li:last"));
        }
    });
}

//轮播图(收容犬只分布)
function initlbt() {
    //unslider
    var unslider04 = $('#b06').unslider({
        speed: 1000,
        delay: 3000,
        autoplay: true,
        dots: true,
        loop:true,
        arrows:false,
        items: '>ul',   // 幻灯片的容器选择器
        item: '>li',    // 需要滚动的选择器
        easing: 'swing',// 动画的缓动函数(easing function)
        starting:function(){
            // alert("执行");
            var ul = $("#cul");
            ul.children("li:first").insertAfter(ul.children("li:last"));
        }
    }),
    data04 = unslider04.data('unslider');
    $('.unslider-arrow04').click(function() {
        var fn = this.className.split(' ')[1];
        data04[fn]();
    });


}


//create 违法次数div
function createDivNumberOfViolations(data1) {
    for(var i=0;i<data1.length;i++){
        var top =  40*(i+2);
        var buffer = new StringBuffer();
        buffer.append('<div class="" style="margin-top: 20px;margin-bottom: 15px">');
        buffer.append('<div id="NumberOf'+(i+1)+'" class="wftimes" style="margin-left: 20px;">'+(i+1)+'</div>');
        buffer.append('<div class="wftimes" style="width: 50px;margin-left: 25px">'+(data1[i].districtName)+'</div>');
        buffer.append('<div class="wftimes" style="margin-left: 198px;">'+(data1[i].illegalCounts)+'</div>');
        buffer.append('</div>');
        // buffer.append('<hr style="border: 1px dashed #0f0f0f;width: 92%;color:gray;size: 1px;position: absolute;top:'+top+'px;">');
        $(buffer.toString()).appendTo($("#bbb"));
    }
}
//初始化 犬只分类统计图(收容犬只品种分布)
function initCartogramEchart(collBreedData) {
    var myChart = echarts.init(document.getElementById('cartogramEcharts'));
    var option = {
        // title: {
        //     text: '天气情况统计',
        //     subtext: '虚构数据',
        //     left: 'center'
        // },
        toolbox:{
            show: true,
            feature: {
                dataView: { //数据视图
                    show: true
                }
            }
        },
        tooltip : {
            trigger: 'item',
            // formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            // orient: 'vertical',
            // top: 'middle',
            // bottom: 10,
            // left: 'center',
            show:false,
            data: ['中华田园犬', '雪纳瑞','边境牧羊犬','哈士奇','博美']
        },
        series : [
            {
                type: 'pie',
                radius : '65%',
                center: ['50%', '50%'],
                selectedMode: 'single',
                data:collBreedData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
}
//初始化echart3(收容犬只性别分布)
function initEchart3(collSexData) {
    var myChart = echarts.init(document.getElementById("echart3"));
    var option = {
            // title: {
            //     text: '天气情况统计',
            //     subtext: '虚构数据',
            //     left: 'center'
            // },
            toolbox:{
                show: true,
                feature: {
                    dataView: { //数据视图
                        show: true
                    }
                }
            },
            tooltip : {
                trigger: 'item',
                // formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                // orient: 'vertical',
                // top: 'middle',
                // bottom: 10,
                // left: 'center',
                show:false,
                data: ['中华田园犬', '雪纳瑞','边境牧羊犬','哈士奇','博美']
            },
            series : [
                {
                    type: 'pie',
                    radius : '65%',
                    center: ['50%', '50%'],
                    selectedMode: 'single',
                    data:collSexData,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
    myChart.setOption(option);
}
//初始化echart2（收容犬只类型分布）
function initEchart1(collTypeData) {
    var myChart = echarts.init(document.getElementById("echart1"));
    var option = {
        toolbox:{
            show: true,
            feature: {
                dataView: { //数据视图
                    show: true
                },
                // restore: { //重置
                //     show: true
                // },
                // dataZoom: { //数据缩放视图
                //     show: true
                // },
                // saveAsImage: {//保存图片
                //     show: true
                // },
                // magicType: {//动态类型切换
                //     type: ['bar', 'line']
                // }
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        },
        series: [
            {
                name:'访问来源',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:collTypeData,
//                data:[
//                    {
//                        value:1000,
//                        name: '10岁'
//                    },
//                    {value:535, name: '20岁'}
//                ],
            }
        ]
    };
    myChart.setOption(option);
}
//初始化违法次数趋势NumberOfViolationsEchart
function initNumberOfViolationsEchart(timeArray,countArry) {
    var myChart = echarts.init(document.getElementById("numberOfViolationsEchart"));
    var option = {
        tooltip : {
            trigger: 'axis',
        },
        xAxis: {
            type: 'category',
            data: timeArray
        },
        yAxis: {
            type: 'value',
            // splitNumber:300,
            // max:2000
        },
        series: [{
            data: countArry,
            type: 'line'
        }]
    };
    myChart.setOption(option);

}

//初始化全市犬只数量趋势 dogNumsEchart2(全市犬只)
function initDogNumsEchart2() {
    var myChart = echarts.init(document.getElementById("dogNumsEchart2"));
    var option = {
        tooltip : {
            trigger: 'axis',
        },
        xAxis: {
            type: 'category',
            data: model.timeArray
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: model.countArry,
            type: 'line'
        }]
    };
    myChart.setOption(option);
}


//初始化犬只数量趋势图 dogNumsEchart*(收容犬只)
function initDogNumsEchart(collTimeArray,collCountArray) {
    var myChart = echarts.init(document.getElementById("dogNumsEchart"));
    var option = {
        tooltip : {
            trigger: 'axis',
        },
        xAxis: {
            type: 'category',
            data: collTimeArray
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data:collCountArray,
            type: 'line'
        }]
    };
    myChart.setOption(option);
}
