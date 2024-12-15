package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.MovieTitleHolder;
import org.example.components.TitleBar;
import org.example.data.MovieRequest;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class Searched extends CriticPage {

    private final JTextField search;
    public JScrollPane scrollPane;
    public JButton back;
    private CriticWindow window;
    public MovieTitleHolder popularThisWeek;

    public Searched(CriticWindow window) {
        this.window = window;

        popularThisWeek = new MovieTitleHolder(MovieRequest.movies, 20, window);
        popularThisWeek.setPreferredSize(new Dimension(1200, 2000));

        JLabel findFilm = new JLabel("FIND A FILM");
        findFilm.setBounds(865, 100, 100, 100);
        findFilm.setFont(new Font("Arial", Font.BOLD, 16));

        search = new JTextField("Search");
        search.setBounds(933, 136, 200, 55);
        search.setPreferredSize(new Dimension(280, 40));
        search.setFont(new Font("Arial", Font.BOLD, 14));
        search.setEditable(true);
        search.setBackground(Color.WHITE);

        search.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!search.getText().equals("")) {
                    MovieRequest.getMoviesByName(search.getText());
                    window.changePage(Page.Search);
                }
            }
        });

        JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        center.setBackground(LIGHT_BEIGE);
        center.add(findFilm);
        center.add(search);

        JLabel popularFilms = new JLabel("FILMS");
        popularFilms.setBounds(50, 0, 300, 100);
        popularFilms.setFont(new Font("Arial", Font.BOLD, 15));

        JPanel spacerUp = new JPanel();
        spacerUp.setLayout(null);
        spacerUp.setPreferredSize(new Dimension(1050, 50));
        spacerUp.setBackground(LIGHT_BEIGE);

        JPanel spacerLow = new JPanel();
        spacerLow.setLayout(null);
        spacerLow.setPreferredSize(new Dimension(1050, 80));
        spacerLow.setBackground(LIGHT_BEIGE);

        JPanel up = new JPanel();
        up.setLayout(new BorderLayout());
        up.setPreferredSize(new Dimension(1110, 50));
        up.setBackground(LIGHT_BEIGE);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        leftPanel.setBackground(LIGHT_BEIGE);

        up.add(leftPanel, BorderLayout.WEST);
        up.add(center, BorderLayout.CENTER);

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
        scrollPane.setBackground(LIGHT_BEIGE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0x756565);
                this.trackColor = new Color(0xD0D0D0);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                g.setColor(new Color(0x756565));
                g.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.setColor(new Color(0xD0D0D0));
                g.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
            }
        });

        add(new TitleBar(window));
        add(scrollPane);

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
    }

    @Override
    public void reloadPage() {
        popularThisWeek.updateTitleCards(MovieRequest.searched);
    }
}
