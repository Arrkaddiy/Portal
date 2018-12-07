package my.web.repos;

import my.web.domain.Customer;
import my.web.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
    List<Invoice> findByCustomer (Customer customer);
    List<Invoice> findByCustomerAndProgressTrue (Customer customer);
    List<Invoice> findByInvoicedate (String invoice_date);


}
