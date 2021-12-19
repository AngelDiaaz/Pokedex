package ui;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.Almacen;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.Tipo;
import models.Pokemon;

public class CrearView {

	private JFrame frmCrear;
	private JButton btnSalir;
	private JButton btnGuardar;
	private JFrame parent;
	private JLabel lblTipo;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JLabel lblFondo;
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
	private JComboBox cbTipo;
	private JLabel lblCrear;

	/**
	 * Create the application.
	 */
	public CrearView(JFrame parent) {
		this.parent = parent;
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

	private void configureUIComponents() {
		frmCrear = new JFrame();
		frmCrear.setIconImage(
				Toolkit.getDefaultToolkit().getImage(PokedexView.class.getResource("/image/icono app.png")));
		frmCrear.setTitle("Creacion");
		frmCrear.setBounds(100, 100, 734, 695);
		frmCrear.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrear.getContentPane().setLayout(null);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(50, 610, 129, 23);
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmCrear.getContentPane().add(btnSalir);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(550, 610, 147, 23);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmCrear.getContentPane().add(btnGuardar);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(34, 125, 46, 23);
		lblTipo.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblTipo);

		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(34, 260, 55, 25);
		lblPeso.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblPeso);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(190, 260, 71, 25);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblAltura);

		lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(190, 125, 95, 23);
		lblCategoria.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(34, 433, 81, 23);
		lblHabilidad.setFont(new Font("Verdana", Font.BOLD, 16));
		frmCrear.getContentPane().add(lblHabilidad);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PokedexView.class.getResource("/image/fondoblanco.jpg")));
		lblFondo.setBounds(10, 11, 604, 23);
		frmCrear.getContentPane().add(lblFondo);

		textPeso = new JTextField();
		textPeso.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPeso.setBounds(34, 323, 71, 41);
		frmCrear.getContentPane().add(textPeso);
		textPeso.setColumns(10);

		textAltura = new JTextField();
		textAltura.setFont(new Font("Verdana", Font.PLAIN, 15));
		textAltura.setBounds(190, 323, 71, 41);
		frmCrear.getContentPane().add(textAltura);
		textAltura.setColumns(10);

		textHabilidad = new JTextField();
		textHabilidad.setFont(new Font("Verdana", Font.PLAIN, 15));
		textHabilidad.setBounds(34, 489, 177, 41);
		frmCrear.getContentPane().add(textHabilidad);
		textHabilidad.setColumns(10);

		textCategoria = new JTextField();
		textCategoria.setFont(new Font("Verdana", Font.PLAIN, 15));
		textCategoria.setBounds(190, 174, 170, 39);
		frmCrear.getContentPane().add(textCategoria);
		textCategoria.setColumns(10);

		lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Verdana", Font.BOLD, 16));
		lblUrl.setBounds(261, 434, 64, 21);
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
		lblNombre.setBounds(441, 125, 101, 21);
		frmCrear.getContentPane().add(lblNombre);

		lblNumero = new JLabel("N\u00FAmero del pokemon");
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNumero.setBounds(350, 260, 187, 22);
		frmCrear.getContentPane().add(lblNumero);

		textNumero = new JTextField();
		textNumero.setFont(new Font("Verdana", Font.PLAIN, 15));
		textNumero.setBounds(350, 323, 129, 41);
		frmCrear.getContentPane().add(textNumero);
		textNumero.setColumns(10);

		lblCrear = new JLabel("Crear Pokemon");
		lblCrear.setFont(new Font("Verdana", Font.BOLD, 20));
		lblCrear.setBounds(269, 45, 177, 31);
		frmCrear.getContentPane().add(lblCrear);

		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Verdana", Font.PLAIN, 15));
		cbTipo.setModel(new DefaultComboBoxModel(Tipo.values()));
		cbTipo.setBounds(34, 174, 129, 39);
		frmCrear.getContentPane().add(cbTipo);

	}

	private void configureListeners() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrear.dispose();
				parent.setVisible(true);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearPokemon();

				frmCrear.dispose();
				parent.setVisible(true);
			}
		});
	}

	private void crearPokemon() {

		Almacen.pokemon.add(new Pokemon(Integer.parseInt(textNumero.getText()), textNombre.getText(),
				Tipo.valueOf(Tipo.class, cbTipo.getSelectedItem().toString()), Double.parseDouble(textPeso.getText()),
				Double.parseDouble(textAltura.getText()), textCategoria.getText(), textHabilidad.getText(),
				textUrl.getText()));

	}
}
