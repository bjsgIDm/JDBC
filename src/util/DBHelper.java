package util;
import java.sql.*;

public class DBHelper {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/thestudentmanagement";
	private static final String username="root";
	private static final String password="root";
	private static Connection con=null;
	
	//静态代码块负责加载驱动，只在第一次加载到时候起作用
	public DBHelper(){
//		try {
//			Class.forName(driver);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static Connection getConnection(){		
		if(null==con){
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url,username,password);
			} catch (Exception e) {
				e.printStackTrace();
			}						
		}		
		return con;
	}
	
	
	
}
