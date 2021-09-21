package pl.pstefaniak.zeus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pstefaniak.zeus.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}