package com.example.guest.movieapp.models;

/**
 * Created by Guest on 3/21/18.
 */

public class Movie {
    private String name;
    private String releaseDate;
    private String rating;
    private String imageUrl;
    private String synopsis;


    public Movie(String name) {
        this.name = name;
//        this.releaseDate = releaseDate;
//        this.rating = rating;
//        this.imageUrl = imageUrl;
//        this.synopsis = synopsis;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }
}
