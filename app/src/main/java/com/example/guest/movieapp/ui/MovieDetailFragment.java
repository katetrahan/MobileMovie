package com.example.guest.movieapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.movieapp.R;
import com.example.guest.movieapp.models.Movie;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    @BindView(R.id.backdropImageView) ImageView mImageLabel;
    @BindView(R.id.movieNameTextView) TextView mNameLabel;
    @BindView(R.id.releaseDateTextView) TextView mReleaseDateLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.overviewTextView) TextView mOverviewLabel;
    @BindView(R.id.actorsTextView) TextView mActorsLabel;


    private Movie mMovie;

    public static MovieDetailFragment newInstance(Movie movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);


        Picasso.with(view.getContext()).load(mMovie.getBackdropUrl()).into(mImageLabel);

        mNameLabel.setText(mMovie.getName());
        mRatingLabel.setText(mMovie.getRating() + "/10");
        mOverviewLabel.setText(mMovie.getSynopsis());
        mReleaseDateLabel.setText(mMovie.getReleaseDate());

        return view;
    }
}