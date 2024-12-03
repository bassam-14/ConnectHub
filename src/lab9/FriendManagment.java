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
    // TODO:- populate fields from FriendsDatabase
    // TODO:- covert constructor into a singleton thread safe initiaizer
    public FriendManagment(String userId, UserDatabase userDatabase, ArrayList<FriendRequest> requests) {
        this.userId = userId;
        this.userDatabase = userDatabase;
        this.sentRequests = requests;
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

    private User getUserById(String userId, UserDatabase userDatabase) {
        return userDatabase.getRecord(userId);
    }

    private void sendRequest(String receiverID) {
        if (friends.contains(receiverID)) {
            return;
        }
        FriendRequest request = new FriendRequest(userId, receiverID, "Pending");
        sentRequests.add(request);
    }

    private void acceptReques(FriendRequest request) {
        if (request.getRecieverID() != userId || !request.getStatus().equals("Pending")) {
            return;
        }
        friends.add(request.getSenderID());
        request.setStatus("Accepted");
        // todo remove from received requests
    }

    private void declineRequesr(FriendRequest request) {
        if (request.getRecieverID() != userId || !request.getStatus().equals("Pending")) {
            return;
        }
        request.setStatus("Declined");
        // todo remove from received requests
    }

    private void removeFriend(String friendId) {
        if (!friends.contains(friendId)) {
            return;
        }
        friends.remove(friendId);
    }

    private void blockUser(String userId) {
        if (this.blockedUsers.contains(userId)) {
            return;
        } else if (this.friends.contains(userId)) {
            blockedUsers.add(userId);
            friends.remove(userId);
        } else {
            blockedUsers.add(userId);
        }
    }

    private ArrayList<User> getFriendSuggestions() {
        List<User> allUsers = userDatabase.getAllRecords();
        ArrayList<User> friends1 = new ArrayList<>();
        for (int i = 0; i < this.friends.size(); i++) {
            friends1.add(getUserById(friends.get(i), this.userDatabase));
        }
        ArrayList<User> blockedUsers1 = new ArrayList<>();
        for (int i = 0; i < this.blockedUsers.size(); i++) {
            blockedUsers1.add(getUserById(blockedUsers.get(i), this.userDatabase));
        }
        ArrayList<User> friendSuggestions = new ArrayList<>();
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i) != friends1.get(i) && allUsers.get(i) != blockedUsers1.get(i)) {
                //TODO:- shouldn't be in the received or sent arrays too
                friendSuggestions.add(allUsers.get(i));
            }
        }
        return friendSuggestions;
    }

}
