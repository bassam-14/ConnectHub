/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contentcreation;

import java.sql.Timestamp;

/**
 *
 * @author mazen
 */
public class Posts extends ContentCreation {

    public Posts(int contentId, int authorId, Content content, Timestamp createdtime) {
        super(contentId, authorId, content, createdtime);
    }
}
