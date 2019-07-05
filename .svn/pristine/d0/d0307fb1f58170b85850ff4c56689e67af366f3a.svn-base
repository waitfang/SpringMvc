<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../basePath.jsp" %>
   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>  
<base id="basePath" href="<%=basePath%>"> 
<link rel="stylesheet" type="text/css" href="${basePath}/webPage/resources/css/login.css"/> 
<script type="text/javascript" src="${basePath}/webPage/resources/js/jquery-1.8.3.min.js"></script>  
<script type="text/javascript" src="${basePath}/webPage/resources/js/Page/login.js"></script>  
 
</head>
<body> 
 <a href="${basePath}/webPage/demo/easyui.jsp" id="a_edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">Easyui</a>
<br/>basePath: ${basePath}  
<br/>txtMasge: ${txtMasge}  
<%-- <br/>data: ${data}   --%> 
<br/>
<table border="1" style="width: 60%"> 
	<c:forEach items="${data}" var="result"> 
		<tr>
			<td style="width: 20%">
				<c:out value="${result.COLUMN1}"></c:out>  
				<c:choose>
					<c:when test="${result.COLUMN1==1}">
					   我就是第一个来捣蛋的！！！
					</c:when> 
				</c:choose>
			</td>
			<td style="width: 20%"><c:out value="${result.NAME}"></c:out>   </td>
			<td style="width: 15%"><c:out value="${result.PWD}"></c:out>   </td>
			<td style="width: 15%"><c:out value="${result.COMESITEID}"></c:out>   </td>
			<td style="width: 15%;text-align: center;"><input type="button" id="butSave"  value="Submit" /></td>
		</tr>
		 
	</c:forEach>
</table>
<div>
	<div>ajaxRetrurn:</div>
	<div id="ajaxRetrurn"></div>
</div>
</body>
</html>