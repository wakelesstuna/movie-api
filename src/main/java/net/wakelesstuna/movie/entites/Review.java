package net.wakelesstuna.movie.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@NoArgsConstructor
@Getter
@Setter
@GenericGenerator(name = "UUID", strategy = "uuid2")
public class Review {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    private String content;
    private Integer score;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private Instant updated;
}
