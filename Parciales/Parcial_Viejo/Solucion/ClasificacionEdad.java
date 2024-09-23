package repaso.parcial.primero;

public enum ClasificacionEdad {
	ATP("Apto para todo publico", 0), MAS13("+13: Apta mayores de 13 años", 13),
	MAS16("+16: Apta mayores de 16 años", 16), MAS18("+18: Apta mayores de 18 años", 18);

	private final String descripcion;
	private final int edadMinima;

	ClasificacionEdad(String descripcion, int edadMinima) {
		this.descripcion = descripcion;
		this.edadMinima = edadMinima;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

}
