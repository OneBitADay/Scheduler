package runner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import runner.Execeptions.*;
import runner.model.User;
import runner.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User persistUser(User user) {
        verificationProcess(user);
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(String userid) {
        if(userid == null || userid.isEmpty()) {
            throw new UserProvidedIsNull("user id provided is empty. PLease provide a legit userid.");
        }
        List<User> userRequested = userRepository.findByUserid(userid);
        if(userRequested.isEmpty()) {
            throw new UserNotFound(String.format("User by the id %s is not found. Ensure id is correct or that the user has been created.",userid));
        }

        return userRequested.get(0);
    }

    @Override
    public boolean purgeUser(String userid) {
        if(!checkIfUserIdExists(userid)) {
            throwErrorUserIDNotFound(userid);
        }

        userRepository.deleteByUserid(userid);
        return checkIfUserIdExists(userid);
    }

    @Override
    public boolean updateUserPassword(User user) {
        List<User> tempUser = userRepository.findByUserid(user.getUserid());

        //TODO:TEST CASE -- WRITE A UNIT TEST CASE TO TEST IF TWO PASSWORD, BOTH SAME CHARS BUT DIFFERENT UPPER/LOWER CASE ARE EQUAL
        if(tempUser.get(0).getPassword().equals(user.getPassword())) {
            throw new UserPasswordIdentical("Please provide a new password. This one is in use.");
        }

        user.setId(tempUser.get(0).getId());
        user.setFname(tempUser.get(0).getFname());
        user.setLname(tempUser.get(0).getLname());
        user.setEmail(tempUser.get(0).getEmail());
        user.setDob(tempUser.get(0).getDob());
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean updateUserId(User user) {
        return false;
    }

    @Override
    public boolean updateUserEmail(User user) {
        return false;
    }


    private boolean checkIfUserExists(User User) {
        List<User> tempList = userRepository.findByFnameAndLnameAndEmail(User.getFname(), User.getLname(), User.getEmail());
        return tempList.size() > 0;
    }

    private boolean checkIfUserIdExists(String userId) {
        return userRepository.findByUserid(userId).size() > 0;
    }

    private void throwErrorUserIDNotFound(String userid) {
        throw new UserIdAlreadyExists(String.format("The user id provided %s already exists",userid));

    }
    private void verificationProcess(User user) {
        if(checkIfUserIdExists(user.getUserid())){
            throwErrorUserIDNotFound(user.getUserid());
        }

        if (checkIfUserExists(user)) {
            throw new UserAlreadyExists(String.format("The user by the first name %s, last name %s, with email %s already exists. Please recovery your account.",
                    user.getFname(),user.getLname(),user.getEmail()));
        }
    }
}
