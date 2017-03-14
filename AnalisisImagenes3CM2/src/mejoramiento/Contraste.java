/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mejoramiento;

import DATA.ImageType;
import MUESTREO.InstanciaEnGrises;
import ajustesespaciales.Iluminacion;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartColor;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Contraste {
    
    private InstanciaEnGrises ioGrises;

    public Contraste(InstanciaEnGrises ioGrises) {
        this.ioGrises = ioGrises;
    
    }
    
    public Image expansionLineal(){
    BufferedImage bi = ImageType.toBufferedImage(this.ioGrises.getImagenGrises());
    for(int x=0;x<bi.getWidth();x++){
      for(int y=0;y < bi.getHeight();y++){
          // obtenemos el color original
          Color color = new Color(bi.getRGB(x, y));
          int tonoOriginal = color.getRed();
          // implementamos la expansion para el tono original
          //int tonoNuevo = 255*((tonoOriginal-this.ioGrises.getnMin())/(this.ioGrises.getnMax()-this.ioGrises.getnMin()));
          int tonoNuevo = (255/(this.ioGrises.getnMax()-this.ioGrises.getnMin()))*(tonoOriginal-this.ioGrises.getnMin());
          color = new Color(tonoNuevo, tonoNuevo, tonoNuevo);
           // modificamos el color del pixel con el tono nuevo
          bi.setRGB(x, y, color.getRGB());
      }
    }     
    return ImageType.toImage(bi);
    }
    
  public Image expansionLinealRestringida(int min, int max){
    BufferedImage bi = ImageType.toBufferedImage(this.ioGrises.getImagenGrises());
    for(int x=0;x<bi.getWidth();x++){
      for(int y=0;y < bi.getHeight();y++){
          // obtenemos el color original
          Color color = new Color(bi.getRGB(x, y));
          int tonoOriginal = color.getRed();
          // implementamos la expansion para el tono original
          //int tonoNuevo = 255*((tonoOriginal-this.ioGrises.getnMin())/(this.ioGrises.getnMax()-this.ioGrises.getnMin()));
          int tonoNuevo = (255/(max-min))*(tonoOriginal-min);
          tonoNuevo = Iluminacion.verificaLimites(tonoNuevo);
          color = new Color(tonoNuevo, tonoNuevo, tonoNuevo);
           // modificamos el color del pixel con el tono nuevo
          bi.setRGB(x, y, color.getRGB());
      }
    }     
    return ImageType.toImage(bi);
    }  
    
    
    
    
}
