/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tablajava;

import java.util.ArrayList;

/**
 *
 * @author gamba
 */
public class TablaJava {

    
    public static ArrayList<Animal>animales;
    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        animales = new ArrayList<>();
        
       Inicio ventana = new Inicio ();
       ventana.setVisible(true);
        
      
    }
}