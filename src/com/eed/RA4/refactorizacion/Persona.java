package com.eed.RA4.refactorizacion;

public class Persona {

	private static final String SALUDA = "Hola, ¿que tal estás? Gracias por darme voz";

	public Persona() {
		super();
	}

	public int getEdad() {
		return this.getEdad();
	}

	public String decirHola() {
		return SALUDA;
	}

	public String decirAdios() {
		return "Nos vemos amig@!";
	}

}