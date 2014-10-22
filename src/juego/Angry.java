package juego;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class Angry {
    int x;
    int y;
    private Image angrybird;
    int vx;
    int vy;
    public Angry(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx=vx;
        this.vy=vy;
        this.angrybird = angrybird;
          ImageIcon angrybird_ic = new ImageIcon(this.getClass().getResource("angrybirds.png"));
        angrybird = angrybird_ic.getImage();
      
        
    }
    
    
    
    public void dibujar(Graphics2D g2)
    {
            
            g2.drawImage(angrybird,x,y, null);
    
    }
    public void moverser()
    {
        this.x += vx;
        this.y += vy;
        if ( this.x > (500+70) ){
            this.x = -70;
        }
        if ( this.y > (500+200) ){
            this.y = -200;
        }
    }    
    public boolean chocar(Image image,int x,int y)
    {
        if(this.x>=x && this.y>=y && this.x<=(x+image.getWidth(null)) && this.y<=(image.getHeight(null)+y))
        {
            return true;
        }
        return false;
    }        
    
    
}
