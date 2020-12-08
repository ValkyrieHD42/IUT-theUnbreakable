/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import iut.Game;
import iut.GameItem;

/**
 * Classe sprite d'un chiffre
 * @author miste
 */
public class Number extends iut.GameItem {

    public Number(Game g, double _x, double _y, String name) {
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
        return "Numnber";
    }

    @Override
    public void evolve(long l) {
        
    }
    
}
