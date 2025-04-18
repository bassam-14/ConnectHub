/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package contentcreation;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import lab9.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author mazen
 */
public class PostsContentPanel extends javax.swing.JPanel {
UserDatabase userDatabase=UserDatabase.getInstance();
    /**
     * Creates new form PostsContentPanel
     * @param post
     */
    public PostsContentPanel(Posts post) {
        initComponents();
        userProfilePicture.setHorizontalAlignment(JLabel.CENTER);
        userProfilePicture.setVerticalAlignment(JLabel.CENTER);
        ImageIcon profileIcon = new ImageIcon(userDatabase.getRecord(post.getAuthorId()).getProfile().getPfpPath());
        Image image = profileIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(image);
        userProfilePicture.setIcon(profileIcon);
        userName.setText(userDatabase.getRecord(post.getAuthorId()).getUsername());
        userName.setHorizontalAlignment(JLabel.CENTER);
        userName.setVerticalAlignment(JLabel.CENTER);
        if(post.getContent().getImagepath()!= null){
        ImageIcon postIcon=new ImageIcon(post.getContent().getImagepath());
        Image postImage=postIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
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

        userName = new javax.swing.JLabel();
        userProfilePicture = new javax.swing.JLabel();
        userPost = new javax.swing.JLabel();
        userCaption = new javax.swing.JLabel();
        dateOfPost = new javax.swing.JLabel();

        userName.setText("Name");

        userProfilePicture.setBackground(new java.awt.Color(255, 255, 255));
        userProfilePicture.setText("Profile Picture");

        userPost.setBackground(new java.awt.Color(255, 255, 255));

        userCaption.setText("Caption");

        dateOfPost.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addComponent(userCaption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateOfPost, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userName)
                        .addGap(44, 44, 44)
                        .addComponent(userPost, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userCaption)
                .addGap(18, 18, 18)
                .addComponent(dateOfPost, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateOfPost;
    private javax.swing.JLabel userCaption;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userPost;
    private javax.swing.JLabel userProfilePicture;
    // End of variables declaration//GEN-END:variables
}
