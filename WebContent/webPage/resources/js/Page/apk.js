 
/**
 * 功能说明：打包新的apk。
 */

var basePath = $("#basePath").attr("href");
var action="CreatAPK"; 

$(function(){  
	$("#progressbar" ).progressbar({ value: total });
	
	$("#a_edit").click(function(){ 
		interval =window.setInterval('add()',210); 
		Page.ajaxclick();
		return false;
	}); 
	
	$("#a_ReadFile").click(()=>{
		Parmdata  = window.open(basePath+"/webPage/demo/"+"apkFile.jsp","windowopen",'width=800,height=700;location=no;'); 
	});
})  


var Page = {
	ajaxclick:  function() {   
		var Parmdata ={};
		Parmdata.serverapkpath = $("#ServerAPKPath").val(); 
		if($("#APKPath")[0].files[0]==null ){
			Parmdata.apkpath = $("#APKPathChild").val();
		}else{
			Parmdata.apkpath = $("#APKPath")[0].files[0].name;
		}
		
		Parmdata.versions = $("#Versions").val(); 
		
		if($("#key0jks")[0].files[0]==null ){
			Parmdata.key0jks = $("#key0jksChild").val();
		}else{
			Parmdata.key0jks = $("#key0jks")[0].files[0].name;
		}
		
		Parmdata.keyAlias = $("#keyAlias").val(); 
		Parmdata.keypass = $("#keypass").val();
		Parmdata.keyStorepass = $("#keyStorepass").val();
		
		var Posturl = basePath+"/webPage/demo/ajaxapk";
		Page.ajaxPost(Posturl,Parmdata,action);
    } 

	,ajaxPost:function(Posturl,Parmdata,action){   
		 $.ajax(
			    {
			       url:Posturl,
			       data:Parmdata,
			       type:"post",
			       //contentType: "application/json;charset=utf-8",
			       dataType:"json",
			       success:function(data)
			        {  
			    	  Page.ajaxReturn(action,data); 
			        } ,
			        error:function(data){  
			            alert("fail");  
			        }
			    });
	 		}
 
	,ajaxReturn:function(action,data){  
		if(data[0]*1 ==1){ 
			$("#newAppPath").val(data[1]);
			alert("APK签名完成！");
		}
		 
		if(action=="GetFileList"){
			GetFileList(data);
		}
//		 $.each(data, function(index, element) { 
//			   var value = element;
//	       });
 	}
}

var total=0;
var interval ;
function add(){
	$("#progressbar" ).progressbar({ value: total });
    total++;
    if(total==101){
    	clearInterval(interval);
        total=0;
    }
} 

var Parmdata = {};
 