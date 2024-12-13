/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;

/**
 *
 * @author belal
 */
public class GroupDatabase extends FileHandling<Group> {
    private static GroupDatabase instance;
      private GroupDatabase(){
       super("groups.json",new TypeReference<List<Group>>(){});
    }
    public static GroupDatabase getInstance(){
        if(instance==null)
            instance=new GroupDatabase();
        return instance;
    }
      @Override
    public Group getRecord(String groupId){
    for(Group g:records){
        if(g.getGroupId().equals(groupId))
            return g;
    }
    return null;
}
        public Group getGroupByName(String name) {
        for (Group group :records) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }
       public boolean createGroup(String name, String description, String groupPhoto,String primaryAdmin) {
         return addRecord(new Group(name,description,groupPhoto,primaryAdmin));
    }
       public List<Group>getUserGroups(String userId){
           List<Group>groups=new ArrayList<>();
           for(Group g:records){
               if(g.getMembers().contains(userId))
                   groups.add(g);
           }
           return groups;
       }
       public List<String>getUserGroupsNames(String userId){
           List<String>groups=new ArrayList<>();
           for(Group g:records){
               if(g.getMembers().contains(userId))
                   groups.add(g.getName());
           }
           return groups;
       }
}
