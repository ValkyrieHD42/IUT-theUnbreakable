/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import iut.Game;
import iut.GameItem;

/**
 * Fond animé pour écran d'accueil
 * @author miste
 */
public class FondMenu extends iut.GameItem  {
    private int frame;
    
    public FondMenu(Game g, int x, int y, String name) {
        super(g,name,x,y);
        this.frame = 133;
    }
    @Override
    public boolean isCollide(GameItem arg0) {
        return false;
    }

    @Override
    public void collideEffect(GameItem arg0) {
    }

    @Override
    public String getItemType() {
        return "fond";
    }
    
    /**
     * Pour chaque évolve, incrémente la frame et charge l'image
     * @param arg0 
     */
    @Override
    public void evolve(long arg0) {
        if(this.frame<492) {
            if(this.frame<10) {
                this.changeSprite("Menu/Fond/Fond000" + this.frame);
            }
            else if(this.frame<100) {
                this.changeSprite("Menu/Fond/Fond00" + this.frame);
            } else {
                this.changeSprite("Menu/Fond/Fond0" + this.frame);
            }
        } else {
            this.frame = 133;
            this.changeSprite("Menu/Fond/Fond0133");
        }
        this.frame++;
    }
    
}
