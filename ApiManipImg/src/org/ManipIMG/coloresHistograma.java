package org.ManipIMG;


/**
 * Enumeracion parar para clase de Histograma
 * @author Emiliano JO y Santiago
 *
 */
public enum coloresHistograma {
	/**
	 * Rojo y tendencia a Magenta.
	 */
	rM("RED & MAGENTA"),
	/**
	 * Rojo y tendencia sobre Amarillo.
	 */
	rY("RED & YELLOW"),
	/**
	 * Verde y tendencia a Cyan.
	 */
	gC("GREEN & CYAN"),
	
	/**
	 * Verde y tendencia sobre Amarillo.
	 */
	gY( "GREEN & YELLOW"),
	/**
	 * Azul y tendencia a Cyan.
	 */
	bC("BLUE & CYAN"),
	/**
	 * Color Azul y tendencia a Magenta.
	 */
	bM( "BLUE & MAGENTA"),
	/**
	 * Color Blanco.
	 */
	white ( "WHITE"),
	/**
	 * Color Negro.
	 */
	black ("BLACK");
	
	private String colores;
	
	/**
	 * Recibe el color que sea, lo introduce en el atributo de la clase
	 * @param colores
	 */
	private coloresHistograma(String colores) {
		this.colores=colores;
	}
	
	@Override
	public String toString() {
		return this.colores;
	}
}
