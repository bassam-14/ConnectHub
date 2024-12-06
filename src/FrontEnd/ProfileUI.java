/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontEnd;

import contentcreation.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import lab9.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Zeina
 */
public class ProfileUI extends javax.swing.JFrame {

    Profile profile;

    FriendManagment friendManager;
    FriendDatabase friendDatabase = FriendDatabase.getInstance();
    ContentDatabase contentDatabase = ContentDatabase.getInstance();
    UserDatabase userDatabase = UserDatabase.getInstance();

    private final User user;


    /**
     * Creates new form Profile
     *
     * @param user
     */
    public ProfileUI(User user) {
        this.user = user;
        profile=user.getProfile();
        FriendManagment friendmanager = new FriendManagment(user.getUserId());
        initComponents();
        //friendManager=new FriendManagment(user.getUserId());
        setTitle("Profile");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String pfpPath = profile.getPfpPath();
        ImageIcon pfp = new ImageIcon(pfpPath);
        Image pfpImage = pfp.getImage().getScaledInstance(profilePhoto.getWidth(), profilePhoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pfpIcon = new ImageIcon(pfpImage);
        profilePhoto.setIcon(pfpIcon);
        String cpPath = profile.getCpPath();
        ImageIcon cp = new ImageIcon(cpPath);
        Image cpImage = cp.getImage().getScaledInstance(coverPhoto.getWidth(), coverPhoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(cpImage);
        coverPhoto.setIcon(scaledIcon);
        String bio = profile.getBio();
       // bio1.setText(profile.getBio());
       bio1.setText("bruhh");
        //NewsFeedFriendStatus status = new NewsFeedFriendStatus(user);
        JPanel status=new JPanel();
        status.setBackground(Color.CYAN);
        status.setBounds(500,220,200,100);
       add(status);
        JPanel postsPanel = new JPanel();
        /*postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));
        List<PostsContentPanel> postsPanels = new ArrayList<>();
        List<Posts> allPosts = contentDatabase.getPostsByAuthor(user.getUserId());
        for (Posts post : allPosts) {
            postsPanels.add(new PostsContentPanel(post));
        }
        for (PostsContentPanel panel : postsPanels) {
            postsPanel.add(panel);
        }*/
        JScrollPane scrollPane = new JScrollPane(postsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 250, 230,230);
        add(scrollPane);
        JPanel storiesPanel = new JPanel();
        /*storiesPanel.setLayout(new BoxLayout(storiesPanel, BoxLayout.Y_AXIS));
        List<NewsFeedPanelStories> storiesPanels = new ArrayList<>();
        List<Stories> allStories = contentDatabase.getStoriesByAuthor(user.getUserId());
        for (Stories story : allStories) {
            storiesPanels.add(new NewsFeedPanelStories(story));
        }
        for (NewsFeedPanelStories panel : storiesPanels) {
            storiesPanel.add(panel);
        }*/
        JScrollPane scrollPane2 = new JScrollPane(storiesPanel);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(250,250, 230,230);
        add(scrollPane2);
        JPanel requestsPanel=new JPanel();
       /* requestsPanel.setLayout(new BoxLayout(requestsPanel, BoxLayout.Y_AXIS));
        List<ProfileRequests>requestPanels=new ArrayList<>();
        List<FriendRequest> friendRequests=friendDatabase.getRecievedRequests(user.getUserId());
        for(FriendRequest request:friendRequests){
            requestPanels.add(new ProfileRequests(friendManager,request.getSenderID()));
        }
        for(ProfileRequests panel:requestPanels){
            requestsPanel.add(panel);
        }*/
        JScrollPane scrollPane3 = new JScrollPane(requestsPanel);
        scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane3.setBounds(500, 330, 200, 150);
        add(scrollPane3);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coverPhoto = new javax.swing.JLabel();
        profilePhoto = new javax.swing.JLabel();
        changeCoverPhoto = new javax.swing.JButton();
        changeProfilephoto = new javax.swing.JButton();
        bio1 = new javax.swing.JLabel();
        changeBio = new javax.swing.JButton();
        block = new javax.swing.JButton();
        remove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        coverPhoto.setText("jLabel1");

        profilePhoto.setText("jLabel2");

        changeCoverPhoto.setText("Change Cover Photo");
        changeCoverPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeCoverPhotoActionPerformed(evt);
            }
        });

