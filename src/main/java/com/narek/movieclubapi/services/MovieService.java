package com.narek.movieclubapi.services;

import com.narek.movieclubapi.entities.Movie;
import com.narek.movieclubapi.repositories.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(String title, int year){
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        
        return movieRepository.save(movie);
    }
}
