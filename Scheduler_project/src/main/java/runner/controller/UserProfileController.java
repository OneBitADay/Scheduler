package runner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import runner.model.UserProfile;

@RestController
@RequestMapping("/api")
public class UserProfileController {


//    @Autowired
//    UserProfileRepository userProfileRepository;
//
//    @PostMapping(name = "/userprofile")
//    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
//        UserProfile up = userProfileRepository.persistUserProfile(new UserProfile(userProfile.get))
//        return null;
//    }
}
