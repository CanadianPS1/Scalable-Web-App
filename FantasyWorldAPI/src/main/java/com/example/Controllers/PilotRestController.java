package com.example.Controllers;
import com.example.Models.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@SuppressWarnings("unused")
@RestController
@RequestMapping("/pilot")
public class PilotRestController{
    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Pilot pilot){
        return PilotRestDataArrayList.add(pilot);
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Pilot> getAll(){
        return PilotRestDataArrayList.getAll();
    }
}
