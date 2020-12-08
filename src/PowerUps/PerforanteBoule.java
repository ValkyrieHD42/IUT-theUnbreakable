/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import iut.Game;
import iut.GameItem;
import theunbreakable.Boules.Boule;
import theunbreakable.Boules.BouleClassique;
import theunbreakable.Boules.BoulePerforante;
import theunbreakable.TheUnbreakable;

/**
 * PowerUp d'une boule perforante
 * @author Mathis Demonceaux
 */
public class PerforanteBoule extends PowerUp{
    private TheUnbreakable game;
    
    public PerforanteBoule(TheUnbreakable g, String name, int _x, int _y) {
        super(g, name, _x, _y);
        this.game = g;
    }

    @Override
    public String getItemType() {
        return "PerforanteBoule";
    }

    /**
     * Transforme la boule actuelle en une boule perforante qui transperce les briques
     */
    @Override
    public void effet() {
        // Position de la boule en jeu
        int x = this.game.getBoules().get(0).getMiddleX();
        int y = this.game.getBoules().get(0).getMiddleY();
        BoulePerforante boulePerfo = new BoulePerforante(this.game,x, y, "BoulePerf", 1);
        boulePerfo.setAngle(game.getBoules().get(0).getAngle());
        this.game.remove(this.game.getBoules().get(0));
        this.game.addItem(boulePerfo);
    }
    
}
