package fr.lfednail;

import fr.lfednail.Models.Boat;

public class Main {
    public static void main(String[] args){
        try{
            System.out.println(Boat.getAllBoat());
            System.out.println(Boat.getBoatByID(1));
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}