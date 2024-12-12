package org.example.components;

import javax.swing.*;
import java.awt.*;

public class MovieTitleHolder extends JPanel {

    public MovieTitleHolder(TitleCard[] titleCards){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        setSize(954, 265);


        for(TitleCard titleCard : titleCards){
            add(titleCard);
        }

    }

}
