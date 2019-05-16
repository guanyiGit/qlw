var models={
			violationList:null,//违法记录
			inspectionsInfoList:null,//年检记录
			vaccineList:null//防疫记录
}

$(function () {
    //取犬id
	var dogId=window.sessionStorage.getItem("dogId");
	var data={
			dogId:10101570,
			cardNum:null
	}
    selectDetail(data);
	
	 //初始化防疫信息
    dogTable.initAntiepidemicMessageTable();
    //初始化年检table
    dogTable.initAnnualSurveyTable();
    //初始化违法table
    dogTable.initIllegalInformationTable();

});


//初始化table
var dogTable = {
    //防疫信息table
    initAntiepidemicMessageTable:function(){
        $("#antiepidemicMessageTable").bootstrapTable({
            // url: '/Home/GetDepartment',         //请求后台的URL（*）
            // method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            // queryParams: oTableInit.queryParams,//传递参数（*）
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: false,                //是否启用点击选中行
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            columns: [{
                field: 'injectionTime',
                title: '免疫日期',
                align:"center",
                valign:"middle",
                formatter:function (value) {
                    return timeStamp2String(value);
                }
            }, {
                field: 'injectionType',
                title: '免疫项目',
                align:"center",
                valign:"middle"
            }, {
                field: 'vaccineName',
                title: '疫苗名称',
                align:"center",
                valign:"middle"
            }, {
                field: 'vaccineProducer',
                title: '疫苗厂家',
            	align:"center",
                valign:"middle"
            }, {
                field: 'vaccineNum',
                title: '疫苗批号',
                align:"center",
                valign:"middle"
            }, {
                field: 'name',
                title: '接种兽医',
                align:"center",
                valign:"middle"
            }, {
                field: 'orgName',
                title: '接种单位',
                align:"center",
                valign:"middle"
            }],
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
            data:models.vaccineList
        });
    },
    //年检信息table
    initAnnualSurveyTable:function () {
        $("#annualSurveyTable").bootstrapTable({
            // url: '/Home/GetDepartment',         //请求后台的URL（*）
            // method: 'get',                      //请求方式（*）
            // toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            // pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: false,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            columns: [{
                field: 'inspectionsDate',
                title: '年检日期',
            	align:"center",
                valign:"middle",
	        	  formatter:function (value) {
	                  return timeStamp2String(value);
	              }
            }, {
                field: 'orgName',
                title: '年检单位',
                align:"center",
                valign:"middle"
            }, {
                field: 'resultType',
                title: '年检结果',
                align:"center",
                valign:"middle"
            }, {
                field: 'remarks',
                title: '备注',
                align:"center",
                valign:"middle"
            }],
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
            data:models.inspectionsInfoList
        });
    },
    
    //初始化illegalInformationTable
    initIllegalInformationTable:function () {
        $("#illegalInformationTable").bootstrapTable({
            // url: '/Home/GetDepartment',         //请求后台的URL（*）
            // method: 'get',                      //请求方式（*）
            striped: false,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: false,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            columns: [{
                field: 'violationDate',
                title: '违法时间',
                align:"center",
                valign:"middle",
                formatter:function (value) {
                    return timeStamp2String(value);
                }
            }, {
                field: 'violation',
                title: '违法类型',
                align:"center",
                valign:"middle"
            }, {
                field: 'remarks',
                title: '违法行为',
                align:"center",
                valign:"middle"
            }, {
                field: 'violationPlace',
                title: '违法地点',
                align:"center",
                valign:"middle"
            },  {
                field: 'fine',
                title: '扣分(分)',
                align:"center",
                valign:"middle"
            }, {
                field: 'punishType',
                title: '是否收容',
                align:"center",
                valign:"middle"
            },
            {
                field: 'operatorName',
                title: '执法人员',
                align:"center",
                valign:"middle"
            }, {
                field: 'remarks',
                title: '备注',
                align:"center",
                valign:"middle"
            }],
            formatNoMatches: function(){
                return "没有相关的匹配结果";
            },
            formatLoadingMessage: function(){
                // return "请稍等，正在加载中。。。";
                return "";
            },
            data:models.violationList
        });
    }   
};

