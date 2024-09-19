package runner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import runner.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFnameAndLnameAndEmail(String fname, String lname, String email);

    List<User> findByUserid(String userid);

    @Transactional
    void deleteByUserid(String userid);


}
