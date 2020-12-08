/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.LevelMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import theunbreakable.TheUnbreakable;

/**
 * Classe utilitaire pour sauvegarde
 * @author martin
 */
public class Save {
    private int[] score = new int[4];
    private int crystals = 0;
    
    /**
     * @param levels Niveaux
     * @param cryst crystal
     */
    public Save(int[] levels, int cryst) {
        score[0] = 0;
        score[1] = 0;
        score[2] = 0;
        score[3] = 0;
        this.score = levels;
        this.crystals = cryst;
    }
    
    /**
     * Lance la sauvgarde du niveau dans le save.txt
     * Ecrit dans un fichier chaque niveau et la quantité de crystal actuelle
     */
    public void save() {
        try {
        FileOutputStream file = new FileOutputStream("save.txt");
        String dataContent = "";
        for(Integer level : score) {
            dataContent += ":" + level;
            System.out.println("Ajout dans le fichier de : "+level);
        }
        
        dataContent += "/" + crystals;
        
        file.write(dataContent.getBytes());
        //file.write(dataContent.getBytes());
        } 
        catch(FileNotFoundException e) {
           
        } 
        catch(IOException e) {
            
        }
        
    }
    
    /**
     * Récupère les informations venant du save.txt
     * On effectue une série de split pour subdiviser chaque variables
     * et les affecté aux bonnes choses.
     */
    public void load() {
        try {
          File myObj = new File("save.txt");
          Scanner myReader = new Scanner(myObj);
          ArrayList<String> result = new ArrayList<>();
          String data = myReader.nextLine();
          myReader.close();
          if(data!=null) {
              String[] dat = data.split("/");
              String[] scores = dat[0].split(":");
              System.out.println(dat[0]);
              System.out.println(dat[1]);
              for(int i = 1;i<5;i++) {
                  System.out.println("score "+i+" : "+scores[i]);
                  score[i-1] = Integer.parseInt(scores[i]);
              }
              crystals = Integer.parseInt(dat[1]);
          }
          
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    /**
     * Renvoi le score
     * @return tableau des scores
     */
    public int[] getScore() {
        return score;
    }

    /**
     * Renvoi le crystal
     * @return Renvoi le crystal actuel
     */
    public int getCrystals() {
        return crystals;
    }
    
    public String toString() {
        String res = "";
        for(int i = 0;i<score.length;i++) {
            res+=this.score[i] + "\n";
        }
        res+="Crystals : " + this.crystals;
        
        return res;
    }

}
