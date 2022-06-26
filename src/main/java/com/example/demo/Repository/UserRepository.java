package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Customer;
import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    public User save(User request) {
        request.getCustomerList().add(new Customer("Onur", 23, new ArrayList<>()));
        request.getCustomerList().add(new Customer("Gizem", 23, new ArrayList<>()));
        request.getCustomerList().add(new Customer("Ceylan", 23, new ArrayList<>()));
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


//    public User updateUser(User user) {
//
//        String sql = "Update User set email = yeniemail where id =1";
//
//        User foundUser = userRepository.findById(user.getId()).get();
//
//        foundUser.setEmail(user.getEmail());
//        foundUser.setSurname(user.getSurname());
//
//        return userRepository.save(foundUser);
//    }

}