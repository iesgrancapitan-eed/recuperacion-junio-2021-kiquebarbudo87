package com.eed.RA4.javadoc.excepciones;
/**
 * 
 * Se lanza si el art�culo no existe.
 * 
 * @author ebarbudo
 *
 */
public class ArticuloNoExisteException extends Exception {
	 public ArticuloNoExisteException(String mensaje) {
		    super(mensaje);
		  }

}
