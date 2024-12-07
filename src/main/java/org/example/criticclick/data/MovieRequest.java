package org.example.criticclick.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class MovieRequest {

    private void getMovieByName(String query){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.themoviedb.org/3/search/movie?query=" + query.replaceAll("\\s", "") + "&include_adult=false&language=en-US&page=1"))
                    .header("accept", "application/json")
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmY5Nzg2NjQ0ODQ1NjIyMDBjZGUwMzVmN2JhNzFhZiIsIm5iZiI6MTczMzM4MDg1My4zMDgsInN1YiI6IjY3NTE0YWY1NzJkMWE4YTU5YzI5NzU3YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VVMB6g66OlAQbOz1SlYVUTPuG4xl74PKdJ2-hqic1zE")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch (Exception e){
            System.err.println("Something went wrong: API request declined or something idk");
        }
    }

    private void getMovieByTrendingAll(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1"))
                    .header("accept", "application/json")
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmY5Nzg2NjQ0ODQ1NjIyMDBjZGUwMzVmN2JhNzFhZiIsIm5iZiI6MTczMzM4MDg1My4zMDgsInN1YiI6IjY3NTE0YWY1NzJkMWE4YTU5YzI5NzU3YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VVMB6g66OlAQbOz1SlYVUTPuG4xl74PKdJ2-hqic1zE")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Movie> getFilmRecommendation(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1"))
                    .header("accept", "application/json")
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmY5Nzg2NjQ0ODQ1NjIyMDBjZGUwMzVmN2JhNzFhZiIsIm5iZiI6MTczMzM4MDg1My4zMDgsInN1YiI6IjY3NTE0YWY1NzJkMWE4YTU5YzI5NzU3YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VVMB6g66OlAQbOz1SlYVUTPuG4xl74PKdJ2-hqic1zE")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

//            System.out.println(response.body());
            ArrayList<Movie> movies = new ArrayList<>();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response.body());

            JsonNode jsonMovies = jsonNode.get("results");

            for(JsonNode jsonMovie : jsonMovies){
                Movie movieObj = new Movie();

                movieObj.backdropPath =  jsonMovie.get("backdrop_path").asText();
                movieObj.id = jsonMovie.get("id").asInt();

                movies.add(movieObj);
            }



            return movies;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
