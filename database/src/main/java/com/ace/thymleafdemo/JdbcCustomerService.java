package com.ace.thymleafdemo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JdbcCustomerService implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> allCustomers() {

        return customerRepository.findAll().stream().map(JdbcCustomerService::convertEntity).toList();
    }

    private static Customer convertEntity(CustomerEntity e) {
        return new Customer(e.getId().toString(), e.getName(), e.getEmail());
    }

    @Override
    public Optional<Customer> findCustomerById(String id) {
        return customerRepository.findById(Integer.parseInt(id)).map(JdbcCustomerService::convertEntity);
    }

    @Override
    public Customer upsertCustomer(Customer customer) {
return customer;
    }
}
