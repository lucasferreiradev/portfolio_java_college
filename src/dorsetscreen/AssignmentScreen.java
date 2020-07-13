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
public class AssignmentScreen extends javax.swing.JInternalFrame {
    Connection conector = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form AssignmentScreen
     */
    public AssignmentScreen() {
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
                cboCourse.setSelectedItem(rs.getString(8));
                txtmodule.setText(rs.getString(13));
                cboSubjects.setSelectedItem(rs.getString(15));
                txtassignmentdescription.setText(rs.getString(16));
                txtassignmentdate.setText(rs.getString(17));
                txtassignmentweight.setText(rs.getString(19));
                txtassignmentgrade.setText(rs.getString(24));
            } else {
                JOptionPane.showMessageDialog(null, "User not found");
                txtiduser.setText(null);
                txtmodule.setText(null);
                cboCourse.setSelectedItem(null);
                txtassignmentdescription.setText(null);
                txtassignmentdate.setText(null);
                cboSubjects.setSelectedItem(null);
                txtassignmentweight.setText(null);
                txtassignmentgrade.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void adicionar() {
        String sql = "update tbusuarios set module=?, assignmentdescription=?, assignmentdate=?, assignmentweight=?, assignmentgrade=? where iduser=?";
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, txtmodule.getText());
            pst.setString(2, txtassignmentdescription.getText());
            pst.setString(3, txtassignmentdate.getText());
            pst.setString(4, txtassignmentweight.getText());
            pst.setString(5, txtassignmentgrade.getText());
            pst.setString(6, txtiduser.getText());

            //validating selected fields
            if ((txtusuario.getText().isEmpty())||(txtiduser.getText().isEmpty())|| (txtmodule.getText().isEmpty()) || (txtassignmentdescription.getText().isEmpty()) || (txtassignmentdate.getText().isEmpty()) || (txtassignmentweight.getText().isEmpty()) || (txtassignmentgrade.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Fill in all fields");
            } else {

                // coment: add new user
                int added = pst.executeUpdate();
                System.out.println(added);
                if (added > 0) {
                    JOptionPane.showMessageDialog(null, "Updated successfully");
                    txtiduser.setText(null);
                    txtmodule.setText(null);
                    txtassignmentdescription.setText(null);
                    txtassignmentdate.setText(null);
                    txtassignmentweight.setText(null);
                    txtassignmentgrade.setText(null);
                }
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

        txtassignmentdescription = new javax.swing.JTextField();
        cboCourse = new javax.swing.JComboBox<>();
        btnConfirm = new javax.swing.JButton();
        lblIdUser = new javax.swing.JLabel();
        lblcourse = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        lblIdUser1 = new javax.swing.JLabel();
        lblIdUser3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtmodule = new javax.swing.JTextField();
        lblIdUser2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtiduser = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblIdUser4 = new javax.swing.JLabel();
        txtassignmentdate = new javax.swing.JTextField();
        lblIdUser5 = new javax.swing.JLabel();
        txtassignmentweight = new javax.swing.JTextField();
        cboSubjects = new javax.swing.JComboBox<>();
        lblcourse1 = new javax.swing.JLabel();
        lblIdUser6 = new javax.swing.JLabel();
        txtassignmentgrade = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Assignment Lecturer");

        txtassignmentdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtassignmentdescriptionActionPerformed(evt);
            }
        });

        cboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "D_BSc_Science in Computing_1_Year", "D_BSc_Science in Computing_2_Year", "D_BSc_Science in Computing_3_Year", "C_BSc_Science in Computing_1_Year", "C_BSc_Science in Computing_2_Year", "C_BSc_Science in Computing_3_Year", "L_BSc_Science in Computing_1_Year", "L_BSc_Science in Computing_2_Year", "L_BSc_Science in Computing_3_Year", "D_BSc_Business_1_Year", "D_BSc_Business_2_Year", "D_BSc_Business_3_Year", "C_BSc_Business_1_Year", "C_BSc_Business_2_Year", "C_BSc_Business_3_Year", "L_BSc_Business_1_Year", "L_BSc_Business_2_Year", "L_BSc_Business_3_Year", "D_BSc_Finance_1_Year", "D_BSc_Finance_2_Year", "D_BSc_Finance_3_Year", "C_BSc_Finance_1_Year", "C_BSc_Finance_2_Year", "C_BSc_Finance_3_Year", "L_BSc_Finance_1_Year", "L_BSc_Finance_2_Year", "L_BSc_Finance_3_Year" }));
        cboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCourseActionPerformed(evt);
            }
        });

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconmonstr-check-mark-8-64.png"))); // NOI18N
        btnConfirm.setToolTipText("Add Payment");
        btnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirm.setPreferredSize(new java.awt.Dimension(80, 80));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        lblIdUser.setText("*ID");

        lblcourse.setText("*Course");

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

        lblIdUser3.setText("*Module");

        jLabel1.setText("*Required Fields");

        txtmodule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmoduleActionPerformed(evt);
            }
        });

        lblIdUser2.setText("Resume");

        txtiduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiduserActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("ASSIGNMENT LECTURER");

        lblIdUser4.setText("Due Date");

        txtassignmentdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtassignmentdateActionPerformed(evt);
            }
        });

        lblIdUser5.setText("Weight");

        txtassignmentweight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtassignmentweightActionPerformed(evt);
            }
        });

        cboSubjects.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "Y1_OOP - Basic Programing", "Y1_Database Management", "Y1_Front-End Development", "Y1_Data Sience", "Y1_Networking & Routing", "Y2_System & Operations", "Y2_DevOps", "Y2_Mobile Development", "Y2_Database Management", "Y2_OOP-Advanced Programing" }));
        cboSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSubjectsActionPerformed(evt);
            }
        });

        lblcourse1.setText("*Subject");

        lblIdUser6.setText("Result");

        txtassignmentgrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtassignmentgradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitle)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
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
                                .addComponent(lblcourse)
                                .addGap(18, 18, 18)
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblIdUser2)
                                    .addComponent(lblIdUser4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtassignmentdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtassignmentdate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblIdUser5)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtassignmentweight, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblIdUser6)
                                                        .addGap(2, 2, 2))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(35, 35, 35)
                                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(16, 16, 16)
                                        .addComponent(txtassignmentgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblcourse1)
                                .addGap(18, 18, 18)
                                .addComponent(cboSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 121, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblTitle))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcourse))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcourse1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUser)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUser1)
                    .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUser3)
                    .addComponent(txtmodule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUser2)
                    .addComponent(txtassignmentdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUser4)
                    .addComponent(txtassignmentdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUser5)
                    .addComponent(txtassignmentweight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUser6)
                    .addComponent(txtassignmentgrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCourseActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtmoduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmoduleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmoduleActionPerformed

    private void txtiduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtiduserActionPerformed

    private void txtassignmentdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtassignmentdescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtassignmentdescriptionActionPerformed

    private void txtassignmentdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtassignmentdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtassignmentdateActionPerformed

    private void txtassignmentweightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtassignmentweightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtassignmentweightActionPerformed

    private void cboSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSubjectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSubjectsActionPerformed

    private void txtassignmentgradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtassignmentgradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtassignmentgradeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
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
    private javax.swing.JLabel lblIdUser6;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblcourse;
    private javax.swing.JLabel lblcourse1;
    private javax.swing.JTextField txtassignmentdate;
    private javax.swing.JTextField txtassignmentdescription;
    private javax.swing.JTextField txtassignmentgrade;
    private javax.swing.JTextField txtassignmentweight;
    private javax.swing.JTextField txtiduser;
    private javax.swing.JTextField txtmodule;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
