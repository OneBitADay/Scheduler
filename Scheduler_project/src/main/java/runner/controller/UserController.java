package runner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import runner.model.User;
import runner.response.UserResponse;
import runner.service.UserService;

import java.util.UUID;

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


    @GetMapping(value = "/user/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseBody
    public ResponseEntity<User> getUser(@PathVariable String userid) {
        User user = userService.getUser(userid);
        UserResponse response =  UserResponse.Builder.newInstance()
                           .setUserId(userid)
                           .setFirstName(user.getFirstName())
                           .setLastName(user.getLastName())
                           .build();
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/user/{userid}")
    public ResponseEntity<Boolean> removeUser(@PathVariable String userid) {
        return new ResponseEntity<>(userService.purgeUser(userid), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/user/uuid/{uuid}")
    public ResponseEntity<Boolean> removeUserViaUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(userService.purgeUserByUuid(uuid), HttpStatus.ACCEPTED);

    }

    @PutMapping("/user")
    public ResponseEntity<Boolean> updateUserCredentials(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUserPassword(user), HttpStatus.ACCEPTED);
    }


    @PostMapping(value = "/user")
    public ResponseEntity<Boolean> persistUser(@RequestBody User user) {
        userService.persistUser(user);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}
