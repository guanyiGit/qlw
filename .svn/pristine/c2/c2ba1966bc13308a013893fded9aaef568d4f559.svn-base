

$(function () {
    //初始化服务网点table serviceNetworkTable
    initServiceNetworkTable();


});

//删除多余的行
function removeRows(num,pageSize) {
    var trs = $("#serviceNetworkTable").find("tr");
    for(var index in trs){
        var item = trs[index];
        if(dataindex==(pageSize-1)){
            return;
        }
        if(item.attributes.length>0){
            var dataindex = item.attributes[0].value;
            if(dataindex>=num){
                item.style.display='none';
            }
        }else {
            continue;
        }
    }
}

//初始化服务网点table serviceNetworkTable
function initServiceNetworkTable() {
    $("#serviceNetworkTable").bootstrapTable({
        // url: 'combobox',         //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        // toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: false,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        pagination:true,
        pageNumber:1,
        pageList:[10,15,20],
        clickToSelect: true,                //是否启用点击选中行
        showHeader:false,
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        columns: [{
            field: 'ParentName',
            formatter:function (value,row,index) {
                var data = $("#serviceNetworkTable").bootstrapTable('getData','useCurrentPage');
                var n = Math.ceil(index/2);
                var pre =  2*index;
                if(pre<data.length){
                    row = data[pre];
                    // return row.ParentName;
                }else {
                    // return ;
                }
                //拼串串

                var buffer = new StringBuffer();
                buffer.append('<div  class="row hhh" style="text-align: center">');
                buffer.append('<div class="col-sm-4 " style="top: 14px  ">');
                buffer.append('<img src="../../images/2.png">');
                buffer.append('</div>');
                buffer.append('<div class="col-sm-6" style="height: 100%;line-height: 40px" >');
                buffer.append('<table style="width: 170px;height: 60px;line-height: 28px">');
                buffer.append('<tr align="left">');
                buffer.append('<td colspan="1" align="left"><span style="left: 0px"><B>西宁市瑞鹏宠物医院</B></span><span style="position: absolute;right:-42px"><a href="#" style="color: red">预约</a></span></td>');
                // buffer.append('<td colspan="8" style="color: rgb(255, 153, 102)">犬证过期</td>');
                // buffer.append('<td colspan="8"><font color="#f65">年检超期</font></td>');
                buffer.append('</tr>');
                buffer.append('<tr align="left">');
                buffer.append('<td colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">电话：13800138000</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">男</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">品种:</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">金毛</td>');
                buffer.append('</tr>');
                buffer.append('<tr align="left">');
                buffer.append('<td colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);"><font size="2">地址:青海省西宁市城东区青藏铁路花园北门向西200米</font></td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">6个月</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">毛色:</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">黑白</td>');
                buffer.append('</tr>');
                // buffer.append('<tr align="left">');
                // buffer.append('<td colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">abc:</td>');
                // buffer.append('</tr>');
                buffer.append('</table>');
                buffer.append('</div>');
                buffer.append('</div>');
                return buffer.toString();
            }
        }, {
            field: 'ParentName',
            // width:80,
            formatter:function (value,row,index) {
                var data = $("#serviceNetworkTable").bootstrapTable('getData','useCurrentPage');
                // var n = Math.floor(index/2);
                var next =  2*index+1;
                if(next<data.length){
                    row = data[next];
                    // return row.ParentName;
                }else {
                    // return  ;
                }
                //拼串串

                var buffer = new StringBuffer();
                buffer.append('<div  class="row hhh" style="text-align: center">');
                buffer.append('<div class="col-sm-4 " style="top: 14px  ">');
                buffer.append('<img src="../../images/2.png">');
                buffer.append('</div>');
                buffer.append('<div class="col-sm-6" style="height: 100%;line-height: 40px" >');
                buffer.append('<table style="width: 170px;height: 60px;line-height: 28px">');
                buffer.append('<tr align="left">');
                buffer.append('<td colspan="1" align="left"><span style="left: 0px"><B>西宁市瑞鹏宠物医院</B></span><span style="position: absolute;right:-42px"><a href="#" style="color: red">预约</a></span></td>');
                // buffer.append('<td colspan="8" style="color: rgb(255, 153, 102)">犬证过期</td>');
                // buffer.append('<td colspan="8"><font color="#f65">年检超期</font></td>');
                buffer.append('</tr>');
                buffer.append('<tr align="left">');
                buffer.append('<td colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">电话：13800138000</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">男</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">品种:</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">金毛</td>');
                buffer.append('</tr>');
                buffer.append('<tr align="left">');
                buffer.append('<td colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);"><font size="2">地址:青海省西宁市城东区青藏铁路花园北门向西200米</font></td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">6个月</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">毛色:</td>');
                // buffer.append('<td colspan="6" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">黑白</td>');
                buffer.append('</tr>');
                // buffer.append('<tr align="left">');
                // buffer.append('<td colspan="1" style="font-family: 微软雅黑; color: rgb(153, 153, 153);">abc:</td>');
                // buffer.append('</tr>');
                buffer.append('</table>');
                buffer.append('</div>');
                buffer.append('</div>');
                return buffer.toString();
            }
        }],
        onLoadSuccess:function(data){
            debugger
            var options = $("#serviceNetworkTable").bootstrapTable('getOptions');
            var pageSize = options.pageSize;
            var num = Math.ceil(pageSize/2);
            removeRows(num,pageSize);
        },
        onPageChange:function () {
            var options = $("#serviceNetworkTable").bootstrapTable('getOptions');
            var pageSize = options.pageSize;
            var num = Math.ceil(pageSize/2);
            removeRows(num,pageSize);
        },

        formatNoMatches: function(){
            return "没有相关的匹配结果";
        },
        formatLoadingMessage: function(){
            // return "请稍等，正在加载中。。。";
            return "";
        },
        data:[{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'},{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'},{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'}
            ,{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'},{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'},{'Name':'abc','ParentName':'132134656','Level':'2018/8/6'}]
    });
}
