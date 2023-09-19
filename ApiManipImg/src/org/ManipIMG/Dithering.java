package org.ManipIMG;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase del algoritmo Dithering.
 * @author Emiliano JO y Santiago
 *
 */
public class Dithering extends ManipulacionImagenes{
	
	/**
	 * 
	 * @param titulo Nombre del Algoritmo
	 * @throws IOException excepcion de ImageIO
	 */
	public Dithering(String titulo) throws IOException {
		super("Dithering");
	}
	
	private int nuevoColor=0;
	private int nuevoColor1=0;
	private int nuevoColor2=0;
	private int nuevoColor3=0;
	
	/**
	 *  Recibe una imagen y extrae los componentes RGB de cuatro en cuatro pixeles con los 24 bits del número del RGB de cada pixel y con ellos calcular el promedio de cada color para establecer el procentaje de presencia de cada color en la agrupación.
	 * @param img La varible que guarda una copia de la imagen para poder trabajar con ella
	 * @return Retorna la imagen ya con filtro de Dithering

	 */
	public BufferedImage toDithering(BufferedImage img) {
		
		super.width = img.getWidth();
		super.height = img.getHeight();
		//int width = img.getWidth();
		//int height = img.getHeight();
		
        nuevoColor=0;
        nuevoColor1=0;
        nuevoColor2=0;
        nuevoColor3=0;
        
		for(int i=1;i<width;i+=2) {
			for(int j=1;j<height;j+=2) {
				
				int pixel = img.getRGB(i-1, j-1); 
	            int pixel1 = img.getRGB(i-1, j); 
	            int pixel2 = img.getRGB(i, j-1); 
	            int pixel3 = img.getRGB(i, j);	
	            
	            double redAvg=(getRed(pixel)+getRed(pixel1)+getRed(pixel2)+getRed(pixel3))/4;
	            double greenAvg=(getGreen(pixel)+getGreen(pixel1)+getGreen(pixel2)+getGreen(pixel3))/4;
	            double blueAvg=(getBlue(pixel)+getBlue(pixel1)+getBlue(pixel2)+getBlue(pixel3))/4;
	           	            
	            if(redAvg> 223.125) { //>87.5%
	                nuevoColor=16_711_680;
	                nuevoColor1=16_711_680;
	                nuevoColor2=16_711_680;
	                nuevoColor3=16_711_680;
	            }else if(redAvg > 159.375) {//> 62.5%
	            	nuevoColor=16_711_680;
	                nuevoColor2=16_711_680;
	                nuevoColor3=16_711_680;
	            }else if(redAvg > 95.625) {//> 37.5%
	            	nuevoColor=16_711_680;
	                nuevoColor2=16_711_680;
	            }else if(redAvg > 31.875) { // >12.5%
	                nuevoColor=16_711_680;
	            }
	            
	            if(greenAvg> 223.125) { //>87.5%
	            	nuevoColor+=65_280;
	                nuevoColor1+=65_280;
	                nuevoColor2+=65_280;
	                nuevoColor3+=65_280;
	            }else if(greenAvg > 159.375) {//> 62.5%
	            	nuevoColor+=65_280;
	                nuevoColor2+=65_280;
	                nuevoColor3+=65_280;
	            }else if(greenAvg > 95.625) {//> 37.5%
	            	nuevoColor+=65_280;
	                nuevoColor2+=65_280;
	            }else if(greenAvg > 31.875) { // >12.5%
	            	nuevoColor+=65_280;
	            }
	            
	            if(blueAvg> 223.125) { //>87.5%
	            	nuevoColor+=255;
	                nuevoColor1+=255;
	                nuevoColor2+=255;
	                nuevoColor3+=255;
	            }else if(blueAvg > 159.375) {//> 62.5%
	            	nuevoColor+=255;
	                nuevoColor2+=255;
	                nuevoColor3+=255;
	            }else if(blueAvg > 95.625) {//> 37.5%
	            	nuevoColor+=255;
	                nuevoColor2+=255;
	            }else if(blueAvg > 31.875) { // >12.5%
	            	nuevoColor+=255;
	            }
	          
	            img.setRGB(i-1, j-1, nuevoColor);
            	img.setRGB(i-1, j, nuevoColor1 );
            	img.setRGB(i, j-1, nuevoColor2 );
            	img.setRGB(i, j, nuevoColor3 );
            	nuevoColor=0;
                nuevoColor1=0;
                nuevoColor2=0;
                nuevoColor3=0;
			}
		}
		return img;
	}
	

}