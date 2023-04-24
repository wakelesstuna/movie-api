package net.wakelesstuna.movie.controllers;

import lombok.RequiredArgsConstructor;
import net.wakelesstuna.movie.entites.requests.CreateReviewRequest;
import net.wakelesstuna.movie.entites.responses.ReviewResponse;
import net.wakelesstuna.movie.services.ReviewService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ReviewResponse createReview(@RequestBody final CreateReviewRequest request) {
        return reviewService.createReview(request);
    }

    @DeleteMapping("/{reviewId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteReview(@PathVariable final String reviewId) {
        reviewService.deleteReview(reviewId);
    }

}
