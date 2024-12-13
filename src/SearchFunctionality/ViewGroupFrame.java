/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SearchFunctionality;
import contentcreation.Posts;
import contentcreation.PostsContentPanel;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import lab9.*;

/**
 *
 * @author bassam
 */
public class ViewGroupFrame extends javax.swing.JFrame {

    private Group currentgroup;
    private GroupManagement grpmanage;
    GroupDatabase groupdata = GroupDatabase.getInstance();
    ContentDatabase contentdata = ContentDatabase.getInstance();
    private final String grpid;

    /**
     * Creates new form ViewGroupFrame
     * @param group
     */
    public ViewGroupFrame(Group group) {
        this.currentgroup = group;
        this.grpid = group.getGroupId();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupProfile.setText("jLabel1");

        GroupName.setText("jLabel2");

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GroupProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GroupName))
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GroupName;
    private javax.swing.JLabel GroupProfile;
    // End of variables declaration//GEN-END:variables
}
