/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.SpaceShips;

import theunbreakable.TheUnbreakable;

/**
 * Vaisseau ayant un mouvement vertical
 * 1 = Down
 * 0 = Up
 * @author miste
 */
public class VerticalSpaceShip extends SpaceShip {
    public VerticalSpaceShip(TheUnbreakable g, int x, int y,String nom, int dir) {
        super(g, nom, x, y);
        this.direction = dir;
    }
    
    /**
     * Bouge de haut en bas
     * Si il rencontre un obstacle, fait demie-tour
     * @param l 
     */
    @Override
    public void evolve(long l) {
        if(!this.game.isPause()) {
            if(this.getTop()<=0 || this.getBottom() >=700) {
                if(this.direction == 0) {
                    this.direction = 1;
                } else {
                    this.direction = 0;
                }
            }
            if(direction == 1) {
                this.moveXY(0, 0.50);
                this.changeSprite("verticalDown");
            } else {
                this.moveXY(0, -0.50);
                this.changeSprite("verticalUp");
            }
        }
    }
}
