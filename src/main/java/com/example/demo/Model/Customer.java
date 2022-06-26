package com.example.demo.Model;

import com.example.demo.Model.Enums.CustomerType;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private int age;
    private List<Order> orderList;
    private CustomerType customerType;

    public Customer(){};

    public Customer(String name, int age, List<Order> orderList, CustomerType customerType) {
        super();
        this.name = name;
        this.age = age;
        this.orderList = orderList;
        this.customerType=customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
