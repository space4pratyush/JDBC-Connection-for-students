import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/college";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	private static Connection con;

	public static Connection createConnection() {

		try {
			Class.forName(DRIVER);
			System.out.println("Driver class loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Unable to load driver");
			System.out.println(e);
		}

		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection Established");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unale to connect database");
			System.out.println(e);
			// e.printStackTrace();
		}

		return con;
	}

	public static void closeConnection() {

		try {
			con.close();
			System.out.println("Connection is closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unale to close database connection");
			System.out.println(e);
			// e.printStackTrace();
		}

	}
}