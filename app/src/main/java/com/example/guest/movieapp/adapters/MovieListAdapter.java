package com.example.guest.movieapp.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.guest.movieapp.models.Movie;
import com.example.guest.movieapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Movie> mMovies = new ArrayList<>();
    private Context mContext;

    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieViewHolder holder, int position) {
        holder.bindMovie(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movieImageView) ImageView movieImageView;
        @BindView(R.id.movieNameTextView) TextView mMovieNameTextView;
        @BindView(R.id.releaseDateTextView) TextView mReleaseDateTextView;
        @BindView(R.id.synopsisTextView) TextView mSynopsisTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindMovie(com.example.guest.movieapp.models.Movie movie) {
            Picasso.with(mContext).load(movie.getImageUrl()).into(movieImageView);
            mMovieNameTextView.setText(movie.getName());
            mReleaseDateTextView.setText(movie.getReleaseDate());
            mSynopsisTextView.setText(movie.getSynopsis());
            mRatingTextView.setText("Rating: " + movie.getRating() + "/10");
        }
    }
}
