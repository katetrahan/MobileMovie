package com.example.guest.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import android.support.v7.widget.RecyclerView;

import com.example.guest.movieapp.Constants;
import com.example.guest.movieapp.R;
import com.example.guest.movieapp.adapters.MovieListAdapter;
import com.example.guest.movieapp.models.Movie;
import com.example.guest.movieapp.service.MovieService;

import java.io.IOException;
import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    public static final String TAG = MovieActivity.class.getSimpleName();


    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private MovieListAdapter mAdapter;

    public ArrayList<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String movie = intent.getStringExtra("movie");

        getMovie(movie);

    }

    private void getMovie(String location) {
        final MovieService movieService = new MovieService();
        movieService.findMovies(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                movies = movieService.processResults(response);

                MovieActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new MovieListAdapter(getApplicationContext(), movies);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(MovieActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);


                     }
                });
            }
        });
    }
}
