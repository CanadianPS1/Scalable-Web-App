package com.example.Controllers;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.example.Models.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class SlothRestDataJSON{
    private static final File jsonFile = new File("src/main/resources/Database/sloth.json");    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static synchronized Sloth findById(int slothID) throws IOException {
        for (Sloth sloth : getAllInternal()){
            if (sloth.getSlothID() == slothID) return sloth;
        }
        return null;
    }
    public static synchronized String add(Sloth sloth) throws IOException{
        List<Sloth> sloths = getAllInternal();
        int nextId = getNextId(sloths);
        sloth.setSlothID(nextId);
        sloths.add(sloth);
        saveFile(sloths);
        return "Sloth Added! " + sloth.getSlothID();
    }
    private static List<Sloth> getAllInternal() throws IOException {
        if(!jsonFile.exists() || jsonFile.length() == 0) return new ArrayList<>();
        try{
            return objectMapper.readValue(
                jsonFile,
                new TypeReference<List<Sloth>>() {}
            );
        }catch(IOException ex){
            System.err.println("Failed to read sloth.json: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    private static int getNextId(List<Sloth> sloths) {
        if(sloths.isEmpty()) return 1;
        return sloths.stream()
                     .map(Sloth::getSlothID)
                     .max(Comparator.naturalOrder())
                     .orElse(0) + 1;
    }
    private static void saveFile(List<Sloth> sloths) throws IOException{
        File parent = jsonFile.getParentFile();
        if(parent != null && !parent.exists()) parent.mkdirs();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(jsonFile, sloths);
    }

    public static File getJsonFile() {
        return jsonFile;
    }
}