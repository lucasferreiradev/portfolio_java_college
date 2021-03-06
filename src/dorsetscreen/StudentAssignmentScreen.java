/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dorsetscreen;
import java.sql.*;
import dorsetdata.ConnectionModule;
import javax.swing.JOptionPane;
/**
 *
 * @author lukfd
 */
public class StudentAssignmentScreen extends javax.swing.JInternalFrame {
    Connection conector = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form StudentAssignmentScreen
     */
    public StudentAssignmentScreen() {
        initComponents();
                conector = ConnectionModule.conector();
    }
private void consultar() {
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, txtiduser.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtusuario.setText(rs.getString(2));
                txtmodule.setText(rs.getString(13));
                cboCourse.setSelectedItem(rs.getString(8));
                txtassignment.setText(rs.getString(16));
                txtassignmentdate.setText(rs.getString(17));
                cboSubjects.setSelectedItem(rs.getString(15));
                txtassignmentweight.setText(rs.getString(19));
            } else {
                JOptionPane.showMessageDialog(null, "User not found");
                txtiduser.setText(null);
                txtmodule.setText(null);
                cboCourse.setSelectedItem(null);
                txtassignment.setText(null);
                txtassignmentdate.setText(null);
                cboSubjects.setSelectedItem(null);
                txtassignmentweight.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        lblIdUser3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtmodule = new javax.swing.JTextField();
        lblIdUser2 = new javax.swing.JLabel();
        txtassignment = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtiduser = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblIdUser = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        lblIdUser1 = new javax.swing.JLabel();
        lblIdUser4 = new javax.swing.JLabel();
        txtassignmentdate = new javax.swing.JTextField();
        cboCourse = new javax.swing.JComboBox<>();
        lblcourse = new javax.swing.JLabel();
        cboSubjects = new javax.swing.JComboBox<>();
        lblcourse1 = new javax.swing.JLabel();
        lblIdUser5 = new javax.swing.JLabel();
        txtassignmentweight = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Assignment Student");

        lblIdUser3.setText("*Module");

        jLabel1.setText("*Required Fields");

        txtmodule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmoduleActionPerformed(evt);
            }
        });

        lblIdUser2.setText("Resume");

        txtassignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtassignmentActionPerformed(evt);
            }
        });

        txtiduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiduserActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("ASSIGNMENT STUDENT");

        lblIdUser.setText("*ID");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconmonstr-magnifier-10-64.png"))); // NOI18N
        btnSearch.setToolTipText("Consult Payment");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblIdUser1.setText("*Name");

        lblIdUser4.setText("Due Date");

        txtassignmentdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtassignmentdateActionPerformed(evt);
            }
        });

        cboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "D_BSc_Science in Computing_1_Year", "D_BSc_Science in Computing_2_Year", "D_BSc_Science in Computing_3_Year", "C_BSc_Science in Computing_1_Year", "C_BSc_Science in Computing_2_Year", "C_BSc_Science in Computing_3_Year", "L_BSc_Science in Computing_1_Year", "L_BSc_Science in Computing_2_Year", "L_BSc_Science in Computing_3_Year", "D_BSc_Business_1_Year", "D_BSc_Business_2_Year", "D_BSc_Business_3_Year", "C_BSc_Business_1_Year", "C_BSc_Business_2_Year", "C_BSc_Business_3_Year", "L_BSc_Business_1_Year", "L_BSc_Business_2_Year", "L_BSc_Business_3_Year", "D_BSc_Finance_1_Year", "D_BSc_Finance_2_Year", "D_BSc_Finance_3_Year", "C_BSc_Finance_1_Year", "C_BSc_Finance_2_Year", "C_BSc_Finance_3_Year", "L_BSc_Finance_1_Year", "L_BSc_Finance_2_Year", "L_BSc_Finance_3_Year" }));
        cboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCourseActionPerformed(evt);
            }
        });

        lblcourse.setText("*Course");

        cboSubjects.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "Y1_OOP - Basic Programing", "Y1_Database Management", "Y1_Front-End Development", "Y1_Data Sience", "Y1_Networking & Routing", "Y2_System & Operations", "Y2_DevOps", "Y2_Mobile Development", "Y2_Database Management", "Y2_OOP-Advanced Programing" }));
        cboSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubjectsActionPerformed(evt);
            }
        });

        lblcourse1.setText("*Subject");

        lblIdUser5.setText("Weight");

        txtassignmentweight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtassignmentweightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(535, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdUser)
                                .addGap(18, 18, 18)
                                .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lblIdUser1)
                                .addGap(18, 18, 18)
                                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lblIdUser3)
                                .addGap(18, 18, 18)
                                .addComponent(txtmodule, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdUser2)
                                .addGap(18, 18, 18)
                                .addComponent(txtassignment, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdUser4)
                                .addGap(18, 18, 18)
                                .addComponent(txtassignmentdate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(214, 214, 214)
                                .addComponent(lblIdUser5)
                                .addGap(18, 18, 18)
                                .addComponent(txtassignmentweight, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblcourse)
                                .addGap(18, 18, 18)
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblcourse1)
                                .addGap(18, 18, 18)
                                .addComponent(cboSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(153, 153, 153))))
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcourse))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcourse1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUser)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUser1)
                    .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUser3)
                    .addComponent(txtmodule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUser2)
                    .addComponent(txtassignment, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdUser5)
                        .addComponent(txtassignmentweight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdUser4)
                        .addComponent(txtassignmentdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmoduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmoduleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmoduleActionPerformed

    private void txtassignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtassignmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtassignmentActionPerformed

    private void txtiduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtiduserActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtassignmentdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtassignmentdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtassignmentdateActionPerformed

    private void cboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCourseActionPerformed

    private void cboSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubjectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSubjectsActionPerformed

    private void txtassignmentweightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtassignmentweightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtassignmentweightActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JComboBox<String> cboSubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIdUser;
    private javax.swing.JLabel lblIdUser1;
    private javax.swing.JLabel lblIdUser2;
    private javax.swing.JLabel lblIdUser3;
    private javax.swing.JLabel lblIdUser4;
    private javax.swing.JLabel lblIdUser5;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblcourse;
    private javax.swing.JLabel lblcourse1;
    private javax.swing.JTextField txtassignment;
    private javax.swing.JTextField txtassignmentdate;
    private javax.swing.JTextField txtassignmentweight;
    private javax.swing.JTextField txtiduser;
    private javax.swing.JTextField txtmodule;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
