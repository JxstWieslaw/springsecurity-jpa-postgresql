package ml.codevilla.springsecurityjpapostgresql;
//JPA has an entity class
//A repository interface
//Have a method which looks upa user form the database given the username.

import ml.codevilla.springsecurityjpapostgresql.models.MyUserDetails;
import ml.codevilla.springsecurityjpapostgresql.models.User;
import ml.codevilla.springsecurityjpapostgresql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired//inject instance of userRepository.
    UserRepository userRepository;

    @Override //JPA API  has to be called by giving an id to find the UserName.
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //return an instance of UserDetails
        //
        Optional<User> user = userRepository.findUserByUserName(userName);
        user.orElseThrow(()->new UsernameNotFoundException("Not found: "+userName));
        return user.map(MyUserDetails::new).get();
    }
}
