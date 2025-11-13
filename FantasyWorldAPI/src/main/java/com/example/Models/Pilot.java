package com.example.Models;
import java.io.Serializable;
public class Pilot implements Serializable{
    int pilotID;
    String name;
    int skillLevel;
    public Pilot(){}
    public Pilot(int pilotID, String name, int skillLevel){
        this.pilotID = pilotID;
        this.name = name;
        this.skillLevel = skillLevel;
    }
    public int getPilotID(){
        return pilotID;
    }
    public void setPilotID(int pilotID){
        this.pilotID = pilotID;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getSkillLevel(){
        return skillLevel;
    }
    public void setSkillLevel(int skillLevel){
        this.skillLevel = skillLevel;
    }

}
