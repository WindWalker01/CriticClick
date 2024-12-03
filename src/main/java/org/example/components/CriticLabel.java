package org.example.components;

import javax.swing.*;
import java.awt.*;

public class CriticLabel extends JLabel {

    private int _fontSize = 12;
    private String _fontFamily = "Roboto";

    public CriticLabel(String text) {
        setText(text);
        setFont(new Font(_fontFamily, Font.PLAIN, _fontSize));

        setBounds(0, 0, 50, 20);
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
}
