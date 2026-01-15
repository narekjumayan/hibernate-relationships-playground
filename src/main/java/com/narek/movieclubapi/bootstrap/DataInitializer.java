package com.narek.movieclubapi.bootstrap;

import com.narek.movieclubapi.entities.*;
import com.narek.movieclubapi.repositories.ClubRepository;
import com.narek.movieclubapi.repositories.MovieRepository;
import com.narek.movieclubapi.repositories.ReviewRepository;
import com.narek.movieclubapi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private UserRepository userRepository;
    private MovieRepository movieRepository;
    private ReviewRepository reviewRepository;
    private ClubRepository clubRepository;

    public DataInitializer(UserRepository userRepository,
                           MovieRepository movieRepository,
                           ReviewRepository reviewRepository,
                           ClubRepository clubRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
        this.clubRepository = clubRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("example@gmail.com");
        UserProfile userProfile = new UserProfile();
        userProfile.setDisplayName("name");
        user.setUserProfile(userProfile);
        userRepository.save(user);
        Movie movie = new Movie();
        movie.setYear(2018);
        movie.setTitle("Avengers: Infinity War");
        Review review = new Review();
        review.setMovie(movie);
        review.setUser(user);
        review.setRating(8);
        review.setComment("comment");
        movieRepository.save(movie);
        reviewRepository.save(review);
        System.out.println(reviewRepository.findById(1L).get());
        Club club = new Club();
        club.setName("Club");
        clubRepository.save(club);
        user.getClubs().add(club);
        userRepository.save(user);
    }
}
