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

    public void affecterJeton(Jetons jetonCourant) {     // méthode permettant de ajouter le jeton en paramètre à la cellule
        this.jetonCourant = jetonCourant;
    }
    
    
    public String lireCouleurDuJeton(){//methode qui renvoie la couleur de la case ou si elle est vide
        if (jetonCourant==null){// si le jeton est null alors la case est vide 
            return "vide";
        }else{
            return jetonCourant.getCouleur();
           
        } 
    }
   
    
    public Jetons recupererJeton(){   // Cette méthode est 
//utilisée soit pour récupérer un jeton en cours de jeu, soit lorsqu’on vide la grille
//pour recommencer une partie 
        Jetons temporaire;
        temporaire = jetonCourant;
        jetonCourant = null;
        return temporaire;
        
    }
    public void placerTrouNoir(){//on met l'attribue AvoirTrouNoir egal à true 
        AvoirTrouNoir=true;
        
    }
    
    public void supprimerTrouNoir(){//on met l'attribu AvoirTrouNoir egal à false pour le supprimer
        AvoirTrouNoir=false;
    }
    
    public boolean presenceTrouNoir(){ //méthode qui renvoie true si un trou noir est présent dans la cellule et false sinon
        if(AvoirTrouNoir==true){
            return true;
        }else{
            return false;
        }
    }
    
    public void supprimerJeton(){//méthode permettant de supprimer un jeton si un desintégrateur est utilisé ou si le jeton est un sur un trou noir 
        jetonCourant=null;
    }
    
    public boolean presenceDesintegrateur(){//méthode qui renvoie true si un tdesintégrateur est présent dans la cellule et false sinon
        if(avoirDesintegrateur==true){
            return true;
        }else{
            return false;
        }
    }
    
    public void placerDesintegrateur(){//méthode qui place un désintégrateur dans la cellule
        avoirDesintegrateur=true;
    }
    
    public void supprimerDesintegrateur (){//méthode qui supprime un desintégrateur
        avoirDesintegrateur=false;
    }
    
    public void activerTrouNoir(){//on active le trou noir on supprime donc le jeton et le noir 
        supprimerJeton();//on appel la méthode supprimer jeton 
        supprimerTrouNoir();//on appel la méthode supprimer trou noir
        
    }

    @Override
    public String toString() {
        if(presenceJeton()==true){
            return jetonCourant.getCouleur();
        }
        if(presenceTrouNoir()==true){
            return "@";
        }
        if (presenceDesintegrateur()==true){
            return "D";
            
        }
        
        return ".";
        
    }
        
        
    
    
    
    
}
