package net.wakelesstuna.movie.services;

import lombok.RequiredArgsConstructor;
import net.wakelesstuna.movie.entites.Movie;
import net.wakelesstuna.movie.entites.requests.CreateMovieRequest;
import net.wakelesstuna.movie.entites.responses.MovieResponse;
import net.wakelesstuna.movie.repositories.MovieReopsitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieReopsitory movieRepo;

    public List<MovieResponse> getAllMovies() {
        return movieRepo.findAll().stream()
                .map(this::mapMovieResponse)
                .toList();
    }

    public MovieResponse createdMovie(final CreateMovieRequest request) {
        final Movie newMovie = new Movie();
        newMovie.setTitle(request.title());
        newMovie.setReleaseYear(request.releaseYear());
        return mapMovieResponse(movieRepo.save(newMovie));
    }

    private MovieResponse mapMovieResponse(final Movie movie) {
        return new MovieResponse(movie.getId(), movie.getTitle(), movie.getReleaseYear());
    }
}
