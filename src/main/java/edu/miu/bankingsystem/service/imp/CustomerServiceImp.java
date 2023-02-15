package edu.miu.bankingsystem.service.imp;

import edu.miu.bankingsystem.domian.Customer;
import edu.miu.bankingsystem.repository.CustomerRepo;
import edu.miu.bankingsystem.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerServiceImp(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getACustomer(long id) {
        return customerRepo.findById(id).get();
    }

    @Override
    public void saveACustomer(Customer customer) {
     customerRepo.save(customer);
    }

    @Override
    public void deleteACustomer(long id) {
     customerRepo.deleteById(id);
    }

    @Override
    public void updateACustomer(long id, Customer customer) {
    customerRepo.save(customer);
    }
}
