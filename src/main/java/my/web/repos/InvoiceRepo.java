package my.web.repos;

import my.web.domain.User;
import my.web.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {

    List<Invoice> findByUser (User user);
    List<Invoice> findByUserAndProgressTrue (User user);
    List<Invoice> findByInvoiceDate (String invoice_date);

}
