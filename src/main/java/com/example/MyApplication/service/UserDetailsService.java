package com.example.MyApplication.service;

import com.example.MyApplication.models.MyUser;
import com.example.MyApplication.repo.UserReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserReposiotry reposiotry;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = reposiotry.findByUsername(username);
        if(user==null){
            throw new RuntimeException("user does not exits");
        }else{
            return new UserPrincipal(user);
        }
    }
}
