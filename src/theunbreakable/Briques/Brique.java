/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Briques;

import PowerUps.FabriquePowerUp;
import iut.Game;
import iut.GameItem;
import java.util.Date;
import theunbreakable.TheUnbreakable;

/**
 * Classe abstraite d'une brique
 * @author Mathias
 * @author Mathis (v2)
 * @author Martin (refonte)
 */
public abstract class Brique extends iut.BoxGameItem {
    protected int life;
    private long bricksRemoveCooldown;
    private TheUnbreakable game;
    /**
     * @param g class Jeu actuel
     * @param x coordonée horizontal
     * @param y coordonée vertical
     * @param name  Nom de la classe
     */
    public Brique(TheUnbreakable g, int x, int y, String name) {
        super((Game) g,name,x,y);
        this.game = g;
    }

    @Override
    public String getItemType() {
        return "Brique";
    }

    @Override
    public void evolve(long l) {
    }
    
    public void setLife(int n) {
        this.life = n;
    }
    
    public TheUnbreakable getUnbreak() {
        return this.game;
    }
    
    /**
     * Timer qui permet de ne pas ajouter plusieurs fois des points au score
     * On calcul le temps entre le fois ou il est touché et la dernière fois
     * @param addScorePoint integer qui s'ajoute au score
     */
    public void checkRemoveBrick(int addScorePoint) {
        long currentRemove = new Date().getTime();
        if(currentRemove-this.bricksRemoveCooldown>300) {
            this.game.removeBrick();
            this.bricksRemoveCooldown = currentRemove;
            this.game.addScore(addScorePoint);
            this.game.displayScore();
            if(addScorePoint==2) {
                FabriquePowerUp.FabriquePowerUp(this.getUnbreak(), this.getMiddleX(), this.getMiddleY(),true);
            }
        }
    }
}