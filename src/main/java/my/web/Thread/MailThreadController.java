package my.web.Thread;

import my.web.domain.IncludeMail;
import my.web.service.IncludeMailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailThreadController {

    public static IncludeMailService includeMailServiceToMail;

    public MailThreadController(IncludeMailService includeMailService) {

        includeMailServiceToMail = includeMailService;

        MailThread mailThread = new MailThread();
        Thread mail = new Thread(mailThread);
        mail.start();

        System.out.println("[THERAD - MAILTHERAD] Thread is started!");
    }
}

class MailThread implements Runnable {

    @Override
    public void run() {

        boolean activeIncludeMailSender = true;

        while (activeIncludeMailSender) {

            List<IncludeMail> mails = MailThreadController.includeMailServiceToMail.searchMail();

            if (!mails.isEmpty()) {
                for (IncludeMail mail : mails) {
                    mail.setDelivered(true);
                    MailThreadController.includeMailServiceToMail.save(mail);
                }
                System.out.println("[THERAD - MAILTHERAD] Mail search and sender!");
            }

            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

