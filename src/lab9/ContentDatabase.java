/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import contentcreation.*;

/**
 *
 * @author bassam
 */
public class ContentDatabase extends FileHandling<ContentCreation> {
    private final List<ContentCreation>contents;
    public ContentDatabase(){
       super("content.json",new TypeReference<List<ContentCreation>>(){});
       contents=readData();
    }
    public void addContent(ContentCreation content){
        contents.add(content);
        writeData(contents);
    }
}
