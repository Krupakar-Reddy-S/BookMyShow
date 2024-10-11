package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signup(String name, String email, String password) {
        // First check if the user with the given email already exists in the database
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()) {
            // Redirect to login

            return optionalUser.get();
        }

        // User not present so create
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        // password should be encrypted before storing, ignoring for now
        // we can use BCryptPasswordEncoder
        user.setPassword(password);

        return userRepository.save(user);
    }

    @Override
    public ResponseStatus login(String email, String inputPassword) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            // redirect to signup
        }

        User user = optionalUser.get();

        if (user.getPassword().equals(inputPassword)) {
            // login successful
            return ResponseStatus.SUCCESS;
        }

        return ResponseStatus.FAILURE;
    }
}
