package org.example.dsa;

import org.example.data.Movie;

public class Test {

    public static void main(String[] args) {
        MovieMap<String, Movie> map = new MovieMap<>();


        map.printTable();
        map.set("Comedy", new Movie());
        map.set("Horror", new Movie());
        map.set("Horror", new Movie());

        map.printTable();
    }
}
