/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable;

import Menu.ActionList;
import PowerUps.PowerUp;
import iut.Vector;
import java.awt.Graphics;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import theunbreakable.Boules.Boule;

/**
 *
 * @author miste
 */
public class TheUnbreakableTest {
    
    public TheUnbreakableTest() {
    }
    
    /**
     * Test of getNumberPath method, of class TheUnbreakable.
     */
    @Test
    public void testGetNumberPath() {
        System.out.println("getNumberPath");
        char n = '5';
        TheUnbreakable g = new TheUnbreakable(0, new int[0], 0);
        String expResult = "nombres/5";
        String result = g.getNumberPath(n);
        assertEquals(expResult, result);
    }


    /**
     * Test of chargerNiveau method, of class TheUnbreakable.
     */
    @Test
    public void testChargerNiveau() {
        System.out.println("chargerNiveau");
        int lvl = 1;
        TheUnbreakable g = new TheUnbreakable(0, new int[0], 0);
        String[] tableaubrique = new String [10];
        tableaubrique[0]= "212121212121000";
        tableaubrique[1]= "222222222222000";
        tableaubrique[2]= "000000000000000";
        tableaubrique[3]= "000000000000000";
        tableaubrique[4]= "105673456700000";
        tableaubrique[5]= "105673456700000";
        tableaubrique[6]= "000000000000000";
        tableaubrique[7]= "000000000000000";
        tableaubrique[8]= "222222222222000";
        tableaubrique[9]= "212121212121000";
        
        String[] result = g.chargerNiveau(lvl);
        assertArrayEquals(tableaubrique, result);
    }

    
}
