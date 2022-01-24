package ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.PokemonDAO;
import models.Pokemon;
import java.awt.Color;

public class ModificarView {

	// Propiedades
	private JFrame frmModificar;
	private JButton btnSalir;
	private JButton btnGuardar;
	private JLabel lblTipo;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JLabel lblNumero;
	private JLabel lblNombre;
	private JLabel lblUrl;
	private JTextField textPeso;
	private JTextField textAltura;
	private JTextField textHabilidad;
	private JTextField textCategoria;
	private JTextField textUrl;
	private JTextField textNombre;
	private JTextField textNumero;
	private JComboBox<String> cbTipo1;
	private JComboBox<String> cbTipo2;
	private JLabel lblTitulo;
	private PokemonDAO pokemonDAO;
	private ArrayList<Pokemon> pokemons;

	/**
	 * Create the application.
	 */
	public ModificarView() {
		this.pokemonDAO = new PokemonDAO();
		this.pokemons = pokemonDAO.getAll();
		initialize();
		this.frmModificar.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
		verPokemon(PokedexView.getIndex());
	}

	/**
	 * Componentes del view
	 */

	private void configureUIComponents() {
		frmModificar = new JFrame();
		frmModificar.setBackground(Color.WHITE);
		frmModificar.getContentPane().setBackground(new Color(153, 204, 204));
		frmModificar.setIconImage(
				Toolkit.getDefaultToolkit().getImage(PokedexView.class.getResource("/image/icono app.png")));
		frmModificar.setTitle("Modificar");
		frmModificar.setBounds(100, 100, 734, 662);
		frmModificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificar.getContentPane().setLayout(null);

		btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 204, 51));
		btnSalir.setBounds(58, 565, 142, 33);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmModificar.getContentPane().add(btnSalir);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(102, 204, 0));
		btnGuardar.setBounds(513, 565, 142, 33);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmModificar.getContentPane().add(btnGuardar);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(155, 125, 46, 23);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblTipo);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(47, 260, 55, 25);
		lblPeso.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblPeso);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(186, 260, 71, 25);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblAltura);

		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(532, 261, 95, 23);
		lblCategoria.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(82, 433, 81, 23);
		lblHabilidad.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblHabilidad);

		textPeso = new JTextField();
		textPeso.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPeso.setBounds(34, 323, 71, 41);
		frmModificar.getContentPane().add(textPeso);
		textPeso.setColumns(10);

		textAltura = new JTextField();
		textAltura.setFont(new Font("Verdana", Font.PLAIN, 15));
		textAltura.setBounds(175, 323, 71, 41);
		frmModificar.getContentPane().add(textAltura);
		textAltura.setColumns(10);

		textHabilidad = new JTextField();
		textHabilidad.setFont(new Font("Verdana", Font.PLAIN, 15));
		textHabilidad.setBounds(34, 489, 177, 41);
		frmModificar.getContentPane().add(textHabilidad);
		textHabilidad.setColumns(10);

		textCategoria = new JTextField();
		textCategoria.setFont(new Font("Verdana", Font.PLAIN, 15));
		textCategoria.setBounds(499, 324, 170, 39);
		frmModificar.getContentPane().add(textCategoria);
		textCategoria.setColumns(10);

		lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Verdana", Font.BOLD, 16));
		lblUrl.setBounds(436, 434, 64, 21);
		frmModificar.getContentPane().add(lblUrl);

		textUrl = new JTextField();
		textUrl.setFont(new Font("Verdana", Font.PLAIN, 15));
		textUrl.setBounds(258, 489, 429, 41);
		frmModificar.getContentPane().add(textUrl);
		textUrl.setColumns(10);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNombre.setBounds(441, 174, 246, 39);
		frmModificar.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNombre.setBounds(526, 126, 101, 21);
		frmModificar.getContentPane().add(lblNombre);

		lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNumero.setBounds(343, 261, 81, 22);
		frmModificar.getContentPane().add(lblNumero);

		textNumero = new JTextField();
		textNumero.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNumero.setBounds(319, 323, 129, 41);
		frmModificar.getContentPane().add(textNumero);
		textNumero.setColumns(10);

		lblTitulo = new JLabel("Modificar pokemon");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 24));
		lblTitulo.setBounds(269, 43, 270, 33);
		frmModificar.getContentPane().add(lblTitulo);

		cbTipo1 = new JComboBox<String>();
		cbTipo1.setFont(new Font("Verdana", Font.PLAIN, 15));
		cbTipo1.setModel(new DefaultComboBoxModel<String>());
		cbTipo1.setBounds(34, 174, 129, 39);
		frmModificar.getContentPane().add(cbTipo1);
		
		cbTipo2 = new JComboBox<String>();
		cbTipo2.setFont(new Font("Verdana", Font.PLAIN, 15));
		cbTipo2.setBounds(190, 174, 129, 39);
		frmModificar.getContentPane().add(cbTipo2);
		
		
	}

	/**
	 * Acciones de los botones de la view
	 */

	private void configureListeners() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificar.dispose();
				new PokedexView();
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cambiar();
				frmModificar.dispose();
				new PokedexView();
			}
		});
	}

	/**
	 * Muestra el pokemon seleccionado
	 * 
	 * @param index Posicion del pokemon seleccionado
	 */

	private void verPokemon(int index) {

		cbTipo1.setSelectedItem(pokemons.get(index).getTipo1());
		textNumero.setText((pokemons.get(index).getNumero() + ""));
		textNombre.setText(pokemons.get(index).getNombre());
		textPeso.setText(pokemons.get(index).getPeso() + "");
		textAltura.setText(pokemons.get(index).getAltura() + "");
		textHabilidad.setText(pokemons.get(index).getHabilidad());
		textCategoria.setText(pokemons.get(index).getCategoria());
		textUrl.setText(pokemons.get(index).getUrl());

	}

	/**
	 * Modifica los datos de un pokemon
	 * 
	 * @return True si los ha modificado y false si no lo ha hecho
	 */

	private void cambiar() {
		Pokemon a = new Pokemon(Integer.parseInt(textNumero.getText()), textNombre.getText(), "",
				Double.parseDouble(textAltura.getText()), Double.parseDouble(textPeso.getText()),
				textCategoria.getText(), textHabilidad.getText(), textUrl.getText());

		pokemonDAO.modificar(a);

	}
}
