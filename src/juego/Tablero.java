/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tablero extends JPanel implements Runnable, KeyListener{
    private Sprite sprites;
    private int spriteAncho=42;
    private int spriteAlto=42;
    private int x,y=2;
    private final int DELAY=50;
    private Thread hilo;
    private Fondo fondo;
    private Elemento tanque;
    public Tablero(){
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
       // ImageIcon sprites_ic = new ImageIcon(this.getClass().getResource("recursos/original.png"));
        sprites = new Sprite("recursos/sprites2.png",spriteAncho,spriteAlto);
        ArrayList<BufferedImage> imagenes = new ArrayList<BufferedImage>();
        imagenes.add(sprites.getSprite(0, 0));
        imagenes.add(sprites.getSprite(3, 4));
        
        fondo = new Fondo( spriteAlto, spriteAncho, imagenes);
        imagenes = new ArrayList<BufferedImage>();
        imagenes.add(sprites.getSprite(1, 1));
        tanque = new Elemento(imagenes, fondo, 0, 0, 2, 2);
         this.setFocusable(true);
      this.requestFocus();
        this.addKeyListener(this);
    }
    @Override
    public void addNotify(){
        super.addNotify();
        hilo = new Thread(this);
        hilo.start();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        fondo.dibujar(g2);
        tanque.dibujar(g2);
     /*    AffineTransform at = new AffineTransform();

              // 4. translate it to the center of the component
              at.translate(getWidth() / 2, getHeight() / 2);
 at.translate(42, 0);
              // 3. do the actual rotation
              at.rotate(Math.PI/2);
             
     //   g2.drawImage(sprites.getSprite(0, 0), 0,0, this);
        g2.drawImage(sprites.getSprite(1, y++), at , this);
      //  g2.drawImage(sprites.getSprite(2, 2), 2*spriteAncho, 2*spriteAlto, this);
        if(y>7) y=1;
       */ 
      //   g2.drawImage(sprites.getSprite(1, 1), 0,0, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    public void ciclo(){
      
    }
    @Override
    public void run() {
        long tiempo_act,tiempo_dif,sleep;
        tiempo_act = System.currentTimeMillis();
        while(true){
            ciclo();
            repaint();
            tiempo_dif = System.currentTimeMillis() - tiempo_act;
            sleep = DELAY - tiempo_dif;
            if(DELAY > 0){
                sleep = 4;
            }
            try{
                Thread.sleep(sleep);
            }catch(InterruptedException err){
                System.out.println(err);
            }
            tiempo_act = System.currentTimeMillis();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
 if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
     {
         tanque.moverseIzqierda();
         
     }    
     if(ke.getKeyCode()==KeyEvent.VK_LEFT)
     {
        tanque.moverseDerecha();
     }    
      if(ke.getKeyCode()==KeyEvent.VK_UP)
     {
         tanque.moverseArriba();
     }    
     if(ke.getKeyCode()==KeyEvent.VK_DOWN)
     {
         tanque.moverseAbajo();
     }    
    
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

