<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib  prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
	<br>
	<img src="pic/filenotfound.jpg"/>
	错误提示:<s:property value="%{getText(exception.errorCode)}"/><br/>
			<s:property value="errorMessages"/>
	<img src="pic/filenotfound.jpg"/>错误代码:<s:property value="exception.errorCode"/><br/>
	<a href="index.jsp">返回首页</a><br/>
	<s:debug/>
</body>
</html>