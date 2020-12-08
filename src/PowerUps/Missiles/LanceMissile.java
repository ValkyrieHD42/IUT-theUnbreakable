/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps.Missiles;

import PowerUps.PowerUp;
import theunbreakable.TheUnbreakable;

/**
 * PowerUp d'un lance missile
 * @author miste
 */
public class LanceMissile extends PowerUp {

    public LanceMissile(TheUnbreakable g, String name, int _x, int _y) {
        super(g, name, _x, _y);
    }

    /**
     * Créer une platforme qui lance des missiles
     * Se retire après utilisation
     */
    @Override
    public void effet() {
        MissileManager lanceMissile = new MissileManager(this.game);
        this.game.addItem(lanceMissile);
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                game.remove(lanceMissile);
            }
        }, 
        400
    );
    }

    @Override
    public String getItemType() {
        return "Lance missile";
    }
    
}
