package com.eed.RA4.refactorizacion;

	/**
	 * Se lanza si la edad es err?nea
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


