/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.LevelMenu;

import Menu.ActionList;
import Menu.MenuButton;
import Menu.Selection;
import Menu.TheMenu;
import iut.Audio;
import iut.Game;
import iut.GameItem;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe de sélection du Level
 * @author martin
 */
public class LevelSelection extends iut.GameItem implements KeyListener {
    private TheMenu game;
    private int[] levels = new int[4];
    private Levels levelsItem;
    private ArrayList<Levels> stars = new ArrayList<>();
    private int x;
    private int y;
    
    public LevelSelection(TheMenu g, double _x, double _y, String name, Levels levelsitem) {
        super(g, name, _x, _y);
        this.game = g;
        this.levels = game.getLevels();
        this.levelsItem = levelsitem;
        loadLevels();
    }

    /**
     * Charge la progression sur chaque niveau
     */
    public void loadLevels() {
        for(int i = 1;i<=4;i++) {
            Levels newLevelProgress = checkProgressLevel(i);
            game.addItem(newLevelProgress);
        }
    }
    
    /**
     * Affiche la progression pour un level donné : Affiche les étoiles
     * @param level niveau actuel
     * @return Sprite 
     */
    public Levels checkProgressLevel(int level) {
        Levels levelSprite = new Levels(game, 750, 201, "");
        int score;
        switch(level) {
            case 1:
                score = this.levels[0];
                System.out.println("Score : " + score);
                if(score < 22) {
                    levelSprite.changeSprite("0star");
                } else if(score < 44) {
                    levelSprite.changeSprite("1star");
                } else if(score < 65) {
                    levelSprite.changeSprite("2star");
                } else {
                    levelSprite.changeSprite("3star");
                }
                break;
            case 2:
                score = this.levels[1];
                System.out.println("Score : " + score);
                levelSprite = new Levels(game, 750, 305, "");
                if(score<26) {
                    levelSprite.changeSprite("0star");
                } else if(score < 52) {
                    levelSprite.changeSprite("1star");
                } else if(score < 78) {
                    levelSprite.changeSprite("2star");
                } else {
                    levelSprite.changeSprite("3star");
                }
                break;
            case 3:
                score = this.levels[2];
                System.out.println("Score : " + score);
                levelSprite = new Levels(game, 750, 403, "");
                 if(score<37) {
                    levelSprite.changeSprite("0star");
                } else if(score < 74) {
                    levelSprite.changeSprite("1star");
                } else if(score < 110) {
                    levelSprite.changeSprite("2star");
                } else {
                    levelSprite.changeSprite("3star");
                }
                break;
            case 4:
                score = this.levels[3];
                System.out.println("Score : " + score);
                levelSprite = new Levels(game, 750, 500, "");
                if(score<51) {
                    levelSprite.changeSprite("0star");
                } else if(score < 102) {
                    levelSprite.changeSprite("1star");
                } else if(score < 153) {
                    levelSprite.changeSprite("2star");
                } else {
                    levelSprite.changeSprite("3star");
                }
                break;
        }
        this.stars.add(levelSprite);
        return levelSprite;
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
        return "Selector";
    }

    @Override
    public void evolve(long l) {
        if(x == 0) {
            switch(y) {
                case 0:
                    this.changeSprite("Menu/Level/level1_actif");
                    break;
                case 1:
                    this.changeSprite("Menu/Level/level2_actif");
                    break;
                case 2:
                    this.changeSprite("Menu/Level/level3_actif");
                    break;
                case 3:
                    this.changeSprite("Menu/Level/Level4_actif");
                    break;
                case 4:
                    this.changeSprite("Menu/Level/sauvegarder");
            }
        } else {
            this.changeSprite("Menu/Level/retour_actif");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * Change l'emplacement et le sprite de la sélection
     * Puis lance le niveau correspondant ou sauvegarde la progression
     * @param e Touche appuyé
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Y: " + y);
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if(y>0 && x==0){
                    new Audio("Menu/move_select").start();
                    this.moveXY(0, -98);
                    this.y--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(this.y<4 && x==0) {
                    new Audio("Menu/move_select").start();
                    this.moveXY(0, 98);
                    this.y++;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(this.x<1) {
                    new Audio("Menu/move_select").start();
                    switch(y) {
                        case 0:
                            this.moveXY(385, 374);
                            break;
                        case 1:
                            this.moveXY(385, 276);
                            break;
                        case 2:
                            this.moveXY(385, 178);
                            break;
                        case 3:
                            this.moveXY(385, 80);
                            break;
                        case 4:
                            this.moveXY(385, -18);
                            break;
                        }
                    this.x++;
                }
                break;
            case KeyEvent.VK_LEFT:
                if(this.x>0) {
                    new Audio("Menu/move_select").start();
                    switch(y) {
                        case 0:
                            this.moveXY(-385, -374);
                            break;
                        case 1:
                            this.moveXY(-385, -276);
                            break;
                        case 2:
                            this.moveXY(-385, -178);
                            break;
                        case 3:
                            this.moveXY(-385, -80);
                            break;
                        case 4:
                            this.moveXY(-385, 18);
                            break;
                        }
                    this.x--;
                }
                break;
            case KeyEvent.VK_ENTER:
                if(x==0) {
                    switch(y) {
                        case 0:
                            this.game.setLevel(1);
                            break;
                        case 1:
                            this.game.setLevel(2);
                            break;
                        case 2:
                            this.game.setLevel(3);
                            break;
                        case 3:
                            this.game.setLevel(4);
                            break;
                        case 4:
                            Save saving = new Save(this.levels,game.getCrystals());
                            saving.save();
                            break;
                    }
                    new Audio("Menu/select").start();
                    if(y<4) {
                        this.game.stop();
                        this.game.setVisible(false);
                        this.game.setAction(ActionList.PLAY);
                    } else {
                        JOptionPane.showMessageDialog(this.game, "Sauvegarde","Sauvegarde effectué", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    this.game.remove(this.levelsItem);
                    this.game.remove(this);
                    for(int i = 0;i<this.stars.size();i++) {
                        this.game.remove(this.stars.get(i));
                    }
                    MenuButton playButton = new MenuButton(this.game,440,230,"Menu/Jouer/Jouer1");
                    this.game.addItem(playButton);
                    MenuButton optionButton = new MenuButton(this.game,440,360,"Menu/Options/Options1");
                    this.game.addItem(optionButton);
                    MenuButton quittButton = new MenuButton(this.game,440,490,"Menu/Quitter/Quitter1");
                    this.game.addItem(quittButton);
                    Selection select = new Selection(this.game,440,230,"Menu/Jouer/Jouer1", quittButton, playButton, optionButton);
                    this.game.addItem(select);
                    }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
