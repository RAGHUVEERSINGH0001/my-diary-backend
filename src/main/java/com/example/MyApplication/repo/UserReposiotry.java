package com.example.MyApplication.repo;

import com.example.MyApplication.models.MyUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiotry extends MongoRepository<MyUser,String> {
    MyUser findByUsername(String username);
}
