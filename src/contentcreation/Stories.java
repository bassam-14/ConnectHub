/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contentcreation;

import java.time.LocalDateTime;

/**
 *
 * @author mazen
 */
public class Stories extends ContentCreation {

    public Stories(int contentId, int authorId, Content content) {
        super(contentId, authorId, content);
    }

    public boolean isExpired() {
        LocalDateTime nowTime = LocalDateTime.now();
        return getCreatedtime().isBefore(nowTime);
    }
}
