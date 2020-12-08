/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Boules;

import iut.Game;
import theunbreakable.TheUnbreakable;

/**
 * Classe d'une boule normale/classique
 * @author Martin
 */
public class BouleClassique extends Boule{
    
    public BouleClassique(TheUnbreakable g, int x, int y, String name, int life) {
        super(g, x, y, name, life);
        g.getBoules().add(this);
    }

    @Override
    public String getItemType() {
        return "Boule";
    }

    /**
     * Vérifie le nombre de vie qu'a la boule.
     * Si elle n'a plus de vie, supression de la boule
     * Sinon on fait respawn la boule en jeu
     */
    @Override
    public void checklife() {
         
        
           //getGame().remove(this);
           //getUnbreak().getBoules().remove(this);
           this.life--;
           System.out.println("vie : "+this.life);
            if (this.life > 0)
            {
                Boule balle = new BouleClassique(getUnbreak(),600,700,"Boule",life);
                getGame().remove(this);
                getUnbreak().getBoules().remove(this);
                getGame().addItem(balle);
                
                System.out.println("creation d'item");
            }
            if(this.life == 0 ){
                getGame().remove(this);
                getUnbreak().getBoules().remove(this);
                
            }
            
        }
    
    
}
