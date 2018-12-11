package my.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "TRACK")
public class Track {

    /* Уникальный ID трэка */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Row_ID", nullable = false, unique = true)
    private long row_id;

    /* Наименование трэка */
    @Column(name = "Track_Name", nullable = false, length = 70)
    private String trackName;

    /* Уникальный ID альбома */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Album_ID")
    private Album album;

    /* Уникальный ID типа */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Media_Type_ID")
    private MediaType mediaType;

    /* Уникальный ID жанра */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Genre_ID")
    private Genre genre;

    /* Автор*/
    @Column(name = "Composer", length = 220)
    private String composer;

    @Column(name = "UnitPrice", nullable = false, length = 40)
    private long unitPrice;

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
