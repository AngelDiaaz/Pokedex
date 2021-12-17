package ui;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import models.Usuario;
import utils.Almacen;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroView {

	private JFrame frmRegistro;
	private JTextField textUsuario;
	private JPasswordField pfPassword;
	private JPasswordField pfPasswordRepetir;
	private JLabel lblRegistro;
	private JLabel lblNewUsuario;
	private JLabel lblNewPassword;
	private JLabel lblNewPasswordRepetir;
	private JButton btnRegistro;
	

	/**
	 * Create the application.
	 */
	public RegistroView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}
	
	private void configureUIComponents() {
		frmRegistro = new JFrame();
		frmRegistro.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroView.class.getResource("/image/icono app.png")));
		frmRegistro.setTitle("Registro");
		frmRegistro.setBounds(100, 100, 450, 300);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		
		lblRegistro = new JLabel("Crear Cuenta");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistro.setBounds(152, 11, 141, 40);
		frmRegistro.getContentPane().add(lblRegistro);
		
		lblNewUsuario = new JLabel("Usuario");
		lblNewUsuario.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewUsuario.setBounds(107, 91, 62, 14);
		frmRegistro.getContentPane().add(lblNewUsuario);
		
		lblNewPassword = new JLabel("Contrase\u00F1a");
		lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setBounds(95, 123, 75, 14);
		frmRegistro.getContentPane().add(lblNewPassword);
		
		lblNewPasswordRepetir = new JLabel("Repetir contrase\u00F1a");
		lblNewPasswordRepetir.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewPasswordRepetir.setBounds(44, 158, 125, 14);
		frmRegistro.getContentPane().add(lblNewPasswordRepetir);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textUsuario.setBounds(212, 89, 116, 20);
		frmRegistro.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);
		
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pfPassword.setBounds(212, 120, 116, 20);
		frmRegistro.getContentPane().add(pfPassword);
		
		pfPasswordRepetir = new JPasswordField();
		pfPasswordRepetir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pfPasswordRepetir.setBounds(212, 155, 116, 20);
		frmRegistro.getContentPane().add(pfPasswordRepetir);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(266, 216, 109, 23);
		frmRegistro.getContentPane().add(btnRegistro);
		frmRegistro.setVisible(true);
	}
	
	private void configureListeners() {
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});
		
		pfPasswordRepetir.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Para que al pulsar la tecla enter, te deje acceder
					registrarse();
				}
			}
		});
	}
	
	private void registrarse() {
		String passwd = new String(pfPassword.getPassword());
		String repetir = new String (pfPasswordRepetir.getPassword());
		if(passwd.equals(repetir) && !textUsuario.getText().equals("") && !passwd.equals("") && !repetir.equals("")) { //Cuando las constrañas coincidan y no haya ningun campo vacio
			Usuario usuario = new Usuario(textUsuario.getText(),passwd);
			Almacen.usuarios.add(usuario);
			//frmRegistro.setVisible(false);
			frmRegistro.dispose();
			new LoginView();
		} else {
			JOptionPane.showMessageDialog(btnRegistro, "La contraseña no coincide, vuelvelo a intentar");
		}
	}
}
