package org.example.pages;
import org.example.CriticWindow;
import org.example.Page;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loading extends CriticPage implements ActionListener {
    public JLabel loading;
    private Timer timer;
    private CriticWindow window;

    public Loading(CriticWindow window) {
        this.window = window;

        loading = new JLabel(new ImageIcon("src/main/resources/loading.gif"));
        loading.setBounds(530, 180, 200, 300);
        add(loading);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);

        if (b) {
            startTimer();
        } else {
            stopTimer();
        }
    }

    //timer
    private void startTimer() {
        if (timer == null || !timer.isRunning()) {
            timer = new Timer(2500, this);
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.changePage(Page.Home);
    }
}