/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import iut.Game;
import iut.GameItem;

/**
 * Sprite d'un impact/explosion
 * @author miste
 */
public class Impact extends iut.GameItem {
    private int frame=0;
    private String name;

    public Impact(Game g, double _x, double _y, String name) {
        super(g, name, _x, _y);
        this.name = name;
    }
    
    @Override
    public boolean isCollide(GameItem gi) {
        return false;
    }

    @Override
    public void collideEffect(GameItem gi) {
        
    }

    @Override
    public String getItemType() {
        return "Impact";
    }

    /**
     * Fait défilé les frame pour affiché l'animation
     * @param l 
     */
    @Override
    public void evolve(long l) {
        if(this.frame<8) {
            this.changeSprite(this.name+this.frame);
        } else {
            this.getGame().remove(this);
        }
        this.frame++;
    }
    
}
