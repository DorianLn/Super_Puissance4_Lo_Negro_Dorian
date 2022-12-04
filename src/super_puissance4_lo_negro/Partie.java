/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package super_puissance4_lo_negro;

import java.util.Scanner;

/**
 *
 * @author doria
 */
public class Partie {

    private Joueur[] listeJoueurs=new Joueur[2];// on créer les attributs demandés
    private Joueur joueurCourant;
    private PlateauDeJeu plateau;

 

    

    public Partie (Joueur joueur1,Joueur joueur2){ //création du constructeur de Partie 
        listeJoueurs[0]=joueur1;//on affecte les deux joueurs  dans le tableau listeJoueurs 
        listeJoueurs[1]=joueur2;
        plateau = new PlateauDeJeu();//on créer un nouveau plateau
    }

 

    

    public Joueur[] getListeJoueurs() {//méthode qui recupère la liste des joueurs 
        return listeJoueurs;
    }   

    public void attribuerCouleurAuxJoueurs(){//méthode qui affecte une couleur aux joueurs aléatoirement 

        int valeur=(int) (Math.random() * (2));
        if (valeur==0){
            listeJoueurs[0].affecterCouleur("rouge");//on affecte la couleur aux jouers avec la méthode affecter joueur
            listeJoueurs[1].affecterCouleur("jaune");
        }
        else{
            listeJoueurs[0].affecterCouleur("jaune");
            listeJoueurs[1].affecterCouleur("rouge");
        }
    }

 

    

    public void creerEtAffecterJeton(Joueur J1){//méthode qui créer 30 jetons et qui va les insérer dans le tableau de reserve du joueur 

        if ("rouge".equals(J1.getCouleurJ())){  // si la couleur rouge est égal à la coueur du joueur 1
            for (int i=0;i<31;i++){//alors on créer une boucle pour remplir la reserve du joueur de jeton rouge
                Jetons jeton=new Jetons ("rouge");
                J1.ajouterJeton(jeton);

            }         
        }

        if ("jaune".equals(J1.getCouleurJ())){//même chose pour la couleur jaune 

            for (int i=0;i<31;i++){
                Jetons jeton=new Jetons ("jaune");
                J1.ajouterJeton(jeton);
            }
        }
    }

 

    public void placerTrousNoirsEtDesintegrateurs(){//méthode qui place les trous noir et les desintégrateurs comme demandé

        int i=0;
        while (i<3){ //on place 2 desintégrateur et 2 trous noir comme demandé si il n'y a pas déjà des des trous noir ou désintégrateurs 
            int x=(int) (Math.random() * (9-3));
            int y=(int) (Math.random() * (8-3));
            if (plateau.presenceDesintegrateur(x,y)==false){
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerTrouNoir(x,y);
                    plateau.placerDesintegrateur(x,y);
                    i+=1;

                }
            }              
        }

        while (i<5){ //  On place trois  trous noir 

            int x=(int) (Math.random() * (9-3));

            int y=(int) (Math.random() * (8-3));

            if (plateau.presenceDesintegrateur(x,y)==false){

                if (plateau.presenceTrouNoir(x,y)==false){

                    plateau.placerTrouNoir(x,y);                  
                    i+=1;

                }
            }
        }

