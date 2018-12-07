package my.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "INCLUDEMAIL")
public class IncludeMail {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(unique = true)
    private long row_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMERFROM_ID")
    private Customer customerFrom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMERTO_ID")
    private Customer customerTo;

    @Column(nullable = false, length = 248)
    private String title;

    @Column(nullable = false, length = 2048)
    private String body;

    @Column(nullable = false)
    private boolean delivered;

    @Column(nullable = false)
    private boolean read;

    public IncludeMail(){

    }

    public IncludeMail(Customer customerFrom, Customer customerTo, String title, String body) {
        this.customerFrom = customerFrom;
        this.customerTo = customerTo;
        this.title = title;
        this.body = body;
        this.delivered = false;
        this.read = false;
    }

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public Customer getCustomerFrom() {
        return customerFrom;
    }

    public void setCustomerFrom(Customer customerFrom) {
        this.customerFrom = customerFrom;
    }

    public Customer getCustomerTo() {
        return customerTo;
    }

    public void setCustomerTo(Customer customerTo) {
        this.customerTo = customerTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getUserNameFrom(){
        return customerFrom != null ? customerFrom.getUsername() : "<none>";
    }

    public String getUserNameTo(){
        return customerTo != null ? customerTo.getUsername() : "<none>";
    }
}
