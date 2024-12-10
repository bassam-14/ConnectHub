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
    private List<String> friends;
    private final List<FriendRequest> sentRequests;
    private final List<FriendRequest> receivedRequests;
    private final List<String> blockedUsers;
   UserDatabase userDatabase=UserDatabase.getInstance();
   FriendDatabase friendDatabase=FriendDatabase.getInstance();

    public FriendManagment(String userId) {
        this.userId = userId;
        sentRequests=friendDatabase.getSentRequests(userId);
        receivedRequests=friendDatabase.getRecievedRequests(userId);
        friends=friendDatabase.getFriends(userId);
        blockedUsers=userDatabase.getRecord(userId).getBlockedUsers();

    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }
    public void sendRequest(String receiverID) {

        if (friends.contains(receiverID)) {
            return;
        }
        FriendRequest request = new FriendRequest(receiverID, userId, "Pending");
        sentRequests.add(request);
        friendDatabase.addRecord(request);
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
        friendDatabase.deleteRecord(friendDatabase.getRecord(friendId+"-"+userId));
        friendDatabase.deleteRecord(friendDatabase.getRecord(userId+"-"+friendId));

    }
    public void blockUser(String userId) {
            blockedUsers.add(userId);
           User user=userDatabase.getRecord(this.userId);
           friendDatabase.getFriends(this.userId).remove(userId);
    }
    public ArrayList<String> getFriendSuggestions() {
        List<User> allUsersByUser = userDatabase.getAllRecords();
        List<String>allUsers=new ArrayList<>();
        for(User user:allUsersByUser){
            allUsers.add(user.getUserId());
        }
        List<String>sentString=new ArrayList<>();
        List<String>recievedString=new ArrayList<>();
        for(FriendRequest r:sentRequests){
            sentString.add(r.getSenderID());
        }
        for(FriendRequest r:receivedRequests){
            recievedString.add(r.getRecieverID());
        }
        ArrayList<String> friendSuggestions = new ArrayList<>(allUsers);
        friendSuggestions.removeAll(friends);
        friendSuggestions.removeAll(blockedUsers);
        friendSuggestions.removeAll(sentString);
        friendSuggestions.removeAll(recievedString);
        friendSuggestions.remove(userId);
        return friendSuggestions;
    }

}
