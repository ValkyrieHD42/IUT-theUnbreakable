/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theunbreakable.Boules;

import iut.Audio;
import iut.Game;
import iut.GameItem;
import java.lang.Math;
import java.util.Date;
import theunbreakable.TheUnbreakable;

/**
 * Classe d'une boule/balle
 * @author mathis
 * @author mathias
 * @author martin
 */
public abstract class Boule extends iut.BoxGameItem {
    protected int life=3;
    protected double vitesse=0.2;
    protected double angle = 45;
    protected boolean touched=false;
    private long brickBounceCooldown;
    private TheUnbreakable game;

    @Override
    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    public Boule(TheUnbreakable g, int x, int y, String name,int life) {
        super((Game) g,name, x, y);
        this.life = life;
        this.game = g;
        
    }

    /**
     * Renvoie les angles
     * @return Angle
     */
    public double getAngle() {
        return angle;
    }
    
    /**
     * Renvoi le jeu principal
     * @return Renvoi la classe jeu avec ses méthodes
     */
    public TheUnbreakable getUnbreak() {
        return this.game;
    }
    
    /**
     * Rebond contre les murs
     */
    private void bounce()
    {   
        normalise();
        if(this.getTop()<=0)
        {
            bounceTop();
        }
        else if(this.getLeft()<=0)
        {
            bounceLeft();
        }
        else if(this.getRight()>=1158)
        {
            bounceRight();
        }
     }
    
    /**
     * Rebond plafond
     */
    private void bounceTop()
    {
        angle = 90 + this.angle;
        /*
        if(angle<90)
            angle -= 90;
        else
            angle += 90;*/
    }
    
    /**
     * Rebond mur gauche
     */
    private void bounceLeft()
    {
        angle = 180 - this.angle;
        /**
        if(angle<180)
            angle-=90;
        else
            angle+=90;
            * **/
    }
    
    /**
     * Rebond mur droite
     */
    private void bounceRight()
    {
        angle = 180 - this.angle;
        /**
        if(angle<90)
            angle += 90;
        else
            angle -= 90;
            **/
    }
    
    @Override
    public void collideEffect(GameItem o) {
         
        
        if (o.getItemType() == "Joueur") {
            bouncePlayer(o);
        }
        if (o.getItemType() == "Boule" || o.getItemType() == "Boule Perforante"){
            bounceBoule(o);
        }
         if (o.getItemType() =="Brique"){
             bounceBrique(o);
         }
        
        
    }

    @Override
    public abstract String getItemType();

    /**
     * Renvoie vers un checkLife et défini la trajectoire avec l'angle
     * @param dt 
     */
    @Override
    public void evolve(long dt) {
        if(!game.isPause()) {
            bounce();
            if(this.getTop()>770){
                checklife();
            }

            this.moveDA(dt*vitesse, angle);
            if(this.getUnbreak().getBoules().isEmpty()) {
                getUnbreak().lost();
            }
        }
        
    }
    
    /**
     * Vérifie le nombre de vie de la balle
     */
    public void checklife() {
         
        
           //getGame().remove(this);
           //getUnbreak().getBoules().remove(this);
           this.life--;
           System.out.println("vie : "+this.life);
            if (this.life > 0)
            {
                Boule balle = new BouleClassique(getUnbreak(),600,500,"Boule",life);
                getGame().remove(this);
                getUnbreak().getBoules().remove(this);
                getGame().addItem(balle);
                
                System.out.println("creation d'item");
            }
            if(this.life == 0 ){
                getGame().remove(this);
                getUnbreak().getBoules().remove(this);
                
            }
            
        }

    /**
     * Rebond avec la platforme
     * @param o item avec lequel le rebond a eu lieu
     */
    public void bouncePlayer(GameItem o) {
        new Audio("impact_bar").start();
        if(o.getItemType().equalsIgnoreCase("Joueur")) {
            
            // Tentative de rapport balle/paltforme
            // Afin d'orienté les angles en fonction du rebond sur la platforme
            // Encore en phase experimentale
            
            int posBalle = this.getMiddleX();
            int posPlat = o.getMiddleX();
            double rapport = 1;
            
            //System.out.println("Ratio : " + ratio);
            
            if((posBalle<=posPlat)) {
                System.out.println("Balle corner gauche");
                System.out.println("Barre " + o.getMiddleX());
                System.out.println("Balle : " + posBalle);
                rapport = (double) o.getMiddleX()/posBalle;
            }
            if((posBalle>=posPlat)) {
                System.out.println("Balle corner droit");
                rapport = (double) o.getRight()/posBalle;
                System.out.println("Barre " + o.getRight());
                System.out.println("Balle : " + posBalle);
            }
            System.out.print("\nRapport de balle : " + rapport+"\n");
            if(angle>=45) {
                this.angle = 180 - this.angle;
            } else if(angle<45) {
                this.angle = 180 + this.angle;
            }
            if(rapport<1.20) {
                //this.angle = this.angle * rapport;
            }
            System.out.println(this.angle);
            this.vitesse+=0.001;
        }
    }
        
    /**
     * Rebond avec les briques
     * @param o Item avec lequel le rebond a eu lieu
     */
    public void bounceBrique(GameItem o) {
        normalise();
        long currentBounce = new Date().getTime();
        if(currentBounce-this.brickBounceCooldown>400) {
            if(this.getTop() > o.getBottom()-2) {
                this.angle = 180 + this.angle;
            } else if(this.getRight() < o.getLeft()+2) {
                this.angle = 180 - this.angle;
            } else if(this.getBottom() < o.getTop()+2) {
                this.angle = 180 +this.angle;
            } else if(this.getLeft() > o.getLeft()-2) {
                this.angle = 180 - this.angle;
            }
            normalise();
        }
        this.brickBounceCooldown = currentBounce;
    }
    
    /**
     * Normalise l'angle [0;360]
     */
    public void normalise() {
       angle %= 360;
    }

    /**
     * Fixe la vitesse de la balle
     * @param vitesse double correspondant à une vitesse
     */
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    /**
     * Renvoi la vitesse de la balle
     * @return double correspondant à la vitesse
     */
    public double getVitesse() {
        return vitesse;
    }

    /**
     * Rebonds avec les autres boules
     * @param o autre boule
     */
    protected void bounceBoule(GameItem o) {
        normalise();
        this.angle = angle -180;
        normalise();
    }
    
                
    }

