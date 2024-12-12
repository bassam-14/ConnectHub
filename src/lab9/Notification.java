/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.util.UUID;

/**
 *
 * @author Zeina
 */
public class Notification {

    private NotificationType type;
    private String message;
    private String notificationId;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
        this.notificationId = generateNotificationId();
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

    @Override
    public String toString() {
        return "[" + type + "]" + ":" + message;
    }

}
