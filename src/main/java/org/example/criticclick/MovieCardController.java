package org.example.criticclick;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class MovieCardController extends VBox {

    @FXML
    private ImageView  poster;

    @FXML
    private Label title;

    @FXML
    private Label  year;

    public MovieCardController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MovieCard.fxml"));
        loader.setRoot(this);
        loader.setController(this);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }
    public void setYear(String year) {
        this.year.setText(year);
    }
    public void setPoster(String poster) {
        this.poster.setImage(new Image("https://image.tmdb.org/t/p/w154" + poster));
    }

    public String getTitle(){
        return title.getText();
    }

    public String getYear(){
        return year.getText();
    }

    public ImageView getPoster(){
        return poster;
    }


}
