package com.movieData.movieRatings;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movieRepository extends JpaRepository<Movies, String> {
    void deleteByMovieId(Integer movie_id);
    Optional<Movies> findByInteger(Integer movie_id);

}
