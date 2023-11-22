package com.example.first.service;

import com.example.first.dto.UserDto;
import com.example.first.entity.User;
import com.example.first.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto saveUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }
    public List<UserDto> getAllUsers(){
         List<User> userList =userRepo.findAll();
         return modelMapper.map(userList,new TypeToken<List<UserDto>>(){}.getType());
    }

    public UserDto updateUser(UserDto userDto){
        userRepo.save(modelMapper.map(userDto,User.class));
        return userDto;
    }

    public boolean deleteUser(UserDto userDto){
        userRepo.delete(modelMapper.map(userDto,User.class));
        return true;
    }

    //user id > User details
    //select * from user where id='1'

    public UserDto getUserById(String userId){
        User userByUserId = userRepo.getUserByUserId(userId);
        return modelMapper.map(userByUserId,UserDto.class);
    }

    //user id,address > user details
    //select* from user where id='1' and address='Gampaha'
    public UserDto getUserByIdAndAddress(String userId,String address){
        return modelMapper.map(userRepo.getUserByIdAndAddress(userId,address),UserDto.class);
    }
}
