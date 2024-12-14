package org.example.pages;
import org.example.CriticWindow;
import org.example.Page;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Create extends CriticPage {

    public JButton createButton;
    public JButton signButton;
    public JLabel CriticLogo;
    public JLabel CriticTitle;
    public JLabel CriticSubTitle;
    public boolean signIn = false;
    public boolean createAcc = false;

    public Create(CriticWindow window) {



        // TODO: remove this shit later this is for debugging purposes only
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.changePage(Page.Home);
            }
        });

    }
}
