package com.eed.RA3.Junit.persona.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eed.RA3.Junit.exceptions.EdadNoValidaException;
import com.eed.RA3.Junit.persona.PersonaA;

class PersonaATest {
	
	private PersonaA Enrique;
	private PersonaA Ana;

	@BeforeAll
	  static void setUpBeforeClass() throws Exception {}

	  @AfterAll
	  static void tearDownAfterClass() throws Exception {}

	  @BeforeEach
	  void setUp() throws Exception {
		  Enrique = new PersonaA(33);
		  Ana = new PersonaA(17);
	  }

	  @AfterEach
	  void tearDown() throws Exception {}

	  @Test
	  /*
	   * Comprueba si es mayor o menor de edad.
	   */
	 final void testPersonaA() {
	    try {
	      //Mayores de edad
	      new PersonaA(18);
	      new PersonaA(100);
	      //Menores de edad
	      new PersonaA(0);
	      new PersonaA(17);
	    } catch (EdadNoValidaException e) {
	      fail("Aqui no debe llegar");
	    }
	    
	 
	  }
	  @Test
	  /*
	   * Comprueba que la edad de la persona sea positiva, y por tanto, real.
	   */
	  final void testPersonaInvalido() {
	    
	    assertThrows(EdadNoValidaException.class,()->{ 
	      new PersonaA(-1);
	    });
	    
	    assertThrows(EdadNoValidaException.class,()->{
	      new PersonaA(-100);
	    });
	    
	 
	  }
	  @Test
	  /*
	   * Comprueba los valores l�mite de la edad.
	   * 
	   */
	  final void testIsMayorDeEdad() {
	    PersonaA persona;
	    try {
	      persona = new PersonaA(18);
	      assertTrue(persona.isMayorDeEdad());
	      
	      persona = new PersonaA(100);
	      assertTrue(persona.isMayorDeEdad());
	      
	      persona = new PersonaA(0);
	      assertFalse(persona.isMayorDeEdad());
	      
	      persona = new PersonaA(17);
	      assertFalse(persona.isMayorDeEdad());
	      
	      
	      
	    } catch (EdadNoValidaException e) {
	      fail("Aqui no debe llegar");
	    }
	    
	    
	  }
	  @Test
	  void compareTo() {
		  assertEquals(PersonaA.IGUAL_EDAD,Enrique.compareTo(Ana));
		  assertEquals(PersonaA.IGUAL_EDAD,Ana.compareTo(Enrique));
		  
	  }

}
