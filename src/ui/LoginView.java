package ui;

import javax.swing.JFrame; 
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import models.Usuario;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LoginView {

	//Propiedades
	private JFrame frmLogin;
	private JLabel lblTitulo;
	private JTextField tfUsuario;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JButton btnEntrar;
	private JPasswordField pfPassword;
	private JButton btnRegistro;
	private JButton btnSalir;
	private JLabel lblFondoLogin;
	private UsuarioDAO usuarioDAO;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		this.frmLogin.setVisible(true);
		usuarioDAO = new UsuarioDAO();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(153, 204, 204));
		frmLogin.getContentPane().setForeground(Color.WHITE);
		configureUIComponents();
		configureListeners();
	}
	
	/**
	 * Componentes del view
	 */

	private void configureUIComponents() {
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/image/icono app.png")));
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(LoginView.class.getResource("/image/login pokemon.png")));
		lblTitulo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 30));
		lblTitulo.setBounds(10, 11, 414, 90);
		frmLogin.getContentPane().add(lblTitulo);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUsuario.setBounds(61, 115, 81, 20);
		frmLogin.getContentPane().add(lblUsuario);

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfUsuario.setBounds(170, 115, 150, 20);
		frmLogin.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);

		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setBounds(58, 160, 84, 20);
		frmLogin.getContentPane().add(lblPassword);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(102, 204, 0));

		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEntrar.setBounds(306, 221, 107, 29);
		frmLogin.getContentPane().add(btnEntrar);

		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pfPassword.setBounds(170, 160, 150, 20);
		frmLogin.getContentPane().add(pfPassword);
		
		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(new Color(255, 204, 51));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(183, 221, 107, 29);
		frmLogin.getContentPane().add(btnRegistro);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 102, 102));
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(35, 221, 107, 29);
		frmLogin.getContentPane().add(btnSalir);
		
		lblFondoLogin = new JLabel("");
		lblFondoLogin.setIcon(new ImageIcon(LoginView.class.getResource("/image/fondo login.png")));
		lblFondoLogin.setBounds(0, 0, 481, 326);
		frmLogin.getContentPane().add(lblFondoLogin);
	}
	
	/**
	 * Acciones de los botones del view
	 */

	private void configureListeners() {
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarLogin();
			}
		});
		pfPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Para que al pulsar la tecla enter, te deje acceder
					comprobarLogin();
				}
			}
		});
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setVisible(false); //Te hace invisible la pesta�a del login
				new RegistroView(frmLogin); // Te muestra la pesta�a de registro
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * Comprueba si el usuario y la contrase�a coincide con lo que tenemos registrado
	 */

	private void comprobarLogin() {
		String usuario = tfUsuario.getText();
		String password = new String(pfPassword.getPassword());
		boolean loginCorrecto = usuarioDAO.login(new Usuario(usuario,password));
		if (loginCorrecto) {
			frmLogin.setVisible(false);
			new PokedexView();
		} else {
			JOptionPane.showMessageDialog(btnEntrar, "Login incorrecto");
		}
	}
}
