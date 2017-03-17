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
public class Filtros {
   
    private Image imagenOriginal;
    private BufferedImage imagenResultante;

    public Filtros(Image imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
      // crear una nueva imagen 
      this.imagenResultante = new BufferedImage(imagenOriginal.getWidth(null), imagenOriginal.getHeight(null),
                           BufferedImage.TYPE_INT_RGB);
    }
    
    public Image aplicarOperadorMediana(int n){
      BufferedImage auxOriginal = ImageType.toBufferedImage(imagenOriginal);
        for (int x=1;x<auxOriginal.getWidth()-1;x++)
           for (int y=1;y<auxOriginal.getHeight()-1;y++){
             // extraer los valores de la imagen
             int ventana[] = extraerValores(x,y,n,auxOriginal);
             if (ventana!=null){
              // obtener el nuevo color del pixel 
             Color colorNuevo = generarMediana(ventana);
             this.imagenResultante.setRGB(x, y, colorNuevo.getRGB());
             
             } else{
             // si es nulo dejamos igual el tono
             this.imagenResultante.setRGB(x, y,auxOriginal.getRGB(x, y));
             }
             
             
           }
        return ImageType.toImage(this.imagenResultante);
    }
    
    public Image aplicarOperadorModa(int n){
      BufferedImage auxOriginal = ImageType.toBufferedImage(imagenOriginal);
        for (int x=1;x<auxOriginal.getWidth()-1;x++)
           for (int y=1;y<auxOriginal.getHeight()-1;y++){
             // extraer los valores de la imagen
             int ventana[] = extraerValores(x,y,n,auxOriginal);
             if (ventana!=null){
              // obtener el nuevo color del pixel 
             Color colorNuevo = generarModa(ventana);
             this.imagenResultante.setRGB(x, y, colorNuevo.getRGB());
             
             } else{
             // si es nulo dejamos igual el tono
             this.imagenResultante.setRGB(x, y,auxOriginal.getRGB(x, y));
             }
             
             
           }
        return ImageType.toImage(this.imagenResultante);
    }
    
    private int[] extraerValores(int x, int y, int tam,BufferedImage auxOriginal) {
       int valores [] = new int[tam];
       if (auxOriginal.getWidth()<x+3 || auxOriginal.getHeight()<y+3){
        return null;
        
        } else {
        // obtenemos los valores
         int xx=0;  
         
         for (int j=x;j<x+3;j++){
          for (int m=y; m < y+3;m++){
            
             valores[xx] =auxOriginal.getRGB(j, m);
              xx++;
          }
         }   
        }

       return valores;
    }

    private Color generarMediana(int[] ventana) {
       // aplicar un ordenamiento 
       ventana = ordenar(ventana);
       int pos = ventana.length/2;
        return new Color(ventana[pos]);
    }

    private Color generarModa(int[] ventana) {
        // resolver moda
        return null;
    }

    private int[] ordenar(int[] ventana) {
        // implentar ordenamiento
        return null;
    }
    
    
}
