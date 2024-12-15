package org.example.pages;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.TitleBar;
import org.example.components.primitives.WebImage;
import org.example.data.MovieRequest;
import org.example.data.StateManager;
import org.example.data.UserData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Poster extends CriticPage implements ActionListener {

    private JPanel desc, background;
    private JLabel title, rate, poster, search;
    private JTextArea synopsis;
    private JButton back, play, submit;
    private JTextField message, searchTf;
    private JComboBox<String> starRate;
    private final CriticWindow window;
    private String currentRating = "0";
    public Poster(CriticWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            window.changePage(Page.Home); // Navigate back to the home page
        }

        if (e.getSource() == submit) {
            // Ensure rating is parsed correctly
            int rating = Integer.parseInt(currentRating.split(" ")[0]); // Extract the numeric rating
            UserData.addMoviesToUser(
                    UserData.currentUser,
                    new UserData.MovieExternalData(
                            StateManager.currentMoviePoster.title,
                            StateManager.currentMoviePoster.id,
                            message.getText(),
                            rating
                    )
            );
        }
    }

    @Override
    public void reloadPage() {
        removeAll();
        setBackground(LIGHT_BEIGE);

        // Create background panel
        // Background panel for high-quality backdrop rendering
        background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

                // Set the transparency level to 50%
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));

                if (StateManager.currentMoviePoster.backdropPath != null && !StateManager.currentMoviePoster.backdropPath.equals("null")) {
                    try {
                        Icon icon = new WebImage("https://image.tmdb.org/t/p/original" + StateManager.currentMoviePoster.backdropPath).getIcon();
                        if (icon instanceof ImageIcon) {
                            ImageIcon backdropIcon = (ImageIcon) icon;
                            Image backdropImage = backdropIcon.getImage();
                            Image scaledImage = backdropImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                            g2d.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), null);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace(); // Handle errors gracefully
                    }
                } else {
                    // Default backdrop
                    ImageIcon defaultImage = new ImageIcon("src/main/resources/defaultBackdrop.png");
                    Image scaledDefault = defaultImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                    g2d.drawImage(scaledDefault, 0, 0, getWidth(), getHeight(), null);
                }
                g2d.dispose();
            }
        };


        // Configure background panel
        background.setBounds(0, 0, window.getWidth(), window.getHeight() - 220);
        background.setLayout(null);

        // Poster panel
        if (!"null".equals(StateManager.currentMoviePoster.posterPath)) {
            WebImage webImage = new WebImage("https://image.tmdb.org/t/p/w342" + StateManager.currentMoviePoster.posterPath);
            Icon icon = webImage.getIcon();
            if (icon instanceof ImageIcon) {
                Image resizedImage = ((ImageIcon) icon).getImage().getScaledInstance(220, 350, Image.SCALE_SMOOTH);
                poster = new JLabel(new ImageIcon(resizedImage));
            }
        } else {
            // Default poster
            ImageIcon image = new ImageIcon("src/main/resources/defaultPoster-big.png");
            Image resizedImage = image.getImage().getScaledInstance(220, 350, Image.SCALE_SMOOTH);
            poster = new JLabel(new ImageIcon(resizedImage));
        }
        poster.setBounds(100, 100, 220, 350);

        // Title label
        title = new JLabel(StateManager.currentMoviePoster.title + " (" + StateManager.currentMoviePoster.year.substring(0, 4) + ")");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setBounds(350, -80, 1000, 500);

        // Synopsis text area
        synopsis = new JTextArea(StateManager.currentMoviePoster.overview);
        synopsis.setForeground(Color.BLACK);
        synopsis.setFont(new Font("Arial", Font.ITALIC, 16));
        synopsis.setWrapStyleWord(true);
        synopsis.setLineWrap(true);
        synopsis.setOpaque(false);
        synopsis.setEditable(false);
        synopsis.setPreferredSize(new Dimension(600, 180));

        // Play trailer button
        play = new JButton("Play Trailer");
        play.setFont(new Font("Arial", Font.BOLD, 13));
        play.setForeground(Color.WHITE);
        play.setBackground(Color.BLACK);
        play.setFocusable(false);
        play.setBounds(350, 320, 150, 40);
        play.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com")); // Navigate to YouTube
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Back button
        back = new JButton("Back");
        back.setBounds(1100, 100, 76, 35);
        back.setFont(new Font("Arial", Font.BOLD, 10));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFocusable(false);
        back.addActionListener(this);

        // Rating label
        rate = new JLabel("Rate this Movie");
        rate.setForeground(Color.BLACK);
        rate.setFont(new Font("Roboto", Font.BOLD, 18));
        rate.setBounds(350, 500, 200, 60);

        // Message text field
        message = new JTextField();
        message.setForeground(Color.BLACK);
        message.setFont(new Font("Arial", Font.PLAIN, 18));
        message.setEditable(true);
        message.setBounds(350, 545, 600, 80);

        // Submit button
        submit = new JButton("Submit");
        submit.setBounds(875, 630, 76, 35);
        submit.setFont(new Font("Arial", Font.BOLD, 10));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFocusable(false);
        submit.addActionListener(this);

        // Search text field
        searchTf = new JTextField();
        searchTf.setForeground(Color.BLACK);
        searchTf.setFont(new Font("Arial", Font.PLAIN, 18));
        searchTf.setEditable(true);
        searchTf.setBounds(560, 10, 230, 40);
        searchTf.setBorder(BorderFactory.createLineBorder(LIGHT_BEIGE));
        searchTf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                searchTf.selectAll();
            }
        });
        searchTf.addActionListener(e -> {
            if (!searchTf.getText().equals("")) {
                MovieRequest.getMoviesByName(searchTf.getText());
                window.changePage(Page.Search);
            }
        });

        // Search label
        search = new JLabel("Search");
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Arial", Font.BOLD, 13));
        search.setBounds(500, 18, 100, 30);

        // Star rating dropdown
        String[] star = {"Rate", "1 - Bad", "2 - Poor", "3 - Fair", "4 - Very Good", "5 - Excellent"};
        starRate = new JComboBox<>(star);
        starRate.setFont(new Font("Arial", Font.BOLD, 14));
        starRate.setBounds(749, 520, 200, 20);
        starRate.setFocusable(false);
        starRate.setBackground(Color.WHITE);
        starRate.addActionListener(e -> currentRating = (String) starRate.getSelectedItem());

        // Prepopulate rating and comment
        for (UserData.MovieExternalData data : UserData.currentUser.getMovies()) {
            if (data.getTitle().equals(StateManager.currentMoviePoster.title)) {
                message.setText(data.getComments());
                starRate.setSelectedIndex(data.getRating());
            }
        }

        add(starRate);
        add(message);
        add(back);
        add(submit);
        add(play);
        desc = new JPanel();
        desc.setBounds(350, 200, 600, 200);
        desc.setOpaque(false);
        desc.setLayout(new FlowLayout(FlowLayout.LEFT));
        desc.add(synopsis);
        add(desc);
        add(title);
        add(rate);
        add(poster);
        add(search);
        add(searchTf);
        add(new TitleBar(window));
        add(background);


    }
}
