package practica3.ej7;

public interface InstrumentoMusical {
	
	void hacerSonar();
	
	void hacerSonar(Notas n,int duracion);
	
	String queEs();
	
	void afinar();
	
	void afinar(FrecuenciasDeLA f);
}
