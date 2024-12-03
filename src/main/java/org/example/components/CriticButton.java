package org.example.components;

import javax.swing.*;
import java.awt.*;

public class CriticButton extends JButton {

    private int _fontSize = 12;
    private String _fontFamily = "Roboto";
    private int _borderThickness = 1;
    private Color _borderColor = Color.BLACK;

    public CriticButton(String text) {
        setFont(new Font(_fontFamily, _fontSize, _fontSize));
        setBorder(BorderFactory.createLineBorder(_borderColor, _borderThickness, true)); // what the fuck meron palang rounded
        setText(text);
    }

    public void setFontColor(Color color){
        setForeground(color);
    }

    public void setFontSize(int size){
        _fontSize = size;
        setFont(new Font(_fontFamily, Font.PLAIN, _fontSize));
    }

    public void setFontFamily(String family){
        _fontFamily = family;
        setFont(new Font(_fontFamily, Font.PLAIN, _fontSize));
    }

    public void setFontFormat(int format){
        setFont(new Font(_fontFamily, format, _fontSize));
    }

    public void setBorderColor(Color color){
        _borderColor = color;
        setBorder(BorderFactory.createLineBorder(_borderColor, _borderThickness, true));

    }

    public void setBorderThickness(int thickness){
        _borderThickness = thickness;
        setBorder(BorderFactory.createLineBorder(_borderColor, _borderThickness, true));
    }
}
