/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.SpaceShips;

import iut.Game;
import theunbreakable.TheUnbreakable;

/**
 * Vaisseau ayant un mouvement horizontal
 * 1 = droite
 * 0 = gauche
 * @author miste
 */
public class HorizontalSpaceShip extends SpaceShip {
    
    public HorizontalSpaceShip(TheUnbreakable g, int x, int y,String nom, int dir) {
        super(g, nom, x, y);
        this.direction = dir;
    }

    /**
     * Bouge de gauche à droite,
     * Si il rencontre un obstacle, fait demie-tour
     * @param l 
     */
    @Override
    public void evolve(long l) {
        if(!this.game.isPause()) {
            if(this.getRight()>=1168 || this.getLeft() <=0) {
                if(this.direction == 0) {
                    this.direction = 1;
                } else {
                    this.direction = 0;
                }
            }
            if(direction == 1) {
                this.moveXY(0.50, 0);
                this.changeSprite("horizontalRight");
            } else {
                this.moveXY(-0.50, 0);
                this.changeSprite("horizontalLeft");
            }
        }
    }
    
}
