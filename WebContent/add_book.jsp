<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>add-book</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/lend_book.css">
</head>
<body>
<form class="form-inline definewidth m20" action="addBook" method="post">
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<td><font color="#777777"><strong>ISBN：&nbsp&nbsp</strong></font>
    			<input autocomplete="off" type="number" name="lend.readerId" class="abc input-default" placeholder="978-7-121-25457-4" >
    		</td>
    		<td><font color="#777777"><strong>书名：</strong></font>
    			<input autocomplete="off" type="number" name="lend.readerId" class="abc input-default" placeholder="图书名" >
    		</td>
    		<td><font color="#777777"><strong>作者：</strong></font>
    			<input autocomplete="off" type="number" name="lend.readerId" class="abc input-default" placeholder="作者" >
    		</td>
		</tr>
		<tr>
			<td><font color="#777777"><strong>出版社：</strong></font>
    			<input autocomplete="off" type="number" name="lend.readerId" class="abc input-default" placeholder="XXX出版社" >
    		</td>
    		<td><font color="#777777"><strong>价格：</strong></font>
    			<input autocomplete="off" type="number" name="lend.readerId" class="abc input-default" placeholder="默认为0" >
    		</td>
    		<td><font color="#777777"><strong>数量：</strong></font>
    			<input autocomplete="off" type="number" name="lend.readerId" class="abc input-default" placeholder="大于0" >
    		</td>
		</tr>
		<tr>
			<td><font color="#777777"><strong>封&nbsp&nbsp面：&nbsp</strong></font>
    			<input autocomplete="off" type="file" name="lend.readerId" class="abc input-default" >
    		</td>
    		<td><button type="submit" class="btn btn-primary">添加</button><span class="msg"></span>
    		</td>
		</tr>
	</table>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<caption><h2>添加结果</h2></caption>
    <thead>
    <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>价格</th>
		<th>总量</th>
		<th>余量</th>
		<th>封面</th>
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