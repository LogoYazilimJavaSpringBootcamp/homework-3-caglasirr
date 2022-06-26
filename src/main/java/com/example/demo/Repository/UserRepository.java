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

    //User'ı kaydeder -User List'e ekler-.
    public User save(User request) {
        userList.add(request);
        return request;
    }

    //Bütün User'ları getirir.
    public List<User> findAll() {
        return userList;
    }

    //Verilen parametredeki email'e sahip kullanıcıyı getirir.
    public Optional<User> findByEmail(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    //Parametrede verilen id'ye sahip kullanıcıyı siler.
    public void deleteUserById(int id){
        User deletedUser = userList.stream().filter(user -> user.getId() == id).findFirst().get();
        userList.remove(deletedUser);
    }

    //Parametrede verilen id'ye sahip kullanıcıyı getirir.
    public Optional<User> getUserById(int id){
        return userList.stream().filter(u-> u.getId() == id).findFirst();
    }

    //Parametrede verilen User'ı, yine parametrede verilen User şeklinde günceller.
    public User update(User user){
        int index = userList.indexOf(getUserById(user.getId()).get());
        userList.set(index, user);
        return user;
    }

    //Aşağıdaki iki method, User'ın aktif ve pasif müşterilerini getirir.
    public List<Customer> activeCustomerOfUser(User user) {
        return user.getCustomerList().stream().filter(c -> c.getCustomerType().equals(CustomerType.ACTIVE)).collect(Collectors.toList());
    }

    public List<Customer> passiveCustomerOfUser(User user) {
        return user.getCustomerList().stream().filter(c -> c.getCustomerType().equals(CustomerType.PASSIVE)).collect(Collectors.toList());
    }

    //Aşağıdaki methodlar, User'ın masraf (Expense) eklemesini, silmesini, bütün masraflarını görüntüleyebilmesini
    //ve masrafını seçip güncellemesini sağlar.


    //Verilen user'ın expense list'ine, parametrede verilen expense'i ekler.
    public User addExpence(User user, Expense expense){
        user.getExpenseList().add(expense);
        return user;
    }

    ////Verilen user'ın expense list'inden, parametrede verilen expenseId'ye sahip masrafı siler.
    public void deleteExpence(User user, int expenseId){
        Expense expense = user.getExpenseList().stream().filter(e -> e.getId() == expenseId).findFirst().get();
        user.getExpenseList().remove(expense);
    }

    //User'ın bütün masraflarını getirir.
    public List<Expense> findAllExpencesofUser(User user){
        return user.getExpenseList();
    }

    //Verilen userId'ye sahip kullanıcının, verilen expenseId'ye sahip masrafını getirir.
    public Expense findExpenceofUserById(User user, int expenseId){
        return user.getExpenseList().stream().filter(e -> e.getId() == expenseId).findFirst().get();
    }

    //Verilen userId'ye sahip kullanıcının expense'ini günceller.
    public Expense updateExpenseOfUser(User user, Expense expense){
        int index = user.getExpenseList().indexOf(findExpenceofUserById(user, expense.getId()));
        return user.getExpenseList().set(index, expense);
    }
}