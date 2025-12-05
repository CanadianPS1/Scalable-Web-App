package com.example.Models;
import java.io.Serializable;
//import java.util.ArrayList;
// import jakarta.persistence.*;
// import java.util.HashSet;
// import java.util.Set;
// @Entity
// @Table(name = "jungles")
public class Jungle implements Serializable{
    //@oneToMany
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    int jungleID;
    int jungleSize;
    int slothID; //= new ArrayList<>();
    int treeID; // = new ArrayList<>();
    String jungleName;
    public Jungle(){};
    public Jungle(int jungleID, String jungleName, int jungleSize, int slothID, int treeID){
        this.jungleID = jungleID;
        this.jungleName = jungleName;
        this.jungleSize = jungleSize;
        this.slothID = slothID;
        this.treeID = treeID;
    }
    public int getJungleID(){
        return jungleID;
    }
    public void setJungleID(int jungleID){
        this.jungleID = jungleID;
    }
    public int getJungleSize(){
        return jungleSize;
    }
    public void setJungleSize(int jungleSize){
        this.jungleSize = jungleSize;
    }
    public String getJungleName(){
        return jungleName;
    }
    public void setJungleName(String jungleName){
        this.jungleName = jungleName;
    }
    public int getSlothID(){
        return slothID;
    }

    public void setSlothID(int slothID){
        this.slothID = slothID;
    }

    public int getTreeID(){
        return treeID;
    }

    public void setTreeID(int treeID){
        this.treeID = treeID;
    }
}
