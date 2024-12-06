/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package contentcreation;

import java.awt.Image;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import lab9.*;

/**
 *
 * @author mazen
 */
public class NewsFeedPanelStories extends javax.swing.JPanel {
UserDatabase userDatabase=UserDatabase.getInstance();
    /**
     * Creates new form NewsFeedPanelStories
     * @param story
     */
    public NewsFeedPanelStories(Stories story) {
        initComponents();
        userProfile.setHorizontalAlignment(JLabel.CENTER);
        userProfile.setVerticalAlignment(JLabel.CENTER);
        ImageIcon profileIcon = new ImageIcon(userDatabase.getRecord(story.getAuthorId()).getProfile().getPfpPath());
        Image image = profileIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(image);
        userProfile.setIcon(profileIcon);
        userName.setText(userDatabase.getRecord(story.getAuthorId()).getUsername());
        userName.setHorizontalAlignment(JLabel.CENTER);
        userName.setVerticalAlignment(JLabel.CENTER);
        if(story.getContent().getImagepath()!= null){
        ImageIcon postIcon=new ImageIcon(story.getContent().getImagepath());
        Image postImage=postIcon.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        postIcon=new ImageIcon(postImage);
        userStory.setIcon(postIcon);
        }
        else {
            userStory.setText("No image attached");
        }
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        date.setText(story.getCreatedtime().format(formatter));
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
        userStory = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        userProfile = new javax.swing.JLabel();

        userName.setText("Name");

        date.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userStory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userName)
                        .addGap(0, 248, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userName)
                    .addComponent(userProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userStory, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userProfile;
    private javax.swing.JLabel userStory;
    // End of variables declaration//GEN-END:variables
}
