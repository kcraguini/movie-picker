package com.movieData.movieRatings;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movies> getMovies(
        @RequestParam(required = false) Integer movie_id, 
        @RequestParam(required = false) String movie_name,
        @RequestParam(required = false) Integer movie_year,
        @RequestParam(required = false) Double rating) {
            if(movie_id != null) {
                return movieService.getMovieByYearandName(movie_id, movie_name);
            }
            else if(movie_name != null) {
                return movieService.getMovieByName(movie_name);
            }
            else if(movie_year != null) {
                return movieService.getMovieYear(movie_year);
            }
            else if(rating != null) {
                return movieService.getRatingFromMovies(rating);
            }
            else { // Returns all movies when no parameters are given
                return movieService.getMovies();
            }
        }

    @PostMapping
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
        Movies createdMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping
    //Handles put requesting
    public ResponseEntity<Movies> updateMovie(@RequestBody Movies movies) {
        Movies resultMovie = movieService.updateMovie(movies);
        if(resultMovie != null) {
            return new ResponseEntity<>(resultMovie, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{movie_name}")
    public ResponseEntity<String> deleteMovie(@PathVariable String movie_name) {
        movieService.deleteMovie(movie_name);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
        
}
