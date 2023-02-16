package edu.miu.bankingsystem.service;

import edu.miu.bankingsystem.domian.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Customer getACustomer(long id);
    public void saveACustomer(Customer customer);
    public void deleteACustomer(long id);
    public void updateACustomer(long id, Customer customer);
}
