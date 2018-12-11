package my.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "ALBUM")
public class Album {

    /* Уникальный ID альбома */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Row_ID", nullable = false, unique = true)
    private long row_id;

    /* Наименование альбома */
    @Column(name = "Album_Name", nullable = false, length = 160)
    private String albumName;

    /* Уникальный ID испонителя */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Artist_ID")
    private Artist artist;

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
