/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import iut.Game;
import iut.GameItem;
import java.util.ArrayList;
import theunbreakable.Boules.Boule;
import theunbreakable.TheUnbreakable;

/**
 * Power Up qui agrandi le taille des boules
 * @author Mathis Demonceaux
 */
public class BigBoule extends PowerUp{
    private TheUnbreakable game;
    
    public BigBoule(TheUnbreakable g, String name, int _x, int _y) {
        super(g, name, _x, _y);
        this.game = g;
    }

    @Override
    public String getItemType() {
        return "BigBoule";
    }

    /**
     * Récupère toutes les boules en jeux et les agrandi
     */
    @Override
    public void effet() {
        this.game.remove(this);
        for(int i = 0;i<this.game.getBoules().size();i++) {
            this.game.getBoules().get(i).changeSprite("BigBoule");
        }
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                for(int i = 0;i<game.getBoules().size();i++) {
                    if(game.getBoules().get(i).getItemType() == "Boule") {
                        game.getBoules().get(i).changeSprite("Boule");
                    }
                }
            }
        }, 
        3200);
    }

}
