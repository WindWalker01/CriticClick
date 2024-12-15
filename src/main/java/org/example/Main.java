package org.example;

import org.example.data.MovieRequest;
import org.example.data.UserData;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        UserData.allUsers =  UserData.loadUsersFromJson();

        MovieRequest request = new MovieRequest();

        CriticWindow window = new CriticWindow();

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UserData.allUsers.add(UserData.currentUser);
                UserData.saveUsersToJson(UserData.allUsers);
            }
        });
    }
}