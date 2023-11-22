package com.example.first.controller;

import com.example.first.dto.UserDto;
import com.example.first.entity.User;
import com.example.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/getUser")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/deleteUser")
    public Boolean deleteUser(@RequestBody UserDto userDto){
        return userService.deleteUser(userDto);
    }

    @GetMapping("/userByid/{userId}")
    public UserDto getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/userByidadd/{userId}/{address}")
    public UserDto getUserByIdandAddress(@PathVariable String userId,@PathVariable String address){
        return userService.getUserByIdAndAddress(userId,address);
    }
}
