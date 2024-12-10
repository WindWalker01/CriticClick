package org.example.criticclick;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
//    public void onChangeSceneCreate(ActionEvent event) throws IOException {
//        changeScene("Create", event);
//    }
//
//    @FXML
//    public void onChangeSceneHome(ActionEvent event) throws IOException {
//        changeScene("Home", event);
//    }
//
//    @FXML
//    public void onChangeSceneLoading(ActionEvent event) throws IOException {
//        changeScene("Loading", event);;
//    }
//
//    @FXML
//    public void onChangeSceneLogin(ActionEvent event) throws IOException {
//        changeScene("Login", event);
//    }
//
//    @FXML
//    public void onChangeSceneMain(ActionEvent event) throws IOException {
//        changeScene("Main", event);
//    }
//
//    @FXML
//    public void onChangeSceneMore(ActionEvent event) throws IOException {
//        changeScene("More", event);
//    }
//
//    @FXML
//    public void onChangeScenePoster(ActionEvent event) throws IOException {
//        changeScene("Poster", event);
//    }
//
//    @FXML
//    public void onChangeSceneProfile(ActionEvent event) throws IOException {
//        changeScene("Profile", event);
//    }


    public void changeScene(String desiredScene, ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource( desiredScene+ ".fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1280, 720);


        stage.setTitle("CriticClick");
        stage.setScene(scene);
        stage.show();
    }


}
