package org.example.criticclick;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class HomeController  extends SceneController{

    @FXML
    private HBox popularFilms;

    @FXML
    public void initialize() {
        try {
            for (int i = 0; i < 15; i++){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieCard.fxml"));
                Node movie = loader.load();
                MovieCardController controller = loader.getController();

                controller.setTitle("Movie");
                controller.setYear("year");
                controller.setPoster("/yh64qw9mgXBvlaWDi7Q9tpUBAvH.jpg");

                popularFilms.getChildren().add(movie);


            }

        }catch (Exception e) {

        }
    }
}
