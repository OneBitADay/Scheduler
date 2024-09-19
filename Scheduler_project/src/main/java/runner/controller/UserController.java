package runner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import runner.model.User;
import runner.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {


    //TODO : CREATE A RESPONSE BODY TO BE SENT BACK WITH RESPONSE ENTITY https://www.baeldung.com/spring-response-entity

    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<String> entry() {
        return new ResponseEntity<>("Welcome to SpringAPI", HttpStatus.ACCEPTED);
    }


    @GetMapping("/user/{userid}")
    public ResponseEntity<User> getUser(@PathVariable String userid) {
        return new ResponseEntity<>(userService.getUser(userid), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/user/{userid}")
    public ResponseEntity<Boolean> removeUser(@PathVariable String userid) {
        return new ResponseEntity<>(userService.purgeUser(userid), HttpStatus.ACCEPTED);
    }

    @PutMapping("/user")
    public ResponseEntity<Boolean> updateUserCredentials(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUserPassword(user), HttpStatus.ACCEPTED);
    }


    @PostMapping("/user")
    public ResponseEntity<User> persistUser(@RequestBody User user) {
        User tempPerson =  userService.persistUser(new User(
                user.getFname(),
                user.getLname(),
                user.getEmail(),
                user.getUserid(),
                user.getDobHolder(),
                user.getPassword()
        ));
        return new ResponseEntity<>(tempPerson, HttpStatus.CREATED);
    }
}
