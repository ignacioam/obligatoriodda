package appgestores.views;

import appgestores.Sistema;
import appgestores.controllers.login.LoginController;
import appgestores.controllers.login.UILogin;
import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author Juan, Ignacio
 */
public class FrmLogin extends javax.swing.JFrame implements UILogin {

    private LoginController controller;

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        setSize(900, 526);
        setLocationRelativeTo(null);
        controller = new LoginController(this, Sistema.getService());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnCerrar = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesión");
        setMinimumSize(new java.awt.Dimension(900, 526));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        txtUsername.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        getContentPane().add(txtUsername);
        txtUsername.setBounds(330, 220, 250, 40);

        lblUsername.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("Nombre de usuario");
        getContentPane().add(lblUsername);
        lblUsername.setBounds(330, 190, 246, 23);

        lblPassword.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("Contraseña");
        getContentPane().add(lblPassword);
        lblPassword.setBounds(330, 270, 246, 23);

        btnIniciarSesion.setBackground(new java.awt.Color(77, 11, 232));
        btnIniciarSesion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.setBorder(null);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesion);
        btnIniciarSesion.setBounds(350, 360, 216, 53);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(330, 300, 250, 40);

        btnCerrar.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setText("x");
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        getContentPane().add(btnCerrar);
        btnCerrar.setBounds(870, 0, 30, 23);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appgestores/views/resources/imgs/logologin.png"))); // NOI18N
        getContentPane().add(lblLogo);
        lblLogo.setBounds(409, 70, 90, 90);

        lblMensaje.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 102, 102));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(20, 470, 880, 16);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appgestores/views/resources/imgs/bglogin.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 900, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        boolean ok = true;
        String user = txtUsername.getText().trim();
        String pass = new String(txtPassword.getPassword()).trim();
        if (user == null || user.length() == 0) {
            txtUsername.setBorder(BorderFactory.createLineBorder(Color.red));
            ok = false;
        }

        if (pass == null || pass.length() == 0) {
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.red));
            ok = false;
        }

        if (ok) {
            controller.iniciarSesion();
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getUsername() {
        return txtUsername.getText();
    }

    @Override
    public String getPassword() {
        return new String(txtPassword.getPassword());
    }

    @Override
    public void mostrarMensaje(String msg) {
        lblMensaje.setText(msg);
    }

    @Override
    public void cerrarForm() {
        this.dispose();
    }
}
