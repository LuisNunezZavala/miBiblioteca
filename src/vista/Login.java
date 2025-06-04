package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.BibliotecariosDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(157, 80, 73, 14);
		panel.add(lblUsuario);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(157, 117, 73, 14);
		panel.add(lblPassword);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(240, 77, 140, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(240, 114, 140, 20);
		panel.add(pwdPassword);

		JButton btnLogin = new JButton("Acceder");
		btnLogin.setBounds(206, 157, 108, 23);
		panel.add(btnLogin);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(88, 157, 108, 23);
		panel.add(btnSalir);

		JButton btnAlta = new JButton("Nuevo Usuario");
		btnAlta.setBounds(324, 157, 108, 23);
		panel.add(btnAlta);

		// Eventos
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String password = new String(pwdPassword.getPassword());
				
				if(usuario.isBlank() || password.isBlank()) {
					JOptionPane.showMessageDialog(btnLogin, "Los campos no puede ser vacios", "Login", JOptionPane.WARNING_MESSAGE);
				} else {
					if (BibliotecariosDAO.Login(usuario, password)) {
						//abri ventana aplicacion
						Biblioteca biblio = new Biblioteca();
						biblio.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(btnLogin, "Usuario o contraseña incorrecta", "Login", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoUsuario nuevoUsuario = new NuevoUsuario(Login.this, "Nuevo usuario", true);
				nuevoUsuario.setVisible(true);
			}
		});

	}
	
	public void setUsuario(String usuario) {
		txtUsuario.setText(usuario);
	}
}
