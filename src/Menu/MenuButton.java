/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import iut.Game;
import iut.GameItem;

/**
 * Bouton pour le menu principale
 * @author miste
 */
public class MenuButton extends iut.GameItem {
    private int frame;
    private TheMenu game;
    
    public MenuButton(TheMenu g, double _x, double _y,String name) {
        super(g, name, _x, _y);
        this.game = g;
        this.frame = 1;
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
        return "OptionButton";
    }

    @Override
    public void evolve(long l) {

    }
}
