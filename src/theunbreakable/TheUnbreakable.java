package theunbreakable;

import theunbreakable.SpaceShips.VerticalSpaceShip;
import theunbreakable.SpaceShips.HorizontalSpaceShip;
import theunbreakable.Briques.Brique;
import theunbreakable.Boules.BouleClassique;
import theunbreakable.Boules.Boule;
import Menu.ActionList;
import Menu.LevelMenu.Save;
import PowerUps.PowerUp;
import iut.Game;
import iut.GameItem;
import iut.Vector;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static theunbreakable.Briques.fabriqueBrique.fabriqueBrique;

/**
 * Class du Jeu, prends en paramètre le niveau à charger
 * et les données à transférer
 * @author mathis
 * @author mathias
 * @author martin
 */
public class TheUnbreakable extends iut.Game {
    private Joueur player;
    private int score = 0;
    private int crystals;
    private int bricks = 0;
    private int level;
    private Stars progression;
    private Boolean pause;
    //Affichage Score
    private Number nb0;
    private Number nb1;
    private Number nb2;
    private Number nb3;
    // Affichagr des crystaux
    private Number cryst1;
    private Number cryst2;
    // Pause
    private ArrayList<Boule> boules = new ArrayList<>();
    private ArrayList<Double> vitesseBoules = new ArrayList<>();
    private ArrayList<PowerUp> powerUps = new ArrayList<>();
    // Sauvegarde & retour
    private ActionList retour;
    private int[] LevelScore = new int[4];
    

    /**
     * Constructeur jeu
     * @param lvl niveau actuel
     * @param levels scores précédent
     * @param crystals cristaux
     */
    public TheUnbreakable(int lvl, int[] levels, int crystals) {
        super(1503,770,"The Unbreakable");
        this.requestFocusInWindow();
        this.level = lvl;
        this.pause = false;
        this.LevelScore = levels;
        this.crystals = crystals;
    }

    /**
     * Renvoi le nombre de crystaux
     * @return integer
     */
    public int getCrystals() {
        return crystals;
    }

    /**
     * Ajoute un ou plusieurs crystaux
     * @param crystals cristaux
     */
    public void addCrystals(int crystals) {
        this.crystals += crystals;
    }
    
    /**
     * Renvoi le score de chaque niveau
     * @return Tableau integer des scores
     */
    public int[] getLevelScore() {
        return LevelScore;
    }

    /**
     * Renvoi vrai si le jeu est en pause
     * @return boolean
     */
    public boolean isPause() {
        return this.pause;
    }
    
    /**
     * Met le jeu en pause :
     * Freeze tout les items en jeux
     */
    public void setPause() {
        this.pause = true;
        for(int i = 0;i<this.getBoules().size();i++) {
            System.out.println("Boule n "+i);
            vitesseBoules.add(boules.get(i).getVitesse());
            this.getBoules().get(i).setVitesse(0);
        }
        for(int i = 0;i<this.powerUps.size();i++) {
            this.powerUps.get(i).setVitesse(0);
        }
    }
    
    /**
     * Enlève le menu de pause
     */
    public void unPause() {
        this.pause = false;
        for(int i = 0;i<this.getPowerUp().size();i++) {
            this.powerUps.get(i).setVitesse(0.3);
        }
        for(int i = 0;i<this.boules.size();i++) {
            this.boules.get(i).setVitesse(vitesseBoules.get(i));
        }
    }
    
    /**
     * Liste des power ups
     * @return Liste des PowerUps
     */
    public ArrayList<PowerUp> getPowerUp() {
        return this.powerUps;
    }
   
    /**
     * Renvoi le score actuel
     * @return integer
     */
    public int getScore() {
        return this.score;
    }
    
    /**
     * Défini le score
     * @param s integer
     */
    public void setScore(int s) {
        this.score = s;
    }
    
    /**
     * Ajoute au score
     * @param s integer
     */
    public void addScore(int s) {
        this.score +=s;
    }
    
