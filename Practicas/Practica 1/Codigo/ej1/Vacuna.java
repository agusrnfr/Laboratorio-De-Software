package practica1.ej1;

import java.util.Objects;

public class Vacuna {
	private String marca;
	private String paisDeOrigen;
	private String enfermedadPreviene;
	private int cantidadDosis;

	public Vacuna() {
	}

	public Vacuna(String marca, String paisDeOrigen, String enfermedadPreviene, int cantidadDosis) {
		this.marca = marca;
		this.paisDeOrigen = paisDeOrigen;
		this.enfermedadPreviene = enfermedadPreviene;
		this.cantidadDosis = cantidadDosis;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}

	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}

	public String getEnfermedadPreviene() {
		return enfermedadPreviene;
	}

	public void setEnfermedadPreviene(String enfermedadPreviene) {
		this.enfermedadPreviene = enfermedadPreviene;
	}

	public int getCantidadDosis() {
		return cantidadDosis;
	}

	public void setCantidadDosis(int cantidadDosis) {
		this.cantidadDosis = cantidadDosis;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("Vacuna \n");
		str.append("Marca: ");
		str.append(this.getMarca());
		str.append("\n");
		str.append("Pais de Origen: ");
		str.append(this.getPaisDeOrigen());
		str.append("\n");
		str.append("Enfermedad que Previene: ");
		str.append(this.getEnfermedadPreviene());
		str.append("\n");
		str.append("Cantidad de Dosis: ");
		str.append(this.getCantidadDosis());
		str.append("\n");
		return str.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Vacuna vacunaO = (Vacuna) o;
		return Objects.equals(this.getMarca(), vacunaO.getMarca())
				&& Objects.equals(this.getPaisDeOrigen(), vacunaO.getPaisDeOrigen())
				&& Objects.equals(this.getEnfermedadPreviene(), vacunaO.getEnfermedadPreviene())
				&& Objects.equals(this.getCantidadDosis(), vacunaO.getCantidadDosis());
	}

}
