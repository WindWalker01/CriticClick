package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.MovieTitleHolder;
import org.example.components.TitleBar;
import org.example.components.TitleCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends CriticPage {

    private final JComboBox<String> genreComboBox;
    private final JTextField search;

    public Home(CriticWindow window) {

        TitleCard[] titleCards = new TitleCard[] {
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
        };



        JLabel browse = new JLabel("BROWSE BY");
        browse.setBounds(170,100,100,100);
        browse.setFont(new Font("Arial", Font.BOLD, 13));


        String[] genres = { "Select Genre", "Action", "Adventure", "Drama", "Sci-Fi" };
        genreComboBox = new JComboBox<>(genres); // Initialize the combo box
        genreComboBox.setFont(new Font("Arial", Font.BOLD, 10));

        genreComboBox.setBounds(263, 136, 150, 25); // Set position and size
        genreComboBox.setFocusable(false); // Disable focus
        genreComboBox.setBackground(Color.WHITE); // Set background color

        // Add an action listener for user interaction
        genreComboBox.addActionListener(e -> {
            String selectedGenre = (String) genreComboBox.getSelectedItem();
            System.out.println("Selected genre: " + selectedGenre);
        });


        JLabel findFilm = new JLabel("SEARCH");
        findFilm.setBounds(865,100,100,100);
        findFilm.setFont(new Font("Arial", Font.BOLD, 13));


        search = new JTextField();
        search.setFont(new Font("Arial", Font.BOLD, 10));
        search.setBounds(933, 136, 150, 25);
        search.setText("Search");
        search.setEditable(true);
        search.setBackground(Color.WHITE);

        search.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                search.selectAll(); // Select all the text
            }
        });


        JLabel popularFilms = new JLabel("POPULAR FILMS THIS WEEK");
        findFilm.setBounds(170,240,100,100);
        findFilm.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel moreFilms = new JLabel("MORE");
        moreFilms.setBounds(1040,240,100,100);
        moreFilms.setFont(new Font("Arial", Font.BOLD, 15));




        MovieTitleHolder popularThisWeek = new MovieTitleHolder(titleCards);
        popularThisWeek.setLocation(167, 300);





        add(browse);
        add(findFilm);
        add(popularFilms);
        add(moreFilms);
        add(genreComboBox);
        add(search);
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
