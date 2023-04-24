package net.wakelesstuna.movie.entites.responses;

import net.wakelesstuna.movie.entites.Review;

import java.util.List;

public record MovieResponse(String id, String title, Integer releaseYear, List<Review> reviews) {
}
