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
    
    
    
}
