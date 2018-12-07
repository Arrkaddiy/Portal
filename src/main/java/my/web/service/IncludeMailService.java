package my.web.service;

import my.web.domain.Customer;
import my.web.domain.IncludeMail;
import my.web.repos.IncludeMailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncludeMailService {
    @Autowired
    private UserService userService;

    private final IncludeMailRepo includeMailRepo;

    public IncludeMailService(IncludeMailRepo includeMailRepo){
        this.includeMailRepo = includeMailRepo;
    }

    public List<IncludeMail> searchMail(){
        return includeMailRepo.findByDeliveredFalse();
    }

    public int myInboxMailTrueNumber(Customer customer){
        return includeMailRepo.findByCustomerToAndDeliveredTrueAndReadFalse(customer).size();
    }
    public List<IncludeMail> myInboxMailTrue(Customer customer){
        return includeMailRepo.findByCustomerToAndDeliveredTrueAndReadFalse(customer);
    }
    public void save(IncludeMail mail) {
        includeMailRepo.save(mail);
    }

    public void sendMessage(String UserNameFrom, String UserNameTo, String Title, String Message) {

        Customer CustomerFrom = userService.loadCustomerByUsername(UserNameFrom);
        Customer CustomerTo = userService.loadCustomerByUsername(UserNameTo);

        IncludeMail mail = new IncludeMail(CustomerFrom, CustomerTo, Title, Message);
        includeMailRepo.save(mail);
    }

}
