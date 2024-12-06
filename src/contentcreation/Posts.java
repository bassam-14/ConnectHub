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

    public Posts(String contentId, String authorId, Content content) {
        super(authorId, content);
    }
    @Override
    public boolean isExpired(){
        return false;
    }
}
