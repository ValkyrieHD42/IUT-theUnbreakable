

package Menu;

import static Menu.ActionList.WAIT;
import iut.Audio;
import iut.Vector;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe du menu d'accueil 
 * @author mathis
 * @author mathias
 * @author martin
 */
public class TheMenu extends iut.Game {
    private int selX;
    private int selY;
    private int level = 1;
    private ActionList action;
    private int[] levels = new int[4];
    private int crystals;
    
    /**
     * Charge la valeur des niveau et du crystal actuel
     * @param levels niveaux
     * @param crystals cristaux
     */
    public TheMenu(int[] levels, int crystals) {
        super(1280,720,"Menu");
        this.selX = 0;
        this.selY = 0;
        this.action = WAIT;
        this.levels = levels;
        this.crystals = crystals;
        //GameItem.DRAW_HITBOX=true;
    }

    /**
     * Fixe les niveaux actuels
     * @param levels niveaux
     */
    public void setLevels(int[] levels) {
        this.levels = levels;
    }

    /**
     * Renvoi les crystaux
     * @return integer cristaux
     */
    public int getCrystals() {
        return crystals;
    }

    /**
     * Fixe les cristaux
     * @param crystals integer correspondant au nouveau cristaux
     */
    public void setCrystals(int crystals) {
        this.crystals = crystals;
    }
    
    /**
     * Renvoi les nivaux
     * @return scores
     */
    public int[] getLevels() {
        return levels;
    }
    
    /**
     * Renvoi le niveau actuel
     * @return renvoi le level
     */
    public int getLevel() {
        return this.level;
    }
    
    /**
     * Fixe le niveau actuel
     * @param lvl niveau actuel 
     */
    public void setLevel(int lvl) {
        this.level = lvl;
    }
    
    /**
     * Modifie l'action en cours
     * @param ac Action
     */
    public void setAction(ActionList ac) {
        this.action = ac;
    }
    
    /**
     * Renvoi l'action ordonné
     * @return une action
     */
    public ActionList getAction() {
        return this.action;
    }
    
    /**
     * Renvoi la valeur X de sélection
     * @return integer
     */
    public int getSelX() {
        return this.selX;
    }
    
    /**
     * Renvoie la valeur Y de sélection
     * @return integer
     */
    public int getSelY() {
        return this.selY;
    }
    
    /**
     * Fixe la valeur X de sélection
     * @param x integer
     */
    public void setSelX(int x) {
        this.selX = x;
    }
    
    /**
     * Fixe la valeur Y de sélection
     * @param y integer
     */
    public void setSelY(int y) {
        this.selY = y;
    }

    @Override
    protected void createItems() {
        FondMenu background = new FondMenu(this,0,0,"Menu/Fond/Fond0000");
        this.addItem(background);
        MenuButton playButton = new MenuButton(this,440,230,"Menu/Jouer/Jouer1");
        this.addItem(playButton);
        MenuButton optionButton = new MenuButton(this,440,360,"Menu/Options/Options1");
        this.addItem(optionButton);
        MenuButton quittButton = new MenuButton(this,440,490,"Menu/Quitter/Quitter1");
        this.addItem(quittButton);
        Selection select = new Selection(this,440,230,"Menu/Jouer/Jouer1", quittButton, playButton, optionButton);
        this.addItem(select);
        TitleMenu title = new TitleMenu(this,190,80,"Menu/Title");
        this.addItem(title);
    }
      
    @Override
    protected void drawBackground(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(00, 0, getWidth(), getHeight());
    }

    @Override
    public void lost() {
        this.stop();
    }

    @Override
    public void win() {
        this.stop();
    }

    @Override
    protected boolean isPlayerWin() {
        boolean res = false;
        return res;
    }

    @Override
    protected boolean isPlayerLost() {   
        
        return false;
    }

    @Override
    public Vector getGravity() {
        return new Vector(); // no gravity in this game
    }
}