//查询犬只详情
function selectDetail(data){
    $.ajax({
        type:"get",
        url:"/biz/dogCard/selectDogCardInfo",
        data:data,
        dataType:"json",
        async:false,
        success:function (res) {
        	console.log(res);
        	var result=res.result;
        	models.violationList=result.violationList;//违法记录
        	models.inspectionsInfoList=result.inspectionsInfoList;//年检记录
        	models.vaccineList=result.vaccineList;//防疫记录
            var dogInfo=result.dogInfo;//犬的信息
            var immuneCard=result.immuneCard;//免疫证
            var dogCard=result.dogCard;//犬证
            var device=result.device;//设备
            var dogOwners=result.dogOwners;//犬主
            /*犬只信息*/
            $("#qm").val(dogInfo.dogName);//犬名
            $("#pz").val(dogInfo.breed);//品种
            $("#xb").val((dogInfo.dogGender==0)?"雄":"雌");//性别
            $("#ql").val(dogInfo.dogAge);//犬龄
            $("#csrq").val(timeStamp2String(dogInfo.birthTime));//出生日期
            $("#ms").val(dogInfo.color);//毛色
            $("#fb").val(dogInfo.fatherId);//父本
            $("#mb").val(dogInfo.motherId);//母本
            $("#pic").val(dogInfo);//图片
            /*免疫证件信息*/
            $("#myzh").val(immuneCard.immuneCardNum);//免疫证号
            $("#qfjg1").val(immuneCard.orgName);//免疫证签发机构
            $("#qfrq1").val(timeStamp2String(immuneCard.lssueTime));//免疫证签发日期
            $("#Syxqx1").val(timeStamp2String(immuneCard.startTime));//免疫证开始日期
            $("#Eyxqx1").val(timeStamp2String(immuneCard.endTime));//免疫证结束日期
            /*犬证信息*/
            $("#qzhm").val(dogCard.dogCardNum);//犬证号码
            $("#qfjg2").val(dogCard.orgName);//犬证签发机构
            $("#qfrq2").val(timeStamp2String(dogCard.lssueTime));//犬证签发日期
            $("#Syxqx2").val(timeStamp2String(dogCard.startTime));//犬证开始日期
            $("#Eyxqx2").val(timeStamp2String(dogCard.endTime));//犬证结束日期
            /*项圈信息*/
            $("#xqbh").val(device.deviceNumber);//项圈编号
            $("#qfjg3").val(device.orgName);//项圈签发机构
            $("#qfrq3").val(timeStamp2String(device.productionTime));//项圈签发日期
            $("#Syxqx3").val(timeStamp2String(device.startTime));//项圈开始日期
            $("#Eyxqx3").val(timeStamp2String(device.endTime));//项圈结束日期
            /*犬主信息*/
            $("#qzxm").val(dogOwners.dogOwnerName);//犬主姓名
            $("#xz").val((dogOwners.dogOwnerType==1)?"企业":"个人");//性质
            var cardType;
            if(dogOwners.cardType==0){
            	cardType="身份证";
            }else if(dogOwners.cardType==1){
            	cardType="房产证";
            }else if(dogOwners.cardType==2){
            	cardType="营业执照";
            }else{
            	cardType="其他";
            }
            $("#zjlx").val(cardType);//证件类型
            $("#zjhm").val(dogOwners.cardNum);//证件号码
            $("#qzxb").val((dogOwners.sex==0)?"男":"女");//性别
            $("#qzqsrq").val(timeStamp2String(dogOwners.birthDate));//出生日期
            $("#xzxq").val(dogOwners.districtName);//现住区县
            $("#ssbm").val(dogOwners.orgName);//所属部门
            $("#sssq").val(dogOwners.community);//所属社区
            $("#yb").val(dogOwners.postalCode);//邮编
            $("#dh").val(dogOwners.dogOwnerPhone);//联系电话
            $("#dz").val(dogOwners.address);//信息地址
        }
    })
}
