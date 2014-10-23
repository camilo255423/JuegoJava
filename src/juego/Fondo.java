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
    int spriteAlto;
    int spriteAncho;
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
    }
    
    public void dibujar(Graphics2D g2)
    {
        for(int i=0;i<10;i++)
        {
           for(int j=0;j<10;j++)
           {
               g2.drawImage(sprites.get(elementos[i][j]), i*spriteAlto, j*spriteAncho, null);
           } 
        }    
    }        
    
}
