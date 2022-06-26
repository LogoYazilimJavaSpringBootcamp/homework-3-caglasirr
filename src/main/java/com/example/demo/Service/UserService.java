package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Customer;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User request) {
       return userRepository.save(request);
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        //kullanıcı bulunamadığında hata verilmeli
        //userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException());
        //userRepository.findByEmail(email).orElseThrow(RuntimeException::new);

        boolean isPresent = userRepository.findByEmail(email).isPresent();
        if (isPresent) {
            return userRepository.findByEmail(email).get();
        }
        // null dönme
        return null;

    }

    public User getUserById(int id) {

        boolean isPresent = userRepository.getUserById(id).isPresent();
        if (isPresent) {
            return userRepository.getUserById(id).get();
        }
        return null;

    }

    public void deleteUserById(int id){
        userRepository.deleteUserById(id);
    }

    public User updateUser(User user){
        User foundUser;
        boolean isPresent = userRepository.getUserById(user.getId()).isPresent();
        if (isPresent) {
            foundUser = userRepository.getUserById(user.getId()).get();
            foundUser.setName(user.getName());
            foundUser.setSurname(user.getSurname());
            foundUser.setEmail(user.getEmail());
            foundUser.setAddress(user.getAddress());
            foundUser.setCustomerList(user.getCustomerList());
            foundUser.setPassword(user.getPassword());
            foundUser.setFirmType(user.getFirmType());
            foundUser.setId(user.getId());
            return  userRepository.update(foundUser);
        }

        return null;
    }

//    public Configuration updateConfig(Configuration configuration) {
//        Configuration selectedConfiguration = configurationDao.findById(configuration.getId()).orElse(configuration);
//        selectedConfiguration.setName(configuration.getName());
//        selectedConfiguration.setDescription(configuration.getDescription());
//        selectedConfiguration.setSearchType(configuration.getSearchType());
//        selectedConfiguration.setSourceType(configuration.getSourceType());
//        selectedConfiguration.setCreateDate(configuration.getCreateDate());
//        selectedConfiguration.setCreatedByUserName(configuration.getCreatedByUserName());
//        return configurationDao.save(selectedConfiguration);
//    }

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