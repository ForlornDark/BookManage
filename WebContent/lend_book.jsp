<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>lend-book</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/lend_book.css">
    <script type="text/javascript" src="js/lend_book.js"></script>
</head>
<body>
<form class="form-inline definewidth m20" action="lendBook" method="post" onsubmit="return check()">
     <font color="#777777"><strong>借阅号：</strong></font>
    <input id="readerId" autocomplete="off" type="number" name="lend.readerId" class="abc input-default" placeholder="数字ID" >&nbsp;&nbsp;
    <font color="#777777"><strong>ISBN：</strong></font>
    <input id="isbn" autocomplete="off" type="text" name="lend.ISBN" class="abc input-default" placeholder="978-7-121-25457-4">
    <font color="#777777"><strong>数量：</strong></font>
    <input id="number" autocomplete="off" type="number" name="lend.num" class="abc input-default" placeholder="数字">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">借书</button><span id="msg" class="msg"></span>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<caption><h2>借书记录</h2></caption>
    <thead>
    <tr>
        <th>ISBN</th>
        <th>借阅号</th>
        <th>书名</th>
        <th>时间</th>
		<th>数量</th>
     </tr>
    </thead>
       
        <s:if test="#map['error']!=null">
         <tr>
        	<td colspan="5" style="color:#ff0000;text-align:center ;border-collapse:collapse;"><s:property value="#map['error']"></s:property></td>
        </tr>
        </s:if>
        <s:else>
        	<s:iterator value="#map['result']">
        	<tr>
        		<td><s:property value="top.isbn"></s:property></td>
                <td><s:property value="top.readerId"></s:property></td>
                <td><s:property value="top.book.bookName"></s:property></td>
                <td><s:date name="top.time" format="yyyy年MM月dd日"/></td>
                <td><s:property value="top.num"></s:property></td>
            </tr>
        	</s:iterator>
        </s:else>
       </table>
</body>
</html>