/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import iut.Game;
import iut.GameItem;

/**
 * Background du jeu
 * @author marti
 */
public class Fond extends iut.GameItem {
    
    public Fond(Game g, int x, int y, String name) {
        super(g,name,x,y);
    }
    @Override
    public boolean isCollide(GameItem arg0) {
        return false;
    }

    @Override
    public void collideEffect(GameItem arg0) {
    }

    @Override
    public String getItemType() {
        return "Fond";
    }

    @Override
    public void evolve(long arg0) {
    }
    
}
