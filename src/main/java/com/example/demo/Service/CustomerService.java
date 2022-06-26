package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Enums.CustomerType;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Yeni bir müşteri yaratır.
    public Customer create(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    //Bütün müşterileri getirir.
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    //Verilen id'ye sahip müşteriyi siler.
    public void deleteCustomerById(int id){customerRepository.deleteCustomerById(id);}

    //Verilen id'ye sahip müşteriyi getirir.
    public Customer getCustomerById(int id) {

        boolean isPresent = customerRepository.getCustomerById(id).isPresent();
        if (isPresent) {
            return customerRepository.getCustomerById(id).get();
        }
        return null;

    }

    //Verilen müşteriyi günceller.
    public Customer updateUser(Customer customer){
        Customer foundCustomer;
        boolean isPresent = customerRepository.getCustomerById(customer.getId()).isPresent();
        if (isPresent) {
            foundCustomer = customerRepository.getCustomerById(customer.getId()).get();
            foundCustomer.setName(customer.getName());
            foundCustomer.setCustomerType(customer.getCustomerType());
            return  customerRepository.updateCustomer(foundCustomer);
        }

        return null;
    }

    private List<Order> prepareOrderList() {
        List<Order> orders = new ArrayList<>();
        int randomOrderNumber = new Random().nextInt(5);
        for (int i = 0; i < randomOrderNumber; i++) {
            Order order = new Order(prepareProductList(randomOrderNumber));
            orders.add(order);
        }
        return orders;
    }

    private List<Product> prepareProductList(int randomOrderNumber) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();

        products.add(new Product("MacBook Pro", random.nextDouble()));
        products.add(new Product("MacBook air", random.nextDouble()));
        products.add(new Product("Mac Mini", random.nextDouble()));
        products.add(new Product("iPhone 11", random.nextDouble()));
        products.add(new Product("iPhone 12", random.nextDouble()));

        return products.stream().limit(randomOrderNumber).collect(Collectors.toList());
    }

}