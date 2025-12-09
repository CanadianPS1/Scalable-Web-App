package com.example.Models;
import java.io.Serializable;
import jakarta.persistence.*;
@Entity
@Table(name = "trees")
public class Tree implements Serializable{
    @Id
    @OneToOne(mappedBy = "sloths")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int treeID;
    @OneToOne(mappedBy = "sloths")
    Sloth slothID;
    int age;
    String treeType;
    public Tree(){}
    public Tree(int age, int treeID, String treeType, Sloth slothID){
        this.age = age;
        this.treeID = treeID;
        this.treeType = treeType;
        this.slothID = slothID;
    }
    public int getTreeID(){return treeID;}
    public void setTreeID(int treeID){this.treeID = treeID;}
    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}
    public String getTreeType(){return treeType;}
    public void setTreeType(String treeType){this.treeType = treeType;}
    public Sloth getSlothID(){return slothID;}
    public void setSloth(Sloth slothID){this.slothID = slothID;}
}
