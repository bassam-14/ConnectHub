/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author Zeina
 */
public class Notification {
    private NotificationType type;
    private String message;
    private String relatedUserId;

    public Notification(NotificationType type, String message, String relatedUserId) {
        this.type = type;
        this.message = message;
        this.relatedUserId=relatedUserId;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getRelatedUserId() {
        return relatedUserId;
    }

    @Override
    public String toString() {
        return "["+type+"]"+ message ;
    }
    
}
