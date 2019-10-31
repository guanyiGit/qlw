
var selectParmas={
	breed:null,
	gender:null,
	startAge:null,
	endAge:null,
	color:null
}

$(function () {
	//初始化种类
	InitBreed();
	//初始化颜色 
	InitColor();
    //图片分页显示
    picturePage(null);
    
    //品种搜索
    $("#breedSelect").change(function(){
    	var breed=$("#breedSelect option:selected").val();
    	if(breed==-1){
    		selectParmas.breed=null;
    	}else{
    		selectParmas.breed=breed;
    	}
    	picturePage(JSON.stringify(selectParmas));
    });
    //性别搜索
    $("#sexSelect").change(function(){
    	var gender=$("#sexSelect option:selected").val();
    	if(gender==-1){
    		selectParmas.gender=null;
    	}else{
    		selectParmas.gender=gender;
    	}
    	picturePage(JSON.stringify(selectParmas));
    });
    //犬龄搜索
    $("#dogAgeSelect").change(function(){
    	var age=$("#dogAgeSelect option:selected").val();
    	if(age==0){
    		selectParmas.startAge=null;
    		selectParmas.endAge=null;
    	}else if(age==1){
    		selectParmas.startAge=null;
    		selectParmas.endAge=3;
    	}else if(age==2){
    		selectParmas.startAge=3;
    		selectParmas.endAge=8;
    	}else if(age==3){
    		selectParmas.startAge=8;
    		selectParmas.endAge=12;
    	}else{
    		selectParmas.startAge=12;
    		selectParmas.endAge=null;
    	}
    	 picturePage(JSON.stringify(selectParmas));
    });
    //毛色搜索
    $("#colorSelect").change(function(){
    	var color=$("#colorSelect option:selected").val();
    	if(color==-1){
    		selectParmas.color=null;
    	}else{
    		selectParmas.color=color;
    	}
    	picturePage(JSON.stringify(selectParmas));
    });
    
    var dogtotal=window.sessionStorage.getItem("dogtotal");
    if(dogtotal!=null && dogtotal!=undefined){
    	$("#total").text(dogtotal);
    }
});

function picturePage(string) {
    $('#imggrid').imgGrid({
        // title: '图片集',
        type: 'GET',//GET|POST
       //data:data,//本地数据
         url: '/biz/collection/findAdoptionsList',//ajax URL
        params:{page:this.page,rows:20,string:string},
        pageselect: [10,15],
        // height:"1230px",
        height:"auto",
        // width: '850px',
        img: { width: '240px', animate: 'zoomIn' },//图片宽度，及动画效果
         onClick: function (obj, index, item) {//点击图片事件
            $("#home").load("views/dog/adoptionApplication.html");
            window.sessionStorage.setItem("collectionId", item.collectionId);
            window.sessionStorage.setItem("adoptionPublicityId", item.adoptionPublicityId);
         },
        render: function (item, index) {//自定义显示图片
            var buffer = new StringBuffer();
            buffer.append('<img src="'+item.thumbnailUrl+'">');
            buffer.append('<div><table style="table-layout: fixed;width: 100%;">' +
				'<tr align="left">' +
				'<td><label style="font-size: 14px">姓名:</label><label style="font-size: 16px">'+item.dogName+'</label></td>' +
				'<td><label style="font-size: 14px">品种:</label><label style="font-size: 16px">'+item.dogBreed+'</label></td></tr>' +
				'<tr align="left">' +
                '<td><label style="font-size: 14px">毛色:</label><label style="font-size: 16px">'+item.dogColor+'</label></td>' +
                '<td><label style="font-size: 14px">性别:</label><label style="font-size: 16px">'+((item.dogGender==0)?"雄":"雌")+'</label></td></tr>' +
				'</table></div>');
            return buffer.toString();
        }
    });
};
    
  
   
   //初始化品种
   function InitBreed(){
	   $.ajax({
	        type:"get",
	        url:"/biz/adoption/selectdogPro",
	        data:{logg:1},
	        dataType:"json",
	        success:function (res) {
	        		if(res.length!=0){
	        			for(var i=0;i<res.length;i++){
	        				var option=$('<option></option>');
	        				option.val(res[i].value);
	        				option.text(res[i].name);
	        				$("#breedSelect").append(option);
	        			}
	        		}
	        }
	    })
   }
   
   //初始化毛色
   function InitColor(){
	   $.ajax({
		   type:"get",
		   url:"/biz/adoption/selectdogPro",
		   data:{logg:2},
		   dataType:"json",
		   success:function (res) {
			   if(res.length!=0){
				   for(var i=0;i<res.length;i++){
					   var option=$('<option></option>');
					   option.val(res[i].value);
					   option.text(res[i].name);
					   $("#colorSelect").append(option);
				   }
			   }
		   }
	   })
   }
   
   
   
   
