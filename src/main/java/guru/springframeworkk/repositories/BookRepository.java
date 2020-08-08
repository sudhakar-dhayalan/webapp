package guru.springframeworkk.repositories;

import guru.springframeworkk.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by A707937 on 25-07-2020.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
