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
    public static Pilot getById(int id){
        return pilots.stream().filter(pilot -> pilot.getPilotID() == id).findFirst().orElse(null);
    }
    public static Pilot update(Pilot pilot){
        Pilot tempPilot = pilots.stream().filter(i -> i.getPilotID() == pilot.getPilotID()).findFirst().orElse(null);
        if(tempPilot != null){
            pilots.remove(tempPilot);
            pilots.add(pilot);
            return pilot;
        }else return null;
    }
    public static String delete(int id){
        return pilots.removeIf(pilot -> pilot.getPilotID() == id) ? "Removed" : "Not Found";
    }

}