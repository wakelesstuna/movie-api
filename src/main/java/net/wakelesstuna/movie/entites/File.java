package net.wakelesstuna.movie.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "files")
@NoArgsConstructor
@Getter
@GenericGenerator(name = "UUID", strategy = "uuid2")
public class File {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    @Setter
    private String name;
    @Setter
    private String type;
    @Lob
    @Setter
    private byte[] content;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private Instant updated;
}
