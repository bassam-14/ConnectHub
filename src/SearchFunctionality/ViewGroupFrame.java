/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SearchFunctionality;

import contentcreation.Content;
import contentcreation.Posts;
import contentcreation.PostsContentPanel;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import lab9.*;

/**
 *
 * @author bassam
 */
public class ViewGroupFrame extends javax.swing.JFrame {

    private Group currentgroup;
    private User user;
    private GroupManagement grpmanage;
    GroupDatabase groupdata = GroupDatabase.getInstance();
    ContentDatabase contentdata = ContentDatabase.getInstance();
    private final String grpid;

    /**
     * Creates new form ViewGroupFrame
     *
     * @param group
     */
    public ViewGroupFrame(Group group, User user) {
        this.currentgroup = group;
        this.grpid = group.getGroupId();
        this.user = user;
        grpmanage = GroupManagement.getInstance(group.getGroupId());
        initComponents();
        GroupProfile.setHorizontalAlignment(JLabel.CENTER);
        GroupProfile.setVerticalAlignment(JLabel.CENTER);
        ImageIcon profileIcon = new ImageIcon(group.getGroupPhoto());
        Image image = profileIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(image);
        GroupProfile.setIcon(profileIcon);
        setTitle(group.getName() + "- view group");
        GroupName.setText(group.getName());
        GroupName.setText(GroupName.getName());
        GroupName.setHorizontalAlignment(JLabel.CENTER);
        GroupName.setVerticalAlignment(JLabel.CENTER);
        // initializing group posts
        JPanel grouppanel = new JPanel();
        grouppanel.setLayout(new BoxLayout(grouppanel, BoxLayout.Y_AXIS));
        List<PostsContentPanel> postsPanels = new ArrayList<>();
        List<Posts> allPosts = contentdata.getGroupPosts(grpid);
        for (Posts post : allPosts) {
            postsPanels.add(new PostsContentPanel(post));
            for (PostsContentPanel panel : postsPanels) {
                grouppanel.add(panel);
            }
            JScrollPane scrollPane = new JScrollPane(grouppanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            add(scrollPane);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupProfile = new javax.swing.JLabel();
        GroupName = new javax.swing.JLabel();
        leave = new javax.swing.JButton();
        addPost = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupProfile.setText("jLabel1");

        GroupName.setText("jLabel2");

        leave.setText("Leave Group");
        leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveActionPerformed(evt);
            }
        });

        addPost.setText("Add Post");
        addPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GroupProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leave, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GroupProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GroupName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(addPost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(leave)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPostActionPerformed
        //opening file choser from desktop to select a photo
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
        caption = JOptionPane.showInputDialog(null, "Enter Caption (Optional):", "Add Caption", JOptionPane.PLAIN_MESSAGE);
        if ((path == null || path.isEmpty()) && (caption == null || caption.trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "You must provide either an image or a caption!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        grpmanage.addPost(user.getUserId(), new Content(caption, path));

    }//GEN-LAST:event_addPostActionPerformed

    private void leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaveActionPerformed
        grpmanage.leaveGroup(user.getUserId()); 

    }//GEN-LAST:event_leaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GroupName;
    private javax.swing.JLabel GroupProfile;
    private javax.swing.JButton addPost;
    private javax.swing.JButton leave;
    // End of variables declaration//GEN-END:variables
}
