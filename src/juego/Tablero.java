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
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.KeyListener;

public class Tablero extends JPanel implements Runnable, KeyListener{
    private Image background;
    private Image angrybird;
    private Thread hilo;
    private int x,y;
    private final int DELAY=50;
    Angry pajaros[] = new Angry[10];
    Angry angry;
    Ladrillos ladrillos = new Ladrillos(0,0);
    public Tablero(){
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        ImageIcon background_ic = new ImageIcon(this.getClass().getResource("background.jpg"));
        background = background_ic.getImage();
       // angrybird = angrybird_ic.getImage();
        x=70;
        y=200;
        pajaros[0] =  new Angry(x, y, 1, 0);
        pajaros[1] =  new Angry(x, y, 0, 1);
        pajaros[2] =  new Angry(x, y, 0, -1);
        pajaros[3] =  new Angry(x, y, -1, -1);
        pajaros[4] =  new Angry(x, y, 1, -1);
        pajaros[5] =  new Angry(x, y, -1, 1);
        pajaros[6] =  new Angry(x, y, 0, 1);
        pajaros[7] =  new Angry(x, y, 1, 0);
        pajaros[8] =  new Angry(x, y, 1, -1);
        pajaros[9] =  new Angry(x, y, -1, 0);
        angry =  new Angry(x, y, 0, 0);
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
        g2.drawImage(background, 0,0, null);
        for(Angry pajaro:pajaros)
        {
            pajaro.moverser();
            pajaro.dibujar(g2);
        } 
        angry.moverser();
        angry.dibujar(g2);
        ladrillos.dibujar(g2);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    public void ciclo(){
       // angryBird1.moverser();
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
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
           
     if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
     {
         angry.x=angry.x-2;
        System.out.println(angry.x); 
     }    
     if(ke.getKeyCode()==KeyEvent.VK_LEFT)
     {
         angry.x=angry.x+2;
     }    
      if(ke.getKeyCode()==KeyEvent.VK_UP)
     {
         angry.y=angry.y-2;
        System.out.println(angry.x); 
     }    
     if(ke.getKeyCode()==KeyEvent.VK_DOWN)
     {
         angry.y=angry.y+2;
     }    
    }

    @Override
    public void keyReleased(KeyEvent ke) {
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

