/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;

/**
 *
 * @author bassam
 * @param <T>
 */
public abstract class FileHandling<T> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    //serializing localdate
    static {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    private final File file;
    private final TypeReference<List<T>> typeReference;
    protected List<T> records;

    protected FileHandling(String filePath, TypeReference<List<T>> typeReference) {
        file = new File(filePath);
        this.typeReference = typeReference;
        records = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        try {
            if (file.exists()) {
                records = objectMapper.readValue(file, typeReference);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract T getRecord(String key);

    public boolean addRecord(T record) {
       return records.add(record);
    }

    public boolean deleteRecord(T record) {
        return records.remove(record);
    }

    public List<T> getAllRecords() {
        return new ArrayList<>(records);
    }

    public void saveData() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
