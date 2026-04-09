package com.example.MyApplication.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {
    @Id
    private String id;
    @Indexed(unique = true)
    @NotBlank(message = "cannot be blank")
    private String username;
    @NotBlank
    private String password;
}

