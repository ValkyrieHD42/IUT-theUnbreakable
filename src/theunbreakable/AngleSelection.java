/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import iut.Game;
import iut.GameItem;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import theunbreakable.Boules.Boule;
import theunbreakable.Boules.BouleClassique;

/**
 * Classe de sélection des angles avant de lancer la partie
 * @author miste
 */
public class AngleSelection extends iut.GameItem implements KeyListener {
    private TheUnbreakable game;
    private boolean hasLaunch = false;
    private double angle;

    public AngleSelection(TheUnbreakable g, String name, double _x, double _y) {
        super(g, name, _x, _y);
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
        return "Angle Selection";
    }
    
    /**
     * La partie se met en pause si ce n'est pas le cas
     * Avec la souris on peut choisir son angle d'attaque
     * Modifie en même temps le sprite pour que la flèche s'aligne
     * @param l 
     */
    @Override
    public void evolve(long l) {
        if(!this.hasLaunch) {
            this.game.setPause();
        } else {
            this.game.unPause();
        }
        int x = MouseInfo.getPointerInfo().getLocation().x;
        if(x<=500) {
            this.changeSprite("start155");
            this.angle = 155;
        } else if(x<=600) {
            this.changeSprite("start135");
            this.angle = 135;
        } else if(x<=700) {
            this.changeSprite("start120");
            this.angle = 120;
        } else if(x<=850) {
            this.changeSprite("start65");
            this.angle = 65;
        } else if(x<=980) {
            this.changeSprite("start45");
            this.angle = 45;
        } else if(x>=1100) {
            this.changeSprite("start25");
            this.angle = 25;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * Quand on appuie sur Espace, la partie se lance avec
     * l'angle défini
     * @param e Touche appuyé
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_SPACE:
                 game.remove(this);
                game.unPause();
                this.hasLaunch = true;
                for(int i = 0;i<this.game.getBoules().size();i++) {
                    this.game.getBoules().get(i).setAngle(angle);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
