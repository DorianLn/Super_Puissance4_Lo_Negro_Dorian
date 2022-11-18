/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package super_puissance4_lo_negro;

/**
 *
 * @author doria
 */
public class PlateauDeJeu {
    CelluleDeGrille grille[][] = new  CelluleDeGrille[6][7];

    public PlateauDeJeu(){ //constructeur pour mettre les cellules du plateau à null
            
           for (int i=0; i<5 ; i++){
               for(int j=0 ; i<6 ; i++){
                   grille [i][j]=null;
               }
           }
    }

    
    
    
    
    
    
    
    
}
