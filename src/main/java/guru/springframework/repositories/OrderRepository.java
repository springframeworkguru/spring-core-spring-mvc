package guru.springframework.repositories;

import guru.springframework.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 12/21/15.
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
