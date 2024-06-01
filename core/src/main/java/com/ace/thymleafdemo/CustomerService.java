package com.ace.thymleafdemo;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> allCustomers();
    Optional<Customer> findCustomerById(String id);
}
