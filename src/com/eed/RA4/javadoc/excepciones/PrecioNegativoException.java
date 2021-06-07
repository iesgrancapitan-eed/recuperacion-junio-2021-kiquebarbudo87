package com.eed.RA4.javadoc.excepciones;
/**
 * 
 * Se lanza si el precio introducido es 0 ó negativo.
 * 
 * @author ebarbudo
 *
 */
public class PrecioNegativoException extends Exception {
	public PrecioNegativoException (String mensaje) {
	    super(mensaje);
	  }

}
