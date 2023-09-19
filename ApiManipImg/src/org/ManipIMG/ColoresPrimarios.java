
package org.ManipIMG;


import java.awt.image.BufferedImage;

import java.io.IOException;


/**
 * Clase del algoritmo ColoresPrimarios
 * @author Emiliano JO y Santiago
 *
 */
public class ColoresPrimarios extends ManipulacionImagenes{
	
	private int nuevoColor=0;

	/**
	 * 
	 * @param titulo Es el nombre del algoritmo, coloca al usar la clase.
	 * @throws IOException Excepcion de la imagen IO FILE
	 */
	public ColoresPrimarios(String titulo) throws IOException {
		super("ColoresPrimarios");
	}
	/**
	 * Recibe un entero para extraer el yellow de los 24 bits del número
     * @param pixel Contiene un valor RGB en un número entero.
     * @return Devuelve un double con el valor extraído del yellow.
	 */
	public double getMagenta(int pixel) {
		int green = (pixel >> 8) & 0xff;
		double magenta=255-green;
		return magenta;
	}
	/**
	 * Recibe un entero para extraer el yellow de los 24 bits del número
     * @param pixel Contiene un valor RGB en un número entero.
     * @return Devuelve un double con el valor extraído del yellow.
	 */
	public double getYellow(int pixel) {
		int blue = (pixel) & 0xff;
		double yellow=255-blue;
		return yellow;
	}
	/**
     * Recibe un entero para extraer el cyan de los 24 bits del número
     * @param pixel Contiene un valor RGB en un número entero.
     * @return Devuelve un double con el valor extraído del cyan.
     */
	public double getCyan(int pixel) {
		int red = (pixel >> 16) & 0xff;
		double cyan=255-red;
		return cyan;
	}
	
	/**
	 * 
	 * @param img Buffered Image, ya con la imagen que le quieras hacer el algoritmo de 8 colores básicos.
	 * @return Retorna la imagen ya con colores Primarios
	 */
	public BufferedImage aPrimarios(BufferedImage img) {
		
		super.width = img.getWidth();
		super.height = img.getHeight();
		//int width = img.getWidth();
		//int height = img.getHeight();
		
        nuevoColor=0;
      							
		for(int i=1;i<width;i+=2) {
			for(int j=1;j<height;j+=2) {
				
				int pixel = img.getRGB(i-1, j-1); 
	            int pixel1 = img.getRGB(i-1, j); 
	            int pixel2 = img.getRGB(i, j-1); 
	            int pixel3 = img.getRGB(i, j);	
	            
	            double redAvg=(getRed(pixel)+getRed(pixel1)+getRed(pixel2)+getRed(pixel3))/4;
	            double greenAvg=(getGreen(pixel)+getGreen(pixel1)+getGreen(pixel2)+getGreen(pixel3))/4;
	            double blueAvg=(getBlue(pixel)+getBlue(pixel1)+getBlue(pixel2)+getBlue(pixel3))/4;
	            
	           	
            	double promedio = (redAvg + greenAvg +blueAvg )/3;
            	double magenta =(getMagenta(pixel)+getMagenta(pixel1)+getMagenta(pixel2)+getMagenta(pixel3))/4;
            	double cyan = (getCyan(pixel)+getCyan(pixel1)+getCyan(pixel2)+getCyan(pixel3))/4;
            	double yellow = (getYellow(pixel)+getYellow(pixel1)+getYellow(pixel2)+getYellow(pixel3))/4;

            	if(promedio > 224) {
            		nuevoColor=16_777_215;
            	}

            	else if(promedio <31) {
            		nuevoColor=0;
            	}
            	
            	else if(redAvg>blueAvg&&redAvg>greenAvg&&redAvg>cyan&&redAvg>magenta&&redAvg>yellow){
            		nuevoColor=16_711_680;
            		}
            	else if(blueAvg>redAvg&&blueAvg>greenAvg&&blueAvg>cyan&&blueAvg>magenta&&blueAvg>yellow){
            		nuevoColor=255;
            		}
            	else if(greenAvg>blueAvg&&greenAvg>redAvg&&greenAvg>cyan&&greenAvg>magenta&&greenAvg>yellow){
            		nuevoColor=65_280;
            		}
            	else if(cyan>blueAvg&&cyan>greenAvg&&cyan>redAvg&&cyan>magenta&&cyan>yellow){
            		nuevoColor=65_535;
            		}
            	else if(yellow>blueAvg&&yellow>greenAvg&&yellow>cyan&&yellow>magenta&&yellow>redAvg){
            		nuevoColor=16_776_960;
            		}
            	else {
            		nuevoColor=16_711_935;
            	}
            	
	          
	            img.setRGB(i-1, j-1, nuevoColor);
            	img.setRGB(i-1, j, nuevoColor );
            	img.setRGB(i, j-1, nuevoColor );
            	img.setRGB(i, j, nuevoColor );
            	nuevoColor=0;
                
			
			}
		}
		
		
		
		return img;
	}
		
		
	

}
