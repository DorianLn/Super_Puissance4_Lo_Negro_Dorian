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

    
    public int AjouterJetonDansColonnes(Jetons jeton, int indice){
        
        for(int i =5; i>0 ; i++){
            if(grille[i][indice]==null){
                grille[i][indice].affecterJeton(jeton);//on ajoute le jeton dans la i ème ligne et la indice colonne 
                break;       
            }
        return i;
        }
        return 0;
        
        
            
    }
    
    public boolean grilleRemplie(){// on créer une méthode permettant de renvoyer false si la grille n'est pas pleine ou true si elle est pleine 
        for (int i=0; i<5 ; i++){
               for(int j=0 ; i<6 ; i++){
                  if( grille[i][j]==null){
                      break;
                  }
                  break;
                   
                   
               }
               return false;
           }
        return true;
    }
    
    
    public afficherGrilleSurConsole(){
        for (int i=0; i<5; i++){
            for(int j=0; j<6 ; j++){
                System.out.println();
            }
        }
        
    }
    
    
    
    
    
        
 }
    
    
    
    
    
    

