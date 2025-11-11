package csc280.springbootstarter;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/store")
@SuppressWarnings("unused")
public class StoreRestController{
    private final StoreJPARepository storeRepo;
    private final BookJPARepository bookRepo;
    StoreRestController(StoreJPARepository storeRepo, BookJPARepository bookRepo){
        this.storeRepo = storeRepo;
        this.bookRepo = bookRepo;
    }
    @SuppressWarnings("null")
    @PostMapping(path = "")
    public void createStore(@RequestBody Store store){
        storeRepo.save(store);
    }
    //https/://localhost:8080/store/123
    @GetMapping(path = "/{id}")
    public Store findOneStoreById(@PathVariable long id){
        Store store = storeRepo.findById(id).orElseThrow();
        return store;
    }
    @DeleteMapping("/{storeId}")
    public HttpEntity<?> deleteStore(@PathVariable long storeId){
        storeRepo.deleteById(storeId);
        return null;
    }
}
