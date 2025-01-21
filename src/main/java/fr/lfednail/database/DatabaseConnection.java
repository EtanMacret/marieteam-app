package fr.lfednail.database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public DatabaseConnection(){
        Connection connexion = null;
        try
        {
            Class.forName("org.gjt.mm.mysql.Driver");

            connexion = DriverManager.getConnection("jdbc:mysql://localhost/garageme", "root", "");
            JOptionPane.showMessageDialog(null, "Connexion OK!");

            connexion.setAutoCommit(false);
        }catch(ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Class introuvable :\t" + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connexion impossible :\t" + ex.getMessage());
        } finally {
            try {
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        System.exit(0);
    }
}
