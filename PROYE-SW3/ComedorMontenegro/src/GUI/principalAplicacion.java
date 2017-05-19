package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.WindowConstants;


import javax.swing.SwingUtilities;
import javax.swing.UIManager;



/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class principalAplicacion extends javax.swing.JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelBienvenido;
	private JLabel jLabelDescripcion;
	private JButton jButtonEstudiante;
	private JButton jButtonAdministrador;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		/* Estilo de la ventana */
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				principalAplicacion inst = new principalAplicacion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public principalAplicacion() {
		super();
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/Escudo.png"));
		setIconImage(icon);
		setVisible(true);
		initGUI();
	}

	private void initGUI() {
		try {
			setLocation(400, 250);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			setTitle("COMEDOR INSTITUTO MONTENEGRO");
			{
				jLabelBienvenido = new JLabel();
				getContentPane().add(jLabelBienvenido);
				jLabelBienvenido.setText("Bienvenido a COMEDOR INSTITUTO MONTENEGRO");
				jLabelBienvenido.setBounds(50, 28, 300, 34);
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Para acceder elija la su perfil");
				jLabelDescripcion.setBounds(120, 68, 224, 43);
			}
			{
				jButtonAdministrador = new JButton();
				getContentPane().add(jButtonAdministrador);
				jButtonAdministrador.setText("Administrador");
				jButtonAdministrador.setBounds(39, 170, 141, 48);
				jButtonAdministrador.addActionListener(this);

			}
			{
				jButtonEstudiante = new JButton();
				getContentPane().add(jButtonEstudiante);
				jButtonEstudiante.setText("Estudiante");
				jButtonEstudiante.setBounds(213, 170, 141, 48);
				jButtonEstudiante.addActionListener(this);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jButtonAdministrador) {
			LogInAdmin login = new LogInAdmin();
			login.setVisible(true);
			this.dispose();
		}
		if (e.getSource() == jButtonEstudiante) {
			logInEstudiante login1 = new logInEstudiante();
			login1.setVisible(true);
			this.dispose();
		}

	}

}
