package org.example.crticclick;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Movies {


    public void getRequest(String query){
        String temp = "http://www.omdbapi.com/?apikey=" + "API KEY GOES HERE" + "&s=" + query.replaceAll("\\s", "");

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
