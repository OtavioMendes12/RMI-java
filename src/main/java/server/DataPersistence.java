package server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataPersistence {


    private static final String FILE_PATH = System.getProperty("user.dir") + "/dictionary.json";
    private ObjectMapper objectMapper;

    public DataPersistence() {
        this.objectMapper = new ObjectMapper();
    }


    public Map<String, String> loadDictionary() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {

                return objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            } else {

                System.out.println("Arquivo dictionary.json não encontrado. Criando um novo arquivo...");
                Map<String, String> dictionary = new HashMap<>();
                saveDictionary(dictionary);
                return dictionary;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void saveDictionary(Map<String, String> dictionary) {
        try {

            objectMapper.writeValue(new File(FILE_PATH), dictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}