package com.example.ValidationAndExceptionHandling.service;

import com.example.ValidationAndExceptionHandling.dto.UserRequest;
import com.example.ValidationAndExceptionHandling.entity.User;
import com.example.ValidationAndExceptionHandling.exception.UserNotFoundException;
import com.example.ValidationAndExceptionHandling.repository.UserRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest){
        User user = User.build(0,
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getNationality(),
                userRequest.getAge());

       return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if(user != null){
            return user;
        }
        else {
            throw new UserNotFoundException("There is no user with id " + id);
        }
    }
}
