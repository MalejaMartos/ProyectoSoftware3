package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;



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
public class principalAdministrador extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JToolBar jToolBar1;
	private JButton jButtonBuscarEstudiante;
	private JButton jButtonEliminarEstudiante;
	private JButton jButtonSalir;
	private JButton jButtonGenerarInforme;
	private JButton jButtonModificarAdmin;
	private JButton jButtonAgregarEstudiante;
	
	private JButton jButtonModificarEstudiante;

	/**
	 * Auto-generated main method to display this JFrame
	 */
//	public static void main(String[] args) {
//		/* estilo de la ventana*/
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				principalAdministrador inst = new principalAdministrador();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	/** Creacion de nueva ventana principal*/
	public principalAdministrador() {
		super();
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/Escudo.png"));
		setIconImage(icon);
		setVisible(true);
		initGUI();
		
		setTitle("PAE INSTITUTO MONTENEGRO-Administrador");
		this.setVisible(true);
	}

	private void initGUI() {
		try {
			setLocation(400, 20);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
			jToolBar1 = new JToolBar();
			jToolBar1.setBounds(0, 0, 1500, 50);
			getContentPane().add(jToolBar1);
			{
				jToolBar1.addSeparator();
				jButtonAgregarEstudiante = new JButton();
				jButtonAgregarEstudiante.setText("Agregar Estudiante");
				jButtonAgregarEstudiante.addActionListener(this);
				jToolBar1.add(jButtonAgregarEstudiante);
			}
			{
				jToolBar1.addSeparator();
				jButtonBuscarEstudiante = new JButton();
				jButtonBuscarEstudiante.setText("Buscar Estudiante");
				jButtonBuscarEstudiante.addActionListener(this);
				jToolBar1.add(jButtonBuscarEstudiante);
			}
			{
				jToolBar1.addSeparator();
				jButtonModificarEstudiante = new JButton();
				getContentPane().add(jButtonModificarEstudiante);
				jButtonModificarEstudiante.setText("Modificar Estudiante");
				jButtonModificarEstudiante.addActionListener(this);
				jToolBar1.add(jButtonModificarEstudiante);
			}
			{
				jToolBar1.addSeparator();
				jButtonEliminarEstudiante = new JButton();
				jButtonEliminarEstudiante.setText("Eliminar Estudiante");
				jButtonEliminarEstudiante.addActionListener(this);
				jToolBar1.add(jButtonEliminarEstudiante);
			}
			{
				jToolBar1.addSeparator();
				jButtonModificarAdmin = new JButton();
				getContentPane().add(jButtonModificarAdmin);
				jButtonModificarAdmin.setText("Modificar mi Informacion");
				jButtonModificarAdmin.addActionListener(this);
				jToolBar1.add(jButtonModificarAdmin);
			}
			{
				jToolBar1.addSeparator();
				jButtonGenerarInforme = new JButton();
				jButtonGenerarInforme.setText("Generar Informe");
				jButtonGenerarInforme.addActionListener(this);
				jToolBar1.add(jButtonGenerarInforme);
			}
			{
				jToolBar1.addSeparator();
				jButtonSalir = new JButton();
				jButtonSalir.setText("Salir");
				jButtonSalir.addActionListener(this);
				jToolBar1.add(jButtonSalir);
			}
			
			pack();
			this.setSize(850, 80);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == jButtonAgregarEstudiante) {
			crearEstudiante c = new crearEstudiante();
			c.setVisible(true);
		}
		if (e.getSource() == jButtonBuscarEstudiante) {
			buscarEstudiante b = new buscarEstudiante();
			b.setVisible(true);
		}
		if (e.getSource() == jButtonEliminarEstudiante) {
			eliminarEstudiante e1 = new eliminarEstudiante();
			e1.setVisible(true);
		}
		if (e.getSource() == jButtonModificarEstudiante) {
			modificarEstudiante m = new modificarEstudiante();
			m.setVisible(true);
		}
		if (e.getSource() == jButtonModificarAdmin) {
			modificarAdministrador a = new modificarAdministrador();
			a.setVisible(true);
			
		}
		if (e.getSource() == jButtonGenerarInforme) {
			generarInforme m = new generarInforme();
			m.setVisible(true);
		}
		if (e.getSource() == jButtonSalir) {
			principalAplicacion principal = new principalAplicacion();
			principal.setVisible(true);
			this.dispose();
		}

	}

}
