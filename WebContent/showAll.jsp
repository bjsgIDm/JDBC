<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/sui.css">
<%
	List list=null;
	list=new ArrayList();
	list=(List)session.getAttribute("allStudentInf");
	
%>
</head>
<body>
	<br><br><br><br>
	<table class="table_stu" border="1">
		<tr>
			<td colspan="8" class="table_h">学生信息</td>
		</tr>
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>生日</td>
			<td>性别</td>
			<td>班级</td>
			<td>地址</td>
			<td>电话</td>
			<td>Email</td>
		</tr>
		<%
			StudentsInformation stu;
			for(int i=0;i<list.size();i++){
				stu=(StudentsInformation)list.get(i);
		%>
		<tr>
			<td><%=stu.getSno()%></td>
			<td><%=stu.getSname()%></td>
			<td><%=stu.getSbirthday()%></td>
			<td><%=stu.getSsex()%></td>
			<td><%=stu.getSclass()%></td>
			<td><%=stu.getAddress()%></td>
			<td><%=stu.getPhone()%></td>
			<td><%=stu.getEmail()%></td>		
		</tr>
		<%
			}
		%>
		
	</table>
</body>
</html>