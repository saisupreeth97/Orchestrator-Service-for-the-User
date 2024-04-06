package com.supreeth.userapi.feign;

import com.supreeth.userapi.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-microservice",configuration = ClientConfiguration.class)
public interface IUserFeignClient {

    @PostMapping("/users/register")
    UserDto addUser(@RequestBody UserDto userDto);

    @GetMapping("/users")
    List<UserDto> getUsers();

    @GetMapping("/users/{emailId}")
    UserDto getUserByEmail(@PathVariable String emailId);

    @PutMapping("/users/update")
    UserDto updateUser(@RequestBody UserDto userDto);

    @DeleteMapping("/users/delete/{emailId}")
    String deleteUser(@PathVariable String emailId);
}
