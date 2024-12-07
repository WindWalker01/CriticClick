package org.example.criticclick;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.criticclick.data.Movie;
import org.example.criticclick.data.MovieRequest;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        MovieRequest request = new MovieRequest();
        ArrayList<Movie> movies = request.getFilmRecommendation();
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i).id);
        }


        launch();
    }
}