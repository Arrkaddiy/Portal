package my.web.service;

import my.web.domain.IncludeMail;
import my.web.repos.IncludeMailRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncludeMailService {

    private final IncludeMailRepo includeMailRepo;

    public IncludeMailService(IncludeMailRepo includeMailRepo){
        this.includeMailRepo = includeMailRepo;
    }

    public List<IncludeMail> searchMail(){
        return includeMailRepo.findByDeliveredFalse();
    }

    public void save(IncludeMail mail) {
        includeMailRepo.save(mail);
    }

}
