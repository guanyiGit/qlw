var model={
		vaccineData:null,
		orgId:null,
		timeArray:null,
		countArray:null
}

$(function () {
	$(".jrzxdivdiv3").empty();//清空默认值
	//获取登录用户相关信息
	model.orgId=JSON.parse(sessionStorage.getItem("user")).organizationId;
	//1.今日预约
	findAppointmentMsg();
	//2.昨日看病,办证,免疫,年检
	findHospitalYesterdayCount();
	//3.上月疫苗使用情况
	findLastMonthVaccine();
	//4.客户增长趋势
	findCustomerCounts();
    //初始化用户在线趋势 yhzxEchart
    //initKhzzEchart();
    //初始化 疫苗使用情况图标 vaccinumDetailEchart
    //initVaccinumDetailEchart();
    //初始化日历
    initMyCalendar();
});
//1#今日预约
function findAppointmentMsg(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findAppointmentMsg",
        data:{orgId:model.orgId},
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		for(var i=0;i<result.length;i++){
        			if(result[i].biz_type==0){//0看病
        				$("#preTreat").append(result[i].appointmentCount);
        			}
        			if(result[i].biz_type==1){//1办证
        				$("#preDoCard").append(result[i].appointmentCount);
        			}
        			if(result[i].biz_type==2){//2年检
        				$("#preCheck").append(result[i].appointmentCount);
        			}
        			if(result[i].biz_type==3){	//3免疫
        				$("#preImmune").append(result[i].appointmentCount);
        			}
        		}
        	}
        }
 })
}
//2#昨日看病,办证,免疫,年检
function findHospitalYesterdayCount(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findHospitalYesterdayCount",
        data:{orgId:model.orgId},
        dataType:"json",
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		$("#yesTreat").append(result.yesterdayTherapy);
        		$("#yesYearCheck").append(result.yesterdayInspection);
        		$("#yesImmune").append(result.yesterdayImmune);
        		$("#yesCard").append(result.yesterdayCard);
        	}
        	else{
        		alert("统计昨日看病,办证,免疫,年检失败");
        	}
        }
 })
}
//3#上月疫苗使用情况
function findLastMonthVaccine(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findLastMonthVaccine",
        dataType:"json",
        data:{orgId:model.orgId},
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		//model.vaccineData=result;
        		initVaccinumDetailEchart(result)
        	}
        	else{
        		alert("统计上月疫苗使用情况失败");
        	}
        }
 })
}
//4#客户增长趋势(待完善)
function findCustomerCounts(){
	$.ajax({
        type: "get",
        url: "/biz/statistic/findCustomerCounts",
        dataType:"json",
        data:{orgId:model.orgId,count:6},
        success: function (result) 
        {
        	var result=result.data;
        	if(result !=null && result !=""){
        		
        		var data=result;
        		var timeArray=[];
        		var countArray=[];
        		for(var i=0;i<data.length;i++){
        			var creationTime=data[i].creation_time;
        			timeArray.push(creationTime);
        			var dogCounts=data[i].customerCount;
        			countArray.push(dogCounts);
        		}
//        		model.timeArray=timeArray;
//        		model.countArray=countArray;
        		initKhzzEchart(timeArray,countArray);
        	}
        	else{
        		alert("统计客户增长趋势失败");
        	}
        }
 })
}
//初始化日历
function initMyCalendar() {
    $('#Mycalendar').datetimepicker({
        format: 'yyyymmdd',
        weekStart: 1,
        autoclose: true,
        startView: 2,
        minView: 2,
        forceParse: false,
        language: 'zh-CN',
        todayBtn:true,
        bootcssVer:3
    });
}

//初始化 疫苗使用情况图标 vaccinumDetailEchart
function initVaccinumDetailEchart(vaccineData) {
    var myChart = echarts.init(document.getElementById('vaccinumDetailEchart'));
    var option = {
        toolbox:{
            show: true,
            feature: {
                dataView: { //数据视图
                    show: true,
                }
            },
            right:"20px"
        },
        tooltip : {
            trigger: 'item',
            // formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series : [
            {
                type: 'pie',
                radius : '80%',
                center: ['50%', '50%'],
                selectedMode: 'single',
                data:vaccineData,
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

//初始化客户增长趋势 khzzEchart
function initKhzzEchart(timeArray,countArray) {
    var myChart = echarts.init(document.getElementById("khzzEchart"));
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
            // center: ['50%', '10%'],
            data: countArray,
            type: 'line'
        }]
    };
    myChart.setOption(option);
}

