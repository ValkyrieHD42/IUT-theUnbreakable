/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.LevelMenu;

import iut.Game;
import iut.GameItem;

/**
 * Sprite fond des niveaux
 * @author miste
 */
public class Levels extends iut.GameItem {

    public Levels(Game g, double _x, double _y, String name) {
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
        return "Levels";
    }

    @Override
    public void evolve(long l) {
        
    }
    
}
