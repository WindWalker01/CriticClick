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
        if (allUsers == null) {
            allUsers = new ArrayList<>();
        }

        if (allUsers.isEmpty()) {
            System.out.println("No users available in the system.");
            return -1;
        }

        User matchedUser = null;
        for (User user : allUsers) {
            if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                matchedUser = user;
                break;
            }
        }
        if (matchedUser == null) {
            System.out.println("User not found with the provided username and password.");
            return -1;
        }
        currentUser = matchedUser;
        allUsers.remove(matchedUser);
        return 0;
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
