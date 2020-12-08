/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.SpaceShips;

import iut.Audio;
import iut.Game;
import iut.GameItem;
import java.util.Date;
import theunbreakable.Impact;
import theunbreakable.TheUnbreakable;

/**
 * Classe abstraite de création de vaisseaux
 * @author martin
 */
public abstract class SpaceShip extends iut.BoxGameItem {
    protected int direction = 0;
    private long spaceShipRemoveCooldown;
    protected TheUnbreakable game;

    public SpaceShip(TheUnbreakable g, String nom, int x, int y) {
        super((Game) g, nom, x, y);
        this.game = g;
    }

    @Override
    public void collideEffect(GameItem gi) {
        if(gi.getItemType() == "Boule") {
            this.getGame().remove(this);
            Impact impact = new Impact(this.getGame(),this.getLeft()-100,this.getBottom()-48,"explosion");
            new Audio("explosion").start();
            this.getGame().addItem(impact);
            
            long currentRemove = new Date().getTime();
            if(currentRemove-this.spaceShipRemoveCooldown>300) {
                this.game.addScore(5);
                this.game.addCrystals(1);
                this.spaceShipRemoveCooldown = currentRemove;
                this.game.displayScore();
            }
        } else if(gi.getItemType() == "Brique") {
            if(this.direction == 0) {
                this.direction = 1;
            } else {
                this.direction = 0;
            }
        }
    }

    @Override
    public String getItemType() {
        return "StarShip";
    }
    
}