        changeProfilephoto.setText("Change Profile Photo");
        changeProfilephoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeProfilephotoActionPerformed(evt);
            }
        });

        bio1.setText("jLabel1");

        changeBio.setText("Change Bio");
        changeBio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBioActionPerformed(evt);
            }
        });

        block.setText("Block Friends");
        block.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockActionPerformed(evt);
            }
        });

        remove.setText("Remove Friends");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(changeCoverPhoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeProfilephoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeBio))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(coverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))

            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(block)
                .addGap(27, 27, 27)
                .addComponent(remove)
                .addGap(42, 42, 42))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeCoverPhoto)
                    .addComponent(changeProfilephoto)
                    .addComponent(changeBio))
                .addGap(8, 8, 8)
                .addComponent(bio1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(block)
                    .addComponent(remove))
                .addContainerGap(117, Short.MAX_VALUE))

        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeCoverPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCoverPhotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            profile.setCpPath(selectedFile.getAbsolutePath());
            ImageIcon cp = new ImageIcon(profile.getCpPath());
            Image cpImage = cp.getImage().getScaledInstance(coverPhoto.getWidth(), coverPhoto.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(cpImage);
            coverPhoto.setIcon(scaledIcon);
        }
        JOptionPane.showMessageDialog(null, "No file selected. Operation canceled.", "File Selection", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_changeCoverPhotoActionPerformed

    private void changeProfilephotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeProfilephotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            profile.setPfpPath(selectedFile.getAbsolutePath());
            ImageIcon pfp = new ImageIcon(profile.getPfpPath());
            Image pfpImage = pfp.getImage().getScaledInstance(profilePhoto.getWidth(), profilePhoto.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(pfpImage);
            profilePhoto.setIcon(scaledIcon);
        }
        JOptionPane.showMessageDialog(null, "No file selected. Operation canceled.", "File Selection", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_changeProfilephotoActionPerformed

    private void changeBioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBioActionPerformed
        String input = JOptionPane.showInputDialog(null, "Enter new Bio:", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
        profile.setBio(input);
        bio1.setText(profile.getBio());
    }//GEN-LAST:event_changeBioActionPerformed

    private void blockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockActionPerformed
        String userInput = JOptionPane.showInputDialog(null, "Enter friend name you want to block:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
        if (!friendDatabase.getFriends(user.getUserId()).contains(userInput)) {
            JOptionPane.showMessageDialog(null, "Friend not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        FriendManagment friendmanager = new FriendManagment(user.getUserId());
        friendmanager.blockUser(userInput);
        JOptionPane.showMessageDialog(null, userInput + " has been blocked.", "Message", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_blockActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
    String userInput = JOptionPane.showInputDialog(null, "Enter friend name you want to remove:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
        if (!friendDatabase.getFriends(user.getUserId()).contains(userInput)) {
            JOptionPane.showMessageDialog(null, "Friend not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        FriendManagment friendmanager = new FriendManagment(user.getUserId());
        friendmanager.removeFriend(userInput);
        JOptionPane.showMessageDialog(null, userInput + " has been removed.", "Message", JOptionPane.PLAIN_MESSAGE);    }//GEN-LAST:event_removeActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bio1;
    private javax.swing.JButton block;
    private javax.swing.JButton changeBio;
    private javax.swing.JButton changeCoverPhoto;
    private javax.swing.JButton changeProfilephoto;
    private javax.swing.JLabel coverPhoto;
    private javax.swing.JLabel profilePhoto;

    private javax.swing.JButton remove;

    // End of variables declaration//GEN-END:variables
}
