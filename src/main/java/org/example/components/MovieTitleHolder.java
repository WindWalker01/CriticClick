package org.example.components;

import org.example.CriticWindow;
import org.example.pages.CriticPage;

import javax.swing.*;
import java.awt.*;

public class MovieTitleHolder extends JPanel {

    public MovieTitleHolder(TitleCard[] titleCards){
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));

        setSize(900, 265);
        setPreferredSize(new Dimension(900, 265));

        for(TitleCard titleCard : titleCards){
            titleCard.setPreferredSize(new Dimension(150, 300));
            add(titleCard);
            setBackground(CriticPage.LIGHT_BEIGE);

        }

    }

}
