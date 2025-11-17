package com.example.Controllers;
import com.example.Models.*;
import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/tree")
public class TreeRestController{
    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Tree tree){
        return TreeRestDataArrayList.add(tree);
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Tree> getAll(){
        return TreeRestDataArrayList.getAll();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Tree findById(@PathVariable int id){
        return TreeRestDataArrayList.getById(id);
    }
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Tree updateById(@RequestBody Tree tree){
        return TreeRestDataArrayList.update(tree);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        return TreeRestDataArrayList.delete(id);
    }
}
