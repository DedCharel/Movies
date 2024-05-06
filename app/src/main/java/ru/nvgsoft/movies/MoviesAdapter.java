package ru.nvgsoft.movies;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies = new ArrayList<>();
    private OnReachEndListener onReachEndListener;

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_item,
                parent,
                false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder viewHolder, int position) {
        Movie movie = movies.get(position);
        Glide.with(viewHolder.itemView)
                .load(movie.getPoster().getUrl())
                .into(viewHolder.imageViewPoster);
        double rating = movie.getRating().getKp();
        int backgroundId;
        if (rating > 7) {
            backgroundId =R.drawable.circle_green;
        } else if (rating > 5 ){
            backgroundId =R.drawable.circle_orange;
        } else{
            backgroundId = R.drawable.circle_red;
        }
        Drawable background = ContextCompat.getDrawable(viewHolder.itemView.getContext(), backgroundId);
        viewHolder.textViewRating.setBackground(background);
        viewHolder.textViewRating.setText(String.format("%.1f",rating));

        // проверяем >= вместо == для того чтобы если пришла от сервера ошибка то при прокрутки на
        // следущий элемент мы снова попытались загрузить.
        // можно было оставить и ==
        if (position >= movies.size() - 10 && onReachEndListener != null){
            onReachEndListener.onReachEnd();
        }

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    interface OnReachEndListener{

        void onReachEnd();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewPoster;
        private final TextView textViewRating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }
}
