package dao;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.StudentsInformation;
import util.DBHelper;
@WebServlet("/ShowAllStudent")
public class ShowAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowAllStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	@SuppressWarnings({ })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得学生信息
			Connection con=null;
			PreparedStatement pre=null;
			ResultSet res=null;
			
			try {			
				con=DBHelper.getConnection();				
				String sql="select * from tstudent";
				pre=con.prepareStatement(sql);
				res=pre.executeQuery();		
				List list = null;
				list=new ArrayList();
				while(res.next()){						
					StudentsInformation student;
					student=new StudentsInformation();
					
					student.setSno(res.getString("sno"));				
					student.setSname(res.getString("sname"));
					student.setSbirthday(res.getDate("sbirthday"));
					student.setSsex(res.getString("ssex"));
					student.setSclass(res.getString("sclass"));
					student.setAddress(res.getString("address"));
					student.setPhone(res.getString("phone"));
					student.setEmail(res.getString("email"));
					
					list.add(student);
				}
				//!!!!!!!
				request.getSession().setAttribute("allStudentInf", list);
				response.sendRedirect("http://localhost:8080/studentInformation_M/showAll.jsp");
			}
			catch (SQLException e) {
				return;
			}
							
		//结束：获得学生信息
		
		
	}

}
