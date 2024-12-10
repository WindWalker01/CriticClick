package org.example.criticclick;


import javafx.event.ActionEvent;

import java.io.IOException;

public class CreateController extends SceneController {


    public void onChangeToHome(ActionEvent event) throws IOException {
        changeScene("Home", event);
    }

}
