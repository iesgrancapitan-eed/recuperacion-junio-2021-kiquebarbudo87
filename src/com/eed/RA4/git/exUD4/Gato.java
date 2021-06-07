package com.eed.RA4.git.exUD4;




/**
 * Clase que hereda de Mamífero
 * 
 * @author ebarbudo
 *
 */
public class Gato extends Mamifero  {
	private static final String MIAUUUUUUUUUUUUU = "Miauuuuuuuuuuuuu";
	private int edad;
	private String nombre;
	
	/**
	 * Constructor de la clase Gato
	 * 
	 * @param nombre
	 * 		Nombre del gato
	 * @param edad
	 * 		Edad del gato
	 * @throws EdadErroneaException
	 * 		Se lanza si la edad es 0 ó menor.
	 */


	public Gato(String nombre, int edad) throws EdadErroneaException {
		setAge(edad);
		this.nombre = nombre;
	}

	public void setAge(int edad) throws EdadErroneaException {
		if (edad < 0)
			throw new EdadErroneaException("La edad no puede ser negativa");
		this.edad = edad;
	}

	public int getEdad() {
		return this.edad;
	}

	
	 /**
	   * Hace que el gato maulle.
	   * @return MIAUUUUUUUUUU
	   */
	  public String maullar() {
	    return MIAUUUUUUUUUUUUU;
	  }

	public String getNombre() {
		return nombre;
	}


}




