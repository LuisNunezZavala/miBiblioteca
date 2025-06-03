package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionDB {

	private Connection con;

	public GestionDB() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria", "root", "");
	}
	
	public Connection getCon() {
		return con;
	}
	
	public void cerrarDB() throws SQLException {
		if(con != null) {
			con.close();
		}
	}

}
