package my.web.service;

import my.web.domain.Customer;
import my.web.domain.Invoice;
import my.web.repos.InvoiceRepo;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private final InvoiceRepo invoiceRepo;
    public InvoiceService(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    public void save(Invoice invoice) {
        invoiceRepo.save(invoice);
    }

    public int customerInvoiceOwner (Customer customer) {
        return invoiceRepo.findByCustomerAndProgressTrue(customer).size();
    }

    public Iterable<Invoice> filter(String filter) {

        if(filter != null && !filter.isEmpty()) {
            return invoiceRepo.findByInvoicedate(filter);
        } else {
            return invoiceRepo.findAll();
        }
    }

    public Iterable<Invoice> inProgress(Customer customer) {
        return invoiceRepo.findByCustomerAndProgressTrue(customer);
    }
}
