/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juego;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author root
 */
public class Ladrillos {
    int capa[][] = new int[][]{{1,0,1},{1,0,1},{1,0,1}};
      int x;
    int y;
    private Image ladrillo;

    public Ladrillos(int x, int y) {
        this.x = x;
        this.y = y;
             ImageIcon _ladrillo = new ImageIcon(this.getClass().getResource("brick.png"));
             this.ladrillo = _ladrillo.getImage();
            
     
    }
     public void dibujar(Graphics2D g2)
    {
        x=0;y=0;
        int alto = ladrillo.getHeight(null);
        int ancho = ladrillo.getWidth(null);
         for(int i=0;i<3;i++)
         {
             for(int j=0;j<3;j++)
             {
                 if(capa[i][j]==1)
                 {    
                    g2.drawImage(ladrillo,x,y, null); 
                 }
                 x=x+ancho;
             }    
             y=y+alto;
         }    
            
    
    }
            
    
}
