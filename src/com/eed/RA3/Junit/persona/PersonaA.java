package com.eed.RA3.Junit.persona;

import com.eed.RA3.Junit.exceptions.EdadNoValidaException;

public class PersonaA implements Comparable<PersonaA>{
	
	public final static int MAYOR_EDAD=1;
	public final static int IGUAL_EDAD=0;
	public final static int MENOR_EDAD=-1;
	
	
  private int edad;
  
  public PersonaA(int edad) throws EdadNoValidaException {
    setEdad(edad);
  }
  private void setEdad(int edad) throws EdadNoValidaException {
    if (edad < 0) throw new EdadNoValidaException();
    this.edad = edad;
  }
  public boolean isMayorDeEdad () {
    return edad >=18;
  }
  
  public int getEdad() {
	  return edad;
  }
@Override
public int compareTo(PersonaA a) {
	int estado=MENOR_EDAD;
	if (this.edad==getEdad()) {
		estado=IGUAL_EDAD;
	}else if(this.edad>=a.getEdad()) {
		estado=MAYOR_EDAD;
	}
	return estado;
}
  
  
}
