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
    private Content content;
    private final Timestamp createdtime;

    public ContentCreation(int contentId, int authorId, Content content, Timestamp createdtime) {
        this.contentId = contentId;
        this.authorId = authorId;
        this.content = content;
        this.createdtime = createdtime;
    }

    public Timestamp getCreatedtime() {
        return createdtime;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

}
