package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;


import Logic.dataConnection;

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
public class LogInAdmin extends javax.swing.JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabel;
	private JLabel jLabelPassword;
	private JButton jButtonIngresar;
	private JTextField jTextFieldNickname;
	private JLabel jLabelNickname;
	private JLabel jLabelIntro;
	private JButton jButtonAtras;
	private JPasswordField jPasswordFieldContrasena;

	Connection cn;
	PreparedStatement pst;
	ResultSet rst;

	public LogInAdmin() {
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
			{
				jLabel = new JLabel();
				getContentPane().add(jLabel);
				jLabel.setText("LogIn Administrador");
				jLabel.setBounds(136, 30, 167, 30);
			}
			{
				jLabelIntro = new JLabel();
				getContentPane().add(jLabelIntro);
				jLabelIntro.setText("Ingrese el nick del administrador y su contrase�a");
				jLabelIntro.setBounds(60, 77, 360, 26);
			}
			{
				jLabelNickname = new JLabel();
				getContentPane().add(jLabelNickname);
				jLabelNickname.setText("Nickname");
				jLabelNickname.setBounds(22, 130, 118, 30);
			}
			{
				jTextFieldNickname = new JTextField();
				getContentPane().add(jTextFieldNickname);
				jTextFieldNickname.setBounds(173, 130, 160, 30);
			}
			{
				jLabelPassword = new JLabel();
				getContentPane().add(jLabelPassword);
				jLabelPassword.setText("Contrase�a:");
				jLabelPassword.setBounds(22, 175, 118, 30);
			}
			{
				jPasswordFieldContrasena = new JPasswordField();
				getContentPane().add(jPasswordFieldContrasena);
				jPasswordFieldContrasena.setBounds(173, 172, 160, 30);
			}
			{
				jButtonIngresar = new JButton();
				getContentPane().add(jButtonIngresar);
				jButtonIngresar.setText("Ingresar");
				jButtonIngresar.setBounds(140, 218, 138, 30);
				jButtonIngresar.addActionListener(this);
			}
			{
				jButtonAtras = new JButton();
				jButtonAtras.setIcon(new ImageIcon(LogInAdmin.class.getResource("/imagen/atras.png")));
				getContentPane().add(jButtonAtras);
				jButtonAtras.setBounds(315, 12, 36, 30);
				jButtonAtras.addActionListener(this);
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

		if (e.getSource() == jButtonAtras) {
			principalAplicacion p = new principalAplicacion();
			p.setVisible(true);
			this.dispose();
		}

		if (e.getSource() == jButtonIngresar) {
			String nickname = jTextFieldNickname.getText();
			char[] arrayC = jPasswordFieldContrasena.getPassword(); 
			String password = new String(arrayC);
			cn = dataConnection.conexion();
			try {
				pst = cn.prepareStatement("select * from administrador where nickname=? and password=?");
				pst.setString(1, nickname);
				pst.setString(2, password);
				rst = pst.executeQuery();

				if (rst.next()) {
					JOptionPane.showMessageDialog(null, "Bienvenido" + " " + nickname);
					principalAdministrador p = new principalAdministrador(); 
					p.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "error");
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}

	}

}
