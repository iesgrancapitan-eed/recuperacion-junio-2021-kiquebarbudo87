package com.eed.RA4.javadoc.excepciones;
/**
 * 
 * Se lanza si el n�mero de unidades introducido es 0 � negativo.
 * 
 * @author ebarbudo
 *
 */
public class UnidadNegativaException extends Exception {
	/**
	 * Si el n�mero de unidades introducido es 0 � negativo muestra un mensaje
	 */
	public UnidadNegativaException (String mensaje) {
	    super(mensaje);
	  }
}
