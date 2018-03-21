package com.example.guest.movieapp.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 3/21/18.
 */

@Parcel
public class Movie {
    String name;
    String releaseDate;
    String rating;
    String synopsis;
    String backdropUrl;
    String posterUrl;


    public Movie() {}

    public Movie(String name, String releaseDate, String rating, String posterUrl, String backdropUrl, String synopsis) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.backdropUrl = backdropUrl;
        this.synopsis = synopsis;
        this.posterUrl = posterUrl;
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

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }
}
