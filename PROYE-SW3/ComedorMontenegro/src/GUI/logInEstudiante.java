package GUI;

import Logic.dataConnection;
import Logic.institutoMontenegro;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
public class logInEstudiante extends javax.swing.JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel jLabelTitulo;
    private JButton jButtonHuella;
    private JButton jButtonSalir;
    private JPanel panHuellas;
    private JLabel lblImagenHuella;
    private JPanel jPanel1;
    //para poder hacer el ingreso
    private int doc;
    private institutoMontenegro instituto = new institutoMontenegro();

    Connection cn;
    PreparedStatement pst;
    private JButton jButtonDocumento;
    ResultSet rst;

    public logInEstudiante() {
        super();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/Escudo.png"));
        setIconImage(icon);
        setVisible(true);
        initGUI();
        Iniciar();
        start();
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
                jLabelTitulo.setText("Si desea ingresar por huella, favor coloca el dedo indice en el lector");
                jLabelTitulo.setBounds(20, 36, 242, 49);
            }
            {
                jButtonHuella = new JButton();
                getContentPane().add(jButtonHuella);
                jButtonHuella.setText("Huella");
                jButtonHuella.setBounds(12, 400, 163, 37);
                jButtonHuella.addActionListener(this);
            }
            {
                jButtonSalir = new JButton();
                getContentPane().add(jButtonSalir);
                jButtonSalir.setIcon(new ImageIcon(LogInAdmin.class.getResource("/imagen/atras.png")));
                jButtonSalir.setBorderPainted(false);
                jButtonSalir.setBounds(337, 30, 40, 40);
                jButtonSalir.addActionListener(this);
            }
            {
                jButtonDocumento = new JButton();
                getContentPane().add(jButtonDocumento);
                jButtonDocumento.setText("Documento");
                jButtonDocumento.setBounds(204, 400, 163, 35);
                jButtonDocumento.addActionListener(this);
            }
            {
                lblImagenHuella = new javax.swing.JLabel();
                panHuellas = new JPanel();
                panHuellas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huella Digital Capturada",
                        javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
                panHuellas.setPreferredSize(new java.awt.Dimension(400, 270));
                panHuellas.setBounds(12, 90, 200, 200);
                panHuellas.setLayout(new java.awt.BorderLayout());

                jPanel1 = new JPanel();

                jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                jPanel1.setLayout(new java.awt.BorderLayout());
                jPanel1.add(lblImagenHuella);

                panHuellas.add(jPanel1);

                getContentPane().add(panHuellas);
            }
            pack();
            setSize(400, 600);
        } catch (Exception e) {
            // add your error handling code here
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButtonSalir) {
            principalAplicacion p = new principalAplicacion();
            stop();
            p.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == jButtonDocumento) {
            logInEstudianteDocumento p = new logInEstudianteDocumento();
            p.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == jButtonHuella) {
            LogInEstudianteHuella p = new LogInEstudianteHuella();
            p.setVisible(true);
            this.dispose();
        }

    }

    // Varible que permite iniciar el dispositivo de lector de huella conectado
    // con sus distintos metodos.
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

    // Varible que permite establecer las capturas de la huellas, para determina
    // sus caracteristicas
    // y poder estimar la creacion de un template de la huella para luego poder
    // guardarla
    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    // Esta variable tambien captura una huella del lector y crea sus
    // caracteristcas para auntetificarla
    // o verificarla con alguna guardada en la BD
    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

    // Variable que para crear el template de la huella luego de que se hallan
    // creado las caracteriticas
    // necesarias de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";

    /**
     * Metodo que sirve para iniciar el lector de huellas
     */
    protected void Iniciar() {
        Lector.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            // EnviarTexto("La Huella Digital ha sido Capturada");
                            ProcesarCaptura(e.getSample());
                        } catch (IOException ex) {
                            Logger.getLogger(logInEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        });

        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El Sensor de Huella Digital esta
                        // Activado o Conectado");
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El Sensor de Huella Digital esta
                        // Desactivado o no Conectado");
                    }
                });
            }
        });

        Lector.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El dedo ha sido colocado sobre el Lector
                        // de Huella");
                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El dedo ha sido quitado del Lector de
                        // Huella");
                    }
                });
            }
        });

        Lector.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("Error: "+e.getError());
                    }
                });
            }
        });
    }

    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;

    public void ProcesarCaptura(DPFPSample sample) throws IOException {
        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el proposito de inscripcion.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el prop�sito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo agrega a su
        // reclutador si es bueno
        if (featuresinscripcion != null) {
            try {
                System.out.println("Las Caracteristicas de la Huella han sido creada");
                Reclutador.addFeatures(featuresinscripcion);// Agregar las
                // caracteristicas
                // de la huella a la
                // plantilla a crear

                // Dibuja la huella dactilar capturada.
                Image image = CrearImagenHuella(sample);
                DibujarHuella(image);

                //identifica despues de capturar la huella
                boolean respuesta=identificarHuella();
                if(respuesta){
                    registrarIngreso();
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede registrar el ingreso del estudiante");
                }
                //limpia el reclutador de las huellas
                Reclutador.clear();
                //se para de utilizar el lector
                stop();
                //vuelve y se inicia para la proxima huella
                start();
                // btnVerificar.setEnabled(true);
                // btnIdentificar.setEnabled(true);
            } catch (DPFPImageQualityException ex) {
                System.err.println("Error: " + ex.getMessage());
            } finally {
                // EstadoHuellas();
                // Comprueba si la plantilla se ha creado.
                switch (Reclutador.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY: // informe de exito y detiene la
                        // captura de huellas
                        stop();
                        JOptionPane.showMessageDialog(null, "Se esta identificando la huella");
                        identificarHuella();
                        setTemplate(Reclutador.getTemplate());
                        JOptionPane.showMessageDialog(null, "Ya puede guardar el estudiante");
                        break;

                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la
                        // captura de huellas
                        Reclutador.clear();
                        stop();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(logInEstudiante.this,
                                "La Plantilla de la Huella no pudo ser creada, Repita el Proceso",
                                "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
                        start();
                        break;
                }
            }
        }
    }

    public void start() {
        Lector.startCapture();
        // EnviarTexto("Utilizando el Lector de Huella Dactilar ");
    }

    public void stop() {
        Lector.stopCapture();
        // EnviarTexto("No se esta usando el Lector de Huella Dactilar ");
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        lblImagenHuella.setIcon(new ImageIcon(
                image.getScaledInstance(lblImagenHuella.getWidth(), lblImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    /*
		  * Guarda los datos de la huella digital actual en la base de datos
     */
    public void guardarHuella(String documento) {
        int doc = Integer.parseInt(documento);
        //Obtiene los datos del template de la huella actual
        ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
        Integer tamanoHuella = template.serialize().length;

        //Pregunta el nombre de la persona a la cual corresponde dicha huella
//		     String nombre = JOptionPane.showInputDialog("Nombre:");
        try {
            //Establece los valores para la sentencia SQL
            cn = dataConnection.conexion();
            PreparedStatement guardarStmt = cn.prepareStatement("INSERT INTO huella(huelladocumneto, huella,estudiante_documento) values(?,?,?)");

            guardarStmt.setString(1, documento);
            guardarStmt.setBinaryStream(2, datosHuella, tamanoHuella);
            guardarStmt.setInt(3, doc);
            //Ejecuta la sentencia
            guardarStmt.execute();
            guardarStmt.close();
            JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");
            cn.close();
            // btnGuardar.setEnabled(false);
            //btnVerificar.grabFocus();
        } catch (SQLException ex) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al guardar los datos de la huella.");
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Identifica a una persona registrada por medio de su huella digital
     */
    public boolean identificarHuella() throws IOException {
        try {
            //Establece los valores para la sentencia SQL
            cn = dataConnection.conexion();

            //Obtiene todas las huellas de la bd
            PreparedStatement identificarStmt = cn.prepareStatement("SELECT estudiante_documento,huella FROM huella");
            ResultSet rs = identificarStmt.executeQuery();

            //Si se encuentra el nombre en la base de datos
            while (rs.next()) {
                //Lee la plantilla de la base de datos
                byte templateBuffer[] = rs.getBytes("huella");
                int documento = rs.getInt("estudiante_documento");
                doc = documento;
                //Crea una nueva plantilla a partir de la guardada en la base de datos
                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
                setTemplate(referenceTemplate);

                // Compara las caracteriticas de la huella recientemente capturda con la
                // alguna plantilla guardada en la base de datos que coincide con ese tipo
                DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

                //compara las plantilas (actual vs bd)
                //Si encuentra correspondencia dibuja el mapa
                //e indica el nombre de la persona que coincidio.
                if (result.isVerified()) {
                    //crea la imagen de los datos guardado de las huellas guardadas en la base de datos
                    JOptionPane.showMessageDialog(null, "Las huella capturada es de " + documento, "Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
            //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
            JOptionPane.showMessageDialog(null, "No existe ning�n registro que coincida con la huella", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
            setTemplate(null);
        } catch (SQLException e) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al identificar huella dactilar." + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Metodo que permite registrar el ingreso de los estudiantes que poseen una huella
     */
    public void registrarIngreso() {
        try {
            Date fecha;
            Date ultimoIngresoFecha;
            fecha = (Date) instituto.fechaHoy();
            ultimoIngresoFecha = (Date) instituto.ultimaFechaIngreso(doc);

            instituto.actualizarUltimoIngreso(fecha, doc);
            cn = dataConnection.conexion();
            try {
                pst = cn.prepareStatement("select * from estudiante where documento=?");
                pst.setInt(1, doc);

                rst = pst.executeQuery();
                if (rst.next()) {
                    if (instituto.validarFechas(fecha, ultimoIngresoFecha) == false) {
                        instituto.insertarRegistro(doc, fecha, ultimoIngresoFecha);
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
