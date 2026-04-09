package com.example.MyApplication.controllers;

import com.example.MyApplication.jwt.JwtUtil;
import com.example.MyApplication.models.MyUser;
import com.example.MyApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService service;

    //register
    @PostMapping("/register")
    public String register(@Valid @RequestBody MyUser myUser){
return service.register(myUser);

    }

    //login
    @PostMapping("/login")
    public String login(@Valid @RequestBody MyUser myUser){
      return   service.login(myUser);
    }

    //get all
  @GetMapping()
    public List<MyUser> get(){
        return service.getallUsers();
   }

    @DeleteMapping("/delete/{username}")
    public String delete(@PathVariable String username){
        service.del(username);
        return "deleted successfully";

    }

}
