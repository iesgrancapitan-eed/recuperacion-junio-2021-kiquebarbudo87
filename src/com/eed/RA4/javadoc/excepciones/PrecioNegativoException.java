package com.eed.RA4.javadoc.excepciones;
/**
 * 
 * Se lanza si el precio introducido es 0 � negativo.
 * 
 * @author ebarbudo
 *
 */
public class PrecioNegativoException extends Exception {
	/**
	 * Si el precio introducido es 0 � negativo muestra un mensaje
	 */
	public PrecioNegativoException (String mensaje) {
	    super(mensaje);
	  }

}
