package org.example.data;

public class Movie {

    public int id = -1;
    public String title = "Not Found";
    public String overview = "Not Found";
    public float  rating = -1f;
    public String  posterPath;
    public String backdropPath;
    public String year = "N / A-01-23";

    public int[] genre;

    public Movie(){
        id = -1;
        title = "Not Found";
        overview = "Not Found";
        rating = -1f;
        posterPath = "null";
        backdropPath = "null";
        year = "N/A-01-23";
    }
}
