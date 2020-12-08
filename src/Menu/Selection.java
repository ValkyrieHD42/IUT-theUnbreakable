/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Menu.LevelMenu.LevelSelection;
import Menu.LevelMenu.Save;
import Menu.LevelMenu.Levels;
import iut.Audio;
import iut.Game;
import iut.GameItem;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import theunbreakable.TheUnbreakable;

/**
 * Bouton sélecteur
 * @author miste
 */
public class Selection extends iut.GameItem implements KeyListener {
    private int x;
    private int y;
    private TheMenu game;
    private MenuButton quitt;
    private MenuButton play;
    private MenuButton button;
    
    public Selection(TheMenu g, double _x, double _y, String name, MenuButton quit, MenuButton pl, MenuButton butt) {
        super(g, name, _x, _y);
        this.game = g;
        this.quitt = quit;
        this.play = pl;
        this.button = butt;
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
        return "Selection";
        
    }

    /**
     * Change le sprite en fonction de sa position
     * @param l 
     */
    @Override
    public void evolve(long l) {
        switch(y) {
            case 0:
                this.changeSprite("Menu/Jouer/Jouer_actif");
                break;
            case 1:
                this.changeSprite("Menu/Options/Options_actif");
                break;
            case 2:
                this.changeSprite("Menu/Quitter/Quitter_actif");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * Modifie sa position en fonction des touches :
     * UP décrémente y
     * DOWN incrémente y
     * @param e Touche appuyé
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Y: " + y);
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if(y>0){
                    new Audio("Menu/move_select").start();
                    this.moveXY(0, -130);
                    this.y--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(this.y<2) {
                    new Audio("Menu/move_select").start();
                    this.moveXY(0, 130);
                    this.y++;
                }
                break;
            case KeyEvent.VK_ENTER:
                if(this.y == 0) {
                    Levels levels = new Levels(this.getGame(),0,0,"Menu/Level/levels");
                    LevelSelection select = new LevelSelection(this.game,437,199,"Menu/Level/level1_actif",levels);
                    this.getGame().remove(this.button);
                    this.getGame().remove(this.play);
                    this.getGame().remove(this.quitt);
                    this.getGame().addItem(levels);
                    this.getGame().addItem(select);
                    this.getGame().remove(this);
                } else if(this.y == 1) {
                    Save loading = new Save(new int[4],0);
                    loading.load();
                    this.game.setLevels(loading.getScore());
                    this.game.setCrystals(loading.getCrystals());
                    JOptionPane.showMessageDialog(this.game, "Vous avez chargé une sauvegarde","Chargement", JOptionPane.INFORMATION_MESSAGE);
                    
                } else if(this.y == 2) {
                    new Audio("Menu/select").start();
                    this.getGame().stop();
                    this.game.setAction(ActionList.QUIT);
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
