var model1={
	sexData:null,
	districtData:null
}

$(function () {
	alert(1);
	debugger
	//1.统计昨日新增/注销犬只/违法次数
	findYesterDayDogMsg();
	//2.犬只品种分布
	findDogBreedsCounts();
	//3.犬龄分布
	findDogAgeCounts();
	//4.区域分布
	findDogCountsByDistrict();
	//5.性别分布
	findDogGenderCounts();
	//6.统计犬只、犬主、服务网点
	findDogDogOwnerSite();
	//7.上月违法次数
	findLastMonthDogIllegalCounts();
	
	//8.每月犬只新增数量趋势
	findDogCountsTendency();

	//9.违法趋势
	findDogIllegalCountsTendency();
    //轮播图2
    initlbt2();
    
    //初始化initTab2Echart11
    initTab2Echart11();

    //初始化犬只数量趋势图 dogNumsEchart
    //initDogNumsEchart();
    //初始化违法次数趋势NumberOfViolationsEchart
    //initNumberOfViolationsEchart();
    // initTable.initNumberofviolationsTable();
    

});
function onchangeCount(){
	findDogCountsTendency();
}

function onchangeIllegalCount(){
	findDogIllegalCountsTendency();
}

//统计昨日新增/注销犬只/违法次数
function findYesterDayDogMsg(){
	 $.ajax({
	        type: "get",
	        url: "/biz/statistic/findYesterDayDogMsg",
	        dataType: "json",
	        success: function (result) 
	        {
	        	var result=result.data;
	        	if(result !=null && result !=""){
	        		$(".headdivspan").empty();
	        		$("#yesAdd").append(result.yesterdayAddDog);
	        		$("#yesCancel").append(result.yesterdayCancelDog);
	        		$("#yesIllegal").append(result.yesterdayIllegalCounts);
	        	}
	        }
	 })
}

//统计犬只品种分布
function findDogBreedsCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogBreedsCounts",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		var breedData=result;
        		initTab2echart3(breedData);
        	}
        }
 })
}

//犬龄分布
function findDogAgeCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogAgeCounts",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		var ageData=result;
        		initTab2echart2(ageData);
        	}
        }
 })
}

//犬只区域分布
function findDogCountsByDistrict(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogCountsByDistrict",
        async: false,
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		model1.districtData=result;
        	}
        }
 })
}


//犬只性别分布
function findDogGenderCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogGenderCounts",
        async: false,
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		model1.sexData=result;
        	}
        }
 })
}

//统计犬只、犬主、服务网点
function findDogDogOwnerSite(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogOwnerAndSite",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		$(".child").empty();
        		$("#dogOwner").append(result.dogOwner);
        		$("#site").append(result.serveSite);
        		$("#dog").append(result.dog);
        	}
        }
 })
}

//上月违法次数
function findLastMonthDogIllegalCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogIllegalCountsTendency",
        data:{count:1},
        dataType:"json",
        success: function (result) 
        {
        	if(result !=null &&result !=""){
        		var data1=result.illegalCountsTendency;
        		var data2=result.totalIllegalCountsTendency;
        		$("#totalIllegal").empty();
        		if(data2.length > 0){
        			$("#totalIllegal").append(data2[0].illegalCounts);
        		}
        		createDivNumberOfViolations(data1);
        	}
        }
 })
}

//每月犬只新增数量趋势
function findDogCountsTendency(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogCountsTendency",
        data:{count:$("#yearCount").val()},
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
        		initDogNumsEchart(timeArray,countArry);
        	}
        }
 })
}
//每月犬只违法数量趋势
function findDogIllegalCountsTendency(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDogIllegalCountsTendency",
        data:{count:$("#yearIllegalCount").val()},
        async: false,
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
//轮播图2
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

//初始化 犬只分类统计图(品种分布)
function initTab2echart3(breedData) {
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
            data: ['一', '二','三','四','五']
        },
        series : [
            {
                type: 'pie',
                radius : '65%',
                center: ['50%', '50%'],
                selectedMode: 'single',
                data:breedData
//                	[
//                    {
//                        value:1548,
//                        name: '中华田园犬'
//                    },
//                    {value:535, name: '哈士奇'},
//                    {value:510, name: '雪纳瑞'},
//                    {value:634, name: '边境牧羊犬'},
//                    {value:735, name: '博美'}
//                ]
            ,
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
//初始化 tab2echart2(犬龄分布)
function initTab2echart2(ageData) {
    var myChart = echarts.init(document.getElementById("tab2Echart2"));
    var option = {
        // title : {
        // text: '南丁格尔玫瑰图',
        // subtext: '纯属虚构',
        // x:'center'
        // },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
//        legend: {
//            x : 'center',
//            y : 'bottom',
//            data:['rose1','rose2','rose3','rose4','rose5','rose6','rose7','rose8']
//        },
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
                data:ageData
//                	[
//                    {value:10, name:'rose1'},
//                    {value:5, name:'rose2'},
//                    {value:15, name:'rose3'},
//                    {value:25, name:'rose4'},
//                    {value:20, name:'rose5'},
//                    {value:35, name:'rose6'},
//                    {value:30, name:'rose7'},
//                    {value:40, name:'rose8'}
//                ]
            }
        ]
    };
    myChart.setOption(option);
}
//初始化initTab2Echart11(区域分布,性别分布)
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
                data:model1.districtData,
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
                data:model1.sexData,
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
        $(buffer.toString()).appendTo($(bbb));
    }
}
//初始化违法次数趋势NumberOfViolationsEchart(待完善)
function initNumberOfViolationsEchart(timeArray,countArry) {
    var myChart = echarts.init(document.getElementById("numberOfViolationsEchart"));
    var option = {
        tooltip : {
            trigger: 'axis',
        },
        xAxis: {
            type: 'category',
            data: timeArray
            	//['2017.6', '2017.8', '2017.9', '2017.10', '2017.11', '2017.12', '2018.1']
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
//初始化犬只数量趋势图 dogNumsEchart
function initDogNumsEchart(timeArray,countArry) {
    var myChart = echarts.init(document.getElementById("dogNumsEchart"));
    var option = {
        tooltip : {
            trigger: 'axis',
        },
        xAxis: {
            type: 'category',
            data: timeArray
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: countArry,
            type: 'line'
        }]
    };
    myChart.setOption(option);

}
//初始化 犬只分类统计图
function initCartogramEchart() {
    var myChart = echarts.init(document.getElementById('cartogramEcharts'));
    // var weatherIcons = {
    //     'Sunny': './data/asset/img/weather/sunny_128.png',
    //     'Cloudy': './data/asset/img/weather/cloudy_128.png',
    //     'Showers': './data/asset/img/weather/showers_128.png'
    // };
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
                data:[
                    {
                        value:1548,
                        name: '中华田园犬'
                    },
                    {value:535, name: '哈士奇'},
                    {value:510, name: '雪纳瑞'},
                    {value:634, name: '边境牧羊犬'},
                    {value:735, name: '博美'}
                ],
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