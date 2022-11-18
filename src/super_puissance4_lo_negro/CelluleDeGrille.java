/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package super_puissance4_lo_negro;

/**
 *
 * @author doria
 */
public class CelluleDeGrille {
    //création des différents attributs qui doivent être présenr dans cette classe
    private Jetons jetonCourant ; 
    private boolean AvoirTrouNoir ;
    private boolean avoirDesintegrateur ;

    public CelluleDeGrille(Jetons jetonCourant, boolean AvoirTrouNoir, boolean avoirDesintegrateur) {   //création d'un constructeur 
        this.jetonCourant = null;// initialement les cases du jeu ne comportent rien
        this.AvoirTrouNoir = false;
        this.avoirDesintegrateur = false;
    }
    
    public boolean presenceJeton(){   // création d'une méthode permettant de savoir si la case est vide ou non 
        if (jetonCourant==null){
            return false;
        }else{
            return true;
        }
    }

    public void setaffecterJeton(Jetons jetonCourant) { // méthode permettant de ajouter le jeton en paramètre à la cellule
        this.jetonCourant = jetonCourant;
    }

    

    

    

    
    
    
    
}
