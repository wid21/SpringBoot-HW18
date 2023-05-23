package com.example.springboothw17.Repository;

import com.example.springboothw17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUser extends JpaRepository<User,Integer> {

    User findUserById(Integer id);

    User findUserByEmail (String email);

    @Query("select e from User e where e.role=?1")
    List<User> getuserbyrole(String role);

    @Query("select a from User a where a.age >= ?1")
    List<User> getuserbyage (int age);

    User findUserByUsernameAndPassword(String username , String password);


}
