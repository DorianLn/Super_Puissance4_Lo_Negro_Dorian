/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package super_puissance4_lo_negro;

/**
 *
 * @author doria
 */
public class Super_Puissance4_LO_NEGRO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Jetons jeton1 = new Jetons("Jaune");//test du code pour voir si il retourne bien ce qui était demandé 
        System.out.println(jeton1);
        
        Jetons jeton2 = new Jetons("Rouge");
        System.out.println(jeton2);
        
        jeton2.getCouleur();
        
        
    }
    
}
