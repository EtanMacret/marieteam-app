package fr.lfednail;

import fr.lfednail.constants.Constants;
import fr.lfednail.database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class MainFrame extends JFrame {

    private final DatabaseConnection connection;

    private JLabel labelOptionBoat;
    private JComboBox listOptionBoat;
    private JLabel labelNameBoat;
    private JTextField nameBoat;
    private JLabel labelLengthBoat;
    private JTextField lengthBoat;
    private JLabel labelWidthBoat;
    private JTextField widthBoat;
    private JLabel labelSpeedBoat;
    private JTextField speedBoat;
    private JLabel labelNbSeatBoat;
    private JTextField nbSeatBoat;
    private Container contentPane;
    private SpringLayout layout;
    private JButton buttonUpdate = new JButton("Mettre à jour");

    public MainFrame() {
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setTitle("MarieTeam Application");

        connection = new DatabaseConnection(Constants.DATABASE_URL, Constants.DATABASE_USER, Constants.DATABASE_PASSWORD);

        ArrayList<String> listBoatName = new ArrayList<>();
        listBoatName.add("");

        try {
            Statement Statementstatement = connection.getConnection().createStatement();
            ResultSet resultSet = Statementstatement.executeQuery("SELECT Nom_bateau FROM bateau WHERE Type_bateau like 'Voyageur'");
            while(resultSet.next()){
                listBoatName.add(resultSet.getString("Nom_bateau"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        labelOptionBoat = new JLabel("Choisissez votre bateau : ");
        listOptionBoat = new JComboBox();
        for (String name : listBoatName) {
            listOptionBoat.addItem(name);
        }

        nameBoat = new JTextField(15);
        labelNameBoat = new JLabel("Nom du bateau : ");

        lengthBoat = new JTextField(15);
        labelLengthBoat = new JLabel("Longueur du bateau (en m): ");

        widthBoat = new JTextField(15);
        labelWidthBoat = new JLabel("Largeur du bateau (en m): ");

        speedBoat = new JTextField(15);
        labelSpeedBoat = new JLabel("Vitesse du bateau (en km/h): ");

        nbSeatBoat = new JTextField(15);
        labelNbSeatBoat = new JLabel("Nombre de places : ");

        //Image imageBoat = new ImageIcon("C:/Users/etan.macret/Documents/marieteam-app/src/main/resources/boat.png").getImage();

        //initialisation layout
        contentPane = getContentPane();
        layout = new SpringLayout();
        contentPane.setLayout(layout);

        //Option boat
        layout.putConstraint(SpringLayout.WEST, labelOptionBoat, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelOptionBoat, 10, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, listOptionBoat, 10, SpringLayout.EAST, labelOptionBoat);
        layout.putConstraint(SpringLayout.NORTH, listOptionBoat, 0, SpringLayout.NORTH, labelOptionBoat);

        //Name boat
        layout.putConstraint(SpringLayout.WEST, labelNameBoat, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelNameBoat, 30, SpringLayout.SOUTH, listOptionBoat);
        layout.putConstraint(SpringLayout.WEST, nameBoat, 10, SpringLayout.EAST, labelNameBoat);
        layout.putConstraint(SpringLayout.NORTH, nameBoat, 0, SpringLayout.NORTH, labelNameBoat);

        //Length boat
        layout.putConstraint(SpringLayout.WEST, labelLengthBoat, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelLengthBoat, 30, SpringLayout.SOUTH, nameBoat);
        layout.putConstraint(SpringLayout.WEST, lengthBoat, 10, SpringLayout.EAST, labelLengthBoat);
        layout.putConstraint(SpringLayout.NORTH, lengthBoat, 0, SpringLayout.NORTH, labelLengthBoat);

        //Width boat
        layout.putConstraint(SpringLayout.WEST, labelWidthBoat, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelWidthBoat, 30, SpringLayout.SOUTH, lengthBoat);
        layout.putConstraint(SpringLayout.WEST, widthBoat, 10, SpringLayout.EAST, labelWidthBoat);
        layout.putConstraint(SpringLayout.NORTH, widthBoat, 0, SpringLayout.NORTH, labelWidthBoat);

        //Speed boat
        layout.putConstraint(SpringLayout.WEST, labelSpeedBoat, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelSpeedBoat, 30, SpringLayout.SOUTH, widthBoat);
        layout.putConstraint(SpringLayout.WEST, speedBoat, 10, SpringLayout.EAST, labelSpeedBoat);
        layout.putConstraint(SpringLayout.NORTH, speedBoat, 0, SpringLayout.NORTH, labelSpeedBoat);

        //Nb seat boat
        layout.putConstraint(SpringLayout.WEST, labelNbSeatBoat, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelNbSeatBoat, 30, SpringLayout.SOUTH, speedBoat);
        layout.putConstraint(SpringLayout.WEST, nbSeatBoat, 10, SpringLayout.EAST, labelNbSeatBoat);
        layout.putConstraint(SpringLayout.NORTH, nbSeatBoat, 0, SpringLayout.NORTH, labelNbSeatBoat);

        //Update button
        layout.putConstraint(SpringLayout.WEST, buttonUpdate, 10, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, buttonUpdate, -10, SpringLayout.SOUTH, contentPane);

        //components
        contentPane.add(listOptionBoat);
        contentPane.add(nameBoat);
        contentPane.add(lengthBoat);
        contentPane.add(widthBoat);
        contentPane.add(speedBoat);
        contentPane.add(nbSeatBoat);
        contentPane.add(buttonUpdate);

        //labels
        contentPane.add(labelOptionBoat);
        contentPane.add(labelNameBoat);
        contentPane.add(labelLengthBoat);
        contentPane.add(labelWidthBoat);
        contentPane.add(labelSpeedBoat);
        contentPane.add(labelNbSeatBoat);

        //on close
        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        connection.closeConnection();
                        System.exit(0);
                    }
                }
        );

        //on change selection
        listOptionBoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //if deselection
                if(Objects.equals(listOptionBoat.getSelectedItem(), "")) {
                    nameBoat.setText("");
                    lengthBoat.setText("");
                    widthBoat.setText("");
                    speedBoat.setText("");
                    nbSeatBoat.setText("");
                    //imageBoat.setImage(null);
                }
                //if boat is selected
                else{
                    try {
                        Statement Statementstatement = connection.getConnection().createStatement();
                        ResultSet resultSet = Statementstatement.executeQuery("SELECT * FROM viewvoyageur WHERE Nom_bateau = '" + listOptionBoat.getSelectedItem() + "'");
                        while(resultSet.next()){
                            nameBoat.setText(Objects.requireNonNull(listOptionBoat.getSelectedItem()).toString());
                            lengthBoat.setText(resultSet.getString("Longueur_bateau"));
                            widthBoat.setText(resultSet.getString("Largeur_bateau"));
                            speedBoat.setText(resultSet.getString("Vitesse"));
                            nbSeatBoat.setText(resultSet.getString("Places"));
                            //imageBoat.setImage(new ImageIcon("C:/Users/etan.macret/Documents/marieteam-app/src/main/resources/boat.png").getImage());
                        }
                    } catch (Exception error) {
                        System.out.println(error.getMessage());
                    }
                }
            }
        });

        //on update
        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateData();
            }
        });
    }

    /**
     * Update data for database
     */
    public void updateData() {
        try {
            int lengthBoat = Integer.parseInt(this.lengthBoat.getText());
            int widthBoat = Integer.parseInt(this.widthBoat.getText());
            int speedBoat = Integer.parseInt(this.speedBoat.getText());
            int nbSeatBoat = Integer.parseInt(this.nbSeatBoat.getText());

            /*
            Statement Statementstatement = connection.getConnection().createStatement();
            Statementstatement.executeUpdate("UPDATE bateau SET Nom_bateau = '" + this.nameBoat.getText() + "', Longueur_bateau = " + lengthBoat + ", Largeur_bateau = " + widthBoat + ", Vitesse = " + speedBoat + ", Places = " + nbSeatBoat + " WHERE Nom_bateau = '" + this.listOptionBoat.getSelectedItem() + "'");
            //*/
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
