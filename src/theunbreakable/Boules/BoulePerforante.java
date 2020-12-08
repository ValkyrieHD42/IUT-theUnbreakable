/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Boules;

import iut.Game;
import iut.GameItem;
import theunbreakable.TheUnbreakable;

/**
 * Classe d'une boule perforante. Perfore les briques
 * @author Martin
 */
public class BoulePerforante extends Boule{
    
    public BoulePerforante(TheUnbreakable g, int x, int y, String name, int life) {
        super(g, x, y, name, life);
        g.getBoules().add(this);
    }

    @Override
    public String getItemType() {
        return "Boule Perforante";
    }
        
    @Override
    public void collideEffect(GameItem o){
        if (o.getItemType() == "Joueur") {
            bouncePlayer(o);
        } else if (o.getItemType() == "Boule" || o.getItemType() == "Boule Perforante"){
            bounceBoule(o);
        }
    }

    @Override
    public void checklife() {
         if(this.getBottom()>730)
        {
           getGame().remove(this);
           this.life--;
           System.out.println("vie : "+this.life);

            if (this.life > 0){
                Boule balle = new BouleClassique((TheUnbreakable) getGame(),600,500,"Boule",life);
                getGame().addItem(balle);
                System.out.println("creation d'item");
                if(this.life ==0)
                {
                    this.getUnbreak().remove(this);
                }     
            }
        }
    }
    
    
    
}
