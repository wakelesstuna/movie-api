package net.wakelesstuna.movie.repositories;

import net.wakelesstuna.movie.entites.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
