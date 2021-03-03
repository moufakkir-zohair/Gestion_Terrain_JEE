package Connection_BD;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class SingletonConnection {

	private static Connection connection;
	static {
		try {
              Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  connection = DriverManager.getConnection("jdbc:mysql://mysql:3306/terrain","root","root");
              //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/terrain?serverTimezone=UTC","root","");
			  System.out.println("Connection !!");
	            
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}











