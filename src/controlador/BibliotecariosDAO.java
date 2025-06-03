package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import util.CifradoClave;

public class BibliotecariosDAO {

	public static boolean Login(String usuario, String password) {

		try {
			GestionDB bbdd = new GestionDB();

			String sql = "select * from bibliotecarios where usuario = ? and clave_hash = ?";
			String pwdCifrada = CifradoClave.cifrado(password);

			try (PreparedStatement pstmt = bbdd.getCon().prepareStatement(sql)) {
				pstmt.setString(1, usuario);
				pstmt.setString(2, pwdCifrada);

				try (ResultSet rs = pstmt.executeQuery()) {
					return rs.next();
				}
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error BBDD", "Acceso", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	
}
