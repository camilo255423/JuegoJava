package juego;


import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class Main extends JFrame{
    public Main(){
        //TITULO
        setTitle("Como Crear un Juego 2D con Java - La base 01");
        //CERRAR AL CLICKEAR EN LA CRUZ
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //TAMAÑO DE VENTANA
        setSize(10*42,10*42);
        //LOCACION DE LA VENTANA ( CENTRO )
        setLocationRelativeTo(null);
        //NO SE REDIMENSIONE LA VENTANA
        setResizable(false);
        //AGREGAMOS A LA VENTANA UN NUEVO OBJETO QUE ES UNA CLASE LLAMADA TABLERO
        //QUE HEREDA DE LA CLASE JPANEL DE SWING Y QUE ES DONDE SE DIBUJARA
        //NUESTRO JUEGO
        add(new Tablero());
        //HACEMOS VISIBLE NUESTRA VENTANA
        setVisible(true);
    }
  
}
