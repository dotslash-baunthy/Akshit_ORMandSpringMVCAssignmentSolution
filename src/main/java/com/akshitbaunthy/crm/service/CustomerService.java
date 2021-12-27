package com.akshitbaunthy.crm.service;

import com.akshitbaunthy.crm.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    void insert(Customer customer);

    void delete(int id);

    List<Customer> getAll();

    Customer getById(int id);

}
