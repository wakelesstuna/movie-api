package net.wakelesstuna.movie.controllers;

import lombok.RequiredArgsConstructor;
import net.wakelesstuna.movie.entites.File;
import net.wakelesstuna.movie.services.FileService;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v1/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping(value = "/{fileId}")
    public ResponseEntity<byte[]> getFile(@PathVariable final String fileId) {
        final File file = fileService.getFile(fileId);
        final HttpHeaders headers = buildFileHeaders(file);
        return ResponseEntity.ok()
                .headers(headers)
                .body(file.getContent());
    }

    @PostMapping
    public ResponseEntity<Void> createFile(@RequestParam final MultipartFile file,
                                           @RequestParam final String movieId) throws URISyntaxException {
        final String fileId = fileService.createFile(file, movieId);
        return ResponseEntity.created(new URI("/v1/files/%s".formatted(fileId))).build();
    }

    private static HttpHeaders buildFileHeaders(final File file) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename(file.getName())
                        .build());
        headers.setContentType(MediaType.parseMediaType(file.getType()));
        headers.setContentLength(file.getContent().length);
        return headers;
    }

}
