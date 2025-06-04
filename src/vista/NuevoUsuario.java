package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.BibliotecariosDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;


public class NuevoUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;
	private JPasswordField pwdConfirmPassword;
	
	/**
	 * Create the dialog.
	 */
	public NuevoUsuario(Login l, String titulo, boolean modal) {
		super(l, titulo, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(179, 62, 131, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 65, 131, 14);
		panel.add(lblUsuario);

		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(10, 96, 131, 14);
		panel.add(lblPassword);

		JLabel lblConfirmPassword = new JLabel("Confirmar contraseña");
		lblConfirmPassword.setBounds(10, 127, 131, 14);
		panel.add(lblConfirmPassword);

		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(179, 93, 131, 20);
		panel.add(pwdPassword);

		pwdConfirmPassword = new JPasswordField();
		pwdConfirmPassword.setBounds(179, 124, 131, 20);
		panel.add(pwdConfirmPassword);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(179, 165, 89, 23);
		panel.add(btnCrear);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(52, 165, 89, 23);
		panel.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});

		btnCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String usuario = txtUsuario.getText();
				String password = new String(pwdPassword.getPassword());
				String confirmPassword = new String(pwdConfirmPassword.getPassword());

				if (usuario.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
					JOptionPane.showMessageDialog(btnCrear, "Los campos no puede ser vacios", "Agregar usuario", JOptionPane.WARNING_MESSAGE);
				} else if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(btnCrear, "Las contreñas no pueden ser diferentes", "Agregar usuario", JOptionPane.WARNING_MESSAGE);
				} else {
					if(BibliotecariosDAO.addUsuario(usuario, password)) {
						JOptionPane.showMessageDialog(btnCrear, "Usuario creado", "Agregar usuario", JOptionPane.INFORMATION_MESSAGE);
						l.setUsuario(usuario);
						dispose();
					} else {
						JOptionPane.showMessageDialog(btnCrear, "No se ha podido dar de alta al usuario", "Agregar usuario", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
}