package ui;

import javax.swing.JFrame;

public class TallerView {

	private JFrame frmPokedex;
 	/**
	 * Create the application.
	 */
	public TallerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokedex = new JFrame();
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setBounds(100, 100, 450, 300);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(null);
		frmPokedex.setVisible(true);
	}

}
