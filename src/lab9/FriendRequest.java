/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

/**
 *
 * @author Zeina
 */
public class FriendRequest {

    private String recieverID;
    private String senderID;
    private String status;

    public FriendRequest() {
    }
    public FriendRequest(String recieverID, String senderID, String status) {
        this.recieverID = recieverID;
        this.senderID = senderID;
        this.status = status;
    }
   public String getFriendShipId(){
       return senderID+"-"+recieverID;
   }
    public String getRecieverID() {
        return recieverID;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
