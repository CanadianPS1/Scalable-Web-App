package com.example.Controllers;
import java.util.ArrayList;
import com.example.Models.*;
public class TreeRestDataArrayList{
    public static final ArrayList<Tree> trees = new ArrayList<>();
    public static String add(Tree tree){
        if(trees.stream().filter(i -> i.getTreeID() == tree.getTreeID()).findFirst().orElse(null) == null){
            trees.add(tree);
            return "Tree Added";
        }else return "Id Conflict";
    }
    public static ArrayList<Tree> getAll(){
        return trees;
    }
    public static Tree getById(int id){
        return trees.stream().filter(tree -> tree.getTreeID() == id).findFirst().orElse(null);
    }
    public static Tree update(Tree tree){
        Tree tempTree = trees.stream().filter(i -> i.getTreeID() == tree.getTreeID()).findFirst().orElse(null);
        if(tempTree != null){
            trees.remove(tempTree);
            trees.add(tree);
            return tree;
        }else return null;
    }
    public static String delete(int id){
        return trees.removeIf(tree -> tree.getTreeID() == id) ? "Removed" : "Not Found";
    }

}