/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author user
 */
public class VentanaModificarDatosAdmin extends javax.swing.JFrame {

    /**
     * Creates new form VentanaModificarDatosAdmin
     */
    public VentanaModificarDatosAdmin() {
        initComponents();
        jButtonGuardar.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jPanelDatosAdmin = new javax.swing.JPanel();
        jLabelNombres = new javax.swing.JLabel();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jLabelActual = new javax.swing.JLabel();
        jPasswordFieldActual = new javax.swing.JPasswordField();
        jLabelNueva = new javax.swing.JLabel();
        jPasswordFieldNuevo = new javax.swing.JPasswordField();
        jButtonGuardar = new javax.swing.JButton();
        jPanelBuscarAdmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombreABuscar = new javax.swing.JTextField();
        jButtonBuscarAdministrador = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PAE Instituto Montenegro-Modificar Informacion Admin");
        setIconImage(getIconImage());
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitulo.setText("Modificar Datos del Administrador");

        jPanelDatosAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Administrador"));

        jLabelNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNombres.setText("Nombres:");

        jTextFieldNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextFieldApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelApellidos.setText("Apellidos:");

        jLabelNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNombreUsuario.setText("Nombre de Usuario:");

        jTextFieldNombreUsuario.setEditable(false);
        jTextFieldNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelActual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelActual.setText("Contraseña Actual:");

        jPasswordFieldActual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabelNueva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNueva.setText("Nueva Contraseña:");

        jPasswordFieldNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButtonGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGuardar.setText("Guardar Cambios");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosAdminLayout = new javax.swing.GroupLayout(jPanelDatosAdmin);
        jPanelDatosAdmin.setLayout(jPanelDatosAdminLayout);
        jPanelDatosAdminLayout.setHorizontalGroup(
            jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosAdminLayout.createSequentialGroup()
                .addGroup(jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelNombres)
                        .addComponent(jLabelApellidos))
                    .addComponent(jLabelNombreUsuario)
                    .addComponent(jLabelActual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombres)
                    .addComponent(jTextFieldNombreUsuario)
                    .addComponent(jPasswordFieldActual)))
            .addGroup(jPanelDatosAdminLayout.createSequentialGroup()
                .addComponent(jLabelNueva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPasswordFieldNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelDatosAdminLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jButtonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDatosAdminLayout.setVerticalGroup(
            jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombres)
                    .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreUsuario)
                    .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelActual)
                    .addComponent(jPasswordFieldActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNueva)
                    .addComponent(jPasswordFieldNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonGuardar))
        );

        jPanelBuscarAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Administrador"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre de Usuario:");

        jButtonBuscarAdministrador.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonBuscarAdministrador.setText("Buscar Administrador");
        jButtonBuscarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAdministradorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Para modificar un administrador, primero debe buscarlo");

        javax.swing.GroupLayout jPanelBuscarAdminLayout = new javax.swing.GroupLayout(jPanelBuscarAdmin);
        jPanelBuscarAdmin.setLayout(jPanelBuscarAdminLayout);
        jPanelBuscarAdminLayout.setHorizontalGroup(
            jPanelBuscarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarAdminLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(jPanelBuscarAdminLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNombreABuscar))
                    .addGroup(jPanelBuscarAdminLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonBuscarAdministrador))))
        );
        jPanelBuscarAdminLayout.setVerticalGroup(
            jPanelBuscarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarAdminLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(jPanelBuscarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombreABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButtonBuscarAdministrador))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelDatosAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelBuscarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanelBuscarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatosAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonBuscarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAdministradorActionPerformed
        // TODO add your handling code here:
        
        jButtonGuardar.setEnabled(true);
    }//GEN-LAST:event_jButtonBuscarAdministradorActionPerformed
 @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/Escudo.png"));


        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarAdministrador;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelActual;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JLabel jLabelNombres;
    private javax.swing.JLabel jLabelNueva;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelBuscarAdmin;
    private javax.swing.JPanel jPanelDatosAdmin;
    private javax.swing.JPasswordField jPasswordFieldActual;
    private javax.swing.JPasswordField jPasswordFieldNuevo;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldNombreABuscar;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    private javax.swing.JTextField jTextFieldNombres;
    // End of variables declaration//GEN-END:variables
}
