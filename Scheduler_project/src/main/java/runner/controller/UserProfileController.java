package runner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import runner.model.UserProfile;
import runner.repository.UserProfileRepository;
import runner.service.UserProfileService;

@RestController
@RequestMapping("/api")
public class UserProfileController {

//https://stackoverflow.com/questions/37439814/how-to-use-secondarytable-with-crudrepository
    @Autowired
    UserProfileService userProfileService;

    @PostMapping(value = "/userprofile")
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile up = userProfileService.persistUserProfile(new UserProfile(userProfile.getDesc()));

        return new ResponseEntity<>(up, HttpStatus.CREATED);
    }
}
