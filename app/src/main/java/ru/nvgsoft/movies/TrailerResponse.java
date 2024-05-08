package ru.nvgsoft.movies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TrailerResponse implements Serializable {

    @SerializedName("videos")
    private TrailersList trailersList;

    @Override
    public String toString() {
        return "TrailerResponse{" +
                "trailersList=" + trailersList +
                '}';
    }

    public TrailersList getTrailersList() {
        return trailersList;
    }

    public TrailerResponse(TrailersList trailersList) {
        this.trailersList = trailersList;
    }
}
