package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import util.CifradoClave;

public class BibliotecariosDAO {

	public static boolean Login(String usuario, String password) {

		try {

			String sql = "select * from bibliotecarios where usuario = ? and clave_hash = ?";
			String pwdCifrada = CifradoClave.cifrado(password);

			try (PreparedStatement pstmt = GestionDB.getCon().prepareStatement(sql)) {
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

	public static boolean addUsuario(String usuario, String password) {
		try {

			String sql = "insert into bibliotecarios(usuario, clave_hash) values (?, ?)";
			String pwdCifrada = CifradoClave.cifrado(password);
			
			
			try (PreparedStatement pstmt = GestionDB.getCon().prepareStatement(sql)) {
				pstmt.setString(1, usuario);
				pstmt.setString(2, pwdCifrada);

				return pstmt.executeUpdate() > 0;
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error BBDD", "Acceso", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

}
