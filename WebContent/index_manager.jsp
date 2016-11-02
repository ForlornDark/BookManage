<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index_manager</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/index_manager.js"></script>
<link rel="stylesheet" type="text/css" href="css/index_manager.css" />
</head>
<body>
	<div class="top1">
		<marquee>欢迎使用图书管理系统</marquee>
	</div>
	<div class="top2">
		<div class="logo">
			<img src="images/admin_logo.png" title="在哪儿" />
		</div>
		<div class="title">
			<h3>图书管理系统</h3>
		</div>
		<div class="fr top-link">
			<a href="#" target="mainCont" title="FolornDark"><i
				class="adminIcon"></i><span>管理员：ForlornDark</span></a>
		</div>
	</div>

	<div class="left">
		<div class="div1">
			<div class="left_top">
				<img src="images/bbb_01.jpg"><img src="images/bbb_02.jpg"
					id="2"><img src="images/bbb_03.jpg"><img
					src="images/bbb_04.jpg">
			</div>

			<div class="div2">
				<div class="spgl"></div>
				业务
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('videoQuery.html');">借书</a></li>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('uservideoQuery.html');">还书</a></li>
				</ul>
			</div>
			<div class="div2">
				<div class="spgl"></div>
				查询
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('lend_query.jsp');">借书查询</a></li>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('book_query.jsp');">图书查询</a></li>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('userdocumentQuery.html');">读者查询</a></li>
				</ul>
			</div>
			<div class="div2">
				<div class="spgl"></div>
				添加
			</div>
			<div class="div3">
				<ul>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('classQuery.html');">图书添加</a></li>
					<li><a class="a" href="javascript:void(0);"
						onClick="openurl('classQuery.html');">读者添加</a></li>
				</ul>
			</div>
			<div class="div2">
				<div class="tcht"></div>
				<a class="a1" href="index.jsp">退出后台</a>
			</div>
		</div>
	</div>
	<div class="right">
		<iframe id="rightFrame" name="rightFrame" width="100%" height="100%"
			scrolling="auto" marginheight="0" marginwidth="0" align="middle"
			style="border: 0px solid #CCC; margin: 0; padding: 0;"></iframe>
	</div>
</body>
</html>
