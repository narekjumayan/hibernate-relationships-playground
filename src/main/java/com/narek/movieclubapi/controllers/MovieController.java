package com.narek.movieclubapi.controllers;

import com.narek.movieclubapi.dtos.CreateMovieRequest;
import com.narek.movieclubapi.entities.Movie;
import com.narek.movieclubapi.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody CreateMovieRequest createMovieRequest) {
        Movie movie = movieService.createMovie(createMovieRequest.getTitle(), createMovieRequest.getYear());
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

}
