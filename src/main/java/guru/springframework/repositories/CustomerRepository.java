package guru.springframework.repositories;

import guru.springframework.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 12/21/15.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
