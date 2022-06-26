package com.example.demo.Repository;

import com.example.demo.Model.Customer;
import com.example.demo.Model.User;
import com.example.demo.Service.CustomerService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository
{
    private static List<Customer> customerList = new ArrayList<>();

    public Customer save(Customer request) {
        customerList.add(request);
        return request;
    }

    public List<Customer> findAll() {
        return customerList;
    }

    public void deleteCustomerById(int id){
        Customer deletedCustomer = customerList.stream().filter(c -> c.getId() == id).findFirst().get();
        customerList.remove(deletedCustomer);
    }

    public Optional<Customer> getCustomerById(int id){
        return customerList.stream().filter(c-> c.getId() == id).findFirst();
    }

    public Customer updateCustomer(Customer customer){
        int index = customerList.indexOf(getCustomerById(customer.getId()).get());
        customerList.set(index, customer);
        return customer;
    }

}
