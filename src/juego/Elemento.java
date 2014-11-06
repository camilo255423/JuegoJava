/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juego;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Elemento {
      ArrayList<BufferedImage> sprites;
      int x;
      int y;
      int vx;
      int vy;
      Fondo fondo;
      int ancho;
      int alto;
      int nAnimacion;
      double angulo;
   
    public Elemento(ArrayList<BufferedImage> sprites, Fondo fondo,int x, int y, int vx, int vy) {
        this.sprites = sprites;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.fondo = fondo;
        this.ancho=sprites.get(0).getWidth();
        this.alto=sprites.get(0).getHeight();
        this.angulo=0;
        this.nAnimacion=0;
        
    }
           
      public void dibujar(Graphics2D g2)
      {
        if(nAnimacion>=sprites.size())
        {
            nAnimacion=0;
        }
          
                AffineTransform at = new AffineTransform();

                if(angulo==0)
               g2.drawImage(sprites.get(nAnimacion), x, y, null);
                else if (angulo==Math.PI) {
               at.translate(x+ancho, y+alto);
               at.rotate(angulo);
               g2.drawImage(sprites.get(nAnimacion), at, null);
                }
                else if (angulo==Math.PI/2) {
               at.translate(x+ancho, y);
               at.rotate(angulo);
               g2.drawImage(sprites.get(nAnimacion), at, null);
                }
            else if (angulo==3*Math.PI/2) {
               at.translate(x, y+alto);
               at.rotate(angulo);
               g2.drawImage(sprites.get(nAnimacion), at, null);
                }
                
      }
      public void rotar(double angulo)
      {
       this.angulo=angulo;
      
      
      }
      public boolean moverseIzqierda()
      {
         
          rotar(3*Math.PI/2);
          if(fondo.posibleMoverseA(x-vx, y))
          {    
          x=x-vx;
          nAnimacion++;
          return true;
          }
          return false;
      }
      public boolean moverseDerecha()
      {
          rotar(Math.PI/2);
        
          if(fondo.posibleMoverseA(x+vx, y))
          {    
          x=x+vx;
          nAnimacion++;
          return true;
          }
          return false;
      }
      public boolean moverseArriba()
      {
             rotar(0);
          if(fondo.posibleMoverseA(x, y-vy))
          {
              y=y-vy;
              nAnimacion++;
              return true;
          }
          return false;
      }
      public boolean moverseAbajo()
      {
             rotar(Math.PI);
       
          if(fondo.posibleMoverseA(x, y+vy))
          {
              y=y+vy;
              nAnimacion++;
              return true;
          }
          return false;
      }
    }      
    
    
    
    

