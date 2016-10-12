package guru.springframework.controllers;

import guru.springframework.commands.CustomerForm;
import guru.springframework.commands.validators.CustomerFormValidator;
import guru.springframework.converters.CustomerToCustomerForm;
import guru.springframework.domain.Customer;
import guru.springframework.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by jt on 11/15/15.
 */
@RequestMapping("/customer")
@Controller
public class CustomerController {

    private CustomerService customerService;
    private Validator customerFormValidator;
    private CustomerToCustomerForm customerToCustomerForm;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    @Qualifier("customerFormValidator")
    public void setCustomerFormValidator(CustomerFormValidator customerFormValidator) {
        this.customerFormValidator = customerFormValidator;
    }

    @Autowired
    public void setCustomerToCustomerForm(CustomerToCustomerForm customerToCustomerForm) {
        this.customerToCustomerForm = customerToCustomerForm;
    }

    @RequestMapping({"/list", "/"})
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAll());
        return "customer/list";
    }

    @RequestMapping("/show/{id}")
    public String showCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){

        Customer customer = customerService.getById(id);

        model.addAttribute("customerForm", customerToCustomerForm.convert(customer));
        return "customer/customerform";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customerForm", new CustomerForm());
        return "customer/customerform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(@Valid CustomerForm customerForm, BindingResult bindingResult){

        customerFormValidator.validate(customerForm, bindingResult);

        if(bindingResult.hasErrors()){
            return "customer/customerform";
        }

        Customer newCustomer = customerService.saveOrUpdateCustomerForm(customerForm);
        return "redirect:customer/show/" + newCustomer.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
