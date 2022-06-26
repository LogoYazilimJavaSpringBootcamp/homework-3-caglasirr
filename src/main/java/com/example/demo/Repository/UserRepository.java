package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Enums.CustomerType;
import com.example.demo.Model.Expense;
import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    public User save(User request) {
        userList.add(request);
        return request;
    }

    public List<User> findAll() {
        return userList;
    }

    public Optional<User> findByEmail(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    public void deleteUserById(int id){
        User deletedUser = userList.stream().filter(user -> user.getId() == id).findFirst().get();
        userList.remove(deletedUser);
    }

    public Optional<User> getUserById(int id){
        return userList.stream().filter(u-> u.getId() == id).findFirst();
    }

    public User update(User user){
        int index = userList.indexOf(getUserById(user.getId()).get());
        userList.set(index, user);
        return user;
    }

    public List<Customer> activeCustomerOfUser(User user) {
        return user.getCustomerList().stream().filter(c -> c.getCustomerType().equals(CustomerType.ACTIVE)).collect(Collectors.toList());
    }

    public List<Customer> passiveCustomerOfUser(User user) {
        return user.getCustomerList().stream().filter(c -> c.getCustomerType().equals(CustomerType.PASSIVE)).collect(Collectors.toList());
    }

    //Verilen user'ın expense list'ine, parametrede verilen expense'i ekler.
    public User addExpence(User user, Expense expense){
        user.getExpenseList().add(expense);
        return user;
    }

    public void deleteExpence(User user, int expenseId){
        Expense expense = user.getExpenseList().stream().filter(e -> e.getId() == expenseId).findFirst().get();
        user.getExpenseList().remove(expense);
    }

    //User'ın bütün masraflarını getirir.
    public List<Expense> findAllExpencesofUser(User user){
        return user.getExpenseList();
    }
}