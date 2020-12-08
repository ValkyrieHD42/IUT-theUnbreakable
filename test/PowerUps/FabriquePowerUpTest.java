/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import org.junit.Test;

import static org.junit.Assert.*;
import theunbreakable.TheUnbreakable;

/**
 *
 * @author Mathis Demonceaux
 */
public class FabriquePowerUpTest {
    
    public FabriquePowerUpTest() {
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
     * Test of FabriquePowerUp method, of class FabriquePowerUp.
     */
    @Test
   public void testFabriquePowerUp() {
        System.out.println("FabriquePowerUp");
        TheUnbreakable g = new TheUnbreakable(0, new int[0], 0);
        int x = 0;
        int y = 0;
        PowerUp expResult = new SpeedBoost(g,"Boost", x, y);
        PowerUp result = FabriquePowerUp.FabriquePowerUp(g, x, y,false);
        assertEquals(expResult.getItemType(), result.getItemType());
        // TODO review the generated test code and remove the default call to fail.
        
    }
}
