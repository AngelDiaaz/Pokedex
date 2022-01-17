package ui;

import java.awt.Font; 
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.PokemonDAO;
import models.Pokemon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class A�adirView {

	private JFrame frmA�adir;
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
	private PokemonDAO pokemonDAO;
	private ArrayList<Pokemon> pokemons;
	

	/**
	 * Create the application.
	 */
	public A�adirView(JFrame parent) {
		this.parent = parent;
		this.pokemonDAO = new PokemonDAO();
		this.pokemons = pokemonDAO.getAll();
		initialize();
		this.frmA�adir.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}
	
	private void configureUIComponents() {
		frmA�adir = new JFrame();
		frmA�adir.setIconImage(Toolkit.getDefaultToolkit().getImage(PokedexView.class.getResource("/image/icono app.png")));
		frmA�adir.setTitle("Pokedex");
		frmA�adir.setBounds(100, 100, 620, 550);
		frmA�adir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmA�adir.getContentPane().setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(62, 457, 147, 23);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmA�adir.getContentPane().add(btnSalir);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(387, 457, 147, 23);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmA�adir.getContentPane().add(btnGuardar);
		
		lblNombrePokemon = new JLabel(String.valueOf(pokemons.get(0).getNombre()));
		lblNombrePokemon.setBounds(359, 97, 199, 53);
		lblNombrePokemon.setFont(new Font("Verdana", Font.BOLD, 20));
		frmA�adir.getContentPane().add(lblNombrePokemon);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(34, 125, 46, 23);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 14));
		frmA�adir.getContentPane().add(lblTipo);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(34, 236, 55, 25);
		lblPeso.setFont(new Font("Verdana", Font.BOLD, 14));
		frmA�adir.getContentPane().add(lblPeso);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(140, 236, 55, 25);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 14));
		frmA�adir.getContentPane().add(lblAltura);
		
		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(140, 125, 81, 23);
		lblCategoria.setFont(new Font("Verdana", Font.BOLD, 14));
		frmA�adir.getContentPane().add(lblCategoria);
		
		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(34, 342, 71, 23);
		lblHabilidad.setFont(new Font("Verdana", Font.BOLD, 14));
		frmA�adir.getContentPane().add(lblHabilidad);
		
		lblNumero = new JLabel("N� " + String.valueOf(pokemons.get(0).getNumero()));
		lblNumero.setBounds(258, 29, 95, 34);
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 20));
		frmA�adir.getContentPane().add(lblNumero);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PokedexView.class.getResource("/image/fondoblanco.jpg")));
		lblFondo.setBounds(10, 11, 604, 511);
		frmA�adir.getContentPane().add(lblFondo);
	}
	
	private void configureListeners() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmA�adir.dispose();
				parent.setVisible(true);
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmA�adir.dispose();
				parent.setVisible(true);
			}
		});
	}
}
