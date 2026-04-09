package com.example.MyApplication.repo;

import com.example.MyApplication.models.MyUser;
import com.example.MyApplication.models.Notes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepo extends MongoRepository<Notes,String> {
    Page<Notes> findByUserId(String userId,Pageable pageable);
   // Page<Notes> findByUsername(String username, Pageable pageable);


}
