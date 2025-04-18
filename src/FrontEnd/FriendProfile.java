/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package FrontEnd;

import contentcreation.NewsFeedPanelStories;
import contentcreation.Posts;
import contentcreation.PostsContentPanel;
import contentcreation.Stories;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import lab9.ContentDatabase;
import lab9.User;

/**
 *
 * @author Zeina
 */
public class FriendProfile extends javax.swing.JFrame {

    ContentDatabase contentDatabase = ContentDatabase.getInstance();
    private final User user;

    /**
     * Creates new form FriendProfile
     */
    public FriendProfile(User user) {
        initComponents();
        this.user = user;
        setTitle(user.getUsername() + "'s profile");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String pfpPath = user.getProfile().getPfpPath();
        ImageIcon pfp = new ImageIcon(pfpPath);
        Image pfpImage = pfp.getImage().getScaledInstance(174,101, Image.SCALE_SMOOTH);
        ImageIcon pfpIcon = new ImageIcon(pfpImage);
        profilePhoto.setIcon(pfpIcon);
        String cpPath = user.getProfile().getCpPath();
        ImageIcon cp = new ImageIcon(cpPath);
        Image cpImage = cp.getImage().getScaledInstance(597,130, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(cpImage);
        coverPhoto.setIcon(scaledIcon);
        bio.setText(user.getProfile().getBio());
        JPanel postsPanel = new JPanel();
        postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));
        List<PostsContentPanel> postsPanels = new ArrayList<>();
        List<Posts> allPosts = contentDatabase.getAllPostsByAuthor(user.getUserId());
        for (Posts post : allPosts) {
            postsPanels.add(new PostsContentPanel(post));
        }
        for (PostsContentPanel panel : postsPanels) {
            postsPanel.add(panel);
        }
        JScrollPane scrollPane = new JScrollPane(postsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0,180,400, 220);
        add(scrollPane);
        JPanel storiesPanel = new JPanel();
        storiesPanel.setLayout(new BoxLayout(storiesPanel, BoxLayout.Y_AXIS));
        List<NewsFeedPanelStories> storiesPanels = new ArrayList<>();
        List<Stories> allStories = contentDatabase.getAllStoriesByAuthor(user.getUserId());
        for (Stories story : allStories) {
            storiesPanels.add(new NewsFeedPanelStories(story));
        }
        for (NewsFeedPanelStories panel : storiesPanels) {
            storiesPanel.add(panel);
        }
        JScrollPane scrollPane2 = new JScrollPane(storiesPanel);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(410,180,400,220);
        add(scrollPane2);
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
        bio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(837, 444));
        setMinimumSize(new java.awt.Dimension(837, 444));

        coverPhoto.setText("jLabel1");

        profilePhoto.setText("jLabel2");

        bio.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coverPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bio;
    private javax.swing.JLabel coverPhoto;
    private javax.swing.JLabel profilePhoto;
    // End of variables declaration//GEN-END:variables
}
