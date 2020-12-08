/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Boules;

import iut.GameItem;
import org.junit.Test;
import static org.junit.Assert.*;
import theunbreakable.TheUnbreakable;

/**
 *
 * @author miste
 */
public class BoulePerforanteTest {
    
    public BoulePerforanteTest() {
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
     * Test of getItemType method, of class BoulePerforante.
     */
    @Test
    public void testGetItemType() {
        System.out.println("getItemType");
        TheUnbreakable g = new TheUnbreakable(0, new int[0], 0);
        BoulePerforante instance = new BoulePerforante(g,725,690,"Boule Perforante",3);
        String expResult = "Boule Perforante";
        String result = instance.getItemType();
        assertEquals(expResult, result);
    }
}
