/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import Menu.ActionList;
import Menu.TheMenu;
import iut.Audio;
import iut.Game;
import iut.GameItem;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import theunbreakable.TheUnbreakable;

/**
 * Classe pour mettre pause au jeu
 * @author miste
 */
public class Pause extends iut.GameItem implements KeyListener{
    private TheUnbreakable game;
    private int y = 0;

    public Pause(TheUnbreakable g, double _x, double _y, String name) {
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
        return "Pause";
    }

    @Override
    public void evolve(long l) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * Sélection de l'option
     * @param e Touche appuyé
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if(y>0){
                    new Audio("Menu/move_select").start();
                    this.changeSprite("pause_resume");
                    this.y--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(y<1) {
                    new Audio("Menu/move_select").start();
                    this.changeSprite("pause_quitt");
                    this.y++;
                }
                break;
            case KeyEvent.VK_ENTER:
                if(y == 0) {
                    this.game.remove(this);
                    game.unPause();
                } else if(y == 1) {
                    this.game.setAction(ActionList.PLAY);
                    this.game.stop();
                }
                break;
            case KeyEvent.VK_ESCAPE:
                this.game.remove(this);
                this.game.unPause();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
}
