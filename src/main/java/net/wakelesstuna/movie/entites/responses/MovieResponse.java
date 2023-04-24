package net.wakelesstuna.movie.entites.responses;

import java.util.List;

public record MovieResponse(String id, String title, Integer releaseYear, String imageId, List<ReviewResponse> reviews) {
}
