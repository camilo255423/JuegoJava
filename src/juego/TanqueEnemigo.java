package juego;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class TanqueEnemigo extends Elemento{
int m;
int t=0;
    public TanqueEnemigo(ArrayList<BufferedImage> sprites, Fondo fondo, int x, int y, int vx, int vy) {
        super(sprites, fondo, x, y, vx, vy);
        m = (int)(Math.random()*4);
    }

    @Override
    public void dibujar(Graphics2D g2) {
        super.dibujar(g2); //To change body of generated methods, choose Tools | Templates.
    
    
    
    }
    public void moverse()
    {
        t++;
        if(t%100000==0)
        {    
         m = (int)(Math.random()*4);
            System.out.println("NUEVO VALOR");
        }
        if(m==1)
            if(!this.moverseIzqierda())
            {    
                m=2;
            }
        if(m==2)
            if(!this.moverseDerecha())
            {
                m=1;
            }
        
        if(m==3)
            if(!this.moverseArriba())
            {
                m=0;
               
            }
        
        if(m==0)
            if(!this.moverseAbajo())
            {
                m=3;
               
            }
        
    }        
    
    
}
