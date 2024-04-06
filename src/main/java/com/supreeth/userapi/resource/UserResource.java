package com.supreeth.userapi.resource;

import com.supreeth.userapi.dto.UserDto;
import com.supreeth.userapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getUsers()
    {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody @Valid UserDto userDto)
    {
        UserDto response = userService.addUser(userDto);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/{emailId}")
    public ResponseEntity getUserByEmail(@PathVariable String emailId)
    {
        return new ResponseEntity(userService.getUserByEmail(emailId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userService.updateUser(userDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{emailId}")
    public ResponseEntity deleteUser(@PathVariable String emailId)
    {
        return new ResponseEntity(userService.deleteUser(emailId),HttpStatus.OK);
    }

}
