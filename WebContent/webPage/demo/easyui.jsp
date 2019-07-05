<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../basePath.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base id="basePath" href="<%=basePath%>"> 

<link rel="stylesheet" type="text/css" href="${basePath}/webPage/resources/jquery-easyui-1.5.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${basePath}/webPage/resources/jquery-easyui-1.5.4.2/themes/icon.css">  
<link rel="stylesheet" type="text/css" href="${basePath}/webPage/resources/css/login.css"/> 
<script type="text/javascript" src="${basePath}/webPage/resources/js/jquery-1.8.3.min.js"></script>   
<script type="text/javascript" src="${basePath}/webPage/resources/jquery-easyui-1.5.4.2/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/webPage/resources/jquery-easyui-1.5.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}/webPage/resources/js/Page/login.js"></script>  

</head>
<body>
  <a   id="a_search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查詢</a>
  <a href="${basePath}/webPage/demo/login" id="a_edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">login</a>
	<table id="listGrid" class="easyui-datagrid" title="用户列表" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
		<thead>
			<tr>
				<th field="COLUMN1" width="20%">COLUMN1</th>
				<th field="NAME" width="30%">NAME</th>
				<th field="PWD" width="20%">PWD</th>
				<th field="COMESITEID" width="19%" align="center">COMESITEID</th> 
			</tr>
		</thead>
	</table>

<div style="display: none;">
	<div>ajaxRetrurn:</div>
	<div id="ajaxRetrurn"></div>
</div>
</body>
</html>