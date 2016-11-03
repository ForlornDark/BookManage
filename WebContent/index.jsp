<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/index.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css">
<title>welcome</title>
</head>
<body>
<div>
<h1>图书管理系统</h1>
</div>
<div >
	<a href="login.jsp" class="login">管理员登陆</a>
</div>
<div class="menu">
	<span onclick="openUrl('lend_query.jsp')" class="menu-item1">借阅查询</span>
	<span onclick="openUrl('book_query.jsp')" class="menu-item1">图书查询</span>
	<span id="about" onclick="openUrl('about.html');" class="menu-item1">关于</span>
</div>
<!--  <iframe id="container" width="100%" height="500px" src="book_query.jsp">-->
<div class="bottom">
<iframe id="container" name="rightFrame" width="100%" height="100%" src="book_query.jsp"
			scrolling="auto" marginheight="0" marginwidth="0" align="middle"
			style="border: 0px solid #CCC; margin: 0; padding: 0;"></iframe>
</div>
</body>
</html>