package dao;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.StudentsInformation;
import util.DBHelper;
@WebServlet("/SelectStudent")
public class SelectStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得学生信息
			Connection con=null;
			PreparedStatement pre=null;
			ResultSet res=null;
			
			try {
				String sno=request.getParameter("sno");				
				con=DBHelper.getConnection();				
				String sql="select * from tstudent where sno=?";
				pre=con.prepareStatement(sql);
				pre.setString(1,sno);
				res=pre.executeQuery();				
				StudentsInformation student=new StudentsInformation();
				if(res.next()){					
				student.setSno(sno);				
				student.setSname(res.getString("sname"));
				student.setSbirthday(res.getDate("sbirthday"));
				student.setSsex(res.getString("ssex"));
				student.setSclass(res.getString("sclass"));
				student.setAddress(res.getString("address"));
				student.setPhone(res.getString("phone"));
				student.setEmail(res.getString("email"));
				}	
				PrintStream out=new PrintStream(response.getOutputStream());
			
				response.setContentType("text/html");
				out.println("<br><br><br><br><h2 style='color:#930000;margin-left:550px;font-family: YouYuan;'>学号："+student.getSno()+"</h1>");
				out.println("<h2 style='color:#930000;margin-left:550px;font-family: YouYuan;'>姓名："+student.getSname()+"</h1>");
				out.println("<h2 style='color:#930000;margin-left:550px;font-family: YouYuan;'>生日："+student.getSbirthday()+"</h1>");
				out.println("<h2 style='color:#930000;margin-left:550px;font-family: YouYuan;'>性别："+student.getSsex()+"</h1>");
				out.println("<h2 style='color:#930000;margin-left:550px;font-family: YouYuan;'>班级："+student.getSclass()+"</h1>");
				out.println("<h2 style='color:#930000;margin-left:550px;font-family: YouYuan;'>地址："+student.getAddress()+"</h1>");
				out.println("<h2 style='color:#930000;margin-left:550px;font-family: YouYuan;'>电话："+student.getPhone()+"</h1>");
				out.println("<h2 style='color:#930000;margin-left:550px;font-family: YouYuan;'>email："+student.getEmail()+"</h1>");
			}
			catch (SQLException e) {
				PrintStream out=new PrintStream(response.getOutputStream());	
				out.println("<br><br><br><br><h1 style='color:#930000;text-align:center;font-family: YouYuan;'>出错啦!</h1>");
				return;
			}
							
		//结束：获得学生信息
		
		
	}

}
