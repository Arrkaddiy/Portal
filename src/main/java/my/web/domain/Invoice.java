package my.web.domain;

import javax.persistence.*;

/**
 * Список счетов
 */
@Entity
@Table(name = "INVOICES")
public class Invoice {

    /* Уникальный ID счета */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ROW_ID", nullable = false, unique = true)
    private long row_id;

    /* Уникальный ID владельца счета */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    /* Наименование счета */
    @Column(name = "INVOICE_NAME", nullable = false, length = 70)
    private String invoiceName;

    /* Дата создания счета */
    @Column(name = "INVOICE_DATE", nullable = false, length = 20)
    private String invoiceDate;

    /* Адрес доставки */
    @Column(name = "BILLING_ADDRESS", nullable = false, length = 70)
    private String billingAddress;

    /* Город доставки */
    @Column(name = "BILLING_CITY", nullable = false, length = 40)
    private String billingCity;

    /* Страна доставки */
    @Column(name = "BILLING_COUNTRY", nullable = false, length = 40)
    private String billingCountry;

    /* Общая сумма счета */
    @Column(name = "TOTAL", length = 40)
    private long total;

    /* Флаг выполнения счета */
    @Column(name = "DONE")
    private boolean done;

    /* Флаг активности счета */
    @Column(name = "Progress")
    private boolean progress;

    public Invoice() {
    }

    public Invoice(String invoiceDate, String billingAddress, User user) {
        this.user = user;
        this.invoiceDate = invoiceDate;
        this.billingAddress = billingAddress;
    }

    public String getUserName(){
        return user != null ? user.getUsername() : "<none>";
    }

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingcity) {
        this.billingCity = billingCity;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
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

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }
}
