package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.User;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomerById(@PathVariable int id) {
        customerService.deleteCustomerById(id);
    }

    @GetMapping(value = "/{id}")
    public Customer getUserById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping
    public Customer updateUser(@RequestBody Customer customer) {
        return customerService.updateUser(customer);
    }
}
