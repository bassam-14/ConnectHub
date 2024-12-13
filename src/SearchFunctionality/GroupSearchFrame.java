/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SearchFunctionality;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import lab9.*;

/**
 *
 * @author mazen
 */
public class GroupSearchFrame extends javax.swing.JFrame {

    private ArrayList<Group> groups;
    private GroupManagement groupManager;
    private final String currentuserid;

    /**
     * Creates new form GroupSearchFrame
     *
     */
    public GroupSearchFrame(User currentuser) {
        this.currentuserid=currentuser.getUserId();
        setTitle("Group Search");
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void loadAllUsers() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Group group : groups) {
            listModel.addElement(group.getName());
        }
        GroupjList1.setModel(listModel);
    }

    private void initializeGroupManager(String groupId) {
        if (groupManager == null) {
            groupManager = GroupManagement.getInstance(groupId);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewGroup = new javax.swing.JButton();
        Name = new javax.swing.JLabel();
        GroupNameText = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        JoinGroup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        GroupjList1 = new javax.swing.JList<>();
        LeaveGroup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ViewGroup.setBackground(new java.awt.Color(204, 204, 255));
        ViewGroup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ViewGroup.setText("View Group");
        ViewGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewGroupActionPerformed(evt);
            }
        });

        Name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Name.setText("Name:");

        GroupNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupNameTextActionPerformed(evt);
            }
        });

        Search.setBackground(new java.awt.Color(204, 204, 255));
        Search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        JoinGroup.setBackground(new java.awt.Color(204, 204, 255));
        JoinGroup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JoinGroup.setText("Join Group");
        JoinGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinGroupActionPerformed(evt);
            }
        });

        GroupjList1.setBackground(new java.awt.Color(60, 63, 65));
        GroupjList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(GroupjList1);

        LeaveGroup.setBackground(new java.awt.Color(204, 204, 255));
        LeaveGroup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LeaveGroup.setText("Leave Group");
        LeaveGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GroupNameText))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JoinGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LeaveGroup)
                        .addComponent(ViewGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JoinGroup, LeaveGroup, Search, ViewGroup});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Search))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Name)
                        .addComponent(GroupNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(JoinGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LeaveGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ViewGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JoinGroup, LeaveGroup, Search, ViewGroup});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GroupNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupNameTextActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        groups = GroupSearch.grSearch(GroupNameText.getText());
        loadAllUsers();
    }//GEN-LAST:event_SearchActionPerformed

    private void JoinGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinGroupActionPerformed
        int index = GroupjList1.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Choose group");
        } else {
            Group g = groups.get(index);
            initializeGroupManager(g.getGroupId());
            groupManager.requestMembership(g.getGroupId());
            JOptionPane.showMessageDialog(this, "Add friend successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_JoinGroupActionPerformed

    private void LeaveGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveGroupActionPerformed
        int index = GroupjList1.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Choose group");
        } else {
            Group g = groups.get(index);
            initializeGroupManager(g.getGroupId());
            groupManager.leaveGroup(currentuserid);
            JOptionPane.showMessageDialog(this, "Add friend successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_LeaveGroupActionPerformed

    private void ViewGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewGroupActionPerformed
        int index = GroupjList1.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Choose a group to view.");
        } else {
            // Get the selected group
            Group selectedGroup = groups.get(index);

            // Initialize Group Manager 
            initializeGroupManager(selectedGroup.getGroupId());

            // Check if the current user is a member of the group
            boolean isMember = groupManager.isMember(currentuserid);
 if (!isMember) {
                JOptionPane.showMessageDialog(this,
                        "You are not a member of this group. Please join the group first.",
                        "Access Denied",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                // Open ViewGroupFrame
                ViewGroupFrame g = new ViewGroupFrame(selectedGroup);
                g.setVisible(true);
            }}
    }//GEN-LAST:event_ViewGroupActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GroupNameText;
    private javax.swing.JList<String> GroupjList1;
    private javax.swing.JButton JoinGroup;
    private javax.swing.JButton LeaveGroup;
    private javax.swing.JLabel Name;
    private javax.swing.JButton Search;
    private javax.swing.JButton ViewGroup;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
