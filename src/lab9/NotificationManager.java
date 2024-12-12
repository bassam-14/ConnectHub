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
    FriendDatabase friendDatabase = FriendDatabase.getInstance();

    public NotificationManager(String userId, FriendManagment friendManager, NotificationDatabase notificationDatabase) {
        this.userId = userId;
        this.friendManager = friendManager;
        this.notificationDatabase = notificationDatabase;
    }

    public void fetchFriendRequestNotifications(FriendRequest request) {
        String message = request.getSenderID() + " sent you a friend request";
        Notification notificaton = new Notification(NotificationType.FRIEND_REQUEST, message);
    }

    public void fetchAcceptedFriendrequestNotification(FriendRequest request) {
        if (request.getStatus().equals("Accepted")) {
            String message = request.getRecieverID() + " accepted your friend request";
            Notification notificaton = new Notification(NotificationType.FRIEND_REQUEST, message);

        }
    }

    public String getUserId() {
        return userId;
    }
    /*  public void clearNotifications() {
        notifications.clear();
        notificationDatabase.saveData();// Save changes to file
    }*/

}
