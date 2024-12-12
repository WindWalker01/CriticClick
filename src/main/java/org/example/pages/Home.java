package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.MovieTitleHolder;
import org.example.components.TitleBar;
import org.example.components.TitleCard;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends CriticPage {

    public Home(CriticWindow window) {

        TitleCard[] titleCards = new TitleCard[] {
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
        };


        MovieTitleHolder popularThisWeek = new MovieTitleHolder(titleCards);

        popularThisWeek.setLocation(167, 200);

        add(popularThisWeek);
        add(new TitleBar());


        // TODO: remove this shit later this is for debugging purposes only
//        TitleCard titleCard = new TitleCard();
//        titleCard.setLocation(titleCard.getWidth(), 320);
//
//        add(titleCard);





        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.Create);
            }
        });

    }

}
