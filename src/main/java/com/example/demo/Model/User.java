package com.example.demo.Model;

import com.example.demo.Model.Enums.FirmType;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private String surname;
    private String email;
    private String password;
    private FirmType firmType;
    private Address address;
    private List<Customer> customerList = new ArrayList<>(10);



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FirmType getFirmType() {
        return firmType;
    }

    public void setFirmType(FirmType firmType) {
        this.firmType = firmType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
