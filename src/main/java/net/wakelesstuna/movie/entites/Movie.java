package net.wakelesstuna.movie.entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@Getter
@Setter
@GenericGenerator(name = "UUID", strategy = "uuid2")
public class Movie {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    private String title;
    private String releaseYear;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private Instant updated;
}
