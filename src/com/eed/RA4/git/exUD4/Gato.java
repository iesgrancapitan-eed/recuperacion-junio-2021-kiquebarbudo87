package com.eed.RA4.git.exUD4;

public class Gato  {
	private int edad;
	private String nombre;

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
	
	public String maullar() {
		return "Miauuuuuuuuuuuuu";
	}

	public String getNombre() {
		return nombre;
	}

}