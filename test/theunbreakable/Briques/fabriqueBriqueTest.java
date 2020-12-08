/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Briques;
import org.junit.Test;
import static org.junit.Assert.*;
import theunbreakable.TheUnbreakable;
import theunbreakable.TheUnbreakable;

/**
 *
 * @author miste
 */
public class fabriqueBriqueTest {
    
    public fabriqueBriqueTest() {
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
     * Test of fabriqueBrique method, of class fabriqueBrique.
     */
    @Test
    public void testFabriqueBrique() {
        System.out.println("fabriqueBrique");
        TheUnbreakable g = new TheUnbreakable(0, new int[0], 0);
        int x = 0;
        int y = 0;
        String brique = "BriqueClassique";
        char couleur = '5';
        Brique expResult = new BriqueSimple(g,x,y,"Brique5");
        Brique result = fabriqueBrique.fabriqueBrique(g, x, y, brique, couleur);
        assertEquals(expResult.getItemType(), result.getItemType());
   }
    
}
