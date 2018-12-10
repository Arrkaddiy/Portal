package my.web.domain;

import javax.persistence.*;

/**
 * Внутреная Почта
 */
@Entity
@Table(name = "IncludeMAIL")
public class IncludeMail {

    /* Уникальный ID внетреннего сообщения */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(unique = true)
    private long row_id;

    /* Пользователь отправитель */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserFROM_ID")
    private User userFrom;

    /* Пользователь адрессат */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserTO_ID")
    private User userTo;

    /* Заголовок сообщения */
    @Column(nullable = false, length = 248)
    private String title;

    /* Тело сообщения */
    @Column(nullable = false, length = 2048)
    private String body;

    /* Флаг доставки сообщения */
    @Column(nullable = false)
    private boolean delivered;

    /* Флаг прочтения сообщения */
    @Column(nullable = false)
    private boolean read;

    public IncludeMail(){

    }

    public IncludeMail(User userFrom, User userTo, String title, String body) {
        this.userFrom = userFrom;
        this.userTo = userTo;
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

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
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
        return userFrom != null ? userFrom.getUsername() : "<none>";
    }

    public String getUserNameTo(){
        return userTo != null ? userTo.getUsername() : "<none>";
    }
}
