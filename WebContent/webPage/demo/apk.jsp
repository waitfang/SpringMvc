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
	<form id="formapk">
	<div style="margin-top:100px;margin-left:10%;"> 
		<table>
			<tr>
			<td>
				<fieldset style="height:450px;">
			    	<legend>打包APK使用的密钥key0.jks，keyAlias-别名。keypass，keyStorepass</legend> 
			  	
					<table style="border-collapse:separate; border-spacing:30px;"> 
						<tr >
							<td>密钥 Name:</td>
							<td> 
								<input type="file" id=key0jks>
								<br/>
								<input type="text" id="key0jksChild"  value="" style="height:50px;width:250px;">
							</td>
						</tr>
						<tr>
							<td>keyAlias:</td>
							<td> 
								<input type="text" id="keyAlias"  value="key0" style="height:50px;width:250px;">
							</td>
						</tr>
						<tr>
							<td>keypass:</td>
							<td> <input type="text" id="keypass"  value="123456" style="height:50px;width:250px;"></td>
						</tr>  
						<tr>
							<td>keyStorepass:</td>
							<td> <input type="text" id="keyStorepass"  value="123456" style="height:50px;width:250px;"></td>
						</tr>    
					</table>  
				</fieldset>
			</td>
			<td>
			 	<fieldset style="height:450px;margin-left:5%;width:100%;">
			    	<legend>打包新的APK,Versions:签名的信息，file：apk目录。</legend> 
			  
					<table style="border-collapse:separate; border-spacing:30px;"> 
						<tr >
							<td>ServerAPK Path:</td>
							<td> 
								<input type="text" id="ServerAPKPath" Value="D:\apk" style="height:50px;width:250px;">
								<a id="a_ReadFile" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" style="height:50px;">读取目录文件</a>
							</td>
						</tr>
						<tr >
							<td>APK Name:</td>
							<td> <input type="file" id="APKPath">
							<br/>
								<input type="text" id="APKPathChild"  value="" style="height:50px;width:250px;">
								</td>
						</tr>
						<tr>
							<td>Versions:</td>
							<td> <input type="text" id="Versions" style="height:50px;width:250px;"></td>
						</tr> 
						<tr>
							<td>
								<%-- href="${basePath}/webPage/demo/apk" --%>
								<a id="a_edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">创建新APK</a>
							</td>
							<td> </td>
						</tr> 
					</table>  
				</fieldset>
			</td>
			</tr>
		</table>
		<div id="progressbar" style="float:left;border:1px solid #00F;width:89%;margin-left:0.3%;"></div> 
		<br/>
		<input type="text" id="newAppPath" value="新APK存放目录" style="height:50px;width:89%;margin-left:0.3%;">  
	</div> 
	</form>
</body>
</html>