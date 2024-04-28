package ru.nvgsoft.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    private List<Movie> movies;

    @SerializedName("docs")
    public List<Movie> getMovies() {
        return movies;
    }

    public MovieResponse(List<Movie> movies) {
        this.movies = movies;
    }
}
