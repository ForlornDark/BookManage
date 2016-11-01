<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<div class="top_div"></div>
	<div
		style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
		<div style="width: 165px; height: 96px; position: absolute;">
			<div class="tou"></div>
			<div class="initial_left_hand" id="left_hand"></div>
			<div class="initial_right_hand" id="right_hand"></div>
		</div>
		<s:form theme="simple" action="login" method="post" onsubmit="return check()">
		<p style="padding: 30px 0px 10px; position: relative;">
			<span class="u_logo"></span> 
			<input class="ipt" id="id" type="text" placeholder="请输入ID" name="user.name">
		</p>
		<p style="position: relative;">
			<span class="p_logo"></span> 
			<input class="ipt" id="password" type="password" placeholder="请输入密码" name="user.password">
		</p>
		<div style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
			<p style="margin: 0px 35px 20px 45px;">
		<!--  		<span style="float: left;">
					<a style="color: rgb(204, 204, 204);" href="#">忘记密码?</a>
				</span>
				<span style="float: right;">
					<a style="color: rgb(204, 204, 204); margin-right: 10px;" href="#">注册</a>
					
				</span>
		-->
				<s:submit class="login" value="登录"></s:submit>  <span id = "msg" style="color:#ff0000"><s:property value="msg"/></span>
			</p>
		</div>
		</s:form>
	</div>
	<div style="text-align: center;margin-top:20px">
		<p>
			技术支持:<a href="#" target="_blank">APAE</a>
		</p>
	</div>
</BODY>
</HTML>