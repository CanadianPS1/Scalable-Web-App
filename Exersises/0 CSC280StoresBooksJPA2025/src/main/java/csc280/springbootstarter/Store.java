package csc280.springbootstarter;
import jakarta.persistence.*;
import java.util.*;
@Entity
public class Store{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable= false)
    private String name;
    @Column(nullable= false)
    private String description;
    @OneToMany(mappedBy = "store")
    private List<Book> books = new ArrayList<>();
    public Store(){}
    public Store(long id, String name, String description, List<Book> books){
        this.id = id;
        this.name = name;
        this.description = description;
        this.books = books;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setBooks(List<Book> books){
        this.books = books;
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public List<Book> getBooks(){
        return books;
    }
}
