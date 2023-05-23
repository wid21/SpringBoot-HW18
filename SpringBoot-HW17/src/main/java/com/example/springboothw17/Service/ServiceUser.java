package com.example.springboothw17.Service;

import com.example.springboothw17.ApiException.ApiException;
import com.example.springboothw17.Model.User;
import com.example.springboothw17.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUser {
    private final RepositoryUser repositoryUser;

    public List<User> getAllUsers(){
      return repositoryUser.findAll();
    }

    public void addUsersd(User user ){
       repositoryUser.save(user);
    }

    public boolean updateUser(Integer id , User user){
     User old = repositoryUser.findUserById(id);
     if (old ==null){
         return false;
     }
     old.setName(user.getName());
     old.setAge(user.getAge());
     old.setUsername(user.getUsername());
     old.setEmail(user.getEmail());
     old.setPassword(user.getPassword());
     old.setRole(user.getRole());
     repositoryUser.save(old);
     return true;
    }

    public boolean deleteUser(Integer id){
        User old = repositoryUser.findUserById(id);
        if (old ==null){
            return false;
        }
        repositoryUser.delete(old);
        return true;
    }

    public User getuserbyemail(String email ){
        User e = repositoryUser.findUserByEmail(email);

        if(e==null){
            throw new ApiException("not found");
        }

        return e;
    }

    public List<User> getuserrole(String role){
        List<User>list=repositoryUser.getuserbyrole(role);
        if(list==null){
            throw new ApiException("not found");
        }
        return list;
    }

    public List<User> getuserage(int age){
        List<User>list=repositoryUser.getuserbyage(age);
        if(list==null){
            throw new ApiException("not found");
        }
        return list;
    }

    public User getUserAndPass(String username , String password){
        User u = repositoryUser.findUserByUsernameAndPassword(username,password);
        if(u==null){
                throw new ApiException("not found");
        }
        return u;
    }

    }

