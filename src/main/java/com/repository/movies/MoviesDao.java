package com.repository.movies;

import com.model.Movies;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MoviesDao {

    private HashMap<Integer, Movies> moviesMap = new HashMap<Integer, Movies>();
    private static MoviesDao instance;

    public void addMovie(Movies movies) {
        moviesMap.put(movies.getMovieId(), movies);
    }

    public Movies getMovie(int movieID) {
        return moviesMap.getOrDefault(movieID, null);
    }

    public List<Movies> getAllMovies() {
        return moviesMap.values().stream()
                .collect(Collectors.toList());
    }

    private MoviesDao() {

    }

    public static synchronized MoviesDao getInstance() {
        if (instance == null)
            instance = new MoviesDao();
        return instance;
    }

}
