/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import static Menu.ActionList.PLAY;
import static Menu.ActionList.QUIT;
import iut.Audio;
import java.awt.Window;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import theunbreakable.TheUnbreakable;

/**
 *
 * @author miste
 */
public class main {
     public static void main(String[] args) {
         int[] levels = new int[5];
         int crystals = 0;
         for(int i = 0; i<levels.length;i++) {
             levels[i] = 0;
         }
         TheMenu menu = new TheMenu(levels,crystals);
         menu.getParent().getParent().getParent().getParent().setVisible(false);
         new Audio("Menu/menu").start();
         while(menu.getAction()!=ActionList.QUIT) {
            System.out.println("lance menu");
            menu = new TheMenu(levels,crystals);
            menu.getParent().getParent().getParent().getParent().setVisible(true);
            menu.play();
            if(menu.getAction() == ActionList.PLAY) {
                menu.getParent().getParent().getParent().getParent().setVisible(false);
                TheUnbreakable jeu = new TheUnbreakable(menu.getLevel(),levels,menu.getCrystals());
                jeu.play();
                jeu.getParent().getParent().getParent().getParent().setVisible(false);
                levels = jeu.getLevelScore();
                crystals = jeu.getCrystals();
            }
         }
         System.exit(0);
    }
}
