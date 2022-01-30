package ui;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import dao.PokemonDAO;
import dao.TipoDAO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import models.Pokemon;
import models.Tipos;

import java.awt.Color;

public class CrearView {

	// Propiedades
	private JFrame frmCrear;
	private JButton btnSalir;
	private JButton btnGuardar;
	private JLabel lblTipo;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JTextField textPeso;
	private JTextField textAltura;
	private JTextField textHabilidad;
	private JTextField textCategoria;
	private JTextField textUrl;
	private JTextField textNombre;
	private JTextField textNumero;
	private JLabel lblUrl;
	private JLabel lblNombre;
	private JLabel lblNumero;
	private JComboBox<String> cbTipo1;
	private JComboBox<String> cbTipo2;
	private JLabel lblCrear;
	private PokemonDAO pokemonDAO;
	private ArrayList<Pokemon> pokemons;
	private TipoDAO tipoDAO;
	private ArrayList<Tipos> tipos;

	/**
	 * Create the application.
	 */
	public CrearView() {
		this.pokemonDAO = new PokemonDAO();
		this.pokemons = pokemonDAO.getAll();
		this.tipoDAO = new TipoDAO();
		this.tipos = tipoDAO.getAll();
		initialize();
		this.frmCrear.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
	}

	/**
	 * Componentes del view
	 */

	private void configureUIComponents() {
		frmCrear = new JFrame();
		frmCrear.getContentPane().setBackground(new Color(153, 204, 204));
		frmCrear.setIconImage(
				Toolkit.getDefaultToolkit().getImage(PokedexView.class.getResource("/image/icono app.png")));
		frmCrear.setTitle("Creacion");
		frmCrear.setBounds(100, 100, 734, 662);
		frmCrear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrear.getContentPane().setLayout(null);

		btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 204, 51));
		btnSalir.setBounds(58, 563, 142, 33);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmCrear.getContentPane().add(btnSalir);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(102, 204, 0));
		btnGuardar.setBounds(520, 563, 142, 33);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmCrear.getContentPane().add(btnGuardar);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(154, 124, 46, 23);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblTipo);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(50, 260, 55, 25);
		lblPeso.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblPeso);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(177, 260, 71, 25);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblAltura);

		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(527, 261, 95, 23);
		lblCategoria.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(82, 433, 81, 23);
		lblHabilidad.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblHabilidad);

		textPeso = new JTextField();
		textPeso.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPeso.setBounds(34, 323, 71, 41);
		frmCrear.getContentPane().add(textPeso);
		textPeso.setColumns(10);

		textAltura = new JTextField();
		textAltura.setFont(new Font("Verdana", Font.PLAIN, 15));
		textAltura.setBounds(167, 323, 71, 41);
		frmCrear.getContentPane().add(textAltura);
		textAltura.setColumns(10);

		textHabilidad = new JTextField();
		textHabilidad.setFont(new Font("Verdana", Font.PLAIN, 15));
		textHabilidad.setBounds(34, 489, 177, 41);
		frmCrear.getContentPane().add(textHabilidad);
		textHabilidad.setColumns(10);

		textCategoria = new JTextField();
		textCategoria.setFont(new Font("Verdana", Font.PLAIN, 15));
		textCategoria.setBounds(497, 324, 170, 39);
		frmCrear.getContentPane().add(textCategoria);
		textCategoria.setColumns(10);

		lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Verdana", Font.BOLD, 16));
		lblUrl.setBounds(441, 434, 64, 21);
		frmCrear.getContentPane().add(lblUrl);

		textUrl = new JTextField();
		textUrl.setFont(new Font("Verdana", Font.PLAIN, 15));
		textUrl.setBounds(258, 489, 429, 41);
		frmCrear.getContentPane().add(textUrl);
		textUrl.setColumns(10);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNombre.setBounds(441, 174, 246, 39);
		frmCrear.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNombre.setBounds(521, 125, 101, 21);
		frmCrear.getContentPane().add(lblNombre);

		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNumero.setBounds(333, 261, 87, 22);
		frmCrear.getContentPane().add(lblNumero);

		textNumero = new JTextField();
		textNumero.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNumero.setBounds(308, 323, 129, 41);
		frmCrear.getContentPane().add(textNumero);
		textNumero.setColumns(10);

		lblCrear = new JLabel("Crear Pokemon");
		lblCrear.setFont(new Font("Verdana", Font.BOLD, 24));
		lblCrear.setBounds(269, 43, 216, 33);
		frmCrear.getContentPane().add(lblCrear);

		cbTipo1 = new JComboBox<String>();
		cbTipo1.setFont(new Font("Verdana", Font.PLAIN, 15));
		cbTipo1.setModel(new DefaultComboBoxModel<String>());
		cbTipo1.setBounds(34, 174, 129, 39);
		frmCrear.getContentPane().add(cbTipo1);

		cbTipo2 = new JComboBox<String>();
		cbTipo2.setFont(new Font("Verdana", Font.PLAIN, 15));
		cbTipo2.setBounds(196, 174, 129, 39);
		frmCrear.getContentPane().add(cbTipo2);
		fillTipos();

	}

	/**
	 * Acciones de los botones del view
	 */

	private void configureListeners() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrear.dispose(); // Elimina la view Crear
				new PokedexView(); // Te abre una nueva view de pokedex
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearPokemon();
				frmCrear.dispose();
				new PokedexView();
			}
		});
	}

	/**
	 * Crea un pokemon nuevo y la agrega en la pokedex
	 */

	private void crearPokemon() {
		boolean repetido = false;

		for (Pokemon pokemon : pokemons) {
			if (pokemon.getNombre().equalsIgnoreCase(textNombre.getText())
					|| pokemon.getNumero() == Integer.parseInt(textNumero.getText())) { // Si el nombre o el numero
																						// coincide con uno de los
																						// pokemon ya creados en el
																						// array list
				repetido = true;
			}
		}

		if (!repetido) { // Si repetido es false

			Pokemon a = new Pokemon(Integer.parseInt(textNumero.getText()), textNombre.getText(),
					Double.parseDouble(textAltura.getText()), Double.parseDouble(textPeso.getText()),
					textCategoria.getText(), textHabilidad.getText(), textUrl.getText());

			Tipos tipo1 = tipos.get(cbTipo1.getSelectedIndex());
			Tipos tipo2 = tipos.get(cbTipo2.getSelectedIndex());
			a.setTipo1(tipo1);
			a.setTipo2(tipo2);
			if (cbTipo1.getSelectedItem() == cbTipo2.getSelectedItem()) {
				JOptionPane.showMessageDialog(null, "No puedes elegir el mismo tipo dos veces");
			} else {
				pokemonDAO.registrar(a);
			}

			JOptionPane.showMessageDialog(frmCrear, "El pokemon " + a.getNombre() + " se ha registrado en la pokedex");

		} else {
			JOptionPane.showMessageDialog(frmCrear, "El pokemon ya esta registrado en la pokedex");
		}
	}

	/**
	 * Almacena todos los tipos de los pokemons que estan en la base de datos en un
	 * array list y luego te los devuelve
	 */

	private void fillTipos() {
		cbTipo1.addItem("Ninguno");
		cbTipo2.addItem("Ninguno");

		for (Tipos tipo : tipos) {
			cbTipo1.addItem(tipo.getNombre());
			cbTipo2.addItem(tipo.getNombre()); // Min video clase 1:28:0
		}

	}
}
