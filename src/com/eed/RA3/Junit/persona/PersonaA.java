package com.eed.RA3.Junit.persona;

import com.eed.RA3.Junit.exceptions.EdadNoValidaException;

public class PersonaA {
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
}
