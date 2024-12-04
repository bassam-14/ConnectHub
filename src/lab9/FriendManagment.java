/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeina
 */
public class FriendManagment {
    private String userId;
    private ArrayList<String> friends;
    private UserDatabase userDatabase;
    private ArrayList<FriendRequest> sentRequests;
    private ArrayList<FriendRequest> receivedRequests;
    private ArrayList<String> blockedUsers;

    public FriendManagment(String userId, UserDatabase userDatabase) {
        this.userId = userId;
        this.userDatabase = userDatabase;

    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public void setUserDatabase(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public ArrayList<FriendRequest> getSentRequests() {
        return sentRequests;
    }

    public void setSentRequests(ArrayList<FriendRequest> sentRequests) {
        this.sentRequests = sentRequests;
    }

    public ArrayList<String> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(ArrayList<String> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }
    public void sendRequest(String receiverID) {
        if (friends.contains(receiverID)) {
            return;
        }
        FriendRequest request = new FriendRequest(userId, receiverID, "Pending");
        sentRequests.add(request);
    }

    public void acceptRequest(FriendRequest request) {
        if (!(request.getRecieverID().equals(userId)) || !request.getStatus().equals("Pending")) {
            return;
        }
        friends.add(request.getSenderID());
        request.setStatus("Accepted");
        receivedRequests.remove(request);
    }

    public void declineRequest(FriendRequest request) {
        if (!request.getRecieverID().equals(userId) || !request.getStatus().equals("Pending")) {
            return;
        }
        request.setStatus("Declined");
        receivedRequests.remove(request);
    }

    public void removeFriend(String friendId) {
        if (!friends.contains(friendId)) {
            return;
        }
        friends.remove(friendId);
    }

    public void blockUser(String userId) {
        if (blockedUsers.contains(userId)) {
            return;
        } else if (friends.contains(userId)) {
            blockedUsers.add(userId);
            friends.remove(userId);
        } else {
            blockedUsers.add(userId);
        }
    }

    public ArrayList<User> getFriendSuggestions() {
        List<User> allUsers = userDatabase.getAllRecords();
        ArrayList<User> friends1 = new ArrayList<>();
        for (int i = 0; i < this.friends.size(); i++) {
            friends1.add(userDatabase.getRecord(friends.get(i)));
        }
        ArrayList<User> blockedUsers1 = new ArrayList<>();
        for (int i = 0; i < this.blockedUsers.size(); i++) {
            blockedUsers1.add(userDatabase.getRecord(blockedUsers.get(i)));
        }
        ArrayList<User> sentRequests1 = new ArrayList<>();
        for (int i = 0; i < this.sentRequests.size(); i++) {
            sentRequests1.add(userDatabase.getRecord(sentRequests.get(i).getRecieverID()));
        }
        ArrayList<User> receivedRequests1 = new ArrayList<>();
        for (int i = 0; i < this.sentRequests.size(); i++) {
            receivedRequests1.add(userDatabase.getRecord(receivedRequests.get(i).getSenderID()));
        }
        ArrayList<User> friendSuggestions = new ArrayList<>();
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i) != friends1.get(i) && allUsers.get(i) != blockedUsers1.get(i) && allUsers.get(i) != sentRequests1.get(i) && allUsers.get(i) != receivedRequests1.get(i)) {
                friendSuggestions.add(allUsers.get(i));
            }
        }
        return friendSuggestions;
    }

}
