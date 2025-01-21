package fr.lfednail;

import fr.lfednail.constants.Constants;
import fr.lfednail.database.DatabaseConnection;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);

        DatabaseConnection connection = new DatabaseConnection(Constants.DATABASE_URL, Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);

        mainFrame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        connection.closeConnection();
                        System.exit(0);
                    }
                }
        );
    }
}