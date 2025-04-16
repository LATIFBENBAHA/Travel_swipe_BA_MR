package com.travel.swipe.service;

import com.travel.swipe.exceptions.EmailAlreadyExistsException;
import com.travel.swipe.model.User;
import com.travel.swipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User getUserByUserId(Long userId){
        return userRepository.findById(userId).orElseThrow();}
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }
        return userRepository.save(user);
    }

//    public User getOrCreateUserFromFirebase(FirebaseToken token) {
//        return userRepository.findByFirebaseUid(token.getUid())
//                .orElseGet(() -> {
//                    User newUser = new User();
//                    newUser.setFirebaseUid(token.getUid());
//                    newUser.setEmail(token.getEmail());
//                    newUser.setName(token.getName());
//                    return userRepository.save(newUser);
//                });
//    }

}
