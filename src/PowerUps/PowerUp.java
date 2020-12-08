/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import iut.BoxGameItem;
import iut.Game;
import iut.GameItem;
import theunbreakable.TheUnbreakable;

/**
 * Classe abstraite de PowerUp
 * @author Mathis Demonceaux
 */
public abstract class PowerUp extends BoxGameItem{
    protected TheUnbreakable game;
    private double vitesse;
    
    public PowerUp(TheUnbreakable g, String name, int _x, int _y) {
        super(g,name,_x,_y);
        this.game = g;
        this.vitesse = 0.5;
        this.game.getPowerUp().add(this);
    }

    /**
     * Descend lentement
     * puis se supprime en dehors des limites
     * @param l 
     */
    @Override
    public void evolve(long l) {
        this.moveXY(0, vitesse);
        if(this.getTop()>804) {
            this.game.remove(this);
        }
    }
    public abstract void effet();
    
    public TheUnbreakable getUnbreak() {
        return this.game;
    }
    
    public void setVitesse(double v) {
        this.vitesse = v;
    } 
    
    /**
     * Se supprime au contact de la barre
     * @param o 
     */
    @Override
    public void collideEffect(GameItem o) {
         if(o.getItemType() == "Joueur"){
           this.game.remove(this);
           System.out.println("Activation d'une nouvel Boule"); 
           this.effet();
        }
    }
    
}
