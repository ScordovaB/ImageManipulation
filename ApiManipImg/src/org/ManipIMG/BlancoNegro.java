package org.ManipIMG;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Clase del algoritmo BlancoyNegro
 * @author Emiliano JO y Santiago
 *
 */
public class BlancoNegro extends ManipulacionImagenes{
	
	/**
	 * 
	 * @param titulo Nombre del Algoritmo
	 * @throws IOException excepcion de ImageIO
	 */
	public BlancoNegro(String titulo) throws IOException {
		super("BlancoNegro");
		// TODO Auto-generated constructor stub
	}
	
	
	private int rgbFinal =0;
	
	/**
	 * Recibe una imagen y calcula el promedio de los componentes RGB de cada pixel, se le asigna blanco o negro al pixel dependiendo a que color se asemeje más el promedio.
	 * @param img La varible que guarda una copia de la imagen para poder trabajar con ella.
	 * @return Retorna la imagen ya con filtro de Blanco y Negro solamente.

	 */
	public BufferedImage aBlancoNegro(BufferedImage img) {
		
		
		super.width = img.getWidth();
		super.height = img.getHeight();
		//int width = img.getWidth();
		//int height = img.getHeight();
		
		rgbFinal =0;
		
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				int pixel = img.getRGB(i, j);
				
				
				//Para ir en otra funcion
				//int alpha = (pixel >> 24) & 0xff;
		        int red = (pixel >> 16) & 0xff;
		        int green = (pixel >> 8) & 0xff;
		        int blue = (pixel) & 0xff;
		        //System.out.println("Medias de RGB: red:"+ red + green);
		        
		        
		        if(red >=128 && green >=128) {
		        	red=255;
		        	green=255;
		        	blue=255;
		        }else if(red >=128 && blue >=128) {
		        	red=255;
		        	green=255;
		        	blue=255;
		        }else if(green >=128 && blue >=128) {
		        	red=255;
		        	green=255;
		        	blue=255;
		        }
		        else {
		        	red=0;
		        	green=0;
		        	blue=0;
		        }
		        
		        
		        Color c1 = new Color(red,green,blue);
		        rgbFinal = c1.getRGB(); 
		        //System.out.println("rgb del pixel DESPUES de "+rgbFinal);
		        
		        img.setRGB(i, j, rgbFinal);
		        
		        
		        
			}
		}
		
		
		
		return img;
	}
	
	
}
