package com.eed.RA4.git.exUD4;
	/**
	 * Se lanza si la edad es errónea
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


