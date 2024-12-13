/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import contentcreation.*;

/**
 *
 * @author Zeina
 */
public class NotificationDatabase extends FileHandling<Notification> {

    private static NotificationDatabase instance;
    private final FriendDatabase friendDatabase=FriendDatabase.getInstance();
    private final GroupDatabase groupDatabase=GroupDatabase.getInstance();
    private final ContentDatabase contentDatabase=ContentDatabase.getInstance();

    private NotificationDatabase() {
        super("Notifications.json", new TypeReference<List<Notification>>() {
        });
    }

    public static NotificationDatabase getInstance() {
        if (instance == null) {
            instance = new NotificationDatabase();
        }
        return instance;
    }

    @Override
    public Notification getRecord(String notificationId) {
        for (Notification N : records) {
            if (N.getNotificationId().equals(notificationId)) {
                return N;
            }
        }
        return null;

    }
    /*public List<Notification>fetchFriendRequestsRecievedNotifications(String userId){
        List<FriendRequest> friendRequests=friendDatabase.getRecievedRequests(userId);
        List <Notification>recievedRequests=new ArrayList<>();
        for(FriendRequest fr:friendRequests){
            Notification notification=new Notification(NotificationType.FRIEND_REQUEST,fr.getSenderID()+" sent you a friend request",userId);
            if(!records.contains(notification)){
                addRecord(notification);
                recievedRequests.add(notification);
            }
        }
        return recievedRequests;
    }
    public List<Notification>fetchFriendRequestsAcceptedNotifications(String userId){
        List<Notification>acceptedRequests=new ArrayList<>();
        List<FriendRequest>friends=friendDatabase.getFriendsRequests(userId);
        for(FriendRequest fr:friends){
            Notification notification=new Notification(NotificationType.FRIEND_REQUEST,fr.getRecieverID()+" accepted your friend request",userId);
            if(!records.contains(notification)&&fr.getSenderID().equals(userId)){
                addRecord(notification);
                acceptedRequests.add(notification);
            }
        }
        return acceptedRequests;
    }
    public List<Notification>fetchGroupPosts(String userId){
        List<Group>userGroups=groupDatabase.getUserGroups(userId);
        List<Notification>newPosts=new ArrayList<>();
        for(Group g:userGroups){
            for(Posts p:contentDatabase.getGroupPosts(g.getGroupId())){
                Notification notification=new Notification(NotificationType.NEW_POST,p.getAuthorId()+" added a new post to "+g.getName(),userId);
                if(records.contains(notification)){
                    newPosts.add(notification);
                    deleteRecord(notification);
                   
                }
            }
        }
        return newPosts;
    }
    public List<Notification>fetchGroupAdd(String userId){
        List<Notification>groupAdds=new ArrayList<>();
        List<Group>userGroups=groupDatabase.getUserGroups(userId);
        for(Group g:userGroups){
            Notification notification=new Notification(NotificationType.GROUP_ACTIVITY,"You were added to group "+g.getName(),userId);
            if(records.contains(notification)){
                groupAdds.add(notification);
                deleteRecord(notification);
            }
        }
        return groupAdds;
    }
    public List<Notification>fetchStatusChange(String userId){
        List<Notification>statusChanges=new ArrayList<>();
        List<Group>userGroups=groupDatabase.getUserGroups(userId);
        for(Group g:userGroups){
            Notification notification=new Notification(NotificationType.GROUP_ACTIVITY,g.getName()+" group status changed to "+g.getStatus(userId),userId);
            if(records.contains(notification)){
                statusChanges.add(notification);
                deleteRecord(notification);
            }
        }
        return statusChanges;
    }*/
   public List<Notification>fetchAllNotifications(String userId){
       List<Notification>notifications=new ArrayList<>();
       Iterator<Notification>iterator=records.iterator();
       while(iterator.hasNext()){
           Notification notif=iterator.next();
           if(notif.getRelatedUserId().equals(userId)){
               notifications.add(notif);
               iterator.remove();
           }
       }
       return notifications;
   }
}
