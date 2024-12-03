package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieData {

    public void  getMovie(String query){
        String temp = "http://www.omdbapi.com/?apikey=" + Settings.API_KEY + "&s=" + query.replaceAll("\\s", "");
//        System.out.println(temp);
        try{
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(
                    new URI(temp)
            ).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        }catch (Exception e){
            System.err.println("Something went wrong: API request declined or something idk");
        }

    }
}
