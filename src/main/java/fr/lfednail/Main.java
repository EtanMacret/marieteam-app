package fr.lfednail;

import fr.lfednail.frame.MainFrame;

public class Main {
    public static void main(String[] args){
        try{
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}