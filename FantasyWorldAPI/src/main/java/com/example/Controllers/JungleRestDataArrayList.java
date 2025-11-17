package com.example.Controllers;
import java.util.ArrayList;
import com.example.Models.*;
public class JungleRestDataArrayList{
    public static final ArrayList<Jungle> jungles = new ArrayList<>();
    public static String add(Jungle jungle){
        if(jungles.stream().filter(i -> i.getJungleID() == jungle.getJungleID()).findFirst().orElse(null) == null){
            jungles.add(jungle);
            return "Jungle Added";
        }else return "Id Conflict";
    }
    public static ArrayList<Jungle> getAll(){
        return jungles;
    }
    public static Jungle getById(int id){
        return jungles.stream().filter(jungle -> jungle.getJungleID() == id).findFirst().orElse(null);
    }
    public static Jungle update(Jungle jungle){
        Jungle tempJungle = jungles.stream().filter(i -> i.getJungleID() == jungle.getJungleID()).findFirst().orElse(null);
        if(tempJungle != null){
            jungles.remove(tempJungle);
            jungles.add(jungle);
            return jungle;
        }else return null;
    }
    public static String delete(int id){
        return jungles.removeIf(jungle -> jungle.getJungleID() == id) ? "Removed" : "Not Found";
    }

}