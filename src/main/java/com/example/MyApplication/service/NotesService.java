package com.example.MyApplication.service;

import com.example.MyApplication.dto.NotesDTO;
import com.example.MyApplication.exception.UserNotFoundException;
import com.example.MyApplication.models.MyUser;
import com.example.MyApplication.models.Notes;
import com.example.MyApplication.repo.NotesRepo;
import com.example.MyApplication.repo.UserReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {



    @Autowired
    private NotesRepo notesRepo;

    @Autowired
    private UserReposiotry reposiotry;

    public NotesDTO convertToDTO(Notes note) {
        return new NotesDTO(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }
    public Page<NotesDTO> getNotesDTOByUsername(String username, Pageable pageable) {
        MyUser user = reposiotry.findByUsername(username);
        if(user==null){
            throw new UserNotFoundException("User not found");
        }
        return notesRepo.findByUserId(user.getId(),pageable)
                .map(this::convertToDTO);
    }






    // Post a new note
    public String post(Notes notes,String username){
        MyUser user =reposiotry.findByUsername(username);
        if(user == null){
            System.out.println("user does not exist , pls register ");
            throw new RuntimeException("user does not exist , pls register");
        }
         //   String id = user.getId();
        notes.setUserId(user.getId());
           notesRepo.save(notes);
           return "saved";
           // return "notes saved successfully";
    }


    // Update a note
    public Notes update(String username, String id, Notes updatedNote) {

        MyUser user = reposiotry.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User does not exist");
        }

        Notes existingNote = notesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        if (!existingNote.getUserId().equals(user.getId())) {
            throw new RuntimeException("Access denied");
        }

        existingNote.setTitle(updatedNote.getTitle());
        existingNote.setContent(updatedNote.getContent());

        return notesRepo.save(existingNote);
    }
    //del
    public String delete(String id,String username){
        MyUser user = reposiotry.findByUsername(username);
        if(user == null){
           return "User not found";
        }
        Notes notes = notesRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        if(!notes.getUserId().equals(user.getId())){
            throw new RuntimeException("Access denied: You can only delete your own notes");
        }

        notesRepo.delete(notes);
        return "note deleted successfully";



    }
}