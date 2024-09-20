package runner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import runner.model.UserProfile;
import runner.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public UserProfile persistUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
}
