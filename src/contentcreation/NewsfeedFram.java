/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package contentcreation;

import FrontEnd.*;
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
    GroupDatabase groupDatabase=GroupDatabase.getInstance();
    private final FriendManagment friendManagment;

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
        status.setBounds(200, 30,200,150);
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
        scrollPane.setBounds(400, 20, 530, 250);
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
        scrollPane2.setBounds(400, 280, 530, 200);
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
                    FriendRequestNotificationsPanel notificationsPanel1 = new FriendRequestNotificationsPanel(friendManagment, requestSenderId, notification, currentuser.getUserId());
                    notificationsPanel.add(notificationsPanel1);
                } else {
                    AcceptedRequestNotificationPanel notificationsPanel2 = new AcceptedRequestNotificationPanel(notification);
                    notificationsPanel.add(notificationsPanel2);
                }
            } else if (notification.getType() == NotificationType.GROUP_ACTIVITY) {
                if (isGroupAddedNotification(notification.getMessage())) {
                    Group grp = notification.extractGroup();
                    UserAddedToGroupsPanel notificationsPanel3 = new UserAddedToGroupsPanel(notification.getNotificationId(), grp,currentuser);
                    notificationsPanel.add(notificationsPanel3);
                } else {
                    Group grp = notification.extractGroup();
                    GrpStatusChangedPanel notificationsPanel4 = new GrpStatusChangedPanel(notification.getNotificationId(), currentuser, grp);
                    notificationsPanel.add(notificationsPanel4);
                }
            } else {
                Group grp = notification.extractGroup();
                NewGroupPostPanel notificationsPanel5 = new NewGroupPostPanel(notification.getNotificationId(), grp, currentuser);
                notificationsPanel.add(notificationsPanel5);
            }
        }
        JScrollPane scrollPane4 = new JScrollPane(notificationsPanel);
        scrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane4.setBounds(665, 490, 265, 180);
        add(scrollPane4);
        JPanel groupSuggestionsPanel = new JPanel();
        groupSuggestionsPanel.setLayout(new BoxLayout(groupSuggestionsPanel, BoxLayout.Y_AXIS));
        List<GroupSuggestion>groupSuggestionPanels=new ArrayList<>();
        List<Group>groupSuggestions=new ArrayList<>(groupDatabase.getAllRecords());
        groupSuggestions.removeAll(groupDatabase.getUserGroups(currentuser.getUserId()));
        for(Group g:groupSuggestions){
            groupSuggestionPanels.add(new GroupSuggestion(GroupManagement.getInstance(g.getGroupId()),currentuser.getUserId()));
        }
        for(GroupSuggestion panel:groupSuggestionPanels){
            groupSuggestionsPanel.add(panel);
        }
        JScrollPane scrollPane5 = new JScrollPane(groupSuggestionsPanel);
        scrollPane5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane5.setBounds(0, 200,300,130);
        add(scrollPane5);
        JPanel groupsPanel = new JPanel();
        groupsPanel.setLayout(new BoxLayout(groupsPanel, BoxLayout.Y_AXIS));
        List<NewsFeedGroups> groupPanels = new ArrayList<>();
        List<Group>groups=groupDatabase.getUserGroups(currentuser.getUserId());
        for(Group g:groups){
            groupPanels.add(new NewsFeedGroups(currentuser,g));
        }
        for(NewsFeedGroups panel:groupPanels){
            groupsPanel.add(panel);
        }
        JScrollPane scrollPane6 = new JScrollPane(groupsPanel);
        scrollPane6.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane6.setBounds(260,545,150,130);
        add(scrollPane6);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                user.setStatus("offline");
                friendDatabase.saveData();
                contentDatabase.saveData();
                userDatabase.saveData();
                notificationDatabase.saveData();
                groupDatabase.saveData();
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
        jLabel4 = new javax.swing.JLabel();

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

        jLabel3.setText("My Friends");

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

        jLabel4.setText("My Groups");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(GroupSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(userName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(userProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(625, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FriendSearch, addPost, addStory, logout, refresh});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton logout;
    private javax.swing.JButton profile;
    private javax.swing.JButton refresh;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userProfile;
    // End of variables declaration//GEN-END:variables
}
