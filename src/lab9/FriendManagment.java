/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static final Map<String,FriendManagment> instances=new HashMap<>();
    UserDatabase userDatabase = UserDatabase.getInstance();
    FriendDatabase friendDatabase = FriendDatabase.getInstance();
    NotificationDatabase notificationDatabase=NotificationDatabase.getInstance();

    private FriendManagment(String userId) {
        this.userId = userId;
        sentRequests = friendDatabase.getSentRequests(userId);
        receivedRequests = friendDatabase.getRecievedRequests(userId);
        friends = friendDatabase.getFriends(userId);
        blockedUsers = userDatabase.getRecord(userId).getBlockedUsers();

    }
    public static FriendManagment getInstance(String userId){
        if(!instances.containsKey(userId))
            instances.put(userId,new FriendManagment(userId));
        return instances.get(userId);
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

    public List<FriendRequest> getSentRequests() {
        return sentRequests;
    }

    public void sendRequest(String receiverID) {

        if (friends.contains(receiverID)) {
            return;
        }
        FriendRequest request = new FriendRequest(receiverID, userId, "Pending");
        sentRequests.add(request);
        friendDatabase.addRecord(request);
        notificationDatabase.addRecord(new Notification(NotificationType.FRIEND_REQUEST,userDatabase.getRecord(userId).getUsername()+" sent you a friend request",receiverID));
    }

    public void acceptRequest(FriendRequest request) {
        if (!(request.getRecieverID().equals(userId)) || !request.getStatus().equals("Pending")) {

            return;
        }
        friends.add(request.getSenderID());
        request.setStatus("Accepted");
        notificationDatabase.addRecord(new Notification(NotificationType.FRIEND_REQUEST,userDatabase.getRecord(userId).getUsername()+" accepted your friend request",request.getSenderID()));
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
        friendDatabase.getFriendsUsers(this.userId).remove(userDatabase.getRecord(userId));
        friends.remove(friendId);
        friendDatabase.deleteRecord(friendDatabase.getRecord(friendId + "-" + userId));
        friendDatabase.deleteRecord(friendDatabase.getRecord(userId + "-" + friendId));
    }

    public void blockUser(String userId) {
        friendDatabase.getFriendsUsers(this.userId).remove(userDatabase.getRecord(userId));
        friends.remove(userId);
        blockedUsers.add(userId);
        friendDatabase.deleteRecord(friendDatabase.getRecord(userId + "-" + this.userId));
        friendDatabase.deleteRecord(friendDatabase.getRecord(this.userId + "-" + userId));
    }

    public ArrayList<String> getFriendSuggestions() {
        List<User> allUsersByUser = userDatabase.getAllRecords();
        List<String> allUsers = new ArrayList<>();
        for (User user : allUsersByUser) {
            allUsers.add(user.getUserId());
        }
        List<String> sentString = new ArrayList<>();
        List<String> recievedString = new ArrayList<>();
        for (FriendRequest r : sentRequests) {
            sentString.add(r.getSenderID());
        }
        for (FriendRequest r : receivedRequests) {
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
