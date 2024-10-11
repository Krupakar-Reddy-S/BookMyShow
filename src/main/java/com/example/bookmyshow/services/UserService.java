package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.models.User;

public interface UserService {
    User signup(String name, String email, String password);

    ResponseStatus login(String email, String password);
}
