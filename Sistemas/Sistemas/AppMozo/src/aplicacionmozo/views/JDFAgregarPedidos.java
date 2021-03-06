package aplicacionmozo.views;

import aplicacionmozo.Sistema;
import aplicacionmozo.controllers.servicio.ServicioController;
import aplicacionmozo.controllers.servicio.UIServicio;
import entidades.Cliente;
import entidades.Mesa;
import entidades.Producto;
import entidades.Servicio;
import java.util.ArrayList;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Ignacio, Juan
 */
public class JDFAgregarPedidos extends javax.swing.JDialog implements UIServicio {

    private ServicioController controller;
    private Mesa m;

    /**
     * Creates new form JDFAgregarPedidos
     */
    public JDFAgregarPedidos(java.awt.Frame parent, boolean modal, Mesa m) {
        super(parent, modal);
        initComponents();
        this.m = m;

        if (this.m.getServicio() == null) {
            this.m.setServicio(new Servicio());
        }
        if (this.m.getServicio().getCliente() != null) {
            jcbSelectCliente.setSelectedItem(this.m.getServicio().getCliente());
            lblTituloAltaPedido.setText(m.getServicio().getCliente().getNombre());
        }

        controller = new ServicioController(Sistema.getService(), this, m);
        lblTituloAltaPedido.setText("Agregar pedidos - N° Mesa: " + m.getNumero());
        controller.obtenerClientes();
        controller.listarProductos();
        listarPedido(m);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTituloAltaPedido = new javax.swing.JLabel();
        jcbSelectProducto = new javax.swing.JComboBox<>();
        lblDescripcion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numCantidad = new javax.swing.JSpinner();
        btnAplicarPedido = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnCerrarMesa = new javax.swing.JButton();
        jcbSelectCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstListadoPedidos = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(98, 160, 240));

        lblTituloAltaPedido.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 18)); // NOI18N
        lblTituloAltaPedido.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloAltaPedido.setText("Agregar pedidos - Mesa: 2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTituloAltaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTituloAltaPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jcbSelectProducto.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jcbSelectProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSelectProductoItemStateChanged(evt);
            }
        });

        lblDescripcion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(51, 51, 51));
        lblDescripcion.setText("Descripción");

        jLabel3.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Seleccionar cantidad");

        numCantidad.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        numCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        btnAplicarPedido.setBackground(new java.awt.Color(98, 160, 240));
        btnAplicarPedido.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        btnAplicarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnAplicarPedido.setText("Aplicar");
        btnAplicarPedido.setBorder(null);
        btnAplicarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarPedidoActionPerformed(evt);
            }
        });

        lblTotal.setBackground(new java.awt.Color(204, 204, 255));
        lblTotal.setFont(new java.awt.Font("Digital-7 Mono", 1, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("Total: 0");
        lblTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnCerrarMesa.setBackground(new java.awt.Color(98, 160, 240));
        btnCerrarMesa.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        btnCerrarMesa.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarMesa.setText("Cerrar mesa");
        btnCerrarMesa.setBorder(null);
        btnCerrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarMesaActionPerformed(evt);
            }
        });

        jcbSelectCliente.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jcbSelectCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSelectClienteItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Seleccionar cliente");

        lstListadoPedidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lstListadoPedidos.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(lstListadoPedidos);

        jLabel5.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Seleccionar producto");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblMensaje.setBackground(new java.awt.Color(255, 102, 102));
        lblMensaje.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(280, 280, 280))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnCerrarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jcbSelectProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(57, 57, 57)
                                    .addComponent(btnAplicarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcbSelectCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                            .addGap(249, 249, 249)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSelectCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSelectProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAplicarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAplicarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarPedidoActionPerformed
        lblMensaje.setText("");
        controller.agregarLineaServicio();
    }//GEN-LAST:event_btnAplicarPedidoActionPerformed

    private void btnCerrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarMesaActionPerformed
        controller.cerrarMesa();
    }//GEN-LAST:event_btnCerrarMesaActionPerformed

    private void jcbSelectClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSelectClienteItemStateChanged
        if (jcbSelectCliente.getSelectedIndex() > 0) {
            Cliente c = (Cliente) evt.getItem();
            m.getServicio().setCliente(c);
            lblTotal.setText("Total: " + Float.toString(m.getServicio().calcularTotal()));
            controller.setCliente(c);
        }
    }//GEN-LAST:event_jcbSelectClienteItemStateChanged

    private void jcbSelectProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSelectProductoItemStateChanged
        if (jcbSelectProducto.getSelectedIndex() > -1) {
            Producto p = (Producto) evt.getItem();
            SpinnerNumberModel model = new SpinnerNumberModel(1, 1, p.getStock(), 1);
            numCantidad.setModel(model);
        }
    }//GEN-LAST:event_jcbSelectProductoItemStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDFAgregarPedidos dialog = new JDFAgregarPedidos(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarPedido;
    private javax.swing.JButton btnCerrarMesa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<Cliente> jcbSelectCliente;
    private javax.swing.JComboBox<Producto> jcbSelectProducto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTituloAltaPedido;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<Object> lstListadoPedidos;
    private javax.swing.JSpinner numCantidad;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getCantidad() {
        return (Integer) numCantidad.getValue();
    }

    @Override
    public Producto getProducto() {
        return (Producto) jcbSelectProducto.getSelectedItem();
    }

    @Override
    public Cliente getCliente() {
        return (Cliente) jcbSelectCliente.getSelectedItem();
    }

    @Override
    public void listarClientes(ArrayList<Cliente> col) {
        jcbSelectCliente.addItem(null);
        for (Cliente c : col) {
            jcbSelectCliente.addItem(c);
        }
    }

    @Override
    public void listarProdcutos(ArrayList<Producto> col) {
        for (Producto p : col) {
            jcbSelectProducto.addItem(p);
        }
    }

    @Override
    public void mostrarMensaje(String msg) {
        lblMensaje.setText(msg);
    }

    @Override
    public void listarPedido(Mesa mesa) {
        lstListadoPedidos.setListData(mesa.getServicio().getLineas().toArray());
        lblTotal.setText("Total: " + Float.toString(mesa.getServicio().calcularTotal()));
    }

    @Override
    public void cerrarForm() {
        this.dispose();
    }

    @Override
    public String getDescripcion() {
        return txtDescripcion.getText();
    }

}
