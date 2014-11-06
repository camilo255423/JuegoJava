/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    private ArrayList<TanqueEnemigo> tanquesEnemigos;
    public Tablero(){
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
       // ImageIcon sprites_ic = new ImageIcon(this.getClass().getResource("recursos/original.png"));
        sprites = new Sprite("recursos/sprites2.png",spriteAncho,spriteAlto);
        ArrayList<BufferedImage> imagenes = new ArrayList<BufferedImage>();
        tanquesEnemigos = new ArrayList<TanqueEnemigo>();
        imagenes.add(sprites.getSprite(0, 0));
        imagenes.add(sprites.getSprite(3, 4));
        
        fondo = new Fondo( spriteAlto, spriteAncho, imagenes);
        imagenes = new ArrayList<BufferedImage>();
        imagenes.add(sprites.getSprite(1, 1));
        imagenes.add(sprites.getSprite(1, 2));
        imagenes.add(sprites.getSprite(1, 3));
        imagenes.add(sprites.getSprite(1, 4));
        imagenes.add(sprites.getSprite(1, 5));
        imagenes.add(sprites.getSprite(1, 6));
        imagenes.add(sprites.getSprite(1, 7));
        imagenes.add(sprites.getSprite(2, 0));
        tanque = new Elemento(imagenes, fondo, 0, 0, 3, 3);
        
        imagenes = new ArrayList<BufferedImage>();
        imagenes.add(sprites.getSprite(0, 1));
        imagenes.add(sprites.getSprite(0, 2));
        imagenes.add(sprites.getSprite(0, 3));
        imagenes.add(sprites.getSprite(0, 4));
        imagenes.add(sprites.getSprite(0, 5));
        imagenes.add(sprites.getSprite(0, 6));
        imagenes.add(sprites.getSprite(0, 7));
        imagenes.add(sprites.getSprite(1, 0));
            
        tanquesEnemigos.add(new TanqueEnemigo(imagenes, fondo, 100, 50, 1, 1));
        tanquesEnemigos.add(new TanqueEnemigo(imagenes, fondo, 100, 50, 1, 1));
        tanquesEnemigos.add(new TanqueEnemigo(imagenes, fondo, 100, 50, 1, 1));
        tanquesEnemigos.add(new TanqueEnemigo(imagenes, fondo, 100, 50, 1, 1));
        tanquesEnemigos.add(new TanqueEnemigo(imagenes, fondo, 100, 50, 1, 1));
        tanquesEnemigos.add(new TanqueEnemigo(imagenes, fondo, 100, 50, 1, 1));
       
        
        this.setFocusable(true);
      this.requestFocus();
        this.addKeyListener(this);
    }
    @Override
    public void addNotify(){
        super.addNotify();
        System.out.println("NOTIFICACION");
        hilo = new Thread(this);
        hilo.start();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        fondo.dibujar(g2);
        tanque.dibujar(g2);
        for(TanqueEnemigo t:tanquesEnemigos)
        {
         t.dibujar(g2);
        }    
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    public void ciclo(){
        for(TanqueEnemigo t:tanquesEnemigos)
        {
         t.moverse();
        }    
        
    
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
                sleep = 12;
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
         tanque.moverseDerecha();
         
     }    
     if(ke.getKeyCode()==KeyEvent.VK_LEFT)
     {
        tanque.moverseIzqierda();
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