    /**
     * Enlève une brique du nombre total de brique en jeu
     */
    public void removeBrick() { 
        this.bricks--; // On enlève une brique du compteur
        System.out.println("\nNombre de brique : " + this.bricks);
    }
    
    /**
     * Renvoi le chemin du sprite pour un caractère donnée
     * @param n char
     * @return String
     */
    public String getNumberPath(char n) {
        String path = "";
        switch(n) {
            case '0':
                path = "nombres/0";
                break;
            case '1':
                path = "nombres/1";
                break;
            case '2':
                path = "nombres/2";
                break;
            case '3':
                path = "nombres/3";
                break;
            case '4':
                path = "nombres/4";
                break;
            case '5':
                path = "nombres/5";
                break;
            case '6':
                path = "nombres/6";
                break;
            case '7':
                path = "nombres/7";
                break;
            case '8':
                path = "nombres/8";
                break;
            case '9':
                path = "nombres/9";
                break;
        }
        return path;
    }
    
    /**
     * Vérifie la progression actuelle du niveau
     */
    public void checkProgressLevel() {
        switch(this.level) {
            case 1:
                if(this.score<32) {
                    this.progression.changeSprite("0star");
                } else if(this.score < 55) {
                    this.progression.changeSprite("1star");
                } else if(this.score < 79) {
                    this.progression.changeSprite("2star");
                } else {
                    this.progression.changeSprite("3star");
                }
                break;
            case 2:
                if(this.score<26) {
                    this.progression.changeSprite("0star");
                } else if(this.score < 52) {
                    this.progression.changeSprite("1star");
                } else if(this.score < 78) {
                    this.progression.changeSprite("2star");
                } else {
                    this.progression.changeSprite("3star");
                }
                break;
            case 3:
                 if(this.score<37) {
                    this.progression.changeSprite("0star");
                } else if(this.score < 74) {
                    this.progression.changeSprite("1star");
                } else if(this.score < 110) {
                    this.progression.changeSprite("2star");
                } else {
                    this.progression.changeSprite("3star");
                }
                break;
            case 4:
                if(this.score<51) {
                    this.progression.changeSprite("0star");
                } else if(this.score < 102) {
                    this.progression.changeSprite("1star");
                } else if(this.score < 150) {
                    this.progression.changeSprite("2star");
                } else {
                    this.progression.changeSprite("3star");
                }
                break;
        }
    }
    
    /**
     * Affiche le nombre de cristaux
     */
    public void displayCrystals() {
        System.out.println("Crystaux : " + this.crystals);
        if(this.cryst1 == null) {
            this.cryst1 = new Number(this,1310,675,"nombres/0");
            this.cryst2 = new Number(this,1347,675,"nombres/0");
            this.addItem(cryst1);
            this.addItem(cryst2);
        } else {
            // Récupération du score et reverse avec un la fonction du StringBuilder
            String crystalsStr = new StringBuilder(String.valueOf(this.crystals)).reverse().toString();
            for(int i = 0; i<crystalsStr.length();i++) {
                switch(i) {
                    case 0:
                        this.cryst2.changeSprite(getNumberPath(crystalsStr.charAt(0)));
                        break;
                    case 1:
                        this.cryst1.changeSprite(getNumberPath(crystalsStr.charAt(1)));
                        break;
                }
            }
        }
    }
    
    /**
     * Affiche le score
     */
    public void displayScore() {
        System.out.println("Score : " + this.score);
        checkProgressLevel();
        displayCrystals();
        if(nb0 == null) {
            this.nb0 = new Number(this,1360, 300,"nombres/0");
            this.nb1 = new Number(this,1323, 300,"nombres/0");
            this.nb2 = new Number(this,1286, 300,"nombres/0");
            this.nb3 = new Number(this,1249, 300,"nombres/0");
            this.addItem(nb0);
            this.addItem(nb1);
            this.addItem(nb2);
            this.addItem(nb3);
        } else {
            // Récupération du score et reverse avec un la fonction du StringBuilder
            String scoreStr = new StringBuilder(String.valueOf(this.score)).reverse().toString();
            for(int i = 0; i<scoreStr.length();i++) {
                switch(i) {
                    case 0:
                        this.nb0.changeSprite(getNumberPath(scoreStr.charAt(0)));
                        break;
                    case 1:
                        this.nb1.changeSprite(getNumberPath(scoreStr.charAt(1)));
                        break;
                    case 2:
                        this.nb2.changeSprite(getNumberPath(scoreStr.charAt(2)));
                        break;
                    case 3:
                        this.nb3.changeSprite(getNumberPath(scoreStr.charAt(3)));
                        break;
                }
            }
        }
    }

