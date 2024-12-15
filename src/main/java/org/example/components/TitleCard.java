package org.example.components;

import org.example.CriticWindow;
import org.example.Page;
import org.example.data.Movie;
import org.example.data.StateManager;
import org.example.pages.CriticPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;

public class TitleCard extends JPanel {

    public JLabel poster;
    public JLabel title;
    public JLabel year;
    private CriticWindow window;
    private Movie movieData;

    public TitleCard(Movie movie, CriticWindow window) {
        this.window = window;
        movieData = movie;
        setLayout(null);
        setSize(160, 320);
        setBackground(new Color(156, 134, 134));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StateManager.currentMoviePoster = movieData;
                window.changePage(Page.Poster);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        // Add poster or default image with rounded corners
        Image image = loadImage(movie.posterPath);
        poster = createPosterLabel(image);
        poster.setBounds(13, 12, 153, 230); // Adjusted bounds to fit panel
        add(poster);

        // Title Panel setup
        JPanel titlePanel = createTitlePanel(movie.title);
        titlePanel.setBounds(5, 245, getWidth() - 10, 50);

        // Year Panel setup
        JPanel yearPanel = createYearPanel(movie.year);
        yearPanel.setBounds(5, 310, getWidth() - 10, 30);

        // Center alignment of panels
        JPanel centeredPanels = new JPanel();
        centeredPanels.setLayout(new BoxLayout(centeredPanels, BoxLayout.Y_AXIS));
        centeredPanels.setOpaque(false); // Transparent background
        centeredPanels.setBounds(15, 235, getWidth() - 10, 80);
        centeredPanels.add(titlePanel);
        centeredPanels.add(yearPanel);
        add(centeredPanels);
    }

    private Image loadImage(String posterPath) {
        try {
            if (!posterPath.equals("null")) {
                URL imageUrl = new URL("https://image.tmdb.org/t/p/w154" + posterPath);
                return new ImageIcon(imageUrl).getImage(); // Load image using ImageIcon
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle any errors gracefully
        }

        return new ImageIcon("src/main/resources/defaultPoster-small.png").getImage();
    }

    private JLabel createPosterLabel(Image image) {
        return new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Resize and draw the image with rounded corners
                BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D gImage = bufferedImage.createGraphics();
                gImage.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                gImage.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                gImage.dispose();
                Shape clip = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10);
                g2d.setClip(clip);
                g2d.drawImage(bufferedImage, 0, 0, null);
                g2d.dispose();
            }
        };
    }

    private JPanel createTitlePanel(String titleText) {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridBagLayout());
        titlePanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Allow the label to take the full width of the panel
        gbc.fill = GridBagConstraints.HORIZONTAL;

        title = new JLabel("<html><div style='text-align: center; word-wrap: break-word;'>" + titleText + "</div></html>");
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);

        titlePanel.add(title, gbc);
        return titlePanel;
    }

    private JPanel createYearPanel(String yearText) {
        JPanel yearPanel = new JPanel();
        yearPanel.setLayout(new BorderLayout());
        yearPanel.setBackground(Color.LIGHT_GRAY);
        yearPanel.setOpaque(false); // Transparent background

        year = new JLabel(yearText.substring(0, 4), SwingConstants.CENTER);
        year.setFont(new Font("Arial", Font.ITALIC, 12));
        year.setHorizontalAlignment(SwingConstants.CENTER);
        yearPanel.add(year, BorderLayout.CENTER);
        return yearPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 0, 0, 150));
        g2d.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 15, 15);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);  // Main panel with rounded corners
        g2d.setColor(CriticPage.LIGHT_BEIGE);
        g2d.setStroke(new BasicStroke(10));  // Set border thickness
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);  // Border with rounded corners
    }
}
