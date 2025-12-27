package com.movieData.movieRatings;

import java.util.List;
import java.util.Optional;
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
    
    //Grabs the movie name
    public List<Movies> getMovieByName(String searchText) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMovie_name().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }


    //Grabs when the movie was made

    public List<Movies> getMovieYear(Integer movieYear) {
        return movieRepository.findAll().stream()
        .filter(movie -> movieYear.equals(movie.getMovie_year()))
        .collect(Collectors.toList());
    }

    //Grabs a movie that matches the given year and the given movie name
    public List<Movies> getMovieByYearandName(Integer movieYear, String searchText) {
        return movieRepository.findAll().stream()
        .filter(movies -> movieYear.equals(movies.getMovie_year()) && searchText.equals(movies.getMovie_name()))
        .collect(Collectors.toList());
    }

    //adds a new movie
    public Movies addMovie(Movies movie) {
        movieRepository.save(movie);
        return movie; // returns the movie so we can see what we saved
    }

    //updates an existing movie
    public Movies updateMovie(Movies updateMovie) {
        Optional<Movies> existingMovies = movieRepository.findByName(updateMovie.getMovie_name());

        if(existingMovies.isPresent()) {
            Movies movieToUpdate = existingMovies.get();
            movieToUpdate.setMovie_name(updateMovie.getMovie_name());
        }

        
    }
}
