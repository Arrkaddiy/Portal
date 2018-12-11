package my.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "ARTIST")
public class Artist {

    /* Уникальный ID испонителя */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Row_ID", nullable = false, unique = true)
    private long row_id;

    /* Наименование исполнителя */
    @Column(name = "Artist_Name", nullable = false, length = 120)
    private String artistName;

    public Artist() {

    }

    public Artist(String artistName) {
        this.artistName = artistName;
    }

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
