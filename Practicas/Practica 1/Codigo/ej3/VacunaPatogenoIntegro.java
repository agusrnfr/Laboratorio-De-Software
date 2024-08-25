package practica1.ej3;

import practica1.ej1.Vacuna;

public class VacunaPatogenoIntegro extends Vacuna {
	private String patogenoInactivo;

	public VacunaPatogenoIntegro(String marca, String paisDeOrigen, String enfermedadPreviene, int cantidadDosis,
			String patogenoInactivo) {
		super(marca, paisDeOrigen, enfermedadPreviene, cantidadDosis);
		this.patogenoInactivo = patogenoInactivo;
	}

	public String getPatogenoInactivo() {
		return patogenoInactivo;
	}

	public void setPatogenoInactivo(String patogenoInactivo) {
		this.patogenoInactivo = patogenoInactivo;
	}

}
