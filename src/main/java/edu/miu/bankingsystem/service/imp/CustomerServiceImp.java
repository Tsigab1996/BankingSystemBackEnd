package edu.miu.bankingsystem.service.imp;

import edu.miu.bankingsystem.domian.Customer;
import edu.miu.bankingsystem.repository.CustomerRepo;
import edu.miu.bankingsystem.service.CustomerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerInterface {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public Customer create(Customer customer) {
       return customerRepo.save(customer);

    }


    @Override
    public Customer update(Customer customer, Long id) {
        Customer c= new Customer();
        c.setId(id);
        Customer newCustomer= customerRepo.save(c);
        return newCustomer;
    }

    @Override
    public void delete(long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepo.findById(id).orElse(null);
    }
}
