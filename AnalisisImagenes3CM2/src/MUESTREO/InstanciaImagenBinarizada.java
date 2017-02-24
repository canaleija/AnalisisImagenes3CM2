/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MUESTREO;

import DATA.ImageType;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class InstanciaImagenBinarizada {
    
    private BufferedImage imagenGrisesOriginal;
  

    public InstanciaImagenBinarizada(Object imagenGrises) {
      
         if (imagenGrises instanceof InstanciaEnGrises){
           InstanciaEnGrises aux = (InstanciaEnGrises)imagenGrises;
           // modificar la imagen 
           this.imagenGrisesOriginal = ImageType.toBufferedImage(aux.getImagenGrises()) ;
          
        } 
        if (imagenGrises instanceof Image){
           Image auxImagen = (Image)imagenGrises;
           InstanciaEnGrises aux = new InstanciaEnGrises(auxImagen);
           this.imagenGrisesOriginal = ImageType.toBufferedImage(aux.generaImagenGrises()) ;
               
        }
     
    }
    public Image generarImagenBinarizada(int umbral){
         // Create a buffered image with transparency
    BufferedImage aux = new BufferedImage(imagenGrisesOriginal.getWidth(null),imagenGrisesOriginal.getHeight(null), BufferedImage.TYPE_INT_RGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = aux.createGraphics();
    bGr.drawImage(imagenGrisesOriginal, 0, 0, null);
    bGr.dispose();
       return binarizar(aux, umbral);
    }
    public Image generarImagenBinarizada (int uI , int uS){
          // Create a buffered image with transparency
    BufferedImage aux = new BufferedImage(imagenGrisesOriginal.getWidth(null),imagenGrisesOriginal.getHeight(null), BufferedImage.TYPE_INT_RGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = aux.createGraphics();
    bGr.drawImage(imagenGrisesOriginal, 0, 0, null);
    bGr.dispose();
       return binarizar(aux, uI, uS);
    }

    private Image binarizar(BufferedImage imagenGris,int umbral){
    
        for (int x=0; x<imagenGris.getWidth();x++)
               for (int y=0; y<imagenGris.getHeight();y++){
                 int rgb = imagenGris.getRGB(x, y);
                 Color color = new Color(rgb);
                 if (color.getRed()<umbral){
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
    
    private Image binarizar(BufferedImage imagenGris,int uI,int uS){
    
        // validar que el umbral 
        if (uI<uS){
        
            for (int x=0; x<imagenGris.getWidth();x++)
               for (int y=0; y<imagenGris.getHeight();y++){
                 int rgb = imagenGris.getRGB(x, y);
                 Color color = new Color(rgb);
                 if (color.getRed()>= uI && color.getRed()<= uS){
                   // mandamos el rgb del pixel a negro
                   color = new Color(0, 0, 0);
                  
                 }else{
                  // mandamos el rgb del pixel a blanco
                   color = new Color(255, 255, 255);
                 }
                  imagenGris.setRGB(x, y, color.getRGB());
               }
           return ImageType.toImage(imagenGris);
            
        
        } else{
        return ImageType.toImage(imagenGris);
        }
     
    }
    
}
