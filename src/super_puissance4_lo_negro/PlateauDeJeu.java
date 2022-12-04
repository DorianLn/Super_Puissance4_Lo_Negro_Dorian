/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package super_puissance4_lo_negro;

import java.util.Arrays;

/**
 *
 * @author doria
 */
public class PlateauDeJeu {
    CelluleDeGrille grille[][] = new  CelluleDeGrille[6][7];

    public PlateauDeJeu(){ //constructeur pour mettre les cellules du plateau à null
            
           for (int i=0; i<6 ; i++){
               for(int j=0 ; j<7 ; j++){
                   grille [i][j]=  new  CelluleDeGrille();
               }
           }
    }

    
    public int AjouterJetonDansColonnes(Jetons jeton, int indice){
        
        for(int i =5; i>=0 ; i--){
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
        for(int i=0; i<6;i++){
            for (int j=0;j<7;j++){
                grille[i][j].toString();
            }
        }
        
        
        
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
                if(lireCouleurDuJeton(i, j ).equals(Couleur)){//si la couleur de la case situé à une i ème ligne et j ème colonne est egale à la couleur  on ajoute 1 au compteur 
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
                if(lireCouleurDuJeton(j, i ).equals(Couleur)){//si la couleur de la case situé à une i ème colonne et j ème ligne est egale à la couleur  on ajoute 1 au compteur 
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
                if(lireCouleurDuJeton(i,j).equals(Couleur)){//on parcourt la première ligne jusqu'à la quatrième colonne 
                    a = i+1;//si la couleur est la bonne
                    b = j+1;//on avance d'une ligne et d'une colonne
                    if(lireCouleurDuJeton(a, b).equals(Couleur)){
                        a +=1;//même résonnement
                        b +=1;
                        if(lireCouleurDuJeton(a,b).equals(Couleur)){
                            a +=1;//idem
                            b +=1;
                            if(lireCouleurDuJeton(a,b).equals(Couleur)){
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
                if(lireCouleurDuJeton(i,j).equals(Couleur)){
                    a = i+1;
                    b = j-1;
                    if(lireCouleurDuJeton(a, b).equals(Couleur)){
                        a +=1;
                        b -=1;
                        if(lireCouleurDuJeton(a,b).equals(Couleur)){
                            a +=1;
                            b -=1;
                            if(lireCouleurDuJeton(a,b).equals(Couleur)){
                                
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
    
    public void tasserLigne(int ColonneIndi){//méthode permettant de tasser une ligne lorsqu'un jeton est supprimer
        for(int i=5; i>0 ;i--){//on parcourt les lignes de la colonne de bas en haut 
            if(grille[i][ColonneIndi]==null){//si la ligne de la colonne est null
                grille[i][ColonneIndi]=grille[i-1][ColonneIndi];//alors on invers la ligne du dessus avec la ligne actuelle 
                grille[i-1][ColonneIndi]=null;//et on met la ligne du dessus à null pour que la condition sur la ligne superieuir s'effectue
                
            }
        }   
    }
    
    
    public boolean GagnantePourCouleur(String Couleur){
        if(diagonaleMontanteGagnantePourCouleur( Couleur)==true || diagonaleDesencanteGagnantePourCouleur(Couleur)==true || colonneGagnantePourCouleur( Couleur)==true || ligneGagnantePourCouleur(Couleur)==true  ){
            return true;
        }else{
            return false;
        }
    }
    
    
    public boolean colonneRemplie(int C){
        if(grille[0][C]!=null){//si la derniere colonne n'est pas egal à null alors la colonne est remplie 
            return true;
        }else{
            return false;
        }
    }     
    
    public void placerTrouNoir(int x, int y){ //méthode permettant de placer un trou noir 
        grille[x][y].placerTrouNoir();
    }
    
    public void supprimerTrouNoir(int x, int y){//méthode permettant de supprimer un trou noir
        grille[x][y].supprimerTrouNoir();
    }
    
    public void placerDesintegrateur(int x, int y){//méthode permettant de placer un désintégrateur 
        grille[x][y].placerDesintegrateur();
    }
    
    public void supprimerDesintegrateur(int x, int y){//methode permettant de supprimer un désintégrateurbn
        grille[x][y].supprimerDesintegrateur();
    }
    
    public void supprimerjeton(int x, int y){//méthode permettant de supprimer un jeton à une,x ligne et y colonne 
        grille[x][y].supprimerJeton();
    }
    
    public void recupererJeton(int x, int y){//méthode permettant de récuperer un jeton à la x ligne et y colonne 
        grille[x][y].recupererJeton();
    }
    
    public void viderGrille(Joueur J1,Joueur J2){ //méthode qui permet de vider la grille
        String couleur;
        Jetons jeton;
        for(int i=0; i<6; i++){//on parcourt la grille à l'aide d'une double boucle
            for(int j=0; j<7; j++){
                if (grille[i][j].presenceJeton()==true){//si la grille contient un jeton 
                    jeton= grille[i][j].recupererJeton();//alors la variable jeton recupère le jeton de la case de la grille 
                    couleur = lireCouleurDuJeton(i,j);//et on prend la couleur du jeton 
                    if(J1.getCouleurJ()==couleur){//si la couleur du jeton correspond à la couleur du joueur
                        J1.ajouterJeton(jeton);//alors on donne le jeton au Joueur associé                    
                    }else{
                        J2.ajouterJeton(jeton);
                    }
                }
                if(grille[i][j].presenceTrouNoir()==true){
                    grille[i][j].supprimerTrouNoir();
                }if(grille[i][j].presenceDesintegrateur()){
                    grille[i][j].supprimerDesintegrateur();
                }
                
            }
        }
    }
    
    public boolean presenceDesintegrateur(int x, int y ){
        return grille[x][y].presenceDesintegrateur();
    }
    
    public boolean presenceTrouNoir(int x, int y){
        return grille[x][y].presenceTrouNoir();
    }
    
    public void utiliserDesintegrateur(int x, int y, Joueur joueur){
        grille[x][y].supprimerDesintegrateur();
        
    }
 }
    
    
    
    
    
    

