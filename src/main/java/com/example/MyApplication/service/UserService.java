package com.example.MyApplication.service;

import com.example.MyApplication.dto.NotesDTO;
import com.example.MyApplication.exception.UserNotFoundException;
import com.example.MyApplication.jwt.JwtUtil;
import com.example.MyApplication.models.MyUser;
import com.example.MyApplication.models.Notes;
import com.example.MyApplication.repo.UserReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserReposiotry userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    // REGISTER
    public String register(MyUser myUser){

        MyUser user = userRepository.findByUsername(myUser.getUsername());

        if(user != null) {

            throw new UserNotFoundException("User already exists");
        }

        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        userRepository.save(myUser);

        return "User registered successfully";
    }

    // LOGIN
    public String login(MyUser myUser){

        MyUser user = userRepository.findByUsername(myUser.getUsername());

        if(user == null){
            return "user does not found , please register first";
        }

        if(!passwordEncoder.matches(myUser.getPassword(), user.getPassword())){
                return "Invalid password";
        }
        String token = jwtUtil.generateToken(user.getUsername());

        return token;
    }

    //get all
    public List<MyUser> getallUsers(){
        return userRepository.findAll();
    }

    //delete user by username
    public String del(String username){
        MyUser user = userRepository.findByUsername(username);
       if(user==null){
           throw new UserNotFoundException("User not found");
        }
        String id =user.getId();
        userRepository.delete(user);
        return "User deleted successfully";
    }
}