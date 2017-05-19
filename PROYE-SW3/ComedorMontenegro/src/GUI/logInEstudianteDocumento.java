package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import Logic.dataConnection;
import Logic.institutoMontenegro;

import javax.swing.SwingUtilities;

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
public class logInEstudianteDocumento extends javax.swing.JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelTitulo;
	private JLabel jLabelNumDocumento;
	private JButton jButtonIngresar;
	private JTextField jTextFieldDocumento;
	private JButton jButtonSalir;
	private institutoMontenegro instituto = new institutoMontenegro();

	Connection cn;
	PreparedStatement pst;
	ResultSet rst;


	public logInEstudianteDocumento() {
		super();
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/Escudo.png"));
		setIconImage(icon);
		setVisible(true);
		initGUI();
	}

	private void initGUI() {
		try {
			setTitle("PAE Instituto Montenegro-Ingreso Estudiante");
			setLocation(400, 250);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Login estudiante");
				jLabelTitulo.setBounds(147, 32, 184, 35);
			}
			{
				jLabelNumDocumento = new JLabel();
				getContentPane().add(jLabelNumDocumento);
				jLabelNumDocumento.setText("Numero de documento");
				jLabelNumDocumento.setBounds(12, 97, 160, 31);
			}
			{
				jTextFieldDocumento = new JTextField();
				getContentPane().add(jTextFieldDocumento);
				jTextFieldDocumento.setBounds(190, 97, 141, 23);
			}
			{
				jButtonIngresar = new JButton();
				getContentPane().add(jButtonIngresar);
				jButtonIngresar.setText("Ingresar");
				jButtonIngresar.setBounds(125, 184, 139, 37);
				jButtonIngresar.addActionListener(this);
			}
			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setIcon(new ImageIcon(LogInAdmin.class.getResource("/imagen/atras.png")));
				jButtonSalir.setBorderPainted(false);
				jButtonSalir.setBounds(337, 210, 40,40);
				jButtonSalir.addActionListener(this);
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

		if (e.getSource() == jButtonSalir) {
			principalAplicacion p = new principalAplicacion();
			p.setVisible(true);
			this.dispose();
		}
		if (e.getSource() == jButtonIngresar) {
			try {
				int documento = Integer.parseInt(jTextFieldDocumento.getText());
				Date fecha;
				Date ultimoIngresoFecha;
				fecha = (Date) instituto.fechaHoy();
				ultimoIngresoFecha = (Date) instituto.ultimaFechaIngreso(documento);

				instituto.actualizarUltimoIngreso(fecha,documento);
				cn = dataConnection.conexion();
				try {
					pst = cn.prepareStatement("select * from estudiante where documento=?");
					pst.setInt(1, documento);

					rst = pst.executeQuery();
					if (rst.next()) {
						if (instituto.validarFechas(fecha, ultimoIngresoFecha) == false) {
							instituto.insertarRegistro(documento, fecha, ultimoIngresoFecha);
							JOptionPane.showMessageDialog(null, "Bienvenido estudiante");
						} else {

							JOptionPane.showMessageDialog(null, "El estudiante ya Ingreso!!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "El estudiante no se encuentra en la base de datos");
					}
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	}

}
