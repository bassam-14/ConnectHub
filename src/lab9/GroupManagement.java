/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.util.ArrayList;

/**
 *
 * @author belal
 */
public class GroupManagement {
    private ArrayList<Group> groups = new ArrayList<>();

    public GroupManagement() {
        this.groups = new ArrayList<>();
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public boolean createGroup(String name, String description, String groupPhoto, User primaryAdmin) {
         for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getName().equals(name)) {
                return false; 
            }
        }
        Group group = new Group(name, description, groupPhoto, primaryAdmin);
        groups.add(group);
        return true;
    }
         

    public Group getGroupByName(String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }
    
    public boolean deleteGroup(String name, User user) {
        Group group = getGroupByName(name);
        if (group.getPrimaryAdmin().equals(user)) {
            groups.remove(group);
            return true;
        }
        return false;
    }
    public void clearGroups() {
        groups.clear();
    }
    public boolean promoteToAdmin(String groupName, User admin, User user) {
        Group group = getGroupByName(groupName);
        if (group != null && group.getPrimaryAdmin().equals(admin) && group.getMembers().contains(user)) {
            group.addAdmin(user);
            return true;
        }
        return false;
    }
    public boolean demoteAdmin(String groupName, User admin, User user) {
        Group group = getGroupByName(groupName);
        if (group != null && group.getPrimaryAdmin().equals(admin) && group.getAdmins().contains(user)) {
            group.removeAdmin(user);
            return true;
        }
        return false;
    }
    public boolean removeMember(String groupName, User admin, User user) {
        Group group = getGroupByName(groupName);
        if (group != null && group.getAdmins().contains(admin)) {
            group.removeMember(user);
            return true;
        }
        return false;
    }
    public boolean leaveGroup(String groupName, User user) {
        Group group = getGroupByName(groupName);
        if (group != null && group.getMembers().contains(user)) {
            group.removeMember(user);
            if (group.getPrimaryAdmin().equals(user)) {
                if (!group.getAdmins().isEmpty()) {
                    group.setPrimaryAdmin(group.getAdmins().get(0));
                } else if (!group.getMembers().isEmpty()) {
                    group.setPrimaryAdmin(group.getMembers().get(0));
                } else {
                    groups.remove(group);
                }
            }
            return true;
        }
        return false;
    }
    public void requestMembership(String groupName, User user) {
        Group group = getGroupByName(groupName);
        if (group != null && !group.getMembers().contains(user) && !group.getMembershipRequests().contains(user)) {
            group.getMembershipRequests().add(user);
        }
    }
    public boolean approveMembershipRequest(String groupName, User admin, User user) {
        Group group = getGroupByName(groupName);
        if (group != null && group.getAdmins().contains(admin) && group.getMembershipRequests().contains(user)) {
            group.getMembershipRequests().remove(user);
            group.addMember(user);
            return true;
        }
        return false;
    }
    public boolean declineMembershipRequest(String groupName, User admin, User user) {
        Group group = getGroupByName(groupName);
        if (group != null && group.getAdmins().contains(admin)) {
            group.getMembershipRequests().remove(user);
            return true;
        }
        return false;
    }
   // public boolean addPost(String groupName, User user, String content) {
    //public boolean editPost(String groupName, User admin, int postIndex, String newContent){
    //public boolean deletePost(String groupName, User admin, int postIndex) {
    //public ArrayList<String> viewPosts(String groupName) {
}
