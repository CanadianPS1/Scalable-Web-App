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
public class TreeRestDataJSON{
    private static final File jsonFile = new File("Scalable-Web-App\\FantasyWorldAPI\\src\\main\\resources\\Database\\trees.json");    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static synchronized Tree update(Tree tree) throws IOException {
        List<Tree> trees = getAllInternal();
        for (Tree tempTree : trees){
            if (tempTree.getTreeID() == tree.getTreeID()){
                trees.remove(tempTree);
                trees.add(tree);
                saveFile(trees);
                return tree;
            };
        }
        return null;
    }
    public static synchronized String delete(int treeID) throws IOException {
        List<Tree> trees = getAllInternal();
        for(Tree tree : trees){
            if(tree.getTreeID() == treeID){
                trees.remove(tree);
                saveFile(trees);
                return "Tree Removed";
            }
        }
        return "No Tree Found";
    }
    public static synchronized List<Tree> getAll() throws IOException {
        return getAllInternal();
    }
    public static synchronized Tree findById(int treeID) throws IOException {
        for (Tree tree : getAllInternal()){
            if (tree.getTreeID() == treeID) return tree;
        }
        return null;
    }
    public static synchronized String add(Tree tree) throws IOException{
        List<Tree> trees = getAllInternal();
        int nextId = getNextId(trees);
        tree.setTreeID(nextId);
        trees.add(tree);
        saveFile(trees);
        return "Tree Added! " + tree.getTreeID();
    }
    private static List<Tree> getAllInternal() throws IOException {
        if(!jsonFile.exists() || jsonFile.length() == 0) return new ArrayList<>();
        try{
            return objectMapper.readValue(
                jsonFile,
                new TypeReference<List<Tree>>() {}
            );
        }catch(IOException ex){
            System.err.println("Failed to read tree.json: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
    private static int getNextId(List<Tree> trees) {
        if(trees.isEmpty()) return 1;
        return trees.stream()
                     .map(Tree::getTreeID)
                     .max(Comparator.naturalOrder())
                     .orElse(0) + 1;
    }
    private static void saveFile(List<Tree> trees) throws IOException{
        File parent = jsonFile.getParentFile();
        if(parent != null && !parent.exists()) parent.mkdirs();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(jsonFile, trees);
    }

    public static File getJsonFile() {
        return jsonFile;
    }
}