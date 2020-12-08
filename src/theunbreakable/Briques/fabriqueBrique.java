/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Briques;

import theunbreakable.Briques.BriqueRenforced;
import theunbreakable.Briques.BriqueSimple;
import theunbreakable.Briques.Brique;
import iut.Game;
import theunbreakable.TheUnbreakable;

/**
 * Fabrique de brique
 * @author Mathis Demonceaux
 */
public class fabriqueBrique {
   
    /**
     * A appeller lors de la fabrication de brique
     * @param g jeu
     * @param x position X
     * @param y position Y
     * @param brique nom de brique
     * @param couleur couleur
     * @return Brique
     */
   public static Brique fabriqueBrique(TheUnbreakable g, int x, int y, String brique, char couleur){
    Brique brick = null;
    switch(brique) {
        case "BriqueClassique":
            brick = new BriqueSimple(g,x,y,"Brique"+couleur);
            break;
        case "BriqueRenforced":
            brick = new BriqueRenforced(g,x,y,"BriqueRenforced");
            break;
        default:
            brick = new BriqueSimple(g,x,y,"Brique"+couleur);
            break;
    }
     return brick;
   }


   
    
}
