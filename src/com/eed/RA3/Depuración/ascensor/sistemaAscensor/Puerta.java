//Lo que contenga este archivo estarï¿½ en el paquete sistemaAscensor
package com.eed.RA3.Depuración.ascensor.sistemaAscensor;

/**
 * La clase Puerta simula el comportamiento de una puerta
 * 
 * @author Lourdes
 * @version 2.0
 */
class Puerta {
	@Override
	public String toString() {
		return "\nPuerta " + (abierta ? "abierta" : "cerrada");
	}

	/**
	 * Indica si la puerta estï¿½ abierta o cerrada
	 * */
	private boolean abierta = true;// Campo de la clase Puerta. Sï¿½lo accesible
									// dentro de esta clase

	/**
	 * Simula la apertura de la puerta. Modifica su estado a abierta
	 * 
	 * @return Mensaje de la puerta
	 */
	String abrir() {// friendly: sï¿½lo accesible dentro del paquete
		abierta = true;
		return "\nAbriendo puerta";
	}

	/**
	 * Simula el cierre de la puerta Modifica su estado a cerrada
	 * 
	 * @return Mensaje de la puerta
	 */
	String cerrar() {// friendly: sï¿½lo accesible dentro del paquete
		abierta = false;
		return "\nCerrando puerta";
	}

	/**
	 * Devuelve el estado de la puerta
	 * */
	boolean estaAbierta() {// friendly: sï¿½lo accesible dentro del paquete
		return abierta;
	}

}
