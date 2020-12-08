/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import PowerUps.Missiles.LanceMissile;
import PowerUps.SpeedBoost;
import PowerUps.MoreBoule;
import PowerUps.PerforanteBoule;
import PowerUps.BigBoule;
import PowerUps.PowerUp;
import iut.Game;
import java.awt.PopupMenu;
import theunbreakable.TheUnbreakable;

/**
 * Fabrique de PowerUp
 * @author Mathis Demonceaux
 */
public class FabriquePowerUp {
    int type;
    
    /**
     * Fabrique pour créer des power up
     * @param g Jeu
     * @param x Position X
     * @param y Position Y
     * @return PowerUp
     */
    public static PowerUp FabriquePowerUp(TheUnbreakable g,int x,int y, boolean random) {
        int type;
        PowerUp fin=null;
        if(random) {
            type =(int)(Math.random()*8);
        } else {
            type = 0;
        }
        switch(type){
            case 0: 
                fin =new SpeedBoost(g,"Boost",x,y);
            break;
            case 1:
                fin=new MoreBoule(g,"Plus",x,y);
                break;
            case 2:
                fin=new BigBoule(g,"Big",x,y);
                break;
            case 3:
                fin =new PerforanteBoule(g,"Perf",x,y);
                break;
            case 4:
                fin = new LanceMissile(g,"lanceMissile",x,y);
                break;
            default : fin=null;
    }
        if(fin!=null){
            g.addItem(fin);
        }
        return fin;
    }
    
    
}
