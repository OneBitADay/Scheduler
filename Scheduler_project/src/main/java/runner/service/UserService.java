package runner.service;

import runner.model.User;

public interface UserService {
     User persistUser(User user);
     User getUser(String userid);

     boolean purgeUser(String userid);

     boolean updateUserPassword(User user);

     boolean updateUserId(User user);

     boolean updateUserEmail(User user);
}
