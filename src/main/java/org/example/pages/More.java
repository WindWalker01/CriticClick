package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.MovieTitleHolder;
import org.example.components.TitleBar;
import org.example.components.TitleCard;
import org.example.data.Movie;
import org.example.data.MovieRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class More extends CriticPage {

    private final JComboBox<String> genreComboBox;
    private final JTextField search;
    public JScrollPane scrollPane;
    public JButton back;
    public JButton next;

    private CriticWindow window;
    public MovieTitleHolder popularThisWeek;

    private ArrayList<TitleCard> titleCards = new ArrayList<>();

    public More(CriticWindow window) {
        this.window = window;

        JLabel browse = new JLabel("BROWSE BY");
        browse.setFont(new Font("Arial", Font.BOLD, 14));

        MovieTitleHolder popularThisWeek = new MovieTitleHolder(MovieRequest.movieMap.get("Default"), 20, window);
        popularThisWeek.setPreferredSize(new Dimension(1200, 2000));


        String[] genres = {"Select Genre", "Action", "Adventure", "Drama", "Science Fiction"};
        genreComboBox = new JComboBox<>(genres);
        genreComboBox.setFont(new Font("Arial", Font.BOLD, 14));
        genreComboBox.setPreferredSize(new Dimension(200, 40));
        genreComboBox.setBounds(263, 136, 50, 25);
        genreComboBox.setFocusable(false);
        genreComboBox.setBackground(Color.WHITE);
        genreComboBox.addActionListener(e -> {
            String selectedGenre = (String) genreComboBox.getSelectedItem();


            switch (selectedGenre) {
                case "Select Genre":
                    popularThisWeek.updateTitleCards(MovieRequest.movieMap.get("Default"));
                    break;
                case "Action":
                    popularThisWeek.updateTitleCards(MovieRequest.movieMap.get("Action"));
                    break;
                case "Adventure":
                    popularThisWeek.updateTitleCards(MovieRequest.movieMap.get("Adventure"));
                    break;
                case "Drama":
                    popularThisWeek.updateTitleCards(MovieRequest.movieMap.get("Drama"));
                    break;
                case "Science Fiction":
                    popularThisWeek.updateTitleCards(MovieRequest.movieMap.get("Science Fiction"));
                    break;
            }

            System.out.println("Selected genre: " + selectedGenre);
            repaint();
        });

        JLabel findFilm = new JLabel("FIND A FILM");
        findFilm.setBounds(865, 100, 100, 100);
        findFilm.setFont(new Font("Arial", Font.BOLD, 14));

        search = new JTextField("Search");
        search.setBounds(933, 136, 150, 55);
        search.setPreferredSize(new Dimension(200, 40));
        search.setFont(new Font("Arial", Font.BOLD, 10));
        search.setEditable(true);
        search.setBackground(Color.WHITE);
        search.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                search.selectAll();
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!search.getText().equals("")) {
                    MovieRequest.getMoviesByName(search.getText());
                    window.changePage(Page.Search);

                }
            }
        });


        JLabel popularFilms = new JLabel("FILMS");
        popularFilms.setBounds(50, 0, 300, 100);
        popularFilms.setFont(new Font("Arial", Font.BOLD, 15));




        //spacer
        JPanel spacerUp = new JPanel();
        spacerUp.setLayout(null);
        spacerUp.setPreferredSize(new Dimension(1050, 50));
        spacerUp.setBackground(LIGHT_BEIGE);

        JPanel spacerLow = new JPanel();
        spacerLow.setLayout(null);
        spacerLow.setPreferredSize(new Dimension(1050, 80));
        spacerLow.setBackground(LIGHT_BEIGE);

        // upper section
        JPanel up = new JPanel();
        up.setLayout(new BorderLayout());
        up.setPreferredSize(new Dimension(1110, 50));
        up.setBackground(LIGHT_BEIGE);


        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        leftPanel.setBackground(LIGHT_BEIGE);
        leftPanel.add(browse);
        leftPanel.add(genreComboBox);


        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 0));
        rightPanel.setBackground(LIGHT_BEIGE);
        rightPanel.add(findFilm);
        rightPanel.add(search);

        up.add(leftPanel, BorderLayout.WEST);
        up.add(rightPanel, BorderLayout.EAST);

        // lower section
        JPanel low = new JPanel();
        low.setPreferredSize(new Dimension(1050, 25));
        low.setBackground(LIGHT_BEIGE);
        low.setLayout(new BorderLayout());
        low.add(popularFilms, BorderLayout.WEST);


        back = new JButton("Back");
        back.setBounds(1100, 600, 76, 35);
        back.setFont(new Font("Arial", Font.BOLD, 10));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFocusable(false);

        JPanel poster = new JPanel();
        poster.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        poster.setBackground(LIGHT_BEIGE);
        poster.setPreferredSize(new Dimension(1200, 1500));

        // lowest
        JPanel lowest = new JPanel();
        lowest.setPreferredSize(new Dimension(1050, 25));
        lowest.setLayout(new BorderLayout());
        lowest.add(back, BorderLayout.WEST);

        poster.add(spacerUp);
        poster.add(up);
        poster.add(spacerLow);
        poster.add(low);
        poster.add(popularThisWeek);
        poster.add(lowest);


        scrollPane = new JScrollPane(poster);
        scrollPane.setBounds(0, 65, 1270, 720);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);  // to make scroll faster

        add(new TitleBar(window));
        add(scrollPane);


        // action listeners
        search.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Search")) {
                    search.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (search.getText().equals("")) {
                    search.setText("Search");
                }
            }
        });

//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                window.changePage(Page.Create);
//            }
//        });

    }

    @Override
    public void reloadPage() {
        ArrayList<Movie> movies = MovieRequest.movies;
        for (Movie movie : movies){
            titleCards.add(new TitleCard(movie, window));
        }
    }
}