package ru.nvgsoft.movies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TrailersList implements Serializable {
    @SerializedName("trailers")
    private List<Trailer> trailers;

    @Override
    public String toString() {
        return "TrailersList{" +
                "trailerList=" + trailers +
                '}';
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public TrailersList(List<Trailer> trailerList) {
        this.trailers = trailerList;
    }
}
