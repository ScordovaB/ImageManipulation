package org.ManipIMG;

/**
 * Clase padre de los algoritmos de imagenes.
 * @author Emiliano JO y Santiago
 *
 */
public class ManipulacionImagenes {
	
	private String algoritmo;
	
	protected int width;
	protected int height;
	
	/**
	 * Constructor Static
	 */
	static {
		System.out.println("Creando nueva imagen...");
		
		
	}
	/**
	 * Simplemente guarda el contructor de la imagen
	 * @param titulo Nombre del algoritmo
	 */
	public ManipulacionImagenes(String titulo) {
		this.algoritmo = titulo; 
		
	}
	
	
	/**
	 * 
	 * @return El ancho de la imagen
	 */
	public int getWidth() {
		return width;
	}


	/**
	 * 
	 * @return El alto de la imagen
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * 
	 * @return El nombre o titulo del Algoritmo.
	 */
	public String getAlgoritmo() {
		return algoritmo;
	}



	@Override
	public String toString() {
		return "Algoritmo usado:" + algoritmo + ", Ancho de la imagen=" + width + ", Alto de la imagen=" + height ;
	}


	/**
     * Recibe un entero para extraer los componentes RGB de los 24 bits del número y con ellos calcular la tonalidad de gris que le corresponde.
     * @param pixel Contiene un valor RGB en un número entero.
     * @return Regresa un double que contiene la tonalidad gris calculada.
     */
	public double sacaGray(int pixel) {
		//int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        double gray1 = (( (red)* 0.299 ) + ( (green)* 0.587 )+( (blue)* 0.114 ) );

		
		return gray1;
	
	}
	/**
	 * Recibe un entero para extraer el rojo de los 24 bits del número
     * @param pixel Contiene un valor RGB en un número entero.
     * @return Devuelve un double con el valor extraído del rojo.
	 */
	public double getRed(int pixel) {
        int red = (pixel >> 16) & 0xff;
		return red;
	}
	/**
	 * Recibe un entero para extraer el azul de los 24 bits del número
     * @param pixel Contiene un valor RGB en un número entero.
     * @return Devuelve un double con el valor extraído del azul.
	 */
	public double getBlue(int pixel) {
		int blue = (pixel) & 0xff;
		return blue;
	}
	/**
     * Recibe un entero para extraer el verde de los 24 bits del número
     * @param pixel Contiene un valor RGB en un número entero.
     * @return Devuelve un double con el valor extraído del verde.
     */
	public double getGreen(int pixel) {
		int green = (pixel >> 8) & 0xff;
		return green;
	}
	
	@Override
	public ManipulacionImagenes clone() throws CloneNotSupportedException {
		return new ManipulacionImagenes(this.algoritmo);
	}
	

}
