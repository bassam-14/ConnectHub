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

    public Stories(int contentId, int authorId, String content) {
        super(contentId, authorId, content);
    }

    public boolean isExpired() {
        Timestamp nowtime = new Timestamp(System.currentTimeMillis());
        return getCreatedtime().before(nowtime);
    }
}
