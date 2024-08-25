package practica1.ej3;

import practica1.ej1.Vacuna;

public class VacunaGenetica extends Vacuna {
	private int tempMinima;
	private int tempMaxima;

	public VacunaGenetica(String marca, String paisDeOrigen, String enfermedadPreviene, int cantidadDosis,
			int tempMinima, int tempMaxima) {
		super(marca, paisDeOrigen, enfermedadPreviene, cantidadDosis);
		this.tempMinima = tempMinima;
		this.tempMaxima = tempMaxima;
	}

	public int getTempMinima() {
		return tempMinima;
	}

	public void setTempMinima(int tempMinima) {
		this.tempMinima = tempMinima;
	}

	public int getTempMaxima() {
		return tempMaxima;
	}

	public void setTempMaxima(int tempMaxima) {
		this.tempMaxima = tempMaxima;
	}

}
