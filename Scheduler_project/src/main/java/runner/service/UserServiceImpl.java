package runner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import runner.Execeptions.userExceptions.*;
import runner.model.User;
import runner.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    //TODO:CHECK TO SEE IF EMAIL PROVIDED IS ALREADY IN USE
    public User persistUser(User user) {

        //TODO : might have to implement a rollback feature

        //verificationProcess(user);
        userRepository.save(user);

        return user;
    }

    @Override
    public User getUser(String userid) {
        if(userid == null || userid.isEmpty()) {
            throw new UserProvidedIsNull("user id provided is empty. PLease provide a legit userid.");
        }
        User userRequested = userRepository.findByUserId(userid);
        if(userRequested == null) {
            throw new UserNotFound(String.format("User by the id %s is not found. Ensure id is correct or that the user has been created.",userid));
        }

        return userRequested;
    }

    @Override
    public boolean purgeUser(String userid) {
        if(!checkIfUserIdExists(userid)) {
            throwErrorUserIDNotFound(userid);
        }

        userRepository.deleteByUserId(userid);
        return checkIfUserIdExists(userid);
    }

    @Override
    public boolean purgeUserByUuid(UUID uuid) {

        userRepository.deleteByUseruuid(uuid);
        return userRepository.findByUseruuid(uuid) == null;
    }

    @Override
    public boolean updateUserPassword(User user) {
        User userHolder = userRepository.findByUserId(user.getUserId());

        //TODO:TEST CASE -- WRITE A UNIT TEST CASE TO TEST IF TWO PASSWORD, BOTH SAME CHARS BUT DIFFERENT UPPER/LOWER CASE ARE EQUAL
        if(userHolder.getPassword().equals(user.getPassword())) {
            throw new UserPasswordIdentical("Please provide a new password. This one is in use.");
        }

        user.setUseruuid(userHolder.getUseruuid());
        user.setFirstName(userHolder.getFirstName());
        user.setLastName(userHolder.getLastName());
        user.setEmail(userHolder.getEmail());
        //user.setDateOfBirth(userHolder.getDateOfBirth());
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
        List<User> tempList = userRepository.findByFirstNameAndLastNameAndEmail(
                User.getFirstName(), User.getLastName(), User.getEmail());
        return tempList.size() > 0;
    }

    private boolean checkIfUserIdExists(String userId) {
        return userRepository.findByUserId(userId) != null;
    }

    private void throwErrorUserIDNotFound(String userId) {
        throw new UserIdAlreadyExists(String.format("The user id provided %s already exists",userId));

    }
    private void verificationProcess(User user) {
        if(checkIfUserIdExists(user.getUserId())){
            throwErrorUserIDNotFound(user.getUserId());
        }

        if (checkIfUserExists(user)) {
            throw new UserAlreadyExists(String.format("The user by the first name %s, last name %s, with email %s already exists. Please recovery your account.",
                    user.getFirstName(),user.getLastName(),user.getEmail()));
        }
    }
}
