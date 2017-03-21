/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MUESTREO;

/**
 *
 * @author Roberto Cruz Leija
 */
public class UmbralAutomatico {
    public double[] histograma;

    public UmbralAutomatico(double[] histograma) {
        this.histograma = histograma;
    }
    
    public int metodoIterativo(){
        int ui = calcularUmbralInicial();
        int ua = 0;
        do{
         ua = ui;
         ui = reAjustaUmbral(ui);
        }while(ua!=ui);
        
    return 0;
    }

    private int reAjustaUmbral(int ui) {
        int u1, u2;
        int a1=0,a2=0,n1=0,n2=0;
        // recorrel el espacion de R1
        for (int x=0; x<ui;x++){
          a1+=this.histograma[x]*x;
          n1+=this.histograma[x];
        }
        for (int y=ui; y<255;y++){
          a2+=this.histograma[y]*y;
          n2+=this.histograma[y];
        }
        u1 = a1/n1;
        u2 = a2/n2;
        return (int)((u1+u2)/2);
    }

    private int calcularUmbralInicial() {
        int numPixels = 0;
        int sumatoria = 0;
        for (int x=0; x < this.histograma.length;x++){
            numPixels+=this.histograma[x];
            sumatoria+=this.histograma[x]*x;
        }
        return (int)(sumatoria/numPixels);
        
        
    }
    
    
}
