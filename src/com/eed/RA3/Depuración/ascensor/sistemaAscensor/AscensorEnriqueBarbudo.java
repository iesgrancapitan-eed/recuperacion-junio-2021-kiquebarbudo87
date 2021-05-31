package com.eed.RA3.Depuración.ascensor.sistemaAscensor;

import com.eed.RA3.Depuración.ascensor.utiles.Teclado;

/**
 * La clase Ascensor simula el comportamiento de un ascensor
 * 
 * @author Lourdes Magarín Corvillo
 * @version 2.0
 */
public class AscensorEnriqueBarbudo {

	/**
	 * Planta en la que se encuentra el ascensor
	 */
	private int plantaActual = 1;
	/**
	 * Total de plantas del ascensor
	 * 
	 */
	private int numPlantas = 2;
	/**
	 * Puerta del ascensor
	 */
	private Puerta puerta;

	/**
	 * Construye un nuevo objeto Ascensor con el número de plantas que tendrá el
	 * ascensor
	 * 
	 * @param numPlantas total de plantas del ascensor
	 * @throws NumeroDePlantasInvalidasException Cuando el número de plantas es
	 *                                           menor que dos
	 */
	public AscensorEnriqueBarbudo(int numPlantas) throws NumeroDePlantasInvalidasException {
		setNumPlantas(numPlantas);
		puerta = new Puerta();
	}

	/**
	 * Crea un ascensor de dos plantas
	 */
	public AscensorEnriqueBarbudo() {
		try {
			setNumPlantas(2);
		} catch (NumeroDePlantasInvalidasException e) {
			e.printStackTrace();
		}
		setPuerta(new Puerta());
	}

	private void setPuerta(Puerta puerta) {
		this.puerta = puerta;
	}

	/**
	 * Simula la bajada de una planta. Cada vez que el ascensor baja, decrementa el
	 * campo plantaActual (privado a la clase) y muestra un mensaje indicándolo.
	 */
	private String bajar() {
		plantaActual--;
		return "\nBajando. Planta " + getPlantaActual() + ".";
	}

	/**
	 * Simula la bajada hasta su destino.
	 * 
	 * @param plantaDestino
	 */
	private String bajar(int plantaDestino) {
		String mensaje = "";
		int numVeces = (plantaActual - plantaDestino);
		for (int i = 0; i < numVeces; i++)
			mensaje += bajar();
		return mensaje;
	}

	/**
	 * 
	 * Muestra mensaje indicando el destino conseguido
	 * 
	 * @return Mensaje del Ascensor
	 * 
	 */
	private String destinoConseguido() {
		String mensaje = "";
		mensaje = puerta.abrir();
		mensaje += "Estás en la planta " + getPlantaActual() + ". Destino conseguido";
		mensaje = puerta.cerrar();
		return mensaje;
	}

	/**
	 * Devuelve si el destino es correcto o no
	 * 
	 * @param destino planta destino
	 * @return verdadero si el destino es correcto
	 * 
	 */
	public boolean destinoCorrecto(int destino) {
		if ((destino < 1) || (destino > numPlantas))
			return false;
		return true;

	}

	@Override
	public String toString() {
		return "\nEstás en la planta " + getPlantaActual() + ".";
	}

	/**
	 * Devuelve el valor de la planta actual donde se encuentra el ascensor
	 * 
	 * @return la planta actual
	 */
	public int getPlantaActual() {
		return plantaActual;
	}

	/**
	 * @param numPlantas el numero de plantas a asignar
	 * @throws NumeroDePlantasInvalidasException Cuando el número de plantas es
	 *                                           menor que dos
	 */
	private void setNumPlantas(int numPlantas) throws NumeroDePlantasInvalidasException {
		if (numPlantas < 2)
			throw new NumeroDePlantasInvalidasException("El número de plantas ha de ser mayor o igual que dos");
		this.numPlantas = numPlantas;
	}

	/**
	 * Simula la subida de una única planta. Cada vez que el ascensor sube,
	 * incrementa el campo plantaActual y muestra un mensaje indicándolo.
	 * 
	 * @return Mensaje del nuevo estado
	 */
	private String subir() {
		plantaActual++;
		return "\nSubiendo. Planta " + getPlantaActual() + ".";
	}

	/**
	 * Simula la subida hasta su destino.
	 * 
	 * @param plantaDestino
	 * @return Mensaje del Ascensor
	 */
	private String subir(int plantaDestino) {
		String mensaje = "";
		for (int i = plantaActual; i < plantaDestino; i++)
			// desde plantaActual a plantaDestino
			mensaje += subir();
		return mensaje;
	}

	/**
	 * Simula cuando un usuario le da a un botón indicando el número de planta a la
	 * que va
	 * 
	 * @param destinoPlanta planta a la que quiere ir el usuario
	 * 
	 * @return Mensaje del nuevo estado
	 * @throws DestinoIncorrectoException Cuando el destino es incorrecto
	 */
	public String viajar(int destinoPlanta) throws DestinoIncorrectoException {
		if (!(destinoCorrecto(destinoPlanta)))
			throw new DestinoIncorrectoException("Destino incorrecto");
		String mensaje = puerta.abrir();
		mensaje += puerta.cerrar();

		if (destinoPlanta > plantaActual)
			mensaje += subir(destinoPlanta);
		else
			mensaje += bajar(destinoPlanta);

		mensaje += destinoConseguido();
		return mensaje;
	}

	/**
	 * Crea un ascensor válido, trabajando por consola
	 * 
	 * @return Ascensor nuevo
	 */
	public static AscensorEnriqueBarbudo crearAscensor() {
		do {
			try {
				return new AscensorEnriqueBarbudo(Teclado.leerEntero("Elige la altura del edificio (plantas en total): "));
			} catch (NumeroDePlantasInvalidasException e) {
				System.out.println(e.getMessage());
			}
		} while (true);

	}

}
