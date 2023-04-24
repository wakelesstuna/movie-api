package net.wakelesstuna.movie.repositories;

import net.wakelesstuna.movie.entites.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
