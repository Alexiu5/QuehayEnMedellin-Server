package com.project.event.server.Controller;

import com.project.event.server.Domain.Dto.UserDto;
import com.project.event.server.Domain.Dto.UserLoginDto;
import com.project.event.server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user.login")
    @ResponseBody
    public ResponseEntity userLogin (@RequestBody @Valid UserLoginDto userLoginDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("exist", userService.userLogin(userLoginDto.getUsername(), userLoginDto.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/user.list")
    @ResponseBody
    public ResponseEntity getAllUsers (HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("users", userService.getAllUsers());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/user.create")
    @ResponseBody
    public ResponseEntity createUser (@RequestBody @Valid UserDto userDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", userService.createUser(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/user.update")
    @ResponseBody
    public ResponseEntity updateUSer (@RequestBody @Valid UserDto userDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", userService.updateUser(userDto));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/user.{id}")
    @ResponseBody
    public ResponseEntity getUserById (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("user", userService.getUserById(id));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/user.remove.{id}")
    @ResponseBody
    public ResponseEntity removeUser (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
