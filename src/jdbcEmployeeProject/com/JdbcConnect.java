package jdbcEmployeeProject.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
	static Connection con;
	public static Connection connect() throws SQLException {
		try {
			
			//STEP -01 load driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbcemployeeproject";
			String user = "root";
			String password = "rootroot";
			
			//STEP - 02 connection create
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
