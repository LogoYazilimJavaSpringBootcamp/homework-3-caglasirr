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

    //Yeni bir müşteri yaratır.
    public Customer save(Customer request) {
        customerList.add(request);
        return request;
    }

    //Bütün müşterileri getirir.
    public List<Customer> findAll() {
        return customerList;
    }

    //Verilen id'ye sahip müşteriyi siler.
    public void deleteCustomerById(int id){
        Customer deletedCustomer = customerList.stream().filter(c -> c.getId() == id).findFirst().get();
        customerList.remove(deletedCustomer);
    }

    //Verilen id'ye sahip müşteriyi getirir.
    public Optional<Customer> getCustomerById(int id){
        return customerList.stream().filter(c-> c.getId() == id).findFirst();
    }

    //Verilen müşteriyi günceller.
    public Customer updateCustomer(Customer customer){
        int index = customerList.indexOf(getCustomerById(customer.getId()).get());
        customerList.set(index, customer);
        return customer;
    }

}
