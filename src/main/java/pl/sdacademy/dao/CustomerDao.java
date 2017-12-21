package pl.sdacademy.dao;

import pl.sdacademy.entity.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getAllCustomers();
    public Customer findCustomerByEmail(String email);
}
