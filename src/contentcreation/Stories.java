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
public class Stories extends ContentCreation {

    public Stories(String contentId,String authorId, Content content, Timestamp createdtime) {
        super(contentId, authorId, content, createdtime);
    }

  
    public boolean isExpired() {
        Timestamp nowtime = new Timestamp(System.currentTimeMillis());
        return getCreatedtime().before(nowtime);
    }
}
