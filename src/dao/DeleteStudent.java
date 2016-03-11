package dao;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBHelper;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		request.setCharacterEncoding("utf-8");
		String sno=request.getParameter("sno");
						
		//删除学生
		Connection con=null;
		PreparedStatement pre=null;
		try {
			con=DBHelper.getConnection();
			String sql="delete from tstudent where sno=?";		
			pre=con.prepareStatement(sql);
			
						
			pre.setString(1,sno);
			pre.executeUpdate();
//			con.close();
			
			PrintStream out=new PrintStream(response.getOutputStream());	
			out.println("<br><br><br><br><h1 style='color:#930000;text-align:center;font-family: YouYuan;'>学生删除成功!</h1>");
		}
		catch (SQLException e) {
			PrintStream out=new PrintStream(response.getOutputStream());	
			out.println("<br><br><br><br><h1 style='color:#930000;text-align:center;font-family: YouYuan;'>出错啦!</h1>");
		}		 
	}

}
