/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.util.ArrayList;


/**
 *
 * @author belal
 */
public class Group {
    private String name;
    private String description;
    private String groupPhoto;
    private User primaryAdmin;
    private ArrayList<User> admins;
    private ArrayList<User> members;
    private ArrayList<User> membershipRequests; // New feature: Membership requests

    public Group(String name, String description, String groupPhoto, User primaryAdmin) {
        this.name = name;
        this.description = description;
        this.groupPhoto = groupPhoto;
        this.primaryAdmin = primaryAdmin;
        this.admins = new ArrayList<>();
        this.members = new ArrayList<>();
        this.membershipRequests = new ArrayList<>();
        this.admins.add(primaryAdmin);
        this.members.add(primaryAdmin);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupPhoto() {
        return groupPhoto;
    }

    public void setGroupPhoto(String groupPhoto) {
        this.groupPhoto = groupPhoto;
    }

    public User getPrimaryAdmin() {
        return primaryAdmin;
    }

    public void setPrimaryAdmin(User primaryAdmin) {
        this.primaryAdmin = primaryAdmin;
    }

    public ArrayList<User> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<User> admins) {
        this.admins = admins;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }

    public ArrayList<User> getMembershipRequests() {
        return membershipRequests;
    }

    public void setMembershipRequests(ArrayList<User> membershipRequests) {
        this.membershipRequests = membershipRequests;
    }
     public void addAdmin(User admin){ 
        if (!admins.contains(admin)){
            admins.add(admin);
        } 
    }
    public void removeAdmin(User admin) { 
        if (!admin.equals(primaryAdmin)){
            admins.remove(admin);
        } 
    }
    public void addMember(User member) { 
        if (!members.contains(member)) {
            members.add(member);
        } 
    }
    public void removeMember(User member) {
        members.remove(member);
        admins.remove(member);
    }
}
