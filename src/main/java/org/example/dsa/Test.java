package org.example.dsa;

import org.example.data.Movie;

import java.util.ArrayList;
import java.util.Objects;

public class Test {

    public static void main(String[] args) {
        HashMapngGroup1<String, Movie> map = new HashMapngGroup1<>();


//        map.printTable();
        map.set("Comedy", new Movie());
        map.set("Horror", new Movie());
        map.set("Horror", new Movie());

        map.printTable();
//        System.out.println("-------");
//        System.out.println(map.get("Horror"));

//        ArrayList<String> list = map.keys();

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }


        for(HashMapngGroup1.Node<String, Movie> set : map.entrySet()){
            System.out.println("Key: " + set.key);
            System.out.println("Value: " + set.value);
        }





    }


}
