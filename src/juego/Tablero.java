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
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tablero extends JPanel implements Runnable{
    private Image background;
    private Image angrybird;
    private Thread hilo;
    private int x,y;
    private final int DELAY=50;
    public Tablero(){
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        ImageIcon background_ic = new ImageIcon(this.getClass().getResource("background.jpg"));
        ImageIcon angrybird_ic = new ImageIcon(this.getClass().getResource("angrybirds.png"));
        background = background_ic.getImage();
        angrybird = angrybird_ic.getImage();
        x=70;
        y=200;
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
        g2.drawImage(angrybird,x,y, null);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    public void ciclo(){
        x += 1;
        if ( x > (500+70) ){
            x = -70;
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
}

