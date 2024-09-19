package practica3.ej7;

public enum FrecuenciasDeLA {
	_440HZ("440 HZ","Organización Internacional de Estandarización ISO 16"),_444HZ("444 HZ","Afinación de cámara"),_446HZ("446 HZ","Renacimiento"),_480HZ("480 HZ","Órganos alemanes que tocaba Bach");
	
	private final String frecuencia;
	private final String descripcion;
	
	FrecuenciasDeLA(String frecuencia, String descripcion){
		this.frecuencia = frecuencia;
		this.descripcion = descripcion;
	}
	
	public String getFrecuencia() {
		return this.frecuencia;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

}
