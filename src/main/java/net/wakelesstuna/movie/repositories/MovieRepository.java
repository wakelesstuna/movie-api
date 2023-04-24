package net.wakelesstuna.movie.repositories;

import net.wakelesstuna.movie.entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
