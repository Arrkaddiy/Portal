package my.web.service;

import my.web.domain.IncludeMail;
import my.web.domain.User;
import my.web.repos.IncludeMailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncludeMailService {

    @Autowired
    private UserService userService;
    @Autowired
    private IncludeMailRepo includeMailRepo;

    public List<IncludeMail> searchMail(){
        return includeMailRepo.findByDeliveredFalse();
    }

    public int myInboxMailTrueNumber(User user){
        return includeMailRepo.findByUserToAndDeliveredTrueAndReadFalse(user).size();
    }

    public List<IncludeMail> myInboxMail(User user){
        return includeMailRepo.findByUserToAndDeliveredTrue(user);
    }

    public List<IncludeMail> myOutputMail(User user) {
        return includeMailRepo.findByUserFrom(user);
    }

    public void save(IncludeMail mail) {
        includeMailRepo.save(mail);
    }

    public void sendMessage(String UserNameFrom, String UserNameTo, String Title, String Message) {

        User userFrom = userService.loadUserObjByUsername(UserNameFrom);
        User userTo = userService.loadUserObjByUsername(UserNameTo);

        IncludeMail mail = new IncludeMail(userFrom, userTo, Title, Message);
        includeMailRepo.save(mail);
    }

}
