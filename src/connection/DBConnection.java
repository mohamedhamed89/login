package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public DBConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnction() throws SQLException, ClassNotFoundException{
		
		String user = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/logindb";
		String driver = "com.mysql.jdbc.Driver";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);
		return conn;
		
		
	}

}
