package net.wakelesstuna.movie.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.wakelesstuna.movie.entites.File;
import net.wakelesstuna.movie.entites.Movie;
import net.wakelesstuna.movie.repositories.FileRepository;
import net.wakelesstuna.movie.repositories.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepo;
    private final MovieRepository movieRepo;

    @SneakyThrows
    @Transactional
    public String createFile(final MultipartFile file, final String movieId) {
        final Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Could not find movie with id (%s) to connect file to.".formatted(movieId)));

        final File newFile = new File();
        newFile.setName(file.getOriginalFilename());
        newFile.setType(file.getContentType());
        newFile.setContent(file.getBytes());

        final String fileId = fileRepo.saveAndFlush(newFile).getId();
        movie.setImageId(fileId);
        return fileId;
    }

    public File getFile(final String fileId) {
        return fileRepo.findById(fileId)
                .orElseThrow();
    }
}
