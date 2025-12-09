package com.example.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Models.*;
@RestController
@RequestMapping("/sloths")
public class SlothRestDataJPA {
    @Autowired
    private SlothRepository slothRepository;
    @Autowired
    private TreeRepository treeRepository;
    @SuppressWarnings("null")
    @PostMapping
    public Sloth create(@RequestBody Sloth sloth){return slothRepository.save(sloth);}
    @GetMapping
    public List<Sloth> getAll(){return slothRepository.findAll();}
    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public Sloth getOne(@PathVariable Integer id){return slothRepository.findById(id).orElse(null);}
    @SuppressWarnings("null")
    @PutMapping("/{id}")
    public Sloth update(@PathVariable Integer id, @RequestBody Sloth sloth){return slothRepository.save(sloth);}
    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){slothRepository.deleteById(id);}
    @PutMapping("/{slothID}/tree/{treeID}")
    public Sloth assignToTree(@PathVariable Integer slothID, @PathVariable Integer treeID) {
        @SuppressWarnings("null")
        Sloth sloth = slothRepository.findById(slothID).orElse(null);
        @SuppressWarnings("null")
        Tree tree = treeRepository.findById(treeID).orElse(null);
        if(sloth != null && treeID != null){
            sloth.setTree(tree);
            return slothRepository.save(sloth);
        }return null;
    }
}