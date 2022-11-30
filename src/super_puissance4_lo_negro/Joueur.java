/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package super_puissance4_lo_negro;

import java.util.ArrayList;

/**
 *
 * @author doria
 */
public class Joueur {
    private String nom;
    private String couleur;
    private ArrayList<Jetons> reserveJetons = new ArrayList<Jetons>();
    private int nombreDesintegrateurs;

    public Joueur(String nom, int nombreDesintegrateurs) {    //Constructeur de la classe Joueur
        this.nom = nom;
        this.nombreDesintegrateurs = nombreDesintegrateurs;
        nombreDesintegrateurs = 0;
    }
    
    public void affecterCouleur (String Joueur) {   //Méthode qui affecte à un joueur une couleur soit rouge soit jaune
        Joueur = couleur;
    }
    
    public int nombreDeJetons() {   //Méthode permettant d'obtenir le nombre de jeton disponible dans la réserve d'un joueur
        return reserveJetons.size();
    }
    
    public void ajouterJeton(Jetons nouveauJeton){   //méthode qui ajoute un jeton à la reserve d'un joueur
        reserveJetons.add(nouveauJeton);
    }
   
   
    public Jetons jouerJeton(){    //méthode permettant de retirer un jeton de la réserve du joueur et de renvoyer une référence vers le jeton retiré
       
        Jetons j = reserveJetons.remove(0);
        return j;
     
    }
    public void obtenirDesintegrateur() {   //méthode incrémente un desintégrateur
        nombreDesintegrateurs += 1;
    }
    public void utiliserDesintegrateur(){   //méthode decrémente un desintégrateur
        nombreDesintegrateurs -= 1;
    }

    public String getCouleurJ(){//méthode qui permet d'obtenir la couleur du joueur
        return couleur;
    }
    
    public int getNombreDesintegrateurs(){
        return nombreDesintegrateurs;
    }
}
