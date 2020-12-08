/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import iut.Game;
import iut.GameItem;
import theunbreakable.Boules.Boule;
import theunbreakable.TheUnbreakable;

/**
 * PowerUp d'un boost de vitesse
 * @author Mathis Demonceaux
 */
public class SpeedBoost extends PowerUp{
    private TheUnbreakable game;

    public SpeedBoost(TheUnbreakable g, String name, int _x, int _y) {
        super(g, name, _x, _y);
        this.game = g;
    }
    
    @Override
    public String getItemType() {
        return "SpeedBoule";
    }
    
    /**
     * Augmente la vitesse des boules puis l'enlève après env 3s
     */
    @Override
    public void effet() {
        for(Boule Balle: this.game.getBoules()){
           Balle.setVitesse(Balle.getVitesse()+0.1);
        }
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                for(Boule balle: game.getBoules()){
                   balle.setVitesse(balle.getVitesse()-0.1);
                }
            }
        }, 
        3000);
    }

}
