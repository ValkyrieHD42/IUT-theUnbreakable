/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Briques;

import PowerUps.FabriquePowerUp;
import iut.Audio;
import iut.Game;
import iut.GameItem;
import java.util.Random;
import theunbreakable.Impact;
import theunbreakable.TheUnbreakable;

/**
 * Classe d'une brique renforcé
 * @author martin
 */
public class BriqueRenforced extends Brique{
    
    public BriqueRenforced(TheUnbreakable g, int x, int y, String name) {
        super(g, x, y, name);
        this.setLife(0);
    }
    
    /**
     * A plusieurs vie, change son sprite quand elle perd une vie
     * puis se supprime
     * @param o 
     */
    @Override
    public void collideEffect(GameItem o){
        
        if(o.getItemType() == "Boule" || o.getItemType() == "Missile"){
            if(this.life >= 2) { // 3 correspond a la vie pour laquelle la balle a déjà rebondi dessus
                getGame().remove(this);
                new Audio("impact").start();
                Impact impact = new Impact(this.getGame(),this.getLeft()-100,this.getBottom()-48,"impact");
                this.getGame().addItem(impact);
                System.out.println("Brique a 2");
                checkRemoveBrick(2);
            } else if(this.life < 2 ) {
                System.out.println("Brique a "+this.life );
                this.life+=1;
                this.changeSprite("BriqueRenforced_2");
            } 
        } else if(o.getItemType() == "Boule Perforante") {
            getGame().remove(this);
            checkRemoveBrick(2);
        }
    }
}
