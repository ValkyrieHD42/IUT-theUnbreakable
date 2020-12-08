/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps.Missiles;

import iut.Game;
import iut.GameItem;

/**
 * Item correspondant au tir d'un lance missile
 * @author miste
 */
public class Missile extends iut.BoxGameItem {

    public Missile(Game g, int x, int y) {
        super(g, "missile", x, y);
    }

    /**
     * Au contact d'une brique se supprime
     * @param gi 
     */
    @Override
    public void collideEffect(GameItem gi) {
        if(gi.getItemType() == "Brique") {
            this.getGame().remove(this);
        }
    }

    @Override
    public String getItemType() {
        return "Missile";
    }
    
    /**
     * Va en direction du ciel jusqu'a se supprimer en dehors du cadre
     * @param l 
     */
    @Override
    public void evolve(long l) {
        this.moveXY(0, -5);
        if(this.getTop()<=0) {
            this.getGame().remove(this);
        }
    }
    
}
