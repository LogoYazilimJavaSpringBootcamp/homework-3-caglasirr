package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Expense;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;

    //Parametrede verilen user ile yeni bir user yaratır.
    public User createUser(User request) {
       return userRepository.save(request);
    }

    //Bütün user'ları getirir.
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    //Email adresi verilen kullanıcıyı getirir.
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

    //Id'si verilen kullanıcıyı getirir.
    public User getUserById(int id) {

        boolean isPresent = userRepository.getUserById(id).isPresent();
        if (isPresent) {
            return userRepository.getUserById(id).get();
        }
        return null;

    }

    //id'si verilen user'ın aktif müşterilerini getirir.
    public List<Customer> activeCustomerOfUser(int id) {
        User user;
        boolean isPresent = userRepository.getUserById(id).isPresent();
        if (isPresent) {
            user = getUserById(id);
            return userRepository.activeCustomerOfUser(user);
        }
        return null;

    }

    //id'si verilen user'ın pasif müşterilerini getirir.
    public List<Customer> passiveCustomerOfUser(int id) {
        User user;
        boolean isPresent = userRepository.getUserById(id).isPresent();
        if (isPresent) {
            user = getUserById(id);
            return userRepository.passiveCustomerOfUser(user);
        }
        return null;

    }

    //Id'si verilen user'ı siler.
    public void deleteUserById(int id){
        userRepository.deleteUserById(id);
    }

    //Verilen user'ı günceller.
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

    //id'si verilen user'ın masraf (expense) girişi yapmasını sağlar.
    public User addExpence(int userId, Expense expense){
        User user;
        boolean isPresent = userRepository.getUserById(userId).isPresent();
        if (isPresent) {
            user = getUserById(userId);
            userRepository.addExpence(user, expense);
            return user;
        }
        return null;
    }

    //id'si verilen user'ın, id'si verilen masrafını silmesini sağlar.
    public void deleteExpence(int userId, int expenseId){
        User user;
        Expense expense;
        user = getUserById(userId);
        userRepository.deleteExpence(user, expenseId);
    }

    //id'si verilen User'ın bütün masraflarını getirir.
    public List<Expense> findAllExpencesofUser(int userId){
        return userRepository.findAllExpencesofUser(getUserById(userId));
    }

    //Verilen userId'ye sahip kullanıcının, verilen expenseId'ye sahip masrafını getirir.
    public Expense findExpenceofUserById(int userId, int expenseId){
        return userRepository.findExpenceofUserById(getUserById(userId), expenseId);
    }

    //Verilen userId'ye sahip kullanıcının expense'ini günceller.
    public Expense updateExpenseOfUser(int userId, Expense expense){
        User user = getUserById(userId);
        Expense expense_;

        expense_ = findExpenceofUserById(user.getId(), expense.getId());
        expense_.setFirmType(expense.getFirmType());
        expense_.setBillNumber(expense.getBillNumber());
        expense_.setCustomerName(expense.getCustomerName());
        expense_.setPaymentStatus(expense.getPaymentStatus());
        expense_.setCurrency(expense.getCurrency());

        return userRepository.updateExpenseOfUser(user, expense_);
    }
}