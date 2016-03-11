<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/reset.css">
</head>
<body>
	<form method="post" action="servlet/UpdateStudent">	
		<h1>修改学生信息</h1><br/>
		<div class="div_add_all">
			<div class="div_add">学生学号：<input type="text" name="sno"/></div>
			<div class="div_add">学生姓名：<input type="text" name="sname"/></div>
			<div class="div_add">生&emsp;&emsp;日：<input type="text" name="sbirthday"/></div>
			<div class="div_add">性&emsp;&emsp;别：<input type="text" name="ssex"/></div>
			<div class="div_add">班&emsp;&emsp;级：<input type="text" name="sclass"/></div>
			<div class="div_add">住&emsp;&emsp;址：<input type="text" name="saddress"/></div>
			<div class="div_add">手&emsp;&emsp;机：<input type="text" name="stelephone"/></div>
			<div class="div_add">邮&emsp;&emsp;箱：<input type="text" name="semail"/></div>
			<div class="div_add_button"><input type="submit" value="确定"/></div>
		</div>		 
	</form>
</body>
</html>