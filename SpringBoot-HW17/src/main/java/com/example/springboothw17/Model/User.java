package com.example.springboothw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {
    @Id  //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genreate id auto
   private Integer id;

    @NotEmpty(message = "name should not be empty")
   // @Size(min = 4,message = "name should be more 4 letters")
    @Pattern(regexp = "^[a-zA-Z]{4,}$",message = "name should be more 4 letters")
   private String name;

    @NotEmpty(message = "name should not be empty")
   // @Pattern(regexp = "^[a-zA-Z]{4,}$",message = "username should be more 4 letters")
    @Size(min = 4,message = "username should be more 4 letters")
    @Column(columnDefinition = "varchar(15) not null unique")
   private String username;

    @NotEmpty(message = "password should be not null")
    @Column(columnDefinition = "varchar(15) not null ")
   private String password;

    @NotEmpty(message = "email should be not null")
    @Column(columnDefinition = "varchar(25) not null unique")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "invalid email")
   private String email;

    @NotEmpty(message = "role should be not null")
    @Column(columnDefinition = "varchar(25) not null check (role='user' or role ='admin')")
    @Pattern(regexp = "^(user|admin)$",message = "role should be user|admin ")
   private String role;

    @Column(columnDefinition = "int not null")
   @NotNull(message = "age should not empty")
    private int age;
}
