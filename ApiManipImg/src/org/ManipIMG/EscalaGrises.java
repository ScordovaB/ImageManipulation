/**
 * Paquete de Algoritmo
 */
package org.ManipIMG;
import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Clase del algoritmo de Escala de Grises
 * @author Emiliano JO y Santiago
 *
 */
public class EscalaGrises extends ManipulacionImagenes {
	
	/**
	 * 
	 * @param titulo Nombre del Algoritmo
	 * @throws IOException excepcion de ImageIO
	 */
	public EscalaGrises(String titulo) throws IOException {
		super("EscalaGrises");
	}
	
	private double gray1=0;
	
	/**
	 * Recibe una foto que quieras convertir a Escala de grises
	 * @param img Buffered Image, ya con la imagen LEIDA que le quieras aplicar el algoritmo.
	 * @return Retorna la imagen ya con filtro de Escala de Grises
	 */
	public BufferedImage convertGrayScale(BufferedImage img) {
		super.width = img.getWidth();
		super.height = img.getHeight();
		//int width = img.getWidth();
	    //int height = img.getHeight();
	   
	    int rgbFinal =0;
	    for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				int pixel = img.getRGB(i, j);
				
				
   				gray1 = sacaGray(pixel);
		        
		        Color c1 = new Color((int) gray1,(int) gray1,(int) gray1);

		        rgbFinal = c1.getRGB(); 
		        
		        img.setRGB(i, j, rgbFinal);
		        
			}
	    
	    }
	    
	    return img;
	}
	
	
	
	
	
	
	
	
	
	

	
}
