package com.eed.RA4.javadoc.excepciones;
/**
 * 
 * Se lanza si el n�mero de unidades introducido es 0 � negativo.
 * 
 * @author ebarbudo
 *
 */
public class UnidadNegativaException extends Exception {
	public UnidadNegativaException (String mensaje) {
	    super(mensaje);
	  }
}
