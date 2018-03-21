package com.example.guest.movieapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.movieapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.movieTextView) TextView mMovieTextView;
    @BindView(R.id.movieEditText) EditText mMovieEditText;
    @BindView(R.id.findMovieButton) Button mFindMovieButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindMovieButton.setOnClickListener(this);
    }

    @Override
    public void onClick (View v){
        if (v == mFindMovieButton) {
            String movie = mMovieEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, MovieActivity.class);
            intent.putExtra("movie", movie);
            startActivity(intent);
        }
    }
}
