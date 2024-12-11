/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

/**
 *
 * @author Zeina
 */
public class NotificationDatabase extends FileHandling<Notification> {

    private static NotificationDatabase instance;

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
    public Notification getRecord(String relatedUserId) {
        for (Notification N : records) {
            if (N.getRelatedUserId().equals(relatedUserId)) {
                return N;
            }
        }
        return null;

    }

}
