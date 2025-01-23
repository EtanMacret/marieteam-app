package fr.lfednail;

import fr.lfednail.constants.Constants;
import fr.lfednail.database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private DatabaseConnection connection;

    public MainFrame() {
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setTitle("MarieTeam Application");

        connection = new DatabaseConnection(Constants.DATABASE_URL, Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);

        ArrayList<String> listBoatName = new ArrayList<>();
        listBoatName.add("");

        ///*
        try {

            Statement Statementstatement = connection.getConnection().createStatement();
            ResultSet resultSet = Statementstatement.executeQuery("SELECT Nom_bateau FROM bateau WHERE Type_bateau like 'Voyageur'");
            while(resultSet.next()){
                listBoatName.add(resultSet.getString("Nom_bateau"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // */

        JComboBox listOptionBoat = new JComboBox();
        for (String name : listBoatName) {
            listOptionBoat.addItem(name);
        }

        JTextField nameBoat = new JTextField(15);

        JTextField lengthBoat = new JTextField(15);
        JTextField widthBoat = new JTextField(15);

        JTextField speedBoat = new JTextField(15);

        JTextField nbSeatBoat = new JTextField(15);

        //Image imageBoat = new ImageIcon("C:/Users/etan.macret/Documents/marieteam-app/src/main/resources/boat.png").getImage();

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        contentPane.add(listOptionBoat);
        contentPane.add(nameBoat);
        contentPane.add(lengthBoat);
        contentPane.add(widthBoat);
        contentPane.add(speedBoat);
        contentPane.add(nbSeatBoat);


        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        connection.closeConnection();
                        System.exit(0);
                    }
                }
        );
    }
}
