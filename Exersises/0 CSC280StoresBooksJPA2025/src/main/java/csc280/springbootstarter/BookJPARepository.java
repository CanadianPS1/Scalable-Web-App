package csc280.springbootstarter;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookJPARepository extends JpaRepository<Book, Long>{}