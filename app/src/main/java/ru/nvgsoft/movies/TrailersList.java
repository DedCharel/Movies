package ru.nvgsoft.movies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TrailersList implements Serializable {
    @SerializedName("trailers")
    private List<Trailer> trailerList;

    @Override
    public String toString() {
        return "TrailersList{" +
                "trailerList=" + trailerList +
                '}';
    }

    public List<Trailer> getTrailerList() {
        return trailerList;
    }

    public TrailersList(List<Trailer> trailerList) {
        this.trailerList = trailerList;
    }
}
