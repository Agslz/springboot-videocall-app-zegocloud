package com.ags.videocall.user.controllers;

import com.ags.videocall.user.User;
import com.ags.videocall.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public void register(User user) {
        userService.register(user);
    }

    @PostMapping("/login")
    public User login(User user) {
        return userService.login(user);
    }

    @PostMapping("/logout")
    public void logout(String email) {
        userService.logout(email);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }


}
