package guru.springframeworkk.repositories;

import guru.springframeworkk.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by A707937 on 02-08-2020.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
