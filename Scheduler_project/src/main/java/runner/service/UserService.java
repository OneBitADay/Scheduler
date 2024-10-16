package runner.service;

import runner.model.User;

import java.util.UUID;

public interface UserService {
     User persistUser(User user);
     User getUser(String userid);

     boolean purgeUser(String userid);
     boolean purgeUserByUuid(UUID uuid);

     boolean updateUserPassword(User user);

     boolean updateUserId(User user);

     boolean updateUserEmail(User user);
}
