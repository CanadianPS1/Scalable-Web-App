package com.example.Models;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
@Entity
@Table(name = "sloths")
public class Sloth implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int slothID;
    @OneToMany(mappedBy = "slothID")
    private Set<Tree> treeID = new HashSet<>();
    @ManyToMany
    @JoinTable(
        name = "slothJungle",
        joinColumns = @JoinColumn(name = "slothId"),
        inverseJoinColumns = @JoinColumn(name = "jungleId")
    )
    private Set<Jungle> jungles = new HashSet<>();
    int slothLevel;
    int speed;
    String name;
    public Sloth(){}
    public Sloth(int slothID, String name, int slothLevel, int speed, Set<Tree> treeID){
        this.slothID = slothID;
        this.name = name;
        this.slothLevel = slothLevel;
        this.speed = speed;
        this.treeID = treeID;
    }
    public int getSlothID(){return slothID;}
    public void setSlothID(int slothID){this.slothID = slothID;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public int getSlothLevel(){return slothLevel;}
    public void setSlothLevel(int slothLevel){this.slothLevel = slothLevel;}
    public int getSlothSpeed(){return speed;}
    public void setSlothSpeed(int speed){this.speed = speed;}
    public Set<Tree> getTrees(){return treeID;}
    public void setTree(Tree treeID){this.treeID.add(treeID);}
}
