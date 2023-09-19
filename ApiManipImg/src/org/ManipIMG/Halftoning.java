package org.ManipIMG;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase del algoritmo de Halftoning
 * @author Emiliano JO y Santiago
 *
 */
public class Halftoning extends ManipulacionImagenes{

	/**
	 * 
	 * @param titulo Nombre del Algoritmo
	 * @throws IOException excepcion de ImageIO
	 */
	public Halftoning(String titulo) throws IOException {
		super("Halftoning");
	}

	private static final int WHITE = -1;
	private static final int BLACK = 0;
	
	
	/**
     *  Recibe una imagen y extrae los componentes RGB de cuatro en cuatro pixeles con los 24 bits del número del RGB de cada pixel y con ellos calcular el promedio de cada color, después de transformalos a su tonalidad gris, para establecer el procentaje de presencia de cada tonalidad en la agrupación.
     * @param img La varible que guarda una copia de la imagen para poder trabajar con ella
     * @return Retorna la imagen ya con filtro de Halftoning

     */
	public BufferedImage toHalftoning(BufferedImage img) {
		
		super.width = img.getWidth();
		super.height = img.getHeight();
		//int width = img.getWidth();
		//int height = img.getHeight();
		
		for(int i=1;i<width;i+=2) {
			for(int j=1;j<height;j+=2) {
				
				int pixel = img.getRGB(i-1, j-1); 
	            int pixel1 = img.getRGB(i-1, j); 
	            int pixel2 = img.getRGB(i, j-1); 
	            int pixel3 = img.getRGB(i, j);	
	            
	            double gray = sacaGray(pixel);
	            double gray1 = sacaGray(pixel1);
	            double gray2 = sacaGray(pixel2);
	            double gray3 = sacaGray(pixel3);
	            
	            double grayAvg = (gray + gray1 +gray2 + gray3 )/4;
	            
	           	            
	            if(grayAvg > 223.125) { //>87.5%
	            	img.setRGB(i-1, j-1, WHITE );
	            	img.setRGB(i-1, j, WHITE );
	            	img.setRGB(i, j-1, WHITE );
	            	img.setRGB(i, j, WHITE );
	            	
	            }else if(grayAvg > 159.375) {//> 62.5%
	            	img.setRGB(i-1, j-1, WHITE );
	            	img.setRGB(i-1, j, WHITE );
	            	img.setRGB(i, j-1, WHITE );
	            	img.setRGB(i, j, BLACK );
	            }else if(grayAvg > 95.625) {//> 37.5%
	            	img.setRGB(i-1, j-1, WHITE );
	            	img.setRGB(i-1, j, BLACK );
	            	img.setRGB(i, j-1, WHITE );
	            	img.setRGB(i, j, BLACK );
	            }else if(grayAvg > 31.875) { // >12.5%
	            	img.setRGB(i-1, j-1, BLACK );
	            	img.setRGB(i-1, j, BLACK );
	            	img.setRGB(i, j-1, BLACK );
	            	img.setRGB(i, j, WHITE );
	            }else {
	            	img.setRGB(i-1, j-1, BLACK );
	            	img.setRGB(i-1, j, BLACK );
	            	img.setRGB(i, j-1, BLACK );
	            	img.setRGB(i, j, BLACK );
	            }
	            
				
			}
		}
		
		return img;
		
	}
	

}
