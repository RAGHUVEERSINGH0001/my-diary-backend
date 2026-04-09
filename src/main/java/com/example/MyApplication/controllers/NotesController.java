package com.example.MyApplication.controllers;

import com.example.MyApplication.dto.NotesDTO;
import com.example.MyApplication.models.Notes;
import com.example.MyApplication.service.NotesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Notes API",description = "Operation related to notes")
@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService service;

    // Create a note
    @Operation(description = "Through this method you create a new node")
    @PostMapping("/{username}")
    public String post(@Valid @RequestBody Notes notes,
                                      @PathVariable String username){

        String saved = service.post(notes, username);
         ResponseEntity.status(HttpStatus.CREATED).body(saved);
         return "saved";
    }

    // Get all notes
    @Operation(description = "Using this you can get all your notes that you have made ")
    @GetMapping("/{username}")
    public Page<NotesDTO> get(@PathVariable String username,
                              @PageableDefault(size = 5)Pageable pageable){
       return  service.getNotesDTOByUsername(username,pageable);

    }
    // Update a note
    @Operation(description = "Using this you can  update your method ")
    @PutMapping("/{username}/{id}")
    public ResponseEntity<Notes> update(@PathVariable String username,
                                        @PathVariable String id,
                                        @Valid @RequestBody Notes notes){

        Notes updated = service.update(username, id, notes);
        return ResponseEntity.ok(updated);
    }

    // Delete a note
    @Operation(description = "using this you can delete your node ")
    @DeleteMapping("/{username}/{id}")
    public ResponseEntity<String> delete(@PathVariable String username,
                                         @PathVariable String id){

        String message = service.delete(username, id);
        return ResponseEntity.ok(message);
    }
}