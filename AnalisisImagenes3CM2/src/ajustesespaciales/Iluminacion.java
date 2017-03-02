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
public class Iluminacion {
    
    public static Image ajustarBrillo(int alpha, Image imagenOriginal){
    
        BufferedImage aux = ImageType.toBufferedImage(imagenOriginal);
        // recorremos los pixels de la imagen 
        for (int x=0; x < aux.getWidth();x++)
            for (int y=0; y < aux.getHeight();y++){
            int rgb = aux.getRGB(x, y);
            Color color = new Color(rgb);
            // realizamos la acumulacion del alpha
            // cuidando los limites tanto inferior como superior
            int aR = color.getRed()+alpha;
            int aG = color.getGreen()+alpha;
            int aB = color.getBlue()+alpha;
            // verificar que no exedan los limites
            aR = verificaLimites(aR);
            aG = verificaLimites(aG);
            aB = verificaLimites(aB);
            color = new Color(aR, aG, aB);
            aux.setRGB(x, y, color.getRGB());
            
            }
        
        return ImageType.toImage(aux);
    }

    public static int verificaLimites(int valor) {
        if (valor<0){
          return 0;
        }
        if (valor>255){
        return 255;
        }
        return valor;
    }
    
}
