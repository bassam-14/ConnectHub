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

    public NotificationManager(String userId, FriendManagment friendManager) {
        this.userId = userId;
        this.friendManager = friendManager;
    }

    public List<String> getRequestsSenders(String userId) {
        List<FriendRequest> recievedRequests = friendManager.friendDatabase.getRecievedRequests(userId);
        List<String> senders = new ArrayList<>();
        for (FriendRequest request : recievedRequests) {
            senders.add(request.getSenderID());
        }
        return senders;
    }

    public List<String> getAcceptedRequests(String userId) {
        List<FriendRequest> sentRequests = friendManager.getSentRequests();
        List<String> newFriends = new ArrayList<>();
        for (FriendRequest request : sentRequests) {
            if (request.getStatus().equals("Accepted")) {
                newFriends.add(request.getRecieverID());
            }
        }
        return newFriends;
    }
}
