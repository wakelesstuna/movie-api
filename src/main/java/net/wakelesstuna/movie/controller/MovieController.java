package net.wakelesstuna.movie.controller;

import lombok.RequiredArgsConstructor;
import net.wakelesstuna.movie.entites.Movie;
import net.wakelesstuna.movie.entites.requests.CreateMovieRequest;
import net.wakelesstuna.movie.entites.responses.MovieResponse;
import net.wakelesstuna.movie.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieResponse> getMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponse createMovie(@RequestBody final CreateMovieRequest request) {
        return movieService.createdMovie(request);
    }

}
