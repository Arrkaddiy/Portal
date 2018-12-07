package my.web.service;

import my.web.domain.Customer;
import my.web.domain.Role;
import my.web.repos.CustomerRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final CustomerRepo customerRepo;
    public UserService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepo.findByUsernameIgnoreCase(username);
    }

    public boolean addUser(Customer customer) {

        Customer customerFromDb = customerRepo.findByUsernameIgnoreCase(customer.getUsername());

        if (customerFromDb != null) {
            return false;
        }
        customer.setActive(true);
        customer.setAvatarname("e1b242c7-ed7c-4349-add6-f930ea77da57.def.jpg");
        customer.setRoles(Collections.singleton(Role.USER));

        customerRepo.save(customer);

        return true;
    }


}
