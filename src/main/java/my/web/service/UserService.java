package my.web.service;

import my.web.domain.User;
import my.web.domain.Role;
import my.web.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsernameIgnoreCase(username);
    }

    public User loadUserObjByUsername(String username) {
        return userRepo.findByUsernameIgnoreCase(username);
    }

    public boolean addUser(User user) {

        User userFromDb = userRepo.findByUsernameIgnoreCase(user.getUsername());

        if (userFromDb != null) {
            return false;
        }
        user.setActive(true);
        user.setAvatarName("e1b242c7-ed7c-4349-add6-f930ea77da57.def.jpg");
        user.setRoles(Collections.singleton(Role.ADMIN));

        userRepo.save(user);

        return true;
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public List<User> loadUsersAll () {
        return userRepo.findAll();
    }

    public List<User> loadUsersByUsernameLike(String username) {
        return userRepo.findByUsernameLike(username);
    }

}
