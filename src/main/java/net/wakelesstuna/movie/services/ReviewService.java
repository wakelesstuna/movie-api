package net.wakelesstuna.movie.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.wakelesstuna.movie.entites.Movie;
import net.wakelesstuna.movie.entites.Review;
import net.wakelesstuna.movie.entites.requests.CreateReviewRequest;
import net.wakelesstuna.movie.entites.responses.ReviewResponse;
import net.wakelesstuna.movie.repositories.MovieRepository;
import net.wakelesstuna.movie.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final MovieRepository movieRepo;
    private final ReviewRepository reviewRepo;

    @Transactional
    public ReviewResponse createReview(final CreateReviewRequest request) {
        final Movie movie = movieRepo.findById(request.movieId())
                .orElseThrow();
        final Review review = reviewRepo.saveAndFlush(mapNewReview(request));
        movie.addReview(review);
        return mapReviewResponse(review);
    }

    public void deleteReview(final String reviewId) {
        reviewRepo.deleteById(reviewId);
    }

    private ReviewResponse mapReviewResponse(final Review review) {
        return new ReviewResponse(review.getId(), review.getContent(), review.getScore());
    }

    private Review mapNewReview(final CreateReviewRequest request) {
        final Review review = new Review();
        review.setContent(request.content());
        review.setScore(request.rating());
        return review;
    }

}
