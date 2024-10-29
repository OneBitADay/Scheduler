package runner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import runner.model.User;


import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByFirstNameAndLastNameAndEmail(String firstName, String LastName, String email);

    //List<User> findByUserId(String userId);

    User findByUserId(String userId);
    User findByUseruuid(UUID useruuid);

    @Transactional
    void deleteByUserId(String userId);

    @Transactional
    void deleteByUseruuid(UUID useruuid);

}
