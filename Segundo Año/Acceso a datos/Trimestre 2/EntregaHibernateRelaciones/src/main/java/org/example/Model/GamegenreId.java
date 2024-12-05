package org.example.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class GamegenreId implements Serializable {
    private static final long serialVersionUID = -6251231634296359737L;
    @Column(name = "game_id", nullable = false)
    private Integer gameId;

    @Column(name = "genre_id", nullable = false)
    private Integer genreId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GamegenreId entity = (GamegenreId) o;
        return Objects.equals(this.gameId, entity.gameId) &&
                Objects.equals(this.genreId, entity.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, genreId);
    }

}