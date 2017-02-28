/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajustesespaciales;

import DATA.ImageType;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ConvolucionEspacial {
    
    private Image imagenOriginal;
    private BufferedImage imagenResultante;

    public ConvolucionEspacial(Image imagenOriginal) {
      this.imagenOriginal = imagenOriginal;
      // crear una nueva imagen 
      this.imagenResultante = new BufferedImage(imagenOriginal.getWidth(null), imagenOriginal.getHeight(null),
                           BufferedImage.TYPE_INT_RGB);
    }
    
    public Image convolucionar3x3(int [][] kernel){
       BufferedImage auxOriginal = ImageType.toBufferedImage(imagenOriginal);
       // recorrer la imagen para extraer
       // la ventana de valores
       for (int x=1;x<auxOriginal.getWidth()-1;x++)
           for (int y=1;y<auxOriginal.getHeight()-1;y++){
             // extraer los valores de la imagen
             int ventana[][] = extraerValores(x,y,kernel[0].length,auxOriginal);
             // obtener el nuevo color del pixel 
             Color colorNuevo = generaConvolucion(ventana,kernel);
             this.imagenResultante.setRGB(x, y, colorNuevo.getRGB());
           }
     return ImageType.toImage(this.imagenResultante);
    }

    private int[][] extraerValores(int x, int y, int tamMascara,BufferedImage auxOriginal) {
       int mascara [][] = new int[tamMascara][tamMascara];
       for (int j=0;j < tamMascara;j++)
            for (int m=0;m < tamMascara;m++){
            // asegurarme de obtener un rgb que si exista dentro 
            // de la imagen 
             mascara[j][m] = 0;            
            }
       return mascara;
    }

    private Color generaConvolucion(int[][] ventana, int[][] kernel) {
        int acumuladorRojo = 0;
        int acumuladorVerde = 0;
        int acumuladorAzul = 0;
        return null;
    }
    
    
    
}
