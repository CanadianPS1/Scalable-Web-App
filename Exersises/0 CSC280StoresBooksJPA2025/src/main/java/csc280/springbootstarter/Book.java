package csc280.springbootstarter;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
@Entity
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable= false)
    private LocalDateTime updateOn;
    @Column(nullable= false)
    private String description;
    @Column(nullable= false)
    private String author;
    @ManyToOne
    @JsonIgnore
    private Store store;
    public Book(){}
    public Book(long id, LocalDateTime updateOn, String description, String author){
        this.id = id;
        this.updateOn = updateOn;
        this.description = description;
        this.author = author;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public LocalDateTime getUpdateOn(){
        return updateOn;
    }
    public Store getStore(){
        return store;
    }
    public void setStore(Store s){
        store = s;
    }
    public void setUpdateOn(LocalDateTime updateOn){
        this.updateOn = updateOn;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
}
