package guru.springframework.repositories;

import guru.springframework.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 12/21/15.
 */
public interface RoleRepsoitory extends CrudRepository<Role, Integer> {
}
