package guru.springframework.services;

import guru.springframework.domain.Customer;
import guru.springframework.domain.DomainObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jt on 11/14/15.
 */
@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Micheal");
        customer1.setLastName("Weston");
        customer1.setAddressLine1("1 Main St");
        customer1.setCity("Miami");
        customer1.setState("Florida");
        customer1.setZipCode("33101");
        customer1.setEmail("micheal@burnnotice.com");
        customer1.setPhoneNumber("305.333.0101");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Fiona");
        customer2.setLastName("Glenanne");
        customer2.setAddressLine1("1 Key Biscane Ave");
        customer2.setCity("Miami");
        customer2.setState("Florida");
        customer2.setZipCode("33101");
        customer2.setEmail("fiona@burnnotice.com");
        customer2.setPhoneNumber("305.323.0233");

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Sam");
        customer3.setLastName("Axe");
        customer3.setAddressLine1("1 Little Cuba Road");
        customer3.setCity("Miami");
        customer3.setState("Florida");
        customer3.setZipCode("33101");
        customer3.setEmail("sam@burnnotice.com");
        customer3.setPhoneNumber("305.426.9832");

        domainMap.put(1, customer1);
        domainMap.put(2, customer2);
        domainMap.put(3, customer3);
    }
}
