package org.ManipIMG;

import java.awt.Color;
import java.awt.image.BufferedImage;

import java.io.IOException;


/**
 * Clase del algoritmo CMY.
 * @author Emiliano JO y Santiago
 *
 */
public class CMY extends ManipulacionImagenes{
	
	
	/**
	 * 
	 * @param titulo Nombre del Algoritmo
	 * @throws IOException excepcion de ImageIO
	 */
	public CMY(String titulo) throws IOException {
		super("CMY");
	}
	private int cyan = 0;
    private int magenta = 0;
    private int yellow = 0;
    
    /**
     * Recibe una imagen y calcula los valores CMY que le corresponden a cada pixel en base a los valores RGB de estos para convertir la imagen al modelo CMY.
     * @param img La varible que guarda una copia de la imagen para poder trabajar con ella
     * @return Retorna la imagen ya con filtro CMY
     */
	public BufferedImage toCMY(BufferedImage img) {
		super.width = img.getWidth();
		super.height = img.getHeight();
		
		//int width = img.getWidth();
		//int height = img.getHeight();
		
		//System.out.println("Medida de img, width: "+ width +"height: "+height);
		
		//Color c1 = new Color(0);
		int rgbFinal =0;
		
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				int pixel = img.getRGB(i, j);
				
				//System.out.println("rgb del pixel antes de CMY"+rgbFinal);
				
				//Para ir en otra funcion
				//int alpha = (pixel >> 24) & 0xff;
		        int red = (pixel >> 16) & 0xff;
		        int green = (pixel >> 8) & 0xff;
		        int blue = (pixel) & 0xff;
		        
		        
		        //System.out.println("Medias de RGB: red:"+ red + green);
		        //sacamos el CMY
		        cyan = 255 - red;
		        magenta = 255 - green;
		        yellow = 255 - blue;
		        
		        Color c1 = new Color(cyan,magenta,yellow);
		        //System.out.println("color C1:"+c1);
		        rgbFinal = c1.getRGB(); 
		        //System.out.println("rgb del pixel DESPUES de CMY"+rgbFinal);
		        
		        img.setRGB(i, j, rgbFinal);
		        
			}
		}
		
		
		return img;
	}
	

}
