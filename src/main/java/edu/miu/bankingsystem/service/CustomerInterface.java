package edu.miu.bankingsystem.service;

import edu.miu.bankingsystem.domian.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerInterface   {
    public Customer create(Customer customer);
    public Customer update(Customer customer, Long id);
    public void delete(long id);
    public List<Customer> findAll();
    public Customer findById(long id);
}
