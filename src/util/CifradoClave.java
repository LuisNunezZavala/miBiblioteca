package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradoClave {

	public static String cifrado(String password) {

		String cadenaCifrada = "";

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] mensajeDigerido = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (byte caracter : mensajeDigerido) {
				sb.append(String.format("%02X", caracter));
			}

			cadenaCifrada = sb.toString();

		} catch (NoSuchAlgorithmException ex) {
			System.out.println("Error en el cifrado");
		}

		return cadenaCifrada;
	}
}
