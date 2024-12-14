/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;
import java.util.*;
/**
 *
 * @author belal
 */
public class GroupManagement {
    private static final Map<String,GroupManagement> instances=new HashMap<>();
    private final GroupDatabase groupDatabase;
    private final Group group;
    private GroupManagement(String groupId) {
     groupDatabase=GroupDatabase.getInstance();
     group=groupDatabase.getRecord(groupId);
    }
    public static GroupManagement getInstance(String groupId){
        if(!instances.containsKey(groupId))
            instances.put(groupId,new GroupManagement(groupId));
        return instances.get(groupId);
    }
    public boolean deleteGroup(String userId) {
        if (group.getPrimaryAdmin().equals(userId)) {
            groupDatabase.deleteRecord(group);
            return true;
        }
        return false;
    }
    public boolean promoteToAdmin(String adminId,String userId) {
        if (group != null && group.getPrimaryAdmin().equals(adminId) && group.getMembers().contains(userId)) {
            group.addAdmin(userId);
            return true;
        }
        return false;
    }
    public boolean demoteAdmin(String adminId,String userId) {
        if (group != null && group.getPrimaryAdmin().equals(adminId) && group.getAdmins().contains(userId)) {
            group.removeAdmin(userId);
            return true;
        }
        return false;
    }
    public boolean removeMember(String adminId,String userId) {
        if (group != null && group.getAdmins().contains(adminId)) {
            group.removeMember(userId);
            return true;
        }
        return false;
    }
    public boolean leaveGroup(String userId) {
        if (group != null && group.getMembers().contains(userId)) {
            group.removeMember(userId);
            if (group.getPrimaryAdmin().equals(userId)) {
                if (!group.getAdmins().isEmpty()) {
                    group.setPrimaryAdmin(group.getAdmins().get(0));
                } else if (!group.getMembers().isEmpty()) {
                    group.setPrimaryAdmin(group.getMembers().get(0));
                } else {
                    groupDatabase.deleteRecord(group);
                }
            }
            return true;
        }
        return false;
    }
    public void requestMembership(String userId) {
        if (group != null && !group.getMembers().contains(userId) && !group.getMembershipRequests().contains(userId)) {
            group.getMembershipRequests().add(userId);
        }
    }
    public boolean approveMembershipRequest(String adminId,String userId) {
        if (group != null && group.getAdmins().contains(adminId) && group.getMembershipRequests().contains(userId)) {
            group.getMembershipRequests().remove(userId);
            group.addMember(userId);
            return true;
        }
        return false;
    }
    public boolean declineMembershipRequest(String adminId,String userId) {
        if (group != null && group.getAdmins().contains(adminId)) {
            group.getMembershipRequests().remove(userId);
            return true;
        }
        return false;
    }
   // public boolean addPost(String groupName, User user, String content) {
    //public boolean editPost(String groupName, User admin, int postIndex, String newContent){
    //public boolean deletePost(String groupName, User admin, int postIndex) {
    //public ArrayList<String> viewPosts(String groupName){
}
