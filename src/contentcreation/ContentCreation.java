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
public abstract class ContentCreation {

    private int contentId;
    private int authorId;
    private String content;
    private final Timestamp createdtime;

    public ContentCreation(int contentId, int authorId, String content) {
        this.contentId = contentId;
        this.authorId = authorId;
        this.content = content;
        this.createdtime = Timestamp.valueOf("2024-12-01 18:30:00");
    }

    public Timestamp getCreatedtime() {
        return createdtime;
    }

}
