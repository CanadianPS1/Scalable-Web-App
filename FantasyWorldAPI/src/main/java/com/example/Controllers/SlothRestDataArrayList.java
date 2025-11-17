package com.example.Controllers;
import java.util.ArrayList;
import com.example.Models.*;
public class SlothRestDataArrayList{
    public static final ArrayList<Sloth> sloths = new ArrayList<>();
    public static String add(Sloth sloth){
        if(sloths.stream().filter(i -> i.getSlothID() == sloth.getSlothID()).findFirst().orElse(null) == null){
            sloths.add(sloth);
            return "Sloth Added";
        }else return "Id Conflict";
    }
    public static ArrayList<Sloth> getAll(){
        return sloths;
    }
    public static Sloth getById(int id){
        return sloths.stream().filter(sloth -> sloth.getSlothID() == id).findFirst().orElse(null);
    }
    public static Sloth update(Sloth sloth){
        Sloth tempSloth = sloths.stream().filter(i -> i.getSlothID() == sloth.getSlothID()).findFirst().orElse(null);
        if(tempSloth != null){
            sloths.remove(tempSloth);
            sloths.add(sloth);
            return sloth;
        }else return null;
    }
    public static String delete(int id){
        return sloths.removeIf(sloth -> sloth.getSlothID() == id) ? "Removed" : "Not Found";
    }

}