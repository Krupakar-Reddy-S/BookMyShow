package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.*;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto requestDto) {
        User user = userService.signup(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        SignUpResponseDto responseDto = new SignUpResponseDto();
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setEmail(user.getEmail());
        responseDto.setId(user.getId());

        return responseDto;
    }

    @GetMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto) {
        ResponseStatus responseStatus = userService.login(
                requestDto.getEmail(),
                requestDto.getPassword()
        );

        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setResponseStatus(responseStatus);

        return responseDto;
    }

}
