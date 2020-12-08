/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import iut.GameItem;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import org.junit.Test;
import static org.junit.Assert.*;
import theunbreakable.Boules.Boule;
import theunbreakable.Boules.BouleClassique;

/**
 *
 * @author miste
 */
public class JoueurTest {
    
    public JoueurTest() {
    }
    
    
    public static void setUpClass() {
    }
    
    
    public static void tearDownClass() {
    }
    
    
    public void setUp() {
    }
    
   
    public void tearDown() {
    }

    /**
     * Test of collideEffect method, of class Joueur.
     */
    @Test
    public void testCollideEffect() {
        System.out.println("collideEffect");
        TheUnbreakable g = new TheUnbreakable(0, new int[0], 0);
        Boule balle = new BouleClassique(g,0,0,"Boule",3);
        balle.setAngle(135);
        Joueur instance = new Joueur(g, 0, 0);
        instance.collideEffect(balle);
        int expResult = 135;
         assertEquals(expResult, balle.getAngle(),0.1);
        
    }

    /**
     * Test of getItemType method, of class Joueur.
     */
    @Test
    public void testGetItemType() {
        System.out.println("getItemType");
        
        TheUnbreakable g = new TheUnbreakable(0, new int[0], 0);
        Joueur instance = new Joueur(g, 0, 0);
        String expResult = "Joueur";
        String result = instance.getItemType();
        assertEquals(expResult, result);
    }
    
}
