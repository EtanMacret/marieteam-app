package fr.lfednail.Models;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.annotations.SerializedName;


import fr.lfednail.JsonWebRequest;

public class Boat {

    @SerializedName("id_Bateau")
    private int idBateau;

    @SerializedName("Nom_bateau")
    private String nomBateau;

    @SerializedName("Longueur_bateau")
    private int longueurBateau;

    @SerializedName("Largeur_bateau")
    private int largeurBateau;

    @SerializedName("Vitesse")
    private int speedBoat;

    @SerializedName("Places_passager")
    private int nbSeatBoat;

    @SerializedName("Places_vehicules_inf_5")
    private int nbVehicleInf5;

    @SerializedName("Places_vehicules_sup_5")
    private int nbVehicleSup5;

    // Getters and setters
    public int getIdBateau() {
        return idBateau;
    }

    public void setIdBateau(int idBateau) {
        this.idBateau = idBateau;
    }

    public String getNomBateau() {
        return nomBateau;
    }

    public void setNomBateau(String nomBateau) {
        this.nomBateau = nomBateau;
    }

    public int getLongueurBateau() {
        return longueurBateau;
    }

    public void setLongueurBateau(int longueurBateau) {
        this.longueurBateau = longueurBateau;
    }

    public int getLargeurBateau() {
        return largeurBateau;
    }

    public void setLargeurBateau(int largeurBateau) {
        this.largeurBateau = largeurBateau;
    }

    public int getSpeedBoat() {
        return speedBoat;
    }

    public void setSpeedBoat(int speedBoat) {
        this.speedBoat = speedBoat;
    }

    public int getNbSeatBoat() {
        return nbSeatBoat;
    }

    public void setNbSeatBoat(int nbSeatBoat) {
        this.nbSeatBoat = nbSeatBoat;
    }

    public int getNbVehicleInf5() {
        return nbVehicleInf5;
    }

    public void setNbVehicleInf5(int nbVehicleInf5) {
        this.nbVehicleInf5 = nbVehicleInf5;
    }

    public int getNbVehicleSup5() {
        return nbVehicleSup5;
    }

    public void setNbVehicleSup5(int nbVehicleSup5) {
        this.nbVehicleSup5 = nbVehicleSup5;
    }

    public static List<Boat> getAllBoat() throws Exception {
        try {
            String jsonString = JsonWebRequest.getRequest("https://marieteamnef.42web.io/api/boatCruise/GET");
            Gson gson = new Gson();
            return gson.fromJson(jsonString, new TypeToken<List<Boat>>(){}.getType());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Boat getBoatByID(int id) throws Exception {

        try {
            String jsonString = JsonWebRequest.getRequest("https://marieteamnef.42web.io/api/boatCruise/GET/" + id);
            Gson gson = new Gson();
            return gson.fromJson(jsonString, new TypeToken<Boat>(){}.getType());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Boat{" +
                "idBateau=" + idBateau +
                ", nomBateau='" + nomBateau + '\'' +
                ", longueurBateau=" + longueurBateau +
                ", largeurBateau=" + largeurBateau +
                ", speedBoat=" + speedBoat +
                ", nbSeatBoat=" + nbSeatBoat +
                ", nbVehicleInf5=" + nbVehicleInf5 +
                ", nbVehicleSup5=" + nbVehicleSup5 +
                '}';
    }
}
