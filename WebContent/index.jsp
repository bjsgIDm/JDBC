<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.StudentsInformation"%>
<%@ page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/sui.css">
	 <script type="text/javascript" src="./js/sui.js"></script>
	 <script type="text/javascript" src="./js/jquery.js"></script>
  </head>
  <body>
    <h1>学生信息</h1>
    <hr>
    <table>
    	<tr>
    		<td><div class="div_index"><a href="add.jsp">增加学生信息</a></div></td>
    	</tr>
    	<tr>
    		<td><div class="div_index"><a href="del.jsp">删除学生信息</a></div></td>
    	</tr>
    	<tr>
    		<td><div class="div_index"><a href="update.jsp">修改学生信息</a></div></td>
    	</tr>
    	<tr>
    		<td><div class="div_index"><a href="SelectStudent.jsp">查询学生信息</a></div></td>
    	</tr>
    </table>
    <br>
    <div class="show_all">
    	<form action="servlet/ShowAllStudent" method="post">
    		<input type="submit" value="显示全部学生信息">
    	</form>	
    </div>  	
  </body>
</html>
