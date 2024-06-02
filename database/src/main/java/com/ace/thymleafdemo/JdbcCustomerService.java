package com.ace.thymleafdemo;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
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

    private static CustomerEntity convertEntity(Customer e) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(NumberUtils.createInteger(e.id()));
        customerEntity.setName(e.name());
        customerEntity.setName(e.email());
        return customerEntity;
    }
    @Override
    public Optional<Customer> findCustomerById(String id) {
        return customerRepository.findById(Integer.parseInt(id)).map(JdbcCustomerService::convertEntity);
    }

    @Override
    public Customer upsertCustomer(Customer customer) {
        Optional<CustomerEntity> byId = customerRepository.findById(Integer.valueOf(customer.id()));
        CustomerEntity customerEntity = byId.map(e -> {
            e.setName(customer.name());
            e.setEmail(customer.email());
            return e;
        }).orElseGet(() -> convertEntity(customer));
        CustomerEntity savedEntity = customerRepository.save(customerEntity);
        return convertEntity(savedEntity);
    }
}
