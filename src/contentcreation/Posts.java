/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contentcreation;

/**
 *
 * @author mazen
 */
public class Posts extends ContentCreation {

    public Posts(String authorId, Content content,String groupId) {
        super(authorId, content,groupId);
    }
    @Override
    public boolean isExpired(){
        return false;
    }
}
