package org.example.criticclick;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MainController  extends SceneController{


    @FXML
    public void onChangeSceneCreate(ActionEvent event) throws IOException {
        changeScene("Create", event);
    }

    @FXML
    public void onChangeSceneLogin(ActionEvent event) throws IOException {
        changeScene("Login", event);
    }
}
