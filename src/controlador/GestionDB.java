package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionDB {
	
	public static Connection getCon() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria", "root", "");
	}

}
