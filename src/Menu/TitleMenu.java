/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import iut.Game;
import iut.GameItem;

/**
 * Classe sprite du Logo du jeu
 * @author miste
 */
public class TitleMenu extends iut.GameItem {
    private int frame;
    private TheMenu game;
    
    public TitleMenu(TheMenu g, double _x, double _y,String name) {
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
        return "Title";
    }

    @Override
    public void evolve(long l) {

    }
}
