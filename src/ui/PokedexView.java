package ui;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;

import utils.Almacen;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Window.Type;

public class PokedexView {

	//Propiedades
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
	private JLabel lblVerTipo;
	private static int index = 0;
	private JLabel lblFoto;

	/**
	 * Create the application.
	 * 
	 * @param frmLogin
	 */
	public PokedexView() {
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
		frmPokedex.getContentPane().setBackground(new Color(153, 204, 204));
		frmPokedex.setIconImage(
				Toolkit.getDefaultToolkit().getImage(PokedexView.class.getResource("/image/icono app.png")));
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setBounds(100, 100, 782, 695);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(null);

		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setBounds(23, 610, 129, 23);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPokedex.getContentPane().add(btnCerrarSesion);

		btnCrear = new JButton("A\u00F1adir");
		btnCrear.setBounds(517, 610, 103, 23);
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPokedex.getContentPane().add(btnCrear);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(630, 610, 103, 23);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPokedex.getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(403, 610, 103, 23);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPokedex.getContentPane().add(btnEliminar);

		lblNombrePokemon = new JLabel("");
		lblNombrePokemon.setBounds(458, 103, 199, 53);
		lblNombrePokemon.setFont(new Font("Verdana", Font.BOLD, 22));
		frmPokedex.getContentPane().add(lblNombrePokemon);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(34, 125, 46, 23);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 16));
		frmPokedex.getContentPane().add(lblTipo);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(34, 260, 55, 25);
		lblPeso.setFont(new Font("Verdana", Font.BOLD, 16));
		frmPokedex.getContentPane().add(lblPeso);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(140, 261, 71, 25);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 16));
		frmPokedex.getContentPane().add(lblAltura);

		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(140, 125, 95, 23);
		lblCategoria.setFont(new Font("Verdana", Font.BOLD, 16));
		frmPokedex.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(34, 433, 81, 23);
		lblHabilidad.setFont(new Font("Verdana", Font.BOLD, 16));
		frmPokedex.getContentPane().add(lblHabilidad);

		lblNumero = new JLabel("");
		lblNumero.setBounds(377, 29, 115, 63);
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 20));
		frmPokedex.getContentPane().add(lblNumero);

		btnSiguiente = new JButton(">");
		btnSiguiente.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSiguiente.setBounds(645, 23, 88, 69);
		frmPokedex.getContentPane().add(btnSiguiente);

		btnAtras = new JButton("<");
		btnAtras.setFont(new Font("Verdana", Font.BOLD, 14));
		btnAtras.setBounds(23, 23, 82, 69);
		frmPokedex.getContentPane().add(btnAtras);

		lblVerPeso = new JLabel("");
		lblVerPeso.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblVerPeso.setBounds(34, 343, 50, 23);
		frmPokedex.getContentPane().add(lblVerPeso);

		lblVerAltura = new JLabel("");
		lblVerAltura.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblVerAltura.setBounds(140, 344, 55, 20);
		frmPokedex.getContentPane().add(lblVerAltura);

		lblVerHabilidad = new JLabel("");
		lblVerHabilidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVerHabilidad.setBounds(34, 495, 201, 33);
		frmPokedex.getContentPane().add(lblVerHabilidad);

		lblVerCategoria = new JLabel("");
		lblVerCategoria.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblVerCategoria.setBounds(140, 194, 95, 20);
		frmPokedex.getContentPane().add(lblVerCategoria);

		lblVerTipo = new JLabel("");
		lblVerTipo.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblVerTipo.setBounds(34, 194, 81, 20);
		frmPokedex.getContentPane().add(lblVerTipo);

		lblFoto = new JLabel("");
		lblFoto.setBounds(258, 145, 498, 439);
		frmPokedex.getContentPane().add(lblFoto);

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

				Almacen.pokemon.remove(index);

				if (index == 0) {
					verPokemon(0);
				} else {
					verPokemon(--index);
				}
			}

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
				verPokemon(++index);
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verPokemon(--index);
			}
		});
	}
	
	/**
	 * Te dice cual es la posicion que se encuentra el pokemon en el array list
	 * @return Posicion del pokemon seleccionado
	 */

	public static int getIndex() {

		return index;
	}
	
	/**
	 * Muestra el pokemon seleccionado
	 * @param index Posicion del pokemon seleccionado
	 */ 

	private void verPokemon(int index) {

		if (!Almacen.pokemon.isEmpty()) { //Si el array list de pokemon no esta vacio

			if (index == 0) { 
				btnAtras.setVisible(false); //Oculta el boton atras de la view
			} else {
				btnAtras.setVisible(true);
			}

			if (index == Almacen.pokemon.size() - 1) { //Cuando el index es la ultima posicion del array list
				btnSiguiente.setVisible(false); //Oculta el boton siguiente de la view
			} else {
				btnSiguiente.setVisible(true);
			}

			lblVerTipo.setText(Almacen.pokemon.get(index).getTipo() + "");
			lblNumero.setText(("Nº " + Almacen.pokemon.get(index).getNumero() + ""));
			lblNombrePokemon.setText(Almacen.pokemon.get(index).getNombre());
			lblVerPeso.setText(Almacen.pokemon.get(index).getPeso() + "");
			lblVerAltura.setText(Almacen.pokemon.get(index).getAltura() + "");
			lblVerHabilidad.setText(Almacen.pokemon.get(index).getHabilidad());
			lblVerCategoria.setText(Almacen.pokemon.get(index).getCategoria());

			//Sirve para inserta la imagen de los pokemon a través de una url
			BufferedImage img;
			try {
				img = ImageIO.read(new URL(Almacen.pokemon.get(index).getUrl()));
				lblFoto.setIcon(new javax.swing.ImageIcon(img));
			} catch (Exception e2) {
				lblFoto.setVisible(false);
			}
		} else {
			
			//Oculta los botones
			btnModificar.setVisible(false);
			btnEliminar.setVisible(false);

			//Te muestra la view con los campos vacios
			lblVerTipo.setText("");
			lblNumero.setText("Nº");
			lblNombrePokemon.setText("");
			lblVerPeso.setText("");
			lblVerAltura.setText("");
			lblVerHabilidad.setText("");
			lblVerCategoria.setText("");
			lblFoto.setVisible(false);

		}
	}

}
