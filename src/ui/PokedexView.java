package ui;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.PokemonDAO;
import models.Pokemon;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PokedexView {

	// Propiedades
	private JFrame frmPokedex;
	private JButton btnCerrarSesion;
	private JButton btnCrear;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNombrePokemon;
	private JLabel lblTipo;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JLabel lblNumero;
	private JButton btnSiguiente;
	private JButton btnAtras;
	private JLabel lblVerPeso;
	private JLabel lblVerAltura;
	private JLabel lblVerHabilidad;
	private JLabel lblVerCategoria;
	private JLabel lblVerTipo1;
	private JLabel lblPokedexFondo;
	private JLabel lblVerTipo2;
	private static int index = 0;
	private JLabel lblFoto;
	private PokemonDAO pokemonDAO;
	private ArrayList<Pokemon> pokemons;

	/**
	 * Create the application.
	 * 
	 * @param frmLogin
	 */
	public PokedexView() {
		this.pokemonDAO = new PokemonDAO();
		this.pokemons = pokemonDAO.getAll();
		initialize();
		frmPokedex.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configureUIComponents();
		configureListeners();
		verPokemon(index);
	}

	/**
	 * Componentes del view
	 */

	private void configureUIComponents() {
		frmPokedex = new JFrame();
		frmPokedex.getContentPane().setBackground(new Color(255, 255, 255));
		frmPokedex.setIconImage(
				Toolkit.getDefaultToolkit().getImage(PokedexView.class.getResource("/image/icono app.png")));
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setBounds(100, 100, 856, 752);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(null);

		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setBackground(new Color(255, 204, 51));
		btnCerrarSesion.setBounds(37, 659, 142, 33);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPokedex.getContentPane().add(btnCerrarSesion);

		btnCrear = new JButton("A\u00F1adir");
		btnCrear.setBackground(new Color(51, 153, 153));
		btnCrear.setBounds(518, 659, 134, 33);
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPokedex.getContentPane().add(btnCrear);

		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(51, 153, 204));
		btnModificar.setBounds(662, 659, 134, 33);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPokedex.getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 102, 102));
		btnEliminar.setBounds(374, 659, 134, 33);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPokedex.getContentPane().add(btnEliminar);

		lblNombrePokemon = new JLabel("");
		lblNombrePokemon.setBounds(505, 103, 199, 53);
		lblNombrePokemon.setFont(new Font("Verdana", Font.BOLD, 24));
		frmPokedex.getContentPane().add(lblNombrePokemon);

		lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(37, 206, 55, 25);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 18));
		frmPokedex.getContentPane().add(lblTipo);

		lblPeso = new JLabel("Peso");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setBounds(37, 398, 55, 25);
		lblPeso.setFont(new Font("Verdana", Font.BOLD, 18));
		frmPokedex.getContentPane().add(lblPeso);

		lblAltura = new JLabel("Altura");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setBounds(140, 398, 71, 25);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 18));
		frmPokedex.getContentPane().add(lblAltura);

		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setBounds(37, 297, 115, 31);
		lblCategoria.setFont(new Font("Verdana", Font.BOLD, 18));
		frmPokedex.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setForeground(Color.WHITE);
		lblHabilidad.setBounds(37, 485, 115, 25);
		lblHabilidad.setFont(new Font("Verdana", Font.BOLD, 18));
		frmPokedex.getContentPane().add(lblHabilidad);

		lblNumero = new JLabel("");
		lblNumero.setBounds(393, 29, 115, 63);
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 22));
		frmPokedex.getContentPane().add(lblNumero);

		btnSiguiente = new JButton(">");
		btnSiguiente.setForeground(new Color(255, 255, 255));
		btnSiguiente.setBackground(new Color(220, 20, 60));
		btnSiguiente.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSiguiente.setBounds(730, 23, 88, 69);
		frmPokedex.getContentPane().add(btnSiguiente);

		btnAtras = new JButton("<");
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setBackground(new Color(220, 20, 60));
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 14));
		btnAtras.setBounds(23, 23, 82, 69);
		frmPokedex.getContentPane().add(btnAtras);

		lblVerPeso = new JLabel("");
		lblVerPeso.setForeground(Color.WHITE);
		lblVerPeso.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblVerPeso.setBounds(37, 441, 50, 23);
		frmPokedex.getContentPane().add(lblVerPeso);

		lblVerAltura = new JLabel("");
		lblVerAltura.setForeground(Color.WHITE);
		lblVerAltura.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblVerAltura.setBounds(140, 441, 71, 25);
		frmPokedex.getContentPane().add(lblVerAltura);

		lblVerHabilidad = new JLabel("");
		lblVerHabilidad.setForeground(Color.WHITE);
		lblVerHabilidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVerHabilidad.setBounds(37, 528, 201, 33);
		frmPokedex.getContentPane().add(lblVerHabilidad);

		lblVerCategoria = new JLabel("");
		lblVerCategoria.setForeground(Color.WHITE);
		lblVerCategoria.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblVerCategoria.setBounds(37, 352, 142, 25);
		frmPokedex.getContentPane().add(lblVerCategoria);

		lblVerTipo1 = new JLabel("");
		lblVerTipo1.setForeground(Color.WHITE);
		lblVerTipo1.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblVerTipo1.setBounds(37, 242, 95, 32);
		frmPokedex.getContentPane().add(lblVerTipo1);

		lblVerTipo2 = new JLabel("");
		lblVerTipo2.setForeground(Color.WHITE);
		lblVerTipo2.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblVerTipo2.setBounds(161, 242, 95, 32);
		frmPokedex.getContentPane().add(lblVerTipo2);

		lblFoto = new JLabel("");
		lblFoto.setBounds(308, 194, 498, 439);
		frmPokedex.getContentPane().add(lblFoto);

		lblPokedexFondo = new JLabel("");
		lblPokedexFondo.setIcon(new ImageIcon(PokedexView.class.getResource("/image/fondo pokedex.png")));
		lblPokedexFondo.setBounds(21, 127, 268, 513);
		frmPokedex.getContentPane().add(lblPokedexFondo);

	}

	/**
	 * Acciones de los botones del view
	 */

	private void configureListeners() {
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.dispose();
				new LoginView();
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resp = JOptionPane.showConfirmDialog(frmPokedex,
						"�Quieres eliminar a " + pokemons.get(index).getNombre() + " de la pokedex?");
				if (JOptionPane.OK_OPTION == resp) {
					System.out.println("Selecciona opci�n Afirmativa");
					pokemonDAO.eliminar(pokemons.get(index));
					frmPokedex.dispose();
					new PokedexView();

				} else {
					System.out.println("No selecciona una opci�n afirmativa");
				}

//				if (index == 0) {
//					verPokemon(0);
//				} else {
//					verPokemon(--index);
//				}
			}// Mirar cuando este vacio la pokedex

		});

		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new CrearView();
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new ModificarView();
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index == pokemons.size()) { // Cuando el index es la ultima posicion del array list
					index = 0;
				}
				verPokemon(index);
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index--;
				if (index < 0) {
					index = pokemons.size() - 1;
				}
				verPokemon(index);
			}
		});
	}

	/**
	 * Te dice cual es la posicion que se encuentra el pokemon en el array list
	 * 
	 * @return Posicion del pokemon seleccionado
	 */

	public static int getIndex() {

		return index;
	}

	/**
	 * Muestra el pokemon seleccionado
	 * 
	 * @param index Posicion del pokemon seleccionado
	 */

	private void verPokemon(int index) {

		if (!pokemons.isEmpty()) { // Si el array list de pokemon no esta vacio

//			if (index == 0) { 
//				btnAtras.setVisible(false); //Oculta el boton atras de la view
//			} else {
//				btnAtras.setVisible(true);
//			}
//
//			if (index == pokemons.size() - 1) { //Cuando el index es la ultima posicion del array list
//				btnSiguiente.setVisible(false); //Oculta el boton siguiente de la view
//			} else {
//				btnSiguiente.setVisible(true);
//			}

			lblVerTipo1.setText(pokemons.get(index).getTipo1().getNombre());
			if(!pokemons.get(index).getTipo2().getNombre().equalsIgnoreCase("Ninguno")) {
				lblVerTipo2.setText(pokemons.get(index).getTipo2().getNombre());
			} else { //Para que cuando escojamos ninguno en el jcombox no se muestre en la pokedex
				lblVerTipo2.setVisible(false);
			}
			lblNumero.setText(("N� " + pokemons.get(index).getNumero() + ""));
			lblNombrePokemon.setText(pokemons.get(index).getNombre());
			lblVerPeso.setText(pokemons.get(index).getPeso() + "");
			lblVerAltura.setText(pokemons.get(index).getAltura() + "");
			lblVerHabilidad.setText(pokemons.get(index).getHabilidad());
			lblVerCategoria.setText(pokemons.get(index).getCategoria());

			// pokemonDAO.infoPokemon();

			// Sirve para inserta la imagen de los pokemon a trav�s de una url
			BufferedImage img;
			try {
				img = ImageIO.read(new URL(pokemons.get(index).getUrl()));
				lblFoto.setIcon(new javax.swing.ImageIcon(img));
			} catch (Exception e2) {
				lblFoto.setVisible(false);
			}
		} else {

			// Oculta los botones
			btnModificar.setVisible(false);
			btnEliminar.setVisible(false);

			// Te muestra la view con los campos vacios
			lblVerTipo1.setText("");
			lblVerTipo2.setText("");
			lblNumero.setText("N�");
			lblNombrePokemon.setText("");
			lblVerPeso.setText("");
			lblVerAltura.setText("");
			lblVerHabilidad.setText("");
			lblVerCategoria.setText("");
			lblFoto.setVisible(false);

		}
	}
}
