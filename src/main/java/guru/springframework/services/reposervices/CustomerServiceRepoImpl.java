package guru.springframework.services.reposervices;

import guru.springframework.commands.CustomerForm;
import guru.springframework.converters.CustomerFormToCustomer;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CustomerRepository;
import guru.springframework.repositories.UserRepository;
import guru.springframework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 12/21/15.
 */
@Service
@Profile("springdatajpa")
public class CustomerServiceRepoImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private UserRepository userRepository;
    private CustomerFormToCustomer customerFormToCustomer;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCustomerFormToCustomer(CustomerFormToCustomer customerFormToCustomer) {
        this.customerFormToCustomer = customerFormToCustomer;
    }

    @Override
    public List<?> listAll() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add); //fun with Java 8
        return customers;
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return customerRepository.save(domainObject);
    }

    @Override
    public Customer saveOrUpdateCustomerForm(CustomerForm customerForm) {
        Customer newCustomer = customerFormToCustomer.convert(customerForm);

        if(newCustomer.getUser().getId() != null){
            Customer existingCustomer = getById(newCustomer.getId());

            newCustomer.getUser().setEnabled(existingCustomer.getUser().getEnabled());
        }

        return saveOrUpdate(newCustomer);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Customer customer = customerRepository.findOne(id);

        userRepository.delete(customer.getUser());
        customerRepository.delete(customer);
    }
}
