package com.example.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Models.*;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/tree")
public class TreeRestController{
    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Tree tree){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return TreeRestDataArrayList.add(tree);
            }
            case JSON -> {
                try{
                    return TreeRestDataJSON.add(tree);
                }catch(IOException e){
                }
            }
            case JPA -> {
                return null; //TreeRestDataJPA.add(tree);
            }
            case SQL -> {
                return TreeRestDataSQL.add(tree);
            }
            default -> {
                return null;
            }
        }
        return null;
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Tree> getAll(){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return TreeRestDataArrayList.getAll();
            }
            case JSON -> {
                try{
                    return TreeRestDataJSON.getAll();
                }catch(IOException e){}
            }
            case JPA -> {
                return null; //TreeRestDataJPA.getAll();
            }
            case SQL -> {
                return TreeRestDataSQL.getAll();
            }
            default -> {
                return null;
            }
        }
        return null;
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Tree findById(@PathVariable int id){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return TreeRestDataArrayList.getById(id);
            }
            case JSON -> {
                try{
                    return TreeRestDataJSON.findById(id);
                }catch(IOException e){}
            }
            case JPA -> {
                return null; //TreeRestDataJPA.findById(id);
            }
            case SQL -> {
                return TreeRestDataSQL.findById(id);
            }
            default -> {
                return null;
            }
        }
        return null;
    }
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Tree updateById(@RequestBody Tree tree){
        switch(Settings.dbStatus){
            case ARRAYLIST -> {
                return TreeRestDataArrayList.update(tree);
            }
            case JSON -> {
                try{
                    return TreeRestDataJSON.update(tree);
                }catch(IOException e){}
            }
            case JPA -> {
                return null; //TreeRestDataJPA.update(tree);
            }
            case SQL -> {
                return TreeRestDataSQL.update(tree);
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
                return TreeRestDataArrayList.delete(id);
            }
            case JSON -> {
                try{
                    return TreeRestDataJSON.delete(id);
                }catch(IOException e){}
            }
            case JPA -> {
                return null; //TreeRestDataJPA.delete(id);
            }
            case SQL -> {
                return TreeRestDataSQL.delete(id);
            }
            default -> {
                return null;
            }
        }
        return null;
    }
}
