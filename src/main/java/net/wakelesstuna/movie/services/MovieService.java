package net.wakelesstuna.movie.services;

import lombok.RequiredArgsConstructor;
import net.wakelesstuna.movie.entites.Movie;
import net.wakelesstuna.movie.entites.Review;
import net.wakelesstuna.movie.entites.requests.CreateMovieRequest;
import net.wakelesstuna.movie.entites.responses.MovieResponse;
import net.wakelesstuna.movie.entites.responses.ReviewResponse;
import net.wakelesstuna.movie.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepo;

    public List<MovieResponse> getAllMovies() {
        return movieRepo.findAll().stream()
                .map(this::mapMovieResponse)
                .toList();
    }

    public MovieResponse createMovie(final CreateMovieRequest request) {
        final Movie newMovie = movieRepo.save(mapNewMovie(request));
        return mapMovieResponse(newMovie);
    }

    public void deleteMovie(final String movieId) {
        movieRepo.deleteById(movieId);
    }

    private Movie mapNewMovie(final CreateMovieRequest request) {
        final Movie movie = new Movie();
        movie.setTitle(request.title());
        movie.setReleaseYear(request.releaseYear());
        return movie;
    }

    private MovieResponse mapMovieResponse(final Movie movie) {
        return new MovieResponse(movie.getId(), movie.getTitle(), movie.getReleaseYear(), movie.getReviews().stream().map(this::mapReviewResponse).toList());
    }

    private ReviewResponse mapReviewResponse(final Review review) {
        return new ReviewResponse(review.getId(), review.getContent(), review.getScore());
    }
}
