package com.example.springboothw17.Controller;

import com.example.springboothw17.Model.User;
import com.example.springboothw17.Service.ServiceUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class ControllerUser {

    private final ServiceUser serviceUser;

    @GetMapping("/get")

    public ResponseEntity getUsers(){
        List<User> userList=serviceUser.getAllUsers();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUsers( @Valid @RequestBody User user , Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        serviceUser.addUsersd(user);
        return ResponseEntity.status(HttpStatus.OK).body("user added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers( @PathVariable Integer id ,@Valid @RequestBody User user , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated = serviceUser.updateUser(id,user);
        if(isUpdated){
            return ResponseEntity.status(200).body("user updated");
        }
        return ResponseEntity.status(400).body("wrong id ");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){

        boolean isdeleted = serviceUser.deleteUser(id);
        if(isdeleted){
            return ResponseEntity.status(200).body("user deleted");
        }
        return ResponseEntity.status(400).body("wrong id ");
    }


    @GetMapping("/getemail/{email}")
     public ResponseEntity getemail(@PathVariable String email){
       User e = serviceUser.getuserbyemail(email);
       return ResponseEntity.status(200).body(e);
    }

    @GetMapping("/getrole/{role}")
    public ResponseEntity getuserrole(@PathVariable  String role){
      List<User>userList=serviceUser.getuserrole(role);
      return ResponseEntity.status(200).body(userList);
    }

    @GetMapping("/getage/{age}")
    public ResponseEntity getuserage(@PathVariable int age){
        List<User>userList=serviceUser.getuserage(age);
        return ResponseEntity.status(200).body(userList);
    }

    @GetMapping("/getup/{username}/{password}")
    public ResponseEntity getuserpassword(@PathVariable String username , @PathVariable String password){
        User p =serviceUser.getUserAndPass(username , password);
        return ResponseEntity.status(200).body(p);
    }



    }


