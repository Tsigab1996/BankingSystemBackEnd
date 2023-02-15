package edu.miu.bankingsystem.controller;

import edu.miu.bankingsystem.domian.Customer;
import edu.miu.bankingsystem.repository.CustomerRepo;
import edu.miu.bankingsystem.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")

    public Customer getACustomerById(@PathVariable long id){
        return customerService.getACustomer(id);
    }

    @PostMapping
    public void saveACustomer(@RequestBody Customer customer){
        customerService.saveACustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteACustomer(@PathVariable long id){
        customerService.deleteACustomer(id);
    }

    @PutMapping("/{id}")
    public void updateACustomer(@PathVariable long id, @RequestBody Customer customer){
        customerService.updateACustomer(id, customer);
    }

}
