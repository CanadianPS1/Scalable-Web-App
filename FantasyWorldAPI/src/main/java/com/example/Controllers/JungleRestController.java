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
@RequestMapping("/jungle")
public class JungleRestController{
    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Jungle jungle){
        return JungleRestDataArrayList.add(jungle);
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Jungle> getAll(){
        return JungleRestDataArrayList.getAll();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Jungle findById(@PathVariable int id){
        return JungleRestDataArrayList.getById(id);
    }
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Jungle updateById(@RequestBody Jungle jungle){
        return JungleRestDataArrayList.update(jungle);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        return JungleRestDataArrayList.delete(id);
    }
}
