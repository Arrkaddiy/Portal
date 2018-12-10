package my.web.service;

import my.web.domain.User;
import my.web.domain.Invoice;
import my.web.repos.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public void save(Invoice invoice) {
        invoiceRepo.save(invoice);
    }

    public int userInvoiceOwner (User user) {
        return invoiceRepo.findByUser(user).size();
    }

    public Iterable<Invoice> filter(String filter) {

        if(filter != null && !filter.isEmpty()) {
            return invoiceRepo.findByInvoiceDate(filter);
        } else {
            return invoiceRepo.findAll();
        }
    }

    public Iterable<Invoice> inProgress(User user) {
        return invoiceRepo.findByUserAndProgressTrue(user);
    }
}
