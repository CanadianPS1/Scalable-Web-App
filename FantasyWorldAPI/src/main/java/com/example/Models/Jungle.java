package com.example.Models;
import java.io.Serializable;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "jungles")
public class Jungle implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jungleID;
    private int jungleSize;
    private String jungleName;
    @ManyToMany(mappedBy = "jungles")
    private Set<Sloth> slothID = new HashSet<>();
    @ManyToMany
    @JoinTable(
        name = "jungleTree",
        joinColumns = @JoinColumn(name = "jungleId"),
        inverseJoinColumns = @JoinColumn(name = "treeId")
    )
    private Set<Tree> treeID = new HashSet<>();
    public Jungle(){};
    public Jungle(int jungleID, String jungleName, int jungleSize, Set<Sloth> slothID, Set<Tree> treeID){
        this.jungleID = jungleID;
        this.jungleName = jungleName;
        this.jungleSize = jungleSize;
        this.slothID = slothID;
        this.treeID = treeID;
    }
    public int getJungleID(){return jungleID;}
    public void setJungleID(int jungleID){this.jungleID = jungleID;}
    public int getJungleSize(){return jungleSize;}
    public void setJungleSize(int jungleSize){this.jungleSize = jungleSize;}
    public String getJungleName(){return jungleName;}
    public void setJungleName(String jungleName){this.jungleName = jungleName;}
    public Set<Sloth> getSlothID(){return slothID;}
    public void setSlothID(Set<Sloth> slothID){this.slothID = slothID;}
    public Set<Tree> getTreeID(){return treeID;}
    public void setTreeID(Set<Tree> treeID){this.treeID = treeID;}
}
