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
	<form method="post" action="servlet/SelectStudent">
		<h1>查询学生信息</h1><br/>
		<div class="div_del_all">	
			<div class="div_del">
				学生学号：
				<input type="text" name="sno"/> 
				<!-- 修改成单选表单 -->
			<!-- 
				<select name="cars">
				<option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="fiat" selected="selected">Fiat</option>
				<option value="audi">Audi</option>
				</select>
			-->
			
			</div>	
			<div class="div_del_button"><input type="submit" value="提交"/></div> 
		</div>
	</form>
</body>
</html>