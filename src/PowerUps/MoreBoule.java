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
 * PowerUp qui rajoute des boules
 * @author Mathis Demonceaux
 */
public class MoreBoule extends PowerUp{
    private TheUnbreakable game;
    
    public MoreBoule(TheUnbreakable g, String name, int _x, int _y) {
        super(g, name, _x, _y);
        this.game = g;
    }
    
    /**
     * Ajotue une boule
     */
    @Override
    public void effet() {
        BouleClassique balle = new BouleClassique(this.game,725,690,"Boule",1);
        this.game.addItem(balle);
        
    }

    @Override
    public String getItemType() {
        return "MoreBoule";
    }
}

  
 


