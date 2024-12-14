package org.example.pages;
import org.example.CriticWindow;
import org.example.Page;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Create extends CriticPage implements ActionListener {

    public JLabel CreateTitle;
    public JButton back;
    public JButton started;
    public JTextField email;
    public JTextField password;
    public JLabel banner;
    public CriticWindow window;

    public Create(CriticWindow window) {
        this.window = window;
        banner = new JLabel(new ImageIcon("src/main/resources/Banner.png"));
        banner.setBounds(835,  0,432,719);


        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(150, 430, 260, 50);
        back.setBackground(new Color(229, 225, 218));
        back.setForeground(new Color(121, 87,87));
        back.setBorder(new LineBorder(new Color(121, 87, 87), 2));
        back.addActionListener( this);
        back.setFocusable(false);

        started = new JButton("Get Started");
        started.setFont(new Font("Arial", Font.BOLD, 14));
        started.setBounds(450, 430, 260, 50);
        started.setForeground(Color.WHITE);
        started.setBackground(new Color(121, 87, 87));
        started.addActionListener( this);
        started.setFocusable(false);

        add(banner);
        add(started);
        add(back);



















        // TODO: remove this shit later this is for debugging purposes only
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                window.changePage(Page.Loading);
//            }
//        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == started) {
            window.changePage(Page.Loading);
        }

    }
}
