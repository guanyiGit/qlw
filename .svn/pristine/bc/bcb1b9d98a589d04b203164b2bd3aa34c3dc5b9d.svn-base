var model={
	formatDate: function(date) {
        var datetime = new Date(date);
        var year = datetime.getFullYear();
        var month = (datetime.getMonth() + 1) < 10 ? ("0" + (datetime.getMonth() + 1)) : (datetime.getMonth() + 1);
        var day = datetime.getDate() < 10 ? ("0" + datetime.getDate()) : (datetime.getDate());
        var hours = datetime.getHours() < 10 ? ("0" + datetime.getHours()) : (datetime.getHours());
        var min = datetime.getMinutes() < 10 ? ("0" + datetime.getMinutes()) : (datetime.getMinutes());
        // return year + "-" + month + "-" + day + " " + hours + ":" + min;
        return year + "-" + month + "-" + day;
    },
	deviceData:null,
	timeArray:null,
	countArray:null
}

$(function () {
	$(".jrzxdivdiv3").empty();
	//1.今日在线人数
	findTodayOnlineCounts();
	//2.今日信息发布条数
	findTodayInformationCount();
	//3.设备使用情况
	findDeviceList();
	//4.用户在线趋势
	findStatisticLogUserTendency();
    //初始化用户在线趋势 yhzxEchart
    //initYhzxEchart();
    //初始化设备在线趋势 deviceOnlineEchart
    //initDeviceOnlineEchart();
    //5.查看信息列表
    getInformations();
    //初始化信息发布列表
    //createDivMyMessage();
    //初始化 设备使用情况sbsydetail
    //initSbsydetail();
});
//1#今日在线人数
function findTodayOnlineCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findTodayOnlineCounts",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		$("#onlineCount").append(result);
        	}
        }
 })
}
//2#今日信息发布条数
function findTodayInformationCount(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findTodayInformationCount",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		$("#msg").append(result);
        	}
        }
 })
}
//3#设备使用情况
function findDeviceList(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findDeviceList",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		//model.deviceData=result;
        		initSbsydetail(result);
            }
        }
 })
}
//4#用户在线趋势
function findStatisticLogUserTendency(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findStatisticLogUserTendency",
        dataType: "json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		var timeArray=[];
        		var countArray=[];
        		for(var i=0;i<result.length;i++)
        		{
        			var date=result[i].date;
        			timeArray.push(date);
        			var logCounts=result[i].logCounts;
        			countArray.push(logCounts);
        		}
//        		model.timeArray=timeArray;
//        		model.countArray=countArray;
        		initYhzxEchart(timeArray,countArray)
        	}
        }
 })
}


//5.查看信息列表
function getInformations(){
	$.ajax({
        type: "get",
        url: "/biz/information/getInformations",
        data:{TypeNumber:null,status:0,pageNum:1,pageSize:10,query:null},
        success: function (result) 
        {
        	if(result.status==400){
        		alert("服务器异常!");
        	}
        	else{
        		var info=result.data.list;
        		if(info !=null && info !=""){
        			createDivMyMessage(info);
        		}
        		
        	}
        	
        }
 })
}
//初始化 设备使用情况sbsydetail
function initSbsydetail(deviceData) {
    var myChart = echarts.init(document.getElementById('sbsydetail'));
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
        series : [
            {
                type: 'pie',
                radius : '50%',
                center: ['50%', '50%'],
                selectedMode: 'single',
                data:deviceData,
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
//create 我的消息
function createDivMyMessage(info) {
    for(var i=0;i<info.length;i++){
        var top = 80;
        switch ((i+1)) {
            case 1:top=80;break;case 2:top=123;break;case 3:top=165;break;case 4:top=209;break;
            case 5:top=252;break;case 6:top=295;break;case 7:top=337;break;case 8:top=379;break;
            case 9:top=425;break;
        }
        var buffer = new StringBuffer();
        if(i==0){
            buffer.append('<div style="margin-top: 69px;margin-bottom: 15px">');
        }else {
            buffer.append('<div style="margin-top: 20px;margin-bottom: 15px">');
        }
        buffer.append("<span class='myMessageSpanLeft'>"+info[i].pubishOrg+"发布了一条新的信息，请及时审核！</span>");
        buffer.append("<span class='myMessageSpanRight'>"+model.formatDate(info[i].updateTime)
+"</span>");
        buffer.append('</div>');
        if(i!=9){
            buffer.append('<hr style="border: 1px dashed #0f0f0f;width: 84%;left:39px;position: absolute;top:'+top+'px;">');
        }
        $(buffer.toString()).appendTo($(myMessage));
    }
}


//初始化用户在线趋势 yhzxEchart
function initYhzxEchart(timeArray,countArray) {
    var myChart = echarts.init(document.getElementById("yhzxEchart"));

    var  option = {
        // Make gradient line here
        visualMap: [{
            show: false,
            type: 'continuous',
            seriesIndex: 0,
            min: 0,
            max: 400
        }],
        tooltip: {
            trigger: 'axis'
        },
        xAxis: [{
            data: timeArray
        }],
        yAxis: [{
            splitLine: {show: false}
        }],
        // grid: [{
        //     bottom: '60%'
        // }, {
        //     top: '60%'
        // }],
        series: [{
            type: 'line',
            showSymbol: false,
            data: countArray,
            itemStyle : {
				normal : {
					lineStyle:{
						color:'red'
					}
				}
			}
        }]
    };

    myChart.setOption(option);

}
//初始化设备在线趋势 deviceOnlineEchart
function initDeviceOnlineEchart() {
    var myChart = echarts.init(document.getElementById("deviceOnlineEchart"));
    var  data = [["2000-06-05",116],["2000-06-06",129],["2000-06-07",135],["2000-06-08",86],["2000-06-09",73],["2000-06-10",85],["2000-06-11",73],["2000-06-12",68],["2000-06-13",92],["2000-06-14",130],["2000-06-15",245],["2000-06-16",139],["2000-06-17",115],["2000-06-18",111],["2000-06-19",309],["2000-06-20",206],["2000-06-21",137],["2000-06-22",128],["2000-06-23",85],["2000-06-24",94],["2000-06-25",71],["2000-06-26",106],["2000-06-27",84],["2000-06-28",93],["2000-06-29",85],["2000-06-30",73],["2000-07-01",83],["2000-07-02",125],["2000-07-03",107],["2000-07-04",82],["2000-07-05",44],["2000-07-06",72],["2000-07-07",106],["2000-07-08",107],["2000-07-09",66],["2000-07-10",91],["2000-07-11",92],["2000-07-12",113],["2000-07-13",107],["2000-07-14",131],["2000-07-15",111],["2000-07-16",64],["2000-07-17",69],["2000-07-18",88],["2000-07-19",77],["2000-07-20",83],["2000-07-21",111],["2000-07-22",57],["2000-07-23",55],["2000-07-24",60]];

    var dateList = data.map(function (item) {
        return item[0];
    });
    var valueList = data.map(function (item) {
        return item[1];
    });

   var  option = {
        // Make gradient line here
        visualMap: [{
            show: false,
            type: 'continuous',
            seriesIndex: 0,
            min: 0,
            max: 400
        }],
        tooltip: {
            trigger: 'axis'
        },
        xAxis: [{
            data: dateList
        }],
        yAxis: [{
            splitLine: {show: false}
        }],
        // grid: [ {
        //     top: '10%'
        // }],
        series: [{
            // center: ['50%', '50%'],
            type: 'line',
            showSymbol: false,
            data: valueList
        }]
    };
    myChart.setOption(option);
}
