package com.example.Controllers;
import java.util.ArrayList;
import com.example.Models.*;
public class PilotRestDataArrayList{
    public static final ArrayList<Pilot> pilots = new ArrayList<>();
    public static String add(Pilot pilot){
        if(pilots.stream().filter(i -> i.getPilotID() == pilot.getPilotID()).findFirst().orElse(null) == null){
            pilots.add(pilot);
            return "Pilot Added";
        }else return "Id Conflict";
    }
    public static ArrayList<Pilot> getAll(){
        return pilots;
    }
}