/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sena.medi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author ADMIN
 */
public class Gestionar_Pacientes extends javax.swing.JFrame {
    conexion co= new conexion();
     Connection conet;
     Statement st;
     ResultSet rs;
     DefaultTableModel modelo;
     int idc;
    
     
     
    /**
     * Creates new form Gestionar_Pacientes
     */
    public Gestionar_Pacientes() {
        initComponents();
     
        consultar();
        
        
    }
    
    public void limpiar(){
    
    while(modelo.getRowCount()>0){
        modelo.removeRow(0);
    
    }
    
    }
   
   

        public void Agregar(){
        try{
        //primera parte obtener la informacion
        int id = Integer.parseInt(txtid.getText()); //123
        String nombres= txtnombres.getText(); // luis
        String apellidos = txtapellidos.getText();
        
        java.util.Date fechaseleccionada = jdfecha.getDate(); // 110225
        java.sql.Date fechanacimiento = new java.sql.Date(fechaseleccionada.getTime()); //110225
        
        String sexo =rbmasculino.isSelected() ? "M" : "F";
        
        //segunda parte enviar la informacion obtenida a la base de datos
        
        String sql = "Insert into pacientes (PacIdentificacion,PacNombres,PacApellidos,PacFechaNacimiento,PacSexo)Values (?,?,?,?,?)";
           
        conet= co.getConnection();
       PreparedStatement ps= conet.prepareStatement(sql);
       ps.setInt(1, id);
        ps.setString(2, nombres);
         ps.setString(3, apellidos);    
        ps.setDate(4, fechanacimiento);     
         ps.setString(5, sexo);
         ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Se ha realizo el registro");
             limpiar();
            consultar();
           
        
        }catch (SQLException e){
          JOptionPane.showMessageDialog(null, "No se pudo ingresar");
            System.err.println("" +e);
        }

        
        }
   
        public void consultar(){
        String sql= "select * from pacientes";
        try{
        conet=co.getConnection();
        st=conet.createStatement();
        rs=st.executeQuery(sql);
        Object[] persona=new Object[5];
        modelo = (DefaultTableModel) jtregistro.getModel();
        while (rs.next()){
        persona [0]=rs.getInt("PacIdentificacion");
        persona [1]=rs.getString("PacNombres");
        persona [2]=rs.getString("PacApellidos");
        persona [3]=rs.getString("PacFechaNacimiento");
        persona [4]=rs.getString("PacSexo");
        modelo.addRow(persona);
        }
        jtregistro.setModel(modelo);
        
        
        }catch(Exception e){
        
        
        }
       
        }
        
        public void actualizar(){
        try {
        int fila = jtregistro.getSelectedRow();
        if (fila ==-1){
          JOptionPane.showMessageDialog(null,"Seleccione una fila");
         return;
        }
        int id=Integer.parseInt(jtregistro.getValueAt(fila,0).toString());
        String nombres= txtnombres.getText(); // luis
        String apellidos = txtapellidos.getText();
        
        //fecha
        java.util.Date fechaseleccionada = jdfecha.getDate(); // 110225
        java.sql.Date fechanacimiento = new java.sql.Date(fechaseleccionada.getTime());
        
        //sexo
        String sexo =rbmasculino.isSelected() ? "M" : "F";
        
        //consulta
        String sql= "UPDATE pacientes SET PacNombres=?,PacApellidos=?,PacFechaNacimiento=?,PacSexo=? WHERE PacIdentificacion";
        Connection conet= co.getConnection();
        PreparedStatement pst = conet.prepareStatement(sql);
        
       
        pst.setString(1, nombres);
         pst.setString(2, apellidos);    
        pst.setDate(3, fechanacimiento);     
         pst.setString(4, sexo);
        pst.setInt(5, id);
         int filasactualizadas = pst.executeUpdate();
         if (filasactualizadas > 0 ){
           JOptionPane.showMessageDialog(null,"Registro Actualizado");
           limpiar();
           consultar();
         }else{
         JOptionPane.showMessageDialog(null,"No se encontro un registro para actualizar");
         }
         
        }catch (SQLException e){
            System.out.println("error al actualizar"+e);
        }
        
        }
     

        
        
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        rbfemenino = new javax.swing.JRadioButton();
        rbmasculino = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtregistro = new javax.swing.JTable();
        jdfecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Gestion de Pacientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 56, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 558, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("ACTUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("LIMPIAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel7.setText("Volver Menu Principal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton4)
                            .addComponent(jButton3)
                            .addComponent(jButton1))
                        .addGap(21, 21, 21))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addGap(33, 33, 33)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addGap(32, 32, 32)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 2, 140, 560));

        jLabel2.setText("Identificacion ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jLabel3.setText("Nombres");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        jLabel4.setText("Apellidos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jLabel5.setText("Fecha de Nacimiento");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jLabel6.setText("Sexo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 130, -1));
        getContentPane().add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 130, -1));
        getContentPane().add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 130, -1));

        buttonGroup1.add(rbfemenino);
        rbfemenino.setText("Femenino");
        getContentPane().add(rbfemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        buttonGroup1.add(rbmasculino);
        rbmasculino.setText("Masculino");
        getContentPane().add(rbmasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        jtregistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificacion", "Nombres", "Apellidos", "F. Nacimiento", "Sexo"
            }
        ));
        jtregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtregistroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtregistro);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 520, 240));
        getContentPane().add(jdfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
       Agregar();
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtregistroMouseClicked
       txtid.setEditable(false);
       int fila = jtregistro.getSelectedRow();
      if (fila ==-1){
          JOptionPane.showMessageDialog(null,"Seleccione una fila");
      }else{
      idc=Integer.parseInt(jtregistro.getValueAt(fila,0).toString());
      String nombres= (String) jtregistro.getValueAt(fila, 1);
      String apellidos= (String) jtregistro.getValueAt(fila, 2);
      
       //obtener la fecha de la tabla (esta en formato string)
      Object fechaobj = jtregistro.getValueAt(fila,3);
      if(fechaobj instanceof  java.sql.Date){
      java.sql.Date fechasql = (java.sql.Date) fechaobj;
      jdfecha.setDate(new java.util.Date(fechasql.getTime()));
      }else if (fechaobj instanceof String){
          try{
          SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); //ajustar al formato
          java.util.Date fecha = formato.parse((String) fechaobj);
          jdfecha.setDate(fecha);
          }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al convertir la fecha");
          }
      
      
      }
       
      //traer el sexo reiniciarlo
      
      String sexotexto = (String) jtregistro.getValueAt(fila,4);
      if(sexotexto.equalsIgnoreCase("M")){
       rbmasculino.setSelected(true);
       rbfemenino.setSelected(false);
      }else if(sexotexto.equalsIgnoreCase("F")){
       rbfemenino.setSelected(true);
       rbmasculino.setSelected(false);
      }
      txtid.setText(""+idc);
      txtnombres.setText(nombres);
      txtapellidos.setText(apellidos);
      }
    }//GEN-LAST:event_jtregistroMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Gestionar_Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_Pacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdfecha;
    private javax.swing.JTable jtregistro;
    private javax.swing.JRadioButton rbfemenino;
    private javax.swing.JRadioButton rbmasculino;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombres;
    // End of variables declaration//GEN-END:variables
}
