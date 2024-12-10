package org.example.criticclick;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Create.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

//        MovieRequest request = new MovieRequest();
//        ArrayList<Movie> movies = request.getPopularReviews();
//        for (int i = 0; i < movies.size(); i++) {
//            System.out.println("ID: "+movies.get(i).id);
//            System.out.println("Title: "+movies.get(i).title);
//            System.out.println("Overview: "+movies.get(i).overview);
//            System.out.println("Rating: "+movies.get(i).rating);
//            System.out.println("Poster: "+movies.get(i).posterPath);
//            System.out.println("Backdrop: "+movies.get(i).backdropPath);
//            System.out.println("Year: "+movies.get(i).year);
//            System.out.println("------------------");
//        }
//
//        System.out.println("\n\n"+movies.size());


        launch();
    }
}