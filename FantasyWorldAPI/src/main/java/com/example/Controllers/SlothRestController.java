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
                } catch (Exception e) {
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
        return SlothRestDataArrayList.getAll();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Sloth findById(@PathVariable int id){
        return SlothRestDataArrayList.getById(id);
    }
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Sloth updateById(@RequestBody Sloth sloth){
        return SlothRestDataArrayList.update(sloth);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        return SlothRestDataArrayList.delete(id);
    }
}
