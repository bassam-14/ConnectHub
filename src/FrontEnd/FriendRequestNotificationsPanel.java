/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import lab9.*;

/**
 *
 * @author bassam
 */
public class FriendRequestNotificationsPanel extends javax.swing.JPanel {
    private final FriendManagment friendManager;
    private final String userId;
    private final FriendDatabase friendDatabase=FriendDatabase.getInstance();
    private final String requestId;
    /**
     * Creates new form FriendRequestNotificationPanel
     * @param friendManager
     * @param requestId
     * @param notification
     * @param userID
     */
    public FriendRequestNotificationsPanel(FriendManagment friendManager, String requestId,Notification notification , String userID) {
        initComponents();
        this.friendManager = friendManager;
        this.requestId = requestId;
        this.userId=userID;
        notificationMessage.setText(notification.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        notificationMessage = new javax.swing.JLabel();
        accept = new javax.swing.JButton();
        decline = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        notificationMessage.setText("jLabel2");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notificationMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decline)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notificationMessage)
                    .addComponent(accept)
                    .addComponent(decline))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        friendManager.acceptRequest(friendDatabase.getRecord(requestId+"-"+userId));
    }//GEN-LAST:event_acceptActionPerformed

    private void declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declineActionPerformed
        friendManager.declineRequest(friendDatabase.getRecord(requestId+"-"+userId));
    }//GEN-LAST:event_declineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton decline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel notificationMessage;
    // End of variables declaration//GEN-END:variables
}
