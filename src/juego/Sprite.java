/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juego;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author root
 */
public class Sprite {
    private BufferedImage imagenSprites;
    private int anchoSprite;
    private int altoSprite;

    public Sprite(String imagen, int anchoSprite, int altoSprite) {
        try {
            this.imagenSprites = imagenSprites;
            this.anchoSprite = anchoSprite;
            this.altoSprite = altoSprite;
            InputStream stream = this.getClass().getResourceAsStream(imagen);
            this.imagenSprites = ImageIO.read(stream);
        } catch (IOException ex) {
            Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public BufferedImage getSprite(int fila, int columna)
    {
        BufferedImage subImagen;
        subImagen = this.imagenSprites.getSubimage( columna*this.altoSprite, fila*this.anchoSprite,this.anchoSprite, this.altoSprite);
        return subImagen;
    }        
    
    
    
    
}
