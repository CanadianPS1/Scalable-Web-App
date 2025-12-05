package com.example.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Models.Sloth;
import com.example.Models.slothRepository;

public class SlothRestDataJPA {
    @PostMapping
    public Sloth create(@RequestBody Sloth sloth){
        return slothRepository.save(sloth);
    }    
    @GetMapping
    public List<Sloth> getAll(){
        return slothRepository.findAll();
    }
    @GetMapping("/{id}")
    public Sloth getOne(@PathVariable Integer id){
        return slothRepository.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public Sloth update(@PathVariable Integer Id, @RequestBody Sloth sloth){
        sloth.setId(Id);
        return slothRepository.save(sloth);
    }
    @DeleteMapping("/{id")
    public void delete(@PathVariable Integer id){
        SlothRepository.deleteById(id);
    }
    @PutMapping("/{slothId}/tree/{treeID}")
    public Sloth assignToTree(@PathVariable Integer slothId, @PathVariable Integer treeId) {
        Sloth sloth = slothRepository.findById(slothId).orElse(null);
        Tree tree = TreeRepository.findById(treeId).orElse(null);
       
        if (sloth != null && tree != null) {
            sloth.setDepartment(tree);
            return slothRepository.save(sloth);
        }
        return null;
    }
}
