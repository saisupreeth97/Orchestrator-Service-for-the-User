package com.supreeth.userapi.service;

import com.supreeth.userapi.dto.UserDto;
import com.supreeth.userapi.feign.IUserFeignClient;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserFeignClient iUserFeignClient;

    public UserDto addUser(UserDto userDto)
    {
        return iUserFeignClient.addUser(userDto);
    }

    public UserDto getUserByEmail(String emailId)
    {
        return iUserFeignClient.getUserByEmail(emailId);
    }

    public List<UserDto> getUsers()
    {
        return iUserFeignClient.getUsers();
    }

    public UserDto updateUser(UserDto userDto) {
        return iUserFeignClient.updateUser(userDto);
    }

    public String deleteUser(String emailId)
    {
        return iUserFeignClient.deleteUser(emailId);
    }
}
