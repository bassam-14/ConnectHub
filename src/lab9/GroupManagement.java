/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;
import contentcreation.Content;
import contentcreation.ContentCreation;
import contentcreation.Posts;
import java.util.*;
/**
 *
 * @author belal
 */
public class GroupManagement {
    private static final Map<String,GroupManagement> instances=new HashMap<>();
    private final GroupDatabase groupDatabase;
    private final ContentDatabase contentDatabase;
    private final NotificationDatabase notificationDatabase;
    private final UserDatabase userDatabase;
    private final Group group;
    private GroupManagement(String groupId) {
     groupDatabase=GroupDatabase.getInstance();
     contentDatabase = ContentDatabase.getInstance();
     notificationDatabase=NotificationDatabase.getInstance();
     userDatabase=UserDatabase.getInstance();
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
            notificationDatabase.addRecord(new Notification(NotificationType.GROUP_ACTIVITY,group.getName()+" group status changed to "+group.getStatus(userId),userId));
            return true;
        }
        return false;
    }
    public boolean demoteAdmin(String adminId,String userId) {
        if (group != null && group.getPrimaryAdmin().equals(adminId) && group.getAdmins().contains(userId)) {
            group.removeAdmin(userId);
            notificationDatabase.addRecord(new Notification(NotificationType.GROUP_ACTIVITY,group.getName()+" group status changed to "+group.getStatus(userId),userId));
            return true;
        }
        return false;
    }
    public boolean removeMember(String adminId,String userId) {
        if (group != null && group.getAdmins().contains(adminId)) {
            group.removeMember(userId);
            notificationDatabase.addRecord(new Notification(NotificationType.GROUP_ACTIVITY,group.getName()+" group status changed to "+group.getStatus(userId),userId));
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
            notificationDatabase.addRecord(new Notification(NotificationType.GROUP_ACTIVITY,"You were added to group "+group.getName(),userId));
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
   public boolean addPost(String userId, Content content) {
        if (group.getMembers().contains(userId)) {
            Posts post = new Posts(userId, content,group.getGroupId());
            contentDatabase.addRecord(post);
            for(String member:group.getMembers()){
                notificationDatabase.addRecord(new Notification(NotificationType.NEW_POST,userDatabase.getRecord(userId).getUsername()+" added a new post to "+group.getName(),member));
            }
            return true;
        }
        return false;
    }
    public boolean editPost(String adminId, String contentId, Content newContent) {
        if (group.getAdmins().contains(adminId)) {
            ContentCreation content = contentDatabase.getRecord(contentId);
            if (content instanceof Posts) {
                content.setContent(newContent);
                return true;
            }
        }
        return false;
    }
    public boolean deletePost(String adminId, String contentId) {
        if (group.getAdmins().contains(adminId)) {
            ContentCreation existingContent = contentDatabase.getRecord(contentId);
            if (existingContent instanceof Posts) {
                contentDatabase.deleteRecord(existingContent);
                return true;
            }
        }
        return false;
    }
}
