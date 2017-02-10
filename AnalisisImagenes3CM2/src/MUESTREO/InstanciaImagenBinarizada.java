/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MUESTREO;

import DATA.ImageType;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class InstanciaImagenBinarizada {
    
    private Object imagenGrises;
    private int umbral;

    public InstanciaImagenBinarizada(Object imagenGrises, int umbral) {
        this.imagenGrises = imagenGrises;
        this.umbral = umbral;
    }
    public Image generarImagenBinarizada(){
    
        if (this.imagenGrises instanceof InstanciaEnGrises){
           InstanciaEnGrises aux = (InstanciaEnGrises)this.imagenGrises;
           // modificar la imagen 
           BufferedImage imagenGris = ImageType.toBufferedImage(aux.getImagenGrises()) ;
           return binarizar(imagenGris);
        } 
        if (this.imagenGrises instanceof Image){
           Image auxImagen = (Image) this.imagenGrises;
           InstanciaEnGrises aux = new InstanciaEnGrises(auxImagen);
           BufferedImage imagenGris = ImageType.toBufferedImage(aux.generaImagenGrises()) ;
           return binarizar(imagenGris);
           
        
        }
        return null;
    }

    private Image binarizar(BufferedImage imagenGris){
    
        for (int x=0; x<imagenGris.getWidth();x++)
               for (int y=0; y<imagenGris.getHeight();y++){
                 int rgb = imagenGris.getRGB(x, y);
                 Color color = new Color(rgb);
                 if (color.getRed()<this.umbral){
                   // mandamos el rgb del pixel a negro
                   color = new Color(0, 0, 0);
                  
                 }else{
                  // mandamos el rgb del pixel a blanco
                   color = new Color(255, 255, 255);
                 }
                  imagenGris.setRGB(x, y, color.getRGB());
               }
           return ImageType.toImage(imagenGris);
    
    }
    
}
