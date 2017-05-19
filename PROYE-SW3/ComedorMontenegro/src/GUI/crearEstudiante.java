package GUI;

import java.awt.Color;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

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

import Logic.dataConnection;
import Logic.institutoMontenegro;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class crearEstudiante extends javax.swing.JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel jLabelTitulo;
    private JButton jButtonCrearEstudiante;
    private JLabel jLabelTipoPoblacion;
    private JLabel jLabelDocumento;
    private JLabel jLabelSexo;
    private JLabel jLabelMetodologia;
    private JTextField jTextFieldGrado;
    private JLabel jLabelGrado;
    private JTextField jTextFieldDocumento;
    private JTextField jTextFieldApellidos;
    private JLabel jLabelApellidos;
    private JTextField jTextFieldnombre;
    private JLabel jLabelnombre;
    private JButton jButtonAtras;
    private JButton jButtonAtras2;
    private JPanel jPanel1;
    private JComboBox<String> jComboMetodologia;
    private JComboBox<String> jComboSexo;
    private JComboBox<String> jComboTipoPoblacion;
    private JPanel panHuellas;
    private JLabel lblImagenHuella;
    private JButton btnGuardar;
    private JButton btnIdentificar;

    institutoMontenegro instituto = new institutoMontenegro();

    private String[] genero = {"FEMENINO", "MASCULINO"};
    ;
	private String[] metodologias = {"TRADICIONAL", "FLEXIBLE"};
    private String[] tipoPoblacion = {"AFRO COLOMBIANO", "DESPLAZADOS", "INDIGENA", "OTRA", "N/A"};

    // atributos para el manejo de la base de datos
    PreparedStatement pst;
    Connection cn;
    ResultSet result;

    public crearEstudiante() {
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
            setTitle("PAE Instituto Montenegro");
            getContentPane().setLayout(null);
            this.setBackground(new Color(152, 251, 152));
            {
                jLabelTitulo = new JLabel();
                getContentPane().add(jLabelTitulo);
                jLabelTitulo.setText("Gestionar Estudiante ");
                jLabelTitulo.setBounds(189, 30, 144, 27);
            }
            {
                jLabelnombre = new JLabel();
                getContentPane().add(jLabelnombre);
                jLabelnombre.setText("NOMBRE:");
                jLabelnombre.setBounds(38, 97, 92, 16);
            }
            {
                jTextFieldnombre = new JTextField();
                getContentPane().add(jTextFieldnombre);
                jTextFieldnombre.setBounds(189, 90, 160, 30);
            }
            {
                jLabelApellidos = new JLabel("APELLIDOS:");
                getContentPane().add(jLabelApellidos);
                jLabelApellidos.setBounds(38, 135, 92, 16);
            }
            {
                jTextFieldApellidos = new JTextField();
                getContentPane().add(jTextFieldApellidos);
                jTextFieldApellidos.setBounds(189, 132, 160, 30);
            }
            {
                jLabelDocumento = new JLabel("DOCUMENTO TI/CC:");
                getContentPane().add(jLabelDocumento);
                jLabelDocumento.setBounds(38, 181, 151, 16);
            }
            {
                jTextFieldDocumento = new JTextField();
                getContentPane().add(jTextFieldDocumento);
                jTextFieldDocumento.setBounds(189, 178, 160, 30);
            }
            {
                jLabelGrado = new JLabel("GRADO:");
                getContentPane().add(jLabelGrado);
                jLabelGrado.setBounds(38, 232, 107, 16);
            }
            {
                jTextFieldGrado = new JTextField();
                getContentPane().add(jTextFieldGrado);
                jTextFieldGrado.setBounds(189, 229, 160, 30);
            }
            {
                jLabelSexo = new JLabel("SEXO:");
                getContentPane().add(jLabelSexo);
                jLabelSexo.setBounds(38, 270, 116, 16);
            }

            {
                jLabelMetodologia = new JLabel("METODOLOG�A:");
                getContentPane().add(jLabelMetodologia);
                jLabelMetodologia.setBounds(38, 309, 94, 16);
            }

            {
                jComboMetodologia = new JComboBox<>(metodologias);
                getContentPane().add(jComboMetodologia);
                jComboMetodologia.setBounds(189, 306, 160, 23);
            }
            {
                jLabelTipoPoblacion = new JLabel("TIPO POBLACI�N:");
                getContentPane().add(jLabelTipoPoblacion);
                jLabelTipoPoblacion.setBounds(38, 345, 151, 16);
            }

            {
                jComboTipoPoblacion = new JComboBox<>(tipoPoblacion);
                getContentPane().add(jComboTipoPoblacion);
                jComboTipoPoblacion.setBounds(189, 342, 160, 23);
            }
            {
                jButtonCrearEstudiante = new JButton("Tomar Huella");
                getContentPane().add(jButtonCrearEstudiante);
                jButtonCrearEstudiante.setBounds(210, 380, 142, 28);
                jButtonCrearEstudiante.addActionListener(this);
            }
            {
                jComboSexo = new JComboBox<>(genero);
                getContentPane().add(jComboSexo);
                // jComboSexo.setBounds(208, 302, 160, 23);
                jComboSexo.setBounds(189, 267, 160, 23);
            }
            {
                jButtonAtras = new JButton();
                getContentPane().add(jButtonAtras);
                jButtonAtras.setIcon(new ImageIcon(LogInAdmin.class.getResource("/imagen/atras.png")));
                jButtonAtras.setBorderPainted(false);
                jButtonAtras.setBounds(750, 32, 40, 40);
                jButtonAtras.addActionListener(this);
            }

            {
                lblImagenHuella = new javax.swing.JLabel();
                panHuellas = new JPanel();
                panHuellas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huella Digital Capturada",
                        javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
                panHuellas.setPreferredSize(new java.awt.Dimension(400, 270));
                panHuellas.setBounds(400, 90, 400, 270);
                panHuellas.setLayout(new java.awt.BorderLayout());

                jPanel1 = new JPanel();

                jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                jPanel1.setLayout(new java.awt.BorderLayout());
                jPanel1.add(lblImagenHuella);

                panHuellas.add(jPanel1);

                getContentPane().add(panHuellas);
            }
            {
                btnGuardar = new JButton("Guardar Estudiante");
                getContentPane().add(btnGuardar);
                btnGuardar.addActionListener(this);
                btnGuardar.setBounds(500, 380, 142, 28);
                btnGuardar.setEnabled(false);
                btnGuardar.setVisible(true);

            }
            {
                btnIdentificar = new JButton("Identificar");
                getContentPane().add(btnIdentificar);
                btnIdentificar.setBounds(700, 380, 142, 28);
                btnIdentificar.addActionListener(this);
            }
            pack();
            // this.setSize(725, 424);
            this.setSize(900, 500);
        } catch (Exception e) {
            // add your error handling code here
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonAtras || e.getSource() == jButtonAtras2) {

            this.dispose();
        }

        if (e.getSource() == jButtonCrearEstudiante) {
            Iniciar();
            start();
            String nombres = jTextFieldnombre.getText();
            String apellidos = jTextFieldApellidos.getText();
            int documento = Integer.parseInt(jTextFieldDocumento.getText());
            String grado = jTextFieldGrado.getText();
            String sexo = sexoF((String) jComboSexo.getSelectedItem());
            String tipoPoblacion = (String) jComboTipoPoblacion.getSelectedItem();
            String metodologia = (String) jComboMetodologia.getSelectedItem();

            // Validar que ingrese los campos obligatorios para registrarlo en
            // la base de datos
            if (nombres.length() != 0 && apellidos.length() != 0 && documento != 0 && grado.length() != 0) {
                cn = dataConnection.conexion();
                try {
                    pst = cn.prepareStatement("insert into estudiante (documento,nombres,apellidos,"
                            + "grado,sexo,tipoPoblacion,modeloPedagogico) values (?,?,?,?,?,?,?)");

                    pst.setInt(1, documento);
                    pst.setString(2, nombres);
                    pst.setString(3, apellidos);
                    pst.setString(4, grado);
                    pst.setString(5, sexo);
                    pst.setString(6, tipoPoblacion);
                    pst.setString(7, metodologia);

                    int res = pst.executeUpdate();
                    if (res > 0) {
                        Date fecha = fechaIncio();
                        try {
                            instituto.insertarRegistro(documento, fecha, fecha);
                        } catch (ParseException e1) {

                            e1.printStackTrace();
                        }

                        JOptionPane.showMessageDialog(null, "Por favor poner el dedo indice 4 veces");
                        setCampos();
                        // jButtonTomarFoto.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "ups...ocurrio un problema");
                    }
                    cn.close();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
            }
        }
        if (e.getSource() == btnGuardar) {

            String documento = jTextFieldDocumento.getText();

            guardarHuella(documento);
            Reclutador.clear();
            lblImagenHuella.setIcon(null);
            stop();
//			Iniciar();
//			start();
        }
        if (e.getSource() == btnIdentificar) {
            try {
                identificarHuella();
                Reclutador.clear();
            } catch (IOException ex) {
                Logger.getLogger(crearEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void limpiar() {
        jTextFieldApellidos.setText("");
        jTextFieldnombre.setText("");
        jTextFieldDocumento.setText("");
        jTextFieldGrado.setText("");
        jComboMetodologia.setSelectedIndex(0);
        jComboSexo.setSelectedIndex(0);
        jComboTipoPoblacion.setSelectedIndex(0);
        jTextFieldApellidos.setText(" ");
        jTextFieldnombre.setText(" ");
        jTextFieldDocumento.setText(" ");
        jTextFieldGrado.setText(" ");
    }

    public Date fechaIncio() {
        String date1 = "1999-05-24";
        Date fecha = java.sql.Date.valueOf(date1);
        return fecha;
    }

    public void setCampos() {
        jTextFieldApellidos.setEditable(false);
        jTextFieldnombre.setEditable(false);
        jTextFieldDocumento.setEditable(false);
        jTextFieldGrado.setEditable(false);
        jComboMetodologia.setEditable(false);
        jComboSexo.setEditable(false);
        jComboTipoPoblacion.setEditable(false);
    }

    /**
     * Metodo que permite validar si el char ingresado es numero
     *
     * @param c
     * @return flag
     */
    private boolean esNumero(char c) {
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                || c == '0') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que permite validar que los campos esten llenos
     */
    public boolean validarCamposObligatorios(JTextField documento, JTextField nombre, JTextField apellidos,
            JTextField grado) {

        return false;
    }

    /**
     * Metodo que permite validar que el documento sea de 10 caracteres
     *
     * @param documento
     * @return
     */
    public boolean validarDocumento(String documento) {
        boolean resultado = false;

        if (documento.length() <= 11) {
            for (int i = 0; i < documento.length(); i++) {
                if (esNumero(documento.charAt(i))) {
                    resultado = true;
                } else {
                    return false;
                }
            }

        }
        return resultado;
    }

    public String sexoF(String sexo) {
        if (sexo == "FEMENINO") {
            return "F";
        } else {
            return "M";
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
                        // EnviarTexto("La Huella Digital ha sido Capturada");
                        ProcesarCaptura(e.getSample());
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

    public void ProcesarCaptura(DPFPSample sample) {
        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el proposito de inscripcion.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el proposito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo a�ade a su
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
                        setTemplate(Reclutador.getTemplate());
                        // EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya
                        // puede Verificarla o Identificarla");
                        // btnIdentificar.setEnabled(false);
                        // btnVerificar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Ya puede guardar el estudiante");
                        btnGuardar.setEnabled(true);
                        btnGuardar.grabFocus();
                        break;

                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la
                        // captura de huellas
                        Reclutador.clear();
                        stop();
                        // EstadoHuellas();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(crearEstudiante.this,
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
            btnGuardar.setEnabled(false);
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
    public void identificarHuella() throws IOException {
        try {
            //Establece los valores para la sentencia SQL
            cn = dataConnection.conexion();

            //Obtiene todas las huellas de la bd
            PreparedStatement identificarStmt = cn.prepareStatement("SELECT huelladocumneto,huella FROM huella");
            ResultSet rs = identificarStmt.executeQuery();

            //Si se encuentra el nombre en la base de datos
            while (rs.next()) {
                //Lee la plantilla de la base de datos
                byte templateBuffer[] = rs.getBytes("huella");
                String documento = rs.getString("huelladocumneto");
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
                    return;
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
    }

}
