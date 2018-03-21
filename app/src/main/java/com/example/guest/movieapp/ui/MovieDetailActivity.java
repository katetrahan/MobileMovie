package com.example.guest.movieapp.ui;

import android.os.Parcel;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.guest.movieapp.R;
import com.example.guest.movieapp.adapters.MoviePagerAdapter;
import com.example.guest.movieapp.models.Movie;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private MoviePagerAdapter adapterViewPager;
    ArrayList<Movie> mMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);

        mMovies = Parcels.unwrap(getIntent().getParcelableExtra("movies"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new MoviePagerAdapter(getSupportFragmentManager(), mMovies);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
