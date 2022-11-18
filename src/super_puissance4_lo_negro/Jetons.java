/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package super_puissance4_lo_negro;

/**
 *
 * @author doria
 */
public class Jetons {
    private String couleur;//création d'une variable couleur 

    public Jetons(String couleur) {// création du constructeur 
        this.couleur=couleur;    
    }

    public String getCouleur() {//création d'un getter pour retourner la couleur du jeton
        return couleur;
    }

    @Override
    public String toString() {
        if (couleur=="Rouge"){
            return "R";
        }else{
            if(couleur=="Jaune"){
                return "J";
            }
        }
        return "Jetons{" + '}';
    }
    
    
    
    
    
    
}
