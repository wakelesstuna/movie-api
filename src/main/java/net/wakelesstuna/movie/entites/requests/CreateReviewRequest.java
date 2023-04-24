package net.wakelesstuna.movie.entites.requests;

public record CreateReviewRequest(String content, Integer rating, String movieId) {
}
