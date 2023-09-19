package org.ManipIMG;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase del creador del Histograma.
 * @author Emiliano JO y Santiago
 *
 */
public class Histograma extends ManipulacionImagenes{
	
		/**
		 * 
		 * @param titulo Nombre del Algoritmo
		 * @throws IOException excepcion de ImageIO
		 */
		public Histograma(String titulo) throws IOException {
			super("Histograma");
		}
		
		private Color colorImagen;
		/**
		 * Recibe una imagen y evalua cada PIXEL, para ver si esta más orientado a ser Blanco, Negro, Verde en Conjunto con Cyan y Amarillo, Rojo en Conjunto con Magenta y Amarillo o Azul en Conjunto con Cyan y Magenta.
		 * @param img Buffered Image, ya con la imagen que le quieras sacar su Histograma.
		 */
		public void crearHistograma(BufferedImage img){
		
		super.width = img.getWidth();
		super.height = img.getHeight();
		
		
        
        //int width = img.getWidth();
		//int height = img.getHeight();
		
		
		int wCont = 0;
    	int bCont = 0;
    	int rMcont = 0;
    	int rYcont = 0;
    	int gCcont = 0;
    	int gYcont = 0;
    	int bCcont = 0;
    	int bMcont = 0;
		
        
        for( int i = 0; i < width; i++ ){
            for( int j = 0; j < height; j++ ){
            	
            	System.out.println();
            	System.out.println("Pixel: X:"+i+"Y:"+j);
            	//color de pixel
            	colorImagen=new Color(img.getRGB(i, j));
            	int red = colorImagen.getRed();
            	int green = colorImagen.getGreen();
            	int blue = colorImagen.getBlue();
            	int promedio = (red + green +blue )/3;
            	int magenta = (red + blue)/2; 
            	int cyan = (green + blue)/2;
            	int yellow = (red + green)/2;
            	
            	
            	
            	if(promedio > 224) {
            		System.out.println("Este color es más "+coloresHistograma.white);
            		wCont+=1;
            	}

            	else if(promedio <31) {
            		System.out.println("Este color es más "+coloresHistograma.black);
            		bCont+=1;
            	}
            	
            	else {
            		if(red > green && red >blue) {
            			if(magenta>= yellow) {
            				System.out.println("Este color es más "+coloresHistograma.rM);
            				rMcont+=1;
            			}
            			else {
            				System.out.println("Este color es más "+coloresHistograma.rY);
            				rYcont+=1;
            			}
            		}
            		if(green > red && green >blue) {
            			if(cyan>= yellow) {
            				System.out.println("Este color es más "+coloresHistograma.gC);
            				gCcont+=1;
            			}
            			else {
            				System.out.println("Este color es más "+coloresHistograma.gY);
            				gYcont+=1;
            			}
            		}
            		if(blue > red && blue >green) {
            			if(cyan>= magenta) {
            				System.out.println("Este color es más "+coloresHistograma.bC);
            				bCcont+=1;
            			}
            			else {
            				System.out.println("Este color es más "+coloresHistograma.bM);
            				bMcont+=1;
            			}
            		}
            	}
            	
            	
                
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        
        System.out.println("Se encontró en " + wCont+" pixeles el "+coloresHistograma.white );
    	System.out.println("Se encontró en " + bCont+" pixeles el "+coloresHistograma.black );
    	System.out.println("Se encontró en " + rMcont+" pixeles el "+coloresHistograma.rM );
    	System.out.println("Se encontró en " + rYcont+" pixeles el "+coloresHistograma.rY );
    	System.out.println("Se encontró en " + gCcont+" pixeles el "+coloresHistograma.gC );
    	System.out.println("Se encontró en " + gYcont+" pixeles el "+coloresHistograma.gY );
    	System.out.println("Se encontró en " + bCcont+" pixeles el "+coloresHistograma.bC );
    	System.out.println("Se encontró en " + bMcont+" pixeles el "+coloresHistograma.bM );
    	System.out.println();
    	
    	//double[] grafW = {wCont,bCont,rMcont,rYcont,gCcont,gCcont,gYcont,bCcont,bMcont};
    	
    	
        
        
    }
	
		
}
