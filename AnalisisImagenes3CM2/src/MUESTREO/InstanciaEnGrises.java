/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MUESTREO;

import DATA.Grafica;
import DATA.ImageType;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class InstanciaEnGrises {
    private Image imagenOriginal;
    private Image imagenGrises;
    private double histrograma[];
    private int nMin,nMax;
    
    public InstanciaEnGrises(Image imagenOriginal ) {
        this.imagenOriginal = imagenOriginal;
        this.histrograma = new double[256];
    }
    public Image generaImagenGrises(){
      
        BufferedImage aux = ImageType.toBufferedImage(imagenOriginal);
        // recorrer pixel por pixel la imagen
        for (int x=0; x < aux.getWidth();x++)
            for (int y=0; y < aux.getHeight();y++){
              Color color = new Color(aux.getRGB(x, y));
              int gris = (color.getRed()+color.getGreen()+color.getBlue())/3;
             
              // acumular la frecuencia del tono de gris
              this.histrograma[gris]++;
              color = new Color(gris,gris,gris);
              aux.setRGB(x, y, color.getRGB());
            }
            
        this.imagenGrises = ImageType.toImage(aux);
        // ya creado el histograma vamos a calcular el rango de niveles de grises
        calcularRango();
        return this.getImagenGrises();
    }
    public void graficarHistograma(){
      Grafica grafica = new Grafica("Histograma de Niveles de Grises (frecuencia de tonos)",
                  "Frecuencia", "Tono de Gris");
      grafica.agregarSerie(this.histrograma, "Imagen1");
      grafica.creaYmuestraGrafica();
    }

    /**
     * @return the imagenGrises
     */
    public Image getImagenGrises() {
        return imagenGrises;
    }

    private void calcularRango() {
        // recorremos el histograma 
        for (int x=0; x < this.histrograma.length;x++){
          if (this.histrograma[x]!=0){
            this.nMin = x;
            break;
          }
        }
        for (int y=255; y>= 0;y--){
          if (this.histrograma[y]!=0){
            this.nMax = y;
            break;
          }
        }
        
    }

    /**
     * @return the nMin
     */
    public int getnMin() {
        return nMin;
    }

    /**
     * @return the nMax
     */
    public int getnMax() {
        return nMax;
    }
    
    
    
}
