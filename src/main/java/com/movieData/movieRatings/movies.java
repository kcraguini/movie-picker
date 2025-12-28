package com.movieData.movieRatings;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ratings")
public class Movies 
{
    @Id
    //@Column(movie_id = "movie_id", unique = true) // Might need to rework this later
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    
    private Integer movie_id;
    private Date movie_date;
    private String movie_name;
    private Integer movie_year;
    private String movie_uri;
    private Double rating;

    public Movies(Integer movie_id)
    {
        this.movie_id = movie_id;
    }

    public Movies(Date movie_date, String movie_name, Integer movie_year, String movie_uri, Double rating) 
    {
        this.movie_date = movie_date;
        this.movie_name = movie_name;
        this.movie_year = movie_year;
        this.movie_uri = movie_uri;
        this.rating = rating;
    }

    public Movies()
    {

    }

    public Integer getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }
    public Date getMovie_date() {
        return movie_date;
    }
    public void setMovie_date(Date movie_date) {
        this.movie_date = movie_date;   
    }
    public String getMovie_name() {
        return movie_name;
    }
    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }
    public Integer getMovie_year(){
        return movie_year;
    }
    public void setMovie_year(Integer movie_year) {
        this.movie_year = movie_year;
    }
    public String getMovie_URI(){
        return movie_uri;
    }
    public void setMovie_URI(String movie_uri) {
        this.movie_uri = movie_uri;
    }
    public Double getMovie_rating(){
        return rating;
    }
    public void setMovie_rating(Double rating) {
        this.rating = rating;
    }
}


