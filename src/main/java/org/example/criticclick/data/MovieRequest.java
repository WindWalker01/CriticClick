package org.example.criticclick.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
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

    // Now Playing
    public ArrayList<Movie> getPopularReviews(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1"))
                    .header("accept", "application/json")
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmY5Nzg2NjQ0ODQ1NjIyMDBjZGUwMzVmN2JhNzFhZiIsIm5iZiI6MTczMzM4MDg1My4zMDgsInN1YiI6IjY3NTE0YWY1NzJkMWE4YTU5YzI5NzU3YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VVMB6g66OlAQbOz1SlYVUTPuG4xl74PKdJ2-hqic1zE")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            return parseMovies(response.body());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // Now Playing
    public  ArrayList<Movie> getPopularFilms(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1"))
                    .header("accept", "application/json")
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmY5Nzg2NjQ0ODQ1NjIyMDBjZGUwMzVmN2JhNzFhZiIsIm5iZiI6MTczMzM4MDg1My4zMDgsInN1YiI6IjY3NTE0YWY1NzJkMWE4YTU5YzI5NzU3YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VVMB6g66OlAQbOz1SlYVUTPuG4xl74PKdJ2-hqic1zE")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());


            return parseMovies(response.body());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //Top Rated
    public ArrayList<Movie> getFilmRecommendation(){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1"))
                    .header("accept", "application/json")
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYmY5Nzg2NjQ0ODQ1NjIyMDBjZGUwMzVmN2JhNzFhZiIsIm5iZiI6MTczMzM4MDg1My4zMDgsInN1YiI6IjY3NTE0YWY1NzJkMWE4YTU5YzI5NzU3YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.VVMB6g66OlAQbOz1SlYVUTPuG4xl74PKdJ2-hqic1zE")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());



            return parseMovies(response.body());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private ArrayList<Movie> parseMovies(String json) throws JsonProcessingException {
        ArrayList<Movie> movies = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json);

        JsonNode results = jsonNode.get("results");

        for(JsonNode jsonMovie : results){
            Movie movieObj = new Movie();

            movieObj.backdropPath =  jsonMovie.get("backdrop_path").asText();
            movieObj.id = jsonMovie.get("id").asInt();
            movieObj.title = jsonMovie.get("original_title").asText();
            movieObj.overview = jsonMovie.get("overview").asText();
            movieObj.rating = jsonMovie.get("vote_average").asInt();
            movieObj.posterPath = jsonMovie.get("poster_path").asText();

            movieObj.year = jsonMovie.get("release_date").asText();

            JsonNode genres = jsonMovie.get("genre_ids");
            movieObj.genre = new int[genres.size()];

            for (int i = 0; i < genres.size(); i++){
                movieObj.genre[i] = genres.get(i).asInt();
            }

            movies.add(movieObj);
        }


        return movies;


    }

}
