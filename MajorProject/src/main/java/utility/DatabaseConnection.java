package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static DatabaseConnection obj = new DatabaseConnection();

	// private constructor
	private DatabaseConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseConnection getInstance() {
		return obj;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "password");
		if (connection.isClosed()) {
			System.out.println("connection is closed!");
		} else {
			System.out.println("Connected to database..");
		}
		return connection;
	}
}
