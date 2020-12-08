/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Briques;

import iut.Audio;
import iut.Game;
import iut.GameItem;
import java.util.Date;
import theunbreakable.Impact;
import theunbreakable.TheUnbreakable;

/**
 * Classe d'une brique simple
 * @author Mathis Demonceaux
 */
public class BriqueSimple extends Brique{
    
    public BriqueSimple(TheUnbreakable g, int x, int y, String name) {
        super(g, x, y, name);
        this.setLife(2);
    }
    
    /**
     *Se supprimme au contacte de la balle 
     */
    @Override
    public void collideEffect(GameItem o){
        if(o.getItemType() == "Boule" || o.getItemType() == "Missile"){
            if(this.life >= 2) { // 3 correspond a la vie pour laquelle la balle a déjà rebondi dessus
                getGame().remove(this);
                Impact impact = new Impact(this.getGame(),this.getLeft()-100,this.getBottom()-48,"impact");
                new Audio("impact").start();
                this.getGame().addItem(impact);
                checkRemoveBrick(1);
            } else if(this.life < 2 ) {
                System.out.println("Brique a "+this.life );
                this.life+=1;
            }
        } else if(o.getItemType() == "Boule Perforante") {
            getGame().remove(this);
            new Audio("impact").start();
            checkRemoveBrick(1);
        }
    }
   
}
