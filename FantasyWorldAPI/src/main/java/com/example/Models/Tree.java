package com.example.Models;
import java.io.Serializable;
public class Tree implements Serializable{
    int treeID, age;
    String treeType;
    public Tree(){}
    public Tree(int age, int treeID, String treeType){
        this.age = age;
        this.treeID = treeID;
        this.treeType = treeType;
    }
    public int getTreeID(){
        return treeID;
    }
    public void setTreeID(int treeID){
        this.treeID = treeID;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getTreeType(){
        return treeType;
    }
    public void setTreeType(String treeType){
        this.treeType = treeType;
    }
}
