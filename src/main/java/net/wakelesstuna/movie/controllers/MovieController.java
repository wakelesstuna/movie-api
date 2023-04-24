package net.wakelesstuna.movie.controllers;

import lombok.RequiredArgsConstructor;
import net.wakelesstuna.movie.entites.requests.CreateMovieRequest;
import net.wakelesstuna.movie.entites.responses.MovieResponse;
import net.wakelesstuna.movie.services.MovieService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    @ResponseStatus(OK)
    public List<MovieResponse> getMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public MovieResponse createMovie(@RequestBody final CreateMovieRequest request) {
        return movieService.createMovie(request);
    }

    @DeleteMapping("/{movieId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteMovie(@PathVariable final String movieId) {
        movieService.deleteMovie(movieId);
    }
}
