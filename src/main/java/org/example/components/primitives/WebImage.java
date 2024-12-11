package org.example.components.primitives;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebImage extends JLabel {

    public String url;
    private ImageIcon icon;

    public WebImage(String url) {
        this.url = url;

        try {
            URL imageUrl = new URL(url);
            BufferedImage image = ImageIO.read(imageUrl);

            icon = new ImageIcon(image);
            setIcon(icon);

        }  catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
