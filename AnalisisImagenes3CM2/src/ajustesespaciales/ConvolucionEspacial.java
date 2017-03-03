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
import org.jfree.chart.ChartColor;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ConvolucionEspacial {
    
    private Image imagenOriginal;
    private BufferedImage imagenResultante;
    private int desfase,divisor;

    public ConvolucionEspacial(Image imagenOriginal) {
      this.imagenOriginal = imagenOriginal;
      // crear una nueva imagen 
      this.imagenResultante = new BufferedImage(imagenOriginal.getWidth(null), imagenOriginal.getHeight(null),
                           BufferedImage.TYPE_INT_RGB);
    }
    
    public Image convolucionar3x3(int [][] kernel,int desfase,int divisor){
       BufferedImage auxOriginal = ImageType.toBufferedImage(imagenOriginal);
       this.divisor = divisor;
       this.desfase = desfase;
// recorrer la imagen para extraer
       // la ventana de valores
       for (int x=1;x<auxOriginal.getWidth()-1;x++)
           for (int y=1;y<auxOriginal.getHeight()-1;y++){
             // extraer los valores de la imagen
             int ventana[][] = extraerValores(x,y,kernel[0].length,auxOriginal);
             if (ventana!=null){
              // obtener el nuevo color del pixel 
             Color colorNuevo = generaConvolucion(ventana,kernel);
             this.imagenResultante.setRGB(x, y, colorNuevo.getRGB());
             } else{
             // si es nulo dejamos igual el tono
             this.imagenResultante.setRGB(x, y,auxOriginal.getRGB(x, y));
             }
             
             
           }
     return ImageType.toImage(this.imagenResultante);
    }

    private int[][] extraerValores(int x, int y, int tamMascara,BufferedImage auxOriginal) {
       int mascara [][] = new int[tamMascara][tamMascara];
       if (auxOriginal.getWidth()<x+3 || auxOriginal.getHeight()<y+3){
        return null;
        
        } else {
        // obtenemos los valores
         int xx=0,yy=0;   
         for (int j=x;j<x+3;j++){
          for (int m=y; m < y+3;m++){
            
             mascara[xx][yy] = auxOriginal.getRGB(j, m);
              yy++;
          }
          yy=0;
          xx++;
         }   
        }

       return mascara;
    }

    private Color generaConvolucion(int[][] ventana, int[][] kernel) {
        int acumuladorRojo = 0;
        int acumuladorVerde = 0;
        int acumuladorAzul = 0;
        Color colorPixel;
        for (int x=0;x<ventana[0].length;x++)
            for (int y=0;y<ventana[0].length;y++){
             colorPixel = new Color(ventana[x][y]);
             acumuladorRojo+=(kernel[x][y]*colorPixel.getRed());
             acumuladorVerde+=(kernel[x][y]*colorPixel.getGreen());
             acumuladorAzul+=(kernel[x][y]*colorPixel.getBlue());
            }
        acumuladorRojo/=this.divisor;
        acumuladorVerde/=this.divisor; 
        acumuladorAzul/=this.divisor;
        acumuladorRojo+=this.desfase;
        acumuladorVerde+=this.desfase; 
        acumuladorAzul+=this.desfase;
        // validar los limites
        acumuladorRojo = Iluminacion.verificaLimites(acumuladorRojo);
        acumuladorVerde = Iluminacion.verificaLimites(acumuladorVerde);
        acumuladorAzul = Iluminacion.verificaLimites(acumuladorAzul);
        
        // creamos el nuevo color
        colorPixel = new Color(acumuladorRojo, acumuladorVerde, acumuladorAzul);
        
        
        return colorPixel;
    }
    
    
    
}
