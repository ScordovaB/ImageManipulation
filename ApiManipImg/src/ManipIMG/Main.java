package ManipIMG;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.ManipIMG.BlancoNegro;
import org.ManipIMG.CMY;
import org.ManipIMG.ColoresPrimarios;
import org.ManipIMG.Dithering;
import org.ManipIMG.EscalaGrises;
import org.ManipIMG.Halftoning;
import org.ManipIMG.Histograma;
import org.ManipIMG.InterfazGrafica;
import org.ManipIMG.ManipulacionImagenes;
import org.ManipIMG.Suavizado;
/**
 * 
 * @author Emiliano JO y Santiago
 *
 */
public class Main {
	
	/**
	 * 
	 * @param args Metodo Main, aquí ingresas tu codigo final para correr los algoritmos. 
	 * @throws IOException Excepcion de ImageIO
	 */
	public static void main(String[] args) throws IOException {
		
				
		File file = new File("src/ManipIMG/benzemaFotoApi.jpg");
		BufferedImage img = ImageIO.read(file);
		BufferedImage img1 = ImageIO.read(file);
		BufferedImage img2 = ImageIO.read(file);
		BufferedImage img3 = ImageIO.read(file);
		BufferedImage img4 = ImageIO.read(file);
		BufferedImage img5 = ImageIO.read(file);
		BufferedImage img6 = ImageIO.read(file);
		
		
		
		//ManipulacionImagenes imagen = new ManipulacionImagenes("prueba");
		
		
		
		
		Histograma histograma1 = new Histograma("Histograma");
		histograma1.crearHistograma(img);
		
		
		
		Suavizado suavizado = new Suavizado("Suavizado");
		suavizado.Media(img);
		InterfazGrafica interfaz = new InterfazGrafica(img,"Suavizado: Filtro de Media");
		
		ImageIO.write(img, "JPG", file);
		
		CMY imagenCMY = new CMY("CMY");
		imagenCMY.toCMY(img1);
		InterfazGrafica interfaz2 = new InterfazGrafica(img1,"CMY");
		
		BlancoNegro BlancoNegro = new BlancoNegro("BlancoNegro");
		BlancoNegro.aBlancoNegro(img6);
		InterfazGrafica interfaz3 = new InterfazGrafica(img6,"BlancoNegro");
		
		EscalaGrises grayScale = new EscalaGrises("Escala de Grises");
		grayScale.convertGrayScale(img2);
		InterfazGrafica interfaz4 = new InterfazGrafica(img2,"Escala de Grises");

		Halftoning manip = new Halftoning("Halftoning");
		manip.toHalftoning(img3);
		InterfazGrafica interfaz5 = new InterfazGrafica(img3,manip.getAlgoritmo());
		
		Dithering manip1 = new Dithering("Dithering");
		manip1.toDithering(img4);
		InterfazGrafica interfaz6 = new InterfazGrafica(img4,manip1.getAlgoritmo());
		
		ColoresPrimarios manip2 = new ColoresPrimarios("ColoresPrimarios");
		manip2.aPrimarios(img5);
		InterfazGrafica interfaz7 = new InterfazGrafica(img5,manip2.getAlgoritmo());
					
		
		
		
			
		System.out.println("llego hasta write");
		
		
		
	}
}
