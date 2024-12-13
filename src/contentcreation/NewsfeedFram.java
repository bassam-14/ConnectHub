/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package contentcreation;
import FrontEnd.AcceptedRequestNotificationPanel;
import FrontEnd.FriendRequestNotificationPanel;
import FrontEnd.GrpStatusChangedPanel;
import FrontEnd.MainUI;
import FrontEnd.NewGroupPostPanel;
import FrontEnd.ProfileUI;
import FrontEnd.UserAddedToGroupPanel;
import SearchFunctionality.*;
import lab9.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author mazen
 */
public class NewsfeedFram extends javax.swing.JFrame {

    private User currentuser;
    private final AccountManagement accmanage;
    FriendDatabase friendDatabase = FriendDatabase.getInstance();
    ContentDatabase contentDatabase = ContentDatabase.getInstance();
    UserDatabase userDatabase = UserDatabase.getInstance();
    NotificationDatabase notificationDatabase = NotificationDatabase.getInstance();
    private final FriendManagment friendManagment;
    //private final NotificationManager notificationManager;

    /**
     * Creates new form NewsfeedFram
     *
     * @param user
     */
    public NewsfeedFram(User user) {
        this.currentuser = user;
        friendManagment = FriendManagment.getInstance(user.getUserId());
        accmanage = new AccountManagement();
        initComponents();
        userProfile.setHorizontalAlignment(JLabel.CENTER);
        userProfile.setVerticalAlignment(JLabel.CENTER);
        setTitle(user.getUsername() + "'s Newsfeed");
        //setting profile photo
        ImageIcon profileIcon = new ImageIcon(user.getProfile().getPfpPath());
        Image image = profileIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        profileIcon = new ImageIcon(image);
        userProfile.setIcon(profileIcon);
        userName.setText(user.getUsername());
        userName.setHorizontalAlignment(JLabel.CENTER);
        userName.setVerticalAlignment(JLabel.CENTER);
        //initializing NewsFeedFriendStatus panel
        NewsFeedFriendStatus status = new NewsFeedFriendStatus(user);
        status.setBounds(0, 220, 300, 100);
        add(status);
        //initializing posts&stories panel 
        JPanel postsPanel = new JPanel();
        postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));
        List<PostsContentPanel> postsPanels = new ArrayList<>();
        List<String> friends = friendDatabase.getFriends(user.getUserId());
        List<Posts> allPosts = new ArrayList<>();
        for (String friend : friends) {
            allPosts.addAll(contentDatabase.getPostsByAuthor(friend));
        }
        for (Posts post : allPosts) {
            postsPanels.add(new PostsContentPanel(post));
        }
        for (PostsContentPanel panel : postsPanels) {
            postsPanel.add(panel);
        }
        JScrollPane scrollPane = new JScrollPane(postsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(300, 20, 530, 250);
        add(scrollPane);
        JPanel storiesPanel = new JPanel();
        storiesPanel.setLayout(new BoxLayout(storiesPanel, BoxLayout.Y_AXIS));
        List<NewsFeedPanelStories> storiesPanels = new ArrayList<>();
        List<String> friends2 = friendDatabase.getFriends(user.getUserId());
        List<Stories> allStories = new ArrayList<>();
        for (String friend : friends2) {
            allStories.addAll(contentDatabase.getStoriesByAuthor(friend));
        }
        for (Stories story : allStories) {
            storiesPanels.add(new NewsFeedPanelStories(story));
        }
        for (NewsFeedPanelStories panel : storiesPanels) {
            storiesPanel.add(panel);
        }
        JScrollPane scrollPane2 = new JScrollPane(storiesPanel);
        //adding vertical scrollbar
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(300, 280, 530, 200);
        add(scrollPane2);
        JPanel suggestionsPanel = new JPanel();
        suggestionsPanel.setLayout(new BoxLayout(suggestionsPanel, BoxLayout.Y_AXIS));
        List<NewsFeedFriendSuggestion> suggestionPanels = new ArrayList<>();
        List<String> friendSuggestion = friendManagment.getFriendSuggestions();
        for (String suggestion : friendSuggestion) {
            suggestionPanels.add(new NewsFeedFriendSuggestion(friendManagment, suggestion));
        }
        for (NewsFeedFriendSuggestion panel : suggestionPanels) {
            suggestionsPanel.add(panel);
        }
        JScrollPane scrollPane3 = new JScrollPane(suggestionsPanel);
        scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane3.setBounds(0, 330, 300, 200);
        add(scrollPane3);
        JPanel notificationsPanel = new JPanel();
        notificationsPanel.setLayout(new BoxLayout(notificationsPanel, BoxLayout.Y_AXIS));
        List<Notification> allNotifications = notificationDatabase.fetchAllNotifications(currentuser.getUserId());
        for (Notification notification : allNotifications) {
            if (notification.getType() == NotificationType.FRIEND_REQUEST) {
                if (isValidFriendRequestFormat(notification.getMessage())) {
                    String requestSenderId = notification.extractSenderId();
                    FriendRequestNotificationPanel notificationsPanel1 = new FriendRequestNotificationPanel(friendManagment, requestSenderId, notification.getNotificationId(), currentuser.getUserId());
                    notificationsPanel.add(notificationsPanel1);
                } else {
                    AcceptedRequestNotificationPanel notificationsPanel2 = new AcceptedRequestNotificationPanel(notification.getNotificationId());
                    notificationsPanel.add(notificationsPanel2);
                }
            } else if (notification.getType() == NotificationType.GROUP_ACTIVITY) {
                if (isGroupAddedNotification(notification.getMessage())) {
                    UserAddedToGroupPanel notificationsPanel3 = new UserAddedToGroupPanel(notification.getNotificationId());
                    notificationsPanel.add(notificationsPanel3);
                } else {
                    GrpStatusChangedPanel notificationsPanel4 = new GrpStatusChangedPanel(notification.getNotificationId());
                    notificationsPanel.add(notificationsPanel4);
                }
            } else {
                NewGroupPostPanel notificationsPanel5 = new NewGroupPostPanel(notification.getNotificationId());
                notificationsPanel.add(notificationsPanel5);
            }
        }
        JScrollPane scrollPane4 = new JScrollPane(notificationsPanel);
        scrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane4.setBounds(300, 450, 530, 200);
        add(scrollPane4);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                user.setStatus("offline");
                friendDatabase.saveData();
                contentDatabase.saveData();
                userDatabase.saveData();
                dispose();
            }
        });
    }

    public static boolean isValidFriendRequestFormat(String input) {
        // Regex pattern: any non-whitespace characters as senderID, followed by the exact message
        String pattern = "^\\S+ sent you a friend request$";
        return input.matches(pattern);
    }

    public static boolean isGroupAddedNotification(String input) {
        // Regex pattern to match "You were added to group <group name>"
        String pattern = "^You were added to group .+$";
        return input.matches(pattern);
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
        jLabel2 = new javax.swing.JLabel();
        userProfile = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        profile = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        addPost = new javax.swing.JButton();
        addStory = new javax.swing.JButton();
        FriendSearch = new javax.swing.JButton();
        GroupSearch = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profile.setText("Profile");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel3.setText("Friends");

        addPost.setText("Add Post");
        addPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPostActionPerformed(evt);
            }
        });

        addStory.setText("Add Story");
        addStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStoryActionPerformed(evt);
            }
        });

        FriendSearch.setText("Search For Friend");
        FriendSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriendSearchActionPerformed(evt);
            }
        });

        GroupSearch.setText("Search For Group");
        GroupSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(556, 556, 556))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addPost)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addStory))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(refresh))
                        .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FriendSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GroupSearch)))
                .addContainerGap(592, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FriendSearch, addPost, addStory, logout, refresh});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, Short.MAX_VALUE)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPost)
                    .addComponent(addStory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FriendSearch)
                    .addComponent(GroupSearch))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {FriendSearch, addPost, addStory, logout, profile, refresh});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        ProfileUI p = new ProfileUI(currentuser);
        p.setVisible(true);
    }//GEN-LAST:event_profileActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        java.awt.Window[] windows = java.awt.Window.getWindows();
        for (java.awt.Window window : windows) {
            if (window.isVisible() && !(window instanceof MainUI)) {
                window.dispose();
            }
        }
        //checking that the user is found
        if (currentuser != null && accmanage.logout(currentuser)) {
            currentuser = null;
            MainUI mainUI = new MainUI();
            mainUI.setVisible(true);
            this.dispose(); // Close the current frame
        } else {
            // Optionally, display a message if logout fails
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Logout failed. Please try again.",
                    "Logout Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        userDatabase.saveData();
        friendDatabase.saveData();
        contentDatabase.saveData();
        notificationDatabase.saveData();
        NewsfeedFram newframe = new NewsfeedFram(currentuser);
        newframe.setVisible(true);
        dispose();
    }//GEN-LAST:event_refreshActionPerformed

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
        contentDatabase.addRecord(new Posts(currentuser.getUserId(), new Content(caption, path), null));
    }//GEN-LAST:event_addPostActionPerformed

    private void addStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStoryActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an image");
        int result = fileChooser.showOpenDialog(null);
        String path = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            if (!path.matches(".*\\.(jpg|jpeg|png|gif)$")) {
                JOptionPane.showMessageDialog(null, "Please select a valid image file!", "Invalid File", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "An image is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        contentDatabase.addRecord(new Stories(currentuser.getUserId(), new Content(null, path), null));
    }//GEN-LAST:event_addStoryActionPerformed

    private void FriendSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriendSearchActionPerformed
        UserSearchFriendFrame p = new UserSearchFriendFrame(currentuser);
        p.setVisible(true);
    }//GEN-LAST:event_FriendSearchActionPerformed

    private void GroupSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupSearchActionPerformed
        GroupSearchFrame p = new GroupSearchFrame(currentuser);
        p.setVisible(true);
    }//GEN-LAST:event_GroupSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FriendSearch;
    private javax.swing.JButton GroupSearch;
    private javax.swing.JButton addPost;
    private javax.swing.JButton addStory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logout;
    private javax.swing.JButton profile;
    private javax.swing.JButton refresh;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userProfile;
    // End of variables declaration//GEN-END:variables
}
