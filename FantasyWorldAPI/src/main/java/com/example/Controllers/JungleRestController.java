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
@RequestMapping("/jungle")
public class JungleRestController{
    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Jungle jungle){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return JungleRestDataArrayList.add(jungle);
            }
            case JSON -> {
                try {
                    return JungleRestDataJSON.add(jungle);
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
    public List<Jungle> getAll(){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return JungleRestDataArrayList.getAll();
            }
            case JSON -> {
                try{
                    return JungleRestDataJSON.getAll();
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
    public Jungle findById(@PathVariable int id){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return JungleRestDataArrayList.getById(id);
            }
            case JSON -> {
                try{
                    return JungleRestDataJSON.findById(id);
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
    public Jungle updateById(@RequestBody Jungle jungle){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return JungleRestDataArrayList.update(jungle);
            }
            case JSON -> {
                try{
                    return JungleRestDataJSON.update(jungle);
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
                return JungleRestDataArrayList.delete(id);
            }
            case JSON -> {
                try{
                    return JungleRestDataJSON.delete(id);
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
