/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juego;

import java.awt.Graphics2D;
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

    public Elemento(ArrayList<BufferedImage> sprites, int x, int y, int vx, int vy) {
        this.sprites = sprites;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }
      
      public void dibujar(Graphics2D g2)
      {
        
               g2.drawImage(sprites.get(0), x, y, null);
            
      }
      public void moverseIzqierda()
      {
          x=x-vx;
      }
      public void moverseDerecha()
      {
          x=x+vx;
      }
      public void moverseArriba()
      {
          y=y-vy;
      }
      public void moverseAbajo()
      {
          y=y+vy;
      }
    }      
    
    
    
    

