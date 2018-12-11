package my.web.domain;

import javax.persistence.*;

@Entity
@Table(name = "GENRE")
public class Genre {

    /* Уникальный ID жанра */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Row_ID", nullable = false, unique = true)
    private long row_id;

    /* Наименование жанра */
    @Column(name = "Genre_Name", nullable = false, length = 120)
    private String genreName;

    public Genre() {

    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public long getRow_id() {
        return row_id;
    }

    public void setRow_id(long row_id) {
        this.row_id = row_id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
