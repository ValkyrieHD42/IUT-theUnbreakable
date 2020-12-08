/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import iut.Game;
import iut.GameItem;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe de la barre principale
 * @author mathis
 * @author mathias
 * @author martin
 */
public class Joueur extends iut.BoxGameItem implements KeyListener, MouseListener {
    private int direction;
    private int lastMouseX = MouseInfo.getPointerInfo().getLocation().x;
    private TheUnbreakable game;
    
    public Joueur(TheUnbreakable g, int x, int y) {
        super(g, "barre",x,y);
        this.game = g;
    }
    @Override
    public void collideEffect(GameItem arg0) {
    }

    @Override
    public String getItemType() {
        return "Joueur";
    }

    @Override
    public void evolve(long arg0) {
       if(this.game.getBoules().isEmpty()) {
            this.game.lost();
       }
       mouseTrigger();
    }

    /**
     * Déplace la barre en fonction de la position de la souris
     */
    public void mouseTrigger() {
        int x = MouseInfo.getPointerInfo().getLocation().x;
        if(x>this.lastMouseX) {
            if(this.getRight()<1158) {
                if(!game.isPause()) {
                    this.moveXY(x-lastMouseX, 0);
                }
            }
        } else if(x<this.lastMouseX) {
            if(this.getLeft()>0) {
                if(!game.isPause()) {
                    this.moveXY(-(lastMouseX-x), 0);
                }
            }
        }
        this.lastMouseX = x;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    /**
     * Déplace la barre en fonction des touches
     * @param e Touche appuyé
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                if(!this.game.isPause()) {
                    if(this.getLeft()>0)
                        this.moveXY(-15, 0);
                        if(direction>0) {
                            this.direction=0;
                        }
                        direction-=1;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(!this.game.isPause()) {
                    if(this.getRight()<1158)
                        this.moveXY(+15, 0);
                        if(direction<0) {
                            this.direction=0;
                        }
                        direction+=1;
                }
                break;
            case KeyEvent.VK_ESCAPE:
            {
                if(!this.game.isPause()) {
                    Pause pauseMenu = new Pause(game, 0, 0, "pause_resume");
                    this.game.addItem(pauseMenu);
                    this.game.setPause();
                }
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.direction=0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

}
