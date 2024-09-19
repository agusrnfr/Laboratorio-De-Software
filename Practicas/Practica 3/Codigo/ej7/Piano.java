package practica3.ej7;

public class Piano implements InstrumentoMusical{

	@Override
	public void hacerSonar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hacerSonar(Notas n, int duracion) {
		System.out.println("Tocando nota " + n + " (" + n.getCifradoAmericano() + ") durante " + duracion + " segundos");
		
	}

	@Override
	public String queEs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afinar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afinar(FrecuenciasDeLA f) {
		System.out.println("Afinando en la frecuencia " + f.getFrecuencia() + " (" + f.getDescripcion() + ") de LA ");
		
	}

}
