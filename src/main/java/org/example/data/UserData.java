package org.example.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserData {

    private static final String JSON_FILE_PATH = "src/main/resources/users.json";

    public static List<User> allUsers = new ArrayList<User>();
    public static User currentUser = null;

    public static int setUpCurrentUser(String username, String password) {
       for (User user : allUsers) {
           if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
               currentUser = user;
               allUsers.remove(user);
               return 0;
           }
       }

       return -1;
    }

    public static void main(String[] args) {
//        // Sample data
//        List<User> users = new ArrayList<>();
//        users.add(new User("john_doe", "password123", List.of(
//                new Movie("Inception", 1, "Amazing sci-fi movie!", 9),
//                new Movie("Titanic", 2, null, 8)
//        )));
//        users.add(new User("jane_doe", "securePassword", List.of(
//                new Movie("The Matrix", 3, "A genre-defining classic", 10)
//        )));
//
//        // Write users to JSON file
//        saveUsersToJson(users);
//
//        // Load users from JSON file
//        List<User> loadedUsers = loadUsersFromJson();
//
//        // Add movies to an existing user
//        addMoviesToUser(loadedUsers, "john_doe", List.of(
//                new Movie("Avatar", 4, "Visually stunning!", 9),
//                new Movie("Interstellar", 5, "Mind-bending sci-fi", 10)
//        ));
//
//        // Save updated users to JSON file
//        saveUsersToJson(loadedUsers);
//
//        // Print updated JSON data
//        System.out.println("Updated User Data:");
//        System.out.println(convertToJson(loadedUsers));
    }

    // Method to save users to an external JSON file
    public static void saveUsersToJson(List<User> users) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            mapper.writeValue(new File(JSON_FILE_PATH), users);
            System.out.println("User data saved to " + JSON_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving user data to file: " + e.getMessage());
        }
    }

    // Method to load users from an external JSON file
    public static List<User> loadUsersFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(JSON_FILE_PATH);
            if (file.exists()) {
                return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
            } else {
                System.out.println("No JSON file found. Starting with an empty user list.");
                return new ArrayList<>();
            }
        } catch (IOException e) {
            System.err.println("Error loading user data from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Method to add movies to an existing user
    public static void addMoviesToUser(User user, MovieExternalData newMovieExternalData) {
        if (user.getMovies() == null) {
            user.setMovies(new ArrayList<>());
        }
        user.getMovies().add(newMovieExternalData);
    }

    // Utility method to convert a list of users to a JSON string
    private static String convertToJson(List<User> users) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            return mapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // User class
    public static class User {
        private String username;
        private String password;
        private List<MovieExternalData> movieExternalData;

        // Default constructor (required for Jackson)
        public User() {
        }

        public User(String username, String password, List<MovieExternalData> movieExternalData) {
            this.username = username;
            this.password = password;
            this.movieExternalData = movieExternalData;
        }

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<MovieExternalData> getMovies() {
            return movieExternalData;
        }

        public void setMovies(List<MovieExternalData> movieExternalData) {
            this.movieExternalData = movieExternalData;
        }
    }

    // Movie class
    public static class MovieExternalData {
        private String title;
        private int id;
        private String comments;
        private int rating;

        public MovieExternalData() {}

        public MovieExternalData(String title, int id, String comments, int rating) {
            this.title = title;
            this.id = id;
            this.comments = comments;
            this.rating = rating;
        }

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }
}
