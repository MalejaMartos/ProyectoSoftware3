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
public class modificarAdministrador extends javax.swing.JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JButton jButtonBuscar;
	private JButton jButtonModificar;
	private JLabel jLabelPassword;
	private JPasswordField jPasswordField;
	private JTextField jTextFieldApellidos;
	private JLabel jLabelApellidos;
	private JTextField jTextFieldnombres;
	private JLabel jLabelNombres;
	private JTextField jTextFieldNickname;
	private JLabel jLabelNickname;
	private JLabel jLabelIntro;
	private JButton jButtonAtras;


	PreparedStatement pst;
	Connection cn;
	ResultSet res;

	public modificarAdministrador() {
		super();
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/Escudo.png"));
		setIconImage(icon);
		setVisible(true);
		initGUI();
	}

	private void initGUI() {
		try {
			setTitle("PAE Instituto Montenegro-Modificar Informacion Admin");
			setLocation(400, 250);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("ModificarAdministrador");
				jLabelTitulo.setBounds(144, 28, 146, 30);
			}
			{
				jLabelIntro = new JLabel();
				getContentPane().add(jLabelIntro);
				jLabelIntro.setText("Para modificar un administrador, busque primero el administrador");
				jLabelIntro.setBounds(12, 56, 420, 36);
			}
			{
				jLabelNickname = new JLabel();
				getContentPane().add(jLabelNickname);
				jLabelNickname.setText("NickName");
				jLabelNickname.setBounds(31, 104, 88, 24);
			}
			{
				jTextFieldNickname = new JTextField();
				getContentPane().add(jTextFieldNickname);
				jTextFieldNickname.setBounds(161, 98, 149, 28);
			}
			{
				jLabelNombres = new JLabel();
				getContentPane().add(jLabelNombres);
				jLabelNombres.setText("nombre(s):");
				jLabelNombres.setBounds(31, 140, 100, 28);
			}
			{
				jTextFieldnombres = new JTextField();
				getContentPane().add(jTextFieldnombres);
				jTextFieldnombres.setBounds(161, 140, 149, 28);
			}
			{
				jLabelApellidos = new JLabel();
				getContentPane().add(jLabelApellidos);
				jLabelApellidos.setText("Apellidos");
				jLabelApellidos.setBounds(31, 175, 100, 16);
			}
			{
				jTextFieldApellidos = new JTextField();
				getContentPane().add(jTextFieldApellidos);
				jTextFieldApellidos.setBounds(161, 172, 149, 28);
			}
			{
				jLabelPassword = new JLabel();
				getContentPane().add(jLabelPassword);
				jLabelPassword.setText("Password");
				jLabelPassword.setBounds(31, 215, 55, 16);
			}
			{
				jPasswordField = new JPasswordField();
				getContentPane().add(jPasswordField);
				jPasswordField.setBounds(161, 212, 149, 28);
			}
			{
				jButtonBuscar = new JButton();
				getContentPane().add(jButtonBuscar);
				jButtonBuscar.setText("BUSCAR");
				jButtonBuscar.setBounds(345, 98, 99, 30);
				jButtonBuscar.addActionListener(this);
			}
			{
				jButtonModificar = new JButton();
				getContentPane().add(jButtonModificar);
				jButtonModificar.setText("Modificar Administrador");
				jButtonModificar.setBounds(119, 273, 210, 38);
				jButtonModificar.addActionListener(this);
			}
			{
				jButtonAtras = new JButton();
				getContentPane().add(jButtonAtras);
				jButtonAtras.setIcon(new ImageIcon(LogInAdmin.class.getResource("/imagen/atras.png")));
				jButtonAtras.setBorderPainted(false);
				jButtonAtras.setBounds(379, 12, 40, 40);
				jButtonAtras.addActionListener(this);
			}
			pack();
			this.setSize(465, 180);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nickName = jTextFieldNickname.getText();
		if (e.getSource() == jButtonBuscar) {
			cn = dataConnection.conexion();
			try {
				pst = cn.prepareStatement(
						"select nickname,password,nombres,apellidos from administrador WHERE nickname=?");
				pst.setString(1, nickName);
				res = pst.executeQuery();
				if (res.next()) {
					this.setSize(465, 360);
					jLabelApellidos.setVisible(true);
					jTextFieldApellidos.setVisible(true);
					jTextFieldApellidos.setText(res.getString("apellidos"));

					jLabelNombres.setVisible(true);
					jTextFieldnombres.setText(res.getString("nombres"));
					jTextFieldnombres.setVisible(true);

					jLabelNickname.setVisible(true);
					jTextFieldNickname.setEditable(false);

					jPasswordField.setEditable(true);

					jButtonBuscar.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "El administrador buscado no se encuentra en la base de datos");
					jTextFieldNickname.setText(" ");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jButtonModificar) {
			cn = dataConnection.conexion();
			char[] arrayC = jPasswordField.getPassword();
			String contrasena = new String(arrayC);
			try {

				pst = cn.prepareStatement("update administrador set password=?,nombres=?,apellidos=? where nickname=?");
				pst.setString(1, contrasena);
				pst.setString(2, jTextFieldnombres.getText());
				pst.setString(3, jTextFieldApellidos.getText());
				pst.setString(4, jTextFieldNickname.getText());
				int res = pst.executeUpdate();
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "El Administrador ha sido modificado");
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo modificar administrador, ocurrio un error");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jButtonAtras) {
			this.dispose();
		}
	}

}
