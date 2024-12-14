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

public class Poster extends CriticPage {

    private final JComboBox<String> genreComboBox;
    private final JTextField search;
    public JScrollPane scrollPane;
    public JButton back;
    public JButton next;

    public Poster(CriticWindow window) {

        TitleCard[] titleCards = new TitleCard[] {
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
                new TitleCard(),
        };

        JLabel browse = new JLabel("BROWSE BY");
        browse.setFont(new Font("Arial", Font.BOLD, 14));

        String[] genres = { "Select Genre", "Action", "Adventure", "Drama", "Sci-Fi" };
        genreComboBox = new JComboBox<>(genres);
        genreComboBox.setFont(new Font("Arial", Font.BOLD, 14));
        genreComboBox.setPreferredSize(new Dimension(200, 40));
        genreComboBox.setBounds(263, 136, 50, 25);
        genreComboBox.setFocusable(false);
        genreComboBox.setBackground(Color.WHITE);
        genreComboBox.addActionListener(e -> {
            String selectedGenre = (String) genreComboBox.getSelectedItem();
            System.out.println("Selected genre: " + selectedGenre);
        });

        JLabel findFilm = new JLabel("FIND A FILM");
        findFilm.setBounds(865,100,100,100);
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


        JLabel popularFilms = new JLabel("FILMS");
        popularFilms.setBounds(50,0,300,100);
        popularFilms.setFont(new Font("Arial", Font.BOLD, 15));


        MovieTitleHolder popularThisWeek = new MovieTitleHolder(titleCards);
        popularThisWeek.setPreferredSize(new Dimension(1200, 2000));

        //spacer
        JPanel spacerUp = new JPanel();
        spacerUp.setLayout(null);
        spacerUp.setPreferredSize(new Dimension(1050, 50));
        spacerUp.setBackground(CriticWindow.LIGHT_BEIGE);

        JPanel spacerLow = new JPanel();
        spacerLow.setLayout(null);
        spacerLow.setPreferredSize(new Dimension(1050, 80));
        spacerLow.setBackground(CriticWindow.LIGHT_BEIGE);

        // upper section
        JPanel up = new JPanel();
        up.setLayout(new BorderLayout());
        up.setPreferredSize(new Dimension(1110, 50));
        up.setBackground(CriticWindow.LIGHT_BEIGE);


        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
        leftPanel.setBackground(CriticWindow.LIGHT_BEIGE);
        leftPanel.add(browse);
        leftPanel.add(genreComboBox);


        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,30,0));
        rightPanel.setBackground(CriticWindow.LIGHT_BEIGE);
        rightPanel.add(findFilm);
        rightPanel.add(search);

        up.add(leftPanel, BorderLayout.WEST);
        up.add(rightPanel, BorderLayout.EAST);

        // lower section
        JPanel low = new JPanel();
        low.setPreferredSize(new Dimension(1050, 25));
        low.setBackground(CriticWindow.LIGHT_BEIGE);
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
        poster.setBackground(CriticWindow.LIGHT_BEIGE);
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

        add(new TitleBar());
        add(scrollPane);


        // action listeners
        search.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Search")) {
                    search.setText("");  // clear the text when the JTextField is clicked
                }
            }

            public void focusLost(FocusEvent e) {
                if (search.getText().equals("")) {
                    search.setText("Search");  // restore the default text if the JTextField is empty
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.Create);
            }
        });

        // TODO: remove this shit later this is for debugging purposes only
//        TitleCard titleCard = new TitleCard();
//        titleCard.setLocation(titleCard.getWidth(), 320);
//
//        add(titleCard);
    }