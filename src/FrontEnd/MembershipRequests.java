/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import lab9.GroupManagement;
import lab9.UserDatabase;

/**
 *
 * @author Zeina
 */
public class MembershipRequests extends javax.swing.JPanel {

    private GroupManagement grpmanage;
    UserDatabase userDatabase = UserDatabase.getInstance();
    private String userId;
    private String adminId;

    /**
     * Creates new form MembershipRequests
     */
    public MembershipRequests(GroupManagement grpmanage, String userId, String adminId) {
        initComponents();
        this.grpmanage = grpmanage;
        this.adminId = adminId;
        this.userId = userId;
        memberUsername.setText(userDatabase.getRecord(userId).getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memberUsername = new javax.swing.JLabel();
        approve = new javax.swing.JButton();
        decline = new javax.swing.JButton();

        memberUsername.setText("jLabel1");

        approve.setText("Approve");
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });

        decline.setText("Decline");
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(memberUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(approve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decline)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(approve)
                    .addComponent(decline))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed
        grpmanage.approveMembershipRequest(adminId, userId);
    }//GEN-LAST:event_approveActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        grpmanage.declineMembershipRequest(adminId, userId);
    }//GEN-LAST:event_declineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve;
    private javax.swing.JButton decline;
    private javax.swing.JLabel memberUsername;
    // End of variables declaration//GEN-END:variables
}
