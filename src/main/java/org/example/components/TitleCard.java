package org.example.components;

import org.example.CriticWindow;
import org.example.Page;
import org.example.components.primitives.WebImage;
import org.example.data.Movie;
import org.example.data.StateManager;
import org.example.pages.CriticPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TitleCard extends JPanel {

    public WebImage poster;
    public JLabel title;
    public JLabel year;
    private CriticWindow window;
    private Movie movieData;

    public TitleCard(Movie movie, CriticWindow window) {
        this.window = window;
        movieData = movie;
        setLayout(null);
        setSize(160, 60);
        setBackground(new Color(156, 134, 134));

        // Adding a black border to the TitleCard
      //  setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // 2px black border

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StateManager.currentMoviePoster = movieData;
                window.changePage(Page.Poster);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        // Add poster or default image
        if (!movie.posterPath.equals("null")) {
            poster = new WebImage("https://image.tmdb.org/t/p/w154" + movie.posterPath);
            poster.setBounds(14, 10, 150, 231); // Adjusted bounds to fit panel
            add(poster);
        } else {
            JLabel defaultImage = new JLabel(new ImageIcon("src/main/resources/defaultPoster-small.png"));
            defaultImage.setBounds(15, 10, 150, 231);
            add(defaultImage);
        }

        // Title Panel setup
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        titlePanel.setBounds(5, 205, getWidth() - 10, 50); // Adjusted height for title panel
        titlePanel.setOpaque(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;  // Allow the label to take the full width of the panel
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create the title label with HTML to allow word wrapping and centering
        title = new JLabel("<html><div style='text-align: center; word-wrap: break-word;'>" + movie.title + "</div></html>");
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        titlePanel.add(title, gbc);

        // Year Panel setup
        JPanel yearPanel = new JPanel();
        yearPanel.setLayout(new BorderLayout());
        yearPanel.setBackground(Color.LIGHT_GRAY);
        yearPanel.setBounds(5, 310, getWidth() - 10, 30);
        yearPanel.setOpaque(false); // Adjusted height for year panel

        year = new JLabel(movie.year.substring(0, 4), SwingConstants.CENTER);
        year.setFont(new Font("Arial", Font.ITALIC, 12));
        year.setHorizontalAlignment(SwingConstants.CENTER);
        yearPanel.add(year, BorderLayout.CENTER);

        // Center alignment of panels
        JPanel centeredPanels = new JPanel();
        centeredPanels.setLayout(new BoxLayout(centeredPanels, BoxLayout.Y_AXIS));
        centeredPanels.setOpaque(false); // Transparent background
        centeredPanels.setBounds(15, 235, getWidth() - 10, 80); // Adjust bounds to fit panels
        centeredPanels.add(titlePanel);
        centeredPanels.add(yearPanel);
        add(centeredPanels);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Cast to Graphics2D for more advanced drawing
        Graphics2D g2d = (Graphics2D) g;

        // Enable anti-aliasing for smoother drawing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the shadow color to black with higher opacity (alpha value 150)
        g2d.setColor(new Color(0, 0, 0, 150));  // More opaque shadow

        // Increase the offset to make the shadow more visible
        g2d.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 15, 15);  // Shadow with more offset

        // Create the main panel with rounded corners
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);  // Main panel with rounded corners

        // If you want to add a border with rounded corners
        g2d.setColor(CriticPage.LIGHT_BEIGE);
        g2d.setStroke(new BasicStroke(10));  // Set border thickness
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);  // Border with rounded corners
    }


}
