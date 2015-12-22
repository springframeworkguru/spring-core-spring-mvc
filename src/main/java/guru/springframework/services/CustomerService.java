package guru.springframework.services;

import guru.springframework.commands.CustomerForm;
import guru.springframework.domain.Customer;

/**
 * Created by jt on 11/14/15.
 */
public interface CustomerService extends CRUDService<Customer>{

    Customer saveOrUpdateCustomerForm(CustomerForm customerForm);

}
