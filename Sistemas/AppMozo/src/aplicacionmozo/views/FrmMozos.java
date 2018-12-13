package aplicacionmozo.views;

import aplicacionmozo.DialogoPersonalizado;
import aplicacionmozo.controllers.mozo.MozoController;
import aplicacionmozo.controllers.mozo.UIMozo;
import aplicacionmozo.Sistema;
import aplicacionmozo.tablemesas.MesaCellRenderer;
import aplicacionmozo.tablemesas.MesaTableModel;
import entidades.Mesa;
import entidades.Mozo;
import entidades.Transferencia;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Juan. Ignacio
 */
public class FrmMozos extends javax.swing.JFrame implements UIMozo {

    private MozoController controller;
    private Mozo mozo;

    public FrmMozos() throws RemoteException {
        initComponents();
        setLocationRelativeTo(null);
        controller = new MozoController(Sistema.getService(), this);
        mozo = Sistema.getMozo();
        lblMozo.setText(mozo.getNombre());
        configurarListadoDeMesas();
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                controller.cerrarSesion();
                System.exit(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        lblMozo = new javax.swing.JLabel();
        lblImgUser = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        btnMesas = new javax.swing.JPanel();
        optMesas = new javax.swing.JPanel();
        lblMesas = new javax.swing.JLabel();
        btnTransefirMesas = new javax.swing.JPanel();
        optTransMesa = new javax.swing.JPanel();
        lblTransMesa = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JPanel();
        optLogout = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        panelAll = new javax.swing.JPanel();
        panelMesas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbMesas = new javax.swing.JTable();
        btnCerrarLstMesas = new javax.swing.JLabel();
        panelTransferirMesa = new javax.swing.JPanel();
        lblTransMesaTitulo = new javax.swing.JLabel();
        btnCerrarTransMesas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlstMesas = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlstMozos = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        btnAceptarTransferirMesa = new javax.swing.JButton();
        lblMensajeTransferencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelMenu.setBackground(new java.awt.Color(98, 160, 240));

        lblMozo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 18)); // NOI18N
        lblMozo.setForeground(new java.awt.Color(255, 255, 255));
        lblMozo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMozo.setText("Nombre mozo");

        lblImgUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplicacionmozo/views/resources/imgs/user.png"))); // NOI18N

        separador.setForeground(new java.awt.Color(255, 255, 255));
        separador.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

