package ui;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enums.Tipo;
import models.Pokemon;
import utils.Almacen;
import java.awt.Color;

public class ModificarView {
	
	//Propiedades
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
	private JComboBox cbTipo;
	private JLabel lblTitulo;

	/**
	 * Create the application.
	 */
	public ModificarView() {
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
		frmModificar.setBounds(100, 100, 734, 695);
		frmModificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificar.getContentPane().setLayout(null);

		btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 204, 51));
		btnSalir.setBounds(50, 610, 129, 23);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmModificar.getContentPane().add(btnSalir);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(102, 204, 0));
		btnGuardar.setBounds(550, 610, 147, 23);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmModificar.getContentPane().add(btnGuardar);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(34, 125, 46, 23);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblTipo);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(34, 260, 55, 25);
		lblPeso.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblPeso);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(190, 260, 71, 25);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblAltura);

		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(190, 125, 95, 23);
		lblCategoria.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(34, 433, 81, 23);
		lblHabilidad.setFont(new Font("Verdana", Font.BOLD, 16));
		frmModificar.getContentPane().add(lblHabilidad);

		textPeso = new JTextField();
		textPeso.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPeso.setBounds(34, 323, 71, 41);
		frmModificar.getContentPane().add(textPeso);
		textPeso.setColumns(10);

		textAltura = new JTextField();
		textAltura.setFont(new Font("Verdana", Font.PLAIN, 15));
		textAltura.setBounds(190, 323, 71, 41);
		frmModificar.getContentPane().add(textAltura);
		textAltura.setColumns(10);

		textHabilidad = new JTextField();
		textHabilidad.setFont(new Font("Verdana", Font.PLAIN, 15));
		textHabilidad.setBounds(34, 489, 177, 41);
		frmModificar.getContentPane().add(textHabilidad);
		textHabilidad.setColumns(10);

		textCategoria = new JTextField();
		textCategoria.setFont(new Font("Verdana", Font.PLAIN, 15));
		textCategoria.setBounds(190, 174, 170, 39);
		frmModificar.getContentPane().add(textCategoria);
		textCategoria.setColumns(10);

		lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Verdana", Font.BOLD, 16));
		lblUrl.setBounds(261, 434, 64, 21);
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
		lblNombre.setBounds(441, 125, 101, 21);
		frmModificar.getContentPane().add(lblNombre);

		lblNumero = new JLabel("N\u00FAmero del pokemon");
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNumero.setBounds(350, 260, 187, 22);
		frmModificar.getContentPane().add(lblNumero);

		textNumero = new JTextField();
		textNumero.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNumero.setBounds(350, 323, 129, 41);
		frmModificar.getContentPane().add(textNumero);
		textNumero.setColumns(10);

		lblTitulo = new JLabel("Modificar pokemon");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		lblTitulo.setBounds(269, 45, 214, 31);
		frmModificar.getContentPane().add(lblTitulo);

		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Verdana", Font.PLAIN, 15));
		cbTipo.setModel(new DefaultComboBoxModel(Tipo.values()));
		cbTipo.setBounds(34, 174, 129, 39);
		frmModificar.getContentPane().add(cbTipo);
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
				cambiar(PokedexView.getIndex());
				frmModificar.dispose();
				new PokedexView();
			}
		});
	}
	
	/**
	 * Muestra el pokemon seleccionado
	 * @param index Posicion del pokemon seleccionado
	 */

	private void verPokemon(int index) {

		cbTipo.setSelectedItem(Almacen.pokemon.get(index).getTipo());
		textNumero.setText((Almacen.pokemon.get(index).getNumero() + ""));
		textNombre.setText(Almacen.pokemon.get(index).getNombre());
		textPeso.setText(Almacen.pokemon.get(index).getPeso() + "");
		textAltura.setText(Almacen.pokemon.get(index).getAltura() + "");
		textHabilidad.setText(Almacen.pokemon.get(index).getHabilidad());
		textCategoria.setText(Almacen.pokemon.get(index).getCategoria());
		textUrl.setText(Almacen.pokemon.get(index).getUrl());

	}
	
	/**
	 * Sobreescribe los datos del pokemon seleccionado
	 * @param index Posicion del pokemon seleccionado
	 */

	private void cambiar(int index) {
		
		Almacen.pokemon.set(index,
				new Pokemon(Integer.parseInt(textNumero.getText()), textNombre.getText(),
						Tipo.valueOf(Tipo.class, cbTipo.getSelectedItem().toString()),
						Double.parseDouble(textPeso.getText()), Double.parseDouble(textAltura.getText()),
						textCategoria.getText(), textHabilidad.getText(), textUrl.getText()));

	}
}
