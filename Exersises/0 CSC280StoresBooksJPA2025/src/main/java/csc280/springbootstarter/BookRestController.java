package csc280.springbootstarter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
@RestController
@RequestMapping("/book")
public class BookRestController{
    @Autowired
    private BookJPARepository bookRepo;
    @Autowired
    private StoreJPARepository storeRepo;
    @GetMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    //returns all books
    public List<Book> findAllBooks(){
        return bookRepo.findAll();
    }
    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewBook(@RequestBody Book book){
        book.setUpdateOn(java.time.LocalDateTime.now());
        bookRepo.save(book);
    }
}
