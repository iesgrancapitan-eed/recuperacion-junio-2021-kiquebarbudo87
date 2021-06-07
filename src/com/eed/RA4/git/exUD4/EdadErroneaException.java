package com.eed.RA4.git.exUD4;

/**
 * 
 * @author ebarbudo 
 *
 */
public class EdadErroneaException extends Exception {
/**
 *  Si la edad es menor de 0.
 * @param string
 */
	public EdadErroneaException(String string) {
		super(string);
	}

}
