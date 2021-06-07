package com.eed.RA3.Junit.persona.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eed.RA3.Junit.exceptions.EdadNoValidaException;
import com.eed.RA3.Junit.persona.Persona;

class PersonaTest {
	
	private Persona enrique;
	private Persona ana;

	@BeforeAll
	  static void setUpBeforeClass() throws Exception {}

	  @AfterAll
	  static void tearDownAfterClass() throws Exception {}

	  @BeforeEach
	  void setUp() throws Exception {
		  enrique = new Persona(33);
		  ana = new Persona(17);
	  }

	  @AfterEach
	  void tearDown() throws Exception {}

	  @Test
	  /*
	   * Comprueba si es mayor o menor de edad.
	   */
	 final void testPersona() {
	    try {
	      //Mayores de edad
	      new Persona(18);
	      new Persona(100);
	      //Menores de edad
	      new Persona(0);
	      new Persona(17);
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
	      new Persona(-1);
	    });
	    
	    assertThrows(EdadNoValidaException.class,()->{
	      new Persona(-100);
	    });
	    
	 
	  }
	  @Test
	  /*
	   * Comprueba los valores límite de la edad.
	   * 
	   */
	  final void testIsMayorDeEdad() {
	    Persona persona;
	    try {
	      persona = new Persona(18);
	      assertTrue(persona.isMayorDeEdad());
	      
	      persona = new Persona(100);
	      assertTrue(persona.isMayorDeEdad());
	      
	      persona = new Persona(0);
	      assertFalse(persona.isMayorDeEdad());
	      
	      persona = new Persona(17);
	      assertFalse(persona.isMayorDeEdad());
	      
	      
	      
	    } catch (EdadNoValidaException e) {
	      fail("Aqui no debe llegar");
	    }
	    
	    
	  }
	  @Test
	  void compareTo() {
		  assertEquals(Persona.IGUAL_EDAD,enrique.compareTo(ana));
		  assertEquals(Persona.IGUAL_EDAD,ana.compareTo(enrique));
		  	Assertions.assertThrows(NullPointerException.class,()->{
		  		enrique.compareTo(null);
		  	});
		  	Assertions.assertThrows(ClassCastException.class,()->{
		  		enrique.compareTo((Persona) new Object());
		  	});

	  }

}
