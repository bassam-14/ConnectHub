/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SearchFunctionality;

import java.awt.Image;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import contentcreation.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import lab9.*;

/**
 *
 * @author bassam
 */
public class AdminPostPanel extends javax.swing.JPanel {
UserDatabase userDatabase=UserDatabase.getInstance();
private final GroupManagement grpmanage;
private final String adminId;
private final String postId;
private final ContentCreation post;
    /**
     * Creates new form AdminPostPanel
     * @param post
     * @param group
     * @param adminId
     */
    public AdminPostPanel(Posts post,Group group,String adminId) {
        initComponents();
        this.adminId=adminId;
        postId=post.getContentId();
        this.post=(ContentCreation)post;
        grpmanage=GroupManagement.getInstance(group.getGroupId());
        userProfilePicture.setHorizontalAlignment(JLabel.CENTER);
        userProfilePicture.setVerticalAlignment(JLabel.CENTER);
        ImageIcon profileIcon = new ImageIcon(userDatabase.getRecord(post.getAuthorId()).getProfile().getPfpPath());
        Image image = profileIcon.getImage().getScaledInstance(94,99, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(image);
        userProfilePicture.setIcon(profileIcon);
        userName.setText(userDatabase.getRecord(post.getAuthorId()).getUsername());
        userName.setHorizontalAlignment(JLabel.CENTER);
        userName.setVerticalAlignment(JLabel.CENTER);
        if(post.getContent().getImagepath()!= null){
        ImageIcon postIcon=new ImageIcon(post.getContent().getImagepath());
        Image postImage=postIcon.getImage().getScaledInstance(158,111, Image.SCALE_SMOOTH);
        postIcon=new ImageIcon(postImage);
        userPost.setIcon(postIcon);
        }
        else {
            userPost.setText("No image attached");
        }
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dateOfPost.setText(post.getCreatedtime().format(formatter));
        userCaption.setText(post.getContent().getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userProfilePicture = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        userPost = new javax.swing.JLabel();
        userCaption = new javax.swing.JLabel();
        dateOfPost = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        userName.setText("jLabel2");

        userCaption.setText("jLabel4");

        dateOfPost.setText("jLabel5");

        edit.setText("Edit Post");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("Delete Post");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(userName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(userCaption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edit)
                    .addComponent(delete))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateOfPost, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userName)
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edit)
                                .addGap(28, 28, 28)
                                .addComponent(delete))
                            .addComponent(userPost, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userCaption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateOfPost)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an image");
        int result = fileChooser.showOpenDialog(null);
        String path = null;
        String caption = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            //getting photo path
            path = selectedFile.getAbsolutePath();
            if (!path.matches(".*\\.(jpg|jpeg|png|gif)$")) {
                JOptionPane.showMessageDialog(null, "Please select a valid image file!", "Invalid File", JOptionPane.ERROR_MESSAGE);
                path = null;
            }
        }
        caption = JOptionPane.showInputDialog(null, "Enter Caption :", "Add Caption", JOptionPane.PLAIN_MESSAGE);
        if (caption==null)caption=post.getContent().getText();
        if(path==null)path=post.getContent().getImagepath();
        grpmanage.editPost(adminId,postId,new Content(caption,path));
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        grpmanage.deletePost(adminId,postId);
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateOfPost;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel userCaption;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userPost;
    private javax.swing.JLabel userProfilePicture;
    // End of variables declaration//GEN-END:variables
}