        while(i<7){//on place trois desintégrateur

            int x=(int) (Math.random() * (9-3));
            int y=(int) (Math.random() * (8-3));
            if (plateau.presenceDesintegrateur(x,y)==false){
                if (plateau.presenceTrouNoir(x,y)==false){
                    plateau.placerDesintegrateur(x,y);
                    i+=1;
                }

            }

        }

    }

 

   

    public void initialiserPartie(){//méthode qui initialise une partie 
        
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[1]);
        creerEtAffecterJeton(listeJoueurs[0]);
        placerTrousNoirsEtDesintegrateurs();
        plateau.afficherGrilleSurConsole();
        
    }

   

    public void lancerPartie(){//méthode qui lance une partie 
        
        
        int n=0;
        joueurCourant = listeJoueurs[0];
        
        while(plateau.GagnantePourCouleur(joueurCourant.getCouleurJ()) == false){
            
            
            if (n%2 == 0){
                joueurCourant = listeJoueurs[0];
                System.out.println("JOUEUR 1 : Si vous voulez jouer un jeton tapez '1', si vous voulez récupérer un jeton, tapez '2' et si vous voulez utiliser un désintegrateur, tapez'3'");
                Scanner reponse = new Scanner (System.in);
                int choix = reponse.nextInt();

                if (choix == 1){

                    int cln=10;

                    Scanner colonne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("Placer le jeton dans la colonne désirée");

                        cln = colonne.nextInt();

                    }
                    plateau.AjouterJetonDansColonnes(joueurCourant.jouerJeton(), cln-1);
                    n +=1;
                }
                if (choix == 2){
                    int cln=10;
                    int lgn=10;
                    Scanner colonne = new Scanner (System.in);
                    Scanner ligne = new Scanner (System.in);
                    
                    while (cln>7){
                        System.out.println("De quelle colonne voulez vous récupérer votre jeton");
                        cln = colonne.nextInt();
                    }
                    while (lgn>6){
                        System.out.println("De quelle ligne voulez vous récupérer votre jeton");
                        lgn = ligne.nextInt();
                    }                   
                    plateau.recupererJeton(lgn-1, cln-1);

                    n +=1;

                }

                if (choix == 3){

                    int cln=10;

                    int lgn=10;

                    if (joueurCourant.getNombreDesintegrateurs()==0){

                        System.out.println("Le joueur n'a pas de désintegrateurs");

                        continue;

                    }

                    Scanner colonne = new Scanner (System.in);

                    Scanner ligne = new Scanner (System.in);

                    while (cln>7){

                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");

                        cln = colonne.nextInt();

                    }
                    while (lgn>6){
                        System.out.println("Dans quelle ligne voulez vous placer votre jeton");
                        lgn = ligne.nextInt();
                    }
                    plateau.utiliserDesintegrateur(lgn-1, cln-1,joueurCourant);
                    n +=1;
                }              
            }
            if (n%2 == 1){
                joueurCourant = listeJoueurs[1];
                System.out.println("jOUEUR 2 :Que voulez vous faire, si vous voulez jouer un jeton tapez '1', si vous voulez récupérer un jeton, tapez '2' et si vous voulez utiliser un désintegrateur, tapez'3'");
                Scanner reponse = new Scanner (System.in);
                int choix = reponse.nextInt();
                if (choix == 1){
                    int cln=10;
                    Scanner colonne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("Dans quelle colonne voulez vous placer votre jeton");
                        cln = colonne.nextInt();
                    }
                    plateau.AjouterJetonDansColonnes(joueurCourant.jouerJeton(), cln-1);                  
                    n +=1;
                }
                if (choix == 2){
                    int cln=10;
                    int lgn=10;
                    Scanner colonne = new Scanner (System.in);
                    Scanner ligne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("De quelle colonne voulez vous récupérer votre jeton");
                        cln = colonne.nextInt();
                    }
                    while (lgn>6){

                        System.out.println("De quelle ligne voulez vous récuprer votre jeton");
                        lgn = ligne.nextInt();
                    }                 
                    plateau.recupererJeton(lgn-1, cln-1);
                    n +=1;
                }
                if (choix == 3){
                    int cln=10;
                    int lgn=10;
                    if (joueurCourant.getNombreDesintegrateurs()==0){
                        System.out.println("Le joueur n'a pas de désintegrateurs");
                        continue;
                    }
                    Scanner colonne = new Scanner (System.in);
                    Scanner ligne = new Scanner (System.in);
                    while (cln>7){
                        System.out.println("Dans quelle colonne voulez vous utiliser votre desintegrateur");
                        cln = colonne.nextInt();
                    }
                    while (lgn>6){
                        System.out.println("Dans quelle ligne voulez vous utiliser votre desintegrateur");
                        lgn = ligne.nextInt();
                    }
                    plateau.utiliserDesintegrateur(lgn-1, cln-1,joueurCourant);
                    n +=1;

                }              

                

            }       

        }

    }
}


