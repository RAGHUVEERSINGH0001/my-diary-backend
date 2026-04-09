package com.example.MyApplication.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class NotesDTO {
    private String title;
    private String content;
    private LocalDateTime createdAt;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public NotesDTO(String title, String content, @NotBlank(message = "content cannot be empty") String noteContent, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private LocalDateTime  updatedAt;
}
