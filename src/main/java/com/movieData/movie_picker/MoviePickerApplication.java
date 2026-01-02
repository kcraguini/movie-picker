package com.movieData.movie_picker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.movieData.movie_picker", "com.movieData.movieRatings"})
@EnableJpaRepositories(basePackages = "com.movieData.movieRatings")
@EntityScan(basePackages = "com.movieData.movieRatings")
public class MoviePickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviePickerApplication.class, args);
    }

}