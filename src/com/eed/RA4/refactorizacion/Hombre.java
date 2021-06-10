package com.eed.RA4.refactorizacion;

public class Hombre {
	public static final String SALUDA = "Hola, ¿que tal estás? Gracias por darme voz";
	private int edad;
	private String nombre;
	
	
	
	public Hombre(String nombre, int edad) throws EdadErroneaException {
		setAge(edad);
		this.nombre = nombre;
	}


	public void setAge(int edad) throws EdadErroneaException {
		if (edad < 0)
			throw new EdadErroneaException("La edad que has introducido no es correcta");
		this.edad = edad;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public String decirHola() {
		return SALUDA;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String decirAdios() {
		return "Nos vemos amig@!";
	}

}
