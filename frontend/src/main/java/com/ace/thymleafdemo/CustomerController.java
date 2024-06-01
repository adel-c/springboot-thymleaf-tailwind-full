package com.ace.thymleafdemo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@AllArgsConstructor
@Controller
class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("customers", customerService.allCustomers());
        return "index";
    }

    @GetMapping("/ct")
    public String ct(Model model) {
        model.addAttribute("customers", customerService.allCustomers());
        return "fragments/customer_table :: customer_tables";
    }

    @GetMapping("/customer")
    public String users(Model model) {
        model.addAttribute("customers", customerService.allCustomers());
        return "index";
    }

    @GetMapping("/customer/{id}")
    public String user(Model model, @PathVariable String id) {
        Optional<Customer> byId = customerService.findCustomerById(id);
        if (byId.isEmpty()) {
            return "notfound";
        }
        model.addAttribute("customer", byId.get());
        return "edit";
    }

}
