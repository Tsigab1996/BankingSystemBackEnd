package edu.miu.bankingsystem.controller;

import edu.miu.bankingsystem.domian.Customer;
import edu.miu.bankingsystem.service.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerInterface customerInterface;

    @GetMapping
    List<Customer> findAllCustomer(){
        return customerInterface.findAll();
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable("id") long id){
        return customerInterface.findById(id);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerInterface.create(customer);
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable long id){
        return customerInterface.update(customer, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerInterface.delete(id);
    }



}
