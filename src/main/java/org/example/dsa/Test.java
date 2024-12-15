package org.example.dsa;

import org.example.data.Movie;

import java.util.ArrayList;
import java.util.Objects;

public class Test {

    public static void main(String[] args) {
        HashMapngGroup1<String, Movie> map = new HashMapngGroup1<>();

        map.set("Comedy", new Movie());
        map.set("Horror", new Movie());
        map.set("Horror", new Movie());
        map.printTable();

        for(HashMapngGroup1.Node<String, Movie> set : map.entrySet()){
            System.out.println("Key: " + set.key);
            System.out.println("Value: " + set.value);
        }





    }


}
