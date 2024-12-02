/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contentcreation;

import java.util.List;

/**
 *
 * @author mazen
 */
public class Content {

    private String text;
    private List<String> imagepath;

    public Content(String text, List<String> imagepath) {
        this.text = text;
        this.imagepath = imagepath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getImagepath() {
        return imagepath;
    }

    public void setImagepath(List<String> imagepath) {
        this.imagepath = imagepath;
    }

}
