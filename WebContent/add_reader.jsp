<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>add-book</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/date.js"></script>
    <script type="text/javascript" src="js/add_reader.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/lend_book.css">
    <style>
    	.date{
    	width:70px;
    	}
    	</style>
</head>
<body onLoad="init()">
<form class="form-inline definewidth m20" action="addReader" method="post" enctype="multipart/form-data" onsubmit="return check()">
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<td><font color="#777777"><strong>姓名：</strong></font>
    			<input id ="name" autocomplete="off" type="text" name="reader.name" class="abc input-default" placeholder="姓名" >
    		</td>
    		<td><font color="#777777"><strong>性别：</strong></font>
    			<select name="reader.sex" name="reader.sex">
    				<option value="1">男</option>
    				<option value="0">女</option>
    			</select>
    		</td>
    		<td><font color="#777777"><strong>出生日期：</strong></font>
    			<select class="date"  id="year" onChange="swap_day()" name="year"></select>年
				<select class="date" id="month" onChange="swap_day()" name="month"></select>月
				<select class="date"  id="day" name="day"></select>日
    		</td>
		</tr>
		<tr>
			<td><font color="#777777"><strong>职业：</strong></font>
    			<input id="spec" autocomplete="off" type="text" name="reader.spec" class="abc input-default" placeholder="职业" >
    		</td>
    		<td><font color="#777777"><strong>照片：</strong></font>
    			<input autocomplete="off" type="file" name="photo" class="abc input-default" >
    		</td>
    		<td><button type="submit" class="btn btn-primary">注册</button><span id="msg" class="msg"></span>
    		</td>
		</tr>
		
	</table>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<caption><h2>添加结果</h2></caption>
    <thead>
    <tr>
        <th>借阅号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>职业</th>
		<th>照片</th>
     </tr>
    </thead>
        	<tr>
        		<td><s:property value="reader.readerId"></s:property></td>
                <td><s:property value="reader.name"></s:property></td>
                <td><s:if test="reader.sex==0">女</s:if><s:elseif test="reader.sex==1">男</s:elseif></td>
                <td><s:date name="reader.born" format="yyyy年MM月dd日"/></td>
                <td><s:property value="reader.spec"></s:property></td>
              
            </tr>
       </table>
</body>
</html>