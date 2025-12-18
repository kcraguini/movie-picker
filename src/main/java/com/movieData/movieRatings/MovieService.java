package com.movieData.movieRatings;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// What Component does is tell Springboot that this class should be managed by the Spring Container
public class MovieService {
    private final movieRepository movieRepository;

    @Autowired
    public MovieService(movieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movies> getMovies(){
        return movieRepository.findAll();
        //This will return all movies in the database
    }


    //Grabs the rating that I gave the movie
    public List<Movies> getRatingFromMovies(Double ratings) {
        return movieRepository.findAll().stream()
            .filter(movie -> ratings.equals(movie.getMovie_rating()))
            .collect(Collectors.toList());
    }

    //Grabs the movie URI for letterboxd
    public List<Movies> getURIfromMovies(String movie_uri) {
        return movieRepository.findAll().stream()
            .filter(movie -> movie_uri.equals(movie.getMovie_URI()))
            .collect(Collectors.toList());
    }
}
