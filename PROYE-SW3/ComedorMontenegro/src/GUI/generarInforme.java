package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import javax.swing.WindowConstants;

import com.toedter.calendar.JDateChooser;

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
public class generarInforme extends javax.swing.JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jButtonGenerarInforme;
	private JLabel jLabelFechaInicio;
	private JLabel jLabelFechaFinal;
	private JLabel jLabeltitulo;
	private JButton jButtonSalir;

	private JLabel jLabelDescripcion;
	private JDateChooser jCalendarFechaFinal;
	private JDateChooser jCalendarFechaInicial;


	BaseColor grisClaro = new BaseColor(230, 230, 230);
	BaseColor azulClaro = new BaseColor(124, 195, 255);

	PreparedStatement pst;
	Connection cn;
	ResultSet result;


	public generarInforme() {
		super();
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/Escudo.png"));
		setIconImage(icon);
		setVisible(true);
		initGUI();
	}

	private void initGUI() {
		try {
			setTitle("PAE Instituto Montenegro-Generar Informe");
			setLocation(400,250);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jButtonGenerarInforme = new JButton();
				getContentPane().add(jButtonGenerarInforme);
				jButtonGenerarInforme.setText("Generar Informe");
				jButtonGenerarInforme.setBounds(120, 188, 150, 23);
				jButtonGenerarInforme.addActionListener(this);
			}
			{
				jLabelFechaInicio = new JLabel();
				getContentPane().add(jLabelFechaInicio);
				jLabelFechaInicio.setText("Fecha Inicial");
				jLabelFechaInicio.setBounds(32, 102, 122, 24);
			}
			{
				jLabelFechaFinal = new JLabel();
				getContentPane().add(jLabelFechaFinal);
				jLabelFechaFinal.setText("Fecha Final");
				jLabelFechaFinal.setBounds(32, 138, 95, 16);
			}
			{
				jLabeltitulo = new JLabel();
				getContentPane().add(jLabeltitulo);
				jLabeltitulo.setText("Generar Informe");
				jLabeltitulo.setBounds(139, 12, 154, 24);
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Coloque las fechas, para generar el informe SEMANAL.");
				jLabelDescripcion.setBounds(32, 41, 340, 39);
			}

			{
				jCalendarFechaInicial = new JDateChooser();
				getContentPane().add(jCalendarFechaInicial);
				jCalendarFechaInicial.setBounds(154, 103, 151, 25);
			}
			{
				jCalendarFechaFinal = new JDateChooser();
				getContentPane().add(jCalendarFechaFinal);
				jCalendarFechaFinal.setBounds(154, 138, 151, 25);
			}

			{
				jButtonSalir = new JButton();
				getContentPane().add(jButtonSalir);
				jButtonSalir.setIcon(new ImageIcon(LogInAdmin.class.getResource("/imagen/atras.png")));
				jButtonSalir.setBorderPainted(false);
				jButtonSalir.setBounds(329, 180, 40, 40);
				jButtonSalir.addActionListener(this);
			}
			pack();
			this.setSize(400, 276);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jButtonGenerarInforme) {
			Document documento = new Document();

			Date fechaInicial = formatFecha(jCalendarFechaInicial.getDate());
			Date fechaFinal = formatFecha(jCalendarFechaFinal.getDate());
			cn = dataConnection.conexion();
			try {
				pst = cn.prepareStatement(
						"select est.nombres,est.apellidos,est.tipoPoblacion, count(*) as asistencias_Semanales from  instituto_montenegro im JOIN estudiante est ON(im.documentoEstudiante=est.documento) WHERE fechaIngreso between ? AND ? GROUP BY est.nombres;");
				pst.setDate(1, (java.sql.Date) fechaInicial);
				pst.setDate(2, (java.sql.Date) fechaFinal);
				result = pst.executeQuery();

				PdfWriter.getInstance(documento, new FileOutputStream("informe.pdf"));
				documento.open();

				documento.add(new Paragraph("Informe Semanal de asistencias \n"));
				Paragraph saltoLinea=new Paragraph();
				saltoLinea.add("\n\n");
				documento.add(saltoLinea);
				documento.add(saltoLinea);
				// Anchos de las columnas
				float anchosFilas[] = { 2f, 2f, 2f, 2f};
				PdfPTable tabla = new PdfPTable(anchosFilas);
				String rotulosColumnas[] = { "Nombres", "Apellidos", "tipo Poblacion", "asistencias Semanales" };
				// Porcentaje que ocupa a lo ancho de la pagina del PDF
				tabla.setWidthPercentage(100);
				// Alineacion horizontal centrada
				tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
				// agregar celda que ocupa las 4 columnas de los rotulos
				PdfPCell cell = new PdfPCell(new Paragraph("Asistencias Semanales"));
				cell.setColspan(4);
				// Centrar contenido de celda
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				// Color de fondo de la celda
				 cell.setBackgroundColor(azulClaro);
				tabla.addCell(cell);

				for (int i = 0; i < rotulosColumnas.length; i++) {
					cell = new PdfPCell(new Paragraph(rotulosColumnas[i]));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(grisClaro);
					tabla.addCell(cell);
				}
				while (result.next()) {

					cell = new PdfPCell(new Paragraph(result.getString("nombres")));
					tabla.addCell(cell);
					cell = new PdfPCell(new Paragraph(result.getString("apellidos")));
					tabla.addCell(cell);
					cell = new PdfPCell(new Paragraph(result.getString("tipoPoblacion")));
					tabla.addCell(cell);
					cell = new PdfPCell(new Paragraph(result.getString("asistencias_Semanales")));
					tabla.addCell(cell);
					
				}
				documento.add(tabla);
				documento.close();
				JOptionPane.showMessageDialog(null, "Informe Generado");
				cn.close();
			} catch (SQLException | FileNotFoundException | DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (e.getSource() == jButtonSalir) {
			this.dispose();
		}
	}

	public Date formatFecha(Date fecha) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = format1.format(fecha);
		fecha = java.sql.Date.valueOf(date1);
		return fecha;

	}

	/*agrega el contenido del documento; para este ejemplo agrega una tabla con
	* datos y una imagen
	* Espera como entrada el documento donde agregara el contenido
	*/
	private void agregarContenido(Document document) throws DocumentException {
		Paragraph ParrafoHoja = new Paragraph();

		/*Agregamos una linea en blanco al principio del documento
		 */
		agregarLineasEnBlanco(ParrafoHoja, 1);

		agregarLineasEnBlanco(ParrafoHoja, 1);
		/* 1.- AGREGAMOS LA TABLA
		 * agregarTabla(ParrafoHoja);
		 * Agregar 2 lineas en blanco 
		 */
		agregarLineasEnBlanco(ParrafoHoja, 2);
		/* 2.- AGREGAMOS LA IMAGEN */
		// try {
		// Image im = Image.getInstance("logo_mysql.gif");
		// im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);
		// im.setWidthPercentage(50);
		// ParrafoHoja.add(im);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		document.add(ParrafoHoja);

	}

	/* Agrega las lineas en blanco especificadas a un parrafo especificado */
	private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas) {
		for (int i = 0; i < nLineas; i++)
			parrafo.add(new Paragraph(" "));
	}

}
