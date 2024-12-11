/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeina
 */
public class NotificationManager {

    private String userId;
    private FriendManagment friendManager;
    private NotificationDatabase notificationDatabase;
    private List<Notification> notifications;
    FriendDatabase friendDatabase = FriendDatabase.getInstance();

    public NotificationManager(String userId, FriendManagment friendManager, NotificationDatabase notificationDatabase, List<Notification> notifications) {
        this.userId = userId;
        this.friendManager = friendManager;
        this.notificationDatabase = notificationDatabase;
        this.notifications = notifications;
    }

    public void fetchFriendRequestNotifications(FriendManagment friendManager, String UserId) {
        List<FriendRequest> recievedRequests = friendDatabase.getRecievedRequests(userId);
        if (!recievedRequests.isEmpty()) {
            for (FriendRequest request : recievedRequests) {
                String message = request.getSenderID() + " sent you a friend request";
                notifications.add(new Notification(NotificationType.FRIEND_REQUEST, message, request.getSenderID()));
            }
        }
        List<FriendRequest> sentRequests = friendManager.getSentRequests();
        if (!sentRequests.isEmpty()) {
            for (FriendRequest request : sentRequests) {
                if (request.getStatus().equals("Accepted")) {
                    String message = request.getRecieverID() + " accepted your friend request";
                    notifications.add(new Notification(NotificationType.FRIEND_REQUEST, message, request.getRecieverID()));
                }
            }
        }
    }
    public List<Notification> getAllNotifications() {
        return new ArrayList<>(notifications); // Return a copy to prevent external modification
    }
     public void clearNotifications() {
        notifications.clear();
        saveNotifications(); // Save changes to file
    }
    private void saveNotifications() {
        notificationDatabase.getAllRecords().clear();
        notificationDatabase.getAllRecords().addAll(notifications);
        notificationDatabase.saveData();
    }

}
