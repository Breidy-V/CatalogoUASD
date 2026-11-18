
package catalogouasd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    private DefaultListModel<String> modeloCarreras = new DefaultListModel<>();
    private Map<String, Integer> facultades = new HashMap<>();
    private Map<String, Integer> escuelas = new HashMap<>();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    public VentanaPrincipal() {
        initComponents();
        listaCarreras.setModel(modeloCarreras);
        cargarFacultades();
        cmbFacultades.addActionListener(e -> cargarEscuelas());
        cargarEscuelas();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbFacultades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbEscuelas = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCarreras = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catálogo de Carreras UASD");
        setSize(new java.awt.Dimension(650, 450));

        jLabel1.setText("CATÁLOGO DE CARRERAS UASD");

        jLabel2.setText("Facultad:");

        cmbFacultades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFacultades.setToolTipText("");

        jLabel3.setText("Escuela:");

        cmbEscuelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnConsultar.setText("Consultar carreras");
        btnConsultar.addActionListener(this::btnConsultarActionPerformed);

        listaCarreras.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaCarreras);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(btnConsultar)
                            .addComponent(cmbEscuelas, 0, 325, Short.MAX_VALUE)
                            .addComponent(cmbFacultades, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbFacultades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEscuelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        cargarCarreras();
    }//GEN-LAST:event_btnConsultarActionPerformed
   
    private void cargarFacultades() {
    String sql = "SELECT Facultadid, Nombre FROM Facultades ORDER BY Nombre";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        cmbFacultades.removeAllItems();
        facultades.clear();

        while (rs.next()) {
            String nombre = rs.getString("Nombre");
            int id = rs.getInt("Facultadid");

            cmbFacultades.addItem(nombre);
            facultades.put(nombre, id);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

private void cargarEscuelas() {
    String nombreFacultad = (String) cmbFacultades.getSelectedItem();

    cmbEscuelas.removeAllItems();
    escuelas.clear();
    modeloCarreras.clear();

    if (nombreFacultad == null) {
        return;
    }

    int facultadId = facultades.get(nombreFacultad);

    String sql = "SELECT Escuelaid, Nombre FROM Escuelas WHERE Facultadid = ? ORDER BY Nombre";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setInt(1, facultadId);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                int id = rs.getInt("Escuelaid");

                cmbEscuelas.addItem(nombre);
                escuelas.put(nombre, id);
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

private void cargarCarreras() {
    String nombreEscuela = (String) cmbEscuelas.getSelectedItem();

    modeloCarreras.clear();

    if (nombreEscuela == null) {
        return;
    }

    int escuelaId = escuelas.get(nombreEscuela);

    String sql = "SELECT Nombre FROM Carreras WHERE Escuelaid = ? ORDER BY Nombre";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setInt(1, escuelaId);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                modeloCarreras.addElement(rs.getString("Nombre"));
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<String> cmbEscuelas;
    private javax.swing.JComboBox<String> cmbFacultades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaCarreras;
    // End of variables declaration//GEN-END:variables
}
