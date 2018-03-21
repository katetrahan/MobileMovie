package com.example.guest.movieapp.service;

import android.util.Log;

import com.example.guest.movieapp.Constants;
import com.example.guest.movieapp.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MovieService {

    public static void findMovies(String movie, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("api_key", Constants.ApiKey);
        urlBuilder.addQueryParameter("query", movie);
        String url = urlBuilder.build().toString();
        Log.v("MovieService", url);

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.ApiKey)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject movieJSON = new JSONObject(jsonData);
            JSONArray businessesJSON = movieJSON.getJSONArray("results");
            for (int i = 0; i < businessesJSON.length(); i++) {
                JSONObject titleJSON = businessesJSON.getJSONObject(i);
                String title = titleJSON.getString("title");



//                ArrayList<String> categories = new ArrayList<>();
//                JSONArray categoriesJSON = restaurantJSON.getJSONArray("categories");

//                for (int y = 0; y < categoriesJSON.length(); y++) {
//                    categories.add(categoriesJSON.getJSONObject(y).getString("title"));
//                }
                Movie movie = new Movie(title);
                movies.add(movie);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return movies;
    }


}
