package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
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

    public CustomerService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Customer create(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    private List<Customer> prepareCustomerList() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("bilisim.io", 25, new ArrayList<>()));
        customers.add(new Customer("cem", 30, prepareOrderList()));
        customers.add(new Customer("ömer", 21, prepareOrderList()));
        customers.add(new Customer("haluk", 32, prepareOrderList()));
        customers.add(new Customer("halil", 25, prepareOrderList()));
        customers.add(new Customer("fatih", 18, prepareOrderList()));
        return customers;
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

    public List<Customer> getAllCustomers() {

        // ProductService productService = new ProductService;
        // singleton olduğunun kanıtı
        System.out.println("CustomerService - productService:" + productService.toString());
        System.out.println("CustomerService - productService:" + productService.url);
        System.out.println("CustomerService - orderService:" + orderService.toString());

        orderService.createOrder();

        return prepareCustomerList();
    }

//    public List<Integer> listAllOrders(List<Customer> customerList){
//        List<Integer> orders = new ArrayList();
//        customerList.forEach(it -> orders.add(this.orderPrice(it.getOrder())));
//        return orders;
//    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }



}