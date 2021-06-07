package com.eed.RA3.Junit.persona;

import com.eed.RA3.Junit.exceptions.EdadNoValidaException;

public class PersonaA implements Comparable<PersonaA>{
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
@Override
public int compareTo(PersonaA o) {
	// TODO Auto-generated method stub
	return 0;
}
}
