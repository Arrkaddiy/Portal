package my.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "INVOICEITEMS")
public class InvoiceItem {

    /* Уникальный ID элемента счета */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Row_ID", nullable = false, unique = true)
    private long row_id;

    /* Уникальный ID счета */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Invoice_ID", nullable = false)
    private Invoice invoice;

/*    *//* Уникальный ID записи *//*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Track_ID", nullable = false)
    private Track track;*/

    @Column(name = "UnitPrice", nullable = false, length = 40)
    private long unitPrice;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

/*    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }*/

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
