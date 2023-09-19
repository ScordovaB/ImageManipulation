package org.ManipIMG;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

	
	
/**
 * Clase que crea la ventana de InterfazGrafica.
 * @author Emiliano JO y Santiago
 *
 */
public class InterfazGrafica{
	private String title;
	private BufferedImage img;
	
	/**
	 * Recibe una imagen, la introduce a un frame y muestra el frame al usuario.
	 * @param img La varible que guarda una copia de la imagen para poder trabajar con ella
	 * @param title El nombre que deseas ponerle a la ventana 
	 */
	public InterfazGrafica(BufferedImage img, String title){
		
		this.img=img;
		this.title=title;
		
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add("Imagen modificada",new JLabel(new ImageIcon(this.img)));
		frame.setTitle(this.title);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	
}
