/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import iut.Game;
import iut.GameItem;

/**
 * Sprite d'une étoile de progression
 * @author miste
 */
public class Stars extends iut.GameItem {

    public Stars(Game g, double _x, double _y,String name) {
        super(g, name, _x, _y);
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
        return "Stars";
    }

    @Override
    public void evolve(long l) {
    }
    
}
