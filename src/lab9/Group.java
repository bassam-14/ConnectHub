/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import java.util.*;


/**
 *
 * @author belal
 */
public class Group {
    private final String groupId;
    private String name;
    private String description;
    private String groupPhoto;
    private String primaryAdmin;
    private ArrayList<String> admins;
    private ArrayList<String> members;
    private ArrayList<String> membershipRequests;

    public Group(String name, String description, String groupPhoto, String primaryAdmin) {
        groupId=UUID.randomUUID().toString();
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
    
    public String getGroupId() {
        return groupId;
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

    public String getPrimaryAdmin() {
        return primaryAdmin;
    }

    public void setPrimaryAdmin(String primaryAdmin) {
        this.primaryAdmin = primaryAdmin;
    }

    public ArrayList<String> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<String> admins) {
        this.admins = admins;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public ArrayList<String> getMembershipRequests() {
        return membershipRequests;
    }

    public void setMembershipRequests(ArrayList<String> membershipRequests) {
        this.membershipRequests = membershipRequests;
    }
     public void addAdmin(String admin){ 
        if (!admins.contains(admin)){
            admins.add(admin);
        } 
    }
    public void removeAdmin(String admin) { 
        if (!admin.equals(primaryAdmin)){
            admins.remove(admin);
        } 
    }
    public void addMember(String member) { 
        if (!members.contains(member)) {
            members.add(member);
        } 
    }
    public void removeMember(String member) {
        members.remove(member);
        admins.remove(member);
    } 
}
