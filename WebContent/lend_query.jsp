<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/lend_query.js"></script>
<title>lend_query</title>
</head>
<body>
	<div>
		<s:form action="queryLend" method ="post" onsubmit="return check();">
			<span style="color:#ff0000;" id="msg"></span>
			<input id="id" pattern="^[0-9]*$" autocomplete="off" placeholder="输入您的借阅号" name="id">
			<s:submit value="提交"></s:submit>
		</s:form>
		
	
	</div>
	<div>
		<table>
			<caption><h2>查询结果</h2></caption>
			<tr>
				<th>ISBN</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>价格</th>
				<th>数量</th>
				<th>借书时间</th>
				<th>书标</th>
			</tr>
			<s:if test="list!=null&&list.size>0">
				<s:iterator value="list">
				<tr>
					<td><s:property value="top.ISBN"/><td>
					<td><s:property value="top.book.bookName"/><td>
					<td><s:property value="top.book.author"/><td>
					<td><s:property value="top.book.publisher"/><td>
					<td><s:property value="top.book.price"/><td>
					<td><s:property value="top.num"/><td>
					<td><s:date name="top.time" format="yyyy年MM月dd日"/><td>
			<!--  		<td><s:property value="top.photo"/><td> -->
				</tr>
				</s:iterator>
			</s:if>
			<s:elseif test="id!=null">
				<tr>
					<td>没有查询结果<td>
				</tr>
			</s:elseif>
		</table>
	</div>
</body>
</html>