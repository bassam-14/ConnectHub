/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contentcreation;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import lab9.*;

/**
 *
 * @author mazen
 */
public class Stories extends ContentCreation {
    ContentDatabase contentDatabase=ContentDatabase.getInstance();
    public Stories(String contentId,String authorId, Content content) {
        super(authorId, content);
        Expire();
    }
   private void Expire(){
       ScheduledExecutorService schedule=Executors.newSingleThreadScheduledExecutor();
       schedule.schedule(()->{
           contentDatabase.deleteRecord(this);
           schedule.shutdown();
       },24,TimeUnit.HOURS);
   }
  
    @Override
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(getCreatedtime().plusHours(24));
    }
}
