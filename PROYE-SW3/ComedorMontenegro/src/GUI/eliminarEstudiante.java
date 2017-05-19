package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import Logic.dataConnection;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

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
public class eliminarEstudiante extends javax.swing.JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelEliminarEstudiante;
	private JButton jButtonEliminarEstudiante;
	private JTextField jTextFieldDocumento;
	private JLabel jLabelintro2;
	private JLabel jLabelIntro;
	private JButton jButtonAtras;


	PreparedStatement pst;
	Connection cn;
	ResultSet resul;

	public eliminarEstudiante() {
		super();
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/Escudo.png"));
		setIconImage(icon);
		setVisible(true);
		initGUI();
	}

	private void initGUI() {
		try {
			setTitle("PAE Instituto Montenegro-Eliminar Estudiante");
			setLocation(400, 250);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelEliminarEstudiante = new JLabel();
				getContentPane().add(jLabelEliminarEstudiante);
				jLabelEliminarEstudiante.setText("Eliminar Estudiante");
				jLabelEliminarEstudiante.setBounds(155, 26, 176, 26);
			}
			{
				jLabelIntro = new JLabel();
				getContentPane().add(jLabelIntro);
				jLabelIntro.setText("Recuerda: Al eliminar un estudiante  no puede recuperar su informaci�n.");
				jLabelIntro.setBounds(18, 70, 397, 34);
			}
			{
				jLabelintro2 = new JLabel();
				getContentPane().add(jLabelintro2);
				jLabelintro2.setText("Ingrese Documento:");
				jLabelintro2.setBounds(24, 132, 138, 27);
			}
			{
				jTextFieldDocumento = new JTextField();
				getContentPane().add(jTextFieldDocumento);
				jTextFieldDocumento.setBounds(208, 132, 145, 23);
			}
			{
				jButtonEliminarEstudiante = new JButton();
				getContentPane().add(jButtonEliminarEstudiante);
				jButtonEliminarEstudiante.setText("Eliminar Estudiante");
				jButtonEliminarEstudiante.setBounds(135, 205, 141, 31);
				jButtonEliminarEstudiante.addActionListener(this);
			}
			{
				jButtonAtras = new JButton();
				jButtonAtras.setIcon(new ImageIcon(LogInAdmin.class.getResource("/imagen/atras.png")));
				getContentPane().add(jButtonAtras);
				jButtonAtras.setBounds(360, 200, 40, 40);
				jButtonAtras.setBorderPainted(false);
				jButtonAtras.addActionListener(this);
			}
			pack();
			this.setSize(436, 311);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jButtonEliminarEstudiante) {
			int documento = Integer.parseInt(jTextFieldDocumento.getText());
			cn = dataConnection.conexion();
			try {
				pst = cn.prepareStatement("delete from estudiante where documento=?");
				pst.setInt(1, documento);
				int res = pst.executeUpdate();
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "Estudiante eliminado satisfractoriamente");
					limpiar();
				} else {
					JOptionPane.showMessageDialog(null, "el estudiante nn existe");
					limpiar();
				}
				cn.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jButtonAtras) {
			this.dispose();
		}

	}

	public void limpiar() {
		jTextFieldDocumento.setText(" ");
	}

}
