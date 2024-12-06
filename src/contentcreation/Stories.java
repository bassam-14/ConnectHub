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

    public Stories(String contentId,String authorId, Content content) {
        super(authorId, content);
    }

  
    @Override
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(getCreatedtime().plusHours(24));
    }
}
