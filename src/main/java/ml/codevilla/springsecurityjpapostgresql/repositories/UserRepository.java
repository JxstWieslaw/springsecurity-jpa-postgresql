package ml.codevilla.springsecurityjpapostgresql.repositories;

import ml.codevilla.springsecurityjpapostgresql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    //create a definition and JPA provides an implementation on its own.
    //Clues/Hints given to JPA to provide implementation:
    // a. method which FINDS a USER by USERNAME hence findUserByUserName(receives a userName)
    // b. gives a USER object.
    // c. object container OPTIONAL means it can be null or not. Populated or not

    Optional<User> findUserByUserName(String userName);
}
