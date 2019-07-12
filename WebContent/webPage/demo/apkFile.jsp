<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ include file="../basePath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Creat APK</title>
<base id="basePath" href="<%=basePath%>"> 
 
<link rel="stylesheet" type="text/css" href="${basePath}/webPage/resources/jquery-easyui-1.5.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${basePath}/webPage/resources/jquery-easyui-1.5.4.2/themes/icon.css">  
<script type="text/javascript" src="${basePath}/webPage/resources/js/jquery-1.8.3.min.js"></script>   
<script type="text/javascript" src="${basePath}/webPage/resources/jquery-easyui-1.5.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/webPage/resources/jquery-easyui-1.5.4.2/jquery.easyui.min.js"></script> 
<script type="text/javascript" src="${basePath}/webPage/resources/js/Page/apk.js"></script>   
</head>
<body>

	<div style="margin-left:1%;">   
			<a id="a_EditFile" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">保存</a>
			<div id="grid"></div>
	</div> 
</body>

<script type="text/javascript">
	var Posturl = basePath+"/webPage/demo/GetFileList";
	var Parmdata ={};
	Parmdata.ServerAPKPath = window.opener.$("#ServerAPKPath").val();
	Page.ajaxPost(Posturl,Parmdata,"GetFileList");
	
	function GetFileList(data){
		 $("#grid").datagrid({
			 	data: data,
		        width: 750,
		        height: 650,
		        autoScroll: true,
		        nowrap: false, //折行
		        rownumbers: true, //行号
		        striped: true, //隔行变色
		        idField: 'fileName', //主键  
		        frozenColumns: [[]],//想要冻结列的时候，就可以写这里
		        toolbar: '#toolbar',
		        showFooter: true,
		        pagination: true,
		        pageSize: 20,
		        pageList: [20, 40, 50],
		        columns: [[ 
		        	{field:'ck',checkbox:true},
		            { title: "文件名称", field: 'fileName' ,width:"90%", align: 'center' } 
		        ]], 
		        singleSelect: false, //单选
		        selectOnCheck: true,
		        checkOnSelect: true
		    });
	}
	
	//保存功能
	$("#a_EditFile").click(()=>{
		var checkedItems = $('#grid').datagrid('getChecked');
		Parmdata = {};
		$.each(checkedItems, function(index, item){  
			if(item.fileName.toUpperCase().indexOf(".APK")!= -1){ 
				if(Parmdata.APK !=null && Parmdata.APK!=""){
					alert("APK只能选择一个，请确认后再执行【保存】。");
					return false;
				}
				Parmdata.APK = item.fileName;
				window.opener.$("#APKPathChild").val(Parmdata.APK);
				
			} 
			if(item.fileName.toUpperCase().indexOf(".JKS")!= -1){ 
				if(Parmdata.JKS !=null && Parmdata.JKS!=""){
					alert("JKS只能选择一个，请确认后再执行【保存】。");
					return false;
				}
				Parmdata.JKS = item.fileName;
				window.opener.$("#key0jksChild").val(Parmdata.JKS);
			} 
		}); 
		//var ServerAPKPath = window.opener.$("#ServerAPKPath").val();//server Path   
		window.close(); 
	});
</script>
</html>