package runner.service;

import runner.model.UserProfile;

public interface UserProfileService {
    UserProfile persistUserProfile(UserProfile userProfile);
}
