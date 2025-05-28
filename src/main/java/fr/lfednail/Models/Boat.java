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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Boat {

    @SerializedName("id_Bateau")
    private int idBateau;

    @SerializedName("Nom_bateau")
    private String nomBateau;

    @SerializedName("Longueur_bateau")
    private int longueurBateau;

    @SerializedName("Largeur_bateau")
    private int largeurBateau;

    @SerializedName("Type_bateau")
    private String typeBateau;

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

    public String getTypeBateau() {
        return typeBateau;
    }

    public void setTypeBateau(String typeBateau) {
        this.typeBateau = typeBateau;
    }

    public static List<Boat> getAllBoat() throws Exception {
        try {
            String jsonString = JsonWebRequest.getRequest("https://marieteamnef.42web.io/api/boat/GET");
            Gson gson = new Gson();
            return gson.fromJson(jsonString, new TypeToken<List<Boat>>(){}.getType());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Boat getBoatByID(int id) throws Exception {

        try {
            String jsonString = JsonWebRequest.getRequest("https://marieteamnef.42web.io/api/boat/GET/" + id);
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
                ", longueurBateau=" + longueurBateau +
                ", largeurBateau=" + largeurBateau +
                ", nomBateau='" + nomBateau + '\'' +
                ", typeBateau='" + typeBateau + '\'' +
                '}';
    }
}
