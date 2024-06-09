package dev.waliamaheep.Runnerz.User;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    List<User> findAll(){
        return users;
    }
    Optional<User> findById(Integer Id){
        return users.stream().filter(user -> user.Id()==Id).findFirst();
    }
    @PostConstruct
    private void init(){
        users.add(new User(1,"Maheep"));
        users.add(new User(2,"Kashish"));
    }

    void Create(User user){
        users.add(user);
    }

    void update(Integer Id, User user){
        Optional<User> existingUser = findById(Id);
        if(!existingUser.isEmpty()){
            users.set(users.indexOf(existingUser.get()),user );
        }
    }
    void delete(Integer Id){
        users.removeIf(run->run.Id().equals(Id));
    }

}
