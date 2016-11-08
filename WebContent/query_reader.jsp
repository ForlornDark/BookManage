<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/book_query.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/lend_book.css">
<title>book_query</title>
</head>
<body>
	<div>
		<s:form class="form-inline definewidth m20" action="queryReader" method ="post" onsubmit="return check();">
			<font color="#777777"><strong>ID或姓名：</strong></font>
			<input type="text" class="abc input-default" autocomplete="off" placeholder="ID或姓名" name="param">
			&nbsp;&nbsp;<button type="submit" class="btn btn-primary">查询</button>
			<span style="color:#ff0000;" id="msg"></span>
		</s:form>
	</div>
	<div>
		<table class="table table-bordered table-hover definewidth m10">
			<caption><h2>查询结果</h2></caption>
			<thead>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>性别</th>
				<th>生日</th>
				<th>职业</th>
				<th>头像</th>
				<th>操作</th>
			</tr>
			</thead>
			<s:if test="state!=null">
				<tr><td colspan="8" style="color:#ff0000;text-align:center ;border-collapse:collapse;"><s:property value="state"/></td></tr>
			</s:if>
			<s:iterator value="readers">
				<tr>
					<td><s:property value="top.readerId"/></td>
					<td><s:property value="top.name"/></td>
					<s:if test="top.sex==1">
						<td>男</td>
					</s:if>
					<s:elseif test="top.sex==0"><td>女</td></s:elseif>
					<td><s:date name="top.born" format="yyyy-MM-dd"/></td>
					<td><s:property value="top.spec"/></td>
					<td><img src="${top.photo}" width="40px" height="40px"></td>
					<td><a href="deleteReader.action?readerId=${top.readerId}">注销</a></td>
				</tr>
			</s:iterator>
			
		</table>
	</div>
</body>
</html>