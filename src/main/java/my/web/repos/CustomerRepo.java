package my.web.repos;

import my.web.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findByUsernameIgnoreCase(String username);
    List<Customer> findByUsernameLike(String username);
}
