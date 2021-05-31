package com.eed.RA3.Depuraci�n.ascensor.testAscensor;

import com.eed.RA3.Depuraci�n.ascensor.sistemaAscensor.AscensorEnriqueBarbudo;
import com.eed.RA3.Depuraci�n.ascensor.sistemaAscensor.DestinoIncorrectoException;
import com.eed.RA3.Depuraci�n.ascensor.utiles.Teclado;

/**
 * @author Lourdes Magarín
 * 
 */
public class TestAscensor {
	public static void main(String args[]) {
		int destino = 0;
		char c;

		AscensorEnriqueBarbudo ascensor = AscensorEnriqueBarbudo.crearAscensor();
		do {
			do {

				try {
					destino = Teclado.leerEntero(ascensor + "\nElige un destino: ");

					System.out.println(ascensor.viajar(destino));
				} catch (DestinoIncorrectoException e) {
					System.out.println(e.getMessage());
				}
			} while (!ascensor.destinoCorrecto(destino));

			c = Teclado.leerCaracter("Quieres dejar el ascensor ya? ");
		} while ((c == 'n') || (c == 'N'));
	}
}
