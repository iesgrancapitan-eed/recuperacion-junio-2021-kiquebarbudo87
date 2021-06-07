package com.eed.RA4.javadoc.excepciones;
/**
 * 
 * Se lanza si el número de unidades introducido es 0 ó negativo.
 * 
 * @author ebarbudo
 *
 */
public class UnidadNegativaException extends Exception {
	public UnidadNegativaException (String mensaje) {
	    super(mensaje);
	  }
}
