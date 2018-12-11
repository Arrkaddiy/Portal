package my.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "MEDIATYPE")
public class MediaType {

    /* Уникальный ID Типа */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Row_ID", nullable = false, unique = true)
    private long row_id;

    /* Наименование типа */
    @Column(name = "MediaType_Name", nullable = false, length = 120)
    private String mediaTypeName;

    public MediaType(){

    }

    public MediaType(String mediaTypeName) {
        this.mediaTypeName = mediaTypeName;
    }

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public String getMediaTypeName() {
        return mediaTypeName;
    }

    public void setMediaTypeName(String mediaTypeName) {
        this.mediaTypeName = mediaTypeName;
    }
}
