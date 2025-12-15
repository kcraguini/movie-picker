package com.movieData.movieRatings;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ratings")
public class rating {
    private Date movie_date;
    private String movie_name;
    private Integer movie_year;
    private String movie_uri;
    private Double rating;
}
