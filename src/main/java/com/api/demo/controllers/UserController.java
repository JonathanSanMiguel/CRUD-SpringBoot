package com.api.demo.controllers;

import com.api.demo.models.UserModel;
import com.api.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ArrayList<UserModel> getUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/getOneUser/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/addNewUser")
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @PutMapping("/updateAUser/{id}")
    public UserModel updateById(@RequestBody UserModel request, @PathVariable("id") Long id) {
        return this.userService.updateUser(request, id);
    }

}
