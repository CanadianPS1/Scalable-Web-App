package com.example.Models;
import java.io.Serializable;
public class Jungle implements Serializable{
    int jungleID, jungleSize;
    String jungleName;
    public Jungle(){};
    public Jungle(int jungleID, String jungleName, int jungleSize){
        this.jungleID = jungleID;
        this.jungleName = jungleName;
        this.jungleSize = jungleSize;
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
}
