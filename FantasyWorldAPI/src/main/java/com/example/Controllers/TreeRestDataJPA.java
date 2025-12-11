package com.example.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Models.*;
@RestController
@RequestMapping("/trees")
public class TreeRestDataJPA {
    @Autowired
    private SlothRepository slothRepository;
    @Autowired
    private TreeRepository treeRepository;
    @SuppressWarnings("null")
    @PostMapping
    public String add(@RequestBody Tree tree){
        treeRepository.save(tree);
        return "Tree Added";
    }
    @GetMapping
    public List<Tree> getAll(){return treeRepository.findAll();}
    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public Tree findById(@PathVariable Integer id){return treeRepository.findById(id).orElse(null);}
    @SuppressWarnings("null")
    @PutMapping("/{id}")
    public Tree update(@RequestBody Tree tree, @PathVariable Integer id){
        return treeRepository.save(tree);
    }
    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        treeRepository.deleteById(id);
        return "Tree Deleted";
    }
    @PutMapping("/{TreeID}/sloth/{slothID}")
    public Tree assignToSloth(@PathVariable Integer treeID, @PathVariable Integer slothID) {
        @SuppressWarnings("null")
        Tree tree = treeRepository.findById(treeID).orElse(null);
        @SuppressWarnings("null")
        Sloth sloth = slothRepository.findById(slothID).orElse(null);
        if(tree != null && slothID != null){
            tree.setSloth(sloth);
            return treeRepository.save(tree);
        }return null;
    }
}