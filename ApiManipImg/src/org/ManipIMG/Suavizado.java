package org.ManipIMG;

import java.awt.Color;
import java.awt.image.BufferedImage;

import java.io.IOException;

/**
 * Clase del algoritmo suavizado de promedio o media.
 * @author Emiliano Jimenez y Santiago Cordova
 *
 */
public class Suavizado  extends ManipulacionImagenes{
	
	
   /**
    * 
    * @param titulo Nombre del Algoritmo
	 * @throws IOException excepcion de ImageIO
    */
    public Suavizado(String titulo) throws IOException {
		super("Suavizado");
		// TODO Auto-generated constructor stub
	}


	private int r,g,b;
    private int[][] redMatriz,greenMatriz,blueMatriz;
   
    private Color nuevoColor;
       
	/**
	 * Recibe una BufferedImage con la imagen precargada y hace un algoritmo de suavizado Media o Promedio.
	 * @param img Recibe una BufferedImage con la imagen a cambiar.
	 * @return Retorn Imagen tipo BufferedImage con un ligero suavizado.
	 */
	public BufferedImage Media(BufferedImage img) {
		
		
    	  
        super.width=img.getWidth();
        super.height=img.getHeight();
        
        BufferedImage img2=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
        
        redMatriz = new int[width][height];
        greenMatriz = new int[width][height];
        blueMatriz = new int[width][height];
         
         
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
            	nuevoColor=new Color(img.getRGB(i, j));
            	
                r =nuevoColor.getRed();
                g =nuevoColor.getGreen();
                b =nuevoColor.getBlue();
                
                redMatriz[i][j]=r;
                greenMatriz[i][j]=g;
                blueMatriz[i][j]=b;
                img2.setRGB(i, j, new Color(r,g,b).getRGB());
          
            }
        }		
		
		int red,green,blue;

	        for (int i = 1; i < width -1; i++) {
	            for (int j = 1; j < height -1; j++) {
	                red=0;
	                green=0;
	                blue=0;
	                for(int x=-1;x<2;x++){
	                    for(int y=-1;y<2;y++){
	                    	red=red+redMatriz[i+x][j+y];
	                    	green=green+greenMatriz[i+x][j+y];
	                    	blue=blue+blueMatriz[i+x][j+y];
	                    }
	                }
	                red /=9;
	                green /=9;
	                blue /=9;
	                Color colorMedia = new Color(red,green,blue);
	                int colorFinal = colorMedia.getRGB();
	                
	                img2.setRGB(i, j, colorFinal);
	            }
	        }
	       
	       return img2;
	    }


}
