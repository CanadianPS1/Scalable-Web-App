package com.example.Controllers;
import java.io.File;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import com.example.Models.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class JungleRestDataJSON{
    private static final File JSON_FILE = new File("Scalable-Web-App\\FantasyWorldAPI\\src\\main\\resources\\Database\\jungles.json");    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static synchronized Jungle update(Jungle jungle) throws IOException {
        List<Jungle> jungles = getAllInternal();
        for (Jungle tempJungle : jungles){
            if (tempJungle.getJungleID() == jungle.getJungleID()){
                jungles.remove(tempJungle);
                jungles.add(jungle);
                saveFile(jungles);
                return jungle;
            }
        }
        return null;
    }
    public static synchronized String delete(int jungleID) throws IOException {
        List<Jungle> jungles = getAllInternal();
        for(Jungle jungle : jungles){
            if(jungle.getJungleID() == jungleID){
                jungles.remove(jungle);
                saveFile(jungles);
                return "Jungle Removed";
            }
        }
        return "No Jungle Found";
    }
    public static synchronized List<Jungle> getAll() throws IOException {
        return getAllInternal();
    }
    public static synchronized Jungle findById(int jungleID) throws IOException {
        for (Jungle jungle : getAllInternal()){
            if (jungle.getJungleID() == jungleID) return jungle;
        }
        return null;
    }
    public static synchronized String add(Jungle jungle) throws IOException{
        List<Jungle> jungles = getAllInternal();
        int nextId = getNextId(jungles);
        jungle.setJungleID(nextId);
        jungles.add(jungle);
        saveFile(jungles);
        return "Jungle Added! " + jungle.getJungleID();
    }
    private static List<Jungle> getAllInternal() throws IOException {
        if(!JSON_FILE.exists() || JSON_FILE.length() == 0) return new ArrayList<>();
        try{
            return objectMapper.readValue(
                JSON_FILE,
                new TypeReference<List<Jungle>>() {}
            );
        }catch(IOException ex){
            System.err.println("Failed to read jungle.json: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    private static int getNextId(List<Jungle> jungles) {
        if(jungles.isEmpty()) return 1;
        return jungles.stream()
                     .map(Jungle::getJungleID)
                     .max(Comparator.naturalOrder())
                     .orElse(0) + 1;
    }
    private static void saveFile(List<Jungle> jungles) throws IOException{
        File parent = JSON_FILE.getParentFile();
        if(parent != null && !parent.exists()) parent.mkdirs();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(JSON_FILE, jungles);
    }
    public static File getJsonFile() {
        return JSON_FILE;
    }
}