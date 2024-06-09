package dev.waliamaheep.Runnerz.User;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository userRepository;

   public UserController(UserRepository userRepository ){
       this.userRepository = userRepository;
   }
    @GetMapping("")
    List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{Id}")
    User getUser(@PathVariable Integer Id){
        Optional<User> user = userRepository.findById(Id);
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return user.get();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void addUser(@RequestBody User user){
       userRepository.Create(user);
    }

    @PutMapping("/{Id}")
    void changeUser(@RequestBody User user,@PathVariable Integer Id){
        userRepository.update(Id,user);
    }
    @DeleteMapping("/{Id}")
    void deleteUser(@PathVariable Integer Id){
       userRepository.delete(Id);
    }


}
