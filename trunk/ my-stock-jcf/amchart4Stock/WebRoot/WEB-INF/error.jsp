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
	<img src="pic/filenotfound.jpg"/><br/>
		<img src="pic/filenotfound.jpg"/><br/>
			<img src="pic/filenotfound.jpg"/><br/>
				<img src="pic/filenotfound.jpg"/><br/>
					<img src="pic/filenotfound.jpg"/><br/>
					到百度首页
新闻　网页　贴吧　知道　MP3　图片　视频　地图　更多▼

▶来百度推广您的产品
咨询热线：400-800-8888
e.baidu.com


web.xml的error-page标签，不起作用~~_百度知道
web.xml的error-page标签，不起作用~~ 系统提示：这是一个从旧版社区导入的...在page_not_found.jsp页面上有用isErrorPage="true"? ...
zhidao.baidu.com/question/39146850.html 2007-11-11 - 百度快照

web.xml error-page 不起作用_NextNJ的空间_百度空间
--> <error-page> <exception-type>java.lang.Throwable</exception-type> <location>/common/500.jsp</location> </error-page> <error-page> <error-code>...
hi.baidu.com/nextnj/blog/item/e98d4628229 ... 2010-6-12 - 百度快照

nginx php error_page不起作用一例 - 网站服务器 - LinuxTone | ...
4条回复 - 发帖时间: 2010年7月16日
今天有同事和我说nginx的error_page设置貌似有问题普通静态文件如果不存在是正在返回指定的404页面的，但是php页面不行，我看了下配置完全没问题，初步估计是fastcgi没...
bbs.linuxtone.org/thread-6848-1-1.html 2011-5-27 - 百度快照

web.xml中配置error-page为什么不起作用? - OperaMasks SDK - Ope...
3条回复 - 发帖时间: 2009年12月20日
web.xml中配置error-page为什么不起作用?我在web.xml中加入了 复制内容到剪贴板 XML 代码: <error-page> <exception-type>java.lang.Exception</exception-type>...
www.operamasks.org/forum/thread-4943-1-1.html 2011-5-26 - 百度快照

我的web.xml error-page没起作用 - Web开发
我的web.xml error-page没起作用我笨故我学 我的web.xml error-page没起作用平台：Win2kserver:Tomcat 4.1.30jvm:jdk1.4.2web.xml如下:

	<a href="index.jsp">返回首页</a><br/>
	<s:debug/>
</body>
</html>