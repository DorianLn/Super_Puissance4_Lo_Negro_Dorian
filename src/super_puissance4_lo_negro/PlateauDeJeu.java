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
            
           for (int i=0; i<6 ; i++){
               for(int j=0 ; i<7 ; i++){
                   grille [i][j]=null;
               }
           }
    }

    
    public int AjouterJetonDansColonnes(Jetons jeton, int indice){
        
        for(int i =6; i>=0 ; i--){
            if(grille[i][indice]==null){
                grille[i][indice].affecterJeton(jeton);//on ajoute le jeton dans la i ème ligne et la indice colonne 
                break;       
            }
        return i;
        }
        return 0;
        
        
            
    }
    
    public boolean grilleRemplie(){// on créer une méthode permettant de renvoyer false si la grille n'est pas pleine ou true si elle est pleine 
        for (int i=0; i<6 ; i++){
               for(int j=0 ; i<7 ; i++){
                  if( grille[i][j]==null){
                      break;
                  }
                  break;
                   
                   
               }
               return false;
           }
        return true;
    }
    
    
    public void afficherGrilleSurConsole(){//méthode permettant d'afficher la grille
        grille.toString();
        
        
    }
    
    public boolean presenceJeton(int x, int y){//méthode permettant de savoir si il y a la présence d'une jeton dans une case de la grille
        return grille[x][y].presenceJeton();
    }
    
    public String lireCouleurDuJeton(int x, int y){// méthode qui renvoie la couleur du jeton dans la grille 
        return grille[x][y].lireCouleurDuJeton();
    }
    
    
    //partie pour savoir si quatre jetons sont alignés 
    
    
    public boolean ligneGagnantePourCouleur(String Couleur){
        int cpt=0;//on pose un compteur egal à 0
        for(int i=0; i<6; i++){//on effectu une double boucle pour parcourir toutes les colonnes de chaque ligne 
            for(int j=0; j<7; j++){
                if(lireCouleurDuJeton(i, j )==Couleur){//si la couleur de la case situé à une i ème ligne et j ème colonne est egale à la couleur  on ajoute 1 au compteur 
                    cpt +=1;
                    
                }
                if(cpt==4){//si le compteur atteint 4 alors il y a 4 couleur à la suite situé sur la i ème ligne 
                        break;//on arrete donc les boucles 
                    }
                else{
                    if(lireCouleurDuJeton(i, j )!=Couleur){//si la couleur n'est pas la bonne on remet le cpt à 0
                        cpt=0;
                    }
                }
            }
            if(cpt==4){
                break;
            }
            
        }
        if(cpt==4){
            return true;
        }else{
            return false;
        }
    }   
    
    public boolean colonneGagnantePourCouleur(String Couleur){
        int cpt=0;//on pose un compteur egal à 0
        for(int i=0; i<7; i++){//on effectu une double boucle pour parcourir toutes les colonnes de chaque ligne 
            for(int j=0; j<6; j++){
                if(lireCouleurDuJeton(j, i )==Couleur){//si la couleur de la case situé à une i ème colonne et j ème ligne est egale à la couleur  on ajoute 1 au compteur 
                    cpt +=1;
                    
                }
                if(cpt==4){//si le compteur atteint 4 alors il y a 4 couleur à la suite situé sur la i ème ligne 
                        break;//on arrete donc les boucles 
                    }
                else{
                    if(lireCouleurDuJeton(j, i )!=Couleur){//si la couleur n'est pas la bonne on remet le cpt à 0
                        cpt=0;
                    }
                }
            }
            if(cpt==4){
                break;
            }
            
        }
        if(cpt==4){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean diagonaleDesencanteGagnantePourCouleur(String Couleur){
        int a=0;//on initialise deux variables a e b 
        int b;
        for (int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if(lireCouleurDuJeton(i,j)==Couleur){//on parcourt la première ligne jusqu'à la quatrième colonne 
                    a = i+1;//si la couleur est la bonne
                    b = j+1;//on avance d'une ligne et d'une colonne
                    if(lireCouleurDuJeton(a, b)==Couleur){
                        a +=1;//même résonnement
                        b +=1;
                        if(lireCouleurDuJeton(a,b)==Couleur){
                            a +=1;//idem
                            b +=1;
                            if(lireCouleurDuJeton(a,b)==Couleur){
                                //si la couleur est 4 fois la bonne on arrete la boucle
                                a=5;
                                break;
                            }
                        }
                    }
                }
                
            }
            if(a==5){//si a =5 alors cela veut dire que l'on a 4 fois la même couleur
                    break;//on arrete la deuxième boucle
                }
        }
        if(a==5){
            return true;//on retourne true si a = 5
        }else{
            return false;
        }
        
    }
    
    public boolean diagonaleMontanteGagnantePourCouleur(String Couleur){
        int a=0;
        int b;
        for (int i=0; i<3; i++){
            for(int j=3; j<7; j++){
                if(lireCouleurDuJeton(i,j)==Couleur){
                    a = i+1;
                    b = j-1;
                    if(lireCouleurDuJeton(a, b)==Couleur){
                        a +=1;
                        b -=1;
                        if(lireCouleurDuJeton(a,b)==Couleur){
                            a +=1;
                            b -=1;
                            if(lireCouleurDuJeton(a,b)==Couleur){
                                
                                a=5;
                                break;
                            }
                        }
                    }
                }
                
            }
            if(a==5){
                    break;
                }
        }
        if(a==5){
            return true;
        }else{
            return false;
        }
    }
    
    public void tasserLigne(int ColonneIndi){
        for(int i=5; i>0 ;i--){
            if(grille[i][ColonneIndi]==null){
                grille[i][ColonneIndi]=grille[i+1][ColonneIndi];
                grille[i-1][ColonneIndi]=null;
                
            }
        }   
    }
    
    public boolean colonneRemplie(int C){
        if(grille[0][C]!=null){
            return true;
        }else{
            return false;
        }
    }     
    
    public void placerTrouNoir(int x, int y){
        grille[x][y].placerTrouNoir();
    }
    
    public void supprimerTrouNoir(int x, int y){
        grille[x][y].supprimerTrouNoir();
    }
    
    public void placerDesintegrateur(int x, int y){
        grille[x][y].placerDesintegrateur();
    }
    
    public void supprimerDesintegrateur(int x, int y){
        grille[x][y].supprimerDesintegrateur();
    }
    
    public void supprimerjeton(int x, int y){
        grille[x][y].supprimerJeton();
    }
    
    public void recupererJeton(int x, int y){
        grille[x][y].recupererJeton();
    }
 }
    
    
    
    
    
    

