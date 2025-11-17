package com.example.Models;
import java.io.Serializable;
public class Sloth implements Serializable{
    int slothLevel, slothID, speed;
    String name;
    public Sloth(){}
    public Sloth(int slothID, String name, int slothLevel, int speed){
        this.slothID = slothID;
        this.name = name;
        this.slothLevel = slothLevel;
        this.speed = speed;
    }
    public int getSlothID(){
        return slothID;
    }
    public void setSlothID(int slothID){
        this.slothID = slothID;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getSlothLevel(){
        return slothLevel;
    }
    public void setSlothLevel(int slothLevel){
        this.slothLevel = slothLevel;
    }
    public int getSlothSpeed(){
        return speed;
    }
    public void setSlothSpeed(int speed){
        this.speed = speed;
    }

}