    @Override
    protected void createItems() {
        Fond background = new Fond(this,0,0,"fond"+this.level);
        this.addItem(background);
        Boule balle = new BouleClassique(this,725,690,"Boule",3);
        this.addItem(balle);
        Joueur joueur1 = new Joueur(this,680,730);
        this.addItem(joueur1);
        this.player = joueur1;
        afficherNiveau(chargerNiveau(this.level));
        Stars progress = new Stars(this,1212,554,"0star");
        this.progression = progress;
        this.addItem(progress);
        displayScore();
        AngleSelection test = new AngleSelection(this,"start45",0,0);
        this.addItem(test);
    }
      
    @Override
    protected void drawBackground(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(00, 0, getWidth(), getHeight());
    }
    /**
     * Met fin au jeu, le joueur a perdu
     */
    @Override
    public void lost() {
        Fond loseFond = new Fond(this, 0, 0, "lose");
        this.addItem(loseFond);
        this.LevelScore[this.level-1] = this.score;
        JOptionPane.showMessageDialog(this, "Vous avez perdu","Dommage vous avez perdu", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Met fin au jeu, le joueur a gagné
     */
    @Override
    public void win() {
        Fond winFond = new Fond(this, 0, 0, "lose");
        this.addItem(winFond);
        this.LevelScore[this.level-1] = this.score;
        JOptionPane.showMessageDialog(this, "Vous avez gagné","Bravo vous avez gagné", JOptionPane.INFORMATION_MESSAGE);
        this.stop();
        //this.stop();
    }

    /**
     * Renvoi true quand il y n'y a plus de brique
     * @return 
     */
    @Override
    protected boolean isPlayerWin() {
        boolean res = false;
        if(this.getBricks() ==0) {
            res = true;
        }
        return res;
    }

    /**
     * Renvoi false quand plus de boule en jeu
     * @return boolean
     */
    @Override
    protected boolean isPlayerLost() { 
        boolean res = false;
        if(this.boules.isEmpty()){
            res = true;
            Fond loseFond = new Fond(this, 0, 0, "lose");
            this.addItem(loseFond);
        }
        return res;
    }

    @Override
    public Vector getGravity() {
        return new Vector(); // no gravity in this game
    }
    
    /**
     * Renvoi la liste des boules en jeu
     * @return Liste de boules
     */
    public ArrayList<Boule> getBoules() {
        return boules;
    }
    
    /**
     * Ajotue une boule à la liste des boules en jeu
     * @param b boule
     */
    public void addBoule(Boule b) {
        this.boules.add(b);
    }
    
    /**
     * Affiche et ajotue au jeu un niveau
     * @param tableaubrique Tableau du niveau
     */
    public void afficherNiveau(String[] tableaubrique) {
        for(int i = 0;i<tableaubrique.length;i++) {
            for(int j = 0;j<tableaubrique[i].length();j++) {
                Brique bra1 = null;
                switch(tableaubrique[i].charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        bra1 = fabriqueBrique(this,180+(i*90),j*38,"BriqueRenforced",'1');
                        this.addItem(bra1);
                        break;
                    default:
                        bra1 = fabriqueBrique(this,180+(i*90),j*38,"BriqueSimple",tableaubrique[i].charAt(j));
                        this.addItem(bra1);
                        break;
                }
            }
        }
    }
    
    /**
     * Charge le niveau correspondant
     * @param lvl numéro du niveau
     * @return 
     */
    public String[] chargerNiveau(int lvl){
               String[] tableaubrique = new String [10];

               switch(lvl){
                 
               case 1 :
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
               HorizontalSpaceShip spaceShip = new HorizontalSpaceShip(this,500,500,"horizontalLeft",0);
               HorizontalSpaceShip spaceShip2 = new HorizontalSpaceShip(this,700,600,"horizontalLeft",1);
               this.addItem(spaceShip);
               this.addItem(spaceShip2);
               
               break;

               case 2:
               tableaubrique[0]= "000000077007700";
               tableaubrique[1]= "007700700070070";
               tableaubrique[2]= "000070070734407";
               tableaubrique[3]= "770043004334430";
               tableaubrique[4]= "027443344334433";
               tableaubrique[5]= "027443344334433";
               tableaubrique[6]= "770043004334430";
               tableaubrique[7]= "000070070734407";
               tableaubrique[8]= "007700700070070";
               tableaubrique[9]= "000000077007700";
               
               VerticalSpaceShip spaceship3 = new VerticalSpaceShip(this, 50, 600, "verticalUp",0);
               this.addItem(spaceship3);
               
               break;

               case 3:
               tableaubrique[0]= "000000666000006";
               tableaubrique[1]= "000006666600006";
               tableaubrique[2]= "000016611660066";
               tableaubrique[3]= "000016601660166";
               tableaubrique[4]= "000016601660166";
               tableaubrique[5]= "001116601660166";
               tableaubrique[6]= "001416601660166";
               tableaubrique[7]= "111166001661166";
               tableaubrique[8]= "000360000116660";
               tableaubrique[9]= "003060000016600";
               HorizontalSpaceShip spaceShip4 = new HorizontalSpaceShip(this,50,100,"horizontalLeft",1);
               this.addItem(spaceShip4);
               
               break;
                case 4 :
               tableaubrique[0]= "000000000000000";
               tableaubrique[1]= "000111111000000";
               tableaubrique[2]= "001114441100000";
               tableaubrique[3]= "001114411111011";
               tableaubrique[4]= "011111111141011";
               tableaubrique[5]= "011111111141011";
               tableaubrique[6]= "001114411111011";
               tableaubrique[7]= "001114441100000";
               tableaubrique[8]= "000111111000000";
               tableaubrique[9]= "000000000000000";

               VerticalSpaceShip spaceship5 = new VerticalSpaceShip(this, 50, 100, "verticalUp",0);
               this.addItem(spaceship5);
               
               VerticalSpaceShip spaceship6 = new VerticalSpaceShip(this, 1050, 100, "verticalDown",1);
               this.addItem(spaceship6);
               
        }
        // Chargement du nombres de briques
        ArrayList<Character> briquesList = new ArrayList<>();
        briquesList.add('1');
        briquesList.add('2');
        briquesList.add('3');
        briquesList.add('4');
        briquesList.add('5');
        briquesList.add('6');
        briquesList.add('7');

        for(int i = 0; i<tableaubrique.length;i++) {
            for(int j = 0;j<tableaubrique[i].length();j++) {
                if(briquesList.contains(tableaubrique[i].charAt(j))) {
                    this.bricks++;
                }
            }
         }
        System.out.println("Nombre de BRIQUE !! ! !  / " + this.bricks);
        return tableaubrique;

    }

    /**
     * Renvoi le nombre de briques en jeu
     * @return integer
     */
    public int getBricks() {
        return bricks;
    }
    
    /**
     * Renvoi l'action
     * @return Action
     */
    public ActionList getAction() {
        return this.retour;
    }
    
    /**
     * Fixe l'action
     * @param action Action
     */
    public void setAction(ActionList action) {
        this.retour = action;
    }

    /**
     * Renvoi le joueur
     * @return Joueur
     */
    public Joueur getPlayer() {
        return player;
    }

    /**
     * Défini le joueur
     * @param player Joueur
     */
    public void setPlayer(Joueur player) {
        this.player = player;
    }
    
}
