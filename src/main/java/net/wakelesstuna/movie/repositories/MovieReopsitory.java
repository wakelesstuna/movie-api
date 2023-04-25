package net.wakelesstuna.movie.repositories;

import net.wakelesstuna.movie.entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieReopsitory extends JpaRepository<Movie, String> {

    List<Movie> findAllByReleaseYear(Integer year);
}
