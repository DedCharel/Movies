package ru.nvgsoft.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @GET("movie?rating.kp=7-10&sortField=votes.kp&sortType=-1&page=2&limit=2")
    @Headers("X-API-KEY:")
    Single<MovieResponse> loadMovies();
}
