package Connection_BD;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class SingletonConnection {

	private static Connection connection;
	static {
		try {
			
			
			   System.out.println("Working directory : "+System.getProperty("user.dir"));
	            // chargement du prop file
	            FileInputStream in = new FileInputStream("C:/Users/Moufakkir Zohair/Desktop/XML/JEE/gestion_terrain/ressources/props.properties");
	            Properties propFile = new Properties();
	            propFile.load(in);
	        
	            // Extraction des propriete
	            String driverClass = propFile.getProperty("jdbc.driverClass");
	            String s = driverClass;
	            Class.forName(s);
	            String dbUrl = propFile.getProperty("jdbc.url");
	            String login = propFile.getProperty("jdbc.login");
	            String password = propFile.getProperty("jdbc.password");	           
	            String url = dbUrl;
	            connection = DriverManager.getConnection(url, login, password);
	            System.out.println("Connection !!");
	            
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}











