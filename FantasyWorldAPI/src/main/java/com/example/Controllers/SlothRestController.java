package com.example.Controllers;
import java.io.IOException;

import com.example.Models.*;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/sloth")
public class SlothRestController{
    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Sloth sloth){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return SlothRestDataArrayList.add(sloth);
            }
            case JSON -> {
                try {
                    return SlothRestDataJSON.add(sloth);
                } catch (IOException e) {
                }
            }
            case JPA -> {
                return null;
            }
            case SQL -> {
                return null;
            }
            default -> {
                return null;
            }
        }
        return null;
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Sloth> getAll(){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return SlothRestDataArrayList.getAll();
            }
            case JSON -> {
                try{
                    return SlothRestDataJSON.getAll();
                }catch(IOException e){}
            }
            case JPA -> {
                return null;
            }
            case SQL -> {
                return null;
            }
            default -> {
                System.out.println("no yupe found");
                return null;
            }
        }
        return null;
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Sloth findById(@PathVariable int id){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return SlothRestDataArrayList.getById(id);
            }
            case JSON -> {
                try{
                    return SlothRestDataJSON.findById(id);
                }catch(IOException e){}
            }
            case JPA -> {
                return null;
            }
            case SQL -> {
                return null;
            }
            default -> {
                return null;
            }
        }
        return null;
    }
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Sloth updateById(@RequestBody Sloth sloth){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return SlothRestDataArrayList.update(sloth);
            }
            case JSON -> {
                try{
                    return SlothRestDataJSON.update(sloth);
                }catch(IOException e){}
            }
            case JPA -> {
                return null;
            }
            case SQL -> {
                return null;
            }
            default -> {
                return null;
            }
        }
        return null;
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return SlothRestDataArrayList.delete(id);
            }
            case JSON -> {
                try{
                    return SlothRestDataJSON.delete(id);
                }catch(IOException e){}
            }
            case JPA -> {
                return null;
            }
            case SQL -> {
                return null;
            }
            default -> {
                return null;
            }
        }
        return null;
    }
}
