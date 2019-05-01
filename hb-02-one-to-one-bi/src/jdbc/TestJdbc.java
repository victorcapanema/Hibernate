package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "victor";
		String pass = "123456";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
