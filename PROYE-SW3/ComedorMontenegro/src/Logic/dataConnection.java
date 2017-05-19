package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Statement;

public class dataConnection {

	/**
	 * metodo que
	 * 
	 * @param args
	 */
	private static String user = "root";
	private static String password = "123456";
	private static String dataBase = "instituto_montenegro";
	static String url = "jdbc:mysql://localhost/" + dataBase;
	private static Connection connection = null;

	public dataConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Connection conexion() {

		try {
			Class.forName("com.mysql.jdbc.Connection");
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			System.out.println("Problema al conectarse a: " + url);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		return connection;
	}

	public ResultSet getQuery(String query) {
		Statement state = null;
		ResultSet result = null;
		try {
			state = (Statement) connection.createStatement();
			result = state.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void setQuery(String query) {
		Statement state = null;
		try {
			state = (Statement) connection.createStatement();
			state.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