        btnMesas.setBackground(new java.awt.Color(76, 132, 203));
        btnMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMesasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMesasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMesasMouseExited(evt);
            }
        });

        optMesas.setBackground(new java.awt.Color(26, 91, 176));
        optMesas.setPreferredSize(new java.awt.Dimension(7, 54));

        javax.swing.GroupLayout optMesasLayout = new javax.swing.GroupLayout(optMesas);
        optMesas.setLayout(optMesasLayout);
        optMesasLayout.setHorizontalGroup(
            optMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        optMesasLayout.setVerticalGroup(
            optMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        lblMesas.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblMesas.setForeground(new java.awt.Color(255, 255, 255));
        lblMesas.setText("Mesas");

        javax.swing.GroupLayout btnMesasLayout = new javax.swing.GroupLayout(btnMesas);
        btnMesas.setLayout(btnMesasLayout);
        btnMesasLayout.setHorizontalGroup(
            btnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMesasLayout.createSequentialGroup()
                .addComponent(optMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnMesasLayout.setVerticalGroup(
            btnMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMesasLayout.createSequentialGroup()
                .addComponent(optMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnTransefirMesas.setBackground(new java.awt.Color(76, 132, 203));
        btnTransefirMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransefirMesasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTransefirMesasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTransefirMesasMouseExited(evt);
            }
        });

        optTransMesa.setBackground(new java.awt.Color(26, 91, 176));
        optTransMesa.setPreferredSize(new java.awt.Dimension(7, 54));

        javax.swing.GroupLayout optTransMesaLayout = new javax.swing.GroupLayout(optTransMesa);
        optTransMesa.setLayout(optTransMesaLayout);
        optTransMesaLayout.setHorizontalGroup(
            optTransMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        optTransMesaLayout.setVerticalGroup(
            optTransMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        lblTransMesa.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblTransMesa.setForeground(new java.awt.Color(255, 255, 255));
        lblTransMesa.setText("Transferir mesas");

        javax.swing.GroupLayout btnTransefirMesasLayout = new javax.swing.GroupLayout(btnTransefirMesas);
        btnTransefirMesas.setLayout(btnTransefirMesasLayout);
        btnTransefirMesasLayout.setHorizontalGroup(
            btnTransefirMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransefirMesasLayout.createSequentialGroup()
                .addComponent(optTransMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTransMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnTransefirMesasLayout.setVerticalGroup(
            btnTransefirMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransefirMesasLayout.createSequentialGroup()
                .addComponent(optTransMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblTransMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCerrarSesion.setBackground(new java.awt.Color(76, 132, 203));
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseExited(evt);
            }
        });

        optLogout.setBackground(new java.awt.Color(26, 91, 176));
        optLogout.setPreferredSize(new java.awt.Dimension(7, 54));

        javax.swing.GroupLayout optLogoutLayout = new javax.swing.GroupLayout(optLogout);
        optLogout.setLayout(optLogoutLayout);
        optLogoutLayout.setHorizontalGroup(
            optLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 7, Short.MAX_VALUE)
        );
        optLogoutLayout.setVerticalGroup(
            optLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        lblLogout.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setText("Cerrar sesión");

        javax.swing.GroupLayout btnCerrarSesionLayout = new javax.swing.GroupLayout(btnCerrarSesion);
        btnCerrarSesion.setLayout(btnCerrarSesionLayout);
        btnCerrarSesionLayout.setHorizontalGroup(
            btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCerrarSesionLayout.createSequentialGroup()
                .addComponent(optLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnCerrarSesionLayout.setVerticalGroup(
            btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCerrarSesionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(btnCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnCerrarSesionLayout.createSequentialGroup()
                        .addComponent(optLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMozo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btnTransefirMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblImgUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnTransefirMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );

        panelAll.setPreferredSize(new java.awt.Dimension(850, 35));
        panelAll.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 24)); // NOI18N
        jLabel1.setText("Mesas");

        jtbMesas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtbMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbMesas.setSurrendersFocusOnKeystroke(true);
        jtbMesas.getTableHeader().setResizingAllowed(false);
        jtbMesas.getTableHeader().setReorderingAllowed(false);
        jtbMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbMesasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbMesas);

        btnCerrarLstMesas.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btnCerrarLstMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrarLstMesas.setText("x");
        btnCerrarLstMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarLstMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarLstMesasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMesasLayout = new javax.swing.GroupLayout(panelMesas);
        panelMesas.setLayout(panelMesasLayout);
        panelMesasLayout.setHorizontalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesasLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarLstMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMesasLayout.setVerticalGroup(
            panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarLstMesas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
        );

        panelAll.add(panelMesas, "card2");

        lblTransMesaTitulo.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 24)); // NOI18N
        lblTransMesaTitulo.setText("Transferir mesas");

        btnCerrarTransMesas.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        btnCerrarTransMesas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrarTransMesas.setText("x");
        btnCerrarTransMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarTransMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarTransMesasMouseClicked(evt);
            }
        });

        jlstMesas.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jlstMesas);

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione la mesa que desea transferir");

        jlstMozos.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(jlstMozos);

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        jLabel3.setText("Seleccione el mozo a quien desea transferir la mesa");

        btnAceptarTransferirMesa.setBackground(new java.awt.Color(98, 160, 240));
        btnAceptarTransferirMesa.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        btnAceptarTransferirMesa.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarTransferirMesa.setText("Aceptar");
        btnAceptarTransferirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarTransferirMesaActionPerformed(evt);
            }
        });

        lblMensajeTransferencia.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelTransferirMesaLayout = new javax.swing.GroupLayout(panelTransferirMesa);
        panelTransferirMesa.setLayout(panelTransferirMesaLayout);
        panelTransferirMesaLayout.setHorizontalGroup(
            panelTransferirMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransferirMesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransferirMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelTransferirMesaLayout.createSequentialGroup()
                        .addComponent(lblTransMesaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 466, Short.MAX_VALUE)
                        .addComponent(btnCerrarTransMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransferirMesaLayout.createSequentialGroup()
                        .addComponent(lblMensajeTransferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAceptarTransferirMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addGroup(panelTransferirMesaLayout.createSequentialGroup()
                        .addGroup(panelTransferirMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTransferirMesaLayout.setVerticalGroup(
            panelTransferirMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransferirMesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTransferirMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarTransMesas)
                    .addComponent(lblTransMesaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTransferirMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAceptarTransferirMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(lblMensajeTransferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelAll.add(panelTransferirMesa, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMesasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesasMouseEntered
        optMesas.setBackground(new Color(169, 205, 252));
    }//GEN-LAST:event_btnMesasMouseEntered

    private void btnMesasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesasMouseExited
        optMesas.setBackground(new Color(26, 91, 176));
    }//GEN-LAST:event_btnMesasMouseExited

    private void btnMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesasMouseClicked
        configurarListadoDeMesas();
    }//GEN-LAST:event_btnMesasMouseClicked

    private void btnTransefirMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransefirMesasMouseClicked
        configurarTransferenciaDeMesas();
    }//GEN-LAST:event_btnTransefirMesasMouseClicked

    private void btnTransefirMesasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransefirMesasMouseEntered
        optTransMesa.setBackground(new Color(169, 205, 252));
    }//GEN-LAST:event_btnTransefirMesasMouseEntered

    private void btnTransefirMesasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransefirMesasMouseExited
        optTransMesa.setBackground(new Color(26, 91, 176));
    }//GEN-LAST:event_btnTransefirMesasMouseExited

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        cerrar();
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnCerrarTransMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarTransMesasMouseClicked
        cerrar();
    }//GEN-LAST:event_btnCerrarTransMesasMouseClicked

    private void btnCerrarLstMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarLstMesasMouseClicked
        cerrar();
    }//GEN-LAST:event_btnCerrarLstMesasMouseClicked

    private void btnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseEntered
        optLogout.setBackground(new Color(169, 205, 252));
    }//GEN-LAST:event_btnCerrarSesionMouseEntered

    private void btnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseExited
        optLogout.setBackground(new Color(26, 91, 176));
    }//GEN-LAST:event_btnCerrarSesionMouseExited

    private void jtbMesasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMesasMousePressed
        if (evt.getClickCount() == 2 && jtbMesas.getValueAt(jtbMesas.getSelectedRow(), jtbMesas.getSelectedColumn()) != null) {
            try {
                Mesa mesa = (Mesa) jtbMesas.getValueAt(jtbMesas.getSelectedRow(), jtbMesas.getSelectedColumn());
                if (!mesa.isAbierta()) {
                    controller.abrirMesa(mesa.getNumero());
                }
                Mesa m = Sistema.getService().getMesaPorNumero(mesa.getNumero());
                new JDFAgregarPedidos(this, true, m).setVisible(true);
            } catch (RemoteException ex) {
                Logger.getLogger(FrmMozos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jtbMesasMousePressed

    private void btnAceptarTransferirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarTransferirMesaActionPerformed
        controller.iniciarTransferencia();
    }//GEN-LAST:event_btnAceptarTransferirMesaActionPerformed

    private void configurarListadoDeMesas() {
        btnTransefirMesas.setBackground(new Color(76, 132, 203));
        optMesas.setBackground(new Color(26, 91, 176));
        btnMesas.setBackground(new Color(0, 88, 170));
        panelTransferirMesa.hide();
        panelMesas.show();
    }

    private void configurarTransferenciaDeMesas() {
        btnMesas.setBackground(new Color(76, 132, 203));
        optTransMesa.setBackground(new Color(26, 91, 176));
        btnTransefirMesas.setBackground(new Color(0, 88, 170));
        panelMesas.hide();
        panelTransferirMesa.show();
    }

    private void cerrar() {
        int res = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?", "Atención", JOptionPane.YES_NO_OPTION);
        if (res == 0 && controller.cerrarSesion()) {
            System.exit(0);
        }
    }

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
            java.util.logging.Logger.getLogger(FrmMozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMozos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmMozos().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(FrmMozos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarTransferirMesa;
    private javax.swing.JLabel btnCerrarLstMesas;
    private javax.swing.JPanel btnCerrarSesion;
    private javax.swing.JLabel btnCerrarTransMesas;
    private javax.swing.JPanel btnMesas;
    private javax.swing.JPanel btnTransefirMesas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Object> jlstMesas;
    private javax.swing.JList<Object> jlstMozos;
    private javax.swing.JTable jtbMesas;
    private javax.swing.JLabel lblImgUser;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblMensajeTransferencia;
    private javax.swing.JLabel lblMesas;
    private javax.swing.JLabel lblMozo;
    private javax.swing.JLabel lblTransMesa;
    private javax.swing.JLabel lblTransMesaTitulo;
    private javax.swing.JPanel optLogout;
    private javax.swing.JPanel optMesas;
    private javax.swing.JPanel optTransMesa;
    private javax.swing.JPanel panelAll;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMesas;
    private javax.swing.JPanel panelTransferirMesa;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables

    @Override
    public void listarUsuarios(ArrayList<Mozo> colUsers) {
        jlstMozos.setListData(colUsers.toArray());
    }

    @Override
    public void listarMesas(Mesa[][] mesas) {
        MesaTableModel modelo = new MesaTableModel(mesas);
        jtbMesas.setModel(modelo);
        jtbMesas.setDefaultRenderer(Object.class, new MesaCellRenderer());
        jtbMesas.setRowHeight(200);
        jtbMesas.setCellSelectionEnabled(true);
        jtbMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @Override
    public void listarMesasTransferencia(ArrayList<Mesa> mesas) {
        jlstMesas.setListData(mesas.toArray());
    }

    @Override
    public Mesa getMesaTransferencia() {
        return (Mesa) jlstMesas.getSelectedValue();
    }

    @Override
    public Mozo getMozoTransferencia() {
        return (Mozo) jlstMozos.getSelectedValue();
    }

    @Override
    public boolean tranferenciaMesa(Transferencia t) {
        DialogoPersonalizado dialog = new DialogoPersonalizado(null, t);
        return dialog.OK;
    }

    @Override
    public void mostrarMensaje(String msg, Color color) {
        lblMensajeTransferencia.setForeground(color);
        lblMensajeTransferencia.setText(msg);
    }

    @Override
    public void mostrarMensajePane(String msg, String titulo, int opt) {
        JOptionPane.showMessageDialog(this, msg, titulo, opt);
    }

}
