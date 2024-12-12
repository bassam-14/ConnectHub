/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;

/**
 *
 * @author bassam
 */
public class FriendDatabase extends FileHandling<FriendRequest>{
    private static FriendDatabase instance;
    UserDatabase userDatabase=UserDatabase.getInstance();
      private FriendDatabase(){
       super("friendrequests.json",new TypeReference<List<FriendRequest>>(){});
    }
    public static FriendDatabase getInstance(){
        if(instance==null)
            instance=new FriendDatabase();
        return instance;
    }
      @Override
    public FriendRequest getRecord(String friendShipId){
    for(FriendRequest f:records){
        if(f.getFriendShipId().equals(friendShipId))
            return f;
    }
    return null;
}
    public List<FriendRequest> getSentRequests(String userId){
        List<FriendRequest> sentRequests=new ArrayList<>();
        for(FriendRequest f:records){
            if(f.getSenderID().equals(userId)&&f.getStatus().equals("Pending"))
                sentRequests.add(f);
        }
        return sentRequests;
    }
        public List<FriendRequest> getRecievedRequests(String userId){
        List<FriendRequest> recievedRequests=new ArrayList<>();
        for(FriendRequest f:records){
            if(f.getRecieverID().equals(userId)&&f.getStatus().equals("Pending"))
                recievedRequests.add(f);
        }
        return recievedRequests;
    }
        public List<String> getFriends(String userId){
        List<String> friends=new ArrayList<>();
        for(FriendRequest f:records){
            if(f.getRecieverID().equals(userId)&& f.getStatus().equals("Accepted"))
                friends.add(f.getSenderID());
             if(f.getSenderID().equals(userId)&& f.getStatus().equals("Accepted"))
                friends.add(f.getRecieverID());
        }
        return friends;
    }
        public List<User>getFriendsUsers(String userId){
        List<User> friends=new ArrayList<>();
        for(FriendRequest f:records){
            if(f.getRecieverID().equals(userId)&& f.getStatus().equals("Accepted"))
                friends.add(userDatabase.getRecord(f.getSenderID()));
             if(f.getSenderID().equals(userId)&& f.getStatus().equals("Accepted"))
                friends.add(userDatabase.getRecord(f.getRecieverID()));
        }
        return friends;
        }
        public List<FriendRequest>getFriendsRequests(String userId){
        List<FriendRequest> friends=new ArrayList<>();
        for(FriendRequest f:records){
            if(f.getRecieverID().equals(userId)&& f.getStatus().equals("Accepted"))
                friends.add(f);
             if(f.getSenderID().equals(userId)&& f.getStatus().equals("Accepted"))
                friends.add(f);
        }
        return friends;
        }
        
        
    
}
