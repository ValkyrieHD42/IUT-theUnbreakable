/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Boules;

import org.junit.Test;
import static org.junit.Assert.*;
import theunbreakable.TheUnbreakable;

/**
 *
 * @author miste
 */
public class BouleClassiqueTest {
    
    public BouleClassiqueTest() {
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
     * Test of getItemType method, of class BouleClassique.
     */
    @Test
    public void testGetItemType() {
        System.out.println("getItemType");
        TheUnbreakable g = new TheUnbreakable(0, new int[0], 0);
        BouleClassique instance = new BouleClassique(g,725,690,"Boule",3);
        String expResult = "Boule";
        String result = instance.getItemType();
        assertEquals(expResult, result);
    }
    
}
