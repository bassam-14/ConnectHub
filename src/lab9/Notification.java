/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.util.*;

/**
 *
 * @author Zeina
 */
public class Notification {

    private final String relatedUserId;
    private NotificationType type;
    private String message;
    private final String notificationId;

    public Notification(NotificationType type, String message,String relatedUserId) {
        this.relatedUserId=relatedUserId;
        this.type = type;
        this.message = message;
        this.notificationId = generateNotificationId();
    }
    public String getRelatedUserId() {
        return relatedUserId;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String generateNotificationId() {
        return UUID.randomUUID().toString(); // Generate a unique ID

    }
    public String extractSenderId() {
    if (type == NotificationType.FRIEND_REQUEST && message.contains(" sent you a friend request")) {
        return message.split(" ")[0]; // Extract the first word, which is the sender's ID
    }
    return null; // Return null if the notification type or format is invalid
}
    @Override
    public String toString() {
        return "[" + type + "]" + ":" + message;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj==null||getClass()!=obj.getClass())return false;
        Notification that = (Notification) obj;
        return Objects.equals(relatedUserId, that.relatedUserId) &&
                type == that.type &&
                Objects.equals(message, that.message);
    }
    @Override
    public int hashCode() {
        return Objects.hash(relatedUserId, type, message);
    }
}
