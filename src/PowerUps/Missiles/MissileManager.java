/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps.Missiles;

import iut.Game;
import iut.GameItem;
import theunbreakable.TheUnbreakable;

/**
 * Platforme de lancement de missile
 * @author miste
 */
public class MissileManager extends iut.GameItem{
    private TheUnbreakable game;

    public MissileManager(TheUnbreakable g) {
        super(g, "missileManager", g.getPlayer().getMiddleX(),710);
        this.game = g;
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
        return "Missile manager";
    }
    
    /**
     * Lance des missiles pour chaque evolve
     * @param l 
     */
    @Override
    public void evolve(long l) {
        int spawnX = this.game.getPlayer().getLeft()+7;
        int spawnX2 = this.game.getPlayer().getRight()-7;
        
        int moveX = this.game.getPlayer().getMiddleX() - this.getMiddleX();
        this.moveXY(moveX, 0);
        
        Missile missileGauche = new Missile(this.game,spawnX,this.getTop());
        Missile missileDroit = new Missile(this.game,spawnX2,this.getTop());
        game.addItem(missileGauche);
        game.addItem(missileDroit);
    }
    
}
