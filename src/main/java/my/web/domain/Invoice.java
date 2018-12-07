package my.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "INVOICES")
public class Invoice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ROW_ID", nullable = false, unique = true)
    private long row_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "INVOICE_NAME", nullable = false, length = 70)
    private String invoicename;

    @Column(name = "INVOICE_DATE", nullable = false, length = 20)
    private String invoicedate;

    @Column(name = "BILLING_ADDRESS", nullable = false, length = 70)
    private String billingaddress;

    @Column(name = "BILLING_CITY", nullable = false, length = 40)
    private String billingcity;

    @Column(name = "BILLING_COUNTRY", nullable = false, length = 40)
    private String billingcountry;

    @Column(name = "TOTAL", length = 40)
    private long total;

    @Column(name = "DONE")
    private boolean done;

    @Column(name = "Progress")
    private boolean progress;

    public Invoice() {
    }

    public Invoice(String invoice_date, String billing_address, Customer customer) {
        this.customer = customer;
        this.invoicedate = invoice_date;
        this.billingaddress = billing_address;
    }

    public String getUserName(){
        return customer != null ? customer.getUsername() : "<none>";
    }

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getInvoice_date() {
        return invoicedate;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoicedate = invoice_date;
    }

    public String getBilling_address() {
        return billingaddress;
    }

    public void setBilling_address(String billing_address) {
        this.billingaddress = billing_address;
    }

    public String getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(String invoicedate) {
        this.invoicedate = invoicedate;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public String getBillingcity() {
        return billingcity;
    }

    public void setBillingcity(String billingcity) {
        this.billingcity = billingcity;
    }

    public String getBillingcountry() {
        return billingcountry;
    }

    public void setBillingcountry(String billingcountry) {
        this.billingcountry = billingcountry;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public String getInvoicename() {
        return invoicename;
    }

    public void setInvoicename(String invoicename) {
        this.invoicename = invoicename;
    }
}
