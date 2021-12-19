package ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.Almacen;

public class ModificarView {

	private JFrame frmModificar;
	private JButton btnSalir;
	private JButton btnGuardar;
	private JFrame parent;
	private JLabel lblNombrePokemon;
	private JLabel lblTipo;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JLabel lblNumero;
	private JLabel lblFondo;

	/**
	 * Create the application.
	 */
	public ModificarView(JFrame parent) {
		this.parent = parent;
		initialize();
		this.frmModificar.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}
	
	private void configureUIComponents() {
		frmModificar = new JFrame();
		frmModificar.setIconImage(Toolkit.getDefaultToolkit().getImage(PokedexView.class.getResource("/image/icono app.png")));
		frmModificar.setTitle("Pokedex");
		frmModificar.setBounds(100, 100, 620, 550);
		frmModificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificar.getContentPane().setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(62, 457, 147, 23);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmModificar.getContentPane().add(btnSalir);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(387, 457, 147, 23);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmModificar.getContentPane().add(btnGuardar);
		
		lblNombrePokemon = new JLabel(String.valueOf(Almacen.pokemon.get(0).getNombre()));
		lblNombrePokemon.setBounds(359, 97, 199, 53);
		lblNombrePokemon.setFont(new Font("Verdana", Font.BOLD, 20));
		frmModificar.getContentPane().add(lblNombrePokemon);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(34, 125, 46, 23);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 14));
		frmModificar.getContentPane().add(lblTipo);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(34, 236, 55, 25);
		lblPeso.setFont(new Font("Verdana", Font.BOLD, 14));
		frmModificar.getContentPane().add(lblPeso);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(140, 236, 55, 25);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 14));
		frmModificar.getContentPane().add(lblAltura);
		
		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(140, 125, 81, 23);
		lblCategoria.setFont(new Font("Verdana", Font.BOLD, 14));
		frmModificar.getContentPane().add(lblCategoria);
		
		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(34, 342, 71, 23);
		lblHabilidad.setFont(new Font("Verdana", Font.BOLD, 14));
		frmModificar.getContentPane().add(lblHabilidad);
		
		lblNumero = new JLabel("Nº " + String.valueOf(Almacen.pokemon.get(0).getNumero()));
		lblNumero.setBounds(258, 29, 95, 34);
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 20));
		frmModificar.getContentPane().add(lblNumero);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PokedexView.class.getResource("/image/fondoblanco.jpg")));
		lblFondo.setBounds(10, 11, 604, 511);
		frmModificar.getContentPane().add(lblFondo);
	}
	
	private void configureListeners() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificar.dispose();
				parent.setVisible(true);
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificar.dispose();
				parent.setVisible(true);
			}
		});
	}

}
