package org.example.pages;
import org.example.CriticWindow;
import org.example.components.TitleBar;
import org.example.components.primitives.WebImage;
import org.example.data.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Poster extends CriticPage implements ActionListener {

     JLabel title, year, rate, synopsis, bg, poster, search;
     JButton back, play, submit;
     JTextField message, searchTf;

     private CriticWindow window;

    public Poster(CriticWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void reloadPage() {
        removeAll();
        setBackground(CriticWindow.LIGHT_BEIGE);


        WebImage webImage =  new WebImage("https://image.tmdb.org/t/p/w342" + StateManager.currentMoviePoster.posterPath);
        ImageIcon originalIcon = (ImageIcon) webImage.getIcon();
        Image resizedImage = originalIcon.getImage().getScaledInstance(170, 250, Image.SCALE_SMOOTH);
        poster = new JLabel(new ImageIcon(resizedImage)); // Create a new JLabel with the resized image
        poster.setBounds(100, 150, 170,250);

        title = new JLabel(StateManager.currentMoviePoster.title);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setBounds(290,-50,1000,500);

        this.year = new JLabel(StateManager.currentMoviePoster.year.substring(0, 4));
        year.setForeground(Color.BLACK);
        year.setFont(new Font("Arial", Font.BOLD, 38));
        year.setBounds(450,-50 ,1000,500);

        synopsis = new JLabel(StateManager.currentMoviePoster.overview);
        synopsis.setForeground(Color.BLACK);
        synopsis.setFont(new Font("Arial", Font.PLAIN, 18));
        synopsis.setBounds(300,0 ,1000,500);

        play = new JButton("Play Trailer");
        play.setFont(new Font("Arial", Font.BOLD, 10));
        play.setForeground(Color.WHITE);
        play.setBackground(Color.BLACK);
        play.setFocusable(false);
        play.setBounds(300, 360 ,100,20);
        play.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(1100, 100, 76, 35);
        back.setFont(new Font("Arial", Font.BOLD, 10));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFocusable(false);
        back.addActionListener(this);

        rate = new JLabel("Rate this Movie");
        rate.setForeground(Color.BLACK);
        rate.setFont(new Font("Roboto", Font.BOLD, 18));
        rate.setBounds(310, 500, 200, 60);

        message = new JTextField();
        message.setForeground(Color.BLACK);
        message.setFont(new Font("Arial", Font.PLAIN, 18));
        message.setEditable(true);
        message.setBounds(310,545,600, 80);

        submit = new JButton("Submit");
        submit.setBounds(825, 630, 76, 35);
        submit.setFont(new Font("Arial", Font.BOLD, 10));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFocusable(false);
        submit.addActionListener(this);

        searchTf = new JTextField();
        searchTf.setForeground(Color.BLACK);
        searchTf.setFont(new Font("Arial", Font.PLAIN, 18));
        searchTf.setEditable(true);
        searchTf.setBounds(600,20,200, 25);
        searchTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        search = new JLabel("Search");
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Arial", Font.BOLD, 12));
        search.setBounds(550,18,100, 30);


        //salamat chatgpt
        bg = new WebImage("https://image.tmdb.org/t/p/w342" + StateManager.currentMoviePoster.backdropPath) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

                Image image = ((ImageIcon) this.getIcon()).getImage();
                Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                g2d.drawImage(scaledImage, 0, 0, this);

                g2d.dispose();
            }
        };
        bg.setBounds(0, 0, window.getWidth(), window.getHeight()-220);








        add(message);
        add(back);
        add(submit);
        add(play);
        add(synopsis);
        add(title);
        add(year);
        add(rate);
        add(poster);
        add(search);
        add(searchTf);
        add(new TitleBar(window));
        add(bg);
    }
}
