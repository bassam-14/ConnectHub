/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab9;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;
/**
 *
 * @author bassam
 * @param <T>
 */
public abstract class FileHandling<T> {
    private final ObjectMapper objectMapper=new ObjectMapper();
    private final File file;
    private final TypeReference<List<T>>typeReference;
    protected FileHandling(String filePath,TypeReference<List<T>> typeReference) {
        file = new File(filePath);
        this.typeReference = typeReference;
    }

    public List<T> readData() {
        try {
            if (file.exists()) {
                return objectMapper.readValue(file,typeReference);
            } else {
                return List.of();
            }
        } catch (IOException e) {
      
        }
        return null;
    }

    public void writeData(List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
        } catch (IOException e) {
           
        }
    }
}
