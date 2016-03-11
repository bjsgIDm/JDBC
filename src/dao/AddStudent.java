package dao;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBHelper;


@WebServlet("/GetFullInformation_s")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String sno=null;
    public String sname=null;
    public String sbirthday=null; 
    public String ssex=null; 
    public String sclass=null; 
    public String saddress=null; 
    public float stelephone;
    public String semail=null; 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
		sno=request.getParameter("sno");
		sname=request.getParameter("sname");	
		sbirthday=request.getParameter("sbirthday");		
		ssex=request.getParameter("ssex");
		sclass=request.getParameter("sclass");
		saddress=request.getParameter("saddress");
		stelephone=Float.parseFloat(request.getParameter("stelephone"));
		semail=request.getParameter("semail");
				
		//添加学生
		Connection con=null;
		PreparedStatement pre=null;
		try {
			con=DBHelper.getConnection();
			String sql="insert into tstudent(sno,sname,sbirthday,ssex,sclass,address,phone,email) values(?,?,?,?,?,?,?,?)";		
			pre=con.prepareStatement(sql);
			
			
						
			pre.setString(1,sno);
			pre.setString(2,sname);
			
			//强string转成mysql中的date			
			try {			
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
				java.util.Date ud = sdf.parse(sbirthday);
				java.sql.Date sqlDate = new java.sql.Date(ud.getTime());
				pre.setDate(3,sqlDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}	
						
			pre.setString(4,ssex);
			pre.setString(5,sclass);
			pre.setString(6,saddress);
			pre.setFloat(7,stelephone);
			pre.setString(8,semail);
			pre.executeUpdate();	
			
			PrintStream out=new PrintStream(response.getOutputStream());	
			out.println("<br><br><br><br><h1 style='color:#930000;text-align:center;font-family: YouYuan;'>学生添加成功!</h1>");
		}
		catch (SQLException e) {
			PrintStream out=new PrintStream(response.getOutputStream());	
			out.println("<br><br><br><br><h1 style='color:#930000;text-align:center;font-family: YouYuan;'>出错啦!</h1>");
		}								
	}

}
