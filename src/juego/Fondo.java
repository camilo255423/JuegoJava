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
public class Fondo {
    public static final int  espacio=0;
    public static final int  ladrillo=1;
    int nFilas=10;
    int nColumnas=10;
    int spriteAlto;
    int spriteAncho;
    int totalAlto;
    int totalAncho;
    ArrayList<BufferedImage> sprites;
    int elementos [][]=new int[][]
    {   {espacio,espacio,espacio,espacio,espacio,espacio,ladrillo,espacio,espacio,ladrillo},
        {espacio,ladrillo,espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio},
        {espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio},
        {espacio,espacio,ladrillo,espacio,espacio,espacio,espacio,espacio,espacio,espacio},
        {espacio,espacio,espacio,espacio,ladrillo,espacio,espacio,espacio,espacio,espacio},
        {espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio},
        {espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio},
        {espacio,ladrillo,espacio,espacio,espacio,espacio,espacio,espacio,espacio,espacio},
        {espacio,espacio,espacio,espacio,ladrillo,ladrillo,espacio,espacio,espacio,espacio},
        {ladrillo,espacio,espacio,espacio,ladrillo,ladrillo,espacio,espacio,espacio,ladrillo}
    
    };

    public Fondo(int spriteAlto, int spriteAncho, ArrayList<BufferedImage> sprites) {
        this.spriteAlto = spriteAlto;
        this.spriteAncho = spriteAncho;
        this.sprites = sprites;
        this.totalAlto=this.spriteAlto*nFilas;
        this.totalAncho=this.spriteAncho*nColumnas;
    }
    
    public void dibujar(Graphics2D g2)
    {
        for(int i=0;i<nFilas;i++)
        {
           for(int j=0;j<nColumnas;j++)
           {
               g2.drawImage(sprites.get(elementos[i][j]), j*spriteAlto, i*spriteAncho, null);
           } 
        }    
    } 
    boolean posibleMoverseA(int x, int y)
    {
        int offSetX=2;
        int offSetY=2;
        
        if(hayLadrillo(x+offSetX,y+offSetY)) return false;
        if(hayLadrillo(this.spriteAncho+x-offSetX,y+offSetY)) return false;
        if(hayLadrillo(x+offSetX,this.spriteAlto+y-offSetY)) return false;
        if(hayLadrillo(this.spriteAncho+x-offSetX,this.spriteAlto+y-offSetY)) return false;
        return true;
    } 
    boolean hayLadrillo(int x, int y)
    {
        int nx = nColumnas * x/totalAncho;
        int ny = nFilas * y/totalAlto;
        
        if(x<=0 || y<=0 || x>=totalAncho || y>=totalAlto) return true;
     
        if (elementos[ny][nx]==ladrillo)
        {
            return true;
        }
        return false;
        
    }        
    
}
