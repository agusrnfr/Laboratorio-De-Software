package practica1.ej3;

import practica1.ej1.Vacuna;

public class VacunaSubunidadAntigenica extends Vacuna {
	private int cantidadAntigenos;
	private String tipoProceso;

	public VacunaSubunidadAntigenica(String marca, String paisDeOrigen, String enfermedadPreviene, int cantidadDosis,
			int cantidadAntigenos, String tipoProceso) {
		super(marca, paisDeOrigen, enfermedadPreviene, cantidadDosis);
		this.cantidadAntigenos = cantidadAntigenos;
		this.tipoProceso = tipoProceso;
	}

	public int getCantidadAntigenos() {
		return cantidadAntigenos;
	}

	public void setCantidadAntigenos(int cantidadAntigenos) {
		this.cantidadAntigenos = cantidadAntigenos;
	}

	public String getTipoProceso() {
		return tipoProceso;
	}

	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

}
