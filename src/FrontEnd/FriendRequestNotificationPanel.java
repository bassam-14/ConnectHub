/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd;

import lab9.FriendDatabase;
import lab9.FriendManagment;
import lab9.NotificationManager;

/**
 *
 * @author Zeina
 */
public class FriendRequestNotificationPanel extends javax.swing.JFrame {

    private final NotificationManager notificationManager;
    private FriendManagment friendManager;
    FriendDatabase friendDatabase = FriendDatabase.getInstance();
    private String requestId;
    /**
     * Creates new form FriendRequestNotificationPanel
     */
    public FriendRequestNotificationPanel(NotificationManager notificationManager, FriendManagment friendManager, String requestId) {
        initComponents();
        this.notificationManager = notificationManager;
        this.friendManager = friendManager;
        this.requestId = requestId;
        notificationMessage.setText(notificationManager.getNotification().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notificationMessage = new javax.swing.JLabel();
        accept = new javax.swing.JButton();
        decline = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        notificationMessage.setText("jLabel1");

        accept.setText("Accept");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        decline.setText("Decline");
        decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notificationMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decline)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notificationMessage)
                    .addComponent(accept)
                    .addComponent(decline))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        friendManager.acceptRequest(friendDatabase.getRecord(requestId + "-" + notificationManager.getUserId()));
    }//GEN-LAST:event_acceptActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        friendManager.declineRequest(friendDatabase.getRecord(requestId + "-" + notificationManager.getUserId()));
    }//GEN-LAST:event_declineActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton decline;
    private javax.swing.JLabel notificationMessage;
    // End of variables declaration//GEN-END:variables
}
